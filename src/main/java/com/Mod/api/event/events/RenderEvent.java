package com.Mod.api.event.events;

import com.Mod.api.event.SeedModEvent;

public class RenderEvent extends SeedModEvent {
    private final float partialTicks;

    public RenderEvent(float partialTicks){
        super();
        this.partialTicks = partialTicks;
    }

    public float getPartialTicks() {
        return partialTicks;
    }
}
