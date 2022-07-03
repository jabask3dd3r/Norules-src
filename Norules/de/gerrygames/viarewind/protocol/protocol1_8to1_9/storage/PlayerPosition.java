package de.gerrygames.viarewind.protocol.protocol1_8to1_9.storage;

import com.viaversion.viaversion.api.connection.*;

public class PlayerPosition extends StoredObject
{
    private /* synthetic */ boolean onGround;
    private /* synthetic */ int confirmId;
    private /* synthetic */ double posX;
    private /* synthetic */ float yaw;
    private /* synthetic */ double posZ;
    private /* synthetic */ float pitch;
    private /* synthetic */ double posY;
    
    public void setYaw(final float lllllllllllllIIllIlllllllIlIIlll) {
        this.yaw = lllllllllllllIIllIlllllllIlIIlll % 360.0f;
    }
    
    public void setPosZ(final double lllllllllllllIIllIllllllIlIllIIl) {
        this.posZ = lllllllllllllIIllIllllllIlIllIIl;
    }
    
    public float getPitch() {
        return this.pitch;
    }
    
    public void setOnGround(final boolean lllllllllllllIIllIllllllIlIlIIll) {
        this.onGround = lllllllllllllIIllIllllllIlIlIIll;
    }
    
    public void setPosY(final double lllllllllllllIIllIllllllIllIIlIl) {
        this.posY = lllllllllllllIIllIllllllIllIIlIl;
    }
    
    public PlayerPosition(final UserConnection lllllllllllllIIllIllllllllIIllIl) {
        super(lllllllllllllIIllIllllllllIIllIl);
        this.confirmId = -1;
    }
    
    public void setConfirmId(final int lllllllllllllIIllIllllllIlIIlIII) {
        this.confirmId = lllllllllllllIIllIllllllIlIIlIII;
    }
    
    public double getPosY() {
        return this.posY;
    }
    
    public void setPos(final double lllllllllllllIIllIlllllllIlllllI, final double lllllllllllllIIllIlllllllIllllII, final double lllllllllllllIIllIlllllllIlllIlI) {
        this.posX = lllllllllllllIIllIlllllllIlllllI;
        this.posY = lllllllllllllIIllIlllllllIllllII;
        this.posZ = lllllllllllllIIllIlllllllIlllIlI;
    }
    
    public double getPosX() {
        return this.posX;
    }
    
    public int getConfirmId() {
        return this.confirmId;
    }
    
    public float getYaw() {
        return this.yaw;
    }
    
    public void setPosX(final double lllllllllllllIIllIllllllIllIllII) {
        this.posX = lllllllllllllIIllIllllllIllIllII;
    }
    
    @Override
    public String toString() {
        return String.valueOf(new StringBuilder().append("PlayerPosition(posX=").append(this.getPosX()).append(", posY=").append(this.getPosY()).append(", posZ=").append(this.getPosZ()).append(", yaw=").append(this.getYaw()).append(", pitch=").append(this.getPitch()).append(", onGround=").append(this.isOnGround()).append(", confirmId=").append(this.getConfirmId()).append(")"));
    }
    
    public void setPitch(final float lllllllllllllIIllIlllllllIIllllI) {
        this.pitch = lllllllllllllIIllIlllllllIIllllI % 360.0f;
    }
    
    @Override
    public boolean equals(final Object lllllllllllllIIllIllllllIlIIIIll) {
        if (lllllllllllllIIllIllllllIlIIIIll == this) {
            return true;
        }
        if (!(lllllllllllllIIllIllllllIlIIIIll instanceof PlayerPosition)) {
            return false;
        }
        final PlayerPosition lllllllllllllIIllIllllllIlIIIIlI = (PlayerPosition)lllllllllllllIIllIllllllIlIIIIll;
        return lllllllllllllIIllIllllllIlIIIIlI.canEqual(this) && Double.compare(this.getPosX(), lllllllllllllIIllIllllllIlIIIIlI.getPosX()) == 0 && Double.compare(this.getPosY(), lllllllllllllIIllIllllllIlIIIIlI.getPosY()) == 0 && Double.compare(this.getPosZ(), lllllllllllllIIllIllllllIlIIIIlI.getPosZ()) == 0 && Float.compare(this.getYaw(), lllllllllllllIIllIllllllIlIIIIlI.getYaw()) == 0 && Float.compare(this.getPitch(), lllllllllllllIIllIllllllIlIIIIlI.getPitch()) == 0 && this.isOnGround() == lllllllllllllIIllIllllllIlIIIIlI.isOnGround() && this.getConfirmId() == lllllllllllllIIllIllllllIlIIIIlI.getConfirmId();
    }
    
    public boolean isOnGround() {
        return this.onGround;
    }
    
    @Override
    public int hashCode() {
        final int lllllllllllllIIllIllllllIIllIIll = 59;
        int lllllllllllllIIllIllllllIIllIIlI = 1;
        final long lllllllllllllIIllIllllllIIllIIIl = Double.doubleToLongBits(this.getPosX());
        lllllllllllllIIllIllllllIIllIIlI = lllllllllllllIIllIllllllIIllIIlI * 59 + (int)(lllllllllllllIIllIllllllIIllIIIl >>> 32 ^ lllllllllllllIIllIllllllIIllIIIl);
        final long lllllllllllllIIllIllllllIIllIIII = Double.doubleToLongBits(this.getPosY());
        lllllllllllllIIllIllllllIIllIIlI = lllllllllllllIIllIllllllIIllIIlI * 59 + (int)(lllllllllllllIIllIllllllIIllIIII >>> 32 ^ lllllllllllllIIllIllllllIIllIIII);
        final long lllllllllllllIIllIllllllIIlIllll = Double.doubleToLongBits(this.getPosZ());
        lllllllllllllIIllIllllllIIllIIlI = lllllllllllllIIllIllllllIIllIIlI * 59 + (int)(lllllllllllllIIllIllllllIIlIllll >>> 32 ^ lllllllllllllIIllIllllllIIlIllll);
        lllllllllllllIIllIllllllIIllIIlI = lllllllllllllIIllIllllllIIllIIlI * 59 + Float.floatToIntBits(this.getYaw());
        lllllllllllllIIllIllllllIIllIIlI = lllllllllllllIIllIllllllIIllIIlI * 59 + Float.floatToIntBits(this.getPitch());
        lllllllllllllIIllIllllllIIllIIlI = lllllllllllllIIllIllllllIIllIIlI * 59 + (this.isOnGround() ? 79 : 97);
        lllllllllllllIIllIllllllIIllIIlI = lllllllllllllIIllIllllllIIllIIlI * 59 + this.getConfirmId();
        return lllllllllllllIIllIllllllIIllIIlI;
    }
    
    public double getPosZ() {
        return this.posZ;
    }
    
    protected boolean canEqual(final Object lllllllllllllIIllIllllllIIllllII) {
        return lllllllllllllIIllIllllllIIllllII instanceof PlayerPosition;
    }
}
