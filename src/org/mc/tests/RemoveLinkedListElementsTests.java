package org.mc.tests;

import org.mc.dataStructures.ListNode;
import org.mc.utils.RemoveLinkedListElements;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;

public class RemoveLinkedListElementsTests {
    @Test(dataProvider = "removeLinkedListElements")
    public void remove_linked_list_elements_works(int[] values, int elementToRemove, int[] expectedResult) {
        ListNode list = ListNode.create(values);

        ListNode actualResult =
                new RemoveLinkedListElements().remove(list, elementToRemove);

        Assert.assertEquals(
                ListNode.listToString(actualResult),
                ListNode.listToString(ListNode.create(expectedResult)),
                "failed for values: " + Arrays.toString(values) + " and element: " + elementToRemove);
    }

    @DataProvider(name = "removeLinkedListElements")
    public Object[][] removeLinkedListElementsProvider() {
        return new Object[][] {
                {
                        // remove all elements
                        new int[] { 1, 1, 1, 1, 1 },
                        1,
                        new int[] { }
                },

                {
                        // remove at beginning
                        new int[] { 1, 1, 2, 3, 4 },
                        1,
                        new int[] { 2, 3, 4 }
                },

                {
                        // remove at end
                        new int[] { 1, 2, 3, 4, 4 },
                        4,
                        new int[] { 1, 2, 3 }
                },

                {
                        // remove at center
                        new int[] { 1, 2, 3, 3, 3, 4 },
                        3,
                        new int[] { 1, 2, 4 }
                },

                {
                        // intertwined
                        new int[] { 1, 2, 1, 3, 1, 4, 1 },
                        1,
                        new int[] { 2, 3, 4 }
                },

                {
                        // no elements to remove
                        new int[] { 1, 2, 3 },
                        101,
                        new int[] { 1, 2, 3 }
                }
        };
    }
}
