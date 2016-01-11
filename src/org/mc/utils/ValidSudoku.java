package org.mc.utils;

import java.util.Arrays;

public class ValidSudoku {
    // 0 means empty space, only number 1-9 are valid
    public boolean isValid(int[][] sudokuBoard) {
        int n = sudokuBoard.length;
        boolean[] visited = new boolean[n+1];

        // check rows
        for (int r = 0; r < n; r++) {
            Arrays.fill(visited, false);

            for (int c = 0; c < n; c++) {
                if (sudokuBoard[r][c] > 0 && visited[sudokuBoard[r][c]])
                    return false;

                visited[sudokuBoard[r][c]] = true;
            }
        }

        // check cols
        for (int c = 0; c < n; c++) {
            Arrays.fill(visited, false);

            for (int r = 0; r < n; r++) {
                if (sudokuBoard[r][c] > 0 && visited[sudokuBoard[r][c]])
                    return false;

                visited[sudokuBoard[r][c]] = true;
            }
        }

        // check boxes
        int boxSize = n / 3;

        for (int bx = 0; bx < 3; bx++) {
            for(int by = 0; by < 3; by++) {
                int boxX = bx * boxSize;
                int boxY = by * boxSize;

                Arrays.fill(visited, false);

                for (int r = boxX; r < boxX+boxSize; r++) {
                    for (int c = boxY; c < boxY+boxSize; c++) {
                        if (sudokuBoard[r][c] > 0 && visited[sudokuBoard[r][c]])
                            return false;

                        visited[sudokuBoard[r][c]] = true;
                    }
                }
            }
        }

        return true;
    }
}
