package katas.exercises;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class ArrayDifferenceTest {

    @Test
    public void testArrayDifference(){
        int[] sampleArray = {10, 3, 5, 6, 20, -2};
        int difference = ArrayDifference.findDifference(sampleArray);
        assertEquals(22,difference);
        sampleArray = new int[]{-10, -3, -5, -6, -20, -2};
        difference = ArrayDifference.findDifference(sampleArray);
        assertEquals(18,difference);
        sampleArray = new int[]{0,0, 0, 6,0, 0};//check if the function return the max correctly
        difference = ArrayDifference.findDifference(sampleArray);
        assertEquals(6,difference);
        sampleArray = new int[]{0,0, 0, -6,0, 0};//check if the function return the min correctly
        difference = ArrayDifference.findDifference(sampleArray);
        assertEquals(6,difference);
        sampleArray = new int[]{1,2,3, 6,4, 5};//if all the numbers is positive//
        difference = ArrayDifference.findDifference(sampleArray);
        assertEquals(5,difference);
        sampleArray = new int[]{};//if all the numbers is positive//
        difference = ArrayDifference.findDifference(sampleArray);
        assertEquals(0,difference);
        sampleArray = new int[]{1,1,1, 1,1, 1};//if all the numbers is positive//
        difference = ArrayDifference.findDifference(sampleArray);
        assertEquals(0,difference);










    }
}
