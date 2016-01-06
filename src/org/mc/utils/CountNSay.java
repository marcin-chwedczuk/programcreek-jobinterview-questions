package org.mc.utils;

import java.util.ArrayDeque;
import java.util.Queue;

public class CountNSay {
    private static final int END_OF_NUMBER = -1;

    public String solve(int n) {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(1);
        q.add(END_OF_NUMBER);

        int item, prev, prevCount;

        for (int i = 0; i < n; i++) {
            prev = 0;
            prevCount = 0;

            while(true) {
                item = q.remove();
                if (item != prev) {
                    if (prevCount > 0) {
                        q.add(prevCount);
                        q.add(prev);
                    }

                    prev = item;
                    prevCount = 1;

                    if (item == END_OF_NUMBER)
                        break;
                }
                else {
                    prevCount++;
                }
            }
            q.add(END_OF_NUMBER);
        }

        StringBuilder result = new StringBuilder();

        while ((item = q.remove()) != END_OF_NUMBER) {
            result.append(item);
        }

        return result.toString();
    }
}
