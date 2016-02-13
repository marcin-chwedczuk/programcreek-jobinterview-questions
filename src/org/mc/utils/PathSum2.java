package org.mc.utils;

import org.apache.commons.lang3.*;
import org.mc.dataStructures.TreeNode;

import java.util.*;

public class PathSum2 {
    public int[][] getAllPathsOfLength(TreeNode treeNode, int length) {
        if (treeNode == null)
            return new int[0][];

        List<int[]> paths = new ArrayList<>();

        Queue<TreePath> q = new ArrayDeque<>();
        q.offer(new TreePath(treeNode, treeNode.value, null));

        while (!q.isEmpty()) {
            TreePath t = q.poll();

            if (t.node.isLeaf() && t.length == length) {
                paths.add(reconstructPath(t));
            }

            if (t.node.hasLeft())
                q.offer(new TreePath(t.node.left, t.length + t.node.left.value, t));

            if (t.node.hasRight())
                q.offer(new TreePath(t.node.right, t.length + t.node.right.value, t));
        }

        return paths.toArray(new int[0][]);
    }

    private int[] reconstructPath(TreePath t) {
        List<Integer> values = new ArrayList<>();

        while (t != null) {
            values.add(t.node.value);
            t = t.prev;
        }

        Collections.reverse(values);

        return org.apache.commons.lang3.ArrayUtils.toPrimitive(values.toArray(new Integer[0]));
    }

    private static class TreePath {
        TreeNode node;

        // length of path including node
        int length;

        TreePath prev;

        TreePath(TreeNode node, int length, TreePath prev) {
            this.node = node;
            this.length = length;
            this.prev = prev;
        }
    }
}
