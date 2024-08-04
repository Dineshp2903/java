import java.util.Stack;

public class InfixToPostfix {

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
    public static String infixToPostfix(String infix) {
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

    public static void main(String[] args) {
        String infix = "A*(B+C)/D";
        String postfix = infixToPostfix(infix);
        System.out.println("Postfix Expression: " + postfix);
    }
}
