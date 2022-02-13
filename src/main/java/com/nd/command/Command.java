package com.nd.command;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class Command {
    protected String name;
    protected final List<String> keys = new ArrayList<>();
    protected final List<String> params = new ArrayList<>();
    protected File currentPath;

    public abstract void execute(File currentPath);

    protected abstract void init(String[] input);

    public String getName() {
        return name;
    }

    public List<String> getKeys() {
        return keys;
    }

    public List<String> getParams() {
        return params;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Command command = (Command) o;
        return Objects.equals(name, command.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
