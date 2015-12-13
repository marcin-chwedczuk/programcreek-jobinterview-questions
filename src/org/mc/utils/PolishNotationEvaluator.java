package org.mc.utils;

import java.util.Stack;

public class PolishNotationEvaluator {

    public static int eval(String[] expression) {
        if (expression == null)
            throw new IllegalArgumentException("expression cannot be null");

        Stack<Integer> stack = new Stack<Integer>();

        for (String term : expression) {
            if (isOperator(term)) {
                Operator op = getOperator(term);
                op.apply(stack);
            }
            else if (isNumber(term)) {
                stack.push(Integer.valueOf(term));
            }
            else {
                throw new InvalidExpression("Invalid term: " + term);
            }
        }

        if (stack.size() != 1)
            throw new InvalidExpression("Badly balanced expression");

        return stack.pop();
    }

    private static boolean isNumber(String term) {
        if (term == null)
            return false;

        return term.matches("^[+-]?\\d{1,8}$");
    }

    private static boolean isOperator(String term) {
        if (term == null)
            return false;

        return term.matches("^[-+*/]$");
    }

    private static Operator getOperator(String term) {
        if ("+".equals(term))
            return new PlusOperator();
        else if ("-".equals(term))
            return new SubtractOperator();
        else if ("*".equals(term))
            return new MultiplyOperator();
        else if ("/".equals(term))
            return new DivideOperator();
        else
            throw new IllegalArgumentException("Unknown operator: " + term);
    }

    private interface Operator {
        void apply(Stack<Integer> arguments);
    }

    private static class PlusOperator implements Operator {
        public void apply(Stack<Integer> arguments) {
            if (arguments.size() < 2)
                throw new InvalidExpression("Unbalanced expression");

            arguments.push(arguments.pop() + arguments.pop());
        }
    }

    private static class SubtractOperator implements Operator {
        public void apply(Stack<Integer> arguments) {
            if (arguments.size() < 2)
                throw new InvalidExpression("Unbalanced expression");

            int op2 = arguments.pop();
            int op1 = arguments.pop();

            arguments.push(op1 - op2);
        }
    }

    private static class MultiplyOperator implements Operator {
        public void apply(Stack<Integer> arguments) {
            if (arguments.size() < 2)
                throw new InvalidExpression("Unbalanced expression");

            arguments.push(arguments.pop() * arguments.pop());
        }
    }

    private static class DivideOperator implements Operator {
        public void apply(Stack<Integer> arguments) {
            if (arguments.size() < 2)
                throw new InvalidExpression("Unbalanced expression");

            int op2 = arguments.pop();
            int op1 = arguments.pop();

            arguments.push(op1 / op2);
        }
    }
}
