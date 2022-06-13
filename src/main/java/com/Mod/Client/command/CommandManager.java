package com.Mod.Client.command;

import com.Mod.Client.command.Commands.PrefixCommand;
import com.Mod.Client.command.Commands.ShowWorldChanges;
import com.Mod.api.util.chat.messages;

import java.util.ArrayList;

public class CommandManager {
    public static String COMMANDPREFIX = ";";
    public static final ArrayList<Command> commands = new ArrayList<>();

    public CommandManager(){
        //init all commands via addCommand method
        addCommand(new ShowWorldChanges());
        addCommand(new PrefixCommand());
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

    public static void setCommandPrefix(String prefix) {
        COMMANDPREFIX = prefix;
    }

    /**
     * Author 086 for KAMI, regex
     **/

    public static boolean isValidCommand = false;

    public static void callCommand(String input) {
        String[] split = input.split(" (?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
        String command1 = split[0];
        String args = input.substring(command1.length()).trim();

        isValidCommand = false;

        commands.forEach(command -> {
            if (command.getName().equalsIgnoreCase(command1)) {
                isValidCommand = true;
                try {
                    command.onCommand(args, args.split(" (?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)"));
                } catch (Exception e) {
                    messages.sendCommandMessage(command.getSyntax(), true);
                }
            }
        });

        if (!isValidCommand) {
            messages.sendCommandMessage("Error! Invalid command!", true);
        }
    }
}
