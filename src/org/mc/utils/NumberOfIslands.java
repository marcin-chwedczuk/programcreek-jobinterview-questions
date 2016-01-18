package org.mc.utils;

import java.util.ArrayDeque;
import java.util.Queue;

public class NumberOfIslands {
    public int solve(int[][] map) {
        if (map.length == 0 || map[0].length == 0)
            return 0;

        int rows = map.length;
        int cols = map[0].length;

        boolean[][] visited = new boolean[rows][cols];
        int nIslands = 0;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (isLand(map[r][c]) && !visited[r][c]) {
                    nIslands++;
                    markLandAsVisited(map, visited, r, c);
                }
            }
        }

        return nIslands;
    }

    private void markLandAsVisited(int[][] map, boolean[][] visited, int r, int c) {
        Queue<Integer> rQueue = new ArrayDeque<>();
        Queue<Integer> cQueue = new ArrayDeque<>();

        rQueue.offer(r); cQueue.offer(c);

        while (!rQueue.isEmpty()) {
            int row = rQueue.poll();
            int col = cQueue.poll();

            if (visited[row][col])
                continue;

            visited[row][col] = true;

            for(int[] offset : new int[][] { {-1,0}, {1,0}, {0,-1}, {0,1} }) {
                int nRow = row + offset[0];
                int nCol = col + offset[1];

                if (isOnMap(map, nRow, nCol) && isLand(map[nRow][nCol]) && !visited[nRow][nCol]) {
                    rQueue.offer(nRow); cQueue.offer(nCol);
                }
            }
        }
    }

    private static boolean isOnMap(int[][] map, int r, int c) {
        return (0 <= r && r < map.length && 0 <= c && c < map[0].length);
    }

    private static boolean isLand(int n) {
        return n == 1;
    }
}
