package org.mc.tests;

import org.mc.dataStructures.TreeNode;
import org.testng.Assert;
import org.testng.annotations.Test;

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
}
