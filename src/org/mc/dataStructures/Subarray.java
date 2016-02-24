package org.mc.dataStructures;

public class Subarray {
    public int start;
    public int end;

    public Subarray(int start, int end) {
        if (start > end)
            throw new IllegalArgumentException("start must be <= end");

        this.start = start;
        this.end = end;
    }

    @Override
    public String toString() {
        return start + " " + end;
    }
}
