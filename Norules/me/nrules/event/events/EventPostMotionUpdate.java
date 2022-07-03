package me.nrules.event.events;

import me.nrules.event.*;

public class EventPostMotionUpdate extends Event
{
    public /* synthetic */ double y;
    public /* synthetic */ float pitch;
    public /* synthetic */ float yaw;
    public /* synthetic */ boolean ground;
    
    public void setGround(final boolean llllllllllllllIIIlIllIIIllllIlII) {
        this.ground = llllllllllllllIIIlIllIIIllllIlII;
    }
    
    public void setY(final double llllllllllllllIIIlIllIIIlllIlIll) {
        this.y = llllllllllllllIIIlIllIIIlllIlIll;
    }
    
    public EventPostMotionUpdate(final float llllllllllllllIIIlIllIIlIIIlIIlI, final float llllllllllllllIIIlIllIIlIIIlIllI, final boolean llllllllllllllIIIlIllIIlIIIlIIII, final double llllllllllllllIIIlIllIIlIIIlIlII) {
        this.yaw = llllllllllllllIIIlIllIIlIIIlIIlI;
        this.pitch = llllllllllllllIIIlIllIIlIIIlIllI;
        this.ground = llllllllllllllIIIlIllIIlIIIlIIII;
        this.y = llllllllllllllIIIlIllIIlIIIlIlII;
    }
    
    public void setPitch(final float llllllllllllllIIIlIllIIIllllllll) {
        this.pitch = llllllllllllllIIIlIllIIIllllllll;
    }
    
    public float getYaw() {
        return this.yaw;
    }
    
    public boolean isGround() {
        return this.ground;
    }
    
    public void setYaw(final float llllllllllllllIIIlIllIIlIIIIlIII) {
        this.yaw = llllllllllllllIIIlIllIIlIIIIlIII;
    }
    
    public double getY() {
        return this.y;
    }
    
    public float getPitch() {
        return this.pitch;
    }
}
