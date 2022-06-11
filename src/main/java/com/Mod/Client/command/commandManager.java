package com.Mod.Client.command;

import com.Mod.Client.command.Commands.ShowWorldChanges;

import java.util.ArrayList;

public class commandManager {
    public static final String COMMANDPREFIX = "se1";
    public static final ArrayList<Command> commands = new ArrayList<>();

    public static void init(){
        //init all commands via addCommand method
        addCommand(new ShowWorldChanges());
    }

    public static void addCommand(Command command) {
        commands.add(command);
    }

    public static ArrayList<Command> getCommands() {
        return commands;
    }

    public static String getCommandPrefix() {
        return COMMANDPREFIX;
    }

    public static void callCommand(){
        //some how call a command haven't really thought up how.
    }
}
