package org.mc.utils;

import java.util.Arrays;

public class UniquePaths2 {
    public int solve(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0)
            return 0;

        int rows = matrix.length;
        int cols = matrix[0].length;

        if (isObstacle(matrix[0][0]) || isObstacle(matrix[rows-1][cols-1]))
            return 0;

        int[] curr = new int[cols];
        boolean obstacle = false;

        for (int i = 0; i < cols; i++) {
            if (isObstacle(matrix[0][i]))
                obstacle = true;

            curr[i] = obstacle ? 0 : 1;
        }

        for (int r = 1; r < rows; r++) {
            curr[0] = isObstacle(matrix[r][0])
                    ? 0
                    : curr[0];

            for (int i = 1; i < cols; i++) {
                if (isObstacle(matrix[r][i]))
                    curr[i] = 0;
                else
                    curr[i] = curr[i-1] + curr[i];
            }
        }

        return curr[cols-1];
    }

    private static boolean isObstacle(int value) {
        return value == 1;
    }
}
