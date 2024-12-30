package katas.exercises;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MaxStorageCapacityTest {

    @Test
    void testMaxStorageArea() {
        // Test 1: Normal case with mixed heights
        int[] containers1 = {2, 1, 5, 6, 2, 3};
        assertEquals(10, MaxStorageCapacity.maxStorageArea(containers1), "Test case 1 failed");

        // Test 2: All containers have the same height
        int[] containers2 = {4, 4, 4, 4};
        assertEquals(16, MaxStorageCapacity.maxStorageArea(containers2), "Test case 2 failed");

        // Test 3: Increasing heights
        int[] containers3 = {1, 2, 3, 4, 5};
        assertEquals(9, MaxStorageCapacity.maxStorageArea(containers3), "Test case 3 failed");

        // Test 4: Decreasing heights
        int[] containers4 = {5, 4, 3, 2, 1};
        assertEquals(9, MaxStorageCapacity.maxStorageArea(containers4), "Test case 4 failed");

        // Test 5: Single container
        int[] containers5 = {7};
        assertEquals(7, MaxStorageCapacity.maxStorageArea(containers5), "Test case 5 failed");

        // Test 6: Two containers
        int[] containers6 = {3, 6};
        assertEquals(6, MaxStorageCapacity.maxStorageArea(containers6), "Test case 6 failed");

        // Test 7: Containers with height zero
        int[] containers7 = {0, 0, 0};
        assertEquals(0, MaxStorageCapacity.maxStorageArea(containers7), "Test case 7 failed");

        // Test 8: Empty array
        int[] containers8 = {};
        assertEquals(0, MaxStorageCapacity.maxStorageArea(containers8), "Test case 8 failed");

        // Test 9: Alternating high and low containers
        int[] containers9 = {2, 4, 2, 4, 2};
        assertEquals(10, MaxStorageCapacity.maxStorageArea(containers9), "Test case 9 failed");
    }
}
