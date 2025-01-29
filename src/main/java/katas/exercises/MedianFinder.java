package katas.exercises;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * find the median of a stream of integers.
 *
 * The numbers will be provided one at a time in a dynamic data stream, and after each new number is added,
 * your function should efficiently compute the median of all numbers seen so far.
 *
 * Adding a number: O(log n).
 * Finding the median: O(1) or O(log n).
 *
 * Hint: Consider using two heaps (min-heap and max-heap) to efficiently maintain the order of elements.
 */
public class MedianFinder {

    /**
     * Initializes the MedianFinder object.
     *
     */
      // Min-Heap (Default)
    private PriorityQueue<Double> minHeap ;

    // Max-Heap (Using reverse order)
     private   PriorityQueue<Double> maxHeap ;
    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    }

    /**
     * Adds a number to the data stream.
     *
     * @param num the number to be added
     */
    public void addNum(int num) {
        // Always push the new number to the maxHeap (left half of the data)
        double num1=(double) num;
        //maxHeap.add(num1);
        if(maxHeap.size()==0 || num1<maxHeap.peek() )
        {

            maxHeap.add(num1);
        }



          else if(maxHeap.size()!=0 &&num1>maxHeap.peek())
           {


               minHeap.add(num1);
           }

        // Move the largest element from maxHeap to minHeap
        if (maxHeap.size() > minHeap.size() + 1) {


            minHeap.add(maxHeap.poll());
        }

        // Balance the heaps: if minHeap has more elements, move the root to maxHeap
      else   if (minHeap.size() > maxHeap.size()) {

            maxHeap.add(minHeap.poll());
        }

    }

    /**
     * Finds and returns the median of the data stream.
     *
     * @return the median as a double
     */
    public double findMedian() {




        if(maxHeap.size()!=0 && minHeap.size()!=0  && maxHeap.size()==minHeap.size())
        {

            double mid= (maxHeap.peek()+minHeap.peek())/2;


            return mid;
        }


        return maxHeap.peek();
    }

    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();

        medianFinder.addNum(1);
        medianFinder.addNum(2);
        System.out.println("Median: " + medianFinder.findMedian());

        medianFinder.addNum(3);
        System.out.println("Median: " + medianFinder.findMedian());

        medianFinder.addNum(5);
        System.out.println("Median: " + medianFinder.findMedian());

    }
}
