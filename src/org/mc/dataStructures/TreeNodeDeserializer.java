package org.mc.dataStructures;

public class TreeNodeDeserializer {
    private String text;
    private int pos;

    public TreeNodeDeserializer(String text) {
        if (text == null || text.isEmpty())
            throw new IllegalArgumentException("text cannot be empty.");

        this.text = text;
        this.pos = 0;
    }

    public TreeNode deserialize() {
        TreeNode root = parseText();
        if (pos != text.length())
            error("expecting end of input");

        return root;
    }

    private TreeNode parseText() {
        if (isNil()) {
            match('n'); match('i'); match('l');
            return null;
        }

        match('(');
        skipSpace();

        int value = matchInt();
        skipSpace();

        TreeNode left = parseText();
        skipSpace();
        TreeNode right = parseText();
        skipSpace();

        match(')');

        return new TreeNode(value, left, right);
    }

    private boolean isNil() {
        int endIndex = pos + "nil".length();

        if (endIndex <= text.length() && text.substring(pos, endIndex).equals("nil"))
            return true;

        return false;
    }

    private void skipSpace() {
        while (pos < text.length() && Character.isWhitespace(text.charAt(pos)))
            pos++;
    }

    private void match(char c) {
        if (pos >= text.length())
            error("unexpected end of input, expecting " + c);

        if (text.charAt(pos) != c)
            error("expecting " + c + ", but found " + text.charAt(pos));

        pos++;
    }

    private int matchInt() {
        if (pos >= text.length())
            error("unexpected end of input, expecting digit");

        int num = 0;
        int sign = 1;
        boolean first = true;

        while (Character.isDigit(text.charAt(pos)) || text.charAt(pos) == '-') {
            if (text.charAt(pos) == '-') {
                if (!first)
                    error("invalid number: minus sign in wrong place");

                sign = -1;
            }
            else {
                num = num * 10 + (text.charAt(pos) - '0');
            }

            first = false;

            pos++;
            if (pos >= text.length())
                break;
        }

        return sign*num;
    }

    private void error(String message) {
        throw new RuntimeException("invalid text: (col: " + pos + "): " + message);
    }
}
