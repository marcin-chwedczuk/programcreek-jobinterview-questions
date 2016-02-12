package org.mc.utils;

import org.mc.dataStructures.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

public class PathSum {
    public boolean pathOfLengthExists(TreeNode treeNode, int pathLength) {
        return recImpl(treeNode, pathLength);
    }

    private boolean recImpl(TreeNode node, int pathLength) {
        if (node == null)
            return false;

        if (node.isLeaf() && pathLength == node.value)
            return true;

        pathLength -= node.value;

        if (node.hasLeft() && recImpl(node.left, pathLength))
            return true;

        if (node.hasRight() && recImpl(node.right, pathLength))
            return true;

        return false;
    }

    private boolean queueImpl(TreeNode treeNode, int pathLength) {
        if (treeNode == null)
            return false;

        Queue<TreePath> q = new ArrayDeque<>();
        q.offer(new TreePath(treeNode, treeNode.value));

        while (!q.isEmpty()) {
            TreePath t = q.poll();

            if (t.node.isLeaf() && t.length == pathLength)
                return true;

            if (t.node.hasLeft())
                q.offer(new TreePath(t.node.left, t.length + t.node.left.value));

            if (t.node.hasRight())
                q.offer(new TreePath(t.node.right, t.length + t.node.right.value));
        }

        return false;
    }

    private static class TreePath {
        TreeNode node;

        // length of path including node
        int length;

        TreePath(TreeNode node, int length) {
            this.node = node;
            this.length = length;
        }
    }
}
