package org.mc.utils;

import org.mc.dataStructures.ListNode;

import java.util.List;
import java.util.PriorityQueue;

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

    public ListNode mergeK(List<ListNode> lists) {
        ListNode fakeHead = new ListNode(0, null);

        PriorityQueue<NodeIndex> q = new PriorityQueue<>();

        for (int i = 0; i < lists.size(); i++) {
            if (lists.get(i) != null)
                q.add(new NodeIndex(i, lists.get(i)));
        }

        ListNode curr = fakeHead;
        while (!q.isEmpty()) {
            NodeIndex min = q.poll();

            if (min.node.next != null)
                q.offer(new NodeIndex(min.index, min.node.next));

            curr.next = min.node;
            curr = curr.next;
        }

        return fakeHead.next;
    }

    private class NodeIndex implements Comparable<NodeIndex> {
        public int index;
        public ListNode node;

        public NodeIndex(int index, ListNode node) {
            this.index = index;
            this.node = node;
        }

        @Override
        public int compareTo(NodeIndex other) {
            return Integer.compare(this.node.value, other.node.value);
        }
    }
}
