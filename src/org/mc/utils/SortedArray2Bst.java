package org.mc.utils;

import org.mc.dataStructures.TreeNode;

public class SortedArray2Bst {
    public TreeNode reconstruct(int[] values) {
        return reconstructImpl(values, 0, values.length);
    }

    private TreeNode reconstructImpl(int[] values, int start, int end) {
        if (start >= end)
            return null;

        int mid = (start + end) / 2;
        TreeNode node = new TreeNode(values[mid], null, null);

        node.left = reconstructImpl(values, start, mid);
        node.right = reconstructImpl(values, mid+1, end);

        return node;
    }
}
