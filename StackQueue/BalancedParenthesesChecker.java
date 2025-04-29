import java.util.Stack;
public class BalancedParenthesesChecker {
    public static boolean isBalanced(String str) {
        // Stack to store opening brackets
        Stack<Character> stack = new Stack<>();
        // Iterate through each character in the string
        for (char ch : str.toCharArray()) {
            // Push opening brackets onto the stack
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } 
            // Check closing brackets
            else if (ch == ')' || ch == '}' || ch == ']') {
                // If stack is empty, parentheses are unbalanced
                if (stack.isEmpty()) {
                    return false;
                }
                
                // Pop the stack and check if it matches the current closing bracket
                char top = stack.pop();
                if (!isMatchingPair(top, ch)) {
                    return false;
                }
            }
        }
        
        // After processing all characters, stack should be empty
        return stack.isEmpty();
    }

    // Helper method to check if brackets match
    private static boolean isMatchingPair(char open, char close) {
        return (open == '(' && close == ')') ||
               (open == '{' && close == '}') ||
               (open == '[' && close == ']');
    }

    public static void main(String[] args) {
        String input = "{[()]}"; // Test string
        if (isBalanced(input)) {
            System.out.println("The string is balanced.");
        } else {
            System.out.println("The string is not balanced.");
        }
    }
}

