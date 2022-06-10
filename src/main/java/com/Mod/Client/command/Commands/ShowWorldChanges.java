package com.Mod.Client.command.Commands;

import com.Mod.Client.command.Command;

@Command.Declaration(name = "SeedOverlay", syntax ="SO [seed]")
public class ShowWorldChanges extends Command {
    //main seed overlay command thing
    public void onCommand(String command, String[] message){
        String main = message[0];
        String seed = message[1];

    }
    private static int showChanges(){
        int blocks = 0;
        // next we need to find out what chunk the player is in

        return blocks;
    }
    private static int returnPlayerDim(){
        int Dimension = 0;

        if (mc.player.dimension == -1){
            Dimension = -1;
        }

        return Dimension;
    }
}
