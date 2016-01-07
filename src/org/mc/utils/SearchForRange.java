package org.mc.utils;

public class SearchForRange {
    public static class Range {
        private int start, stop;

        public Range(int start, int stop) {
            this.start = start;
            this.stop = stop;
        }

        public int getStart() {
            return start;
        }

        public int getStop() {
            return stop;
        }

        @Override
        public String toString() {
            return "Range{" +
                    "start=" + start +
                    ", stop=" + stop +
                    '}';
        }
    }


    public Range solve(int[] sortedArray, int value) {
        if (sortedArray.length < 1)
            return new Range(-1, -1);

        int lower = binarySearchFirst(sortedArray, 0, sortedArray.length, value);
        int upper = binarySearchLast(sortedArray, 0, sortedArray.length, value);

        return new Range(lower, upper);
    }

    private int binarySearchFirst(int[] array, int start, int stop, int value) {
        boolean found = false;

        while (start < stop) {
            int mid = (start + stop) / 2;

            if (array[mid] < value) {
                start = mid+1;
            }
            else {
                if (array[mid] == value)
                    found = true;

                stop = mid;
            }
        }

        return found ? start : (-1);
    }

    private int binarySearchLast(int[] array, int start, int stop, int value) {
        boolean found = false;

        while (start < stop) {
            int mid = (start + stop) / 2;

            if (array[mid] <= value) {
                if (array[mid] == value)
                    found = true;
                start = mid+1;
            }
            else {
                stop = mid;
            }
        }

        return found ? start-1 : (-1);
    }
}
