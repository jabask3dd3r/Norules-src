package de.gerrygames.viarewind.protocol.protocol1_7_6_10to1_8.storage;

import com.viaversion.viaversion.api.connection.*;

public class PlayerAbilities extends StoredObject
{
    private /* synthetic */ boolean allowFly;
    private /* synthetic */ float flySpeed;
    private /* synthetic */ boolean sprinting;
    private /* synthetic */ boolean invincible;
    private /* synthetic */ boolean flying;
    private /* synthetic */ boolean creative;
    private /* synthetic */ float walkSpeed;
    
    public void setFlying(final boolean llllllllllllllllllIIIIllIllllllI) {
        this.flying = llllllllllllllllllIIIIllIllllllI;
    }
    
    public boolean isFlying() {
        return this.flying;
    }
    
    public boolean isSprinting() {
        return this.sprinting;
    }
    
    public void setSprinting(final boolean llllllllllllllllllIIIIlllIIIlIlI) {
        this.sprinting = llllllllllllllllllIIIIlllIIIlIlI;
    }
    
    protected boolean canEqual(final Object llllllllllllllllllIIIIllIlIllIII) {
        return llllllllllllllllllIIIIllIlIllIII instanceof PlayerAbilities;
    }
    
    public void setInvincible(final boolean llllllllllllllllllIIIIllIlllIllI) {
        this.invincible = llllllllllllllllllIIIIllIlllIllI;
    }
    
    public float getWalkSpeed() {
        return this.walkSpeed;
    }
    
    public byte getFlags() {
        byte llllllllllllllllllIIIIlllIlIIlIl = 0;
        if (this.invincible) {
            llllllllllllllllllIIIIlllIlIIlIl |= 0x8;
        }
        if (this.allowFly) {
            llllllllllllllllllIIIIlllIlIIlIl |= 0x4;
        }
        if (this.flying) {
            llllllllllllllllllIIIIlllIlIIlIl |= 0x2;
        }
        if (this.creative) {
            llllllllllllllllllIIIIlllIlIIlIl |= 0x1;
        }
        return llllllllllllllllllIIIIlllIlIIlIl;
    }
    
    public boolean isInvincible() {
        return this.invincible;
    }
    
    @Override
    public String toString() {
        return String.valueOf(new StringBuilder().append("PlayerAbilities(sprinting=").append(this.isSprinting()).append(", allowFly=").append(this.isAllowFly()).append(", flying=").append(this.isFlying()).append(", invincible=").append(this.isInvincible()).append(", creative=").append(this.isCreative()).append(", flySpeed=").append(this.getFlySpeed()).append(", walkSpeed=").append(this.getWalkSpeed()).append(")"));
    }
    
    public void setFlySpeed(final float llllllllllllllllllIIIIllIllIllII) {
        this.flySpeed = llllllllllllllllllIIIIllIllIllII;
    }
    
    public boolean isCreative() {
        return this.creative;
    }
    
    @Override
    public boolean equals(final Object llllllllllllllllllIIIIllIlIlllll) {
        if (llllllllllllllllllIIIIllIlIlllll == this) {
            return true;
        }
        if (!(llllllllllllllllllIIIIllIlIlllll instanceof PlayerAbilities)) {
            return false;
        }
        final PlayerAbilities llllllllllllllllllIIIIllIlIllllI = (PlayerAbilities)llllllllllllllllllIIIIllIlIlllll;
        return llllllllllllllllllIIIIllIlIllllI.canEqual(this) && this.isSprinting() == llllllllllllllllllIIIIllIlIllllI.isSprinting() && this.isAllowFly() == llllllllllllllllllIIIIllIlIllllI.isAllowFly() && this.isFlying() == llllllllllllllllllIIIIllIlIllllI.isFlying() && this.isInvincible() == llllllllllllllllllIIIIllIlIllllI.isInvincible() && this.isCreative() == llllllllllllllllllIIIIllIlIllllI.isCreative() && Float.compare(this.getFlySpeed(), llllllllllllllllllIIIIllIlIllllI.getFlySpeed()) == 0 && Float.compare(this.getWalkSpeed(), llllllllllllllllllIIIIllIlIllllI.getWalkSpeed()) == 0;
    }
    
    public void setCreative(final boolean llllllllllllllllllIIIIllIlllIIlI) {
        this.creative = llllllllllllllllllIIIIllIlllIIlI;
    }
    
    public float getFlySpeed() {
        return this.flySpeed;
    }
    
    public PlayerAbilities(final UserConnection llllllllllllllllllIIIIlllIlIlIIl) {
        super(llllllllllllllllllIIIIlllIlIlIIl);
    }
    
    public void setWalkSpeed(final float llllllllllllllllllIIIIllIllIIllI) {
        this.walkSpeed = llllllllllllllllllIIIIllIllIIllI;
    }
    
    @Override
    public int hashCode() {
        final int llllllllllllllllllIIIIllIlIlIIlI = 59;
        int llllllllllllllllllIIIIllIlIlIIIl = 1;
        llllllllllllllllllIIIIllIlIlIIIl = llllllllllllllllllIIIIllIlIlIIIl * 59 + (this.isSprinting() ? 79 : 97);
        llllllllllllllllllIIIIllIlIlIIIl = llllllllllllllllllIIIIllIlIlIIIl * 59 + (this.isAllowFly() ? 79 : 97);
        llllllllllllllllllIIIIllIlIlIIIl = llllllllllllllllllIIIIllIlIlIIIl * 59 + (this.isFlying() ? 79 : 97);
        llllllllllllllllllIIIIllIlIlIIIl = llllllllllllllllllIIIIllIlIlIIIl * 59 + (this.isInvincible() ? 79 : 97);
        llllllllllllllllllIIIIllIlIlIIIl = llllllllllllllllllIIIIllIlIlIIIl * 59 + (this.isCreative() ? 79 : 97);
        llllllllllllllllllIIIIllIlIlIIIl = llllllllllllllllllIIIIllIlIlIIIl * 59 + Float.floatToIntBits(this.getFlySpeed());
        llllllllllllllllllIIIIllIlIlIIIl = llllllllllllllllllIIIIllIlIlIIIl * 59 + Float.floatToIntBits(this.getWalkSpeed());
        return llllllllllllllllllIIIIllIlIlIIIl;
    }
    
    public boolean isAllowFly() {
        return this.allowFly;
    }
    
    public void setAllowFly(final boolean llllllllllllllllllIIIIlllIIIIlII) {
        this.allowFly = llllllllllllllllllIIIIlllIIIIlII;
    }
}
