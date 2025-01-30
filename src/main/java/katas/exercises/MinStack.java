package katas.exercises;

import java.util.Stack;

/**
 * Design a stack that supports standard stack operations (push, pop, top) and also retrieves
 * the minimum element in constant time.
 */
public class MinStack {
    private Stack<Integer> stack;      // Stores all elements
    private Stack<Integer> minStack;



    /** Initialize your data structure here. */
    public MinStack() {
       stack=new Stack<>();
       minStack=new Stack<>();


    }

    public void push(int val) {
        stack.push(val);

        if(minStack.isEmpty())
        {

            minStack.push(val);
        }
       else if(minStack.peek()>val)
        {
            minStack.push(val);
        }
       else{
            minStack.push(minStack.peek());
        }


    }

    public void pop() {

        if(stack.isEmpty())return;
        minStack.pop();
        stack.pop();

    }

    public int top() {
        if (stack.isEmpty()) throw new RuntimeException("Stack is empty");
        return stack.peek();
    }

    public int getMin() {
        if (minStack.isEmpty()) throw new RuntimeException("Stack is empty");
        return minStack.peek();
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
