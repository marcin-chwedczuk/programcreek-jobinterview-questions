package org.mc.tests;

import org.mc.utils.SimplifyPath;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SimplifyPathTests {
    @Test(dataProvider = "simplifyPath")
    public void simplify_path_works(String path, String expectedSimplifiedPath) {
        String actualSimplifiedPath = new SimplifyPath().solve(path);
        Assert.assertEquals(actualSimplifiedPath, expectedSimplifiedPath, "failed for path: " + path);
    }

    @DataProvider(name = "simplifyPath")
    public Object[][] simplifyPathProvider() {
        return new Object[][] {
                // boundary cases
                { "/", "/" },
                { "/foo", "/foo" },
                { "/.", "/" },
                { "/..", "/" },

                // path with trailing slash
                { "/foo/", "/foo" },
                { "/foo/bar/", "/foo/bar" },

                // path with ..
                { "/foo/../bar/..", "/" },
                { "/../../..", "/" },
                { "/foo/bar/nya/../..", "/foo" },
                { "/a/b/c/../d/e/../f", "/a/b/d/f" },

                // path with .
                { "/./././././", "/" },
                { "/foo/./bar/./", "/foo/bar" },
                { "/foo/bar/.", "/foo/bar" },

                // path with .. and .
                { "/foo/./../bar", "/bar" },

                // official test case
                { "/home/", "/home" },
                { "/a/./b/../../c/", "/c" },
                { "/../", "/" },
                { "/home//foo/", "/home/foo"}
        };
    }
}
