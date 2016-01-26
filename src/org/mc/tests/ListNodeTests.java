package org.mc.tests;

import org.mc.dataStructures.ListNode;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ListNodeTests {
    @Test
    public void list_node_constructor_assigns_values_to_fields() {
        ListNode n = new ListNode(3);

        Assert.assertEquals(n.value, 3);
        Assert.assertEquals(n.next, null);

        ListNode m = new ListNode(10, n);

        Assert.assertEquals(m.value, 10);
        Assert.assertEquals(m.next, n);
    }

    @Test
    public void isTail_returns_true_when_node_is_tail_node() {
        ListNode tailNode = new ListNode(3);
        Assert.assertEquals(tailNode.isTail(), true);

        ListNode innerNode = new ListNode(3, new ListNode(4));
        Assert.assertEquals(innerNode.isTail(), false);
    }

    @Test
    public void create_creates_single_linked_list_from_array_of_values() {
        ListNode head = ListNode.create(1, 2, 3);

        Assert.assertEquals(head.value, 1);
        Assert.assertEquals(head.next.value, 2);
        Assert.assertEquals(head.next.next.value, 3);

        Assert.assertEquals(head.next.next.next, null);
    }

    @Test
    public void listToString_returns_string_representing_list() {
        ListNode head = ListNode.create(1, 3, 5);
        Assert.assertEquals(ListNode.listToString(head), "[1, 3, 5]");

        Assert.assertEquals(ListNode.listToString(null), "[]");
    }
}
