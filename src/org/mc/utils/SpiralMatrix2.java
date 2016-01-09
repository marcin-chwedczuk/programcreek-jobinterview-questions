package org.mc.utils;

public class SpiralMatrix2 {
    public int[][] solve(int n) {
        int[][] m = new int[n][n];

        int offset = 0;
        int next = 1;

        while (n > 0) {
            if (n == 1) {
                m[offset][offset] = next++;
                break;
            }

            // ->
            for (int i = offset; i < offset+n; i++)
                m[offset][i] = next++;

            // down
            for (int i = offset+1; i < offset+n-1; i++)
                m[i][offset+n-1] = next++;

            // <-
            for (int i = offset+n-1; i >= offset; i--)
                m[offset+n-1][i] = next++;

            // up
            for (int i = offset+n-2; i >= offset+1; i--)
                m[i][offset] = next++;

            n -= 2;
            offset += 1;
        }

        return m;
    }
}
