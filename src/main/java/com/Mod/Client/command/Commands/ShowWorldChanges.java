package com.Mod.Client.command.Commands;

import com.Mod.Client.command.Command;

import com.Mod.api.util.chat.messages;
import com.seedfinding.mcbiome.biome.Biome;
import com.seedfinding.mcbiome.biome.Biomes;
import com.seedfinding.mcbiome.source.BiomeSource;
import com.seedfinding.mccore.state.Dimension;
import com.seedfinding.mccore.version.MCVersion;
import com.seedfinding.mcterrain.TerrainGenerator;

import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.chunk.Chunk;

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

        messages.sendMessageToClientRaw("Seed: " + seed);
        messages.sendMessageToClientRaw(returnPlayerDim().name());
    }
    private static int showChanges(String seed){
        // before we implement rendering we should just print the missing blocks and their coordinates to the chat

        // next we need to find the chunk the player is in, I think I may have done this. It might not work though
        BiomeSource biomeSource = BiomeSource.of(returnPlayerDim(), MCVersion.v1_12_2, Long.parseLong(seed));
        TerrainGenerator generator = TerrainGenerator.of(returnPlayerDim(), biomeSource);
        BlockPos.MutableBlockPos mutable = new BlockPos.MutableBlockPos();
       // final BlockPos center = new BlockPos(mc.player.posX, mc.player.posY - 1, mc.player.posZ); //this may also work
        final BlockPos center = new BlockPos(mc.player.getPosition());
        final Chunk chunk = mc.player.getEntityWorld().getChunk(center);
        final ChunkPos chunkPos = chunk.getPos();



        int blocks = 0;
        return blocks;
    }
    private static Dimension returnPlayerDim(){
        Dimension playerDim = Dimension.OVERWORLD;

        switch (mc.player.dimension){
            case 0:
                playerDim = Dimension.OVERWORLD;
                break;
            case -1:
                playerDim = Dimension.NETHER;
                break;
            case 1:
                playerDim = Dimension.END;
                break;
        }
        return playerDim;
    }
}
