package org.mc.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CopyListWithRandomPointer {
    // node1 -> node2
    // node1 -> node1'copy -> node2 -> node2'copy
    public ListNode copy(ListNode head) {
        if (head == null)
            return null;

        ListNode listWithShadow = addShadow(head);
        linkShadowList(listWithShadow);
        return removeShadow(listWithShadow);
    }

    private ListNode addShadow(ListNode head) {
        for (ListNode curr = head; curr != null; ) {
            ListNode shadow = new ListNode(curr.name, curr.next);
            curr.next = shadow;
            curr = shadow.next;
        }

        return head;
    }

    private void linkShadowList(ListNode head) {
         for (ListNode curr = head; curr != null; ) {
             ListNode shadow = curr.next;

             if (curr.random != null) {
                 shadow.random = curr.random.next;
             }
             else {
                 shadow.random = null;
             }

             curr = shadow.next;
        }

    }

    private ListNode removeShadow(ListNode head) {
        ListNode shadowHead = head.next;

        for (ListNode curr = head; curr != null; curr = curr.next) {
            ListNode shadow = curr.next;

            curr.next = shadow.next;

            if (curr.next != null)
                shadow.next = curr.next.next;
            else
                shadow.next = null;
        }

        return shadowHead;
    }

    public static class ListNode {
        public String name;
        public ListNode next;
        public ListNode random;

        public ListNode(String name, ListNode next, ListNode random) {
            this.name = name;
            this.next = next;
            this.random = random;
        }

        public ListNode(String name, ListNode next) {
            this.name = name;
            this.next = next;
        }

        public boolean isTail() {
            return (this.next == null);
        }

        // index(name,points-to-name) e.g.  (nya, nya) (foo, bar) (bar, baz) (baz, bar)
        // use null for null
        public static ListNode listFromString(String stringRepresentation) {
            List<List<String>> matches =
                    RegexUtils.splitAndMatch(stringRepresentation, "\\s+", "\\((\\w+),\\s*(\\w+)\\)");

            Map<String, ListNode> name2Node = new HashMap<>();
            for (List<String> match : matches) {
                name2Node.put(match.get(0), new ListNode(match.get(0), null));
            }

            for (int i = 0; i < matches.size(); i++) {
                List<String> match = matches.get(i);

                ListNode curr = name2Node.get(match.get(0));

                if (!match.get(1).equals("null"))
                    curr.random = name2Node.get(match.get(1));

                if (i < matches.size()-1)
                    curr.next = name2Node.get(matches.get(i+1).get(0));
            }

            return name2Node.get(matches.get(0).get(0));
        }

        public static String listToString(ListNode head) {
            StringBuilder sb = new StringBuilder();

            ListNode curr = head;
            while (curr != null) {
                String name = curr.name;
                String random = curr.random != null ? curr.random.name : "null";

                sb.append(String.format("(%s,%s) ", name, random));

                curr = curr.next;
            }

            if (sb.length() > 0)
                sb.delete(sb.length()-1, sb.length());

            return sb.toString();
        }
    }
}
