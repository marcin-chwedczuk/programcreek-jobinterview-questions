package org.mc.utils;

import org.mc.dataStructures.TreeNode;

public class MaximumPathSum {
    private int globalMax = 0;

    public int getMaxPath(TreeNode node) {
        getMaxPathImpl(node);
        return globalMax;
    }

    private MaxPathResult getMaxPathImpl(TreeNode node) {
        if (node == null)
            return new MaxPathResult(0, 0);

        MaxPathResult left = getMaxPathImpl(node.left);
        MaxPathResult right = getMaxPathImpl(node.right);

        int maxInclude = node.value
                + Math.max(0, left.maxValue())
                + Math.max(0, right.maxValue());
        int maxWithout = Math.max(node.value, Math.max(left.maxValue(), right.maxValue()));
        globalMax = Math.max(globalMax, Math.max(maxInclude, maxWithout));

        return new MaxPathResult(node.value + left.maxValue(), node.value + right.maxValue());
    }

    private static class MaxPathResult {
        int maxL, maxR;

        MaxPathResult(int maxL, int maxR) {
            this.maxL = maxL;
            this.maxR = maxR;
        }

        public int maxValue() {
            return Math.max(maxL, maxR);
        }
    }
}
