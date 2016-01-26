package org.mc.utils;

import org.mc.dataStructures.ListNode;

public class LinkedListCycle {
    public boolean solve(ListNode head) {
        if (head == null)
            return false;

        ListNode fast = head;
        ListNode slow = head;

        while (fast != null) {
            if (fast.next != null && fast.next.next != null)
                fast = fast.next.next;
            else
                break;

            slow = slow.next;

            if (fast == slow)
                return true;
        }

        return false;
    }
}
