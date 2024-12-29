package katas.exercises;

import java.util.Stack;

public class ValidParentheses {

    /**
     * Checks if a given string has valid parentheses (try in O(n)).
     *
     * A string has valid parentheses if:
     * 1. Every opening parenthesis has a matching closing parenthesis.
     * 2. The parentheses are correctly nested.
     *
     * @param s the input string containing parentheses
     * @return true if the string has valid parentheses, false otherwise
     */

    public static boolean isValidParentheses(String s) {
        // Hint for efficient implementation: stack
        Stack<Character> stack=new Stack<>();
        int i=0;
        char lastChar='m';
       while( i <s.length())
        {
            if(s.charAt(i)=='(' || s.charAt(i)=='[' || s.charAt(i)=='{')
            {
                stack.push(s.charAt(i));


                i++;
            }
            else if(s.charAt(i)==')' || s.charAt(i)==']' || s.charAt(i)=='}')
            {
                if(stack.isEmpty() || !isMatching(stack.peek(),s.charAt(i)))
                {
                    return false;
                }
                else if(isMatching(stack.peek(),s.charAt(i)))
                {

                    stack.pop();
                    i++;
                }

            }
            else{
                i++;
            }
        }
        return stack.isEmpty();
    }
    public static boolean isMatching(char c1,char c2)
    {
        return (c1=='[' && c2==']')|| (c1=='{' && c2=='}')||(c1=='(' && c2==')');


    }

    public static void main(String[] args) {
        String validInput = "()[]{}";
        String invalidInput1 = "(]";
        String invalidInput2 = "([)]";
        String validInputNested = "{[()]}";


        System.out.println("Is valid: " + isValidParentheses(validInput));
        System.out.println("Is valid: " + isValidParentheses(invalidInput1));
        System.out.println("Is valid: " + isValidParentheses(invalidInput2));
        System.out.println("Is valid: " + isValidParentheses(validInputNested));
    }
}
