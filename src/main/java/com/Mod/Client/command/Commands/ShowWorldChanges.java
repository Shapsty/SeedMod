package com.Mod.Client.command.Commands;

import com.Mod.Client.command.Command;
import com.seedfinding.mcbiome.biome.Biome;
import com.seedfinding.mcbiome.biome.Biomes;
import com.seedfinding.mcbiome.source.BiomeSource;
import com.seedfinding.mccore.state.Dimension;
import com.seedfinding.mccore.version.MCVersion;
import com.seedfinding.mcterrain.TerrainGenerator;

@Command.Declaration(name = "SeedOverlay", syntax ="SO [seed]")
public class ShowWorldChanges extends Command {
    /*use these as a reference
    https://github.com/seedfinding/mc_terrain_java
    https://github.com/SeedFinding/mc_core_java

    https://github.com/xpple/SeedMapper/blob/master/src/main/java/dev/xpple/seedmapper/command/ClientCommand.java
    https://github.com/xpple/SeedMapper/blob/master/src/main/java/dev/xpple/seedmapper/command/commands/SeedOverlayCommand.java
    https://github.com/xpple/SeedMapper/blob/master/src/main/java/dev/xpple/seedmapper/command/CustomClientCommandSource.java

    Use messages.java for sending info to the user via the cha
     */


    //main seed overlay command thing
    public void onCommand(String command, String[] message){
        String main = message[0];
        String seed = message[1];

    }
    private static int showChanges(String seed){
        BiomeSource biomeSource = BiomeSource.of(Dimension.valueOf(returnPlayerDim()), MCVersion.v1_12_2, Long.parseLong(seed));
        TerrainGenerator generator = TerrainGenerator.of(Dimension.valueOf(returnPlayerDim()), biomeSource);

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
