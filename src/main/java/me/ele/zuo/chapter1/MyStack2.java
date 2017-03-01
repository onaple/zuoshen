package me.ele.zuo.chapter1;

import java.util.Stack;

/**
 * Created by onaple on 2017/2/4.
 */
public class MyStack2 {
    private Stack<Integer> stackData;
    private Stack<Integer> stackMin;

    public MyStack2(){
        this.stackData = new Stack<Integer>();
        this.stackMin = new Stack<Integer>();
    }

    public void push(int newNUm){
        if(this.stackMin.isEmpty()){
            this.stackMin.push(newNUm);
        }else if(newNUm < this.stackMin.peek())
        {
            this.stackMin.push(newNUm);
        }else{
            int peek = this.stackMin.peek();
            this.stackMin.push(peek);
        }

        this.stackData.push(newNUm);
    }

    public int pop(){
        if(this.stackData.isEmpty()){
            throw new RuntimeException("Your stack is empty.");
        }
        this.stackMin.pop();
        return this.stackData.pop();
    }

    public int getmin(){
        if(this.stackMin.isEmpty()){
            throw new RuntimeException("Your stack is empty.");
        }
        return this.stackMin.peek();
    }
}
