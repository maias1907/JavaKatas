package katas.exercises;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class OrderedMapTest {

    private OrderedMap<String, Integer> orderedMap;

    @BeforeEach
    public void setUp() {
        orderedMap = new OrderedMap<>();
    }

    @Test
    public void testPutAndGet() {
        orderedMap.put("One", 1);
        orderedMap.put("Two", 2);

        // Test that the correct values are retrieved
        assertEquals(1, orderedMap.get("One"));
        assertEquals(2, orderedMap.get("Two"));

        // Test non-existing key
        assertNull(orderedMap.get("Three"));
    }

    @Test
    public void testPutWithExistingKey() {
        orderedMap.put("One", 1);
        orderedMap.put("One", 11);  // Overwriting existing value

        // Check that the value is updated
        assertEquals(11, orderedMap.get("One"));
    }

    @Test
    public void testRemove() {
        orderedMap.put("One", 1);
        orderedMap.put("Two", 2);
        assertEquals(2, orderedMap.size());

        // Remove an element and check if it's removed
        orderedMap.remove("One");
        assertNull(orderedMap.get("One"));


        // Test that removal does not affect other elements
        assertEquals(2, orderedMap.get("Two"));
    }

    @Test
    public void testKeys() {
        orderedMap.put("One", 1);
        orderedMap.put("Two", 2);
        orderedMap.put("Three", 3);

        List<String> keys = orderedMap.keys();

        // Ensure the keys are in the insertion order
        assertEquals(List.of("One", "Two", "Three"), keys);
    }

    @Test
    public void testSize() {
        orderedMap.put("One", 1);
        orderedMap.put("Two", 2);

        // Check size of the map
        assertEquals(2, orderedMap.size());
    }

    @Test
    public void testClear() {
        orderedMap.put("One", 1);
        orderedMap.put("Two", 2);

        // Clear the map
        orderedMap.clear();

        // Check that the map is empty
        assertEquals(0, orderedMap.size());
        assertNull(orderedMap.get("One"));
        assertNull(orderedMap.get("Two"));
    }
}
