package org.mc.utils;

import java.util.*;

public class LargestNumber {
    public String solve(int[] numbers) {
        List<String> strings = new ArrayList<>();

        for(int num : numbers) {
            strings.add(String.valueOf(num));
        }

        // TODO: Find a proof of this algorithm

        Collections.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String o12 = o1 + o2;
                String o21 = o2 + o1;

                return -o12.compareTo(o21);
            }
        });

        StringBuilder sb = new StringBuilder();

        for(String s : strings) {
            sb.append(s);
        }

        return sb.toString();
    }
}
