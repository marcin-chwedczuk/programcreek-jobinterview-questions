package org.mc.utils;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {

    public int[][] solve(int rowsCount) {
        int[][] rows = new int[rowsCount][];

        for (int row = 0; row < rowsCount; row++) {
            int[] r = rows[row] = new int[row+1];

            r[0] = 1;
            r[row] = 1;

            for (int col = 1; col < row; col++) {
                r[col] = rows[row-1][col-1] + rows[row-1][col];
            }
        }

        return rows;
    }

    public int[] generateRow(int row) {
        int[] curr = new int[row];
        int[] last = new int[row];

        for (int i = 0; i < row; i++) {

            curr[0] = curr[i] = 1;
            for (int j = 1; j < i; j++) {
                curr[j] = last[j-1] + last[j];
            }

            int[] swap = curr; curr = last; last = swap;
        }

        return last;
    }
}
