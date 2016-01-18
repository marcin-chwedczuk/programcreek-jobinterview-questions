package org.mc.utils;

import java.util.Arrays;

public class UniquePaths {
    public int solve(int rows, int cols) {
        if (rows <= 0 || cols <= 0)
            return 0;

        return solveNewton(rows, cols);
    }

    private int solveDynamicProgramming(int rows, int cols) {
        int[] curr = new int[cols];
        Arrays.fill(curr, 1);

        for (int r = 1; r < rows; r++) {
            for (int i = 1; i < cols; i++) {
                curr[i] = curr[i-1] + curr[i];
            }
        }

        return curr[cols-1];
    }

    private int solveNewton(int rows, int cols) {
        int totalSteps = (rows-1) + (cols-1);
        int stepsDown = (rows-1);

        return (int) Combinatorial.newton(totalSteps, stepsDown);
    }
}
