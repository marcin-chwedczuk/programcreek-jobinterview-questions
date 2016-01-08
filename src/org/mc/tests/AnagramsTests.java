package org.mc.tests;

import org.apache.commons.lang3.StringUtils;
import org.mc.utils.Anagrams;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.*;

public class AnagramsTests {
    @Test(dataProvider = "anagrams")
    public void anagrams_works(String[] strings, List<List<String>> expectedGroups) {
        List<List<String>> actualGroups = new Anagrams().solve(strings);
        String failureMessage = buildFailureMessage(actualGroups, expectedGroups);

        Assert.assertEquals(actualGroups.size(), expectedGroups.size(), failureMessage);

        String actual = groupsToString(actualGroups);
        String expected = groupsToString(expectedGroups);
        Assert.assertEquals(actual, expected, failureMessage);
    }

    @DataProvider(name = "anagrams")
    public Object[][] anagramsDataProvider() {
        return new Object[][] {
                // empty input array
                {
                        new String[] { },
                        list()
                },

                // single string
                {
                        new String[] { "foo" },
                        list(group("foo"))
                },

                // all string in same group
                {
                        new String[] { "aaab", "abaa", "baaa", "aaba" },
                        list(group("aaab", "aaba", "abaa", "baaa"))
                },

                // every string in separate group
                {
                        new String[] { "abc", "def", "ggg", "hji", "zfx" },
                        list(group("abc"), group("def"), group("ggg"), group("hji"), group("zfx"))
                },

                // array with repeating string
                {
                        new String[] { "foo", "bar", "foo", "jinx" },
                        list(group("foo", "foo"), group("bar"), group("jinx"))
                },

                // random anagrams
                {
                        new String[] { "foo", "off", "fof", "ofo", "ufo" },
                        list(group("foo", "ofo"), group("off", "fof"), group("ufo"))
                },

                {
                        new String[] { "az", "azz", "buzz", "zuzb", "bzuz" },
                        list(group("az"), group("azz"), group("buzz", "zuzb", "bzuz"))
                }
        };
    }

    private List<String> group(String... anagrams) {
        List<String> group = new ArrayList<>();

        for(String anagram : anagrams)
            group.add(anagram);

        return group;
    }

    private List<List<String>> list(List<String>... groups) {
        List<List<String>> list = new ArrayList<>();

        for(List<String> group : groups)
            list.add(group);

        return list;
    }

    private String groupsToString(List<List<String>> groups) {
        List<String> flatGroups = new ArrayList<>();

        for(List<String> group : groups) {
            String[] array = group.toArray(new String[0]);
            Arrays.sort(array);

            flatGroups.add("{" + StringUtils.join(array, ',') + "}");
        }

        Collections.sort(flatGroups);
        return "[" + StringUtils.join(flatGroups, ' ') + "]";
    }

    private String buildFailureMessage(List<List<String>> actual, List<List<String>> expected) {
        return String.format(
                "expected anagrams %s\nactual anagrams %s",
                groupsToString(expected),
                groupsToString(actual));
    }
}
