package org.mc.tests;

import org.mc.dataStructures.TreeNode;
import org.mc.utils.BinaryTreeFromTraversal;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class BinaryTreeFromTraversalTests {
    @Test(dataProvider = "bstFromTraversal")
    public void binary_tree_from_traversal_works(String expectedTreeString) {
        TreeNode expectedTree = TreeNode.treeFromString(expectedTreeString);

        int[] inorder = expectedTree.inorder();
        int[] postorder = expectedTree.postorder();

        TreeNode reconstructed = new BinaryTreeFromTraversal().reconstruct(inorder, postorder);

        Assert.assertEquals(
                TreeNode.treeToString(reconstructed),
                expectedTreeString);
    }

    @DataProvider(name = "bstFromTraversal")
    public Object[][] bstFromTraversalProvider() {
        return new Object[][] {
                { "(3 nil nil)" },
                { "(3 (4 nil nil) (5 nil nil))" },
                { "(3 (4 (5 nil nil) nil) nil)" },
                { "(3 nil (4 nil (5 nil nil)))" },
                { "(5 (4 (11 (7 nil nil) (2 nil nil)) nil) (8 (13 nil nil) (9 nil (1 nil nil))))" }
        };
    };
}
