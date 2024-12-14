package katas.exercises;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;



public class DoNTimesTest {
    @Test
    public void testDoNTimes()
    {
// Test 1: Correct execution of the function n times
        final int[] counter = {0};
        Runnable increment = () -> counter[0]++;
        DoNTimes.doNTimes(increment, 5);
        assertEquals(5, counter[0], "Counter should be incremented 5 times");

        // Test 2: When n = 0, the function should not be executed
        counter[0] = 0;
        DoNTimes.doNTimes(increment, 0);
        assertEquals(0, counter[0], "Counter should remain 0 when n = 0");

        // Test 3: When n is negative, the function should not be executed
        counter[0] = 0;
        DoNTimes.doNTimes(increment, -3);  // Assuming negative n does nothing
        assertEquals(0, counter[0], "Counter should remain 0 when n is negative");


        // Test 4: Test for null Runnable (should throw NullPointerException)
        assertThrows(NullPointerException.class, () -> DoNTimes.doNTimes(null, 5));

        // Test 5: Test for empty Runnable, should execute n times but do nothing
        counter[0] = 0;
        Runnable doNothing = () -> {};  // An empty Runnable
        DoNTimes.doNTimes(doNothing, 5);
        assertEquals(0, counter[0], "Counter should remain 0 when Runnable does nothing");


    }
}
