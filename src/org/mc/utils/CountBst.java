package org.mc.utils;

public class CountBst {
    public static int withElements(int n) {
        int[] counts = new int[Math.max(2, n+1)];
        counts[0] = counts[1] = 1;

        for (int i = 2; i <= n; i++) {
            int countI = 0;
            for (int leftSubtreeCount = 0; leftSubtreeCount < i; leftSubtreeCount++) {
                int rightSubtreeCount = i - leftSubtreeCount - 1;
                countI += counts[leftSubtreeCount] * counts[rightSubtreeCount];
            }
            counts[i] = countI;
        }

        return counts[n];
    }
}
