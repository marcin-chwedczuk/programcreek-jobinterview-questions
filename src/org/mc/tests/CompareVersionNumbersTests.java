package org.mc.tests;

import org.mc.utils.CompareVersionNumbers;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CompareVersionNumbersTests {
    @Test(dataProvider = "versionNumbers")
    public void compare_versions_works(String versionNumberA, String versionNumberB, int outcome) {
        int actualOutcome = new CompareVersionNumbers().compare(versionNumberA, versionNumberB);
        Assert.assertEquals(actualOutcome, outcome);
    }

    @DataProvider(name = "versionNumbers")
    public Object[][] versionNumbersProvider() {
        return new Object[][] {
                // boundary conditions
                { "1", "1", 0 },
                { "2", "1", 1 },
                { "1", "2", -1 },

                // same number of parts
                { "1.2.3.4", "1.2.3.4", 0 },
                { "1.3.3.4", "1.2.3.4", 1 },
                { "1.2.3.3", "1.2.3.4", -1 },

                { "1.3.5.3", "1.2.3.4", 1 },
                { "0.14.5.3", "1.2.3.4", -1 },
                { "9.3.2.1", "10.0.0.0", -1 },

                // different numbers of parts
                { "3.32", "4", -1 },
                { "1.3.32", "1.3", 1 },
                { "1.0.0.0", "1.0.0", 1 },
                { "4.32.1.23", "7.1.0", -1 }
        };
    }
}
