package org.mc.tests;

import org.mc.dataStructures.ListNode;
import org.mc.utils.ListInsertionSort;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;

public class ListInsertionSortTests {
    @Test(dataProvider = "insertionSortLinkedList")
    public void list_insertion_sort_works(int[] values) {
        ListNode sortedList = ListInsertionSort.perform(ListNode.create(values));

        int[] sortedValues = values.clone();
        Arrays.sort(sortedValues);

        Assert.assertEquals(
                ListNode.listToString(sortedList),
                ListNode.listToString(ListNode.create(sortedValues)));
    }

    @DataProvider(name = "insertionSortLinkedList")
    public Object[][] insertionSortLinkedListProvider() {
        return new Object[][] {
                {
                        // empty
                        new int[] { }
                },

                {
                        // single value
                        new int[] { 1 }
                },

                {
                        // ascending order
                        new int[] { 1, 2, 3, 4, 5, 6, 7 }
                },

                {
                        // descending order
                        new int[] { 10, 9, 8, 7, 6, 5, 4, 3 }
                },

                {
                        // random
                        new int[] { 1, 3, 1, 12, 8, 32, 1, 2, 43, 73, 9, 2, 30, 10, 3, 27 }
                },

                {
                        // same value
                        new int[] { 1, 1, 1, 1, 1 }
                },

                {
                        // 2 value mix
                        new int[] { 0, 0, 1, 1, 0, 1, 1, 1, 0, 1, 0, 0 }
                }
        };
    }
}
