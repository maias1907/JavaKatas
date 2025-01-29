package katas.exercises;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GraphClonerTest {

    @Test
    void testCloneGraph_SimpleGraph() {
        GraphCloner.Node node1 = new GraphCloner.Node(1);
        GraphCloner.Node node2 = new GraphCloner.Node(2);
        GraphCloner.Node node3 = new GraphCloner.Node(3);

        node1.neighbors.add(node2);
        node2.neighbors.add(node3);

        GraphCloner.Node clonedGraph = GraphCloner.cloneGraph(node1);

        assertNotNull(clonedGraph);
        assertEquals(node1.val, clonedGraph.val);
        assertNotSame(node1, clonedGraph);
        assertEquals(1, clonedGraph.neighbors.size());
        assertEquals(node2.val, clonedGraph.neighbors.get(0).val);
    }

    @Test
    void testCloneGraph_CyclicGraph() {
        GraphCloner.Node node1 = new GraphCloner.Node(1);
        GraphCloner.Node node2 = new GraphCloner.Node(2);
        GraphCloner.Node node3 = new GraphCloner.Node(3);
        GraphCloner.Node node4 = new GraphCloner.Node(4);

        node1.neighbors.add(node2);
        node2.neighbors.add(node3);
        node3.neighbors.add(node4);
        node4.neighbors.add(node1); // Cycle

        GraphCloner.Node clonedGraph = GraphCloner.cloneGraph(node1);

        assertNotNull(clonedGraph);
        assertEquals(node1.val, clonedGraph.val);
        assertNotSame(node1, clonedGraph);
        assertEquals(1, clonedGraph.neighbors.size());
        assertEquals(node2.val, clonedGraph.neighbors.get(0).val);

        // Ensure cycle is preserved
        GraphCloner.Node clonedNode4 = clonedGraph.neighbors.get(0).neighbors.get(0).neighbors.get(0);
        assertEquals(node4.val, clonedNode4.val);
        assertEquals(clonedGraph, clonedNode4.neighbors.get(0));
    }

    @Test
    void testCloneGraph_DisconnectedGraph() {
        GraphCloner.Node node1 = new GraphCloner.Node(1);
        GraphCloner.Node node2 = new GraphCloner.Node(2);

        // No connection between nodes
        GraphCloner.Node clonedGraph = GraphCloner.cloneGraph(node1);

        assertNotNull(clonedGraph);
        assertEquals(node1.val, clonedGraph.val);
        assertNotSame(node1, clonedGraph);
        assertEquals(0, clonedGraph.neighbors.size());

        GraphCloner.Node clonedNode2 = GraphCloner.cloneGraph(node2);
        assertNotNull(clonedNode2);
        assertEquals(node2.val, clonedNode2.val);
        assertNotSame(node2, clonedNode2);
        assertEquals(0, clonedNode2.neighbors.size());
    }

    @Test
    void testCloneGraph_NullGraph() {
        assertNull(GraphCloner.cloneGraph(null));
    }

    @Test
    void testCloneGraph_SingleNodeSelfLoop() {
        GraphCloner.Node node1 = new GraphCloner.Node(1);
        node1.neighbors.add(node1); // Self-loop

        GraphCloner.Node clonedGraph = GraphCloner.cloneGraph(node1);

        assertNotNull(clonedGraph);
        assertEquals(node1.val, clonedGraph.val);
        assertNotSame(node1, clonedGraph);
        assertEquals(1, clonedGraph.neighbors.size());
        assertEquals(clonedGraph, clonedGraph.neighbors.get(0)); // Should still be a self-loop
    }
}
