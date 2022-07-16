package com.Mod.Client.command.Commands;

import com.Mod.api.util.map.SimpleBlockMap;
import com.mojang.realmsclient.gui.ChatFormatting;

import com.Mod.Client.command.Command;
import com.Mod.Client.command.CommandManager;
import com.Mod.api.util.chat.messages;
import com.seedfinding.mcbiome.biome.Biomes;
import com.seedfinding.mcbiome.source.BiomeSource;
import com.seedfinding.mccore.state.Dimension;
import com.seedfinding.mccore.version.MCVersion;
import com.seedfinding.mcterrain.TerrainGenerator;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.gen.MapGenBase;
import net.minecraft.world.gen.MapGenCaves;
import net.minecraftforge.event.terraingen.TerrainGen;

@Command.Declaration(name="GetBlock", syntax=":)", alias={"block", "b"})
public class GetBlock extends Command {

    public void onCommand(String command, String[] message) {
        String seed = message[1];

        Minecraft minecraft = Minecraft.getMinecraft();
        BlockPos pos = minecraft.player.getPosition();
//        Block block = minecraft.world.getBlockState(pos).getBlock();

        int originalBlock, currentBlock;
        final SimpleBlockMap map = new SimpleBlockMap(MCVersion.v1_12_2, returnPlayerDim(), Biomes.PLAINS);
        BiomeSource biomeSource = BiomeSource.of(returnPlayerDim(), MCVersion.v1_12_2, Long.parseLong(seed));
        TerrainGenerator generator = TerrainGenerator.of(returnPlayerDim(), biomeSource);
        MapGenCaves mgc = new MapGenCaves();
        MapGenBase mgb = TerrainGen.getModdedMapGen(mgc, net.minecraftforge.event.terraingen.InitMapGenEvent.EventType.CAVE);


        BlockPos.MutableBlockPos mutable = new BlockPos.MutableBlockPos();
        final BlockPos center = new BlockPos(mc.player.getPosition());
        final Chunk chunk = mc.world.getChunkFromChunkCoords(center.getX() >> 4, center.getZ() >> 4);
        final Block terrainBlock = chunk.getBlockState(mutable).getBlock();
        currentBlock = generator.getColumnAt(pos.getX(), pos.getZ())[pos.getY()].getId();
        originalBlock = map.get(terrainBlock);

        messages.sendCommandMessage(originalBlock + " => " + currentBlock, false);

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
