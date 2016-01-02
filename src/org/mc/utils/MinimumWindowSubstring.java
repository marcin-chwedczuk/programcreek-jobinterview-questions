package org.mc.utils;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MinimumWindowSubstring {
    public String solve(String s, String t) {
        if (t.length() == 0)
            return "";

        Set<Character> tChars = new HashSet<>();
        Map<Character, Integer> counts = new HashMap<>();

        for(char c : t.toCharArray()) {
            tChars.add(c);
            updateCount(counts, c, -1);
        }

        int start = 0;
        int shortest = Integer.MAX_VALUE;
        int shortestStart = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (counts.containsKey(c)) {
                int newCount = counts.get(c) + 1;
                counts.put(c, newCount);

                if (newCount >= 0) {
                    tChars.remove(c);
                }
            }

            while (tChars.size() == 0) {
                if (tChars.size() == 0) {
                    if ((i+1-start) < shortest) {
                        shortest = i+1 - start;
                        shortestStart = start;
                    }
                }

                char cStart = s.charAt(start);

                if (counts.containsKey(cStart)) {
                    int newCount = counts.get(cStart) - 1;
                    counts.put(cStart, newCount);

                    if (newCount < 0) {
                        tChars.add(cStart);
                    }
                }

                start++;
            }
        }

        if (shortest == Integer.MAX_VALUE)
            return null;

        return s.substring(shortestStart, shortestStart + shortest);
    }

    private void updateCount(Map<Character,Integer> map, char key, int delta) {
        if (map.containsKey(key)) {
            map.put(key, map.get(key) + delta);
        }
        else {
            map.put(key, delta);
        }
    }
}
