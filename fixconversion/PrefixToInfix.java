import java.util.Stack;

public class PrefixToInfix {

    // Method to convert prefix expression to infix expression
    public static String prefixToInfix(String prefix) {
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
                
                // Form the infix expression and push it onto the stack
                String infixExpr = "(" + operand1 + c + operand2 + ")";
                stack.push(infixExpr);
            }
        }
        
        // The final result is the infix expression
        return stack.pop();
    }

    public static void main(String[] args) {
        String prefix = "*A+BC";
        String infix = prefixToInfix(prefix);
        System.out.println("Infix Expression: " + infix);
    }
}
