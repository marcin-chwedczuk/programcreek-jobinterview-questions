package org.mc.tests;

import org.mc.dataStructures.TreeNode;
import org.mc.utils.SumRoot2Leaf;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SumRoot2LeafTests {
    @Test(dataProvider = "sumRoot2Leaf")
    public void sum_root_2_leaf_works(String tree, int expectedSum) {
        int actualSum = new SumRoot2Leaf().sum(TreeNode.treeFromString(tree));
        Assert.assertEquals(actualSum, expectedSum);
    }

    @DataProvider(name = "sumRoot2Leaf")
    public Object[][] sumRoot2LeafProvider() {
        return new Object[][] {
                {
                        "(1 nil nil)",
                        1
                },

                {
                        "(2 (1 nil nil) (3 nil nil))",
                        21 + 23
                },

                {
                        "(2 (1 nil nil) nil)",
                        21
                },

                {
                        "(2 (3 (1 nil nil) nil) (4 nil nil))",
                        231+24
                },
        };
    }
}
