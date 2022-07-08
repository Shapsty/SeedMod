package com.Mod.Client.module;

import net.minecraft.client.Minecraft;

import org.lwjgl.input.Keyboard;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public abstract class Mod {

    protected static final Minecraft mc = Minecraft.getMinecraft();

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.TYPE)
    public @interface Declaration {
        String name();
        Category catergory();

        int prio() default 0;
        int keyBinding() default Keyboard.KEY_NONE;

        boolean enabled() default false;
        boolean drawn() default true;
        boolean toggleMsg() default false;
    }
    private final String name = getDeclaration().name();
    private final Category category = getDeclaration().catergory();
    private final int priority = getDeclaration().prio();
    private int bind = getDeclaration().keyBinding();
    private boolean enabled = getDeclaration().enabled();
    private boolean drawn = getDeclaration().drawn();
    private boolean toggleMsg = getDeclaration().toggleMsg();

    private Declaration  getDeclaration() {
        return getClass().getAnnotation(Declaration.class);
    }
}
