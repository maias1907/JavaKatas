package katas.exercises;

public class CircularBuffer {
    /**
     * Design a circular buffer (ring buffer).
     *
     * The buffer should operate in constant time.
     * When the buffer is full, adding a new element should overwrite the oldest element.
     *
     */

    private int[] buffer;
    private int head;
    private int tail;
    private int size;

    /**
     * Initializes the circular buffer with a fixed capacity.
     *
     * @param capacity the maximum number of elements the buffer can hold
     */
    public CircularBuffer(int capacity) {
        this.buffer=new int[capacity];
        this.head=0;
        this.size=capacity;
        this.tail=0;

    }

    /**
     * Adds an element to the buffer.
     *
     * @param val the value to add
     */
    public void add(int val) {
        if (isFull()) {
            this.head = (this.head+1 ) % this.size;

        }

        this.buffer[this.tail] = val;  // Add the value at the current tail
        this.tail = (this.tail+1 ) % this.size;



    }

    /**
     * Retrieves the oldest element from the buffer.V
     *
     * @return the oldest element, or -1 if the buffer is empty
     */
    public int get() {
        if(isEmpty())
        {
            return -1;
        }


        return this.buffer[this.head-1];
    }

    /**
     * Checks if the buffer is full.V
     *
     * @return true if the buffer is full, false otherwise
     */
    public boolean isFull() {
        if((tail + 1) % size == head)
        {
            return true;
        }

        return false;
    }

    /**
     * Checks if the buffer is empty.V
     *
     * @return true if the buffer is empty, false otherwise
     */
    public boolean isEmpty() {

        if(tail!=head)
        {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        CircularBuffer buffer = new CircularBuffer(3);

        buffer.add(1);
        buffer.add(2);
        buffer.add(3);
        System.out.println(buffer.get()); // Output: 1
        buffer.add(4);
        System.out.println(buffer.get()); // Output: 2
        buffer.add(5);
        System.out.println(buffer.isFull()); // Output: true
    }
}


