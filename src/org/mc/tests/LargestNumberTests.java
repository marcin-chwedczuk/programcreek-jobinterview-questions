package org.mc.tests;

import org.mc.utils.LargestNumber;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LargestNumberTests {
    @Test(dataProvider = "largestNumberWorks")
    public void largest_number_works(int[] numbers, String expectedAnswer) {
        String actualAnswer = new LargestNumber().solve(numbers);
        Assert.assertEquals(actualAnswer, expectedAnswer);
    }

    @DataProvider(name = "largestNumberWorks")
    public Object[][] largestNumberWorks() {
        return new Object[][] {
                // single digit numbers
                {
                        new int[] { 9, 9, 3, 2, 1, 8, 5, 1 },
                        "99853211"
                },

                // numbers that are prefixes of other numbers
                {
                        new int[] { 9, 90, 900, 9000 },
                        "9909009000"
                },

                // numbers without prefixes
                {
                        new int[] { 11, 23, 55, 90, 47 },
                        "9055472311"
                },

                // various test cases
                {
                        new int[] { 5, 9, 500, 9910, 99 },
                        "99999105500"
                },

                {
                        new int[] { 1, 2, 3, 4, 5 },
                        "54321"
                },

                {
                        new int[] { 101, 2, 32, 12, 112 },
                        "32212112101"
                },

                {
                        new int[] { 3, 30, 34, 5, 9 },
                        "9534330"
                },

                // bug 1
                {
                        new int[] { 95, 9599 },
                        "959995"
                }
        };
    }
}
