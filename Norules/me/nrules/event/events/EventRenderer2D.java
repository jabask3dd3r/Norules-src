package me.nrules.event.events;

import me.nrules.event.*;
import net.minecraft.client.gui.*;

public class EventRenderer2D extends Event
{
    private /* synthetic */ ScaledResolution resolution;
    private /* synthetic */ float partialticks;
    
    public EventRenderer2D(final ScaledResolution lllllllllllllIIIllIlllIIIIIIIlII, final float lllllllllllllIIIllIlllIIIIIIIIII) {
        this.resolution = lllllllllllllIIIllIlllIIIIIIIlII;
        this.partialticks = lllllllllllllIIIllIlllIIIIIIIIII;
    }
    
    public float getPartialTicks() {
        return this.partialticks;
    }
    
    public ScaledResolution getResolution() {
        return this.resolution;
    }
}
