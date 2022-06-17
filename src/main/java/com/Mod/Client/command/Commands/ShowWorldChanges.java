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

import com.Mod.Client.SeedMod;

import net.minecraft.block.Block;
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
    public void onCommand(String command, String[] message) {
        String main = message[0];
        String seed = message[1];

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
        final Chunk chunk = mc.world.getChunk(center.getX() >> 4, center.getZ() >> 4);
        final ChunkPos chunkPos = chunk.getPos();

        //this also doesn't work for 1.12 but this is what we are trying to implement
        //Map<Box, String> boxes = new HashMap<>();
        int blocks = 0;
        messages.sendCommandMessage("1.12 Seed Overlay Started", true);

        //these embedded for loops are inf looping. Z increases forever and x never changes.
        for (int x = chunkPos.getXStart(); x <= chunkPos.getXEnd(); x++) {
            SeedMod.logger.info(chunkPos.getXStart() + " " + chunkPos.getZStart());
            SeedMod.logger.info(chunkPos.getXEnd() + " " + chunkPos.getZEnd());

            for (int z = chunkPos.getZStart(); z <= chunkPos.getZEnd(); z++) {
                final com.seedfinding.mccore.block.Block[] column = generator.getColumnAt(x, z);
                final Biome biome = biomeSource.getBiome(x, 0, z);
                SeedMod.logger.info("init column:" + column.length + " and biome: " + biome.getName());

                map.setBiome(biome);

                SeedMod.logger.info("Set Biome");
                for (int y = 0; y < column.length; y++) {
                    mutable.setPos(x, y, z);
                    SeedMod.logger.info("Mutable: " + mutable);

                    final Block terrainBlock = chunk.getBlockState(mutable).getBlock();
                    String terrainBlockName = Block.REGISTRY.getNameForObject(terrainBlock).getPath();
                    SeedMod.logger.info("Found BlockName");

                    if (map.get(terrainBlock) == column[y].getId()) {
                        SeedMod.logger.info("Terrain block "+ map.get(terrainBlock));
                        SeedMod.logger.info("column id " + column[y].getId());
                        SeedMod.logger.info("Block is the same");
                        continue;
                    }
                    messages.sendCommandMessage("Block at " + "X: " +mutable.getX() + " Y: " + mutable.getY()+ " Z: " + mutable.getZ() + " is " + terrainBlockName, true);
                    blocks++;
                    SeedMod.logger.info("incremented");
                }
            }
        }
        if (blocks > 0) {
            messages.sendCommandMessage(blocks + " do not match", true);
        }
        //rendering goes here
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