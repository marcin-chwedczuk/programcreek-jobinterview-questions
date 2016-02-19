package org.mc.tests;

import org.apache.commons.lang3.ArrayUtils;
import org.mc.dataStructures.TreeNode;
import org.mc.utils.BstIterator;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BstIteratorTests {
    @Test(dataProvider = "bstIterator")
    public void bst_iterator_works(String tree, int[] expectedValues) {
        Iterator<Integer> it = new BstIterator(TreeNode.treeFromString(tree)).iterator();

        Assert.assertEquals(
                getIteratorValues(it),
                expectedValues,
                "failed for tree: " + tree);
    }

    @DataProvider(name = "bstIterator")
    public Object[][] bstIteratorProvider() {
        return new Object[][] {
                {
                        // empty tree
                        "nil",
                        new int[0]
                },

                {
                        // single element
                        "(3 nil nil)",
                        new int[] { 3 }
                },

                {
                        // unbalanced left
                        "(3 (2 (1 nil nil) nil) nil)",
                        new int[] { 1, 2, 3 }
                },

                {
                        // unbalanced right
                        "(1 nil (2 nil (3 nil nil)))",
                        new int[] { 1, 2, 3 }
                },

                {
                        // balanced tree
                        "(10 (5 (1 nil nil) (7 nil nil)) (20 (15 nil nil) (25 nil nil)))",
                        new int[] { 1, 5, 7, 10, 15, 20, 25 }
                },

                {
                        // random tree
                        "(10 (5 (1 nil nil) nil) (20 nil (25 nil nil)))",
                        new int[] { 1, 5, 10, 20, 25 }
                }
        };
    }

    private int[] getIteratorValues(Iterator<Integer> it) {
        List<Integer> values = new ArrayList<>();

        if (it != null) {
            while (it.hasNext()) {
                values.add(it.next());
            }
        }

        return ArrayUtils.toPrimitive(values.toArray(new Integer[0]));
    }
}
