import java.util.Stack;

public class PostfixToPrefix {

    // Method to convert postfix expression to prefix expression
    public static String postfixToPrefix(String postfix) {
        Stack<String> stack = new Stack<>();
        
        for (int i = 0; i < postfix.length(); i++) {
            char c = postfix.charAt(i);
            
            // If the character is an operand, push it onto the stack
            if (Character.isLetterOrDigit(c)) {
                stack.push(Character.toString(c));
            } 
            // If the character is an operator
            else if (c == '+' || c == '-' || c == '*' || c == '/' || c == '^') {
                // Pop two operands from the stack
                String operand2 = stack.pop();
                String operand1 = stack.pop();
                
                // Form the prefix expression and push it onto the stack
                String prefixExpr = c + operand1 + operand2;
                stack.push(prefixExpr);
            }
        }
        
        // The final result is the prefix expression
        return stack.pop();
    }

    public static void main(String[] args) {
        String postfix = "ABC*+";
        String prefix = postfixToPrefix(postfix);
        System.out.println("Prefix Expression: " + prefix);
    }
}
