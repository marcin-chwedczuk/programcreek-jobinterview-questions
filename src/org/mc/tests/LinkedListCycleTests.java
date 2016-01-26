package org.mc.tests;

import org.mc.dataStructures.ListNode;
import org.mc.utils.LinkedListCycle;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.ObjectFactory;
import org.testng.annotations.Test;

import java.util.Arrays;

public class LinkedListCycleTests {
    @Test(dataProvider = "linkedListCycle")
    public void linked_list_cycle_works(int[] indexPointerList, boolean hasCycle) {
        ListNode head = ListNode.fromIndexPointers(indexPointerList);
        boolean actualHasCycle = new LinkedListCycle().solve(head);

        Assert.assertEquals(
                actualHasCycle,
                hasCycle,
                "failed for list: " + Arrays.toString(indexPointerList));
    }

    @DataProvider(name = "linkedListCycle")
    public Object[][] linkedListCycleProvider() {
        return new Object[][] {
                { new int[] { }, false },
                { new int[] { -1 }, false },
                { new int[] { 1, 2, 3, -1 }, false },

                // odd cycles
                { new int[] { 1, 2, 3, 4, 0 }, true },
                { new int[] { 1, 2, 3, 4, 5, 6, 4 }, true },

                // even cycles
                { new int[] { 1, 2, 3, 4, 5, 0 }, true },
                { new int[] { 1, 2, 3, 4, 5, 6, 7, 4 }, true }
        };
    }
}
