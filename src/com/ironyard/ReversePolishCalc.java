package com.ironyard;

public class ReversePolishCalc {

    private int stackTop = 0;

    private String[] tokens;

    private String[] stack;

    public double calculate(String input) {

        tokens = input.split(",");

        stack = new String [tokens.length];

        for(int i = 0; i < tokens.length; ++i) {
            if (tokens[i].equals("+")) {
                double temp1 = pop();
                double temp2 = pop();
                push(temp1 + temp2);
            } else if (tokens[i].equals("-")) {
                double temp1 = pop();
                double temp2 = pop();
                push(temp2 - temp1);
            } else if (tokens[i].equals("*")) {
                double temp1 = pop();
                double temp2 = pop();
                push(temp1 * temp2);
            } else if (tokens[i].equals("/")) {
                double temp1 = pop();
                double temp2 = pop();
                push(temp2 / temp1);
            } else {
                push(tokens[i]);
            }
        }
        return pop();
    }

    private void push(String number) {
        stack[stackTop] = number;
        stackTop += 1;
    }

    private void push(double d) {
        String temp = Double.toString(d);
        stack[stackTop] = temp;
        stackTop += 1;
    }

    private double pop() {
        double result = Double.parseDouble(stack[stackTop - 1]);
        stackTop -= 1;
        return result;
    }
}
