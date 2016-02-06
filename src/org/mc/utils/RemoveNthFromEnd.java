package org.mc.utils;

import org.mc.dataStructures.ListNode;

public class RemoveNthFromEnd {
    public ListNode remove(ListNode listNode, int nth) {
        ListNode fakeHead = new ListNode(0, listNode);

        ListNode curr = fakeHead.next;
        for (int i = 0; i < nth; i++)
            curr = curr.next;

        ListNode nthPrev = fakeHead;

        while (curr.next != null) {
            curr = curr.next;
            nthPrev = nthPrev.next;
        }

        nthPrev.next = nthPrev.next.next;
        return fakeHead.next;
    }
}
