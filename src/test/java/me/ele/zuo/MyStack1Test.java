package me.ele.zuo;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by onaple on 2017/2/4.
 */
public class MyStack1Test {


    @Test
    public void getMin() throws Exception {
        MyStack1 myStack1 = new MyStack1();
        myStack1.push(123);
        myStack1.push(12113213);
        myStack1.push(1234);
        assertEquals(123,myStack1.getMin());

    }

}