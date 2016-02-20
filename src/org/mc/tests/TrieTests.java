package org.mc.tests;

import org.mc.utils.Trie;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TrieTests {
    private Trie trie;

    @BeforeMethod
    public void before_test() {
        trie = new Trie();
    }

    @Test
    public void can_add_string_to_trie() {
        trie.add("");

        trie.add("a");
        trie.add("a");

        trie.add("blahblah");
        trie.add("blah");

        trie.add("aaa");
        trie.add("foo");

        Assert.assertTrue(trie.search(""));
        Assert.assertTrue(trie.search("aaa"));
        Assert.assertTrue(trie.search("blahblah"));
        Assert.assertTrue(trie.search("blah"));
    }

    @Test
    public void search_return_true_if_element_is_in_trie() {
        Assert.assertEquals(trie.search(""), false);
        Assert.assertEquals(trie.search("foo"), false);

        trie.add("a");
        trie.add("foo");

        Assert.assertEquals(trie.search("a"), true);
        Assert.assertEquals(trie.search("foo"), true);

        Assert.assertEquals(trie.search(""), false);
        Assert.assertEquals(trie.search("bar"), false);
        Assert.assertEquals(trie.search("foozble"), false);
    }

    @Test
    public void startsWith_returns_true_if_some_element_starts_with_given_string() {
        Assert.assertEquals(trie.startsWith(""), false);
        Assert.assertEquals(trie.startsWith("foo"), false);

        trie.add("foo");
        trie.add("b");

        Assert.assertEquals(trie.startsWith("fo"), true);
        Assert.assertEquals(trie.startsWith(""), true);
        Assert.assertEquals(trie.startsWith("b"), true);

        Assert.assertEquals(trie.startsWith("c"), false);
        Assert.assertEquals(trie.startsWith("dumpty"), false);
    }
}
