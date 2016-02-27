package org.mc.utils;

public class Candies {
    public static int howManyAreNeededFor(int[] ranks) {
        int[] sort = countSort(ranks);
        int[] candies = new int[ranks.length];

        int candyCount = 0;

        for (int i = 0; i < sort.length; i++) {
            int index = sort[i];

            int minCandy = 1;

            if (index >= 1 && ranks[index-1] < ranks[index]) {
                minCandy = candies[index-1]+1;
            }

            if (index < sort.length-1 && ranks[index+1] < ranks[index]) {
                minCandy = Math.max(minCandy, candies[index+1]+1);
            }

            candyCount += minCandy;
            candies[index] = minCandy;
        }

        return candyCount;
    }

    private static int[] countSort(int[] ranks) {
        int[] sortedIndexes = new int[ranks.length];

        int max = ranks[0];
        for (int i = 1; i < ranks.length; i++)
            max = Math.max(max, ranks[i]);

        int[] count = new int[max+1];
        for (int i = 0; i < ranks.length; i++)
            count[ranks[i]]++;

        for (int i = 1; i < count.length; i++) {
            count[i] += count[i-1];
        }

        for (int i = ranks.length-1; i >= 0; i--) {
            sortedIndexes[--count[ranks[i]]] = i;
        }

        return sortedIndexes;
    }
}
