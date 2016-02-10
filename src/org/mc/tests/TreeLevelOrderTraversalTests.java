package org.mc.tests;

import org.mc.dataStructures.TreeNode;
import org.mc.utils.TreeLevelOrderTraversal;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;
import static org.mc.tests.MatrixUtils.*;

public class TreeLevelOrderTraversalTests {

    @Test(dataProvider = "treeLevelOrderTraversal")
    public void tree_level_order_traversal_works(String treeString, int[][] expectedLevels) {
        TreeNode root = TreeNode.treeFromString(treeString);
        int[][] actualLevels = new TreeLevelOrderTraversal().getLevels(root);

        Assert.assertEquals(
                toMatrixString(actualLevels),
                toMatrixString(expectedLevels),
                "failed for tree: " + treeString);
    }


    @DataProvider(name = "treeLevelOrderTraversal")
    public Object[][] treeLevelOrderTraversalProvider() {
        return new Object[][] {
                {
                        // empty tree
                        "nil",
                        m()
                },

                {
                        // single node
                        "(3 nil nil)",
                        m(row(3))
                },

                {
                        // perfectly balanced tree
                        "(3 (1 nil nil) (4 nil nil))",
                        m(
                                row(3),
                                row(1, 4)
                        )
                },

                {
                        // degenerated tree - left
                        "(3 (2 (1 nil nil) nil) nil)",
                        m(
                                row(3),
                                row(2),
                                row(1)
                        )
                },

                {
                        // degenerated tree - right
                        "(3 nil (4 nil (5 nil nil)))",
                        m(
                                row(3),
                                row(4),
                                row(5)
                        )
                },

                {
                        // huge tree
                        "(10 (5 (3 nil nil) nil) (17 (14 nil nil) (20 nil nil)))",
                        m(
                                row(10),
                                row(5, 17),
                                row(3, 14, 20)
                        )
                }
        };
    }
}
