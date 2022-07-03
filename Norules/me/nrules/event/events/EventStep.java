package me.nrules.event.events;

import me.nrules.event.*;

public class EventStep extends Event
{
    private /* synthetic */ double realHeight;
    private /* synthetic */ boolean pre;
    private /* synthetic */ double stepHeight;
    private /* synthetic */ boolean active;
    
    public EventStep() {
    }
    
    public void setRealHeight(final double lllllllllllllllIllIIIIlIllIlIIII) {
        this.realHeight = lllllllllllllllIllIIIIlIllIlIIII;
    }
    
    public EventStep(final boolean lllllllllllllllIllIIIIlIllllIlIl, final double lllllllllllllllIllIIIIlIllllIIIl) {
        this.pre = lllllllllllllllIllIIIIlIllllIlIl;
        this.realHeight = lllllllllllllllIllIIIIlIllllIIIl;
        this.stepHeight = lllllllllllllllIllIIIIlIllllIIIl;
    }
    
    public double getRealHeight() {
        return this.realHeight;
    }
    
    public boolean isPre() {
        return this.pre;
    }
    
    public EventStep(final boolean lllllllllllllllIllIIIIlIllllllII, final double lllllllllllllllIllIIIIlIllllllll, final double lllllllllllllllIllIIIIlIlllllllI) {
        this.pre = lllllllllllllllIllIIIIlIllllllII;
        this.stepHeight = lllllllllllllllIllIIIIlIllllllll;
        this.realHeight = lllllllllllllllIllIIIIlIlllllllI;
    }
    
    public double getStepHeight() {
        return this.stepHeight;
    }
    
    public boolean isActive() {
        return this.active;
    }
    
    public void setStepHeight(final double lllllllllllllllIllIIIIlIlllIIIIl) {
        this.stepHeight = lllllllllllllllIllIIIIlIlllIIIIl;
    }
    
    public void setActive(final boolean lllllllllllllllIllIIIIlIllIllIll) {
        this.active = lllllllllllllllIllIIIIlIllIllIll;
    }
}
