package com.Mod.api.util.map;

import com.google.common.collect.ImmutableMap;
import com.seedfinding.mcbiome.biome.Biome;
import com.seedfinding.mccore.block.Blocks;
import com.seedfinding.mccore.state.Dimension;
import com.seedfinding.mccore.version.MCVersion;
import net.minecraft.block.Block;

import java.util.Map;

import static com.seedfinding.mcbiome.biome.Biomes.*;
import static net.minecraft.init.Blocks.*;


public class SimpleBlockMap {

    /*
     * xpple for basically this entire file I only changed a few things
     */
    private static final int AIR_ID = Blocks.AIR.getId();
    private static final int CAVEAIR_ID = Blocks.CAVE_AIR.getId();
    private static final int STONE_ID = Blocks.STONE.getId();
    private static final int END_STONE_ID = Blocks.END_STONE.getId();
    private static final int NETHERRACK_ID = Blocks.NETHERRACK.getId();
    private static final int WATER_ID = Blocks.WATER.getId();
    private static final int LAVA_ID = Blocks.LAVA.getId();

    private static final Map<MCVersion, Map<Biome, Map<Block, Integer>>> versionedBiomeMap = ImmutableMap.<MCVersion, Map<Biome, Map<Block, Integer>>>builder()
            .put(MCVersion.v1_12_2, ImmutableMap.<Biome, Map<Block, Integer>>builder()
                    .put(OCEAN, ImmutableMap.<Block, Integer>builder()
                            .put(WATER, WATER_ID)
                            .put(GRAVEL, STONE_ID)
                            .put(SAND, STONE_ID)
                            .put(DIRT, STONE_ID)
                            .put(CLAY, STONE_ID)
                            .build()
                    ).put(PLAINS, ImmutableMap.<Block, Integer>builder()
                            .put(GRASS, STONE_ID)
                            .put(DOUBLE_PLANT, AIR_ID)
                            .put(LOG, AIR_ID)
                            .put(LEAVES, AIR_ID)
                            .put(RED_FLOWER, AIR_ID)

                            .put(TALLGRASS, AIR_ID)
                            .build()
                    ).put(DESERT, ImmutableMap.<Block, Integer>builder()
                            .put(SAND, STONE_ID)
                            .put(SANDSTONE, STONE_ID)
                            .put(CACTUS, AIR_ID)
                            .put(DEADBUSH, AIR_ID)
                            .build()
                    ).put(MOUNTAINS, ImmutableMap.<Block, Integer>builder()
                            .put(GRASS, STONE_ID)
                            .put(LOG, AIR_ID)
                            .put(LEAVES, AIR_ID)
                            .put(STONE, STONE_ID)
                            .put(MONSTER_EGG, STONE_ID)
                            .put(EMERALD_ORE, STONE_ID)
                            .put(COAL_ORE, STONE_ID)
                            .put(IRON_ORE, STONE_ID)
                            .put(SNOW, AIR_ID)
                            .put(ICE, STONE_ID)

                            .put(TALLGRASS, AIR_ID)
                            .put(RED_FLOWER, AIR_ID)
                            .put(YELLOW_FLOWER, AIR_ID)
                            .build()
                    ).put(FOREST, ImmutableMap.<Block, Integer>builder()
                            .put(GRASS, STONE_ID)
                            .put(LOG, AIR_ID)
                            .put(LEAVES, AIR_ID)
                            .put(DOUBLE_PLANT, AIR_ID)

                            .put(TALLGRASS, AIR_ID)
                            .build()
                    ).put(TAIGA, ImmutableMap.<Block, Integer>builder()
                            .put(GRASS, STONE_ID)
                            .put(TALLGRASS, AIR_ID)
                            .put(DOUBLE_PLANT, AIR_ID)
                            .put(LOG, AIR_ID)
                            .put(LEAVES, AIR_ID)
                            .build()
                    ).put(SWAMP, ImmutableMap.<Block, Integer>builder()
                            .put(GRASS, STONE_ID)
                            .put(WATER, WATER_ID)
                            .put(WATERLILY, AIR_ID)
                            .put(CLAY, STONE_ID)
                            .put(VINE, AIR_ID)
                            .put(LOG, AIR_ID)
                            .put(LEAVES, AIR_ID)
                            .put(RED_FLOWER, AIR_ID)
                            .put(RED_MUSHROOM, AIR_ID)
                            .put(BROWN_MUSHROOM, AIR_ID)
                            .put(DEADBUSH, AIR_ID)

                            .put(TALLGRASS, AIR_ID)
                            .build()
                    ).put(RIVER, ImmutableMap.<Block, Integer>builder()
                            .put(WATER, WATER_ID)
                            .put(GRASS, STONE_ID)
                            .put(DIRT, STONE_ID)
                            .put(CLAY, STONE_ID)
                            .put(SAND, STONE_ID)
                            .put(GRAVEL, STONE_ID)
                            .put(REEDS, AIR_ID)
                            .build()
                    ).put(THE_END, ImmutableMap.<Block, Integer>builder()
                            .put(END_STONE, END_STONE_ID)
                            .put(OBSIDIAN, AIR_ID)
                            .put(BEDROCK, AIR_ID)
                            .build()
                    ).put(FROZEN_OCEAN, ImmutableMap.<Block, Integer>builder()
                            .put(WATER, WATER_ID)
                            .put(ICE, STONE_ID)
                            .put(SNOW, STONE_ID)
                            .put(PACKED_ICE, STONE_ID)
                            .put(GRAVEL, STONE_ID)
                            .put(SAND, STONE_ID)
                            .put(CLAY, STONE_ID)
                            .put(DIRT, STONE_ID)
                            .build()
                    ).put(FROZEN_RIVER, ImmutableMap.<Block, Integer>builder()
                            .put(ICE, STONE_ID)
                            .put(WATER, WATER_ID)
                            .put(GRASS, STONE_ID)
                            .put(DIRT, STONE_ID)
                            .put(CLAY, STONE_ID)
                            .put(SAND, STONE_ID)
                            .put(GRAVEL, STONE_ID)
                            .build()
                    ).put(SNOWY_TUNDRA, ImmutableMap.<Block, Integer>builder()
                            .put(SNOW, AIR_ID)
                            .put(GRASS, STONE_ID)
                            .put(ICE, STONE_ID)
                            .put(LOG, AIR_ID)
                            .put(LEAVES, AIR_ID)
                            .build()
                    ).put(SNOWY_MOUNTAINS, ImmutableMap.<Block, Integer>builder()
                            .put(SNOW, AIR_ID)
                            .put(GRASS, STONE_ID)
                            .put(ICE, STONE_ID)
                            .put(LOG, AIR_ID)
                            .put(LEAVES, AIR_ID)
                            .build()
                    ).put(MUSHROOM_FIELDS, ImmutableMap.<Block, Integer>builder()
                            .put(MYCELIUM, STONE_ID)
                            .put(RED_MUSHROOM_BLOCK, AIR_ID)
                            .put(BROWN_MUSHROOM_BLOCK, AIR_ID)
                            .put(RED_MUSHROOM, AIR_ID)
                            .put(BROWN_MUSHROOM, AIR_ID)
                            .build()
                    ).put(MUSHROOM_FIELD_SHORE, ImmutableMap.<Block, Integer>builder()
                            .put(MYCELIUM, STONE_ID)
                            .put(RED_MUSHROOM_BLOCK, AIR_ID)
                            .put(BROWN_MUSHROOM_BLOCK, AIR_ID)
                            .put(RED_MUSHROOM, AIR_ID)
                            .put(BROWN_MUSHROOM, AIR_ID)
                            .build()
                    ).put(BEACH, ImmutableMap.<Block, Integer>builder()
                            .put(WATER, WATER_ID)
                            .put(SAND, STONE_ID)
                            .put(SANDSTONE, STONE_ID)
                            .put(GRAVEL, STONE_ID)
                            .put(DIRT, STONE_ID)
                            .put(CLAY, STONE_ID)
                            .put(REEDS, AIR_ID)
                            .build()
                    ).put(DESERT_HILLS, ImmutableMap.<Block, Integer>builder()
                            .put(SAND, STONE_ID)
                            .put(SANDSTONE, STONE_ID)
                            .put(CACTUS, AIR_ID)
                            .put(DEADBUSH, AIR_ID)
                            .build()
                    ).put(WOODED_HILLS, ImmutableMap.<Block, Integer>builder()
                            .put(GRASS, STONE_ID)
                            .put(LOG, AIR_ID)
                            .put(LEAVES, AIR_ID)
                            .put(DOUBLE_PLANT, AIR_ID)

                            .put(TALLGRASS, AIR_ID)
                            .build()
                    ).put(TAIGA_HILLS, ImmutableMap.<Block, Integer>builder()
                            .put(GRASS, STONE_ID)
                            .put(TALLGRASS, AIR_ID)
                            .put(DOUBLE_PLANT, AIR_ID)
                            .put(LOG, AIR_ID)
                            .put(LEAVES, AIR_ID)
                            .build()
                    ).put(MOUNTAIN_EDGE, ImmutableMap.<Block, Integer>builder()
                            .put(GRASS, STONE_ID)
                            .put(LOG, AIR_ID)
                            .put(LEAVES, AIR_ID)
                            .put(STONE, STONE_ID)
                            .put(MONSTER_EGG, STONE_ID)
                            .put(EMERALD_ORE, STONE_ID)
                            .put(COAL_ORE, STONE_ID)
                            .put(IRON_ORE, STONE_ID)
                            .put(SNOW, AIR_ID)
                            .put(ICE, STONE_ID)
                            .build()
                    ).put(JUNGLE, ImmutableMap.<Block, Integer>builder()
                            .put(GRASS, STONE_ID)
                            .put(VINE, AIR_ID)
                            .put(LOG, AIR_ID)
                            .put(LEAVES, AIR_ID)
                            .put(COCOA, AIR_ID)
                            .put(MELON_BLOCK, AIR_ID)
                            .build()
                    ).put(JUNGLE_HILLS, ImmutableMap.<Block, Integer>builder()
                            .put(GRASS, STONE_ID)
                            .put(VINE, AIR_ID)
                            .put(LOG, AIR_ID)
                            .put(LEAVES, AIR_ID)
                            .put(COCOA, AIR_ID)
                            .put(MELON_BLOCK, AIR_ID)
                            .build()
                    ).put(JUNGLE_EDGE, ImmutableMap.<Block, Integer>builder()
                            .put(GRASS, STONE_ID)
                            .put(VINE, AIR_ID)
                            .put(LOG, AIR_ID)
                            .put(LEAVES, AIR_ID)
                            .put(COCOA, AIR_ID)
                            .put(MELON_BLOCK, AIR_ID)
                            .build()
                    ).put(DEEP_OCEAN, ImmutableMap.<Block, Integer>builder()
                            .put(WATER, WATER_ID)
                            .put(GRAVEL, STONE_ID)
                            .put(OBSIDIAN, STONE_ID)
                            .build()
                    ).put(STONE_SHORE, ImmutableMap.<Block, Integer>builder()
                            .put(WATER, WATER_ID)
                            .put(STONE, STONE_ID)
                            .put(GRAVEL, STONE_ID)
                            .build()
                    ).put(SNOWY_BEACH, ImmutableMap.<Block, Integer>builder()
                            .put(WATER, WATER_ID)
                            .put(SNOW, AIR_ID)
                            .put(ICE, STONE_ID)
                            .put(SAND, STONE_ID)
                            .put(SANDSTONE, STONE_ID)
                            .put(GRAVEL, STONE_ID)
                            .put(DIRT, STONE_ID)
                            .put(CLAY, STONE_ID)
                            .build()
                    ).put(BIRCH_FOREST, ImmutableMap.<Block, Integer>builder()
                            .put(GRASS, STONE_ID)
                            .put(LOG, AIR_ID)
                            .put(LEAVES, AIR_ID)
                            .put(DOUBLE_PLANT, AIR_ID)

                            .put(TALLGRASS, AIR_ID)
                            .put(RED_FLOWER, AIR_ID)
                            .build()
                    ).put(BIRCH_FOREST_HILLS, ImmutableMap.<Block, Integer>builder()
                            .put(GRASS, STONE_ID)
                            .put(LOG, AIR_ID)
                            .put(LEAVES, AIR_ID)
                            .put(DOUBLE_PLANT, AIR_ID)

                            .put(TALLGRASS, AIR_ID)
                            .put(YELLOW_FLOWER, AIR_ID)
                            .build()
                    ).put(DARK_FOREST, ImmutableMap.<Block, Integer>builder()
                            .put(GRASS, STONE_ID)
                            .put(LOG2, AIR_ID)
                            .put(LEAVES2, AIR_ID)
                            .put(LOG, AIR_ID)
                            .put(LEAVES, AIR_ID)
                            .put(RED_MUSHROOM_BLOCK, AIR_ID)
                            .put(BROWN_MUSHROOM_BLOCK, AIR_ID)
                            .put(DOUBLE_PLANT, AIR_ID)

                            .put(TALLGRASS, AIR_ID)
                            .put(RED_FLOWER, AIR_ID)
                            .build()
                    ).put(SNOWY_TAIGA, ImmutableMap.<Block, Integer>builder()
                            .put(GRASS, STONE_ID)
                            .put(SNOW, AIR_ID)
                            .put(TALLGRASS, AIR_ID)
                            .put(DOUBLE_PLANT, AIR_ID)
                            .put(LOG, AIR_ID)
                            .put(LEAVES, AIR_ID)
                            .build()
                    ).put(SNOWY_TAIGA_HILLS, ImmutableMap.<Block, Integer>builder()
                            .put(GRASS, STONE_ID)
                            .put(SNOW, AIR_ID)
                            .put(TALLGRASS, AIR_ID)
                            .put(DOUBLE_PLANT, AIR_ID)
                            .put(LOG, AIR_ID)
                            .put(LEAVES, AIR_ID)
                            .build()
                    ).put(GIANT_TREE_TAIGA, ImmutableMap.<Block, Integer>builder()
                            .put(GRASS, STONE_ID)
                            .put(DIRT, STONE_ID)
                            .put(MOSSY_COBBLESTONE, AIR_ID)
                            .put(LOG, AIR_ID)
                            .put(LEAVES, AIR_ID)
                            .put(TALLGRASS, AIR_ID)
                            .put(DOUBLE_PLANT, AIR_ID)
                            .put(DEADBUSH, AIR_ID)
                            .put(RED_MUSHROOM, AIR_ID)
                            .put(BROWN_MUSHROOM, AIR_ID)
                            .build()
                    ).put(GIANT_TREE_TAIGA_HILLS, ImmutableMap.<Block, Integer>builder()
                            .put(GRASS, STONE_ID)
                            .put(DIRT, STONE_ID)
                            .put(MOSSY_COBBLESTONE, AIR_ID)
                            .put(LOG, AIR_ID)
                            .put(LEAVES, AIR_ID)
                            .put(TALLGRASS, AIR_ID)
                            .put(DOUBLE_PLANT, AIR_ID)
                            .put(DEADBUSH, AIR_ID)
                            .put(RED_MUSHROOM, AIR_ID)
                            .put(BROWN_MUSHROOM, AIR_ID)
                            .build()
                    ).put(WOODED_MOUNTAINS, ImmutableMap.<Block, Integer>builder()
                            .put(GRASS, STONE_ID)
                            .put(LOG, AIR_ID)
                            .put(LEAVES, AIR_ID)
                            .put(STONE, STONE_ID)
                            .put(MONSTER_EGG, STONE_ID)
                            .put(EMERALD_ORE, STONE_ID)
                            .put(COAL_ORE, STONE_ID)
                            .put(IRON_ORE, STONE_ID)
                            .put(SNOW, AIR_ID)
                            .put(ICE, STONE_ID)

                            .put(TALLGRASS, AIR_ID)
                            .put(RED_FLOWER, AIR_ID)
                            .build()
                    ).put(SAVANNA, ImmutableMap.<Block, Integer>builder()
                            .put(GRASS, STONE_ID)
                            .put(TALLGRASS, AIR_ID)
                            .put(LOG2, AIR_ID)
                            .put(LEAVES2, AIR_ID)
                            .put(LOG, AIR_ID)
                            .put(LEAVES, AIR_ID)
                            .put(DOUBLE_PLANT, AIR_ID)

                            .put(RED_FLOWER, AIR_ID)
                            .build()
                    ).put(SAVANNA_PLATEAU, ImmutableMap.<Block, Integer>builder()
                            .put(GRASS, STONE_ID)
                            .put(DOUBLE_PLANT, AIR_ID)
                            .put(LOG2, AIR_ID)
                            .put(LEAVES2, AIR_ID)
                            .put(LOG, AIR_ID)
                            .put(LEAVES, AIR_ID)

                            .put(TALLGRASS, AIR_ID)
                            .build()
                    ).put(BADLANDS, ImmutableMap.<Block, Integer>builder()
                            .put(SAND, STONE_ID)
                            .put(HARDENED_CLAY, STONE_ID)
                            .put(STAINED_HARDENED_CLAY, STONE_ID)
                            .put(CACTUS, AIR_ID)
                            .put(DEADBUSH, AIR_ID)
                            .put(GOLD_ORE, STONE_ID)
                            .build()
                    ).put(WOODED_BADLANDS_PLATEAU, ImmutableMap.<Block, Integer>builder()
                            .put(SAND, STONE_ID)
                            .put(HARDENED_CLAY, STONE_ID)
                            .put(STAINED_HARDENED_CLAY, STONE_ID)
                            .put(CACTUS, AIR_ID)
                            .put(DEADBUSH, AIR_ID)
                            .put(GOLD_ORE, STONE_ID)
                            .put(GRASS, STONE_ID)
                            .put(DIRT, STONE_ID)
                            .put(LOG, STONE_ID)
                            .put(LEAVES, STONE_ID)
                            .build()
                    ).put(BADLANDS_PLATEAU, ImmutableMap.<Block, Integer>builder()
                            .put(SAND, STONE_ID)
                            .put(HARDENED_CLAY, STONE_ID)
                            .put(STAINED_HARDENED_CLAY, STONE_ID)
                            .put(CACTUS, AIR_ID)
                            .put(DEADBUSH, AIR_ID)
                            .put(GOLD_ORE, STONE_ID)
                            .build()
                    ).put(SMALL_END_ISLANDS, ImmutableMap.<Block, Integer>builder()
                            .put(END_STONE, END_STONE_ID)
                            .build()
                    ).put(END_MIDLANDS, ImmutableMap.<Block, Integer>builder()
                            .put(END_STONE, END_STONE_ID)
                            .build()
                    ).put(END_HIGHLANDS, ImmutableMap.<Block, Integer>builder()
                            .put(END_STONE, END_STONE_ID)
                            .put(CHORUS_PLANT, AIR_ID)
                            .put(CHORUS_FLOWER, AIR_ID)
                            .build()
                    ).put(END_BARRENS, ImmutableMap.<Block, Integer>builder()
                            .put(END_STONE, END_STONE_ID)
                            .build()
                    ).put(WARM_OCEAN, ImmutableMap.<Block, Integer>builder()
                            .put(WATER, WATER_ID)
                            .put(GRAVEL, STONE_ID)
                            .put(SAND, STONE_ID)
                            .put(DIRT, STONE_ID)
                            .put(CLAY, STONE_ID)
                            .put(OBSIDIAN, STONE_ID)
                            .build()
                    ).put(LUKEWARM_OCEAN, ImmutableMap.<Block, Integer>builder()
                            .put(WATER, WATER_ID)
                            .put(GRAVEL, STONE_ID)
                            .put(SAND, STONE_ID)
                            .put(DIRT, STONE_ID)
                            .put(CLAY, STONE_ID)
                            .build()
                    ).put(COLD_OCEAN, ImmutableMap.<Block, Integer>builder()
                            .put(WATER, WATER_ID)
                            .put(GRAVEL, STONE_ID)
                            .put(SAND, STONE_ID)
                            .put(DIRT, STONE_ID)
                            .put(CLAY, STONE_ID)
                            .build()
                    ).put(DEEP_WARM_OCEAN, ImmutableMap.<Block, Integer>builder()
                            .put(WATER, WATER_ID)
                            .put(SAND, STONE_ID)
                            .put(OBSIDIAN, STONE_ID)
                            .build()
                    ).put(DEEP_LUKEWARM_OCEAN, ImmutableMap.<Block, Integer>builder()
                            .put(WATER, WATER_ID)
                            .put(SAND, STONE_ID)
                            .put(OBSIDIAN, STONE_ID)
                            .build()
                    ).put(DEEP_COLD_OCEAN, ImmutableMap.<Block, Integer>builder()
                            .put(WATER, WATER_ID)
                            .put(GRAVEL, STONE_ID)
                            .put(OBSIDIAN, STONE_ID)
                            .build()
                    ).put(DEEP_FROZEN_OCEAN, ImmutableMap.<Block, Integer>builder()
                            .put(WATER, WATER_ID)
                            .put(SNOW, STONE_ID)
                            .put(PACKED_ICE, STONE_ID)
                            .put(ICE, STONE_ID)
                            .put(GRAVEL, STONE_ID)
                            .put(OBSIDIAN, STONE_ID)
                            .build()
                    ).put(THE_VOID, ImmutableMap.<Block, Integer>builder()
                            .put(COBBLESTONE, STONE_ID)
                            .put(STONE, STONE_ID)
                            .build()
                    ).put(SUNFLOWER_PLAINS, ImmutableMap.<Block, Integer>builder()
                            .put(GRASS, STONE_ID)
                            .put(DOUBLE_PLANT, AIR_ID)
                            .put(LOG, AIR_ID)
                            .put(LEAVES, AIR_ID)
                            .put(RED_FLOWER, AIR_ID)
                            .build()
                    ).put(DESERT_LAKES, ImmutableMap.<Block, Integer>builder()
                            .put(SAND, STONE_ID)
                            .put(SANDSTONE, STONE_ID)
                            .put(CACTUS, AIR_ID)
                            .put(DEADBUSH, AIR_ID)
                            .put(WATER, WATER_ID)
                            .put(REEDS, AIR_ID)
                            .build()
                    ).put(GRAVELLY_MOUNTAINS, ImmutableMap.<Block, Integer>builder()
                            .put(GRAVEL, STONE_ID)
                            .put(GRASS, STONE_ID)
                            .put(SNOW, AIR_ID)
                            .put(STONE, STONE_ID)
                            .put(MONSTER_EGG, STONE_ID)
                            .put(EMERALD_ORE, STONE_ID)
                            .put(COAL_ORE, STONE_ID)
                            .put(IRON_ORE, STONE_ID)
                            .build()
                    ).put(FLOWER_FOREST, ImmutableMap.<Block, Integer>builder()
                            .put(GRASS, STONE_ID)
                            .put(LOG, AIR_ID)
                            .put(LEAVES, AIR_ID)
                            .put(DOUBLE_PLANT, AIR_ID)
                            .build()
                    ).put(TAIGA_MOUNTAINS, ImmutableMap.<Block, Integer>builder()
                            .put(GRASS, STONE_ID)
                            .put(TALLGRASS, AIR_ID)
                            .put(DOUBLE_PLANT, AIR_ID)
                            .put(LOG, AIR_ID)
                            .put(LEAVES, AIR_ID)
                            .build()
                    ).put(SWAMP_HILLS, ImmutableMap.<Block, Integer>builder()
                            .put(GRASS, STONE_ID)
                            .put(WATER, WATER_ID)
                            .put(WATERLILY, AIR_ID)
                            .put(CLAY, STONE_ID)
                            .put(VINE, AIR_ID)
                            .put(LOG, AIR_ID)
                            .put(LEAVES, AIR_ID)
                            .put(RED_FLOWER, AIR_ID)
                            .put(RED_MUSHROOM, AIR_ID)
                            .put(BROWN_MUSHROOM, AIR_ID)
                            .build()
                    ).put(ICE_SPIKES, ImmutableMap.<Block, Integer>builder()
                            .put(PACKED_ICE, AIR_ID)
                            .put(SNOW, STONE_ID)
                            .put(DIRT, STONE_ID)
                            .put(ICE, STONE_ID)
                            .build()
                    ).put(MODIFIED_JUNGLE, ImmutableMap.<Block, Integer>builder()
                            .put(GRASS, STONE_ID)
                            .put(VINE, AIR_ID)
                            .put(LOG, AIR_ID)
                            .put(LEAVES, AIR_ID)
                            .put(COCOA, AIR_ID)
                            .put(MELON_BLOCK, AIR_ID)
                            .build()
                    ).put(MODIFIED_JUNGLE_EDGE,  ImmutableMap.<Block, Integer>builder()
                            .put(GRASS, STONE_ID)
                            .put(VINE, AIR_ID)
                            .put(LOG, AIR_ID)
                            .put(LEAVES, AIR_ID)
                            .put(COCOA, AIR_ID)
                            .put(MELON_BLOCK, AIR_ID)
                            .build()
                    ).put(TALL_BIRCH_FOREST, ImmutableMap.<Block, Integer>builder()
                            .put(GRASS, STONE_ID)
                            .put(LOG, AIR_ID)
                            .put(LEAVES, AIR_ID)
                            .put(DOUBLE_PLANT, AIR_ID)
                            .build()
                    ).put(TALL_BIRCH_HILLS, ImmutableMap.<Block, Integer>builder()
                            .put(GRASS, STONE_ID)
                            .put(LOG, AIR_ID)
                            .put(LEAVES, AIR_ID)
                            .put(DOUBLE_PLANT, AIR_ID)
                            .build()
                    ).put(DARK_FOREST_HILLS, ImmutableMap.<Block, Integer>builder()
                            .put(GRASS, STONE_ID)
                            .put(LOG2, AIR_ID)
                            .put(LEAVES2, AIR_ID)
                            .put(LOG, AIR_ID)
                            .put(LEAVES, AIR_ID)
                            .put(RED_MUSHROOM_BLOCK, AIR_ID)
                            .put(BROWN_MUSHROOM_BLOCK, AIR_ID)
                            .put(DOUBLE_PLANT, AIR_ID)
                            .build()
                    ).put(SNOWY_TAIGA_MOUNTAINS, ImmutableMap.<Block, Integer>builder()
                            .put(GRASS, STONE_ID)
                            .put(SNOW, AIR_ID)
                            .put(TALLGRASS, AIR_ID)
                            .put(DOUBLE_PLANT, AIR_ID)
                            .put(LOG, AIR_ID)
                            .put(LEAVES, AIR_ID)
                            .build()
                    ).put(GIANT_SPRUCE_TAIGA, ImmutableMap.<Block, Integer>builder()
                            .put(GRASS, STONE_ID)
                            .put(DIRT, STONE_ID)
                            .put(MOSSY_COBBLESTONE, AIR_ID)
                            .put(LOG, AIR_ID)
                            .put(LEAVES, AIR_ID)
                            .put(TALLGRASS, AIR_ID)
                            .put(DOUBLE_PLANT, AIR_ID)
                            .put(DEADBUSH, AIR_ID)
                            .put(RED_MUSHROOM, AIR_ID)
                            .put(BROWN_MUSHROOM, AIR_ID)
                            .build()
                    ).put(GIANT_SPRUCE_TAIGA_HILLS, ImmutableMap.<Block, Integer>builder()
                            .put(GRASS, STONE_ID)
                            .put(DIRT, STONE_ID)
                            .put(MOSSY_COBBLESTONE, AIR_ID)
                            .put(LOG, AIR_ID)
                            .put(LEAVES, AIR_ID)
                            .put(TALLGRASS, AIR_ID)
                            .put(DOUBLE_PLANT, AIR_ID)
                            .put(DEADBUSH, AIR_ID)
                            .put(RED_MUSHROOM, AIR_ID)
                            .put(BROWN_MUSHROOM, AIR_ID)
                            .build()
                    ).put(MODIFIED_GRAVELLY_MOUNTAINS, ImmutableMap.<Block, Integer>builder()
                            .put(GRAVEL, STONE_ID)
                            .put(GRASS, STONE_ID)
                            .put(SNOW, AIR_ID)
                            .put(STONE, STONE_ID)
                            .put(MONSTER_EGG, STONE_ID)
                            .put(EMERALD_ORE, STONE_ID)
                            .put(COAL_ORE, STONE_ID)
                            .put(IRON_ORE, STONE_ID)
                            .build()
                    ).put(SHATTERED_SAVANNA, ImmutableMap.<Block, Integer>builder()
                            .put(GRASS, STONE_ID)
                            .put(DIRT, STONE_ID)
                            .put(STONE, STONE_ID)
                            .put(DOUBLE_PLANT, AIR_ID)
                            .put(LOG2, AIR_ID)
                            .put(LEAVES2, AIR_ID)
                            .put(LOG, AIR_ID)
                            .put(LEAVES, AIR_ID)

                            .put(TALLGRASS, AIR_ID)
                            .build()
                    ).put(SHATTERED_SAVANNA_PLATEAU, ImmutableMap.<Block, Integer>builder()
                            .put(GRASS, STONE_ID)
                            .put(DIRT, STONE_ID)
                            .put(STONE, STONE_ID)
                            .put(DOUBLE_PLANT, AIR_ID)
                            .put(LOG2, AIR_ID)
                            .put(LEAVES2, AIR_ID)
                            .put(LOG, AIR_ID)
                            .put(LEAVES, AIR_ID)
                            .build()
                    ).put(ERODED_BADLANDS, ImmutableMap.<Block, Integer>builder()
                            .put(SAND, STONE_ID)
                            .put(HARDENED_CLAY, STONE_ID)
                            .put(STAINED_HARDENED_CLAY, STONE_ID)
                            .put(CACTUS, AIR_ID)
                            .put(DEADBUSH, AIR_ID)
                            .put(GOLD_ORE, STONE_ID)
                            .build()
                    ).put(MODIFIED_WOODED_BADLANDS_PLATEAU, ImmutableMap.<Block, Integer>builder()
                            .put(SAND, STONE_ID)
                            .put(HARDENED_CLAY, STONE_ID)
                            .put(STAINED_HARDENED_CLAY, STONE_ID)
                            .put(CACTUS, AIR_ID)
                            .put(DEADBUSH, AIR_ID)
                            .put(GOLD_ORE, STONE_ID)
                            .put(GRASS, STONE_ID)
                            .put(DIRT, STONE_ID)
                            .put(LOG, STONE_ID)
                            .put(LEAVES, STONE_ID)
                            .build()
                    ).put(MODIFIED_BADLANDS_PLATEAU, ImmutableMap.<Block, Integer>builder()
                            .put(SAND, STONE_ID)
                            .put(HARDENED_CLAY, STONE_ID)
                            .put(STAINED_HARDENED_CLAY, STONE_ID)
                            .put(CACTUS, AIR_ID)
                            .put(DEADBUSH, AIR_ID)
                            .put(GOLD_ORE, STONE_ID)
                            .build()
                    )
                    .build()
            )
            .build();

    private static final Map<MCVersion, Map<Block, Integer>> overworld = ImmutableMap.<MCVersion, Map<Block, Integer>>builder()
            .put(MCVersion.v1_12_2, ImmutableMap.<Block, Integer>builder()
                    .put(AIR, AIR_ID)
                    .put(BEDROCK, STONE_ID)
                    .put(STONE, STONE_ID)
                    .put(DIRT, STONE_ID)
                    .put(WATER, STONE_ID)
                    .put(LAVA, STONE_ID)
                    .put(COAL_ORE, STONE_ID)
                    .put(IRON_ORE, STONE_ID)
                    .put(GOLD_ORE, STONE_ID)
                    .put(DIAMOND_ORE, STONE_ID)
                    .put(EMERALD_ORE, STONE_ID)
                    .put(LAPIS_ORE, STONE_ID)
                    .put(REDSTONE_ORE, STONE_ID)
                    .put(GRAVEL, STONE_ID)
                    .build()
            )
            .build();

    private static final Map<MCVersion, Map<Block, Integer>> nether = ImmutableMap.<MCVersion, Map<Block, Integer>>builder()
            .put(MCVersion.v1_12_2, ImmutableMap.<Block, Integer>builder()
                    .put(AIR, AIR_ID)
                    //.put(BEDROCK, 7)
                    .put(BEDROCK, NETHERRACK_ID)
                    .put(NETHERRACK, NETHERRACK_ID)
                    .put(LAVA, LAVA_ID)
                    .put(QUARTZ_ORE, NETHERRACK_ID)
                    .build()
            )
            .build();

    private static final Map<MCVersion, Map<Block, Integer>> end = ImmutableMap.<MCVersion, Map<Block, Integer>>builder()
            .put(MCVersion.v1_12_2, ImmutableMap.<Block, Integer>builder()
                    .put(AIR, AIR_ID)
                    .put(END_STONE, END_STONE_ID)
                    .build()
            )
            .build();

    private final MCVersion mcVersion;
    private Map<Block, Integer> map;
    private final Dimension dimension;

    public SimpleBlockMap(Dimension dimension) {
        this(dimension, PLAINS);
    }

    public SimpleBlockMap(Dimension dimension, Biome biome) {
        this(MCVersion.v1_12_2, dimension, biome);
    }

    public SimpleBlockMap(MCVersion mcVersion, Dimension dimension, Biome biome) {
        this.mcVersion = mcVersion;
        this.map = versionedBiomeMap.getOrDefault(this.mcVersion, versionedBiomeMap.get(mcVersion)).get(biome);
        this.dimension = dimension;
    }

    public void setBiome(Biome biome) {
        this.map = versionedBiomeMap.getOrDefault(this.mcVersion, versionedBiomeMap.get(MCVersion.v1_12_2)).get(biome);
    }

    public int get(Block block) {
        Integer biomeBlock = this.map.get(block);
        if (biomeBlock == null) {
            if (this.dimension == Dimension.OVERWORLD) {
                return overworld.getOrDefault(this.mcVersion, overworld.get(MCVersion.v1_12_2)).getOrDefault(block, -1);
            } else if (this.dimension == Dimension.NETHER) {
                return nether.getOrDefault(this.mcVersion, nether.get(MCVersion.v1_12_2)).getOrDefault(block, -1);
            } else {
                return end.getOrDefault(this.mcVersion, end.get(MCVersion.v1_12_2)).getOrDefault(block, -1);
            }
        }
        return biomeBlock;
    }
}