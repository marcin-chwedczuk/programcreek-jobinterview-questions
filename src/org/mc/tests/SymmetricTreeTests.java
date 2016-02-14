package org.mc.tests;

import org.mc.dataStructures.TreeNode;
import org.mc.utils.SymmetricTree;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SymmetricTreeTests {
    @Test(dataProvider = "symmetricTree")
    public void symmetric_tree_works(String treeString, boolean isSymmetric) {
        boolean actualIsSymmetric =
                new SymmetricTree().isSymmetric(TreeNode.treeFromString(treeString));

        Assert.assertEquals(actualIsSymmetric, isSymmetric, "failed for tree: " + treeString);
    }

    @DataProvider(name = "symmetricTree")
    public Object[][] symmetricTreeProvider() {
        return new Object[][] {
                { "(3 nil nil)", true },
                { "(3 (1 nil nil) (1 nil nil))", true },
                { "(3 (1 nil nil) (4 nil nil))", false },
                { "(3 (1 nil (2 nil nil)) (1 nil nil))", false },
                { "(3 (1 nil (2 nil nil)) (1 (2 nil nil) nil))", true },
                { "(3 (1 nil (2 nil nil)) (1 nil (2 nil nil)))", false }
        };
    }
}
