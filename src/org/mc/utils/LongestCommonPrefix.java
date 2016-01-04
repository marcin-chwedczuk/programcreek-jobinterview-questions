package org.mc.utils;

public class LongestCommonPrefix {
    public String solve(String[] strings) {
        if (strings.length == 0)
            return "";

        int currentIndex = 0;

        outer: while(true) {
            if (strings[0].length() == currentIndex)
                break;

            char c = strings[0].charAt(currentIndex);

            for (int i = 1; i < strings.length; i++) {
                if (currentIndex == strings[i].length() || strings[i].charAt(currentIndex) != c)
                    break outer;
            }

            currentIndex++;
        }

        return strings[0].substring(0, currentIndex);
    }
}
