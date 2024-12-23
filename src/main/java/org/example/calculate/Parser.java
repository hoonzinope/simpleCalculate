package org.example.calculate;

import org.example.calculate.operator.*;

public class Parser {

    public String parse(String input) {
        return "result : "+ this.calculate(input);
    }

    private int calculate(String input) {
        for(int i = 0; i< input.length(); i++) {
            if(input.charAt(i) == '(') {
                int j = i;
                int cnt = 1;
                while(cnt != 0) {
                    j++;
                    if(input.charAt(j) == '(') {
                        cnt++;
                    } else if(input.charAt(j) == ')') {
                        cnt--;
                    }
                }
                String sub = input.substring(i+1, j);
                int result = calculate(sub);
                input = input.substring(0, i) + result + input.substring(j+1);
            }
        }

        return checkOperator(input);
    }

    private int checkOperator(String input) {
        if(input.contains("+") || input.contains("-")) {
            for(int i = 0; i < input.length(); i++) {
                if(input.charAt(i) == '+'){
                    return executeCommand(input, new AddCommand(), i);
                }

                if(input.charAt(i) == '-'){
                    return executeCommand(input, new SubCommand(), i);
                }
            }
        }

        if(input.contains("/") || input.contains("%") || input.contains("*")) {
            for(int i = 0; i < input.length(); i++) {
                if(input.charAt(i) == '/') {
                    return executeCommand(input, new DivideCommand(), i);
                }
                if(input.charAt(i) == '%') {
                    return executeCommand(input, new RemainCommand(), i);
                }
                if(input.charAt(i) == '*') {
                    return executeCommand(input, new MulCommand(), i);
                }
            }
        }
        return Integer.parseInt(input);
    }

    private int executeCommand(String input, Command command, int i) {
        return command.execute(checkOperator(input.substring(0, i)), checkOperator(input.substring(i + 1)));
    }
}
