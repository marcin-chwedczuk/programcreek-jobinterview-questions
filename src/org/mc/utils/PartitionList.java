package org.mc.utils;

import org.mc.dataStructures.ListNode;

public class PartitionList {
    public ListNode partition(int element, ListNode list) {
        ListNode lower = new ListNode(0, null);
        ListNode lowerTail = lower;

        ListNode upper = new ListNode(0, null);
        ListNode upperTail = upper;

        for (ListNode l = list; l != null; ) {
            if (l.value < element) {
                lowerTail.next = l;
                lowerTail = l;
                l = l.next;
            }
            else {
                upperTail.next = l;
                upperTail = l;
                l = l.next;
            }
        }

        lowerTail.next = upperTail.next = null;

        if (lower == lowerTail)
            return upper.next;
        else if (upper == upperTail)
            return lower.next;

        // skip fake heads
        lowerTail.next = upper.next;
        return lower.next;
    }
}
