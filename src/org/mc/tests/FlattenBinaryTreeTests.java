package org.mc.tests;

import org.mc.dataStructures.ListNode;
import org.mc.dataStructures.TreeNode;
import org.mc.utils.FlattenBinaryTree;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FlattenBinaryTreeTests {
    @Test(dataProvider = "flattenBinaryTree")
    public void flatten_binary_tree_works(String treeString, int[] expectedListValues) {
        TreeNode root = TreeNode.treeFromString(treeString);
        ListNode expectedList = ListNode.create(expectedListValues);

        ListNode actualList = new FlattenBinaryTree().flatten(root);

        Assert.assertEquals(
                ListNode.listToString(actualList),
                ListNode.listToString(expectedList),
                "failed for tree: " + treeString);
    }

    @DataProvider(name = "flattenBinaryTree")
    public Object[][] flattenBinaryTreeProvider() {
        return new Object[][] {
                {
                        // single node
                        "(3 nil nil)",
                        new int[] { 3 },
                },

                {
                        // balanced tree
                        "(3 (5 (1 nil nil) (3 nil nil)) (6 (7 nil nil) (8 nil nil)))",
                        new int[] { 3, 5, 1, 3, 6, 7, 8 }
                },

                {
                        // degenerated left tree
                        "(3 (4 (5 nil nil) nil) nil)",
                        new int[] { 3, 4, 5 }
                },

                {
                        // degenerated right tree
                        "(4 nil (5 nil (6 nil nil)))",
                        new int[] { 4, 5, 6 }
                },

                {
                        // example from problem desc
                        "(1 (2 (3 nil nil) (4 nil nil)) (5 nil (6 nil nil)))",
                        new int[] { 1, 2, 3, 4, 5, 6 }
                }
        };
    }
}
