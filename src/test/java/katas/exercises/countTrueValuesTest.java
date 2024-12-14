package katas.exercises;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class countTrueValuesTest {
    @Test
    public void testcountTrueValues()
    {
        //test 1 false and true
        boolean[] sampleArray = {true, false, true, true, false};
        int expected=3;
        assertEquals(expected,TrueCounter.countTrueValues(sampleArray));
         //test 2 just false
         sampleArray = new boolean[]{false, false,false, false, false};
         expected=0;
        assertEquals(expected,TrueCounter.countTrueValues(sampleArray));
        //test 3 just true
        sampleArray = new boolean[]{true, true};
        expected=2;
        assertEquals(expected,TrueCounter.countTrueValues(sampleArray));
        //test 4 empty
        sampleArray = new boolean[]{};
        expected=0;
        assertEquals(expected,TrueCounter.countTrueValues(sampleArray));
        //test 5 null

        expected=0;
        assertEquals(expected,TrueCounter.countTrueValues(null));
    }

}
