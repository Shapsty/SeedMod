package com.Mod.Client;

import com.Mod.Client.command.CommandManager;
import com.Mod.Client.manager.managerLoader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import me.zero.alpine.EventBus;
import me.zero.alpine.EventManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.lwjgl.opengl.Display;

@Mod(modid = SeedMod.MODID, name = SeedMod.NAME, version = SeedMod.VERSION)
public class SeedMod  {
    public static final String MODID = "SeedMod";
    public static final String NAME = "Seed Mod";
    public static final String VERSION = "1.0";

    public static managerLoader managerLoad;
    public static CommandManager CommandMang;

    public static final EventBus EVENT_BUS = new EventManager();

    private static final Logger logger = LogManager.getLogger(NAME);

    @Mod.Instance
    public static SeedMod INSTANCE;

    public SeedMod(){
        INSTANCE = this;
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        Display.setTitle(NAME + " " + VERSION);

        logger.info("Starting up " + NAME + " " + VERSION);

        CommandMang = new CommandManager();
        logger.info("Finished initialization for commandManager");

        managerLoad = new managerLoader();
        logger.info("Finished initialization for commandManager");

        logger.info("Finished initialization for " + NAME + " " + VERSION);
    }

}
