package org.mc.tests;

import org.mc.dataStructures.TreeNode;
import org.mc.utils.PathSum;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class PathSumTests {
    @Test(dataProvider = "pathSum")
    public void path_sum_works(String treeString, int pathLength, boolean expected) {
        boolean actual = new PathSum().pathOfLengthExists(
                TreeNode.treeFromString(treeString),
                pathLength);

        Assert.assertEquals(actual, expected, "failed for: " + treeString + " and len: " + pathLength);
    }

    @DataProvider(name = "pathSum")
    public Object[][] pathSumProvider() {
        return new Object[][]{
                {
                        // single node - exists
                        "(3 nil nil)",
                        3,
                        true
                },

                {
                        // single node - doesn't exists
                        "(3 nil nil)",
                        4,
                        false
                },

                {
                        // balanced tree - exists
                        "(3 (1 nil nil) (4 nil nil))",
                        4,
                        true
                },

                {
                        // balanced tree - exists
                        "(3 (1 nil nil) (4 nil nil))",
                        7,
                        true
                },

                {
                        // balanced tree - don't exists
                        "(3 (1 nil nil) (4 nil nil))",
                        33,
                        false
                },

                {
                        // degenerated left tree - exists
                        "(3 (4 (5 nil nil) nil) nil)",
                        12,
                        true
                },
                {
                        // degenerated left tree - doesn't exists
                        "(3 (4 (5 nil nil) nil) nil)",
                        6,
                        false
                },

                {
                        // degenerated right tree - exists
                        "(3 nil (4 nil (5 nil nil)))",
                        12,
                        true
                },
                {
                        // degenerated right tree - doesn't exists
                        "(3 nil (4 nil (5 nil nil)))",
                        45,
                        false
                },

                {
                        // random tree - exits
                        "(5 (4 (11 (7 nil nil) (2 nil nil)) nil) (8 (13 nil nil) (4 nil (1 nil nil))))",
                        22,
                        true
                },

                {
                        // random tree - exits
                        "(5 (4 (11 (7 nil nil) (2 nil nil)) nil) (8 (13 nil nil) (4 nil (1 nil nil))))",
                        18,
                        true
                },

                {
                        // random tree
                        "(5 (4 (11 (7 nil nil) (2 nil nil)) nil) (8 (13 nil nil) (4 nil (1 nil nil))))",
                        48,
                        false
                },

                {
                        // random tree
                        "(5 (4 (11 (7 nil nil) (2 nil nil)) nil) (8 (13 nil nil) (4 nil (1 nil nil))))",
                        4,
                        false
                }
        };
    }
}
