package org.mc.tests;

import org.junit.Assert;
import org.mc.utils.LongestCommonPrefix;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LongestCommonPrefixTests {

    @Test(dataProvider = "longestCommonPrefix")
    public void longest_common_prefix_works(String[] inputs, String expectedPrefix) {
        String actualPrefix = new LongestCommonPrefix().solve(inputs);
        Assert.assertEquals(expectedPrefix, actualPrefix);
    }

    @DataProvider(name = "longestCommonPrefix")
    public Object[][] longestCommonPrefixProvider() {
        return new Object[][] {
                // empty array
                {
                        new String[] { },
                        ""
                },

                // single string
                {
                        new String[] { "foo" },
                        "foo"
                },

                // one of arrays is empty
                {
                        new String[] {
                                "foozble",
                                "",
                                "boble"
                        },
                        ""
                },

                // arrays of same strings
                {
                        new String[] {
                                "foo",
                                "foo",
                                "foo"
                        },
                        "foo"
                },

                // empty common prefix
                {
                        new String[] {
                                "abc",
                                "zyx",
                                "zyf",
                                "123"
                        },
                        ""
                },

                // nonempty common prefix
                {
                        new String[] {
                                "abcdef",
                                "abc",
                                "abzfa",
                                "abcd"
                        },
                        "ab"
                },

                {
                        new String[] {
                                "foozble",
                                "foo"
                        },
                        "foo"
                }
        };
    }
}
