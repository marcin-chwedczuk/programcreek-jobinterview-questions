package org.mc.tests;

public final class MatrixUtils {
    // [ 1, 2, 3
    //   4, 4, 6
    //   7, 8, 9 ]
    public static String toMatrixString(int[][] m) {
        StringBuilder sb = new StringBuilder();

        int rows = m.length;
        int cols = (rows == 0) ? 0 : m[0].length;

        for(int r = 0; r < rows; r++) {
            if (r == 0) {
                sb.append("[ ");
            }
            else {
                sb.append("  ");
            }

            for (int c = 0; c < cols; c++) {
                sb.append(m[r][c]);

                if (c != (cols-1))
                    sb.append(", ");
            }

            if (r != (rows-1)) {
                sb.append("\n");
            }
            else {
                sb.append(" ]");
            }
        }

        return sb.toString();
    }

    public static int[][] m(int[]... rows) {
        int[][] matrix = new int[rows.length][];

        for (int r = 0; r < rows.length; r++) {
            matrix[r] = rows[r];
        }

        return matrix;
    }

    public static int[] row(int... items) {
        int[] row = new int[items.length];

        for (int c = 0; c < items.length; c++) {
            row[c] = items[c];
        }

        return row;
    }
}
