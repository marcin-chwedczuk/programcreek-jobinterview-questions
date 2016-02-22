package org.mc.tests;

import org.mc.utils.MaxGap;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;

public class MaximumGapTests {
    @Test(dataProvider = "maxGap")
    public void maximum_gap_works(int[] values, int maxgap) {
        int actualMaxgap = MaxGap.getFor(values);

        Assert.assertEquals(actualMaxgap, maxgap, "failed for: " + Arrays.toString(values));
    }

    @DataProvider(name = "maxGap")
    public Object[][] maxGapProvider() {
        return new Object[][] {
                { new int[] { 1 }, 0 },
                { new int[] { 1, 3 }, 2 },
                { new int[] { 3, 1 }, 2 },
                { new int[] { 1, 6, 7, 2, 8, 3, 9, 4, 5 }, 1 },
                { new int[] { 101, 1, 102, 2 }, 99 },
                { new int[] { 1, 10, 2, 17, 3, 33 }, 16 }
        };
    }
}
