package org.mc.tests;

import org.mc.dataStructures.ListNode;
import org.mc.utils.ReorderList;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;

public class ReorderListTests {
    @Test(dataProvider = "reorderList")
    public void reorder_list_works(int[] listValues, int[] expectedListValues) {
        ListNode list = ListNode.create(listValues);
        ListNode expectedList = ListNode.create(expectedListValues);

        ListNode actualList = new ReorderList().solve(list);

        Assert.assertEquals(
                ListNode.listToString(actualList),
                ListNode.listToString(expectedList),
                "Failed for list: " + Arrays.toString(listValues));
    }

    @DataProvider(name = "reorderList")
    public Object[][] reorderListProvider() {
        return new Object[][] {
                {
                        new int[] { },
                        new int[] { }
                },

                {
                        new int[] { 1 },
                        new int[] { 1 }
                },

                {
                        new int[] { 1, 2 },
                        new int[] { 1, 2 }
                },

                {
                        new int[] { 1, 2, 3, 4, 5 },
                        new int[] { 1, 5, 2, 4, 3 }
                },

                {
                        new int[] { 1, 2, 3, 4, 5, 6 },
                        new int[] { 1, 6, 2, 5, 3, 4 }
                }
        };
    }
}
