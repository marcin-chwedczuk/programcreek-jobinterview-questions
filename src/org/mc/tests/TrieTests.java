package org.mc.tests;

import com.sun.xml.internal.ws.policy.AssertionSet;
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

    @Test
    public void match_returns_true_if_trie_contains_string_matching_simplified_regex() {
        // simplified regex letters: a-z and '.' operator

        trie.add("foooz");
        trie.add("foo");
        trie.add("moo");
        trie.add("xox");

        Assert.assertEquals(trie.match("f...z"), true);
        Assert.assertEquals(trie.match("f....z"), false);
        Assert.assertEquals(trie.match("f.z"), false);
        Assert.assertEquals(trie.match(".oo.z"), true);
        Assert.assertEquals(trie.match("foooz"), true);

        Assert.assertEquals(trie.match(".ox"), true);
        Assert.assertEquals(trie.match(".o."), true);
        Assert.assertEquals(trie.match("xox"), true);
        Assert.assertEquals(trie.match("m.o"), true);
        Assert.assertEquals(trie.match("d.."), false);
        Assert.assertEquals(trie.match("d."), false);
        Assert.assertEquals(trie.match("."), false);
        Assert.assertEquals(trie.match("..."), true);
        Assert.assertEquals(trie.match(""), false);
    }
}
