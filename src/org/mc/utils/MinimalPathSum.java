package org.mc.utils;

import java.util.*;

public class MinimalPathSum {
    public List<Coords> findPath(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        // array will hold minimal costs of path from [0][0] to [i][j]
        int[][] dist = new int[rows][cols];
        ArrayUtils.fill2d(dist, Integer.MAX_VALUE);
        dist[0][0] = matrix[0][0];

        // array that will track visited nodes
        boolean[][] visited = new boolean[rows][cols];

        // array to track path
        Coords[][] from = new Coords[rows][cols];

        // priority queue used in Dijkstra algorithm
        PriorityQueue<Node> minSet = new PriorityQueue<>(16, new NodeComparator());
        minSet.add(new Node(new Coords(0, 0), matrix[0][0]));

        while (minSet.size() > 0) {
            Node node = minSet.poll();
            visited[node.getCoords().x()][node.getCoords().y()] = true;

            for(Coords neighbour : node.getCoords().getNeighbors(0, 0, rows, cols)) {
                if (visited[neighbour.x()][neighbour.y()])
                    continue;

                int improvedDist =
                        dist[node.getCoords().x()][node.getCoords().y()] +
                        matrix[neighbour.x()][neighbour.y()];

                if (improvedDist < dist[neighbour.x()][neighbour.y()]) {
                    dist[neighbour.x()][neighbour.y()] = improvedDist;
                    minSet.offer(new Node(neighbour, improvedDist));

                    from[neighbour.x()][neighbour.y()] = node.getCoords();
                }
            }
        }

        // construct path
        List<Coords> path = new ArrayList<>();

        Coords curr = new Coords(rows-1, cols-1);
        while(curr != null) {
            path.add(curr);
            curr = from[curr.x()][curr.y()];
        }

        Collections.reverse(path);
        return path;
    }

    private static class NodeComparator implements Comparator<Node> {
        @Override
        public int compare(Node o1, Node o2) {
            return Integer.compare(o1.getDistance(), o2.getDistance());
        }
    }

    private static class Node {
        private Coords coords;
        private int distance;

        public Node(Coords coords, int distance) {
            if (coords == null)
                throw new NullPointerException("coords");

            if (distance < 0)
                throw new IllegalArgumentException("distance cannot be negative");

            this.coords = coords;
            this.distance = distance;
        }

        public Coords getCoords() {
            return coords;
        }

        public int getDistance() {
            return distance;
        }
    }

    public static class Coords {
        private int x;
        private int y;

        public Coords(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int x() { return x; }
        public int y() { return y; }

        @Override
        public String toString() {
            return String.format("%d,%d", x, y);
        }

        public List<Coords> getNeighbors(int startRow, int startCol, int rows, int cols) {
            int endRow = startRow + rows - 1;
            int endCol = startCol + cols - 1;

            int[] dx = { 0,  0, 1, -1 };
            int[] dy = { 1, -1, 0,  0 };

            List<Coords> neighbors = new ArrayList<>();

            for (int i = 0; i < dx.length; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];

                if (newX >= startRow && newX <= endRow &&
                    newY >= startCol && newY <= endCol)
                        neighbors.add(new Coords(newX, newY));
            }

            return neighbors;
        }
    }
}
