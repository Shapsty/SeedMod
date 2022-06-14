package com.Mod.Client.command.Commands;

import com.Mod.Client.command.Command;
import com.Mod.Client.command.CommandManager;
import com.Mod.api.util.chat.messages;

@Command.Declaration(name = "Commands", syntax = "commands", alias = {"commands", "cmd", "command", "commandlist", "help"})
public class CmdListCommand extends Command {

    public void onCommand(String command, String[] message) {
        for (Command command1 : CommandManager.getCommands()) {
            messages.sendCommandMessage(command1.getName() + ": " + "\"" + command1.getSyntax() + "\"!", true);
        }
    }
}
