package katas.exercises;

import java.util.*;

public class ValidGitTree {

    /**
     * Determines if a given tree structure represents a valid Git tree.
     *
     * A valid Git tree should:
     * 1. Have exactly one root (no parent).
     * 2. Contain no cycles.
     *
     * @param treeMap a map representing the Git tree (commit ID to list of child commit IDs)
     * @return true if the tree is a valid Git tree, false otherwise
     */
    public static boolean isValidGitTree(Map<String, List<String>> treeMap) {
        // Rule 1: Check for exactly one root
        Map<String, Integer> inDegrees = new HashMap<>();
        for (String node : treeMap.keySet()) {
            inDegrees.put(node, 0);
        }
        for (List<String> children : treeMap.values()) {
            for (String child : children) {
                inDegrees.put(child, inDegrees.getOrDefault(child, 0) + 1);
            }
        }
        int rootCount = 0;
        String root = null;
        for (String node : inDegrees.keySet()) {
            if (inDegrees.get(node) == 0) {
                rootCount++;
                root = node;
            }
        }
        if (rootCount != 1) return false;

        // Rule 2: Check for cycles using DFS
        Set<String> visited = new HashSet<>();
        if (hasCycle(root, treeMap, visited, new HashSet<>())) {
            return false;
        }

        // Make sure all nodes are connected
        return visited.size() == treeMap.size();
    }

    public static boolean hasCycle(String node, Map<String, List<String>> treeMap, Set<String> visited, Set<String> stack) {
        if (stack.contains(node)) return true; // Found a cycle
        if (visited.contains(node)) return false;

        visited.add(node);
        stack.add(node);
        for (String child : treeMap.getOrDefault(node, new ArrayList<>())) {
            if (hasCycle(child, treeMap, visited, stack)) {
                return true;
            }
        }
        stack.remove(node);
        return false;
    }



    public static void main (String [] args){
            Map<String, List<String>> validTree = new HashMap<>();
            validTree.put("A", List.of("B", "C"));
            validTree.put("B", List.of("D"));
            validTree.put("C", List.of());
            validTree.put("D", List.of());

            Map<String, List<String>> invalidTree = new HashMap<>();
            invalidTree.put("A", List.of("B"));
            invalidTree.put("B", List.of("C"));
            invalidTree.put("C", List.of("A")); // cycle

            System.out.println("Is valid tree: " + isValidGitTree(validTree));
            System.out.println("Is valid tree: " + isValidGitTree(invalidTree));
        }
    }

