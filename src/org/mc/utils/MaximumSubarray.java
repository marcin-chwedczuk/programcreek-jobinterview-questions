package org.mc.utils;

public class MaximumSubarray {

    public static Subarray find(int[] numbers) {
        int sum = numbers[0], start = 0, end = 1;
        int max = sum, maxStart = start, maxEnd = end;

        while (end != numbers.length) {
            if (sum < 0 && start < end) {
                sum -= numbers[start];
                start++;
            }
            else {
                sum += numbers[end];
                end++;
            }

            if (sum > max && start < end) {
                maxStart = start;
                maxEnd = end;
                max = sum;
            }
        }

        // skip zeros
        while (maxStart < maxEnd-1 && numbers[maxStart] == 0) maxStart++;
        while (maxStart < maxEnd-1 && numbers[maxEnd-1] == 0) maxEnd--;

        return new Subarray(maxStart, maxEnd);
    }

    public static class Subarray {
        public int start;
        public int end;

        public Subarray(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return start + " " + end;
        }
    }
}
