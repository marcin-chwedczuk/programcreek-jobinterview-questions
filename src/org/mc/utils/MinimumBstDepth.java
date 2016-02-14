package org.mc.utils;

import org.mc.dataStructures.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumBstDepth {
    public int getMinHeight(TreeNode root) {
        return getMinHeightBFS(root);
    }

    private int getMinHeightBFS(TreeNode node) {
        Queue<TreeNode> curr = new LinkedList<>();
        Queue<TreeNode> next = new LinkedList<>();

        curr.offer(node);
        int h = 0;

        while (!curr.isEmpty()) {
            h++;

            while (!curr.isEmpty()) {
                TreeNode t = curr.poll();
                if (t.isLeaf())
                    return h;

                if (t.hasLeft())
                    next.offer(t.left);

                if (t.hasRight())
                    next.offer(t.right);
            }

            Queue<TreeNode> swap = curr; curr = next; next = swap;
        }

        return h;
    }
}
