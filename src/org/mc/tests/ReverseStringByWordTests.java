package org.mc.tests;

import org.mc.utils.ReverseStringByWord;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ReverseStringByWordTests {
    @Test(dataProvider="reverseStringByWord")
    public void reverse_string_by_word_works(String s, String expected) {
        String actual = new ReverseStringByWord().solve(s);
        Assert.assertEquals(actual, expected);
    }

    @DataProvider(name="reverseStringByWord")
    public Object[][] reverseStringByWordProvider() {
        return new Object[][] {
                // empty string
                { "", "" },

                // single word
                { "foo", "foo" },

                // many words
                { "foo is good", "good is foo" },
                { "abra cadabra", "cadabra abra" },
                { "a b c d", "d c b a" }
        };
    }
}
