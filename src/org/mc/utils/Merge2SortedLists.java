package org.mc.utils;

import org.mc.dataStructures.ListNode;

public class Merge2SortedLists {
    public ListNode merge(ListNode left, ListNode right) {
        ListNode lc = left, rc = right;

        // fake head
        ListNode merged = new ListNode(0, null);

        ListNode curr = merged;
        while ( (lc != null) && (rc != null) ) {
            if (lc.value <= rc.value) {
                curr.next = lc;
                curr = lc;

                lc = lc.next;
            }
            else {
                curr.next = rc;
                curr = rc;

                rc = rc.next;
            }
        }

        if (lc != null)
            curr.next = lc;
        else if (rc != null)
            curr.next = rc;

        // skip fake head
        return merged.next;
    }
}
