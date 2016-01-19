package org.mc.tests;

import org.mc.utils.SurroundedRegions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static org.mc.tests.MatrixUtils.*;

public class SurroundedRegionsTests {
    @Test(dataProvider = "surroundedRegions")
    public void surrounded_regions_works(char[][] map, char[][] expectedFilledMap) {
        char[][] actualFilledMap = map.clone();
        new SurroundedRegions().solve(actualFilledMap);

        Assert.assertEquals(
            toMatrixString(actualFilledMap),
            toMatrixString(expectedFilledMap),
            "failed for: " + toMatrixString(map));
    }

    @DataProvider(name = "surroundedRegions")
    public Object[][] surroundedRegionsProvider() {
        return new Object[][] {
                // empty map
                {
                        cm(),
                        cm()
                },

                // single element map
                {
                        cm("O"),
                        cm("O")
                },

                {
                        cm("X"),
                        cm("X")
                },

                // nothing surrounded by X
                {
                        cm("OXOOOO",
                           "OXXXXX",
                           "OXXOXO",
                           "OXXOXO",
                           "OOXOOO",
                           "OOXOXX"),

                        cm("OXOOOO",
                           "OXXXXX",
                           "OXXOXO",
                           "OXXOXO",
                           "OOXOOO",
                           "OOXOXX")
                },

                // inner region surrounded by X
                {
                        cm("OXOOOO",
                           "OXXXXX",
                           "OXOOXO",
                           "OXOOXO",
                           "OXXXXO",
                           "OOXOXX"),

                        cm("OXOOOO",
                           "OXXXXX",
                           "OXXXXO",
                           "OXXXXO",
                           "OXXXXO",
                           "OOXOXX"),
                },

                // example from problem description
                 {
                        cm("XXXX",
                           "XOOX",
                           "XXOX",
                           "XOXX"),

                        cm("XXXX",
                           "XXXX",
                           "XXXX",
                           "XOXX"),
                },

                {
                        cm("OXOOOO",
                           "OXXXXX",
                           "XXXXXO",
                           "OXXOXO",
                           "OOXXXO",
                           "OOXOXX"),

                        cm("OXOOOO",
                           "OXXXXX",
                           "XXXXXO",
                           "OXXXXO",
                           "OOXXXO",
                           "OOXOXX"),
                },
        };
    }
}
