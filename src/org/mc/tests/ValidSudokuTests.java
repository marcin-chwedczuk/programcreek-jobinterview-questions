package org.mc.tests;

import org.mc.utils.ValidSudoku;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ValidSudokuTests {
    @Test(dataProvider = "validSudoku")
    public void valid_sudoku_works(int[][] sudokuBoard, boolean expectedIsValid) {
        boolean actualIsValid = new ValidSudoku().isValid(sudokuBoard);

        Assert.assertEquals(actualIsValid, expectedIsValid,
                "failed for sudoku board: " + MatrixUtils.toMatrixString(sudokuBoard));
    }

    @DataProvider(name = "validSudoku")
    public Object[][] validSudokuProvider() {
        return new Object[][] {
                // valid board
                {
                    SudokuUtils.toSudokuBoard(
                            "53_|_7_|___" +
                            "6__|195|___" +
                            "_98|___|_6_" +

                            "8__|_6_|__3" +
                            "4__|8_3|__1" +
                            "7__|_2_|__6" +

                            "_6_|___|28_" +
                            "___|419|__5" +
                            "___|_8_|_79"),

                    true
                },

                // repeated number in row
                {
                    SudokuUtils.toSudokuBoard(
                            "53_|_7_|___" +
                            "6__|195|___" +
                            "_98|___|_6_" +

                            "8__|_6_|__8" + // repeated number
                            "4__|8_3|__1" +
                            "7__|_2_|__6" +

                            "_6_|___|28_" +
                            "___|419|__5" +
                            "___|_8_|_79"),

                    false
                },

                // repeated number in column
                {
                    SudokuUtils.toSudokuBoard(
                            "53_|_7_|___" +
                            "6__|195|___" +
                            "598|___|_6_" +

                            "8__|_6_|__3" +
                            "4__|8_3|__1" +
                            "7__|_2_|__6" +

                            "_6_|___|28_" +
                            "___|419|__5" +
                            "___|_8_|_79"),

                    false
                },

                // repeated number in box
                {
                    SudokuUtils.toSudokuBoard(
                            "53_|_7_|___" +
                            "6_3|195|___" +
                            "_98|___|_6_" +

                            "8__|_6_|__3" +
                            "4__|8_3|__1" +
                            "7__|_2_|__6" +

                            "_6_|___|28_" +
                            "___|419|__5" +
                            "___|_8_|_79"),

                    false
                },

        };
    }
}
