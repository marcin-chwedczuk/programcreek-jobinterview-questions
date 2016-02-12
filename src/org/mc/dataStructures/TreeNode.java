package org.mc.dataStructures;

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
}
