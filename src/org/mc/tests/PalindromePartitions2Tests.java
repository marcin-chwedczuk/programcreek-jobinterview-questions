package org.mc.tests;

import org.mc.utils.PalindromePartition2;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class PalindromePartitions2Tests {
    @Test(dataProvider = "palindromePartition2")
    public void palindrome_parttitions2_works(String string, String minimalPartition) {
        String actualMinimalPartition =
                new PalindromePartition2(string).findMinimalPartition();

        Assert.assertEquals(actualMinimalPartition, minimalPartition, "failed for string: " + string);
    }

    @DataProvider(name = "palindromePartition2")
    public Object[][] palindromePartition2Provider() {
        return new Object[][] {
                {
                        "", ""
                },
                {
                        "a", "a"
                },
                {
                        "aab", "aa.b"
                },
                {
                        "aabaazbz", "aabaa.zbz"
                },
                {
                        "abrarzaz", "a.b.rar.zaz"
                },

                {
                        "foovoof", "foovoof"
                },

                {
                        "abcd", "a.b.c.d"
                },

                {
                        "aaabbaab", "aaa.b.baab"
                }
        };
    }
}
