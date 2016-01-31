package org.mc.utils;

public class LRUCache {
    private final int maxCapacity;
    private ListNode fakeHead;

    public LRUCache(int maxCapacity) {
        if (maxCapacity <= 0)
            throw new IllegalArgumentException("maxCapacity must be positive.");

        this.maxCapacity = maxCapacity;
        this.fakeHead = new ListNode(0, 0);
    }

    public int get(int key) {
        for (ListNode prev = fakeHead, c = fakeHead.next; c != null; prev = c, c = c.next) {
            if (c.hasKey(key)) {
                // move node to front
                prev.next = c.next;
                c.next = fakeHead.next;
                fakeHead.next = c;

                return c.getValue();
            }
        }

        return -1;
    }

    public void set(int key, int value) {
        int nodes = 1;

        ListNode prev = fakeHead;
        for (ListNode c = fakeHead.next; c != null; prev = c, c = c.next, nodes++) {
            if (c.hasKey(key)) {
                // move node to front
                prev.next = c.next;
                c.next = fakeHead.next;
                fakeHead.next = c;

                c.updateValue(value);
                return;
            }
            else if (nodes == maxCapacity) {
                // at last node and node.key != key

                // remove last
                prev.next = null;

                // add new at front - after for loop
                break;
            }
        }

        ListNode c = new ListNode(key, value);
        c.next = fakeHead.next;
        fakeHead.next = c;
    }

    private static class ListNode {
        private int key;
        private int value;

        public ListNode next;

        public ListNode(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public boolean hasKey(int key) {
            return this.key == key;
        }

        public int getValue() {
            return value;
        }

        public void updateValue(int newValue) {
            this.value = newValue;
        }
    }
}
