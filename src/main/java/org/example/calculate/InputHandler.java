package org.example.calculate;

import java.util.Scanner;

public class InputHandler {

    Validator validator;

    public InputHandler(Validator validator) {
        this.validator = validator;
    }

    public String input() {
        Scanner sc = new Scanner(System.in);
        String input = "";

        input = removeSpace(sc.nextLine());
        if(!validator.isValid(input)) {
            closeScanner(sc);
            throw new IllegalArgumentException("invalid input");
        }

        if(input.equals("exit")) {
            closeScanner(sc);
        }
        return input;
    }

    private String removeSpace(String input) {
        return input.replaceAll(" ", "");
    }

    private void closeScanner(Scanner sc) {
        sc.close();
    }
}
