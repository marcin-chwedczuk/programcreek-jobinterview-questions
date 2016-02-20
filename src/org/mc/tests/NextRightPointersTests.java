package org.mc.tests;

import org.mc.dataStructures.TreeNode;
import org.mc.utils.NextRightPointers;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NextRightPointersTests {
    @Test
    public void next_right_pointers_works() {
        TreeNode node;

        // single node
        node = TreeNode.treeFromString("(1 nil nil)");
        new NextRightPointers().wire(node);
        Assert.assertNull(node.next);

        // two level tree
        node = TreeNode.treeFromString("(1 (0 nil nil) (1 nil nil))");
        new NextRightPointers().wire(node);
        Assert.assertNull(node.next);
        Assert.assertNull(node.right.next);
        Assert.assertSame(node.left.next, node.right);

        // three level tree
        node = TreeNode.treeFromString("(10 (5 (1 nil nil) (6 nil nil)) (15 (11 nil nil) (16 nil nil)))");
        new NextRightPointers().wire(node);
        Assert.assertNull(node.next);
        Assert.assertNull(node.right.next);
        Assert.assertSame(node.left.next, node.right);

        Assert.assertSame(node.left.left.next, node.left.right);
        Assert.assertSame(node.left.right.next, node.right.left);
        Assert.assertSame(node.right.left.next, node.right.right);
        Assert.assertNull(node.right.right.next);
    }
}
