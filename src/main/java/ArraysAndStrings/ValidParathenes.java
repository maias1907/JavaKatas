package ArraysAndStrings;

import java.util.Stack;

public class ValidParathenes {
    public boolean isValid(String s) {
        Stack<Character> stackOpen = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '[' || ch == '(' || ch == '{') {
                stackOpen.push(ch);
            } else if (ch == ']' || ch == ')' || ch == '}') {
                 char ch1=stackOpen.pop();
                if ((ch=='[' && ch1!=']') || (ch=='{' && ch1!='}') ||(ch=='(' && ch1!=')') )
                {
                    return false;
                }

            }

        }
        return stackOpen.isEmpty() ;
    }
}
