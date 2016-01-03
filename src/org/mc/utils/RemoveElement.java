package org.mc.utils;

public class RemoveElement {
    public int solve(int[] array, int valueToRemove) {
        int start = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] != valueToRemove) {
                array[start++] = array[i];
            }
        }

        return start;
    }
}
