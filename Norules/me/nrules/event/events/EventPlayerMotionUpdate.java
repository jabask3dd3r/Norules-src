package me.nrules.event.events;

import me.nrules.event.*;
import java.util.function.*;
import net.minecraft.client.entity.*;

public class EventPlayerMotionUpdate extends Event
{
    protected /* synthetic */ double y;
    private /* synthetic */ Consumer<EntityPlayerSP> _funcToCall;
    protected /* synthetic */ float _yaw;
    protected /* synthetic */ float _pitch;
    protected /* synthetic */ double x;
    private /* synthetic */ boolean _isForceCancelled;
    protected /* synthetic */ boolean onGround;
    protected /* synthetic */ double z;
    
    public void setFunct(final Consumer<EntityPlayerSP> llllllllllllllIllIlllIlIlIIIllII) {
        this._funcToCall = llllllllllllllIllIlllIlIlIIIllII;
    }
    
    public void setYaw(final double llllllllllllllIllIlllIlIIlllIlII) {
        this._yaw = (float)llllllllllllllIllIlllIlIIlllIlII;
    }
    
    public Consumer<EntityPlayerSP> getFunc() {
        return this._funcToCall;
    }
    
    public void setOnGround(final boolean llllllllllllllIllIlllIlIIlIlIIlI) {
        this.onGround = llllllllllllllIllIlllIlIIlIlIIlI;
    }
    
    public void setPitch(final float llllllllllllllIllIlllIlIIlllllII) {
        this._pitch = llllllllllllllIllIlllIlIIlllllII;
    }
    
    public double getZ() {
        return this.z;
    }
    
    public void forceCancel() {
        this._isForceCancelled = true;
    }
    
    public boolean getOnGround() {
        return this.onGround;
    }
    
    public EventPlayerMotionUpdate(final double llllllllllllllIllIlllIlIlIIlllIl, final double llllllllllllllIllIlllIlIlIIlllII, final double llllllllllllllIllIlllIlIlIIlIllI, final boolean llllllllllllllIllIlllIlIlIIlIlIl) {
        this._funcToCall = null;
        this.x = llllllllllllllIllIlllIlIlIIlllIl;
        this.y = llllllllllllllIllIlllIlIlIIlllII;
        this.z = llllllllllllllIllIlllIlIlIIlIllI;
        this.onGround = llllllllllllllIllIlllIlIlIIlIlIl;
    }
    
    public void setZ(final double llllllllllllllIllIlllIlIIlIllIII) {
        this.z = llllllllllllllIllIlllIlIIlIllIII;
    }
    
    public void setYaw(final float llllllllllllllIllIlllIlIlIIIIlIl) {
        this._yaw = llllllllllllllIllIlllIlIlIIIIlIl;
    }
    
    public void setPitch(final double llllllllllllllIllIlllIlIIlllIIII) {
        this._pitch = (float)llllllllllllllIllIlllIlIIlllIIII;
    }
    
    public void setY(final double llllllllllllllIllIlllIlIIlIllllI) {
        this.y = llllllllllllllIllIlllIlIIlIllllI;
    }
    
    public double getX() {
        return this.x;
    }
    
    public void setX(final double llllllllllllllIllIlllIlIIllIIlII) {
        this.x = llllllllllllllIllIlllIlIIllIIlII;
    }
    
    public boolean isForceCancelled() {
        return this._isForceCancelled;
    }
    
    public float getYaw() {
        return this._yaw;
    }
    
    public float getPitch() {
        return this._pitch;
    }
    
    public double getY() {
        return this.y;
    }
}
