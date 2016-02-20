package org.mc.dataStructures;

import com.sun.javaws.exceptions.InvalidArgumentException;
import org.apache.commons.lang3.StringUtils;

import java.util.*;

public class Graph {
    private Map<Integer, GraphNode> nodes;

    public Graph() {
        nodes = new HashMap<>();
    }

    public List<GraphNode> nodes() {
        List<GraphNode> tmp = new ArrayList<>();
        tmp.addAll(nodes.values());
        return tmp;
    }

    public GraphNode addNode(int label) {
        if (getNode(label) != null)
            throw new IllegalStateException("graph already contains node with label: " + label);

        GraphNode newNode = new GraphNode(label);
        nodes.put(label, newNode);
        return newNode;
    }

    public GraphNode getNode(int label) {
        if (nodes.containsKey(label))
            return nodes.get(label);
        else
            return null;
    }

    public String serialize() {
        StringBuilder graphString = new StringBuilder();
        graphString.append('{');

        Integer[] labels = nodes.keySet().toArray(new Integer[0]);
        Arrays.sort(labels);

        for (int label : labels) {
            graphString
                    .append(serializeNode(nodes.get(label)))
                    .append('#');
        }

        // remove last ,
        if (labels.length > 0)
            graphString.setLength(graphString.length()-1);

        graphString.append('}');
        return graphString.toString();
    }

    private String serializeNode(GraphNode node) {
        List<Integer> values = new ArrayList<Integer>();
        values.add(node.label);

        for (GraphNode neighbour : node.neighbours)
            if (neighbour.label >= node.label)
                values.add(neighbour.label);

        Collections.sort(values.subList(1, values.size()));
        return StringUtils.join(values, ",");
    }

    public static Graph deserialize(String graphString) {
        Graph graph = new Graph();

        if (!graphString.startsWith("{") || !graphString.endsWith("}"))
            throw new IllegalArgumentException("graphString is in incorrect format.");

        // skip { and }
        graphString = graphString.substring(1, graphString.length()-1);
        String[] nodeStrings = graphString.split("#");

        // create all nodes
        for(String nodeString : nodeStrings) {
            int label = Integer.valueOf(nodeString.split(",")[0]);
            graph.addNode(label);
        }

        // link nodes
        for(String nodeString : nodeStrings) {
            String[] links = nodeString.split(",");

            int label = Integer.valueOf(links[0]);
            GraphNode node = graph.getNode(label);

            for (int i = 1; i < links.length; i++) {
                node.addEdge(graph.getNode(Integer.valueOf(links[i])));
            }
        }

        return graph;
    }
}
