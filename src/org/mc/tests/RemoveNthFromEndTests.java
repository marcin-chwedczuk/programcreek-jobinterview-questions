package org.mc.tests;

import org.mc.dataStructures.ListNode;
import org.mc.utils.RemoveNthFromEnd;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;

public class RemoveNthFromEndTests {
    @Test(dataProvider = "removeNthFromEnd")
    public void remove_nth_from_end(int[] list, int nth, int[] expectedResult) {
        // list is 0 based (nth == 0 <-> remove list tail)

        ListNode result = new RemoveNthFromEnd().remove(ListNode.create(list), nth);

        Assert.assertEquals(
                ListNode.listToString(ListNode.create(expectedResult)),
                ListNode.listToString(result),
                "failed for list: " + Arrays.toString(list));
    }

    @DataProvider(name = "removeNthFromEnd")
    public Object[][] removeNthFromEndProvider() {
        return new Object[][] {
                {
                        // remove element from single element list
                        new int[] { 1 },
                        0,
                        new int[] { }
                },

                {
                        // remove head
                        new int[] { 1, 2, 3 },
                        2,
                        new int[] { 2, 3 }
                },

                {
                        // remove tail
                        new int[] { 1, 2, 3 },
                        0,
                        new int[] { 1, 2 }
                },

                {
                        // remove inner element
                        new int[] { 1, 2, 3, 4, 5, 6 },
                        3,
                        new int[] { 1, 2, 4, 5, 6 }
                }
        };
    }
}
