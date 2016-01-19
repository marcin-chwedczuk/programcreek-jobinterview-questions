package org.mc.tests;

public final class MatrixUtils {
    // [ 1, 2, 3
    //   4, 4, 6
    //   7, 8, 9 ]
    public static String toMatrixString(final int[][] m) {
        return toMatrixString(new IMatrix<Integer>() {
            @Override
            public int rows() {
                return m.length;
            }

            @Override
            public int cols() {
                return m[0].length;
            }

            @Override
            public Integer get(int row, int col) {
                return m[row][col];
            }
        });
    }

    public static String toMatrixString(final char[][] m) {
        return toMatrixString(new IMatrix<Character>() {
            @Override
            public int rows() {
                return m.length;
            }

            @Override
            public int cols() {
                return m[0].length;
            }

            @Override
            public Character get(int row, int col) {
                return m[row][col];
            }
        });
    }

    private static <Type> String toMatrixString(IMatrix<Type> m) {
        StringBuilder sb = new StringBuilder();

        int rows = m.rows();
        int cols = (rows == 0) ? 0 : m.cols();

        for(int r = 0; r < rows; r++) {
            if (r == 0) {
                sb.append("[ ");
            }
            else {
                sb.append("  ");
            }

            for (int c = 0; c < cols; c++) {
                sb.append(m.get(r,c));

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

    private interface IMatrix<Type> {
        int rows();
        int cols();

        Type get(int row, int col);
    }

    public static int[][] m(int[]... rows) {
        int[][] matrix = new int[rows.length][];

        for (int r = 0; r < rows.length; r++) {
            matrix[r] = rows[r];
        }

        return matrix;
    }

    public static char[][] cm(String... rows) {
        char[][] matrix = new char[rows.length][];

        for (int r = 0; r < rows.length; r++) {
            matrix[r] = rows[r].toCharArray();
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
