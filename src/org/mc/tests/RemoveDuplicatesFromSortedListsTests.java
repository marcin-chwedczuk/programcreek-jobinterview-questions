package org.mc.tests;

import org.mc.dataStructures.ListNode;
import org.mc.utils.RemoveDuplicatesFromSortedLists;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RemoveDuplicatesFromSortedListsTests {
    @Test(dataProvider = "removeDuplicatesSortedList")
    public void remove_duplicates_from_sorted_list_works(int[] list, int[] listNoDuplicates) {
        ListNode result = new RemoveDuplicatesFromSortedLists().solve(
                ListNode.create(list));

        Assert.assertEquals(
                ListNode.listToString(result),
                ListNode.listToString(ListNode.create(listNoDuplicates)));
    }

    @DataProvider(name = "removeDuplicatesSortedList")
    public Object[][] removeDuplicatesSortedListProvider() {
        return new Object[][] {
                {
                        // empty list
                        new int[] { },
                        new int[] { }
                },

                {
                        // list no duplicates
                        new int[] { 1, 2, 3, 4 },
                        new int[] { 1, 2, 3, 4 }
                },

                {
                        // list many elements single value
                        new int[] { 1, 1, 1, 1 },
                        new int[] { 1 }
                },

                {
                        // random list #1
                        new int[] { 1, 1, 3, 4, 4, 4, 6, 6, 7, 9, 9 },
                        new int[] { 1, 3, 4, 6, 7, 9 }
                },

                {
                        // random list #2
                        new int[] { 1, 1, 2, 3, 3 },
                        new int[] { 1, 2, 3 }
                }
        };
    }
}
