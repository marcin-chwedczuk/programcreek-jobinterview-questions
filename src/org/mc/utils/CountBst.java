package org.mc.utils;

import org.mc.dataStructures.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CountBst {
    public static int withElements(int n) {
        int[] counts = new int[Math.max(2, n+1)];
        counts[0] = counts[1] = 1;

        for (int i = 2; i <= n; i++) {
            int countI = 0;
            for (int leftSubtreeCount = 0; leftSubtreeCount < i; leftSubtreeCount++) {
                int rightSubtreeCount = i - leftSubtreeCount - 1;
                countI += counts[leftSubtreeCount] * counts[rightSubtreeCount];
            }
            counts[i] = countI;
        }

        return counts[n];
    }

    public static List<TreeNode> generateAllBst(int n) {
        return generateAllBstImpl(1, n+1);
    }

    private static List<TreeNode> generateAllBstImpl(int start, int end) {
        if (start >= end)
            return single(null);

        if (start+1 == end)
            return single(new TreeNode(start));

        List<TreeNode> trees = new ArrayList<>();

        for (int root = start; root < end; root++) {
            List<TreeNode> leftTrees = generateAllBstImpl(start, root);
            List<TreeNode> rightTrees = generateAllBstImpl(root+1, end);

            for (TreeNode left : leftTrees) {
                for (TreeNode right : rightTrees) {
                    TreeNode node = new TreeNode(root, left, right);
                    trees.add(node);
                }
            }
        }

        return trees;
    }

    private static List<TreeNode> single(TreeNode value) {
        List<TreeNode> result = new ArrayList<>();
        result.add(value);
        return result;
    }
}
