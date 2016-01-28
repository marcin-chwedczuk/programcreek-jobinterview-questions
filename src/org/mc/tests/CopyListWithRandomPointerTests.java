package org.mc.tests;

import org.mc.utils.CopyListWithRandomPointer;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.mc.utils.CopyListWithRandomPointer.ListNode;

public class CopyListWithRandomPointerTests {

    @Test(dataProvider = "copyListWithRandomPointer")
    public void copy_list_with_random_pointer_works(String listToCopy) {
        ListNode head = ListNode.listFromString(listToCopy);

        ListNode copy = new CopyListWithRandomPointer().copy(head);

        Assert.assertNotEquals(copy, head);

        // check copy
        Assert.assertEquals(ListNode.listToString(copy), listToCopy);

        // check if original is not destroyed
        Assert.assertEquals(ListNode.listToString(head), listToCopy);
    }

    @DataProvider(name = "copyListWithRandomPointer")
    public Object[][] copyListWithRandomPointerProvider() {
        return new Object[][] {
                // loop
                {
                        "(nyu,nyu)"
                },

                // cycle
                {
                        "(a,b) (b,c) (c,a)"
                },

                // star
                {
                        "(a,b) (b,a) (c,b) (d,b)"
                },

                // random
                {
                        "(a,d) (b,c) (c,a) (d,b) (e,c)"
                }
        };
    }
}
