package org.mc.utils;

import java.util.Stack;

public class MostWaterContainer {
    public static class Solution {
        private int start;
        private int stop;

        public Solution(int start, int stop) {
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
            return String.format("%d - %d", start, stop);
        }
    }

    public static class Boundary {
        private int height;
        private int index;

        public Boundary(int height, int index) {
            this.height = height;
            this.index = index;
        }

        public int getHeight() {
            return height;
        }

        public int getIndex() {
            return index;
        }
    }

    public Solution solve(int[] heights) {
        Stack<Boundary> boundaries = new Stack<>();

        for(int i = 0; i < heights.length; i++) {
            int h = heights[i];

            while (isConcave(boundaries, h))
                boundaries.pop();

            boundaries.push(new Boundary(h, i));
        }

        Boundary[] b = boundaries.toArray(new Boundary[boundaries.size()]);

        int left = 0, right = b.length-1;
        int maxSize = 0;
        Boundary bestLeft = null, bestRight = null;

        while (left < right) {
            int currentSize = getSize(b[left], b[right]);
            if (currentSize > maxSize) {
                bestLeft = b[left];
                bestRight = b[right];
                maxSize = currentSize;
            }

            if (b[left].getHeight() < b[right].getHeight()) {
                left++;
            }
            else {
                right--;
            }
        }

        return new Solution(bestLeft.getIndex(), bestRight.getIndex());
    }

    private int getSize(Boundary left, Boundary right) {
        return (right.getIndex() - left.getIndex()) * Math.min(left.getHeight(), right.getHeight());
    }

    private boolean isConcave(Stack<Boundary> boundaries, int h) {
        if (boundaries.size() < 2)
            return false;

        Boundary lastElement = boundaries.pop();
        try {
            if (boundaries.peek().getHeight() >= lastElement.getHeight() && lastElement.getHeight() <= h) {
                return true;
            }
            else {
                return false;
            }
        }
        finally {
            boundaries.push(lastElement);
        }
    }
}
