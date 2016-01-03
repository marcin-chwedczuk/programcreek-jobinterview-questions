package org.mc.utils;

public class MinimumInRotatedArray {
    public int solve(int[] array) {
        // if array is not rotated return first element
        if (array[0] < array[array.length-1])
            return 0;

        int left = 0, right = array.length-1;

        while ((right - left) > 1) {
            int mid = (left + right) / 2;

            if (array[left] > array[mid]) {
                right = mid;
            }
            else {
                left = mid;
            }
        }

        return right;
    }

    public int solveWithDuplicates(int[] array) {
        int left = 0, right = array.length-1;

        // skip duplicates
        while (array[left] == array[right] && left < right) {
            right--;
        }

        // if array is not rotated return first element
        if (array[left] <= array[right])
            return left;

        while ((right - left) > 1) {
            // skip duplicates
            while (array[left] == array[right] && left < right) {
                left++;
            }

            if (left == right)
                break;

            int mid = (left + right) / 2;

            if (array[left] > array[mid]) {
                right = mid;
            }
            else {
                left = mid;
            }
        }

        // move to leftmost index
        while (right > 0 && array[right-1] == array[right])
            right--;

        return right;
    }
}
