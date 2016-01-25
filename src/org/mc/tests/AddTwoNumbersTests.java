package org.mc.tests;

import org.mc.utils.AddTwoNumbers;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.LinkedList;

public class AddTwoNumbersTests {
    @Test(dataProvider = "addTwoNumbers")
    public void add_two_numbers_works(int first, int second, int expectedSum) {
        LinkedList<Integer> actualSum = new AddTwoNumbers().solve(
                numberToList(first),
                numberToList(second));

        Assert.assertEquals(
                ListUtils.toListString(actualSum),
                ListUtils.toListString(numberToList(expectedSum)),
                String.format("Failed for %d and %d", first, second));
    }

    @DataProvider(name = "addTwoNumbers")
    public Object[][] addTwoNumbersProvider() {
        return new Object[][] {
                { 0, 0, 0 },
                { 1, 0, 1 },
                { 0, 1, 1 },

                { 9, 2, 11 },
                { 99, 11, 110 },
                { 55, 55, 110 },
                { 17, 34, 51 },
                { 99999, 1, 100000 },
                { 33123, 5432, 33123+5432 }
        };
    }

    private LinkedList<Integer> numberToList(int number) {
        LinkedList<Integer> result = new LinkedList<>();

        while (number > 0) {
            result.addLast(number % 10);
            number /= 10;
        }

        if (result.isEmpty())
            result.addLast(0);

        return result;
    }
}
