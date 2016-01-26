package org.mc.dataStructures;

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
        return (next == null);
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
}
