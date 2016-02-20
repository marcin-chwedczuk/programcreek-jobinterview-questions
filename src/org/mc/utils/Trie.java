package org.mc.utils;

import org.mc.dataStructures.TreeNode;

public class Trie {
    private static final int CHILDREN_COUNT = ('z' - 'a' + 1);

    private TrieNode _root;

    public Trie() {
        _root = new TrieNode();
        _root.isLeaf = false;
    }

    public void add(String string) {
        if (string == null) {
            throw new IllegalArgumentException("string cannot be null");
        }

        TrieNode curr = _root;

        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);
            curr = curr.getChildFor(c, true);
        }

        curr.isLeaf = true;
    }

    public boolean search(String string) {
        TrieNode node = searchImpl(string);
        return node != null && node.isLeaf;
    }

    public boolean startsWith(String string) {
        if (!_root.hasChildren())
            return false;

        TrieNode node = searchImpl(string);
        return node != null;
    }

    private TrieNode searchImpl(String string) {
        if (string == null) {
            throw new IllegalArgumentException("string cannot be null");
        }

        TrieNode curr = _root;

        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);
            curr = curr.getChildFor(c, false);

            if (curr == null)
                return null;
        }

        return curr;
    }

    public boolean match(String string) {
        if (string == null) {
            throw new IllegalArgumentException("string cannot be empty");
        }

        return matchImpl(_root, string, 0) != null;
    }

    private TrieNode matchImpl(TrieNode node, String string, int currIndex) {
        if (string.length() == currIndex) {
            return node.isLeaf ? node : null;
        }

        char c = string.charAt(currIndex);
        if (c == '.') {
            for (TrieNode child : node.children) {
                if (child == null) continue;

                TrieNode tmp = matchImpl(child, string, currIndex+1);
                if (tmp != null)
                    return tmp;
            }

            return null;
        }
        else {
            node = node.getChildFor(c, false);
            if (node == null)
                return null;
            else
                return matchImpl(node, string, currIndex+1);
        }
    }

    private static class TrieNode {
        public boolean isLeaf;
        public TrieNode[] children;

        TrieNode() {
            children = new TrieNode[CHILDREN_COUNT];
        }

        public TrieNode getChildFor(char character, boolean create) {
            if (character < 'a' || character > 'z')
                throw new IllegalArgumentException("String should contain only english small letters");

            int index = character - 'a';

            if (children[index] == null && create) {
                children[index] = new TrieNode();
            }

            return children[index];
        }

        public boolean hasChildren() {
            for (TrieNode n : children) {
                if (n != null)
                    return true;
            }

            return false;
        }
    }
}
