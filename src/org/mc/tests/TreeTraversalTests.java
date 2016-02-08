package org.mc.tests;

import org.apache.commons.lang3.ArrayUtils;
import org.mc.dataStructures.TreeNode;
import org.mc.utils.IntVisitor;
import org.mc.utils.TreeTraversal;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TreeTraversalTests {
    @Test(dataProvider = "preorderTreeTraversal")
    public void tree_traversal_perorder_works(String treeText, int[] expectedOrder) {
        final List<Integer> order = new ArrayList<>();

        new TreeTraversal().preorder(TreeNode.treeFromString(treeText), new IntVisitor() {
            @Override
            public void accept(int value) {
                order.add(value);
            }
        });

        int[] actual = ArrayUtils.toPrimitive(order.toArray(new Integer[0]));

        Assert.assertEquals(
                Arrays.toString(actual),
                Arrays.toString(expectedOrder),
                "failed for tree: " + treeText);
    }

    @DataProvider(name = "preorderTreeTraversal")
    public Object[][] preorderTreeTraversalProvider() {
        return new Object[][] {
                {
                        // single element
                        "(3 nil nil)",
                        new int[] { 3 }
                },

                {
                        // degenerated tree left
                        "(3 (4 (5 nil nil) nil) nil)",
                        new int[] { 3, 4, 5 }
                },

                {
                        // degenerated tree right
                        "(3 nil (4 nil (5 nil nil)))",
                        new int[] { 3, 4, 5 }
                },

                {
                        // balanced tree
                        "(3 (4 nil nil) (5 nil nil))",
                        new int[] { 3, 4, 5 }
                },

                {
                        // unbalanced tree
                        "(3 (4 nil nil) (5 (6 (7 nil nil) nil) (8 nil nil)))",
                        new int[] { 3, 4, 5, 6, 7, 8 }
                }
        };
    }


    @Test(dataProvider = "inorderTreeTraversal")
    public void tree_traversal_inorder_works(String treeText, int[] expectedOrder) {
        final List<Integer> order = new ArrayList<>();

        new TreeTraversal().inorder(TreeNode.treeFromString(treeText), new IntVisitor() {
            @Override
            public void accept(int value) {
                order.add(value);
            }
        });

        int[] actual = ArrayUtils.toPrimitive(order.toArray(new Integer[0]));

        Assert.assertEquals(
                Arrays.toString(actual),
                Arrays.toString(expectedOrder),
                "failed for tree: " + treeText);
    }

    @DataProvider(name = "inorderTreeTraversal")
    public Object[][] inorderTreeTraversalProvider() {
        return new Object[][] {
                {
                        // single element
                        "(3 nil nil)",
                        new int[] { 3 }
                },

                {
                        // degenerated tree left
                        "(3 (4 (5 nil nil) nil) nil)",
                        new int[] { 5, 4, 3 }
                },

                {
                        // degenerated tree right
                        "(3 nil (4 nil (5 nil nil)))",
                        new int[] { 3, 4, 5 }
                },

                {
                        // balanced tree
                        "(3 (4 nil nil) (5 nil nil))",
                        new int[] { 4, 3, 5 }
                },

                {
                        // unbalanced tree
                        "(3 (4 nil nil) (5 (6 (7 nil nil) nil) (8 nil nil)))",
                        new int[] { 4, 3, 7, 6, 5, 8 }
                }
        };
    }
}
