package org.mc.tests;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class ListUtils {
    private ListUtils() { }

    public static <T> String toListString(List<T> list) {
        return String.format("[%s]", StringUtils.join(list, ", "));
    }

    public static List<Integer> list(int... ints) {
        List<Integer> tmp = new ArrayList<>();

        for (int i : ints)
            tmp.add(i);

        return tmp;
    }

    @SafeVarargs
    public static List<List<Integer>> list(List<Integer>... lists) {
        List<List<Integer>> tmp = new ArrayList<>();

        Collections.addAll(tmp, lists);

        return tmp;
    }
}
