package org.mc.utils;

import org.w3c.dom.ranges.RangeException;
import org.yaml.snakeyaml.util.ArrayStack;

import java.lang.reflect.Array;
import java.util.Stack;

public class Utils {
    public static <T> void rotate(T[] array, int byNumberOfPositions) {
        rotateArrayInPlace(array, byNumberOfPositions);
    }

    private static <T> void rotateArrayByCopy(T[] array, int byNumberOfPositions) {
        if (array == null)
            throw new IllegalArgumentException("array");

        int length = array.length;
        if (length < 2)
            return;

        int shift = normalizeShift(byNumberOfPositions, array.length);
        if (shift == 0)
            return;

        T[] original = array.clone();
        for (int i = 0; i < length; i++) {
            array[(i + shift) % length] = original[i];
        }
    }

    private static <T> void rotateArrayInPlace(T[] array, int byNumberOfPositions) {
        if (array == null)
            throw new IllegalArgumentException("array");

        int length = array.length;
        if (length == 0)
            return;

        int shift = normalizeShift(byNumberOfPositions, array.length);
        if (shift == 0)
            return;

        reverse(array, 0, length - shift);
        reverse(array, length - shift, length);
        reverse(array, 0, length);
    }

    private static int normalizeShift(int shift, int arrayLength) {
        int moduloShift = shift % arrayLength;

        // 14 % 10 == 4
        // -14 % 10 == -4

        if (moduloShift >= 0)
            return moduloShift;
        else
            return (arrayLength + moduloShift);
    }

    /* Reverses array elements between [startIndex .. stopIndex).
     * startIndex element is included in reverse operation, wheres stopIndex is excluded.
     */
    public static <T> void reverse(T[] array, int startIndex, int stopIndex) {
        if (array == null)
            throw new IllegalArgumentException("array");

        if (startIndex < 0 || startIndex > array.length)
            throw new IndexOutOfBoundsException("startIndex");

        if (stopIndex < 0 || stopIndex > array.length)
            throw new IndexOutOfBoundsException("stopIndex");

        if (startIndex > stopIndex)
            throw new IllegalArgumentException("startIndex cannot be greater than stopIndex");

        int left = startIndex;
        int right = stopIndex - 1;

        while (left < right) {
            T tmp = array[left];
            array[left] = array[right];
            array[right] = tmp;

            left += 1; right -= 1;
        }
    }

}
