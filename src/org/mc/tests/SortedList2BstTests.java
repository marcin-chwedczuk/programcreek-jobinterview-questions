package org.mc.tests;

import org.mc.dataStructures.ListNode;
import org.mc.dataStructures.TreeNode;
import org.mc.utils.SortedList2Bst;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SortedList2BstTests {
    @Test(dataProvider = "sortedList2Bst")
    public void sorted_list_to_bst_works(int[] listValues, String expectedTree) {
        TreeNode tree = new SortedList2Bst().reconstruct(ListNode.create(listValues));

        Assert.assertEquals(
                TreeNode.treeToString(tree),
                expectedTree);
    }

    @DataProvider(name = "sortedList2Bst")
    public Object[][] sortedList2BstProvider() {
        return new Object[][] {
                {
                        new int[] { 1 },
                        "(1 nil nil)"
                },

                {
                        new int[] { 1, 2, 3 },
                        "(2 (1 nil nil) (3 nil nil))"
                },

                {
                        new int[] { 1, 2, 3, 4, 5, 6, 7 },
                        "(4 (2 (1 nil nil) (3 nil nil)) (6 (5 nil nil) (7 nil nil)))"
                },

                {
                        new int[] { 1, 2 },
                        "(2 (1 nil nil) nil)"
                },

                {
                        new int[] { 1, 2, 3, 4, 5 },
                        "(3 (2 (1 nil nil) nil) (5 (4 nil nil) nil))"
                }
        };
    }
}
