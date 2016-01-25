package org.mc.utils;

import org.apache.commons.lang3.ObjectUtils;

public class MaximalRectangle {
    private final char[][] matrix;
    private final int[][] h;

    private final int rows;
    private final int cols;

    public MaximalRectangle(char[][] matrix) {
        if (matrix == null)
            throw new NullPointerException("matrix cannot be null");

        this.matrix = matrix;
        this.rows = matrix.length;
        this.cols = (this.rows == 0) ? 0 : matrix[0].length;

        this.h = createHeightTable(matrix, rows, cols);
    }

    public int solve() {
        int maxSize = 0;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (isOne(matrix[r][c])) {
                    int size = maxSizeOfRectangleStartingFrom(r, c);
                    maxSize = Math.max(size, maxSize);
                }
            }
        }

        return maxSize;
    }

    private int maxSizeOfRectangleStartingFrom(int r, int c) {
        int height = h[r][c];
        int width = 1;

        int size = 0;

        while (true) {
            int currSize = width * height;
            size = Math.max(size, currSize);

            if (c + width >= cols)
                break;

            height = Math.min(height, h[r][c+width]);
            width += 1;
        }

        return size;
    }

    private int[][] createHeightTable(char[][] matrix, int rows, int cols) {
        // h[i][j] - length of consecutive sequence of 1's
        // in column starting form (i,j) (including starting point)
        int[][] h = new int[rows][cols];

        // last row
        for (int c = 0; c < cols; c++) {
            h[rows-1][c] = isOne(matrix[rows-1][c]) ? 1 : 0;
        }

        // dynamic programming - move up
        for (int r = rows-2; r >= 0; r--) {
            for (int c = 0; c < cols; c++) {
                h[r][c] = isOne(matrix[r][c])
                        ? 1 + h[r+1][c]
                        : 0;
            }
        }

        return h;
    }

    private static boolean isOne(char c) {
        return (c == '1');
    }
}
