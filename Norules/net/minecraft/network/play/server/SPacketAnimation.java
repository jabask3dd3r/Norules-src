package net.minecraft.network.play.server;

import net.minecraft.network.play.*;
import java.io.*;
import net.minecraft.entity.*;
import net.minecraft.network.*;

public class SPacketAnimation implements Packet<INetHandlerPlayClient>
{
    private /* synthetic */ int entityId;
    private /* synthetic */ int type;
    
    @Override
    public void readPacketData(final PacketBuffer lllllllllllllIIIlIIlIllIIlIIlIIl) throws IOException {
        this.entityId = lllllllllllllIIIlIIlIllIIlIIlIIl.readVarIntFromBuffer();
        this.type = lllllllllllllIIIlIIlIllIIlIIlIIl.readUnsignedByte();
    }
    
    public SPacketAnimation(final Entity lllllllllllllIIIlIIlIllIIlIlIIll, final int lllllllllllllIIIlIIlIllIIlIlIIlI) {
        this.entityId = lllllllllllllIIIlIIlIllIIlIlIIll.getEntityId();
        this.type = lllllllllllllIIIlIIlIllIIlIlIIlI;
    }
    
    @Override
    public void processPacket(final INetHandlerPlayClient lllllllllllllIIIlIIlIllIIIllllIl) {
        lllllllllllllIIIlIIlIllIIIllllIl.handleAnimation(this);
    }
    
    public int getEntityID() {
        return this.entityId;
    }
    
    public SPacketAnimation() {
    }
    
    public int getAnimationType() {
        return this.type;
    }
    
    @Override
    public void writePacketData(final PacketBuffer lllllllllllllIIIlIIlIllIIlIIIIll) throws IOException {
        lllllllllllllIIIlIIlIllIIlIIIIll.writeVarIntToBuffer(this.entityId);
        lllllllllllllIIIlIIlIllIIlIIIIll.writeByte(this.type);
    }
}
