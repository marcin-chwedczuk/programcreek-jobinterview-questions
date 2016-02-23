package org.mc.tests;

import org.mc.utils.WordBreak;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import static org.mc.tests.SetUtils.*;
import static org.mc.tests.ListUtils.*;

public class WordBreakTests {
    @Test(dataProvider = "wordBreak")
    public void word_break_works(String string, Set<String> dict, boolean canBreak) {
        boolean actualCanBreak = WordBreak.canBreak(string, dict);

        Assert.assertEquals(actualCanBreak, canBreak, "failed for string: " + string);
    }

    @DataProvider(name = "wordBreak")
    public Object[][] wordBreak() {
        return new Object[][] {
                {
                        "foobar",
                        set("foo", "bar"),
                        true
                },

                {
                        "foobar",
                        set("foo", "baz"),
                        false
                },

                {
                        "",
                        set("foo", "bar"),
                        false
                },

                {
                        "foo",
                        set("foo", "bar", "nyu"),
                        true
                },

                {
                        "fooz",
                        set("foo", "bar", "nyu"),
                        false
                },

                {
                        "foofoofoo",
                        set("foo", "bar", "nyu"),
                        true
                },

                {
                        "aaabbbcccddd",
                        set("aaa", "bbb", "ccd", "ddd"),
                        false
                },

                {
                        "abcdefab",
                        set("a", "bc", "d", "b", "f", "e"),
                        true
                }
        };
    }

    @Test(dataProvider = "wordBreak2")
    public void generateAll_works(String word, Set<String> dict, List<String> expectedDivisions) {
        List<String> actualDivisions = WordBreak.generateAll(word, dict);
        Collections.sort(actualDivisions, String.CASE_INSENSITIVE_ORDER);

        Collections.sort(expectedDivisions, String.CASE_INSENSITIVE_ORDER);

        Assert.assertEquals(toListString(actualDivisions), toListString(expectedDivisions), "failed for word: " + word);
    }

    @DataProvider(name = "wordBreak2")
    public Object[][] wordBreak2Provider() {
        return new Object[][] {
                {
                        "foobar",
                        set("foo", "bar"),
                        list("foo bar")
                },

                {
                        "foobar",
                        set("foo", "baz"),
                        emptyList()
                },

                {
                        "",
                        set("foo", "bar"),
                        emptyList()
                },

                {
                        "foo",
                        set("foo", "bar", "nyu"),
                        list("foo")
                },

                {
                        "fooz",
                        set("foo", "bar", "nyu"),
                        emptyList()
                },

                {
                        "foofoofoo",
                        set("foo", "bar", "nyu"),
                        list("foo foo foo")
                },

                {
                        "aaabbbcccddd",
                        set("aaa", "bbb", "ccd", "ddd"),
                        emptyList()
                },

                {
                        "catsanddog",
                        set("cat", "sand", "and", "dog", "cats"),
                        list("cats and dog", "cat sand dog")
                },

                {
                        "aaa",
                        set("a", "aa", "aaa"),
                        list("a a a", "aa a", "a aa", "aaa")
                }
        };
    }
}
