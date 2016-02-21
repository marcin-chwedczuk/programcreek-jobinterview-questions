package org.mc.tests;

import org.mc.dataStructures.ListNode;
import org.mc.utils.MergeSortList;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;

public class MergeSortListTest {
    @Test(dataProvider = "mergeSortList")
    public void merge_sort_works(int[] values) {
        ListNode listToSort = ListNode.create(values);
        ListNode sortedList = new MergeSortList().sort(listToSort);

        int[] sortedValues = values.clone();
        Arrays.sort(sortedValues);

        Assert.assertEquals(
                ListNode.listToString(sortedList),
                ListNode.listToString(ListNode.create(sortedValues)));
    }

    @DataProvider(name = "mergeSortList")
    public Object[][] mergeSortListProvider() {
        return new Object[][] {
                { new int[] { } },
                { new int[] { 1 } },
                { new int[] { 7, 3 } },
                { new int[] { 1, 2, 3, 4, 5, 6 } },
                { new int[] { 5, 4, 3, 2, 1, 0 } },
                { new int[] { 1, 2, 3, 2, 1, 2, 3, 4 } },
                { new int[] { 3, 2, 1, 6, 32, 1, 2, 32, 4, 7, 43 } }
        };
    }
}
