package org.mc.tests;

import org.mc.utils.EditDistance;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class EditDistanceTests {
    @Test(dataProvider = "editDistance")
    public void edit_dist_works(String a, String b, int editDist) {
        int actualEditDist = EditDistance.compute(a, b);

        Assert.assertEquals(actualEditDist, editDist, "failed for: '" + a + "', '" + b + "'");
    }

    @DataProvider(name = "editDistance")
    public Object[][] editDistanceProvider() {
        return new Object[][] {
                {
                        "", "", 0
                },

                {
                        "foo", "", 3
                },

                {
                        "", "bar", 3
                },

                {
                        "fuzble",
                        "fuzble",
                        0
                },

                {
                        "fuzble",
                        "fuzzble",
                        1
                },

                {
                        "fuzble",
                        "fuble",
                        1
                },

                {
                        "fuzble",
                        "fuzxle",
                        1
                },

                {
                        "fbb",
                        "foo",
                        2
                },

                {
                        "alice in wonderland",
                        "Alice in Wonderland",
                        2
                },

                {
                        "gumbo",
                        "gambol",
                        2
                }
        };
    }
}
