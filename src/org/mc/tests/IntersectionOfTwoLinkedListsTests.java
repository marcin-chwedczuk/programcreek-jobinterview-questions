package org.mc.tests;

import org.mc.dataStructures.ListNode;
import org.mc.utils.IntersectionOfTwoLinkedLists;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;

public class IntersectionOfTwoLinkedListsTests {
    @Test(dataProvider = "intersectionOfTwoLists")
    public void intersection_of_two_linked_lists_works(int[] aValues, int[] bValues, int[] commonValues) {
        ListNode a = ListNode.create(aValues);
        ListNode b = ListNode.create(bValues);
        ListNode c = ListNode.create(commonValues);

        a = (a != null) ? a.setTail(c) : c;
        b = (b != null) ? b.setTail(c) : c;

        ListNode intersection =
                new IntersectionOfTwoLinkedLists().findIntersection(a, b);

        Assert.assertEquals(intersection, c,
                "failed for a: " + Arrays.toString(aValues) +
                " and b: " + Arrays.toString(bValues));
    }

    @DataProvider(name = "intersectionOfTwoLists")
    public Object[][] intersectionOfTwoListsProvider() {
        return new Object[][] {
                {
                        // common value is last
                        new int[] { 1, 2, 3 },
                        new int[] { 3, 2, 2, 7, 9 },
                        new int[] { 1 }
                },

                {
                        // common value is first
                        new int[] { },
                        new int[] { },
                        new int[] { 1, 2, 3, }
                },

                {
                        // common value first in one list
                        new int[] { },
                        new int[] { 1, 2, 3 },
                        new int[] { 101, 102, 103 }
                },

                {
                        // random case
                        new int[] { 34, 2, 1, 54 },
                        new int[] { 1, 2, 3 },
                        new int[] { 20, 32 }
                }
        };
    }
}
