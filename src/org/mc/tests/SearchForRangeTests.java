package org.mc.tests;

import org.mc.utils.SearchForRange;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;

public class SearchForRangeTests {
    @Test(dataProvider = "searchForRange")
    public void search_for_range_works(int[] sortedArray, int value, SearchForRange.Range expectedRange) {
        String failureMessage = "failed for array " + Arrays.toString(sortedArray) + " and element " + value;

        SearchForRange.Range actualRange = new SearchForRange().solve(sortedArray, value);

        Assert.assertEquals(actualRange.getStart(), expectedRange.getStart(), failureMessage);
        Assert.assertEquals(actualRange.getStop(), expectedRange.getStop(), failureMessage);
    }

    @DataProvider(name = "searchForRange")
    public Object[][] searchForRangeProvider() {
        return new Object[][] {
                // empty array
                {
                        new int[] { },
                        7,
                        new SearchForRange.Range(-1, -1)
                },

                // single value in array
                {
                        new int[] { 1, 1, 1, 1, 1 },
                        1,
                        new SearchForRange.Range(0, 4)
                },

                {
                        new int[] { 1,1,1,1,1 },
                        2,
                        new SearchForRange.Range(-1, -1)
                },

                // range at array beginning
                {
                        new int[] { 3,3,3,3, 4, 5, 6, 7 },
                        3,
                        new SearchForRange.Range(0, 3)
                },

                // range at array ending
                {
                        new int[] { 1, 2, 3, 4,4,4,4 },
                        4,
                        new SearchForRange.Range(3,6)
                },

                // range in the middle
                {
                        new int[] { 1, 2, 3, 4,4,4, 6, 89, 101 },
                        4,
                        new SearchForRange.Range(3, 5)
                },

                // example from problem
                {
                        new int[] { 5, 7, 7, 8, 8, 10 },
                        8,
                        new SearchForRange.Range(3, 4)
                },

                // range not in array - value in middle
                {
                        new int[] { 1, 2, 3, 4, 6, 8 },
                        5,
                        new SearchForRange.Range(-1, -1)
                },

                // range not in array - value less than array[0]
                {
                        new int[] { 2, 3, 4, 5, 6, 7 },
                        1,
                        new SearchForRange.Range(-1, -1)
                },

                // range not in array - value greater than array[array.length-1]
                {
                        new int[] { 1, 2, 3, 4, 5, 6, 8 },
                        9,
                        new SearchForRange.Range(-1, -1)
                }
        };
    }
}
