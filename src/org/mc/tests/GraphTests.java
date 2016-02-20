package org.mc.tests;

import org.mc.dataStructures.Graph;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GraphTests {
    @Test
    public void graph_serialize_works() {
        Graph g = new Graph();
        g.addNode(0); g.addNode(1); g.addNode(2);

        g.getNode(0)
                .addEdge(g.getNode(1))
                .addEdge(g.getNode(2));

        g.getNode(1)
                .addEdge(g.getNode(2));

        g.getNode(2)
                .addEdge(g.getNode(2));

        Assert.assertEquals(g.serialize(), "{0,1,2#1,2#2,2}");
    }

    @Test
    public void graph_deserialize_works() {
        Graph g = Graph.deserialize("{0,1,2#1,2#2,2}");

        Assert.assertEquals(g.nodes().size(), 3);
        Assert.assertNotNull(g.getNode(0));
        Assert.assertNotNull(g.getNode(1));
        Assert.assertNotNull(g.getNode(2));

        Assert.assertEquals(g.getNode(0).neighbours.size(), 2);
        Assert.assertTrue(g.getNode(0).hasEdgeTo(g.getNode(1)));
        Assert.assertTrue(g.getNode(0).hasEdgeTo(g.getNode(2)));

        Assert.assertEquals(g.getNode(1).neighbours.size(), 2);
        Assert.assertTrue(g.getNode(1).hasEdgeTo(g.getNode(0)));
        Assert.assertTrue(g.getNode(1).hasEdgeTo(g.getNode(2)));

        Assert.assertEquals(g.getNode(2).neighbours.size(), 3);
        Assert.assertTrue(g.getNode(2).hasEdgeTo(g.getNode(0)));
        Assert.assertTrue(g.getNode(2).hasEdgeTo(g.getNode(1)));
        Assert.assertTrue(g.getNode(2).hasEdgeTo(g.getNode(2)));
    }
}
