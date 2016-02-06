package org.mc.tests;

import org.mc.dataStructures.ListNode;
import org.mc.utils.ReverseList;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;

public class ReverseListTests {
    @Test(dataProvider = "reverseList")
    public void reverse_list_works(int[] list, int[] reversedList) {
        ListNode actual = new ReverseList().reverse(ListNode.create(list));

        Assert.assertEquals(
                ListNode.listToString(actual),
                ListNode.listToString(ListNode.create(reversedList)),
                "failed for list: " + Arrays.toString(list));
    }

    @DataProvider(name = "reverseList")
    public Object[][] reverseListProvider() {
        return new Object[][] {
                {
                        // empty list
                        new int[] { },
                        new int[] { }
                },

                {
                        // single element list
                        new int[] { 1 },
                        new int[] { 1 }
                },

                {
                        // two element list
                        new int[] { 1, 2 },
                        new int[] { 2, 1 }
                },

                {
                        // odd number of elements
                        new int[] { 1, 2, 3, 4, 5 },
                        new int[] { 5, 4, 3, 2, 1 }
                },

                {
                        // even number of elements
                        new int[] { 1, 2, 3, 4, 5, 6 },
                        new int[] { 6, 5, 4, 3, 2, 1 }
                }
        };
    }
}
