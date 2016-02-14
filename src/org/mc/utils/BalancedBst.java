package org.mc.utils;

import org.mc.dataStructures.TreeNode;

public class BalancedBst {
    private boolean unbalanced = false;

    public boolean isBalanced(TreeNode root) {
        isBalancedImpl(root);
        return !unbalanced;
    }

    private int isBalancedImpl(TreeNode node) {
        if (node == null || unbalanced)
            return 0;

        int hl = isBalancedImpl(node.left);
        int hr = isBalancedImpl(node.right);

        if (Math.abs(hl - hr) > 1) {
            unbalanced = true;
        }

        return 1 + Math.max(hl, hr);
    }
}
