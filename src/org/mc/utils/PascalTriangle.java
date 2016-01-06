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
}
