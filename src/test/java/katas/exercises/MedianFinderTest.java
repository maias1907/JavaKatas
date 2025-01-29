package katas.exercises;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for MedianFinder class.
 */
class MedianFinderTest {

    @Test
    void testMedianWithSingleElement() {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(10);
        assertEquals(10.0, medianFinder.findMedian(), 0.0001);
    }

    @Test
    void testMedianWithTwoElements() {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(10);
        medianFinder.addNum(20);
        assertEquals(15.0, medianFinder.findMedian(), 0.0001);
    }

    @Test
    void testMedianWithOddNumberOfElements() {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        medianFinder.addNum(3);
        assertEquals(2.0, medianFinder.findMedian(), 0.0001);
    }

    @Test
    void testMedianWithEvenNumberOfElements() {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        medianFinder.addNum(3);
        medianFinder.addNum(4);
        assertEquals(2.5, medianFinder.findMedian(), 0.0001);
    }

    @Test
    void testMedianWithNegativeNumbers() {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(-5);
        medianFinder.addNum(-10);
        medianFinder.addNum(-15);
        assertEquals(-10.0, medianFinder.findMedian(), 0.0001);
    }

    @Test
    void testMedianWithMixedNumbers() {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(3);
        medianFinder.addNum(-2);
        medianFinder.addNum(7);
        medianFinder.addNum(10);
        medianFinder.addNum(5);
        assertEquals(5.0, medianFinder.findMedian(), 0.0001);
    }

    @Test
    void testMedianWithDuplicateNumbers() {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(5);
        medianFinder.addNum(5);
        medianFinder.addNum(5);
        medianFinder.addNum(5);
        assertEquals(5.0, medianFinder.findMedian(), 0.0001);
    }
}
