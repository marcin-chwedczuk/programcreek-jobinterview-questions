package org.mc.utils;

import java.util.*;

public class Courses {
    private int n;
    private Map<Integer, List<Integer>> graph;

    public Courses(int n, List<List<Integer>> prerequisites) {
        this.n = n;
        this.graph = new HashMap<>();

        buildGraph(prerequisites);
    }

    private void buildGraph(List<List<Integer>> prerequisites) {
        for(List<Integer> prereq : prerequisites) {
            int node = prereq.get(0);
            List<Integer> neighbours = new ArrayList<>(prereq.subList(1, prereq.size()));
            graph.put(node, neighbours);
        }

        for (int i = 0; i < n; i++) {
            if (!graph.containsKey(i)) {
                graph.put(i, new ArrayList<Integer>());
            }
        }
    }

    public boolean canTake() {
        return !graphContainsCycle();
    }

    private boolean graphContainsCycle() {
        Set<Integer> visited = new HashSet<>();
        Set<Integer> path = new HashSet<>();

        for (int i = 0; i < n; i++) {
            if (!visited.contains(i))
                if(cycleCheckDfs(i, visited, path))
                    return true;
        }

        return false;
    }

    private boolean cycleCheckDfs(int node, Set<Integer> visited, Set<Integer> path) {
        visited.add(node);
        path.add(node);

        try {
            for (Integer neighbour : graph.get(node)) {
                if (path.contains(neighbour))
                    return true;

                if (!visited.contains(neighbour) && cycleCheckDfs(neighbour, visited, path))
                    return true;
            }
        }
        finally {
            path.remove(node);
        }

        return false;
    }
}
