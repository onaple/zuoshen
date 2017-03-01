package me.ele.zuo.chapter1;

import me.ele.zuo.chapter1.MyStack2;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by onaple on 2017/2/4.
 */
public class MyStack2Test {
    @Test
    public void push() throws Exception {
        MyStack2 stack2 = new MyStack2();
        stack2.push(123);
    }

    @Test
    public void pop() throws Exception {
        MyStack2 myStack2 = new MyStack2();
        myStack2.push(1213);
        assertEquals(1213, myStack2.pop());
    }

    @Test
    public void getmin() throws Exception {
        MyStack2 myStack2 = new MyStack2();
        myStack2.push(1213);
        myStack2.push(12345);
        assertEquals(1213, myStack2.getmin());

    }

}