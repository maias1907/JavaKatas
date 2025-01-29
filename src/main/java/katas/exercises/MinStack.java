package katas.exercises;

/**
 * Design a stack that supports standard stack operations (push, pop, top) and also retrieves
 * the minimum element in constant time.
 */
public class MinStack {


    /** Initialize your data structure here. */
    public MinStack() {

    }

    public void push(int val) {

    }

    public void pop() {

    }

    public int top() {

        return -1;
    }

    public int getMin() {

        return -1;
    }

    public static void main(String[] args) {
        MinStack stack = new MinStack();
        stack.push(-2);
        stack.push(0);
        stack.push(-3);
        System.out.println(stack.getMin());
        stack.pop();
        System.out.println(stack.top());
        System.out.println(stack.getMin());
    }
}
