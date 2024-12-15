package katas.exercises;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordCounterTest {
    @Test
    public void testWordCounter()
    {
        // Test case 1: Basic sentence
        assertEquals(5, WordCounter.countWords("Hello this is a test"), "The number of words should be 5");

        // Test case 2: Empty string
        assertEquals(0, WordCounter.countWords(""), "The number of words should be 0 for an empty string");

        // Test case 3: Extra spaces
        assertEquals(5, WordCounter.countWords("  Hello   this   is  a  test  "), "The number of words should be 5 despite extra spaces");

        // Test case 4: Punctuation
        assertEquals(5, WordCounter.countWords("Hello, this is a test!"), "The number of words should be 5, punctuation doesn't affect word count");

        // Test case 5: Null input
        assertEquals(0, WordCounter.countWords(null), "The number of words should be 0 for a null input");

        // Test case 6: One word
        assertEquals(1, WordCounter.countWords("Word"), "The number of words should be 1 for a single word");

        // Test case 7: Numbers
        assertEquals(3, WordCounter.countWords("123 456 789"), "The number of words should be 3, numbers are considered words");

        // Test case 8: Numbers and text
        assertEquals(4, WordCounter.countWords("Test 123 example 456"), "The number of words should be 4, numbers and text are counted as words");
    }
}
