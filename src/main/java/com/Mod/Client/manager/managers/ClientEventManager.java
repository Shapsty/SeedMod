package com.Mod.Client.manager.managers;

import com.Mod.Client.command.CommandManager;
import com.Mod.Client.manager.Manager;

import com.Mod.api.util.chat.messages;
import com.mojang.realmsclient.gui.ChatFormatting;
import net.minecraftforge.client.event.ClientChatEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public enum ClientEventManager implements Manager {
    INSTANCE;

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public void onChatSent(ClientChatEvent event) {
        if (event.getMessage().startsWith(CommandManager.getCommandPrefix())) {
            event.setCanceled(true);
            try {
                getMinecraft().ingameGUI.getChatGUI().addToSentMessages(event.getMessage());
                CommandManager.callCommand(event.getMessage().substring(1));
            } catch (Exception e) {
                e.printStackTrace();
                messages.sendMessageToClientRaw(ChatFormatting.DARK_RED + "Error: " + e.getMessage(), true);
            }
        }
    }
}
