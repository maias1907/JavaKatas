package katas.exercises;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SlidingWindowMaximumTest {
    @Test
    void testMaxSlidingWindow() {
        // Test 1: Normal case with positive and negative integers
        int[] nums1 = {1, 3, -1, -3, 5, 3, 6, 7};
        int k1 = 3;
        List<Integer> expected1 = Arrays.asList(3, 3, 5, 5, 6, 7);
        assertEquals(expected1, SlidingWindowMaximum.maxSlidingWindow(nums1, k1), "Normal case failed");

        // Test 2: Window size equals array length
        int[] nums2 = {4, 2, 12, 7};
        int k2 = 4;
        List<Integer> expected2 = Collections.singletonList(12);
        assertEquals(expected2, SlidingWindowMaximum.maxSlidingWindow(nums2, k2), "Window size equals array length failed");

        // Test 3: Window size is 1 (output should match input)
        int[] nums3 = {4, 2, 12, 7};
        int k3 = 1;
        List<Integer> expected3 = Arrays.asList(4, 2, 12, 7);
        assertEquals(expected3, SlidingWindowMaximum.maxSlidingWindow(nums3, k3), "Window size of 1 failed");

        // Test 4: Window size is larger than array length
        int[] nums4 = {1, 2, 3};
        int k4 = 4;
        List<Integer> expected4 = Collections.emptyList();
        assertEquals(expected4, SlidingWindowMaximum.maxSlidingWindow(nums4, k4), "Window size larger than array failed");

        // Test 5: Empty array
        int[] nums5 = {};
        int k5 = 3;
        List<Integer> expected5 = Collections.emptyList();
        assertEquals(expected5, SlidingWindowMaximum.maxSlidingWindow(nums5, k5), "Empty array failed");

        // Test 6: All elements are the same
        int[] nums6 = {5, 5, 5, 5, 5};
        int k6 = 3;
        List<Integer> expected6 = Arrays.asList(5, 5, 5);
        assertEquals(expected6, SlidingWindowMaximum.maxSlidingWindow(nums6, k6), "All elements are the same failed");

        // Test 7: Single element in array
        int[] nums7 = {10};
        int k7 = 1;
        List<Integer> expected7 = Collections.singletonList(10);
        assertEquals(expected7, SlidingWindowMaximum.maxSlidingWindow(nums7, k7), "Single element in array failed");
    }
}
