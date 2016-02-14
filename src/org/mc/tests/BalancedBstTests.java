package org.mc.tests;

import org.mc.dataStructures.TreeNode;
import org.mc.utils.BalancedBst;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class BalancedBstTests {
    @Test(dataProvider = "balancedBst")
    public void balanced_bst_works(String treeString, boolean isBalanced) {
        boolean actualIsBalanced = new BalancedBst().isBalanced(TreeNode.treeFromString(treeString));

        Assert.assertEquals(actualIsBalanced, isBalanced, "failed for: " + treeString);
    }

    @DataProvider(name = "balancedBst")
    public Object[][] balancedBstProvider() {
        return new Object[][] {
                { "(3 nil nil)", true },
                { "(3 (1 nil nil) (2 nil nil))", true },
                { "(3 (1 nil nil) nil)", true },
                { "(3 (1 nil (5 nil nil)) nil)", false },
                { "(3 (1 (2 (3 nil nil) nil) nil) nil)", false },
                { "(3 (1 nil (5 nil nil)) (4 nil nil))", true },
                { "(3 (1 (8 nil (1 nil nil)) (5 nil nil)) (4 nil nil))", false }
        };
    }
}
