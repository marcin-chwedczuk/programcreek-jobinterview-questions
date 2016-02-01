package org.mc.utils;

import org.mc.dataStructures.ListNode;

public class RemoveLinkedListElements {
    public ListNode remove(ListNode list, int elementToRemove) {
        ListNode fakeHead = new ListNode(0, null);

        ListNode prev = fakeHead;
        for (ListNode c = list; c != null; c = c.next) {
            if (c.value == elementToRemove)
                continue;

            prev.next = c;
            prev = c;
        }
        prev.next = null;

        return fakeHead.next;
    }
}
