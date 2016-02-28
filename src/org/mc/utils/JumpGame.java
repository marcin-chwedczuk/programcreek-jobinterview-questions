package org.mc.utils;

public class JumpGame {
    public static boolean canReachEnd(int[] range) {
        int max = range[0];

        for (int i = 1; i < range.length-1; i++) {
            max = Math.max(max-1, range[i]);
            if (max == 0)
                return false;
        }

        return true;
    }

    public static boolean canReachEnd2(int[] range) {
        boolean[] reached = new boolean[range.length];
        reached[0] = true;

        for (int i = 0; i < reached.length; i++)
        {
            if (reached[i]) {
                for (int j = i+1; j < Math.min(i+range[i]+1, reached.length); j++)
                    reached[j] = true;
            }
        }

        return reached[reached.length-1];
    }
}
