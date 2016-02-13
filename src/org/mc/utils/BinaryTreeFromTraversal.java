package org.mc.utils;

import org.mc.dataStructures.TreeNode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class BinaryTreeFromTraversal {
    public TreeNode reconstruct(int[] inorder, int[] postorder) {

        if (inorder == null) throw new NullPointerException("inorder");
        if (postorder == null) throw new NullPointerException("postorder");

        if (inorder.length != postorder.length)
            throw new IllegalArgumentException("inorder must have same number of elements as postorder");

        Set<Integer> set = new HashSet<>();
        for (int n : inorder) set.add(n);
        if (set.size() != inorder.length)
            throw new IllegalArgumentException("tree must have distinct values");

        return reconstructImpl(inorder, 0, inorder.length, postorder, 0, postorder.length);
    }

    private TreeNode reconstructImpl(
            int[] inorder,  int istart, int iend,
            int[] postorder, int pstart, int pend)
    {
        if (pstart >= pend)
            return null;

        if (pstart + 1 == pend)
            return new TreeNode(postorder[pstart], null, null);

        int root = postorder[pend-1];

        int iRightStart = findIndex(inorder, istart, iend, root) + 1;
        int iLeftEnd = iRightStart - 1;

        int pLeftEnd = pstart + (iLeftEnd - istart);
        int pRightStart = pLeftEnd;

        return new TreeNode(root,
                reconstructImpl(inorder, istart, iLeftEnd, postorder, pstart, pLeftEnd),
                reconstructImpl(inorder, iRightStart, iend, postorder, pRightStart, pend-1));
    }

    private int findIndex(int[] array, int from, int to, int value) {
        for (int i = from; i < to; i++) {
            if (array[i] == value)
                return i;
        }

        return (-1);
    }
}
