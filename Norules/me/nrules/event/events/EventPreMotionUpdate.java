package me.nrules.event.events;

import me.nrules.event.*;
import net.minecraft.network.play.client.*;
import net.minecraft.client.*;

public class EventPreMotionUpdate extends Event
{
    private /* synthetic */ CPacketPlayer.Rotation rotation;
    private /* synthetic */ LPosition location;
    public /* synthetic */ double y;
    public /* synthetic */ float pitch;
    private /* synthetic */ boolean cancel;
    public /* synthetic */ float yaw;
    
    public double getY() {
        return this.y;
    }
    
    public float getPitch() {
        return this.pitch;
    }
    
    public EventPreMotionUpdate(final float llllllllllllllIlIIllIIIIIIlllIIl, final float llllllllllllllIlIIllIIIIIIlllIII, final double llllllllllllllIlIIllIIIIIIllIlll, final LPosition llllllllllllllIlIIllIIIIIIllIIIl) {
        this.yaw = llllllllllllllIlIIllIIIIIIlllIIl;
        this.pitch = llllllllllllllIlIIllIIIIIIlllIII;
        this.y = llllllllllllllIlIIllIIIIIIllIlll;
        this.location = llllllllllllllIlIIllIIIIIIllIIIl;
    }
    
    public CPacketPlayer.Rotation getRotation() {
        return this.rotation;
    }
    
    public void setY(final double llllllllllllllIlIIllIIIIIIIIllII) {
        this.y = llllllllllllllIlIIllIIIIIIIIllII;
    }
    
    public void setYaw(final float llllllllllllllIlIIllIIIIIIIlllII) {
        Minecraft.getMinecraft().player.renderYawOffset = llllllllllllllIlIIllIIIIIIIlllII;
        Minecraft.getMinecraft().player.rotationYawHead = llllllllllllllIlIIllIIIIIIIlllII;
        this.yaw = llllllllllllllIlIIllIIIIIIIlllII;
    }
    
    public double getLegitMotion() {
        return 0.41999998688697815;
    }
    
    public void setPitch(final float llllllllllllllIlIIllIIIIIIIlIIll) {
        Minecraft.getMinecraft().player.rotationPitchHead = llllllllllllllIlIIllIIIIIIIlIIll;
        this.pitch = llllllllllllllIlIIllIIIIIIIlIIll;
    }
    
    public float getYaw() {
        return this.yaw;
    }
    
    public void setCancel(final boolean llllllllllllllIlIIllIIIIIIlIlIlI) {
        this.cancel = llllllllllllllIlIIllIIIIIIlIlIlI;
    }
    
    public boolean isCancel() {
        return this.cancel;
    }
    
    public EventPlayerMotionUpdate getLocation() {
        return null;
    }
}
