package katas.exercises;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StringDigitSumTest {
    @Test
    public void testStringDigitSum(){
        //test 1 if we have an input that contain letters and digits
        String input="123bnhmh";
        int expected=6;
        assertEquals(expected,StringDigitSum.sumOfDigits(input));

        //test 2 if we have an input that contain just digits
        input="12356";
        expected=17;
        assertEquals(expected,StringDigitSum.sumOfDigits(input));

        //test 3 if we have an input that contain just letters
        input="no digits";
        expected=0;
        assertEquals(expected,StringDigitSum.sumOfDigits(input));

        //test 4 empty input
        input="";
        expected=0;
        assertEquals(expected,StringDigitSum.sumOfDigits(input));

        //test 5 null input
        input=null;
        expected=0;
        assertEquals(expected,StringDigitSum.sumOfDigits(input));







    }

}
