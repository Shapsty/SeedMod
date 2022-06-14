package com.Mod.Client.command.Commands;

import com.Mod.Client.command.Command;
import com.Mod.Client.command.CommandManager;
import com.Mod.api.util.chat.messages;

@Command.Declaration(name = "Prefix", syntax = "prefix value (no letters or numbers)", alias = {"prefix", "p"})
public class PrefixCommand extends Command {

    public void onCommand(String command, String[] message) {
        String main = message[0].toUpperCase().replaceAll("[a-zA-Z0-9]", null);

        if (main != null && message.length == 1) {
            CommandManager.setCommandPrefix(main);
            messages.sendCommandMessage("Prefix set: \"" + main + "\"!", true);
        } else if (message.length != 1) {
            messages.sendCommandMessage(this.getSyntax(), true);
        }
    }
}
