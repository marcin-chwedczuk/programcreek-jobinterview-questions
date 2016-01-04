package org.mc.utils;

import java.util.*;

public class LargestRectangleHistogram {
    public int solve(int[] histogram) {
        return solveStack(histogram);
    }

    public int solveN2(int[] histogram) {
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

    public int solveStack(int[] histogram) {
        Stack<Integer> limits = new Stack<>();
        int maxSize = 0;

        for (int i = 0; i <= histogram.length; i++) {
            int h = (i == histogram.length) ? 0 : histogram[i];

            while (!limits.empty() && histogram[limits.peek()] >= h) {
                int hIndex = limits.pop();

                int rectEnd = i - 1;
                int rectBegin = limits.empty() ? 0 : limits.peek()+1;
                int rectSize = (rectEnd - rectBegin + 1)*histogram[hIndex];

                maxSize = Math.max(maxSize, rectSize);
            }

            limits.push(i);
        }

        return maxSize;
    }
}
