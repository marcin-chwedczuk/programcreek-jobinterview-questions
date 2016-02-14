package org.mc.tests;

import org.mc.dataStructures.TreeNode;
import org.mc.utils.MinimumBstDepth;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MinimumBstDepthTests {
    @Test(dataProvider = "minimumBstDepth")
    public void minimum_bst_depth_works(String treeString, int expectedMinH) {
        int actualMinH = new MinimumBstDepth().getMinHeight(TreeNode.treeFromString(treeString));

        Assert.assertEquals(actualMinH, expectedMinH, "failed for tree: " + treeString);
    }

    @DataProvider(name = "minimumBstDepth")
    public Object[][] minimumBstDepthProvider() {
        return new Object[][] {
                { "(3 nil nil)", 1 },
                { "(3 (1 nil nil) nil)", 2 },
                { "(3 nil (1 nil (23 nil nil)))", 3 },

                { "(3 (1 nil nil) (2 nil nil))", 2 },
                { "(3 (1 (4 nil nil) (5 nil nil)) (5 nil nil))", 2 },

                { "(3  (1 (4 nil nil) (5 nil nil)) (1 (4 nil nil) (5 nil nil)))", 3 },
                { "(3  (1 (4 nil nil) (5 nil nil)) (1 nil (5 nil nil)))", 3 }
        };
    }
}
