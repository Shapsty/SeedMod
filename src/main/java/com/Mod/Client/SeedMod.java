package com.Mod.Client;

import com.Mod.Client.command.CommandManager;
import com.Mod.Client.manager.managerLoader;
import com.Mod.Client.module.ModuleManager;
import me.zero.alpine.EventBus;
import me.zero.alpine.EventManager;
import net.minecraft.client.Minecraft;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.lwjgl.opengl.Display;

@Mod(modid = SeedMod.MODID, name = SeedMod.NAME, version = SeedMod.VERSION, dependencies = "required-after:forge@[14.23.5.2860,);")
public class SeedMod  {
    private static final Minecraft mc = Minecraft.getMinecraft();
    public static final String MODID = "seedmod";
    public static final String NAME = "Seed Mod";
    public static final String VERSION = "b.77";

    public static managerLoader managerLoad;
    public static CommandManager CommandManager;
    public static ModuleManager moduleManager;

    public static final EventBus EVENT_BUS = new EventManager();

    public static final Logger logger = LogManager.getLogger(NAME);

    @Instance
    public static SeedMod INSTANCE;

    public SeedMod(){
        INSTANCE = this;
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(this);
        Display.setTitle(NAME + " " + VERSION + " - " +  mc.getSession().getUsername());

        logger.info("Starting up " + NAME + " " + VERSION);

        CommandManager = new CommandManager();
        logger.info("Finished initialization for commandManager");

        moduleManager = new ModuleManager();
        logger.info("Finished initialization for ModuleManager");

        managerLoad = new managerLoader();
        logger.info("Finished initialization for commandManager");

        logger.info("Finished initialization for " + NAME + " " + VERSION);
    }

}
