import java.util.Stack;

public class PostfixToInfix {

    // Method to convert postfix expression to infix expression
    public static String postfixToInfix(String postfix) {
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
                
                // Form the infix expression and push it onto the stack
                String infixExpr = "(" + operand1 + c + operand2 + ")";
                stack.push(infixExpr);
            }
        }
        
        // The final result is the infix expression
        return stack.pop();
    }

    public static void main(String[] args) {
        String postfix = "ABC*+";
        String infix = postfixToInfix(postfix);
        System.out.println("Infix Expression: " + infix);
    }
}
