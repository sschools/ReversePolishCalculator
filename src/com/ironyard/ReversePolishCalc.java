package com.ironyard;

public class ReversePolishCalc {

    private int stackTop = 0;

    private String[] tokens;

    // The stack
    private String[] stack;

    public double calculate(String input) {

        tokens = input.split(",");

        // 2. Allocate a stack as big as the number of tokens
        stack = new String [tokens.length];

        // 3. write the algorithm
        for(int i = 0; i < tokens.length; ++i) {
            if (tokens[i].equals("+")) {
                double temp1 = pop();
                double temp2 = pop();
                push(temp1 + temp2);
            } else {
                push(tokens[i]);
            }

        }

        // 4. return the result
        return pop();
    }

    private void push(String number) {
        // push on the stack
        stack[stackTop] = number;
        stackTop += 1;
    }

    private void push(double d) {
        // change the double to a string and then push it on the stack
        String temp = Double.toString(d);
        stack[stackTop] = temp;
        stackTop += 1;
    }

    private double pop() {
        // remove the string from the top of the stack and convert it to a double and return it (double)
        double result = Double.parseDouble(stack[stackTop]);
        stackTop -= 1;
        return result;
    }
}
