package org.mc.utils;

import com.sun.deploy.util.ArrayUtil;
import org.apache.commons.lang3.ArrayUtils;

public class ReverseStringByWord {
    public String solve(String s) {
        char[] chars = s.toCharArray();
        reverse(chars, 0, chars.length);

        int wordStart = -1;
        for (int i = 0; i < chars.length; i++) {
            if (wordStart == -1 && !Character.isWhitespace(chars[i])) {
                wordStart = i;
            }

            boolean isLastChar = (i == chars.length-1);
            if (wordStart != -1 && (Character.isWhitespace(chars[i]) || isLastChar)) {
                reverse(chars, wordStart, isLastChar ? (i+1) : i);
                wordStart = -1;
            }
        }

        return new String(chars);
    }

    private void reverse(char[] array, int start, int end) {
        end--;

        while (start < end) {
            char swap = array[start]; array[start] = array[end]; array[end] = swap;
            start++;
            end--;
        }
    }
}
