package com.Mod.mixin;

import com.Mod.Client.SeedMod;
import net.minecraftforge.fml.relauncher.IFMLLoadingPlugin;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.launch.MixinBootstrap;
import org.spongepowered.asm.mixin.MixinEnvironment;
import org.spongepowered.asm.mixin.Mixins;

import java.util.Map;

@IFMLLoadingPlugin.Name(SeedMod.NAME)
@IFMLLoadingPlugin.MCVersion("1.12.2")
public class SeedModMixinLoader implements IFMLLoadingPlugin {
    private static boolean isObfuscatedEnvironment = false;

    public SeedModMixinLoader() {
        MixinBootstrap.init();
        Mixins.addConfiguration("mixins.seedmod.json");
        MixinEnvironment.getDefaultEnvironment().setObfuscationContext("searge");
    }

    @Override
    public String[] getASMTransformerClass() {
        return new String[0];
    }

    @Override
    public String getModContainerClass() {
        return null;
    }

    @Nullable
    @Override
    public String getSetupClass() {
        return null;
    }

    @Override
    public void injectData(Map<String, Object> data) {
        isObfuscatedEnvironment = (boolean) data.get("runtimeDeobfuscationEnabled");
    }
    @Override
    public String getAccessTransformerClass() {
        return null;
    }
}
