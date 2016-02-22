package org.mc.utils;

import org.mc.dataStructures.ListNode;

public class ListInsertionSort {
    public static ListNode perform(ListNode listNode) {
        if (listNode == null || !listNode.hasNext())
            return listNode;

        ListNode fakeHead = new ListNode(0, listNode);
        ListNode curr = listNode.next;
        listNode.next = null;

        while (curr != null) {
            ListNode toInsert = curr;
            curr = curr.next;

            // insertion sort insert curr into sorted
            ListNode prev = fakeHead;
            for (ListNode ii = fakeHead.next; ii != null; prev = ii, ii = ii.next) {
                if (ii.value > toInsert.value)
                    break;
            }

            toInsert.next = prev.next;
            prev.next = toInsert;
        }

        return fakeHead.next;
    }
}
