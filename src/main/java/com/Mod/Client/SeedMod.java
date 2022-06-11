package com.Mod.Client;

import com.Mod.Client.command.commandManager;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

@Mod(modid = SeedMod.MODID, name = SeedMod.NAME, version = SeedMod.VERSION)
public class SeedMod  {
    public static final String MODID = "SeedMod";
    public static final String NAME = "Seed Mod";
    public static final String VERSION = "1.0";

    private static Logger logger;
    @Mod.Instance
    public static SeedMod INSTANCE;

    public SeedMod(){
        INSTANCE = this;
    }

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        logger = event.getModLog();
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        logger.info("Starting up " + NAME + " " + VERSION);
        startClient();
        logger.info("Finished initialization for " + NAME + " " + VERSION);
    }
    private void startClient(){
        commandManager.init();
        logger.info("Finished initialization for commandManager");
    }
}
