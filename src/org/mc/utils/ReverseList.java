package org.mc.utils;

import org.mc.dataStructures.ListNode;

public class ReverseList {
    public ListNode reverse(ListNode list) {

        ListNode prev = null;

        while (list != null) {
            ListNode next = list.next;
            list.next = prev;

            prev = list;
            list = next;
        }

        return prev;
    }
}
