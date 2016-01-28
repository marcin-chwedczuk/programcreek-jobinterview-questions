package org.mc.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class RegexUtils {
    private RegexUtils() { }

    // given input "(foo,bar) (bar,bar)" " " "\((?<first>\w+),(?<second>\w+)\)"
    // returns [ ["foo","bar"], ["bar","bar"] ]
    public static List<List<String>> splitAndMatch(String input, String splitRegex, String matchRegex) {
        List<List<String>> result = new ArrayList<>();

        String[] parts = input.split(splitRegex);

        Pattern pattern = Pattern.compile(matchRegex);
        for (String part : parts) {
            if (part.isEmpty()) continue;

            result.add(getGroupsValues(part, pattern));
        }

        return result;
    }

    public static List<String> getGroupsValues(String input, Pattern pattern) {
        List<String> groupValues = new ArrayList<>();

        Matcher m = pattern.matcher(input);
        while (m.find()) {
            // first group is for entire match
            for (int i = 1; i <= m.groupCount(); i++)
                groupValues.add(m.group(i));
        }

        return groupValues;
    }
}
