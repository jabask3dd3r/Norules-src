package me.nrules.event.events;

import me.nrules.event.*;
import net.minecraft.client.gui.*;

public class EventRender2D extends Event
{
    private /* synthetic */ float partialticks;
    private /* synthetic */ ScaledResolution resolution;
    
    public ScaledResolution getResolution() {
        return this.resolution;
    }
    
    public EventRender2D(final ScaledResolution lllllllllllllllllllIllllIIIIIIIl, final float lllllllllllllllllllIlllIllllllIl) {
        this.resolution = lllllllllllllllllllIllllIIIIIIIl;
        this.partialticks = lllllllllllllllllllIlllIllllllIl;
    }
    
    public float getPartialTicks() {
        return this.partialticks;
    }
}
