package org.mc.utils;

import java.util.*;

public class Anagrams {
    public List<List<String>> solve(String[] input) {
        if (input.length == 0)
            return new ArrayList<>();

        final String[] keys = new String[input.length];
        Integer[] indexes = new Integer[input.length];

        for (int i = 0; i < input.length; i++) {
            char[] chars = input[i].toCharArray();
            Arrays.sort(chars);
            keys[i] = new String(chars);
            indexes[i] = i;
        }

        Arrays.sort(indexes, new Comparator<Integer>() {
            @Override
            public int compare(Integer i1, Integer i2) {
                return keys[i1].compareTo(keys[i2]);
            }
        });

        List<List<String>> groups = new ArrayList<>();

        List<String> current = new ArrayList<>();
        current.add(input[indexes[0]]);

        for (int i = 1; i < input.length; i++) {
            if (!keys[indexes[i]].equals(keys[indexes[i-1]])) {
                // new element found
                groups.add(current);
                current = new ArrayList<>();
            }

            current.add(input[indexes[i]]);
        }

        groups.add(current);
        return groups;
    }
}
