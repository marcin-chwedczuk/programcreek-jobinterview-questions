package org.mc.tests;

import org.mc.dataStructures.TreeNode;
import org.mc.utils.MaximumPathSum;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MaximumPathSumTests {
    @Test(dataProvider = "maximumPathSum")
    public void maximum_path_sum_works(String treeString, int expectedMaxPath) {
        int actualMaxPath = new MaximumPathSum().getMaxPath(TreeNode.treeFromString(treeString));

        Assert.assertEquals(actualMaxPath, expectedMaxPath, "failed for tree: " + treeString);
    }

    @DataProvider(name = "maximumPathSum")
    public Object[][] maximumPathSumProvider() {
        return new Object[][] {
                { "(3 nil nil)", 3 },
                { "(1 (2 nil nil) (5 nil nil))", 8 },
                { "(1 (3 nil nil) nil)", 4 },
                { "(-3 (3 nil nil) (1 nil nil))", 3 },

                { "(3 (-3 nil nil) (2 nil nil))", 5 },
                { "(3 (-3 (10 nil nil) nil) (1 nil nil))", 11 }
        };
    }
}
