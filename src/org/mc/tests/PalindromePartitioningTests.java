package org.mc.tests;

import org.mc.utils.PalindromePartitions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;
import static org.mc.tests.ListUtils.*;

public class PalindromePartitioningTests {
    @Test(dataProvider = "palindromePartitioning")
    public void palindrome_partitioning_works(String s, List<String> partitions) {
        List<String> actualPartitions = PalindromePartitions.get(s);
        Collections.sort(actualPartitions);

        Collections.sort(partitions);

        Assert.assertEquals(
                toListString(actualPartitions),
                toListString(partitions));
    }

    @DataProvider(name = "palindromePartitioning")
    public Object[][] palindromePartitioningProvider() {
        return new Object[][] {
                {
                        "",
                        list("")
                },

                {
                        "a",
                        list("a")
                },

                {
                        "aab",
                        list("a.a.b", "aa.b")
                },

                {
                        "aabaa",
                        list("aabaa", "aa.b.aa", "a.a.b.a.a", "a.a.b.aa", "aa.b.a.a", "a.aba.a")
                },

                {
                        "fox",
                        list("f.o.x")
                }
        };
    }
}
