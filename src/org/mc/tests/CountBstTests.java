package org.mc.tests;

import org.mc.dataStructures.TreeNode;
import org.mc.utils.CountBst;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class CountBstTests {
    @Test
    public void count_bst_works() {
        Assert.assertEquals(CountBst.withElements(0), 1);
        Assert.assertEquals(CountBst.withElements(1), 1);
        Assert.assertEquals(CountBst.withElements(2), 2);
        Assert.assertEquals(CountBst.withElements(3), 5);
    }

    @Test
    public void generate_bst_works() {
        List<TreeNode> result = CountBst.generateAllBst(0);
        Assert.assertEquals(result.size(), 1);
        Assert.assertEquals(result.get(0), null);

        result = CountBst.generateAllBst(1);
        Assert.assertEquals(result.size(), 1);
        Assert.assertEquals(
                TreeNode.treeToString(result.get(0)),
                "(1 nil nil)");

        result = CountBst.generateAllBst(2);
        Assert.assertEquals(result.size(), 2);
        Assert.assertEquals(
                TreeNode.treeToString(result.get(0)),
                "(1 nil (2 nil nil))");
        Assert.assertEquals(
                TreeNode.treeToString(result.get(1)),
                "(2 (1 nil nil) nil)");

        result = CountBst.generateAllBst(3);
        Assert.assertEquals(result.size(), 5);
        Assert.assertEquals(
                TreeNode.treeToString(result.get(0)),
                "(1 nil (2 nil (3 nil nil)))");
        Assert.assertEquals(
                TreeNode.treeToString(result.get(1)),
                "(1 nil (3 (2 nil nil) nil))");
        Assert.assertEquals(
                TreeNode.treeToString(result.get(2)),
                "(2 (1 nil nil) (3 nil nil))");
        Assert.assertEquals(
                TreeNode.treeToString(result.get(3)),
                "(3 (1 nil (2 nil nil)) nil)");
        Assert.assertEquals(
                TreeNode.treeToString(result.get(4)),
                "(3 (2 (1 nil nil) nil) nil)");
    }
}
