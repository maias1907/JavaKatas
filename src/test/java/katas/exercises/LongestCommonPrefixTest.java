package katas.exercises;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LongestCommonPrefixTest {
    @Test
    public void testLongestCommonPrefix(){
        //test 1
        String[] test1 = {"flower", "flow", "flight"};
        String expected="fl";
        assertEquals(expected,LongestCommonPrefix.longestCommonPrefix(test1));//if we have a common prefix

       //test 2 if we  have not a common prefix
        String[] test2 = {"dog", "racecar", "car"};
        expected="";
        assertEquals(expected,LongestCommonPrefix.longestCommonPrefix(test2));

        //test 3 if we have a empty array of strings
        String[] test3={""};
        expected="";
        assertEquals(expected,LongestCommonPrefix.longestCommonPrefix(test3));

        String[] test4=null;
        assertThrows(NullPointerException.class,()->LongestCommonPrefix.longestCommonPrefix(test4));

        //test 5 array of strings with one word
        String[] test5={"maias"};
        expected="maias";
        assertEquals(expected,LongestCommonPrefix.longestCommonPrefix(test5));

        //test 6 array of strings with two elements
        String[] test6={"maias","maia"};
        expected="maia";
        assertEquals(expected,LongestCommonPrefix.longestCommonPrefix(test6));






    }
}
