package net.minecraft.network.play.server;

import net.minecraft.network.play.*;
import net.minecraft.entity.*;
import java.io.*;
import net.minecraft.world.*;
import net.minecraft.network.*;

public class SPacketEntityHeadLook implements Packet<INetHandlerPlayClient>
{
    private /* synthetic */ byte yaw;
    private /* synthetic */ int entityId;
    
    public SPacketEntityHeadLook(final Entity lllllllllllllIIIIIllIIlIllIIIIlI, final byte lllllllllllllIIIIIllIIlIllIIIIIl) {
        this.entityId = lllllllllllllIIIIIllIIlIllIIIIlI.getEntityId();
        this.yaw = lllllllllllllIIIIIllIIlIllIIIIIl;
    }
    
    @Override
    public void writePacketData(final PacketBuffer lllllllllllllIIIIIllIIlIlIllIlIl) throws IOException {
        lllllllllllllIIIIIllIIlIlIllIlIl.writeVarIntToBuffer(this.entityId);
        lllllllllllllIIIIIllIIlIlIllIlIl.writeByte(this.yaw);
    }
    
    @Override
    public void readPacketData(final PacketBuffer lllllllllllllIIIIIllIIlIlIlllIll) throws IOException {
        this.entityId = lllllllllllllIIIIIllIIlIlIlllIll.readVarIntFromBuffer();
        this.yaw = lllllllllllllIIIIIllIIlIlIlllIll.readByte();
    }
    
    public Entity getEntity(final World lllllllllllllIIIIIllIIlIlIlIlIll) {
        return lllllllllllllIIIIIllIIlIlIlIlIll.getEntityByID(this.entityId);
    }
    
    @Override
    public void processPacket(final INetHandlerPlayClient lllllllllllllIIIIIllIIlIlIllIIIl) {
        lllllllllllllIIIIIllIIlIlIllIIIl.handleEntityHeadLook(this);
    }
    
    public SPacketEntityHeadLook() {
    }
    
    public byte getYaw() {
        return this.yaw;
    }
}
