import java.util.Stack;

public class PrefixToPostfix {

    // Method to convert prefix expression to postfix expression
    public static String prefixToPostfix(String prefix) {
        Stack<String> stack = new Stack<>();
        
        // Reverse the prefix expression
        String reversedPrefix = new StringBuilder(prefix).reverse().toString();
        
        // Process each character in the reversed prefix expression
        for (int i = 0; i < reversedPrefix.length(); i++) {
            char c = reversedPrefix.charAt(i);
            
            // If the character is an operand, push it onto the stack
            if (Character.isLetterOrDigit(c)) {
                stack.push(Character.toString(c));
            } 
            // If the character is an operator
            else if (c == '+' || c == '-' || c == '*' || c == '/' || c == '^') {
                // Pop two operands from the stack
                String operand1 = stack.pop();
                String operand2 = stack.pop();
                
                // Form the postfix expression and push it onto the stack
                String postfixExpr = operand1 + operand2 + c;
                stack.push(postfixExpr);
            }
        }
        
        // The final result is the postfix expression
        return stack.pop();
    }

    public static void main(String[] args) {
        String prefix = "*A+BC";
        String postfix = prefixToPostfix(prefix);
        System.out.println("Postfix Expression: " + postfix);
    }
}
