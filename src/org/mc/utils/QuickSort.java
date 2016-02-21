package org.mc.utils;

public class QuickSort {
    public static void sort(int[] values) {
        sortImpl(values, 0, values.length);
    }

    private static void sortImpl(int[] values, int start, int end) {
        if (start+1 >= end)
            return;

        int mid = (start+end)/2;
        int tmp = values[start]; values[start] = values[mid]; values[mid] = tmp;
        int pivot = values[start];

        // pivot | less than pivot (next) | processed part of array (i) | unprocessed part of array
        int next = start+1;
        for (int i = start+1; i < end; i++) {
            if (values[i] < pivot) {
                tmp = values[i]; values[i] = values[next]; values[next] = tmp;
                next++;
            }
        }

        // move pivot to values[start]
        tmp = values[start]; values[start] = values[next-1]; values[next-1] = tmp;

        sortImpl(values, start, next-1);
        sortImpl(values, next, end);
    }
}
