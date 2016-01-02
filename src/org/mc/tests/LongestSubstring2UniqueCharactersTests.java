package org.mc.tests;
import org.mc.utils.LongestSubstring2UniqueCharacters;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LongestSubstring2UniqueCharactersTests {
    @Test(dataProvider = "longest_substring_2_unique_characters")
    public void given_string_returns_longest_substring_composed_of_only_2_characters(String string, String expectedSubstring) {
        String actualSubstring = new LongestSubstring2UniqueCharacters().solution(string);
        Assert.assertEquals(expectedSubstring, actualSubstring);
    }

    @DataProvider(name = "longest_substring_2_unique_characters")
    public Object[][] longestSubstring2UniqueCharactersProvider() {
        return new Object[][] {
                // empty string
                {
                        "", ""
                },

                // single letter sing
                {
                        "a", "a"
                },

                // two letter strings
                {
                        "aa", "aa"
                },

                {
                        "ab", "ab"
                },

                // string composed of 2 characters
                {
                        "abbaaababbbaa", "abbaaababbbaa"
                },

                // longest substring at begingin
                {
                        "abababcdef", "ababab"
                },

                // longest stubstring at end
                {
                        "cdefababab", "ababab"
                },

                // longest substring int he middle
                {
                        "cdcdabababeded", "ababab"
                },

                // string composed of only 2 letters
                {
                        "ababab", "ababab"
                }
        };
    }
}
