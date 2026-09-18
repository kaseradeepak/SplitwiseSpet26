package com.scaler.splitwisesept26;

import com.scaler.splitwisesept26.commands.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class SplitwiseSept26Application {
    public static void main(String[] args) {
        SpringApplication.run(SplitwiseSept26Application.class, args);

        // settleup user 1234
        //      -> SettleUpCommand -> True
        //      -> RegisterCommand -> False
//        Scanner scanner = new Scanner(System.in);
//
//        String inputCommand = scanner.next();
//
//        List<String> words = List.of(inputCommand.split(" "));
//
//        if (words.get(0).equalsIgnoreCase("settleup")) {
//            if (words.get(1).equalsIgnoreCase("user")) {
//                //call settleUpUser
//            } else if (words.get(1).equalsIgnoreCase("group")) {
//                //call settleUpGroup
//            } else {
//                //throw invalid command exception.
//            }
//        } else if (words.get(0).equalsIgnoreCase("register")) {
//            //
//        } else if (words.get(0).equalsIgnoreCase("login")) {
//            //
//        } ........

//        List<Command> commands = new ArrayList<>();
//        commands.add(new RegisterCommand());
//        commands.add(new LoginCommand());
//        commands.add(new SettleUpCommand());
//
//        Scanner scanner = new Scanner(System.in);
//
//        String inputCommand = scanner.next();
//
//        for (Command command : commands) {
//            if (command.matches(inputCommand)) {
//                command.execute(inputCommand);
//            }
//        }

        CommandExecutor commandExecutor = new CommandExecutor();

        Scanner scanner = new Scanner(System.in);
        String inputCommand = scanner.next();

        commandExecutor.run(inputCommand);
    }
}
