package org.mc.tests;

import org.mc.dataStructures.TreeNode;
import org.mc.utils.PathSum2;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static org.mc.tests.MatrixUtils.*;

public class PathSum2Tests {
    @Test(dataProvider = "pathSum2")
    public void path_sum2_works(String treeString, int length, int[][] expectedPaths) {
        int[][] actualPaths = new PathSum2().getAllPathsOfLength(
                TreeNode.treeFromString(treeString),
                length);

        Assert.assertEquals(
                MatrixUtils.toMatrixString(actualPaths),
                MatrixUtils.toMatrixString(expectedPaths),
                "failed for tree: " + treeString + " and len: " + length);
    }

    @DataProvider(name = "pathSum2")
    public Object[][] pathSum2Provider() {
        return new Object[][] {
                {
                        // single node
                        "(3 nil nil)",
                        3,
                        m(row(3))
                },

                {
                        // balanced tree
                        "(3 (1 nil nil) (4 nil nil))",
                        4,
                        m(row(3, 1))
                },

                {
                        // balanced tree
                        "(3 (1 nil nil) (1 nil nil))",
                        4,
                        m(row(3, 1), row(3, 1))
                },

                {
                        // balanced tree
                        "(3 (1 nil nil) (1 nil nil))",
                        32,
                        m()
                },

                {
                        // degenerated left tree
                        "(3 (4 (5 nil nil) nil) nil)",
                        12,
                        m(row(3, 4, 5))
                },

                {
                        // degenerated left tree
                        "(3 (4 (5 nil nil) nil) nil)",
                        2,
                        m()
                },

                {
                        // degenerated right tree
                        "(3 nil (4 nil (5 nil nil)))",
                        12,
                        m(row(3, 4, 5))
                },

                {
                        // degenerated right tree
                        "(3 nil (4 nil (5 nil nil)))",
                        32,
                        m()
                },

                {
                        // random tree - exits
                        "(5 (4 (11 (7 nil nil) (2 nil nil)) nil) (8 (13 nil nil) (4 nil (1 nil nil))))",
                        22,
                        m(row(5, 4, 11, 2))
                },

                {
                        // balanced tree
                        "(0 (0 (0 nil nil) (0 nil nil)) (0 (0 nil nil) nil))",
                        0,
                        m(row(0, 0, 0),
                          row(0, 0, 0),
                          row(0, 0, 0))
                }
        };
    }
}
