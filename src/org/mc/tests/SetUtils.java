package org.mc.tests;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public final class SetUtils {
    private SetUtils() { }

    public static Set<String> set(String... strings) {
        Set<String> set = new HashSet<>();
        Collections.addAll(set, strings);
        return set;
    }
}
