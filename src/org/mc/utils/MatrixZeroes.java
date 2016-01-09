package org.mc.utils;

public class MatrixZeroes {
    public void solve(int[][] matrix) {
        int rows = matrix.length;
        if (rows == 0) return;

        int cols = matrix[0].length;
        if (cols == 0) return;

        int[] rZeros = new int[rows];
        int[] cZeros = new int[cols];

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (matrix[r][c] == 0) {
                    rZeros[r] = 1;
                    cZeros[c] = 1;
                }
            }
        }

        // zero rows
        for (int r = 0; r < rows; r++) {
            if (rZeros[r] == 1) {
                for (int c = 0; c < cols; c++) {
                    matrix[r][c] = 0;
                }
            }
        }

        // zero cols
        for (int c = 0; c < cols; c++) {
            if (cZeros[c] == 1) {
                for (int r = 0; r < rows; r++) {
                    matrix[r][c] = 0;
                }
            }
        }
    }
}
