package org.mc.tests;

import org.apache.commons.lang3.ArrayUtils;
import org.mc.utils.JumpGame;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.mc.tests.ListUtils.*;

public class JumpGameTests {
    @Test(dataProvider = "jumpGame")
    public void jump_game_works(List<Integer> list, boolean canReachEnd) {
        int[] array = ArrayUtils.toPrimitive(list.toArray(new Integer[0]));
        boolean actualCanReachEnd = JumpGame.canReachEnd(array);

        Assert.assertEquals(actualCanReachEnd, canReachEnd, "failed for: " + Arrays.toString(array));
    }

    @DataProvider(name = "jumpGame")
    public Object[][] jumpGameProvider() {
        return new Object[][] {
                {
                        list(0), true
                },

                {
                        list(3), true
                },

                {
                        list(3, 2, 1, 0, 4),
                        false
                },

                {
                        list(1, 2, 3, 2, 1, 3),
                        true
                },

                {
                        list(3, 2, 0, 1, 2, 0, 0),
                        true
                },

                {
                        list(3, 0, 0, 1, 0, 3),
                        false
                },

                {
                        list(10, 0, 0, 0, 0, 5),
                        true
                },

                {
                        list(5, 0, 0, 0, 0, 3, 0, 0, 1),
                        true
                },

                {
                        list(5, 0, 0, 0, 0, 1, 0, 0, 1),
                        false
                },
        };
    }
}
