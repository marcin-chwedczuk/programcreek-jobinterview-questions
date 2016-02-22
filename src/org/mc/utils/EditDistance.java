package org.mc.utils;

public class EditDistance {
    public static int compute(String a, String b) {
        if (a.isEmpty() || b.isEmpty())
            return a.length() + b.length();

        // a -> b

        int[] prev = new int[b.length()+1];
        int[] curr = new int[b.length()+1];

        // '' -> b[0..i]
        for (int i = 0; i < prev.length; i++)
            prev[i] = i;

        for (int aLen = 1; aLen <= a.length(); aLen++) {
            // a[0..aLen] -> ''
            curr[0] = aLen;

            for (int bLen = 1; bLen < curr.length; bLen++) {
                int replaceCost = (a.charAt(aLen-1) == b.charAt(bLen-1)) ? 0 : 1;

                // curr[bLen] = cost(a[0..aLen] -> b[0..bLen])
                curr[bLen] = min(
                    prev[bLen -1]+replaceCost, // a-1.lastA -> b-1.lastA -> (lastA -> lastB) -> b
                    prev[bLen]+1, // a-1.lastA -> b.lastA -> delete lastA -> b
                    curr[bLen -1]+1 // a -> b-1 -> insert(last b) -> b
                );
            }

            int[] swap = curr; curr = prev; prev = swap;
        }

        return prev[b.length()];
    }

    private static int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }
}
