package katas.exercises;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class isValidGitTreeTest {
    @Test
    public void testValidGitTreeCases() {
        // Test case 1: Valid tree
        Map<String, List<String>> validTree = new HashMap<>();
        validTree.put("A", List.of("B", "C"));
        validTree.put("B", List.of("D"));
        validTree.put("C", List.of());
        validTree.put("D", List.of());
        assertEquals(true, ValidGitTree.isValidGitTree(validTree), "The tree should be valid.");

        // Test case 2: Tree with cycle
        Map<String, List<String>> invalidTreeWithCycle = new HashMap<>();
        invalidTreeWithCycle.put("A", List.of("B"));
        invalidTreeWithCycle.put("B", List.of("C"));
        invalidTreeWithCycle.put("C", List.of("A")); // cycle
        assertEquals(false, ValidGitTree.isValidGitTree(invalidTreeWithCycle), "The tree should be invalid due to a cycle.");

        // Test case 3: Tree with multiple roots
        Map<String, List<String>> invalidTreeMultipleRoots = new HashMap<>();
        invalidTreeMultipleRoots.put("A", List.of("B"));
        invalidTreeMultipleRoots.put("C", List.of("D"));
        invalidTreeMultipleRoots.put("B", List.of());
        invalidTreeMultipleRoots.put("D", List.of());
        assertEquals(false, ValidGitTree.isValidGitTree(invalidTreeMultipleRoots), "The tree should be invalid due to multiple roots.");

        // Test case 4: Disconnected tree
        Map<String, List<String>> invalidTreeDisconnected = new HashMap<>();
        invalidTreeDisconnected.put("A", List.of("B"));
        invalidTreeDisconnected.put("C", List.of()); // Disconnected node
        invalidTreeDisconnected.put("B", List.of());
        assertEquals(false, ValidGitTree.isValidGitTree(invalidTreeDisconnected), "The tree should be invalid due to disconnected components.");

        // Test case 5: Empty tree
        Map<String, List<String>> emptyTree = new HashMap<>();
        assertEquals(false, ValidGitTree.isValidGitTree(emptyTree), "An empty tree is not valid.");

        // Test case 6: Single node tree
        Map<String, List<String>> singleNodeTree = new HashMap<>();
        singleNodeTree.put("A", List.of());
        assertEquals(true, ValidGitTree.isValidGitTree(singleNodeTree), "A single-node tree should be valid.");

        // Test case 7: Tree with self loop
        Map<String, List<String>> selfLoopTree = new HashMap<>();
        selfLoopTree.put("A", List.of("A")); // Self-loop
        assertEquals(false, ValidGitTree.isValidGitTree(selfLoopTree), "The tree should be invalid due to a self-loop.");
    }
}
