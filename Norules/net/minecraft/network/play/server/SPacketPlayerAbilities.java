package net.minecraft.network.play.server;

import net.minecraft.network.play.*;
import net.minecraft.network.*;
import java.io.*;
import net.minecraft.entity.player.*;

public class SPacketPlayerAbilities implements Packet<INetHandlerPlayClient>
{
    private /* synthetic */ float walkSpeed;
    private /* synthetic */ boolean flying;
    private /* synthetic */ float flySpeed;
    private /* synthetic */ boolean creativeMode;
    private /* synthetic */ boolean invulnerable;
    private /* synthetic */ boolean allowFlying;
    
    public void setCreativeMode(final boolean llllllllllllllllllllllIlllIlIlII) {
        this.creativeMode = llllllllllllllllllllllIlllIlIlII;
    }
    
    public boolean isInvulnerable() {
        return this.invulnerable;
    }
    
    public void setFlying(final boolean llllllllllllllllllllllIllllIIllI) {
        this.flying = llllllllllllllllllllllIllllIIllI;
    }
    
    @Override
    public void writePacketData(final PacketBuffer llllllllllllllllllllllIlllllllll) throws IOException {
        byte lllllllllllllllllllllllIIIIIIIIl = 0;
        if (this.isInvulnerable()) {
            lllllllllllllllllllllllIIIIIIIIl |= 0x1;
        }
        if (this.isFlying()) {
            lllllllllllllllllllllllIIIIIIIIl |= 0x2;
        }
        if (this.isAllowFlying()) {
            lllllllllllllllllllllllIIIIIIIIl |= 0x4;
        }
        if (this.isCreativeMode()) {
            lllllllllllllllllllllllIIIIIIIIl |= 0x8;
        }
        llllllllllllllllllllllIlllllllll.writeByte(lllllllllllllllllllllllIIIIIIIIl);
        llllllllllllllllllllllIlllllllll.writeFloat(this.flySpeed);
        llllllllllllllllllllllIlllllllll.writeFloat(this.walkSpeed);
    }
    
    public SPacketPlayerAbilities(final PlayerCapabilities lllllllllllllllllllllllIIIIlIIII) {
        this.setInvulnerable(lllllllllllllllllllllllIIIIlIIII.disableDamage);
        this.setFlying(lllllllllllllllllllllllIIIIlIIII.isFlying);
        this.setAllowFlying(lllllllllllllllllllllllIIIIlIIII.allowFlying);
        this.setCreativeMode(lllllllllllllllllllllllIIIIlIIII.isCreativeMode);
        this.setFlySpeed(lllllllllllllllllllllllIIIIlIIII.getFlySpeed());
        this.setWalkSpeed(lllllllllllllllllllllllIIIIlIIII.getWalkSpeed());
    }
    
    public void setAllowFlying(final boolean llllllllllllllllllllllIlllIlllll) {
        this.allowFlying = llllllllllllllllllllllIlllIlllll;
    }
    
    public boolean isCreativeMode() {
        return this.creativeMode;
    }
    
    public void setWalkSpeed(final float llllllllllllllllllllllIlllIIIIlI) {
        this.walkSpeed = llllllllllllllllllllllIlllIIIIlI;
    }
    
    public float getFlySpeed() {
        return this.flySpeed;
    }
    
    public SPacketPlayerAbilities() {
    }
    
    public boolean isAllowFlying() {
        return this.allowFlying;
    }
    
    public boolean isFlying() {
        return this.flying;
    }
    
    @Override
    public void processPacket(final INetHandlerPlayClient llllllllllllllllllllllIllllllIlI) {
        llllllllllllllllllllllIllllllIlI.handlePlayerAbilities(this);
    }
    
    @Override
    public void readPacketData(final PacketBuffer lllllllllllllllllllllllIIIIIlIII) throws IOException {
        final byte lllllllllllllllllllllllIIIIIlIlI = lllllllllllllllllllllllIIIIIlIII.readByte();
        this.setInvulnerable((lllllllllllllllllllllllIIIIIlIlI & 0x1) > 0);
        this.setFlying((lllllllllllllllllllllllIIIIIlIlI & 0x2) > 0);
        this.setAllowFlying((lllllllllllllllllllllllIIIIIlIlI & 0x4) > 0);
        this.setCreativeMode((lllllllllllllllllllllllIIIIIlIlI & 0x8) > 0);
        this.setFlySpeed(lllllllllllllllllllllllIIIIIlIII.readFloat());
        this.setWalkSpeed(lllllllllllllllllllllllIIIIIlIII.readFloat());
    }
    
    public void setFlySpeed(final float llllllllllllllllllllllIlllIIlIll) {
        this.flySpeed = llllllllllllllllllllllIlllIIlIll;
    }
    
    public void setInvulnerable(final boolean llllllllllllllllllllllIllllIllll) {
        this.invulnerable = llllllllllllllllllllllIllllIllll;
    }
    
    public float getWalkSpeed() {
        return this.walkSpeed;
    }
}
