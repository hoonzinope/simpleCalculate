package org.example.calculate;

public class CalculateMain {

    public void run() {
        while (true) {
            System.out.println("Enter an expression or 'exit' to exit:");
            InputHandler inputHandler = new InputHandler(new Validator());
            String input = inputHandler.input();
            if(input.equals("exit")) {
                System.out.println("Bye!");
                break;
            }
            System.out.println("input: " + input);
            Parser parser = new Parser();
            String result = parser.parse(input);
            System.out.println(result);
        }
    }

}
