package com.Mod.Client.command.Commands;

import com.mojang.realmsclient.gui.ChatFormatting;

import com.Mod.Client.command.Command;
import com.Mod.Client.command.CommandManager;
import com.Mod.api.util.chat.messages;

@Command.Declaration(name = "Prefix", syntax = "prefix value (no letters or numbers)", alias = {"prefix", "p"})
public class PrefixCommand extends Command {

    public void onCommand(String command, String[] message) {
        if (message.length > 1 ){
            String newPrefix = message[1];

            CommandManager.setCommandPrefix(newPrefix);
            messages.sendCommandMessage("Prefix set to " + ChatFormatting.WHITE + CommandManager.COMMANDPREFIX + ChatFormatting.LIGHT_PURPLE, true);
        } else {
            messages.sendCommandMessage(this.getSyntax(), false);
        }
    }
}
