package org.mc.utils;

public class FindPeakElement {
    public int solve(int[] array) {
        if (array.length == 1 || array[0] > array[1])
            return 0;

        for (int i = 1; i < array.length-1; i++) {
            if (array[i-1] < array[i] && array[i] > array[i+1])
                return i;
        }

        if (array[array.length-1] > array[array.length-2])
            return array.length-1;

        return -1;
    }
}
