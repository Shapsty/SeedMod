package com.Mod.Client.command.Commands;

import com.Mod.Client.command.Command;
import com.seedfinding.mcbiome.biome.Biome;
import com.seedfinding.mcbiome.biome.Biomes;
import com.seedfinding.mcbiome.source.BiomeSource;
import com.seedfinding.mcterrain.TerrainGenerator;

@Command.Declaration(name = "SeedOverlay", syntax ="SO [seed]")
public class ShowWorldChanges extends Command {
    //main seed overlay command thing
    public void onCommand(String command, String[] message){
        String main = message[0];
        String seed = message[1];

    }
    private static int showChanges(){
        //BiomeSource biomeSource = BiomeSource.of()
        //TerrainGenerator generator = TerrainGenerator

        int blocks = 0;
        // next we need to find out what chunk the player is in
        return blocks;
    }
    private static String returnPlayerDim(){
        String playerDim = "";

        switch (mc.player.dimension){
            case 0:
                playerDim = "Overworld";
                break;
            case -1:
                playerDim = "Nether";
                break;
            case 1:
                playerDim = "End";
                break;
        }
        return playerDim;
    }
}
