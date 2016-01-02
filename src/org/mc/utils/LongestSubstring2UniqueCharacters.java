package org.mc.utils;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstring2UniqueCharacters {
    public String solution(String input) {
        if (input.length() <= 2)
            return input;

        Map<Character, Integer> counts = new HashMap<>();

        int start = 0;
        int longest = 0;
        int longestStart = 0;

        for (int i = 0; i < input.length(); i++) {
            // update counts
            char c = input.charAt(i);
            if (counts.containsKey(c)) {
                counts.put(c, counts.get(c) + 1);
            }
            else {
                counts.put(c, 1);
            }

            while (counts.size() > 2) {
                char cStart = input.charAt(start);

                int newCount = counts.get(cStart) - 1;
                if (newCount == 0)
                    counts.remove(cStart);
                else
                    counts.put(cStart, newCount);

                start++;
            }

            if ((i+1 - start) > longest) {
                longestStart = start;
                longest = i+1 - start;
            }
        }

        return input.substring(longestStart, longestStart + longest);
    }
}
