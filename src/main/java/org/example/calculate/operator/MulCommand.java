package org.example.calculate.operator;

public class MulCommand implements Command {

    @Override
    public int execute(int a, int b) {
        return a * b;
    }
}
