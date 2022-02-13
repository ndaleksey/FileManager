package com.nd;

import com.nd.command.Command;
import com.nd.command.CommandResolver;

import java.io.File;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class FileManager {
    private static final String CURRENT_PATH = "/home/nd/Projects/Java/FileManager/test";
    private static final String STOP_WORD = "exit";
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to FileManager 1.0");
        CommandParser parser = new CommandParser();
        CommandResolver resolver = new CommandResolver();

        File currentPath = new File(CURRENT_PATH);
        if (!currentPath.exists()) {
            System.out.println("Cannot start programme. Check current path parameter and try again");
            return;
        }

        do {
            System.out.println("Enter command:  ");
            String input = scanner.nextLine();

            if (STOP_WORD.equalsIgnoreCase(input)) {
                System.out.println("Bye-bye");
                return;
            }

            Command cmd = resolver.resolve(parser.parse(input));
            cmd.execute(currentPath);
        } while (true);
    }
}
