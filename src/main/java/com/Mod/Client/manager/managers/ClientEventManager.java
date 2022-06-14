package com.Mod.Client.manager.managers;

import com.Mod.Client.command.Command;
import com.Mod.Client.command.CommandManager;
import com.Mod.Client.manager.Manager;

import me.zero.alpine.listener.EventHandler;
import me.zero.alpine.listener.Listener;

import com.Mod.api.util.chat.messages;
import com.mojang.realmsclient.gui.ChatFormatting;
import net.minecraftforge.client.event.ClientChatEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public enum ClientEventManager implements Manager {
    INSTANCE;


    /*
        *srgantmoomoo for OnChatSent body
     */
    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public void onChatSent(ClientChatEvent event) {
        String message = event.getMessage();

        if (!event.getMessage().startsWith(CommandManager.getCommandPrefix())) {
            return;
        }
        event.setCanceled(true);
        message = message.substring(CommandManager.COMMANDPREFIX.length());

        if(message.split(" ").length > 0) {
            boolean commandFound = false;
            String commandName = message.split(" ")[0];

            for (Command command : CommandManager.getCommands()) {
                for (String string : command.getAlias()) {
                    if (string.equalsIgnoreCase(commandName)) {
                        commandFound = true;
                        try {
                            command.onCommand(message, message.split(" "));
                        } catch (Exception e) {
                            messages.sendCommandMessage(command.getSyntax(), true);
                        }
                    }
                }
            }
        }
    }
}
