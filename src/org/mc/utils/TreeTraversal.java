package org.mc.utils;

import org.mc.dataStructures.TreeNode;

import java.util.Stack;

public class TreeTraversal {
    public void preorder(TreeNode root, IntVisitor visitor) {
        if (root == null)
            return;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            visitor.accept(curr.value);

            if (curr.hasRight())
                stack.push(curr.right);

            if (curr.hasLeft())
                stack.push(curr.left);
        }
    }

    public void inorder(TreeNode root, IntVisitor visitor) {
        if (root == null)
            return;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        TreeNode lastVisited = null;

        while (!stack.isEmpty()) {
            TreeNode top = stack.peek();

            // order is important
            if (top.hasRight() && top.right == lastVisited) {
                lastVisited = top;
                stack.pop();
            }
            else if (!top.hasLeft() || (top.hasLeft() && top.left == lastVisited)) {
                visitor.accept(top.value);
                lastVisited = top;

                if (top.hasRight())
                    stack.push(top.right);
                else
                    stack.pop();
            }
            else {
                stack.push(top.left);
            }
        }
    }

    public void postorder(TreeNode root, IntVisitor visitor) {
        if (root == null)
            return;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        TreeNode lastVisited = null;

        while (!stack.isEmpty()) {
            TreeNode top = stack.peek();

            // order is important
            if ((!top.hasLeft() && !top.hasRight()) ||
                (top.hasRight() && top.right == lastVisited) ||
                (top.hasLeft() && top.left == lastVisited && !top.hasRight()))
            {
                visitor.accept(top.value);
                lastVisited = top;
                stack.pop();
            }
            else if (top.hasRight() && (!top.hasLeft() || top.left == lastVisited)) {
                stack.push(top.right);
            }
            else if (top.hasLeft() && top.left != lastVisited) {
                stack.push(top.left);
            }
        }
    }
}
