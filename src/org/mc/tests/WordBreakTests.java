package org.mc.tests;

import org.mc.utils.WordBreak;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Set;
import static org.mc.tests.SetUtils.*;

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
}
