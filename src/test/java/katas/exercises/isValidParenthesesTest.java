package katas.exercises;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class isValidParenthesesTest {
    @Test
    public void testIsValidParentheses(){
        assertEquals(true, ValidParentheses.isValidParentheses("()"), "Should return true for simple valid parentheses");
        assertEquals(true, ValidParentheses.isValidParentheses("()[]{}"), "Should return true for mixed valid parentheses");
        assertEquals(true, ValidParentheses.isValidParentheses("{[()]}"), "Should return true for nested valid parentheses");
        assertEquals(true, ValidParentheses.isValidParentheses(""), "Should return true for an empty string");
        assertEquals(false, ValidParentheses.isValidParentheses("(]"), "Should return false for mismatched parentheses");
        assertEquals(false, ValidParentheses.isValidParentheses("([)]"), "Should return false for incorrectly nested parentheses");
        assertEquals(false, ValidParentheses.isValidParentheses("("), "Should return false for unmatched opening parenthesis");
        assertEquals(false, ValidParentheses.isValidParentheses(")"), "Should return false for unmatched closing parenthesis");
        assertEquals(true, ValidParentheses.isValidParentheses("(a[b]{c})"), "Should return true for valid parentheses with extra characters");
        assertEquals(false, ValidParentheses.isValidParentheses("(a[b]c}"), "Should return false for invalid parentheses with extra characters");

    }
}
