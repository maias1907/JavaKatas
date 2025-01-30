package katas.exercises;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MinStackTest {

    @Test
    public void testPushAndTop() {
        MinStack minStack = new MinStack();
        minStack.push(5);
        assertEquals(5, minStack.top());

        minStack.push(10);
        assertEquals(10, minStack.top());
    }

    @Test
    public void testGetMin() {
        MinStack minStack = new MinStack();
        minStack.push(5);
        minStack.push(2);
        minStack.push(8);
        assertEquals(2, minStack.getMin());

        minStack.push(1);
        assertEquals(1, minStack.getMin());

        minStack.pop();
        assertEquals(2, minStack.getMin());
    }

    @Test
    public void testPop() {
        MinStack minStack = new MinStack();
        minStack.push(5);
        minStack.push(2);
        minStack.push(8);

        minStack.pop();
        assertEquals(2, minStack.top());

        minStack.pop();
        assertEquals(5, minStack.top());
    }

    @Test
    public void testPopAndGetMin() {
        MinStack minStack = new MinStack();
        minStack.push(3);
        minStack.push(1);
        minStack.push(4);
        minStack.push(1);

        assertEquals(1, minStack.getMin());
        minStack.pop();  // Removes 1
        assertEquals(1, minStack.getMin());

        minStack.pop();  // Removes 4
        assertEquals(1, minStack.getMin());

        minStack.pop();  // Removes 1
        assertEquals(3, minStack.getMin());
    }

    @Test
    public void testEmptyStackBehavior() {
        MinStack minStack = new MinStack();
        Exception exception1 = assertThrows(RuntimeException.class, minStack::top);
        assertEquals("Stack is empty", exception1.getMessage());

        Exception exception2 = assertThrows(RuntimeException.class, minStack::getMin);
        assertEquals("Stack is empty", exception2.getMessage());

        minStack.push(7);
        assertEquals(7, minStack.getMin());

        minStack.pop();
        Exception exception3 = assertThrows(RuntimeException.class, minStack::getMin);
        assertEquals("Stack is empty", exception3.getMessage());
    }
}
