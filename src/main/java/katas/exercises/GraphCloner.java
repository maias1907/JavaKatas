package katas.exercises;

import java.util.*;

/**
 * You are given the reference to a node in a directed graph, where each node contains a unique integer
 * value and a list of neighbors (outgoing edges).
 *
 * Your task is to write a function to clone the entire graph, creating a deep copy.
 *
 * - Ensure the cloned graph has the same structure and values as the original graph.
 * - The function should handle graphs with cycles.
 *
 */
class GraphCloner {



    /**
     * Clones a directed graph.
     *
     * @param node the starting node of the graph to clone
     * @return the starting node of the cloned graph
     */
    public static Node cloneGraph(Node node) {
        return null;
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        node1.neighbors.add(node2);
        node1.neighbors.add(node4);
        node2.neighbors.add(node3);
        node3.neighbors.add(node4);
        node4.neighbors.add(node1);

        System.out.println("Original graph:");
        printGraph(node1, new HashSet<>());

        Node clonedNode = cloneGraph(node1);

        System.out.println("\nCloned graph:");
        printGraph(clonedNode, new HashSet<>());
    }

    /**
     * Helper function to print the graph.
     *
     * @param node the starting node of the graph
     * @param visited a set to track visited nodes
     */
    public static void printGraph(Node node, Set<Node> visited) {
        if (node == null || visited.contains(node)) return;
        visited.add(node);
        System.out.println("Node " + node.val + " -> " + node.neighbors.stream().map(n -> n.val).toList());
        for (Node neighbor : node.neighbors) {
            printGraph(neighbor, visited);
        }
    }

    static class Node {
        public int val;
        public List<Node> neighbors;

        public Node(int val) {
            this.val = val;
            this.neighbors = new ArrayList<>();
        }

        @Override
        public String toString() {
            return "Node{" + "val=" + val + ", neighbors=" + neighbors.size() + '}';
        }
    }
}

