package net.minecraft.network.play.client;

import net.minecraft.network.play.*;
import java.io.*;
import net.minecraft.network.*;
import net.minecraft.entity.player.*;

public class CPacketPlayerAbilities implements Packet<INetHandlerPlayServer>
{
    private /* synthetic */ boolean creativeMode;
    private /* synthetic */ boolean allowFlying;
    public /* synthetic */ boolean flying;
    private /* synthetic */ float flySpeed;
    private /* synthetic */ boolean invulnerable;
    private /* synthetic */ float walkSpeed;
    
    @Override
    public void readPacketData(final PacketBuffer lllllllllllllllllIllllIIIIIlIlIl) throws IOException {
        final byte lllllllllllllllllIllllIIIIIlIlII = lllllllllllllllllIllllIIIIIlIlIl.readByte();
        this.setInvulnerable((lllllllllllllllllIllllIIIIIlIlII & 0x1) > 0);
        this.setFlying((lllllllllllllllllIllllIIIIIlIlII & 0x2) > 0);
        this.setAllowFlying((lllllllllllllllllIllllIIIIIlIlII & 0x4) > 0);
        this.setCreativeMode((lllllllllllllllllIllllIIIIIlIlII & 0x8) > 0);
        this.setFlySpeed(lllllllllllllllllIllllIIIIIlIlIl.readFloat());
        this.setWalkSpeed(lllllllllllllllllIllllIIIIIlIlIl.readFloat());
    }
    
    public void setFlying(final boolean lllllllllllllllllIlllIllllllIIlI) {
        this.flying = lllllllllllllllllIlllIllllllIIlI;
    }
    
    public void setWalkSpeed(final float lllllllllllllllllIlllIllllIlIIlI) {
        this.walkSpeed = lllllllllllllllllIlllIllllIlIIlI;
    }
    
    public void setCreativeMode(final boolean lllllllllllllllllIlllIllllIllllI) {
        this.creativeMode = lllllllllllllllllIlllIllllIllllI;
    }
    
    public void setFlySpeed(final float lllllllllllllllllIlllIllllIllIlI) {
        this.flySpeed = lllllllllllllllllIlllIllllIllIlI;
    }
    
    public CPacketPlayerAbilities() {
    }
    
    @Override
    public void writePacketData(final PacketBuffer lllllllllllllllllIllllIIIIIIlIIl) throws IOException {
        byte lllllllllllllllllIllllIIIIIIlIll = 0;
        if (this.isInvulnerable()) {
            lllllllllllllllllIllllIIIIIIlIll |= 0x1;
        }
        if (this.isFlying()) {
            lllllllllllllllllIllllIIIIIIlIll |= 0x2;
        }
        if (this.isAllowFlying()) {
            lllllllllllllllllIllllIIIIIIlIll |= 0x4;
        }
        if (this.isCreativeMode()) {
            lllllllllllllllllIllllIIIIIIlIll |= 0x8;
        }
        lllllllllllllllllIllllIIIIIIlIIl.writeByte(lllllllllllllllllIllllIIIIIIlIll);
        lllllllllllllllllIllllIIIIIIlIIl.writeFloat(this.flySpeed);
        lllllllllllllllllIllllIIIIIIlIIl.writeFloat(this.walkSpeed);
    }
    
    public boolean isInvulnerable() {
        return this.invulnerable;
    }
    
    public boolean isCreativeMode() {
        return this.creativeMode;
    }
    
    public void setAllowFlying(final boolean lllllllllllllllllIlllIlllllIIlll) {
        this.allowFlying = lllllllllllllllllIlllIlllllIIlll;
    }
    
    @Override
    public void processPacket(final INetHandlerPlayServer lllllllllllllllllIllllIIIIIIIIlI) {
        lllllllllllllllllIllllIIIIIIIIlI.processPlayerAbilities(this);
    }
    
    public boolean isFlying() {
        return this.flying;
    }
    
    public CPacketPlayerAbilities(final PlayerCapabilities lllllllllllllllllIllllIIIIIllIlI) {
        this.setInvulnerable(lllllllllllllllllIllllIIIIIllIlI.disableDamage);
        this.setFlying(lllllllllllllllllIllllIIIIIllIlI.isFlying);
        this.setAllowFlying(lllllllllllllllllIllllIIIIIllIlI.allowFlying);
        this.setCreativeMode(lllllllllllllllllIllllIIIIIllIlI.isCreativeMode);
        this.setFlySpeed(lllllllllllllllllIllllIIIIIllIlI.getFlySpeed());
        this.setWalkSpeed(lllllllllllllllllIllllIIIIIllIlI.getWalkSpeed());
    }
    
    public boolean isAllowFlying() {
        return this.allowFlying;
    }
    
    public void setInvulnerable(final boolean lllllllllllllllllIlllIlllllllIIl) {
        this.invulnerable = lllllllllllllllllIlllIlllllllIIl;
    }
}
