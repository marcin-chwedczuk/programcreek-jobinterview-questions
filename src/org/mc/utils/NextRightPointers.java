package org.mc.utils;

import org.mc.dataStructures.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

public class NextRightPointers {
    public void wire(TreeNode root) {
        if (root == null) return;

        root.next = null;
        TreeNode upper = root;
        TreeNode curr = root.left;

        while (!upper.isLeaf()) {
            TreeNode upperStart = upper;
            TreeNode currStart = curr;

            while (upper != null) {
                // left -> right
                curr.next = upper.right;

                // move to right
                curr = upper.right;

                // right to next left
                if (upper.next != null) {
                    curr.next = upper.next.left;
                    curr = upper.next.left;
                } else {
                    curr.next = null;
                }

                upper = upper.next;
            }

            upper = currStart;
            curr = currStart.left;
        }
    }

    public void wire2(TreeNode root) {
        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);

        Queue<TreeNode> nextLevel = new ArrayDeque<>();

        while (!q.isEmpty()) {
            TreeNode prev = new TreeNode(1);

            while (!q.isEmpty()) {
                TreeNode curr = q.poll();
                prev.next = curr;
                prev = curr;

                if (!curr.isLeaf()) {
                    nextLevel.offer(curr.left);
                    nextLevel.offer(curr.right);
                }
            }
            prev.next = null;

            Queue<TreeNode> swap = q; q = nextLevel; nextLevel = swap;
        }
    }

}
