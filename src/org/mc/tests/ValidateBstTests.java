package org.mc.tests;

import org.mc.dataStructures.TreeNode;
import org.mc.utils.ValidateBst;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ValidateBstTests {
    @Test(dataProvider = "validateBst")
    public void validate_bst_works(String treeString, boolean expectedIsValid) {
        TreeNode root = TreeNode.treeFromString(treeString);

        boolean actualIsValid = new ValidateBst().isValidBst(root);

        Assert.assertEquals(actualIsValid, expectedIsValid, "failed for tree: " + treeString);
    }

    @DataProvider(name = "validateBst")
    public Object[][] validateBstProvider() {
        return new Object[][] {
                {
                        // empty tree is valid
                        "nil", true
                },

                {
                        // single node tree is valid
                        "(3 nil nil)", true
                },

                {
                        // balanced tree valid
                        "(10 (5 (1 nil nil) (6 nil nil)) (15 (11 nil nil) (16 nil nil)))",
                        true
                },

                {
                        // balanced tree invalid
                        "(10 (5 (1 nil nil) (7 nil nil)) (11 (12 nil nil) (33 nil nil)))",
                        false
                },

                {
                        // degenerated left tree - valid
                        "(5 (3 (2 nil nil) nil) nil)", true
                },

                {
                        // degenerated left tree - invalid
                        "(5 (3 (4 nil nil) nil) nil)", false
                },

                {
                        // degenerated right tree - valid
                        "(5 nil (6 nil (8 nil nil)))", true
                },

                {
                        // degenerated right tree - invalid
                        "(5 nil (6 nil (4 nil nil)))", false
                },

        };
    }
}
