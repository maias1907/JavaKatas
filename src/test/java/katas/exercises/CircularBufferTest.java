package katas.exercises;

import static org.junit.jupiter.api.Assertions.*;

import katas.exercises.CircularBuffer;
import org.junit.jupiter.api.Test;


public class CircularBufferTest {

    @Test
    public void testAddAndGet() {
        CircularBuffer buffer = new CircularBuffer(3);

        buffer.add(1);
        buffer.add(2);
        buffer.add(3);

        // Assert that the oldest element is 1
        assertEquals(1, buffer.get());
    }

    @Test
    public void testOverwriteWhenFull() {
        CircularBuffer buffer = new CircularBuffer(3);

        buffer.add(1);
        buffer.add(2);
        buffer.add(3);

        // Buffer is full, so the next add will overwrite the oldest element
        buffer.add(4);

        // Assert that after adding 4, the oldest element (1) is overwritten
        assertEquals(2, buffer.get()); // 2 should be the oldest element now
    }

    @Test
    public void testIsFull() {
        CircularBuffer buffer = new CircularBuffer(3);

        buffer.add(1);
        buffer.add(2);
        buffer.add(3);

        // Buffer is full
        assertTrue(buffer.isFull());

        // Adding one more element should overwrite the oldest one
        buffer.add(4);

        // Buffer is still full
        assertTrue(buffer.isFull());
    }

    @Test
    public void testIsEmpty() {
        CircularBuffer buffer = new CircularBuffer(3);

        // Initially, the buffer should be empty
        assertTrue(buffer.isEmpty());

        buffer.add(1);

        // After adding an element, the buffer is not empty
        assertFalse(buffer.isEmpty());
    }

    @Test
    public void testGetFromEmptyBuffer() {
        CircularBuffer buffer = new CircularBuffer(3);

        // Buffer is empty, should return -1
        assertEquals(-1, buffer.get());
    }

    @Test
    public void testAddAndGetAfterOverwrite() {
        CircularBuffer buffer = new CircularBuffer(3);

        buffer.add(1);
        buffer.add(2);
        buffer.add(3);
        buffer.add(4); // Overwrites 1

        // Now the oldest element is 2, so it should return 2
        assertEquals(2, buffer.get());
    }
}
