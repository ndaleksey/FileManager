package com.nd.command;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class RmCommand extends Command {
    private final String RM = "rm";

    public RmCommand() {
        name = RM;
    }

    @Override
    public void execute(File currentPath) {
        if (currentPath == null) {
            throw new IllegalArgumentException("Wrong current path. Cannot proceed. Please, try again");
        }

        File[] files = currentPath.listFiles();

        if (files == null || files.length == 0) {
            System.out.println("There is no files/dirs to delete with such parameters. Try again");
            return;
        }

        for (File file : files) {
            if (getParams().contains(file.getName())) {
                try {
                    Files.delete(file.toPath());
                    System.out.println(file.getName() + " was removed");
                } catch (IOException e) {
                    System.out.println("Cannot delete file/dir: " + file.getName());
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void init(String[] input) {
        if (input.length == 1) {
            throw new IllegalArgumentException(name + " command cannot be initialized with empty params");
        }

        for (int i = 1; i < input.length; i++) {
            getParams().add(input[i]);
        }
    }
}
