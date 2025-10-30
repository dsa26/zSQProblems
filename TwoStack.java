public class TwoStack {
    public static int compute(String expression) {
        StackLL<Character> operators = new StackLL<>();
        StackLL<Integer> operands = new StackLL<>();
        String tempOperand = "";
        expression = expression.replaceAll(" ", "");
        for (int i = 0; i < expression.length(); i++) {
            char current = expression.charAt(i);
            if (current == '+' || current == '-' || current == '/' || current == '*' || current == '^') {
                operators.push(current);
            } else if (Character.isDigit(current)) {
                tempOperand += current;
                if (i == (expression.length() - 1)) {
                    throw new IllegalArgumentException("Last character has to be a ')'");
                }
                if (!Character.isDigit(expression.charAt(i + 1))) {
                    operands.push(Integer.parseInt(tempOperand));
                    tempOperand = "";
                }
            } else if (current == ')') {
                char operator = operators.pop();
                int operand1 = operands.pop();
                int operand2 = operands.pop();
                int evaluated = 0; // Since operator stack can only have valid operators, one case will always be
                                   // evaluated
                switch (operator) {
                    case '+':
                        evaluated = operand1 + operand2;
                        break;
                    case '-':
                        evaluated = operand1 - operand2;
                        break;
                    case '*':
                        evaluated = operand1 * operand2;
                        break;
                    case '/':
                        evaluated = operand2 / operand1; // Order matters for division
                        break;
                    case '^':
                        evaluated = (int) Math.pow(operand2, operand1); // Casting from double to int
                        break;
                }
                operands.push(evaluated);
            } else if (current != '(') {
                throw new IllegalArgumentException("Illegal character in expression: " + current);
            }
        }
        return operands.pop();
        /*
         * Extension: Thinking I'd have to iterate through the operators stack and
         * evaluate in standard order of operations
         */
    }
}
