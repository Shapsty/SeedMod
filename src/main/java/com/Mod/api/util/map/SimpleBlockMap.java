package com.Mod.api.util.map;

import com.google.common.collect.ImmutableMap;
import com.seedfinding.mcbiome.biome.Biome;
import com.seedfinding.mccore.block.Blocks;
import com.seedfinding.mccore.state.Dimension;
import com.seedfinding.mccore.version.MCVersion;
import net.minecraft.block.Block;

import java.util.Map;

import static com.seedfinding.mcbiome.biome.Biomes.*;
//import static net.minecraft.block.Blocks.*;
//we need to figure out how to convert this import above this message to work on 1.12.2

// ref:
//https://github.com/xpple/SeedMapper/blob/master/src/main/java/dev/xpple/seedmapper/util/maps/SimpleBlockMap.java

public class SimpleBlockMap {

    private static final int AIR_ID = Blocks.AIR.getId();
    private static final int STONE_ID = Blocks.STONE.getId();
    private static final int END_STONE_ID = Blocks.END_STONE.getId();
    private static final int NETHERRACK_ID = Blocks.NETHERRACK.getId();
    private static final int WATER_ID = Blocks.WATER.getId();
    private static final int LAVA_ID = Blocks.LAVA.getId();

}