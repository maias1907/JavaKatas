package katas.exercises;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UniqueStringTest {
    @Test
    public void testisUniqueT(){
        //test 1
        String test = "Hello";
        boolean exp=false;
        assertEquals(exp,UniqueString.isUnique(test));
        //test 2
        test= "World";
         exp=true;
        assertEquals(exp,UniqueString.isUnique(test));
        //test 3
        test= "Java";
        exp=false;
        assertEquals(exp,UniqueString.isUnique(test));
        test="Unique";
        exp=true;
        assertEquals(exp,UniqueString.isUnique(test));
        test="";
        exp=true;
        assertEquals(exp,UniqueString.isUnique(test));
        test=null;
        exp=true;
        assertEquals(exp,UniqueString.isUnique(test));


    }
}
