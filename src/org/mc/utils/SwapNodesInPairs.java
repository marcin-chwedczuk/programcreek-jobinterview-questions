package org.mc.utils;

import org.mc.dataStructures.ListNode;

public class SwapNodesInPairs {
    public ListNode swap(ListNode listNode) {
        ListNode fakeHead = new ListNode(0, listNode);

        ListNode prev = fakeHead;
        while (prev.hasNext() && prev.next.hasNext()) {
            ListNode curr = prev.next;
            ListNode next = curr.next;
            ListNode nextNext = next.next;

            prev.next = next;
            next.next = curr;
            curr.next = nextNext;

            prev = curr;
        }

        return fakeHead.next;
    }
}
