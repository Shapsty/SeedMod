package com.Mod.api.util;

import com.mojang.realmsclient.gui.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.util.text.TextComponentString;

public class messages {
    public static ChatFormatting messageFormatting = ChatFormatting.GOLD;
    protected static final Minecraft mc = Minecraft.getMinecraft();

    public static void sendMessageToClientRaw(String message){
        TextComponentString string = new TextComponentString(messageFormatting + message);

        mc.player.sendMessage(string);
    }
}
