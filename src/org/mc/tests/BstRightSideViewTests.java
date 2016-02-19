package org.mc.tests;

import org.mc.dataStructures.TreeNode;
import org.mc.utils.BstRightSideView;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class BstRightSideViewTests {
    @Test(dataProvider = "bstRightSideView")
    public void bst_right_side_view_works(String tree, int[] rightSideView) {
        int[] actual = new BstRightSideView().get(TreeNode.treeFromString(tree));

        Assert.assertEquals(
                actual,
                rightSideView,
                "failed for: " + tree);
    }

    @DataProvider(name = "bstRightSideView")
    public Object[][] bstRightSideViewProvider() {
        return new Object[][] {
                {
                        // single node
                        "(3 nil nil)",
                        new int[] { 3 }
                },

                {
                        // degenerated left
                        "(3 (2 (1 nil nil) nil) nil)",
                        new int[] { 3, 2, 1 }
                },

                {
                        // degenerated right
                        "(3 nil (4 nil (5 nil nil)))",
                        new int[] { 3, 4, 5 }
                },

                {
                        // balanced tree
                        "(5 (3 (1 nil nil) (4 nil nil)) (10 (6 nil nil) (11 nil nil)))",
                        new int[] { 5, 10, 11 }
                },

                {
                        // random tree
                        "(5 (3 (1 nil nil) nil) (10 nil nil))",
                        new int[] { 5, 10, 1 }
                }
        };
    }
}
