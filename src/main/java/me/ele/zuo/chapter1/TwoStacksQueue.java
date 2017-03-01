package me.ele.zuo.chapter1;

import java.util.Stack;

/**
 * Created by onaple on 2017/2/4.
 */
public class TwoStacksQueue {
    private Stack<Integer> stackPush;
    private Stack<Integer> stackPop;

    public TwoStacksQueue(){
        stackPush = new Stack<Integer>();
        stackPop = new Stack<Integer>();
    }

    public void add(int pushInt){
        stackPush.push(pushInt);
    }

    public int poll(){
        if(stackPop.empty() && stackPush.empty()){
            throw new RuntimeException("Queue is empty.");
        }else if(stackPop.empty()){
            while (!stackPush.empty()){
                stackPop.push(stackPush.pop());
            }
        }
        return stackPop.pop();
    }

    public int peek(){
        if (stackPop.empty() && stackPush.empty()){
            throw new RuntimeException("Queue is empty.");
        }else if(stackPop.empty()){
            while (!stackPush.empty()){
                stackPop.push(stackPush.pop());
            }
        }
        return stackPop.peek();
    }


}
