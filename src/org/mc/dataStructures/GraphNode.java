package org.mc.dataStructures;

import java.util.*;

public class GraphNode {
    public int label;
    public Set<GraphNode> neighbours;

    public GraphNode(int label) {
        this.label = label;
        this.neighbours = new HashSet<>();
    }

    public GraphNode addEdge(GraphNode node) {
        if (node == null) {
            throw new NullPointerException("node");
        }

        if (node.label == this.label && node != this)
            throw new IllegalArgumentException("node label collision");

        neighbours.add(node);

        if (node != this)
            node.neighbours.add(this);

        return this;
    }

    public boolean hasEdgeTo(GraphNode node) {
        if (node == null) {
            throw new IllegalArgumentException("node cannot be null");
        }

        return neighbours.contains(node);
    }
}
