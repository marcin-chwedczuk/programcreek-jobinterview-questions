package org.mc.utils;

import org.mc.dataStructures.ListNode;

public class MergeSortList {
    public ListNode sort(ListNode listToSort) {
        if (listToSort == null || !listToSort.hasNext())
            return listToSort;

        ListNode left = new ListNode(0);
        ListNode leftTail = left;

        ListNode right = new ListNode(0);
        ListNode rightTail = right;

        for (ListNode curr = listToSort; curr != null; curr = curr.next) {
            leftTail.next = curr;
            leftTail = curr;

            if (curr.hasNext()) {
                curr = curr.next;

                rightTail.next = curr;
                rightTail = curr;
            }
        }

        leftTail.next = rightTail.next = null;

        left = sort(left.next);
        right = sort(right.next);

        ListNode fakeHead = new ListNode(0);
        ListNode tail = fakeHead;

        while (left != null && right != null) {
            if (left.value <= right.value) {
                tail.next = left;
                tail = left;

                left = left.next;
            }
            else {
                tail.next = right;
                tail = right;

                right = right.next;
            }
        }

        if (left != null)
            tail.next = left;
        else
            tail.next = right;

        return fakeHead.next;
    }
}
