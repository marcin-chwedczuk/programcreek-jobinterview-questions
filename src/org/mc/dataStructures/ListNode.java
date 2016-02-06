package org.mc.dataStructures;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListNode {
    public int value;
    public ListNode next;

    public ListNode(int value) {
        this(value, null);
    }

    public ListNode(int value, ListNode next) {
        this.value = value;
        this.next = next;
    }

    public boolean isTail() {
        return !hasNext();
    }

    public boolean hasNext() {
        return (next != null);
    }

    public ListNode setTail(ListNode newTail) {
        ListNode last = this;

        while (last.next != null)
            last = last.next;

        last.next = newTail;
        return this;
    }

    public ListNode reverse() {
        ListNode prev = null;
        ListNode curr = this;

        while (curr != null) {
            ListNode tmp = curr.next;

            curr.next = prev;
            prev = curr;

            curr = tmp;
        }

        return prev;
    }

    public int count() {
        int count = 0;

        for (ListNode c = this; c != null; c = c.next)
            count++;

        return count;
    }

    public ListNode atIndex(int cIndex) {
        ListNode c = this;

        for (int i = 0; i < cIndex; i++)
            c = c.next;

        return c;
    }

    @Override
    public String toString() {
        return String.format("[%d]", value);
    }

    public static String listToString(ListNode head) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");

        ListNode curr = head;
        while (curr != null) {
            sb.append(curr.value);
            if (curr.next != null)
                sb.append(", ");

            curr = curr.next;
        }

        sb.append("]");
        return sb.toString();
    }

    public static ListNode create(int... values) {
        ListNode head = null;

        for (int i = values.length - 1; i >= 0; i--) {
            head = new ListNode(values[i], head);
        }

        return head;
    }

    public static ListNode fromIndexPointers(int[] indexPointers) {
        if (indexPointers.length == 0)
            return null;

        Map<Integer, ListNode> nodes = new HashMap<>();

        for (int i = 0; i < indexPointers.length; i++) {
            nodes.put(i, new ListNode(i));
        }

        for (int i = 0; i < indexPointers.length; i++) {
            nodes.get(i).next = indexPointers[i] == -1
                    ? null
                    : nodes.get(indexPointers[i]);
        }

        return nodes.get(0);
    }

}
