package org.mc.tests;

import org.mc.utils.MinimumWindowSubstring;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MinimumWindowSubstringTests {
    @Test(dataProvider = "minimumWindowSubstring")
    public void minimum_windows_substring(String s, String t, String expectedWindow) {
        String actualWindow = new MinimumWindowSubstring().solve(s, t);
        Assert.assertEquals(expectedWindow, actualWindow);
    }

    @DataProvider(name = "minimumWindowSubstring")
    public Object[][] minimumWindowSubstring() {
        return new Object[][] {
                // empty t
                {
                        "foo", "", ""
                },

                // empty s
                {
                        "", "foo", null
                },

                // empty t & s
                {
                        "", "", ""
                },

                // t equal to string
                {
                        "foo", "foo", "foo"
                },

                {
                        "fo", "foo", null
                },

                // window don't exits
                {
                        "foo", "bar", null
                },

                // exiting windows
                {
                        "farfooolce", "rol", "rfoool"
                },

                {
                        "ADOBECODEBANC", "ABC", "BANC"
                },

                {
                        "abcdefg", "dcba", "abcd"
                }
        };
    }
}
