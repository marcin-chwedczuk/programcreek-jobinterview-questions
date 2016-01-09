package org.mc.utils;

public class ShortestPalindrome {
    public String solve(String s) {
        if (s.length() == 0)
            return s;

        String rs = new StringBuilder(s).reverse().toString();

        // core palindrome in s
        // [core_palindrome][rest_of_s]
        for (int coreEnd = s.length()-1; coreEnd >= 0; coreEnd--) {
            if (isPalindrome(s, coreEnd)) {
                return rs.substring(0, s.length()-1 - coreEnd) + s;
            }
        }

        throw new RuntimeException("cannot happen");
    }

    private boolean isPalindrome(String s, int stop) {
        int left = 0;
        int right = stop;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right))
                return false;

            left++;
            right--;
        }

        return true;
    }
}
