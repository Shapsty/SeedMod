package com.Mod.Client.command;

import com.Mod.api.event.events.RenderEvent;
import net.minecraft.client.Minecraft;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public abstract class Command {

    protected static final Minecraft mc = Minecraft.getMinecraft();

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.TYPE)
    public @interface Declaration {
        String name();

        String syntax();

        String[] alias();

        boolean enabled() default false;
    }

    private Declaration getDeclaration() {
        return getClass().getAnnotation(Declaration.class);
    }

    private final String name = getDeclaration().name();
    private final String[] alias = getDeclaration().alias();
    private final String syntax = getDeclaration().syntax();
    private boolean enabled = getDeclaration().enabled();

    public String getName() {
        return this.name;
    }

    public String getSyntax() {
        return CommandManager.getCommandPrefix() + this.syntax;
    }

    public String[] getAlias() {
        return this.alias;
    }

    public boolean isEnabled() {
        return this.enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public void onWorldRender(RenderEvent event) {

    }

    public abstract void onCommand(String command, String[] message);
}
