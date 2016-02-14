package org.mc.utils;

import org.mc.dataStructures.TreeNode;

public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        return (root == null) || isSymmetric(root.left, root.right);
    }

    public boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null)
            return true;

        if (left == null || right == null)
            return false;

        if (left.value != right.value)
            return false;

        return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }
}
