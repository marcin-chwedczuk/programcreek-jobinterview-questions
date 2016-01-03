package org.mc.utils;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LargestRectangleHistogram {
    public int solve(int[] histogram) {
        int largest = -1;
        Map<Integer, Integer> sizes= new HashMap<>();

        // key - height, sizes[key] - number of stripes that has h >= height

        for (int aHistogram : histogram)
            sizes.put(aHistogram, 0);

        for (int i = 0; i <= histogram.length; i++) {
            int h = (i == histogram.length) ? 0 : histogram[i];

            for(Map.Entry<Integer, Integer> e : sizes.entrySet()) {
                if (e.getKey() <= h) {
                    e.setValue(e.getValue() + 1);
                }
                else {
                    largest = Math.max(largest, e.getValue()*e.getKey());
                    e.setValue(0);
                }
            }
        }

        return largest;
    }
}
