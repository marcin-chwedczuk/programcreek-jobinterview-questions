package org.mc.utils;

import java.lang.reflect.Array;

public class Utils {
    public static <T> void rotate(T[] array, int byNumberOfPositions) {
        if (array == null)
            throw new IllegalArgumentException("array");

        int length = array.length;
        if (length < 2)
            return;

        int shift = (length + byNumberOfPositions % length) % length;
        if (shift == 0)
            return;

        T[] original = array.clone();
        for (int i = 0; i < length; i++) {
            array[(i + shift) % length] = original[i];
        }
    }

    public static void main(String[] args) { }
}
