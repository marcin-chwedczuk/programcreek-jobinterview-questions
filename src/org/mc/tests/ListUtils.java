package org.mc.tests;

import org.apache.commons.lang3.StringUtils;

import java.util.List;

public final class ListUtils {
    private ListUtils() { }

    public static <T> String toListString(List<T> list) {
        return String.format("[%s]", StringUtils.join(list, ", "));
    }
}
