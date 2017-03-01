package me.ele.zuo.chapter1;

import me.ele.zuo.chapter1.TwoStacksQueue;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by onaple on 2017/2/4.
 */
public class TwoStacksQueueTest {
    @Test
    public void add() throws Exception {
        TwoStacksQueue twoStacksQueue = new TwoStacksQueue();
        twoStacksQueue.add(1);
        twoStacksQueue.add(12);
        twoStacksQueue.add(13);
        twoStacksQueue.add(14);
        twoStacksQueue.add(15);

    }

    @Test
    public void poll() throws Exception {
        TwoStacksQueue twoStacksQueue = new TwoStacksQueue();
        twoStacksQueue.add(1);
        twoStacksQueue.add(12);
        twoStacksQueue.add(13);
        twoStacksQueue.add(14);
        twoStacksQueue.add(15);
        assertEquals(1,twoStacksQueue.poll());
    }

    @Test
    public void peek() throws Exception {
        TwoStacksQueue twoStacksQueue = new TwoStacksQueue();
        twoStacksQueue.add(1);
        twoStacksQueue.add(12);
        twoStacksQueue.add(13);
        twoStacksQueue.add(14);
        twoStacksQueue.add(15);
        assertEquals(1,twoStacksQueue.peek());
    }

}