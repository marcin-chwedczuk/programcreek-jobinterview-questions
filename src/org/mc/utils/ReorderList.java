package org.mc.utils;

import org.mc.dataStructures.ListNode;

public class ReorderList {
    public ListNode solve(ListNode list) {
        int c = count(list);
        if (c < 3)
            return list;

        int toSkip = (c+1) / 2;

        ListNode firstHalfTail = skip(list, toSkip-1);
        ListNode secondHalf = firstHalfTail.next;
        firstHalfTail.next = null;

        secondHalf = reverse(secondHalf);
        return merge(list, secondHalf);
    }

    private ListNode merge(ListNode left, ListNode right) {
        ListNode merged = null;
        ListNode curr = null;

        while (left != null && right != null) {
            ListNode leftNext = left.next;
            ListNode rightNext = right.next;

            for(ListNode node : new ListNode[] { left, right }) {
                if (curr == null) {
                    merged = curr = node;
                }
                else {
                    curr.next = node;
                    curr = node;
                }
            }

            left = leftNext;
            right = rightNext;
        }

        if (left != null) {
            curr.next = left;
            left.next = null;
        }

        return merged;
    }

    private ListNode skip(ListNode head, int count) {
        ListNode curr = head;

        for (int i = 0; i < count; i++)
            curr = curr.next;

        return curr;
    }

    private int count(ListNode head) {
        int count = 0;

        for (ListNode curr = head; curr != null; curr = curr.next)
            count++;

        return count;
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null;

        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;

            curr.next = prev;
            prev = curr;

            curr = next;
        }

        return prev;
    }
}
