package org.mc.utils;

import org.mc.dataStructures.Subarray;

public class MaximumProductSubarray {
    public static Subarray find(int[] array) {
        if (array.length < 2)
            return new Subarray(0, array.length);

        long[] products = new long[array.length];
        long maxProd = -1;
        int maxStart = 0, maxEnd = 0;

        for (int i = 0; i < array.length; i++) {
            int prod = 1, start = i;
            int firstNegative = -1, lastNegative = -1;

            while (i < array.length && array[i] != 0) {
                if (array[i] < 0) {
                    if (notSet(firstNegative))
                        firstNegative = i;
                    lastNegative = i;
                }

                prod = prod * array[i];
                products[i] = prod;

                i++;
            }

            int end = i;
            if (start == end) continue;

            long chunkMaxProd;
            if (products[end-1] > 0) {
                chunkMaxProd = products[end-1];
            }
            else if (start+1 == end) {
                // single element
                chunkMaxProd = products[firstNegative];
            }
            else {
                long pf = products[lastNegative-1];
                long pl = products[end-1] / products[firstNegative];

                if (pf >= pl) {
                    chunkMaxProd = pf;
                    end = lastNegative;
                }
                else {
                    chunkMaxProd = pl;
                    start = firstNegative+1;
                }
            }

            if (chunkMaxProd > maxProd) {
                maxProd = chunkMaxProd;
                maxStart = start;
                maxEnd = end;
            }
        }

        // array full of zeros
        if (maxStart == maxEnd)
            return new Subarray(0, 1);

        return new Subarray(maxStart, maxEnd);
    }

    private static boolean notSet(int value) {
        return (value == -1);
    }
}
