package com.nd;

public class CommandParser {
    private static final String DELIMITER = " ";
    String[] parse(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("Wrong parameter state: user input string is empty");
        }
        return input.split(DELIMITER);
    }
}
