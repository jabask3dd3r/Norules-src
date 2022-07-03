package de.gerrygames.viarewind.protocol.protocol1_7_6_10to1_8.storage;

import com.viaversion.viaversion.api.connection.*;

public class PlayerPosition extends StoredObject
{
    private /* synthetic */ double posY;
    private /* synthetic */ double posZ;
    private /* synthetic */ boolean onGround;
    private /* synthetic */ float yaw;
    private /* synthetic */ double receivedPosY;
    private /* synthetic */ float pitch;
    private /* synthetic */ boolean positionPacketReceived;
    private /* synthetic */ double posX;
    
    public void setPosX(final double lllllllllllllIIIllIIIlIlIllIlIll) {
        this.posX = lllllllllllllIIIllIIIlIlIllIlIll;
    }
    
    public float getPitch() {
        return this.pitch;
    }
    
    public boolean isOnGround() {
        return this.onGround;
    }
    
    public void setPosZ(final double lllllllllllllIIIllIIIlIlIlIIllll) {
        this.posZ = lllllllllllllIIIllIIIlIlIlIIllll;
    }
    
    public void setPosY(final double lllllllllllllIIIllIIIlIlIlIllIII) {
        this.posY = lllllllllllllIIIllIIIlIlIlIllIII;
    }
    
    public double getPosX() {
        return this.posX;
    }
    
    public void setYaw(final float lllllllllllllIIIllIIIlIlIlIIIllI) {
        this.yaw = lllllllllllllIIIllIIIlIlIlIIIllI;
    }
    
    public void setPositionPacketReceived(final boolean lllllllllllllIIIllIIIlIllIIIlIIl) {
        this.positionPacketReceived = lllllllllllllIIIllIIIlIllIIIlIIl;
    }
    
    public double getPosY() {
        return this.posY;
    }
    
    public void setPitch(final float lllllllllllllIIIllIIIlIlIIllIlll) {
        this.pitch = lllllllllllllIIIllIIIlIlIIllIlll;
    }
    
    public double getReceivedPosY() {
        return this.receivedPosY;
    }
    
    public float getYaw() {
        return this.yaw;
    }
    
    public double getPosZ() {
        return this.posZ;
    }
    
    public void setPos(final double lllllllllllllIIIllIIIlIllIIllIlI, final double lllllllllllllIIIllIIIlIllIIllllI, final double lllllllllllllIIIllIIIlIllIIlIlll) {
        this.posX = lllllllllllllIIIllIIIlIllIIllIlI;
        this.posY = lllllllllllllIIIllIIIlIllIIllllI;
        this.posZ = lllllllllllllIIIllIIIlIllIIlIlll;
    }
    
    public boolean isPositionPacketReceived() {
        return this.positionPacketReceived;
    }
    
    public PlayerPosition(final UserConnection lllllllllllllIIIllIIIlIllIlIlIlI) {
        super(lllllllllllllIIIllIIIlIllIlIlIlI);
    }
    
    public void setOnGround(final boolean lllllllllllllIIIllIIIlIlIIIlllll) {
        this.onGround = lllllllllllllIIIllIIIlIlIIIlllll;
    }
    
    public void setReceivedPosY(final double lllllllllllllIIIllIIIlIlIllllIII) {
        this.receivedPosY = lllllllllllllIIIllIIIlIlIllllIII;
    }
}
