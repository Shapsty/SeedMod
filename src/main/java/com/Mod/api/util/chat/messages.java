package com.Mod.api.util.chat;

import com.mojang.realmsclient.gui.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.util.text.TextComponentString;

public class messages {
    protected static final Minecraft mc = Minecraft.getMinecraft();

    public static void sendCommandMessage(String message, boolean prefix){
            String watermark1 = prefix ? ChatFormatting.LIGHT_PURPLE + "[" + mc.player.getName() + "] " : "";
            TextComponentString string = new TextComponentString(watermark1 + ChatFormatting.LIGHT_PURPLE + message);

            mc.player.sendMessage(string);
    }
}
