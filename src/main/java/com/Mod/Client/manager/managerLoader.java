package com.Mod.Client.manager;

import com.Mod.Client.SeedMod;
import com.Mod.Client.manager.managers.ClientEventManager;
import net.minecraftforge.common.MinecraftForge;

import java.util.ArrayList;
import java.util.List;

public class managerLoader {
    private static final List<Manager> managers = new ArrayList<>();

    public static void init() {
        register(ClientEventManager.INSTANCE);
    }

    private static void register(Manager manager) {
        managers.add(manager);
        SeedMod.EVENT_BUS.subscribe(manager);
        MinecraftForge.EVENT_BUS.register(manager);
    }
}
