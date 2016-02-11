package org.mc.utils;

import org.mc.dataStructures.ListNode;
import org.mc.dataStructures.TreeNode;

public class FlattenBinaryTree {
    public ListNode flatten(TreeNode root) {
        List l = flattenImpl(root);
        return l.head;
    }

    private List flattenImpl(TreeNode node) {
        if (node == null)
            return new List(null, null);

        List left = flattenImpl(node.left);
        List right = flattenImpl(node.right);

        ListNode head = new ListNode(node.value, null);
        ListNode tail = head;

        if (left.head != null) {
            tail.next = left.head;
            tail = left.tail;
        }

        if (right.head != null) {
            tail.next = right.head;
            tail = right.tail;
        }

        return new List(head, tail);
    }

    private static class List {
        ListNode head;
        ListNode tail;

        List(ListNode head, ListNode tail) {
            this.head = head;
            this.tail = tail;
        }
    }
}
