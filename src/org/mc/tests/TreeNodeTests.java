package org.mc.tests;

import org.mc.dataStructures.TreeNode;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;

public class TreeNodeTests {
    @Test
    public void treeToString_works() {
        TreeNode root = new TreeNode(3,
                new TreeNode(7, null, null),
                new TreeNode(8, null, new TreeNode(32)));

        String expectedString = "(3 (7 nil nil) (8 nil (32 nil nil)))";

        Assert.assertEquals(TreeNode.treeToString(root), expectedString);
    }

    @Test
    public void stringToTree_works() {
        String text = "(3 (7 nil nil) (8 nil (32 nil nil)))";

        TreeNode root = TreeNode.treeFromString(text);

        Assert.assertEquals(TreeNode.treeToString(root), text);
    }

    @Test
    public void inorder_works() {
        String text = "(3 (7 nil nil) (8 (9 nil nil) (10 nil nil)))";

        int[] values = TreeNode.treeFromString(text).inorder();

        Assert.assertEquals(
                Arrays.toString(values),
                Arrays.toString(new int[] { 7, 3, 9, 8, 10 }));
    }

    @Test
    public void postorder_works() {
        String text = "(3 (7 nil nil) (8 (9 nil nil) nil))";

        int[] values = TreeNode.treeFromString(text).postorder();

        Assert.assertEquals(
                Arrays.toString(values),
                Arrays.toString(new int[] { 7, 9, 8, 3 }));
    }
}
