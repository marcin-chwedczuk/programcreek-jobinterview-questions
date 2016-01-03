package org.mc.tests;

import org.mc.utils.MinStack;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MinStackTests {
    @Test
    public void min_stack_works() {
        final MinStack stack = new MinStack();

        stack.push(1);
        Assert.assertEquals(stack.getMin(), 1);

        stack.push(2);
        Assert.assertEquals(stack.getMin(), 1);

        stack.push(-3);
        Assert.assertEquals(stack.getMin(), -3);

        stack.push(-2);
        Assert.assertEquals(stack.getMin(), -3);

        Assert.assertEquals(stack.pop(), -2);
        Assert.assertEquals(stack.getMin(), -3);

        Assert.assertEquals(stack.pop(), -3);
        Assert.assertEquals(stack.getMin(), 1);

        Assert.assertEquals(stack.pop(), 2);
        Assert.assertEquals(stack.getMin(), 1);
    }
}
