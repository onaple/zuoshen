package me.ele.zuo.chapter3;

import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;
import org.hamcrest.core.IsEqual;

import java.awt.datatransfer.StringSelection;
import java.net.HttpRetryException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.SortedMap;
import java.util.Stack;

/**
 * Created by onaple on 2017/2/26.
 */
public class TreeCommon {


    /*
    树的遍历； 递归实现
     */
    public static void preOrderRecur(Node head){
        if (null == head){
            return;
        }
        System.out.println(head.value + " ");
        preOrderRecur(head.left);
        preOrderRecur(head.right);
    }

    public static void inOrderRecur(Node head){
        if (null == head) {
            return;
        }
        inOrderRecur(head.left);
        System.out.println(head.value + " ");
        inOrderRecur(head.right);
    }

    public static void posOrderRecur(Node head){
        if (null == head) {
            return;
        }
        posOrderRecur(head.left);
        posOrderRecur(head.right);
        System.out.println(head.value + " ");
    }


    /*
    树的遍历非递归的实现；
     */

    public static void preOrderUNRecur(Node head){
        System.out.println(" pre-order:");
        if(head != null){
            Stack<Node> stack = new Stack<Node>();
            stack.add(head);
            while (!stack.empty()) {
                head = stack.pop();
                System.out.println(head.value + " ");
                if (null != head.right){
                    stack.push(head.right);
                }
                if (null != head.left){
                    stack.push(head.left);
                }
            }
        }
        System.out.println();
    }


   public static void inOrderUnRecur(Node head){
       System.out.println("in-order");
       if (head != null){
           Stack<Node> stack = new Stack<Node>();
           while (!stack.isEmpty() || head != null){
               if (head != null){
                   stack.push(head);
                   head = head.left;
               } else {
                   head = stack.pop();
                   System.out.println(head.value + " ");
                   head = head.right;
               }
           }
       }
       System.out.println();
   }


   public static void posOrderUnRecur1(Node head){
       System.out.println("pos-order");
       if(head != null){
           Stack<Node> s1 = new Stack<Node>();
           Stack<Node> s2 = new Stack<Node>();

           s1.push(head);
           while (!s1.isEmpty()){
               head = s1.pop();
               s2.push(head);
               if (head.left != null) {
                   s1.push(head.left);
               }
               if (head.right != null){
                   s1.push(head.right);
               }
           }

           while(!s2.isEmpty()){
               System.out.println(s2.pop().value + " ");
           }
       }
       System.out.println();
   }

   public void posOrderUnRecur2(Node head){
       System.out.println("pos-order:");
       if (head != null){
           Stack<Node> stack = new Stack<Node>();
           stack.push(head);
           Node c = null;
           while (!stack.isEmpty()){
               c = stack.peek();
               if(c.left != null && head != c.left && head != c.right){
                   stack.push(c.left);
               } else if (c.right != null && head != c.right){
                   stack.push(c.right);
               } else {
                   System.out.println(stack.pop().value + " ");
                   head = c;
               }
           }
       }
       System.out.println();
   }


//   二叉树的序列化和反序列化

    //先序；
    public static String serialByPre (Node head){
        if (null == head) {
            return "#!";
        }
        String res = head.value + "!";
        res += serialByPre(head.left);
        res += serialByPre(head.right);
        return res;
    }

    public static Node reconByPreString(String preStr){
        String [] values = preStr.split("!");
        Queue<String> queue = new LinkedList<String>();
        for (int i = 0 ; i!= values.length; ++i){
            queue.offer(values[i]);
        }
        return reconPreOrder(queue);
    }

    private static Node reconPreOrder(Queue<String> queue) {
        String  value = queue.poll();
        if (value.equals("#")) {
            return null;
        }
        Node head = new Node(Integer.valueOf(value));
        head.left = reconPreOrder(queue);
        head.right = reconPreOrder(queue);
        return head;
    }
}
