import java.util.Stack;

public class InfixToPrefix {

    // Method to get precedence of operators
    private static int precedence(char op) {
        switch (op) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }

    // Method to convert infix expression to postfix
    private static String infixToPostfix(String infix) {
        Stack<Character> stack = new Stack<>();
        StringBuilder postfix = new StringBuilder();
        
        for (int i = 0; i < infix.length(); i++) {
            char c = infix.charAt(i);
            
            // If the character is an operand, add it to postfix
            if (Character.isLetterOrDigit(c)) {
                postfix.append(c);
            } 
            // If the character is '(', push it to stack
            else if (c == '(') {
                stack.push(c);
            } 
            // If the character is ')', pop and append from the stack until '(' is encountered
            else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfix.append(stack.pop());
                }
                stack.pop(); // Remove '('
            } 
            // An operator is encountered
            else {
                while (!stack.isEmpty() && precedence(c) <= precedence(stack.peek())) {
                    postfix.append(stack.pop());
                }
                stack.push(c);
            }
        }
        
        // Pop all remaining operators from the stack
        while (!stack.isEmpty()) {
            postfix.append(stack.pop());
        }
        
        return postfix.toString();
    }

    // Method to convert infix expression to prefix expression
    public static String infixToPrefix(String infix) {
        // Step 1: Reverse the infix expression
        StringBuilder reversedInfix = new StringBuilder(infix).reverse();
        
        // Step 2: Replace '(' with ')' and vice versa
        for (int i = 0; i < reversedInfix.length(); i++) {
            char c = reversedInfix.charAt(i);
            if (c == '(') {
                reversedInfix.setCharAt(i, ')');
            } else if (c == ')') {
                reversedInfix.setCharAt(i, '(');
            }
        }
        
        // Step 3: Convert modified infix expression to postfix
        String postfix = infixToPostfix(reversedInfix.toString());
        
        // Step 4: Reverse the postfix expression
        return new StringBuilder(postfix).reverse().toString();
    }

    public static void main(String[] args) {
        String infix = "A*(B+C)/D";
        String prefix = infixToPrefix(infix);
        System.out.println("Prefix Expression: " + prefix);
    }
}
