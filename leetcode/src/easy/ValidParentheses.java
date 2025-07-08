package easy;

import java.util.Stack;

public class ValidParentheses {


    public boolean isValid(String s) {

        // use a stack to validate matching parentheses: (), {}, []
        // for every opening bracket, push the corresponding closing bracket on the stack
        // when encountering a closing bracket, check if it matches the tope of the stack.
        // if not, return false
        // if the stack is not empty at the end, return false

        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()) {
            if(c == '(' || c == '{' || c == '[') stack.add(c);
            else {
                if(stack.isEmpty()) return false;
                char topStackEl = stack.pop();
                if(topStackEl == '(' && c != ')'
                        || topStackEl == '{' && c != '}'
                        || topStackEl == '[' && c != ']'
                ) return false;
            }
        }
        return stack.isEmpty();
    }

}
