package org.mc.utils;

import java.util.*;

public class SurroundedRegions {
    public void solve(char[][] map) {
        if (map.length == 0 || map[0].length == 0)
            return;

        int rows = map.length;
        int cols = map[0].length;

        boolean[][] notSurrounded = new boolean[rows][cols];
        List<Position> borderPositions = getBorderPositions(rows, cols);

        for(Position pos : borderPositions) {
            if (isO(map, pos)) {
                discoverNotSurroundedRegion(map, notSurrounded, rows, cols, pos);
            }
        }

        // fill inner regions
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (notSurrounded[i][j])
                    continue;

                if (isO(map, i, j)) {
                    map[i][j] = 'X';
                }
            }
        }
    }

    private void discoverNotSurroundedRegion(char[][] map, boolean[][] notSurrounded, int rows, int cols, Position pos) {
        Queue<Position> q = new ArrayDeque<>();
        q.offer(pos);

        while (!q.isEmpty()) {
            Position p = q.poll();

            // not surrounded are already visited
            if (notSurrounded[p.row][p.col])
                continue;

            notSurrounded[p.row][p.col] = true;

            for(Position neighbourPos : p.getNeighbours()) {
                if (neighbourPos.isOnMap(rows, cols) && isO(map, neighbourPos))
                    q.offer(neighbourPos);
            }
        }
    }

    private List<Position> getBorderPositions(int rows, int cols) {
        List<Position> result = new ArrayList<>();

        // top & bottom
        for (int i = 0; i < cols; i++) {
            result.add(new Position(0, i));
            result.add(new Position(rows-1, i));
        }

        // left & right w/o corners
        for (int i = 1; i < rows-1; i++) {
            result.add(new Position(i, 0));
            result.add(new Position(i, cols-1));
        }

        return result;
    }

    private boolean isO(char[][] map, Position pos) {
        return isO(map, pos.row, pos.col);
    }

    private boolean isO(char[][] map, int row, int col) {
        return map[row][col] == 'O';
    }

    private class Position {
        public int row;
        public int col;

        public Position(int row, int col) {
            this.row = row;
            this.col = col;
        }

        public boolean isOnMap(int rows, int cols) {
            return 0 <= row && row < rows &&
                   0 <= col && col < cols;
        }

        public List<Position> getNeighbours() {
            return Arrays.asList(
                    new Position(row-1, col),
                    new Position(row+1, col),
                    new Position(row, col-1),
                    new Position(row, col+1)
            );
        }
    }
}
