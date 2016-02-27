package org.mc.utils;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitions {
    public static List<String> get(String s) {
        List<String> partitions = new ArrayList<>();

        stringDfs(s, 0, partitions, new StringBuilder());

        return partitions;
    }

    private static void stringDfs(String string, int curr, List<String> partitions, StringBuilder currentPartition) {
        if (curr >= string.length()) {
            partitions.add(currentPartition.toString());
        }
        else {
            for(String palindrome : findAllPalindromesStartingAt(string, curr)) {
                int prevLength = currentPartition.length();

                if (currentPartition.length() > 0) {
                    currentPartition.append('.');
                }
                currentPartition.append(palindrome);

                stringDfs(string, curr+palindrome.length(), partitions, currentPartition);

                // rollback changes
                currentPartition.setLength(prevLength);
            }
        }
    }

    private static List<String> findAllPalindromesStartingAt(String string, int index) {
        List<String> palindromes = new ArrayList<>();

        // odd palindrome starting at index+len
        for (int len = 0; index+2*len < string.length(); len++) {
            if (isOddPalindrome(string, index+len, len))
                palindromes.add(string.substring(index, index+2*len+1));
        }

        // even palindrome starting at (index, index+1)
        for (int len = 0; index+2*len+1 < string.length(); len++) {
            if (isEvenPalindrome(string, index+len, len))
                palindromes.add(string.substring(index, index+2*len+2));
        }

        return palindromes;
    }

    private static boolean isOddPalindrome(String string, int center, int length) {
        for (int i = 1; i <= length; i++) {
            if (string.charAt(center-i) != string.charAt(center+i))
                return false;
        }

        return true;
    }

    private static boolean isEvenPalindrome(String string, int leftCenter, int length) {
        int l = leftCenter, r = leftCenter+1;

        for (int i = 0; i <= length; i++) {
            if (string.charAt(l) != string.charAt(r))
                return false;

            l--; r++;
        }

        return true;
    }
}
