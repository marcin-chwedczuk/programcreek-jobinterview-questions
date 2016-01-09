package org.mc.tests;

import org.mc.utils.ShortestPalindrome;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ShortestPalindromeTests {
    @Test(dataProvider = "shortestPalindrome")
    public void shortest_palindrome_works(String s, String expected) {
        String actual = new ShortestPalindrome().solve(s);
        Assert.assertEquals(actual, expected);
    }

    @DataProvider(name = "shortestPalindrome")
    public Object[][] shortestPalindromeProvider() {
        return new Object[][] {
                // already palindrome
                { "", "" },
                { "a", "a" },
                { "aaaa", "aaaa" },
                { "foof", "foof" },
                { "afafa", "afafa" },

                // must be extended to palindrome
                { "abara", "arabara" },
                { "1234", "4321234" },
                { "oxoof", "fooxoof" },
                { "anarof", "foranarof" },

                // problem test cases
                { "aacecaaa", "aaacecaaa" },
                { "abcd", "dcbabcd" }
        };
    }
}
