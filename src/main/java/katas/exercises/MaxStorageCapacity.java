package katas.exercises;

import java.util.Stack;

public class MaxStorageCapacity {

    /**
     *Imagine a series of storage containers placed side by side, where the height of each container
     *      * is given by an integer in the array. Your task is to find the largest rectangular area that
     *      * can be formed using one or more of these containers.
     *      *
     *      * For example:
     *      * Input: containers = [2, 1, 5, 6, 2, 3]
     *      * Output: 10
     *      * Explanation: The largest rectangle is formed between containers at indices 2 and 3
     *      * with height 5 and width 2.
     *      *
     *      * @param containers an array of integers representing the heights of containers
     *      * @return the area of the largest rectangle formed between containers
     *
     *
     */
    public static int maxStorageArea(int[] containers) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0,top,width,high,area;
        int i = 0;

        // Traverse through all containers
        while (i < containers.length) {
            // If the stack is empty or the current container is taller than the container at the top of the stack
            if (stack.isEmpty() || containers[stack.peek()] <= containers[i]) {
                // Assuming 'stack' is your Stack object

                stack.push(i++);
            } else {

                 top = stack.pop();

                 width = stack.isEmpty() ? i : i - stack.peek() - 1;
                 area = containers[top] * width;
                maxArea = Math.max(maxArea, area);
            }
        }


        while (!stack.isEmpty()) {
             top = stack.pop();
             width = stack.isEmpty() ? i : i - stack.peek() - 1;
            area = containers[top] * width;
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
        // Hint for efficient implementation: stack

    }

    public static void main(String[] args) {
        int[] containers = {2, 1, 5, 6, 2, 3};


        int result = maxStorageArea(containers);
        System.out.println("Max storage area: " + result); // Expected output: 10
    }
}
