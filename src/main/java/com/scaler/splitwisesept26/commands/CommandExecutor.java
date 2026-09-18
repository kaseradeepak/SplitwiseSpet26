package com.scaler.splitwisesept26.commands;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CommandExecutor {
    // Add all the commands in the list.
    private List<Command> commands = List.of(

    );

//    public void addCommand(Command command) {
//        commands.add(command);
//    }

    public void run(String inputCommand) {
        for (Command command : commands) {
            if (command.matches(inputCommand)) {
                command.execute(inputCommand);
            }
        }
    }
}
