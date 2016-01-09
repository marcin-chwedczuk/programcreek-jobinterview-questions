package org.mc.utils;

public class FirstMissingPositive {
    public int solve(int[] a) {
        if (a.length == 0)
            return 1;

        // in 1-based arrays:
        // if a[i] != i then swap a[i], a[a[i]]
        // (of course only if a[i] is valid index, we
        //  want to end up with array that has property a[i] = i,
        //  for every positive integer in that array).

        for (int i = 1; i <= a.length; i++) {
            int index = i-1;

            while (a[index] != i && canIndex(a, a[index]-1) && a[a[index]-1] != a[index])
                swap(a, index, a[index]-1);
        }

        for (int i = 0; i < a.length; i++) {
            if (a[i] != (i+1))
                return (i+1);
        }

        return 0;
    }

    private boolean canIndex(int[] array, int index) {
        return index >= 0 && index < array.length;
    }

    private void swap(int[] array, int i, int j) {
        int swap = array[i];
        array[i] = array[j];
        array[j] = swap;
    }
}
