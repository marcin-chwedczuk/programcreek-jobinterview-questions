package org.mc.tests;

import org.mc.dataStructures.TreeNode;
import org.mc.utils.SortedArray2Bst;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SortedArray2BstTests {
    @Test(dataProvider = "sortedArray2Bst")
    public void sorted_array_2_bst_works(int[] array, String treeString) {
        TreeNode tree = new SortedArray2Bst().reconstruct(array);

        Assert.assertEquals(
                TreeNode.treeToString(tree),
                treeString);
    }

    @DataProvider(name = "sortedArray2Bst")
    public Object[][] sortedArray2BstProvider() {
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
