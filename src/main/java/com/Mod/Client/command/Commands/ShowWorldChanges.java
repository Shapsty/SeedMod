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

import java.util.HashMap;

@Command.Declaration(name = "SeedOverlay", syntax ="so [seed]", alias = {"so", "seedoverlay"})
public class ShowWorldChanges extends Command {
    /*use these as a reference
    https://github.com/seedfinding/mc_terrain_java
    https://github.com/SeedFinding/mc_core_java

    https://github.com/xpple/SeedMapper/blob/master/src/main/java/dev/xpple/seedmapper/command/commands/SeedOverlayCommand.java
    https://github.com/xpple/SeedMapper/blob/master/src/main/java/dev/xpple/seedmapper/util/maps/SimpleBlockMap.java
     */


    //main seed overlay command thing
    @Override
    public void onCommand(String command, String[] message){
        String main = message[0];
        String seed = message[1];

        final BlockPos center = new BlockPos(mc.player.getPosition());
        final Chunk chunk = mc.player.getEntityWorld().getChunk(center);
        final ChunkPos chunkPos = chunk.getPos();

        if (main == null || seed == null){
            messages.sendCommandMessage(this.getSyntax(), true);
            return;
        }
        messages.sendCommandMessage("Seed: " + seed, true);
        messages.sendCommandMessage(returnPlayerDim().name(), true);
        messages.sendCommandMessage(String.valueOf(center), true);
        messages.sendCommandMessage(String.valueOf(chunk), true);
        messages.sendCommandMessage(String.valueOf(chunkPos), true);
    }
    private static int showChanges(String seed){
        // before we implement rendering we should just print the missing blocks and their coordinates to the chat

        BiomeSource biomeSource = BiomeSource.of(returnPlayerDim(), MCVersion.v1_12_2, Long.parseLong(seed));
        TerrainGenerator generator = TerrainGenerator.of(returnPlayerDim(), biomeSource);
        BlockPos.MutableBlockPos mutable = new BlockPos.MutableBlockPos();
        final BlockPos center = new BlockPos(mc.player.getPosition());
        //final WorldChunk chunk = mc.player.getWorld().getChunk(center.getX() >> 4, center.getZ() >> 4); This doesn't work for 1.12 but this is what we are trying to implement
        final Chunk chunk = mc.player.getEntityWorld().getChunk(center);
        final ChunkPos chunkPos = chunk.getPos();

        //this also doesnt work for 1.12 but this is what we are trying to implement
        //Map<Box, String> boxes = new HashMap<>();
        int blocks = 0;
        for (int x = chunkPos.getXStart(); x <= chunkPos.getXEnd(); x++){
            for (int z = chunkPos.getZStart(); x <= chunkPos.getZEnd(); z++){

            }
        }
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
