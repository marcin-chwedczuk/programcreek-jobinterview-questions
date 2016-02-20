package org.mc.tests;

import org.mc.utils.CountBst;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CountBstTests {
    @Test
    public void count_bst_works() {
        Assert.assertEquals(CountBst.withElements(0), 1);
        Assert.assertEquals(CountBst.withElements(1), 1);
        Assert.assertEquals(CountBst.withElements(2), 2);
        Assert.assertEquals(CountBst.withElements(3), 5);
    }
}
