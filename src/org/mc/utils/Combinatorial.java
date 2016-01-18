package org.mc.utils;

public final class Combinatorial {
    public static long newton(int n, int k) {
        // return n!/(k! * (n-k)!) = (n-0) * (n-1) * ... * (n-(k-1)) / 1 * 2 * ... * k

        long r = 1;

        for (int i = 0; i < k; i++) {
            r = r * (n-i) / (i+1);
        }

        return r;
    }
}
