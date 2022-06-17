package com.Mod.api.util.render;

import net.minecraft.client.renderer.GlStateManager;

import java.awt.*;

public class SeedModColor extends Color {

    private static final long serialVersionUID = 1L;

    public SeedModColor(int rgb) {
        super(rgb);
    }

    public SeedModColor(int rgba, boolean hasalpha) {
        super(rgba, hasalpha);
    }

    public SeedModColor(int r, int g, int b) {
        super(r, g, b);
    }

    public SeedModColor(int r, int g, int b, int a) {
        super(r, g, b, a);
    }

    public SeedModColor(Color color) {
        super(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha());
    }

    public SeedModColor(SeedModColor color, int a) {
        super(color.getRed(), color.getGreen(), color.getBlue(), a);
    }

    public static SeedModColor fromHSB(float hue, float saturation, float brightness) {
        return new SeedModColor(Color.getHSBColor(hue, saturation, brightness));
    }

    public float getHue() {
        return RGBtoHSB(getRed(), getGreen(), getBlue(), null)[0];
    }

    public float getSaturation() {
        return RGBtoHSB(getRed(), getGreen(), getBlue(), null)[1];
    }

    public float getBrightness() {
        return RGBtoHSB(getRed(), getGreen(), getBlue(), null)[2];
    }

    public void glColor() {
        GlStateManager.color(getRed() / 255.0f, getGreen() / 255.0f, getBlue() / 255.0f, getAlpha() / 255.0f);
    }
}
