package org.example.calculate.operator;

public class AddCommand implements Command {

    @Override
    public int execute(int a, int b) {
        return a + b;
    }
}
