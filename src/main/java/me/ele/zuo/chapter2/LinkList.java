package me.ele.zuo.chapter2;


import com.sun.javafx.sg.prism.web.NGWebView;

/**
 * Created by onaple on 2017/2/7.
 */
public class LinkList {

    public Node first = null;
    private int pos = 0;

    public LinkList(){
        this.first = null;
        this.pos = 0;
    }
    //头插法
    public void addFirstNode(int data){
        Node node = new Node(data);
        node.next = first;
        first = node;
    }

    //删除一个头结点，并返回头结点。
    public Node deleteFirstNode(){
        Node temp = first;
        first = temp.next;
        return temp;
    }

    //在index位置插入结点
    public void add(int index, int data){
        Node node = new Node(data);
        Node cureent = first;
        Node previous = first;
        while (pos != index){
            previous = cureent;
            cureent = cureent.next;
            pos++;
        }

        node.next = cureent;
        previous.next = node;
        pos = 0;
    }


    //删除任意结点的位置
    public Node deleteByPos(int index){
        Node current = first;
        Node previous = first;
        while (pos != index){
            pos ++;
            previous = current;
            current = current.next;
        }

        if(current == first){
            first = first.next;
        }else {
            pos = 0;
            previous.next = current.next;
        }
        return current;
    }

    //删除第一个data结点
    public Node deleteByData(int data){
        Node current = first;
        Node previous = first;
        while (current.value != data)
        {
            if (current.next == null){
                return null;
            }
            previous = current;
            current = current.next;
        }

        if(current == first){
            first = first.next;
        }else {
            previous.next = current.next;
        }
        return current;
    }

    // 显示出所有的节点信息
    public void displayAllNodes() {
        Node current = first;
        while (current != null) {
            current.display();
            current = current.next;
        }
        System.out.println();
    }

    // 根据位置查找节点信息
    public Node findByPos(int index) {
        Node current = first;
        if (pos != index) {
            current = current.next;
            pos++;
        }
        return current;
    }

    // 根据数据查找节点信息
    public Node findByData(int data) {
        Node current = first;
        while (current.value != data) {
            if (current.next == null)
                return null;
            current = current.next;
        }
        return current;
    }

    public void printCommonPart(Node head1, Node head2){
        System.out.println("Common Part:");
        while (head1 != null && head2 != null){
            if (head1.value < head2.value){
                head1 = head1.next;
            } else if(head1.value > head1.value){
                head2 = head2.next;
            } else {
                System.out.println(" "+ head1.value);
                head1 = head1.next;
                head2 = head2.next;
            }
        }
        System.out.println();
    }

}
