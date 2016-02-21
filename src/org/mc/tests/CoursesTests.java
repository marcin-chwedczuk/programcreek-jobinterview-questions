package org.mc.tests;

import com.google.common.collect.Lists;
import org.mc.utils.Courses;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import static org.mc.tests.ListUtils.*;

public class CoursesTests {
    @Test(dataProvider = "courses")
    public void courses_works(String testCase, int n, List<List<Integer>> prerequisites, boolean canTake) {
        boolean actualCanTake = new Courses(n, prerequisites).canTake();

        Assert.assertEquals(actualCanTake, canTake, "failed for: " + testCase);
    }

    @DataProvider(name = "courses")
    public Object[][] coursesProvider() {
        //noinspection unchecked
        return new Object[][] {
                {
                        "Single course",
                        1,
                        new ArrayList<List<Integer>>(),
                        true
                },

                {
                        "Two curses - can take",
                        2,
                        list(list(0,1)),
                        true
                },

                {
                        "Two curses - cannot take",
                        2,
                        list(list(0,1), list(1,0)),
                        false
                },

                {
                        "Three courses - can take",
                        3,
                        list(list(0,2), list(1,0,2)),
                        true
                },

                {
                        "Three courses - cannot take",
                        3,
                        list(list(0,2), list(2,1), list(1,0)),
                        false
                }
        };
    }
}
