package org.mc.utils;

import org.apache.commons.lang3.ArrayUtils;

public class Search2DMatrix {

    public Result solve(int[][] matrix, int value) {
        if (matrix.length == 0 || matrix[0].length == 0)
            return Result.notFound();

        int rowIndex = binarySearch(matrix, 0, matrix.length, value, new IBinarySearchComparer<int[], Integer>() {
            @Override
            public int compare(int[] arrayItem, Integer searchedValue) {
                return Integer.compare(arrayItem[0], searchedValue);
            }
        });

        if (rowIndex < 0)
            return Result.notFound();

        int colIndex = binarySearch(ArrayUtils.toObject(matrix[rowIndex]), 0, matrix[rowIndex].length, value, new IBinarySearchComparer<Integer, Integer>() {
            @Override
            public int compare(Integer arrayItem, Integer searchedValue) {
                return Integer.compare(arrayItem, searchedValue);
            }
        });

        if (colIndex < 0 || matrix[rowIndex][colIndex] != value)
            return Result.notFound();

        return Result.fromIndexes(rowIndex, colIndex);
    }

    private <T, U> int binarySearch(T[] array, int start, int end, U value, IBinarySearchComparer<T,U> comparer) {
        while (start < end) {
            int mid = (start + end) / 2;

            int cmp = comparer.compare(array[mid], value);
            if (cmp == 0) {
                return mid;
            }
            else if (cmp > 0) {
                end = mid;
            }
            else {
                start = mid + 1;
            }
        }

        return start-1;
    }

    private interface IBinarySearchComparer<T,U> {
        int compare(T arrayItem, U searchedValue);
    }

    public static class Result {
        private int _row;
        private int _col;

        private Result() {
            _row = _col = (-1);
        }

        private Result(int row, int col) {
            if (row < 0)
                throw new IllegalArgumentException("row must be >= 0.");

            if (col < 0)
                throw new IllegalArgumentException("col must be >= 0.");

            _row = row;
            _col = col;
        }

        public boolean found() {
            return (_row >= 0 && _col >= 0);
        }

        public int row() {
            throwWhenNotFound();
            return _row;
        }

        public int col() {
            throwWhenNotFound();
            return _col;
        }

        private void throwWhenNotFound() {
            if (!found())
                throw new IllegalStateException("element was not found");
        }

        @Override
        public String toString() {
            return found() ? String.format("%d %d", row(), col()) : "not found";
        }

        public static Result notFound() {
            return new Result();
        }

        public static Result fromIndexes(int row, int col) {
            return new Result(row, col);
        }
    }
}
