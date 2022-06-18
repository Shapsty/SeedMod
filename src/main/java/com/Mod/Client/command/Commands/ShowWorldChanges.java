package com.Mod.Client.command.Commands;

import com.Mod.Client.SeedMod;
import com.Mod.Client.command.Command;
import com.Mod.api.util.chat.messages;
import com.Mod.api.util.map.SimpleBlockMap;
import com.Mod.api.util.render.RenderUtil;
import com.Mod.api.util.render.SeedModColor;
import com.seedfinding.mcbiome.biome.Biome;
import com.seedfinding.mcbiome.biome.Biomes;
import com.seedfinding.mcbiome.source.BiomeSource;
import com.seedfinding.mccore.state.Dimension;
import com.seedfinding.mccore.version.MCVersion;
import com.seedfinding.mcterrain.TerrainGenerator;
import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.chunk.Chunk;

import java.util.HashMap;
import java.util.Map;

@Command.Declaration(name = "SeedOverlay", syntax ="so [seed]", alias = {"so", "seedoverlay"})
public class ShowWorldChanges extends Command {
    private static Map<BlockPos.MutableBlockPos,String> boxes = new HashMap<>();

    /*use these as a reference
    https://github.com/seedfinding/mc_terrain_java
    https://github.com/SeedFinding/mc_core_java
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
        setEnabled(true);
        messages.sendCommandMessage("1.12 Seed Overlay Started", true);
        boxes.clear();

        SeedModColor containerColor = new SeedModColor(255, 255, 0, 100);
        final int AIR_ID = com.seedfinding.mccore.block.Blocks.AIR.getId();
        BiomeSource biomeSource = BiomeSource.of(returnPlayerDim(), MCVersion.v1_12_2, Long.parseLong(seed));
        TerrainGenerator generator = TerrainGenerator.of(returnPlayerDim(), biomeSource);
        BlockPos.MutableBlockPos mutable = new BlockPos.MutableBlockPos();
        final BlockPos center = new BlockPos(mc.player.getPosition());
        final SimpleBlockMap map = new SimpleBlockMap(MCVersion.v1_12_2, returnPlayerDim(), Biomes.PLAINS);
        final Chunk chunk = mc.world.getChunk(center.getX() >> 4, center.getZ() >> 4);
        final ChunkPos chunkPos = chunk.getPos();

        int blocks = 0;

        for (int x = chunkPos.getXStart(); x <= chunkPos.getXEnd(); x++) {

            for (int z = chunkPos.getZStart(); z <= chunkPos.getZEnd(); z++) {
                final com.seedfinding.mccore.block.Block[] column = generator.getColumnAt(x, z);
                final Biome biome = biomeSource.getBiome(x, 0, z);

                map.setBiome(biome);

                for (int y = 0; y < column.length; y++) {
                    mutable.setPos(x, y, z);

                    final Block terrainBlock = chunk.getBlockState(mutable).getBlock();
                    String terrainBlockName = Block.REGISTRY.getNameForObject(terrainBlock).getPath();

                    if (map.get(terrainBlock) == column[y].getId()) {
                        continue;
                    }
                    //temp fix while I figure out how to use predicates On Maps or alternate how terrain generates
                    if (map.get(terrainBlock) == AIR_ID && mutable.getY() <= 40){
                        continue;
                    }
                    boxes.put(mutable, terrainBlockName);
                    messages.sendCommandMessage("Block at " + "X: " +mutable.getX() + " Y: " + mutable.getY()+ " Z: " + mutable.getZ() + " is " + terrainBlockName, true);
                    blocks++;
                }
            }
        }
        if (blocks > 0) {
            messages.sendCommandMessage(blocks + " do not match", true);
            SeedMod.logger.info(boxes);
            boxes.forEach((key, value) -> RenderUtil.drawBoundingBox(mc.world.getBlockState(key).getSelectedBoundingBox(mc.world, key), 2, containerColor));
        }
        messages.sendCommandMessage("1.12 Seed Overlay Complete", true);
        setEnabled(false);
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