package org.mc.utils;

import org.mc.dataStructures.TreeNode;

public class SumRoot2Leaf {
    public int sum(TreeNode root) {
        return sumImpl(root, 0);
    }

    private int sumImpl(TreeNode root, int sum) {
        if (root == null)
            return 0;

        int newSum = 10*sum + root.value;

        if (root.isLeaf())
            return newSum;

        int tmp = 0;

        if (root.hasLeft())
            tmp += sumImpl(root.left, newSum);

        if (root.hasRight())
            tmp += sumImpl(root.right, newSum);

        return tmp;
    }
}
