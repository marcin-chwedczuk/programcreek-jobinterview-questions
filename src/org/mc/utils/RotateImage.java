package org.mc.utils;

public class RotateImage {
    public void rotate(int[][] matrix) {
        transpose(matrix);
        flipHorizontally(matrix);
    }

    private void transpose(int[][] matrix) {
        int n = matrix.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n-i-1; j++) {
                int swap = matrix[i][j];
                matrix[i][j] = matrix[n-1-j][n-1-i];
                matrix[n-1-j][n-1-i] = swap;
            }
        }
    }

    private void flipHorizontally(int[][] matrix) {
        for (int c = 0; c < matrix.length; c++) {
            int top = 0, down = matrix.length-1;

            while (top < down) {
                int swap = matrix[top][c];
                matrix[top][c] = matrix[down][c];
                matrix[down][c] = swap;

                top++; down--;
            }
        }
    }
}
