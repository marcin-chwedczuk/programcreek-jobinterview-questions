package org.mc.tests;

import org.mc.dataStructures.ListNode;
import org.mc.utils.CopyListWithRandomPointer;
import org.mc.utils.PartitionList;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class PartitionListTests {
    @Test(dataProvider = "partitionList")
    public void partition_list_works(int[] list, int element, int[] partedList) {
        ListNode result = new PartitionList().partition(element, ListNode.create(list));

        Assert.assertEquals(
                ListNode.listToString(result),
                ListNode.listToString(ListNode.create(partedList))
        );
    }

    @DataProvider(name = "partitionList")
    public Object[][] partitionListProvider() {
        return new Object[][] {
                {
                        // empty list
                        new int[] { },
                        3,
                        new int[] { }
                },

                {
                        // all elements in lower partition
                        new int[] { 1, 2, 3 },
                        100,
                        new int[] { 1, 2, 3 }
                },

                {
                        // all elements in upper partition
                        new int[] { 1, 2, 3 },
                        0,
                        new int[] { 1, 2, 3 }
                },

                {
                        // random elements
                        new int[] { 10, 3, 2, 7, 32, 21, 11, 47 },
                        13,
                        new int[] { 10, 3, 2, 7, 11, 32, 21, 47 }
                },

                {
                        // random elements (partition element is element of the list)
                        new int[] { 1, 5, 3, 4, 2, 4, 5, 2, 2, 5 },
                        4,
                        new int[] { 1, 3, 2, 2, 2, 5, 4, 4, 5, 5 }
                }
        };
    }
}
