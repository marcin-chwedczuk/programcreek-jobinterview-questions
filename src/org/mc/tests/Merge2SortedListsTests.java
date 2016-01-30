package org.mc.tests;

import org.mc.dataStructures.ListNode;
import org.mc.utils.Merge2SortedLists;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.w3c.dom.NodeList;

import java.util.Arrays;

public class Merge2SortedListsTests {

    @Test(dataProvider = "merge2lists")
    public void merge2sorted_lists_works(int[] leftList, int[] rightList, int[] expectedResult) {
        ListNode actualMerged = new Merge2SortedLists().merge(
                ListNode.create(leftList),
                ListNode.create(rightList)
        );

        ListNode expectedMerged = ListNode.create(expectedResult);

        Assert.assertEquals(
                ListNode.listToString(actualMerged),
                ListNode.listToString(expectedMerged),
                String.format("failed for left: %s and right: %s", Arrays.toString(leftList), Arrays.toString(rightList))
        );
    }

    @DataProvider(name = "merge2lists")
    public Object[][] merge2listsDataProvider() {
        return new Object[][] {
                // both empty
                {
                        new int[] { },
                        new int[] { },
                        new int[] { }
                },

                // left empty
                {
                        new int[] { },
                        new int[] { 1, 2, 3 },
                        new int[] { 1, 2, 3 }
                },

                // right empty
                {
                        new int[] { 1, 2, 3, },
                        new int[] { },
                        new int[] { 1, 2, 3 }
                },

                // same length
                {
                        new int[] { 1, 2, 3 },
                        new int[] { 1, 4, 5 },
                        new int[] { 1, 1, 2, 3, 4, 5 }
                },

                // different length
                {
                        new int[] { 1, 2, 3, 4, 5 },
                        new int[] { 4, 7 },
                        new int[] { 1, 2, 3, 4, 4, 5, 7 }
                },

                // value cases
                {
                        new int[] { 100, 101 },
                        new int[] { 1, 2, 3 },
                        new int[] { 1, 2, 3, 100, 101 },
                },

                {
                        new int[] { 1, 2, 3, },
                        new int[] { 101, 102 },
                        new int[] { 1, 2, 3, 101, 102 },
                }
        };
    }
}
