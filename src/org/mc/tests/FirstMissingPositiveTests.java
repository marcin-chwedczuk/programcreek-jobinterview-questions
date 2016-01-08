package org.mc.tests;

import org.mc.utils.FirstMissingPositive;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FirstMissingPositiveTests {
    @Test(dataProvider = "firstMissingPositive")
    public void first_missing_positive_works(int[] numbers, int expectedMissingPositive) {
        int actualMissingPositive = new FirstMissingPositive().solve(numbers);
        Assert.assertEquals(actualMissingPositive, expectedMissingPositive);
    }

    @DataProvider(name = "firstMissingPositive")
    public Object[][] firstMissingPositiveProvider() {
        return new Object[][] {
                // empty array
                {
                        new int[] { },
                        1
                },

                // examples from problem description
                {
                        new int[] { 1, 2, 0 },
                        3
                },

                {
                        new int[] { 3, 4, -1, 1 },
                        2
                },

                // sorted and reverse sorted arrays
                {
                        new int[] { 1, 2, 3, 4, 6 },
                        5
                },

                {
                        new int[] { 6, 4, 3, 2, 1 },
                        5
                },

                // 1 is missing
                {
                        new int[] { -1, -2, -3 },
                        1
                },

                {
                        new int[] { 2, 3, 4 },
                        1
                },

                // all numbers negative or zeros
                {
                        new int[] { -1, -2, -3 },
                        1
                },

                {
                        new int[] { 0, 0, 0 },
                        1
                },

                // same number
                {
                        new int[] { 1, 1, 1, 1 },
                        2
                },

                // some random examples
                {
                        new int[] { 3, -2, 1, 3, 5, 4, 7 },
                        2
                },

                {
                        new int[] { 3, 2, 1, 2, 7, 4, 5 },
                        6
                }
        };
    }
}
