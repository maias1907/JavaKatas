package katas.exercises;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class ArrayReducerTest {
    @Test
    public void testArrayReducer(){
        int[] sampleArray = {10, 15, 7, 20, 25};//positive numbers
        int[] expected={10,5,-8,13,5};
        ArrayReducer.reduceArray(sampleArray);
        assertArrayEquals(expected,sampleArray);

        sampleArray =new int[]{-10, -3, -5, -6, -20, -2};//negitive numbers
        expected= new int []{-10,7,-2,-1,-14,18};
        ArrayReducer.reduceArray(sampleArray);
        assertArrayEquals(expected,sampleArray);

        sampleArray =new int[]{0, 0, 0, 0, 0, 0};//zero numbers
        expected= new int []{0,0,0,0,0,0};
        ArrayReducer.reduceArray(sampleArray);
        assertArrayEquals(expected,sampleArray);

        sampleArray =new int[]{};//empty numbers
        expected= new int []{};
        ArrayReducer.reduceArray(sampleArray);
        assertArrayEquals(expected,sampleArray);

        sampleArray =new int[]{10};//one element
        expected= new int []{10};
        ArrayReducer.reduceArray(sampleArray);
        assertArrayEquals(expected,sampleArray);

        sampleArray =new int[]{10,7};//two elements
        expected= new int []{10,-3};
        ArrayReducer.reduceArray(sampleArray);
        assertArrayEquals(expected,sampleArray);

        sampleArray =new int[]{10,10,10,10};//two elements
        expected= new int []{10,0,0,0};
        ArrayReducer.reduceArray(sampleArray);
        assertArrayEquals(expected,sampleArray);

        sampleArray =new int[]{10,-6,-5,3,5,-2};//positive and negitive numbers
        expected=new int[]{10,-16,1,8,2,-7};
        ArrayReducer.reduceArray(sampleArray);
        assertArrayEquals(expected,sampleArray);







    }

}
