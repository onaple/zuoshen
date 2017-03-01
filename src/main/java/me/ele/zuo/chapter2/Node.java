package me.ele.zuo.chapter2;


/**
 * Created by onaple on 2017/2/7.
 */
public class Node {
    public int value;
    public Node next;
    public Node(int data){
        this.value = data;
    }

    public void display(){
        System.out.println( value + " ");
    }

}
