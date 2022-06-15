package com.Mod.Client.command.Commands;

import com.Mod.Client.command.Command;

import com.Mod.api.util.chat.messages;
import com.Mod.api.util.map.SimpleBlockMap;
import com.seedfinding.mcbiome.biome.Biome;
import com.seedfinding.mcbiome.biome.Biomes;
import com.seedfinding.mcbiome.source.BiomeSource;
import com.seedfinding.mccore.state.Dimension;
import com.seedfinding.mccore.version.MCVersion;
import com.seedfinding.mcterrain.TerrainGenerator;
import net.minecraft.util.text.*;

import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.chunk.Chunk;

import java.util.Arrays;
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
    public void onCommand(String command, String[] message) {
        String main = message[0];
        String seed = message[1];

        final BlockPos center = new BlockPos(mc.player.getPosition());
        final Chunk chunk = mc.player.getEntityWorld().getChunk(center);
        final ChunkPos chunkPos = chunk.getPos();

        if (main == null || seed == null) {
            messages.sendCommandMessage(this.getSyntax(), true);
            return;
        }
        messages.sendCommandMessage("Seed: " + seed, true);
        showChanges("-4684036758601247941");
    }

    private static int showChanges(String seed) {
        // before we implement rendering we should just print the missing blocks and their coordinates to the chat
        messages.sendCommandMessage("1.12 Seed Overlay init", true);

        BiomeSource biomeSource = BiomeSource.of(returnPlayerDim(), MCVersion.v1_12_2, Long.parseLong(seed));
        TerrainGenerator generator = TerrainGenerator.of(returnPlayerDim(), biomeSource);
        BlockPos.MutableBlockPos mutable = new BlockPos.MutableBlockPos();
        final BlockPos center = new BlockPos(mc.player.getPosition());
        final SimpleBlockMap map = new SimpleBlockMap(MCVersion.v1_12_2, returnPlayerDim(), Biomes.PLAINS);
        //final WorldChunk chunk = mc.player.getWorld().getChunk(center.getX() >> 4, center.getZ() >> 4); This doesn't work for 1.12 but this is what we are trying to implement
        final Chunk chunk = mc.player.getEntityWorld().getChunk(center);
        final ChunkPos chunkPos = chunk.getPos();

        //this also doesnt work for 1.12 but this is what we are trying to implement
        //Map<Box, String> boxes = new HashMap<>();
        int blocks = 0;
        messages.sendCommandMessage("1.12 Seed Overlay Started", true);
        for (int x = chunkPos.getXStart(); x <= chunkPos.getXEnd(); x++) {
            messages.sendCommandMessage("first for", true);
            messages.sendCommandMessage("X" + x, true);
            messages.sendCommandMessage("Start X" + chunkPos.getXStart(), true);
            messages.sendCommandMessage("endX" + chunkPos.getXEnd(), true);

            for (int z = chunkPos.getZStart(); x <= chunkPos.getZEnd(); z++) {
                messages.sendCommandMessage("Second for", true);
                messages.sendCommandMessage("Set Pos should be here", true);

                final com.seedfinding.mccore.block.Block[] column = generator.getColumnAt(x, z);
                final Biome biome = biomeSource.getBiome(x, 0, z);
                messages.sendCommandMessage("init column:" + column.length + " and biome: " + biome.getName(), true);

                //issue is on this line below this comment
                map.setBiome(biome);

                messages.sendCommandMessage("Set Biome", true);
                for (int y = 0; y < column.length; y++) {
                    messages.sendCommandMessage("Third for", true);
                    mutable.setPos(x, y, z);

                    messages.sendCommandMessage("Set Y", true);

                    final Block terrainBlock = chunk.getBlockState(mutable).getBlock();
                    String terrainBlockName = Block.REGISTRY.getNameForObject(terrainBlock).getPath();
                    messages.sendCommandMessage("Found BlockName", true);

                    if (map.get(terrainBlock) == column[y].getId()) {
                        continue;
                    }
                    messages.sendCommandMessage("Block at " + mutable.toString() + " is " + terrainBlockName, true);
                    blocks++;
                    messages.sendCommandMessage("incremented", true);
                }
            }
        }
        if (blocks > 0) {
            messages.sendCommandMessage(String.valueOf(blocks) + " do not match", true);
        }
        messages.sendCommandMessage("1.12 Seed Overlay Complete", true);
        return blocks;
    }
    private static Dimension returnPlayerDim(){
        Dimension playerDim = Dimension.OVERWORLD;

        switch (mc.player.dimension){
            case 0:
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
