package org.mc.tests;

import org.mc.utils.IntPriorityQueue;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ImplementingPriorityQueueTests {
    @Test
    public void priority_queue_works() {
        IntPriorityQueue queue = new IntPriorityQueue();

        Assert.assertEquals(queue.elementsCount(), 0);

        queue.insert(3);
        Assert.assertEquals(queue.peek(), 3);
        Assert.assertEquals(queue.peek(), 3);
        Assert.assertEquals(queue.deleteMin(), 3);

        queue.insert(1);
        queue.insert(2);
        queue.insert(3);
        Assert.assertEquals(queue.elementsCount(), 3);
        Assert.assertEquals(queue.deleteMin(), 1);
        Assert.assertEquals(queue.deleteMin(), 2);
        Assert.assertEquals(queue.deleteMin(), 3);

        queue.insert(3); queue.insert(1); queue.insert(2); queue.insert(0);
        Assert.assertEquals(queue.elementsCount(), 4);
        Assert.assertEquals(queue.deleteMin(), 0);
        Assert.assertEquals(queue.deleteMin(), 1);
        Assert.assertEquals(queue.deleteMin(), 2);
        Assert.assertEquals(queue.deleteMin(), 3);
        Assert.assertEquals(queue.elementsCount(), 0);
    }
}
