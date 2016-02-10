package org.mc.utils;

import org.mc.dataStructures.TreeNode;

public class ValidateBst {
    public boolean isValidBst(TreeNode root) {
        if (root == null)
            return true;

        OpenInterval interval = OpenInterval.unboundInterval();
        return isValidBst(root, interval);
    }

    private boolean isValidBst(TreeNode node, OpenInterval interval) {
        if (!interval.contains(node.value))
            return false;

        if (node.hasLeft()) {
            OpenInterval leftInterval = interval.splitLower(node.value);
            if (!isValidBst(node.left, leftInterval))
                return false;
        }

        if (node.hasRight()) {
            OpenInterval rightInterval = interval.splitUpper(node.value);
            if (!isValidBst(node.right, rightInterval))
                return false;
        }

        return true;
    }

    private static class OpenInterval {
        private int left, right;

        private OpenInterval(int left, int right) {
            if (left > right)
                throw new IllegalArgumentException("left must be <= than right");

            this.left = left;
            this.right = right;
        }

        public boolean contains(int value) {
            return (left < value) && (value < right);
        }

        public OpenInterval splitLower(int value) {
            if (!contains(value))
                throw new IllegalArgumentException("value must be within interval");

            return new OpenInterval(left, value);
        }

        public OpenInterval splitUpper(int value) {
             if (!contains(value))
                throw new IllegalArgumentException("value must be within interval");

            return new OpenInterval(value, right);
        }

        @Override
        public String toString() {
            return "OpenInterval{" +
                    "left=" + left +
                    ", right=" + right +
                    '}';
        }

        public static OpenInterval unboundInterval() {
            return new OpenInterval(Integer.MIN_VALUE, Integer.MAX_VALUE);
        }
    }
}
