package org.mc.utils;

public class MaxGap {
    public static int getFor(int[] values) {
        if (values.length < 2)
            return 0;

        int min = values[0];
        int max = values[0];

        for (int i = 1; i < values.length; i++) {
            min = Math.min(min, values[i]);
            max = Math.max(max, values[i]);
        }

        // idea map min-max to 0-1
        // on 0-1 interval there must be difference >= 1/n
        // group values closer to each other than 1/n into buckets
        // compare difference between buckets

        long scale = max - min;

        Bucket[] buckets = new Bucket[values.length+1];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new Bucket();
        }

        for (int i = 0; i < values.length; i++) {
            int v = values[i];
            int bucketIndex = (int)((values.length * (v - min)) / scale);
            buckets[bucketIndex].addValue(v);
        }

        // find largest gap
        Bucket prev = null;
        int maxGap = 0;

        for (int i = 0; i < buckets.length; i++) {
            if (prev != null && buckets[i].hasValue()) {
                maxGap = Math.max(maxGap, buckets[i].low - prev.high);
            }

            if (buckets[i].hasValue())
                prev = buckets[i];
        }

        return maxGap;
    }

    private static class Bucket {
        int low, high;

        Bucket() {
            low = high = -1;
        }

        void addValue(int value) {
            if (low == -1) {
                low = high = value;
            }
            else {
                low = Math.min(low, value);
                high = Math.max(high, value);
            }
        }

        boolean hasValue() {
            return (low != -1);
        }
    }
}
