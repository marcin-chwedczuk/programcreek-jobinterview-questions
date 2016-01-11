package org.mc.tests;

public final class SudokuUtils {
    public static int[][] toSudokuBoard(String boardString) {
        if (boardString == null)
            throw new NullPointerException("boardString");

        if(!boardString.matches("([1-9_]{3}\\|[1-9_]{3}\\|[1-9_]{3}){9}"))
            throw new IllegalArgumentException("boardString has invalid format.");

        String numericBoard = boardString
                .replace('_', '0')
                .replaceAll("\\|", "");

        int[][] board = new int[9][9];

        int next = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = numericBoard.charAt(next++) - '0';
            }
        }

        return board;
    }
}
