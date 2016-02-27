package org.mc.utils;

public class PalindromePartition2 {
    private final String string;

    private final short[] counts;
    private final short[][] splits;

    public PalindromePartition2(String string) {
        this.string = string;

        int len = string.length() + 1;
        counts = new short[len];
        splits = new short[len][len];
    }

    public String findMinimalPartition() {
        for (int end = 1; end <= string.length(); end++) {
            counts[end] = Short.MAX_VALUE;

            for (int split = 0; split < end; split++) {
                // if palindrome string[split..end]
                if (string.charAt(split) == string.charAt(end-1) && (end-split <= 1 || splits[split+1][end-1] == 0)) {
                    int tmp = 1 + counts[split];
                    if (tmp < counts[end]) {
                        counts[end] = (short)tmp;
                        splits[0][end] = (short)split;
                    }
                }
                else {
                    splits[split][end] = Short.MAX_VALUE;
                }
            }
        }

        String minPartition = reconstruct();
        return minPartition;
    }

    private String reconstruct() {
        return reconstruct(0, string.length());
    }

    private String reconstruct(int start, int end) {
        if (splits[start][end] != 0) {
            int split = splits[start][end];
            return reconstruct(start, split) + "." + reconstruct(split, end);
        }
        else {
            return string.substring(start, end);
        }
    }

    private boolean isPalindrome(int start, int end) {
        int left = start, right = end-1;

        while (left < right) {
            if (string.charAt(left) != string.charAt(right))
                return false;

            left++;
            right--;
        }

        return true;
    }
}
