package org.mc.tests;

import org.mc.utils.CountNSay;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CountNSayTests {
    @Test(dataProvider = "countNSay")
    public void count_n_say_works(int n, String expectedAnswer) {
        String actualAnswer = new CountNSay().solve(n);
        Assert.assertEquals(actualAnswer, expectedAnswer);
    }

    @DataProvider(name = "countNSay")
    public Object[][] countNSayProvider() {
        return new Object[][] {
                { 0, "1" },
                { 1, "11" },
                { 2, "21" },
                { 3, "1211" },
                { 4, "111221" },
                { 5, "312211" },
                { 6, "13112221" },
                { 7, "1113213211" }
        };
    }
}
