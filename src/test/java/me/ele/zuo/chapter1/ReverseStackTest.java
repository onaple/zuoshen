package me.ele.zuo.chapter1;

import me.ele.zuo.chapter1.ReverseStack;
import org.junit.Test;

import java.util.Stack;

import static org.junit.Assert.*;

/**
 * Created by onaple on 2017/2/4.
 */
public class ReverseStackTest {
    @Test
    public void reverse() throws Exception {
        Stack stack = new Stack<Integer>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        ReverseStack.reverse(stack);
        assertEquals(1,stack.pop());
        assertEquals(2, stack.pop());
        assertEquals(3, stack.pop());

    }

}