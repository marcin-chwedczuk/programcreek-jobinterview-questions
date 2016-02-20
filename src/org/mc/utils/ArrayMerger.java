package org.mc.utils;

import java.util.Comparator;
import java.util.PriorityQueue;

public class ArrayMerger {
    public int[] merge(int[]... arrays) {
        PriorityQueue<Index> q = new PriorityQueue<Index>();

        int totalCount = 0;

        for (int[] array : arrays) {
            if (array != null) {
                totalCount += array.length;
                q.offer(new Index(array, 0));
            }
        }

        int[] result = new int[totalCount];
        int next = 0;

        for (int i = 0; i < totalCount; i++) {
            Index index = q.poll();
            result[next++] = index.getElement();
            index.moveNext();
            q.offer(index);
        }

        return result;
    }

    private static class Index implements Comparable<Index> {
        int[] array;
        int index;

        public Index(int[] array, int index) {
            this.array = array;
            this.index = index;
        }

        public int getElement() {
            return array[index];
        }

        public boolean ended() {
            return index == array.length;
        }

        public void moveNext() {
            if (!ended())
                index++;
        }

        @Override
        public int compareTo(Index other) {
            if (this.ended()) {
                return other.ended() ? 0 : 1;
            }

            if (other.ended()) {
                return -1;
            }

            return Integer.compare(this.getElement(), other.getElement());
        }
    }
}
