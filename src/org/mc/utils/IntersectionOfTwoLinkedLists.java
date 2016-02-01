package org.mc.utils;

import org.mc.dataStructures.ListNode;

public class IntersectionOfTwoLinkedLists {
    public ListNode findIntersection(ListNode a, ListNode b) {
        if (a == null || b == null)
            return null;

        int A = a.count();
        int B = b.count();

        ListNode reversedB = b.reverse();

        // L = a elements + 1 c element + b elements
        int L = a.count();

        // restore b
        reversedB.reverse();

        // A = a + c
        // B = b + c
        // L = a + b + 1

        int cIndex = ((A+B) - (L-1)) / 2;
        return a.atIndex(A - cIndex);
    }
}
