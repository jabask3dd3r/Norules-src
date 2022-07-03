package net.minecraft.network.play.client;

import net.minecraft.network.play.*;
import java.io.*;
import net.minecraft.network.*;

public class CPacketInput implements Packet<INetHandlerPlayServer>
{
    private /* synthetic */ float strafeSpeed;
    private /* synthetic */ float field_192621_b;
    private /* synthetic */ boolean sneaking;
    private /* synthetic */ boolean jumping;
    
    @Override
    public void readPacketData(final PacketBuffer lllllllllllllllIllIIllIlIIllllll) throws IOException {
        this.strafeSpeed = lllllllllllllllIllIIllIlIIllllll.readFloat();
        this.field_192621_b = lllllllllllllllIllIIllIlIIllllll.readFloat();
        final byte lllllllllllllllIllIIllIlIlIIIIIl = lllllllllllllllIllIIllIlIIllllll.readByte();
        this.jumping = ((lllllllllllllllIllIIllIlIlIIIIIl & 0x1) > 0);
        this.sneaking = ((lllllllllllllllIllIIllIlIlIIIIIl & 0x2) > 0);
    }
    
    public CPacketInput() {
    }
    
    public CPacketInput(final float lllllllllllllllIllIIllIlIlIIlIlI, final float lllllllllllllllIllIIllIlIlIIlllI, final boolean lllllllllllllllIllIIllIlIlIIllIl, final boolean lllllllllllllllIllIIllIlIlIIllII) {
        this.strafeSpeed = lllllllllllllllIllIIllIlIlIIlIlI;
        this.field_192621_b = lllllllllllllllIllIIllIlIlIIlllI;
        this.jumping = lllllllllllllllIllIIllIlIlIIllIl;
        this.sneaking = lllllllllllllllIllIIllIlIlIIllII;
    }
    
    @Override
    public void writePacketData(final PacketBuffer lllllllllllllllIllIIllIlIIllIllI) throws IOException {
        lllllllllllllllIllIIllIlIIllIllI.writeFloat(this.strafeSpeed);
        lllllllllllllllIllIIllIlIIllIllI.writeFloat(this.field_192621_b);
        byte lllllllllllllllIllIIllIlIIlllIII = 0;
        if (this.jumping) {
            lllllllllllllllIllIIllIlIIlllIII |= 0x1;
        }
        if (this.sneaking) {
            lllllllllllllllIllIIllIlIIlllIII |= 0x2;
        }
        lllllllllllllllIllIIllIlIIllIllI.writeByte(lllllllllllllllIllIIllIlIIlllIII);
    }
    
    public float getStrafeSpeed() {
        return this.strafeSpeed;
    }
    
    public float func_192620_b() {
        return this.field_192621_b;
    }
    
    public boolean isJumping() {
        return this.jumping;
    }
    
    public boolean isSneaking() {
        return this.sneaking;
    }
    
    @Override
    public void processPacket(final INetHandlerPlayServer lllllllllllllllIllIIllIlIIlIllll) {
        lllllllllllllllIllIIllIlIIlIllll.processInput(this);
    }
}
