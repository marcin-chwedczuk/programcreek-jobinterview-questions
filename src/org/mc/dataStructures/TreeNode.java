package org.mc.dataStructures;

import org.apache.commons.lang3.ArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TreeNode {
    public int value;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int value) {
        this.value = value;
    }

    public TreeNode(int value, TreeNode left, TreeNode right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public boolean hasRight() {
        return (right != null);
    }

    public boolean hasLeft() {
        return (left != null);
    }

    public boolean isLeaf() {
        return !hasLeft() && !hasRight();
    }

    // (value left right) (1 (3 nil) (7 (2 nil nil) (3 nil nil)))
    public static String treeToString(TreeNode tree) {
        StringBuilder builder = new StringBuilder();
        treeToStringImpl(builder, tree);
        return builder.toString();
    }

    private static void treeToStringImpl(StringBuilder stringBuilder, TreeNode node) {
        if (node == null) {
            stringBuilder.append("nil");
            return;
        }

        stringBuilder
                .append("(")
                .append(node.value)
                .append(" ");

        treeToStringImpl(stringBuilder, node.left);
        stringBuilder.append(" ");
        treeToStringImpl(stringBuilder, node.right);

        stringBuilder.append(")");
    }

    public static TreeNode treeFromString(String treeString) {
        return new TreeNodeDeserializer(treeString).deserialize();
    }

    public int[] inorder() {
        List<Integer> values = new ArrayList<>();

        inorderImpl(this, values);

        return ArrayUtils.toPrimitive(values.toArray(new Integer[0]));
    }

    private void inorderImpl(TreeNode node, List<Integer> values) {
        if (node == null)
            return;

        inorderImpl(node.left, values);
        values.add(node.value);
        inorderImpl(node.right, values);
    }

    public int[] postorder() {
        List<Integer> values = new ArrayList<>();

        postorderImpl(this, values);

        return ArrayUtils.toPrimitive(values.toArray(new Integer[0]));
    }

    private void postorderImpl(TreeNode node, List<Integer> values) {
        if (node == null)
            return;

        postorderImpl(node.left, values);
        postorderImpl(node.right, values);
        values.add(node.value);
    }
}
