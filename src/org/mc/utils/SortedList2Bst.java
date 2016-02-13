package org.mc.utils;

import org.mc.dataStructures.ListNode;
import org.mc.dataStructures.TreeNode;

public class SortedList2Bst {
    public TreeNode reconstruct(ListNode list) {
        int length = list.count();
        return reconstruct(list, 0, length).tree;
    }

    private BuildTreeResult reconstruct(ListNode list, int start, int end) {
        if (start >= end)
            return new BuildTreeResult(null, list);

        if (start+1==end)
            return new BuildTreeResult(new TreeNode(list.value, null, null), list.next);

        int mid = (start + end) / 2;

        BuildTreeResult left = reconstruct(list, start, mid);
        list = left.curr;

        TreeNode root = new TreeNode(list.value, null, null);
        list = list.next;

        BuildTreeResult right = reconstruct(list, mid+1, end);

        root.left = left.tree;
        root.right = right.tree;

        return new BuildTreeResult(root, right.curr);
    }

    private TreeNode unbalancedFullLeft(ListNode list) {
        if (list == null)
            return null;

        TreeNode root = new TreeNode(list.value, null, null);
        list = list.next;

        for (int h = 2; list != null; h++) {
            root = new TreeNode(list.value, root, null);
            BuildTreeResult right = buildTree(h-1, list.next);
            root.right = right.tree;
            list = right.curr;
        }

        return root;
    }

    private BuildTreeResult buildTree(int h, ListNode curr) {
        if (curr == null || h == 0)
            return new BuildTreeResult(null, curr);

        if (h == 1)
            return new BuildTreeResult(new TreeNode(curr.value, null, null), curr.next);

        BuildTreeResult left = buildTree(h-1, curr);
        curr = left.curr;

        if (curr == null)
            return left;

        TreeNode root = new TreeNode(curr.value, null, null);
        curr = curr.next;

        BuildTreeResult right = buildTree(h-1, curr);

        root.left = left.tree;
        root.right = right.tree;

        return new BuildTreeResult(root, right.curr);
    }

    private static class BuildTreeResult {
        TreeNode tree;
        ListNode curr;

        BuildTreeResult(TreeNode tree, ListNode curr) {
            this.tree = tree;
            this.curr = curr;
        }
    }
}
