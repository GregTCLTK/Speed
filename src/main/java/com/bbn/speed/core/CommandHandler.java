package com.bbn.speed.core;

import com.bbn.speed.commands.Command;

import java.util.HashMap;

public class CommandHandler {

    public static final CommandParser parser = new CommandParser();
    public static HashMap<String, Command> commands = new HashMap<>();

    public static void handleCommand(CommandParser.commandContainer cmd) {
        if (commands.containsKey(cmd.invoke)) {
            System.out.println("Execute");
                commands.get(cmd.invoke).action(cmd.args, cmd.event);
        }
    }
}
