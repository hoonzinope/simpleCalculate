package org.example.calculate.operator;

public class RemainCommand implements Command {

    @Override
    public int execute(int a, int b) {
        return a % b;
    }
}
