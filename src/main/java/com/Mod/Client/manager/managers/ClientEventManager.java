package com.Mod.Client.manager.managers;

import com.Mod.Client.command.Command;
import com.Mod.Client.command.CommandManager;
import com.Mod.Client.manager.Manager;

import com.Mod.api.util.chat.messages;
import net.minecraftforge.client.event.ClientChatEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public enum ClientEventManager implements Manager {
    INSTANCE;

    /*
     *srgantmoomoo for Main body of code in onChatSent
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
            String commandName = message.split(" ")[0];

            for (Command command : CommandManager.getCommands()) {
                for (String string : command.getAlias()) {
                    if (string.equalsIgnoreCase(commandName)) {
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
