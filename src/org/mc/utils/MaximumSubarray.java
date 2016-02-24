package org.mc.utils;

import org.mc.dataStructures.Subarray;

public class MaximumSubarray {
    public static Subarray find(int[] numbers) {
        int sum = numbers[0], start = 0;
        int max = sum, maxStart = start, maxEnd = start+1;

        for (int i = 1; i < numbers.length; i++) {
            sum += numbers[i];
            if (sum <= numbers[i]) {
                start = i;
                sum = numbers[i];
            }

            if (max < sum) {
                max = sum;
                maxStart = start;
                maxEnd = i+1;
            }
        }

        return new Subarray(maxStart, maxEnd);
    }
}
