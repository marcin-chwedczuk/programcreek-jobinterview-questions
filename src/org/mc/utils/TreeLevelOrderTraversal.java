package org.mc.utils;

import org.mc.dataStructures.TreeNode;

import java.util.*;

public class TreeLevelOrderTraversal {
    public int[][] getLevels(TreeNode root) {
        if (root == null)
            return new int[0][];

        List<int[]> levels = new ArrayList<>();

        int nextLevelSize = 1;
        int[] currLevel = null;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            currLevel = new int[nextLevelSize];
            levels.add(currLevel);

            q.offer(null); // mark level end
            nextLevelSize = 0;

            TreeNode curr = null;
            int pos = 0;
            while ((curr = q.poll()) != null) {
                currLevel[pos++] = curr.value;

                if (curr.hasLeft()) {
                    nextLevelSize++;
                    q.offer(curr.left);
                }

                if (curr.hasRight()) {
                    nextLevelSize++;
                    q.offer(curr.right);
                }
            }
        }

        return levels.toArray(new int[0][]);
    }
}
