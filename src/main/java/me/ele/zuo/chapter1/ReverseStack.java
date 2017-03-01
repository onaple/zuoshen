package me.ele.zuo.chapter1;

import java.util.Stack;

/**
 * Created by onaple on 2017/2/4.
 */
public class ReverseStack {
    public static int getAndRemoveLastElement(Stack<Integer> stack){
        int result = stack.pop();
        if(stack.isEmpty()){
            return result;
        }else{
            int last = getAndRemoveLastElement(stack);
            stack.push(result);
            return last;
        }
    }

    public static void reverse(Stack<Integer> stack){
        if(stack.isEmpty()){
            return;
        }
        int i = getAndRemoveLastElement(stack);
        reverse(stack);
        stack.push(i);
    }
}
