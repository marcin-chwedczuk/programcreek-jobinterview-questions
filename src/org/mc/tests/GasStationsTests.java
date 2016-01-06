package org.mc.tests;

import org.mc.utils.GasStations;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class GasStationsTests {
    @Test(dataProvider = "gasStations")
    public void gas_stations_works(int[] gas, int[] cost, int expectedStart) {
        int actualStart = new GasStations().chooseStartStation(gas, cost);
        Assert.assertEquals(actualStart, expectedStart);
    }

    @DataProvider(name = "gasStations")
    public Object[][] gasStationsProvider() {
        return new Object[][] {
                // gas
                // cost
                // expectedStart

                // good cases
                {
                        new int[] { 4, 5, 1, 1, 5 },
                        new int[] { 3, 4, 2, 5, 2 },
                        4
                },

                {
                        new int[] { 1, 6, 5, 3, 3, 3 },
                        new int[] { 2, 3, 4, 5, 6, 1 },
                        5
                },

                {
                        new int[] { 5, 1, 2 },
                        new int[] { 2, 5, 1 },
                        2
                },

                // bad cases (no route)

                {
                        new int[] { 1, 2, 1 },
                        new int[] { 2, 2, 1 },
                        -1
                }
        };
    }
}
