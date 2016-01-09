package org.mc.utils;

import java.util.List;

public class SpiralMatrix {
    public int[] solve(int[][] matrix) {
        int rOffset = 0, cOffset = 0;
        int rows = matrix.length, cols = (rows == 0) ? 0 : matrix[0].length;

        int[] result = new int[rows * cols];
        int next = 0;

        while (rows > 0 && cols > 0) {
            if (cols == 1) {
                for (int i = rOffset; i < rOffset+rows; i++)
                    result[next++] = matrix[i][cOffset];
                break;
            }

            // ->
            for (int i = cOffset; i < cOffset+cols; i++)
                result[next++] = matrix[rOffset][i];

            if (rows == 1) break;

            // down
            for (int i = rOffset+1; i < rOffset+rows-1; i++) {
                result[next++] = matrix[i][cOffset+cols-1];
            }

            // <-
            for (int i = cOffset+cols-1; i >= cOffset; i--) {
                result[next++] = matrix[rOffset+rows-1][i];
            }

            // up
            for (int i = rOffset+rows-2; i > rOffset; i--) {
                result[next++] = matrix[i][cOffset];
            }

            rows -= 2; cols -= 2;
            rOffset++; cOffset++;
        }

        return result;
    }
}
