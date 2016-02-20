package org.mc.tests;

import org.mc.utils.ArrayMerger;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;

public class MergeKArraysTests {
    @Test
    public void merge_k_arrays_works() {
        int[] a = { 1, 2, 7, 9 };
        int[] b = { 3, 3, 4 };
        int[] c = { 2, 11, 33, 34 };

        int[] merged = { 1, 2, 2, 3, 3, 4, 7, 9, 11, 33, 34 };

        int[] acutal = new ArrayMerger().merge(a, b, c);

        Assert.assertEquals(
                Arrays.toString(acutal),
                Arrays.toString(merged));
    }
}
