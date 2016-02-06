package org.mc.tests;

import org.mc.dataStructures.ListNode;
import org.mc.utils.SwapNodesInPairs;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;

public class SwapNodesInPairsTests {

    @Test(dataProvider = "swapNodesInPairs")
    public void swap_nodes_in_pairs_works(int[] list, int[] expectedResult) {
        ListNode actualResult = new SwapNodesInPairs().swap(ListNode.create(list));

        Assert.assertEquals(
                ListNode.listToString(actualResult),
                ListNode.listToString(ListNode.create(expectedResult)),
                "failed for list: " + Arrays.toString(list));
    }

    @DataProvider(name = "swapNodesInPairs")
    public Object[][] swapNodesInPairsProvider() {
        return new Object[][] {
                {
                        // empty list
                        new int[] { },
                        new int[] { }
                },

                {
                        // one element in list
                        new int[] { 1 },
                        new int[] { 1 }
                },

                {
                        // two elements in list
                        new int[] { 1, 2 },
                        new int[] { 2, 1 }
                },

                {
                        // odd number of elements
                        new int[] { 1, 2, 3, 4, 5 },
                        new int[] { 2, 1, 4, 3, 5 }
                },

                {
                        // even number of elements
                        new int[] { 1, 2, 3, 4, 5, 6 },
                        new int[] { 2, 1, 4, 3, 6, 5 }
                }
        };
    }
}
