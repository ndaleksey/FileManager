package com.nd.command;

import com.nd.command.Command;
import com.nd.command.LsCommand;
import com.nd.command.RmCommand;

import java.util.*;

public class CommandResolver {
    private static final String RM_NAME = "rm";
    private static final String LS_NAME = "ls";
    private static final List<String> cmdName = Arrays.asList(RM_NAME, LS_NAME);
    private static final HashMap<String, Command> commands = new HashMap<>();

    static {
        commands.put(RM_NAME, new RmCommand());
        commands.put(LS_NAME, new LsCommand());
    }

    public CommandResolver() {

    }

    public Command resolve(String[] input) {
        if (input == null || input.length < 1) {
            throw new IllegalArgumentException("Cant resolve empty string");
        }

        String cmdName = input[0];
        Command cmd = commands.get(cmdName);

        if (cmd == null) {
            throw new IllegalArgumentException("Command with name " + cmdName + " cannot be resolved");
        }

        initCommand(cmd, input);

        return cmd;
    }

    void initCommand(Command cmd, String... input) {
        cmd.init(input);
    }
}
