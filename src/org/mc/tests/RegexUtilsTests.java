package org.mc.tests;

import org.mc.utils.RegexUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class RegexUtilsTests {
    @Test
    public void splitAndMatch_works() {
        String testString = "(foo,bar) (nyu,aura) (baz,bar)";

        List<List<String>> result = RegexUtils.splitAndMatch(testString, "\\s+", "\\((\\w+),(\\w+)\\)");

        Assert.assertEquals(result.size(), 3);

        Assert.assertEquals(result.get(0).size(), 2);
        Assert.assertEquals(result.get(0).get(0), "foo");
        Assert.assertEquals(result.get(0).get(1), "bar");

        Assert.assertEquals(result.get(1).size(), 2);
        Assert.assertEquals(result.get(1).get(0), "nyu");
        Assert.assertEquals(result.get(1).get(1), "aura");

        Assert.assertEquals(result.get(2).size(), 2);
        Assert.assertEquals(result.get(2).get(0), "baz");
        Assert.assertEquals(result.get(2).get(1), "bar");
    }
}
