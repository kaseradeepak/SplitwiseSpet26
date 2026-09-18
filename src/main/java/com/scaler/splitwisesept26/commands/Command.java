package com.scaler.splitwisesept26.commands;

public interface Command {
    boolean matches(String command);

    void execute(String command);
}
