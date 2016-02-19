package org.mc.utils;

import org.mc.dataStructures.TreeNode;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;

public class BstIterator {
    private final TreeNode tree;

    public BstIterator(TreeNode tree) {
        this.tree = tree;
    }

    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            private final Stack<TreeNode> rightStack;

            {
                rightStack = new Stack<>();
                expandStack(BstIterator.this.tree);
            }

            private void expandStack(TreeNode tree) {
                while (tree != null) {
                    rightStack.push(tree);
                    tree = tree.left;
                }
            }

            @Override
            public boolean hasNext() {
                return !rightStack.empty();
            }

            @Override
            public Integer next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }

                TreeNode rightTree = rightStack.pop();

                expandStack(rightTree.right);

                int value = rightTree.value;
                return value;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }
}
