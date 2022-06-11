package com.Mod.Client;

import com.Mod.Client.command.commandManager;
import com.Mod.Client.manager.managerLoader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import me.zero.alpine.EventBus;
import me.zero.alpine.EventManager;
import org.apache.logging.log4j.Logger;

@Mod(modid = SeedMod.MODID, name = SeedMod.NAME, version = SeedMod.VERSION)
public class SeedMod  {
    public static final String MODID = "SeedMod";
    public static final String NAME = "Seed Mod";
    public static final String VERSION = "1.0";

    public static final EventBus EVENT_BUS = new EventManager();

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

        managerLoader.init();
        logger.info("Finished initialization for commandManager");
    }
}
