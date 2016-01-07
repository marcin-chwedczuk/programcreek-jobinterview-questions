package org.mc.utils;

public class KthLargestElement {
    public int solve(int[] array, int kthLargest) {
        int start = 0;
        int stop = array.length;

        // kth is 1 based
        // n - nth element of sorted array
        int n = array.length - kthLargest;

        while (true) {
            int p = partition(array, start, stop);
            int pfs = p - start;

            if (pfs < n) {
                start = p + 1;
                n -= (pfs+1);
            }
            else if (pfs > n) {
               stop = p;
            }
            else {
                return array[p];
            }
        }
    }

    /*
      Returns index k such that array[<k] <= array[k] < array[>k]
     */
    private int partition(int[] array, int start, int stop) {
        int pivotValue = array[start];

        int last = start;
        for (int i = start+1; i < stop; i++) {
            if (array[i] <= pivotValue)
                swap(array, i, ++last);
        }

        swap(array, start, last);
        return last;
    }

    private void swap(int[] array, int i, int j) {
        int swap = array[i];
        array[i] = array[j];
        array[j] = swap;
    }
}
