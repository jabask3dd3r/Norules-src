package net.minecraft.network.play.server;

import net.minecraft.network.play.*;
import net.minecraft.network.*;
import java.io.*;
import net.minecraft.entity.*;
import net.minecraft.entity.effect.*;

public class SPacketSpawnGlobalEntity implements Packet<INetHandlerPlayClient>
{
    private /* synthetic */ double y;
    private /* synthetic */ int entityId;
    private /* synthetic */ int type;
    private /* synthetic */ double x;
    private /* synthetic */ double z;
    
    public SPacketSpawnGlobalEntity() {
    }
    
    @Override
    public void processPacket(final INetHandlerPlayClient lllllllllllllIIIllIIlIIlIIIlIlIl) {
        lllllllllllllIIIllIIlIIlIIIlIlIl.handleSpawnGlobalEntity(this);
    }
    
    public int getEntityId() {
        return this.entityId;
    }
    
    public double getZ() {
        return this.z;
    }
    
    public double getY() {
        return this.y;
    }
    
    @Override
    public void readPacketData(final PacketBuffer lllllllllllllIIIllIIlIIlIIIlllll) throws IOException {
        this.entityId = lllllllllllllIIIllIIlIIlIIIlllll.readVarIntFromBuffer();
        this.type = lllllllllllllIIIllIIlIIlIIIlllll.readByte();
        this.x = lllllllllllllIIIllIIlIIlIIIlllll.readDouble();
        this.y = lllllllllllllIIIllIIlIIlIIIlllll.readDouble();
        this.z = lllllllllllllIIIllIIlIIlIIIlllll.readDouble();
    }
    
    public int getType() {
        return this.type;
    }
    
    @Override
    public void writePacketData(final PacketBuffer lllllllllllllIIIllIIlIIlIIIllIll) throws IOException {
        lllllllllllllIIIllIIlIIlIIIllIll.writeVarIntToBuffer(this.entityId);
        lllllllllllllIIIllIIlIIlIIIllIll.writeByte(this.type);
        lllllllllllllIIIllIIlIIlIIIllIll.writeDouble(this.x);
        lllllllllllllIIIllIIlIIlIIIllIll.writeDouble(this.y);
        lllllllllllllIIIllIIlIIlIIIllIll.writeDouble(this.z);
    }
    
    public SPacketSpawnGlobalEntity(final Entity lllllllllllllIIIllIIlIIlIIlIIlIl) {
        this.entityId = lllllllllllllIIIllIIlIIlIIlIIlIl.getEntityId();
        this.x = lllllllllllllIIIllIIlIIlIIlIIlIl.posX;
        this.y = lllllllllllllIIIllIIlIIlIIlIIlIl.posY;
        this.z = lllllllllllllIIIllIIlIIlIIlIIlIl.posZ;
        if (lllllllllllllIIIllIIlIIlIIlIIlIl instanceof EntityLightningBolt) {
            this.type = 1;
        }
    }
    
    public double getX() {
        return this.x;
    }
}
