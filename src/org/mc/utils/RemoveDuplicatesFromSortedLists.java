package org.mc.utils;

import org.mc.dataStructures.ListNode;

public class RemoveDuplicatesFromSortedLists {
    public ListNode solve(ListNode list) {
        if (list == null)
            return null;

        ListNode last = list;
        for (ListNode curr = last.next; curr != null; curr = curr.next) {
            if (curr.value != last.value) {
                last.next = curr;
                last = curr;
            }
        }

        last.next = null;
        return list;
    }
}
