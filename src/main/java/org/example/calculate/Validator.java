package org.example.calculate;

public class Validator {

    public boolean isValid(String input) {
        return isInputEmpty(input) && isValidBrace(input) && isValidBracket(input) && isValidParentheses(input);
    }
    private boolean isInputEmpty(String input) {
        return input != null && !input.isEmpty();
    }
    private boolean isValidParentheses(String input) {
        int cnt = 0;
        for(int i = 0; i < input.length(); i++) {
            if(input.charAt(i) == '(') {
                cnt++;
            } else if(input.charAt(i) == ')') {
                cnt--;
            }
        }
        return cnt == 0;
    }

    private boolean isValidBrace(String input) {
        int cnt = 0;
        for(int i = 0; i < input.length(); i++) {
            if(input.charAt(i) == '{') {
                cnt++;
            } else if(input.charAt(i) == '}') {
                cnt--;
            }
        }
        return cnt == 0;
    }

    private boolean isValidBracket(String input) {
        int cnt = 0;
        for(int i = 0; i < input.length(); i++) {
            if(input.charAt(i) == '[') {
                cnt++;
            } else if(input.charAt(i) == ']') {
                cnt--;
            }
        }
        return cnt == 0;
    }


}
