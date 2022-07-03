package net.minecraft.network.play.server;

import net.minecraft.network.play.*;
import net.minecraft.entity.item.*;
import net.minecraft.network.*;
import java.io.*;

public class SPacketSpawnExperienceOrb implements Packet<INetHandlerPlayClient>
{
    private /* synthetic */ double posZ;
    private /* synthetic */ int xpValue;
    private /* synthetic */ double posY;
    private /* synthetic */ double posX;
    private /* synthetic */ int entityID;
    
    public int getEntityID() {
        return this.entityID;
    }
    
    public int getXPValue() {
        return this.xpValue;
    }
    
    public SPacketSpawnExperienceOrb(final EntityXPOrb lllllllllllllIIIlIIlIIllIIIllIlI) {
        this.entityID = lllllllllllllIIIlIIlIIllIIIllIlI.getEntityId();
        this.posX = lllllllllllllIIIlIIlIIllIIIllIlI.posX;
        this.posY = lllllllllllllIIIlIIlIIllIIIllIlI.posY;
        this.posZ = lllllllllllllIIIlIIlIIllIIIllIlI.posZ;
        this.xpValue = lllllllllllllIIIlIIlIIllIIIllIlI.getXpValue();
    }
    
    public double getY() {
        return this.posY;
    }
    
    public double getX() {
        return this.posX;
    }
    
    @Override
    public void writePacketData(final PacketBuffer lllllllllllllIIIlIIlIIllIIIIlllI) throws IOException {
        lllllllllllllIIIlIIlIIllIIIIlllI.writeVarIntToBuffer(this.entityID);
        lllllllllllllIIIlIIlIIllIIIIlllI.writeDouble(this.posX);
        lllllllllllllIIIlIIlIIllIIIIlllI.writeDouble(this.posY);
        lllllllllllllIIIlIIlIIllIIIIlllI.writeDouble(this.posZ);
        lllllllllllllIIIlIIlIIllIIIIlllI.writeShort(this.xpValue);
    }
    
    public double getZ() {
        return this.posZ;
    }
    
    @Override
    public void readPacketData(final PacketBuffer lllllllllllllIIIlIIlIIllIIIlIIlI) throws IOException {
        this.entityID = lllllllllllllIIIlIIlIIllIIIlIIlI.readVarIntFromBuffer();
        this.posX = lllllllllllllIIIlIIlIIllIIIlIIlI.readDouble();
        this.posY = lllllllllllllIIIlIIlIIllIIIlIIlI.readDouble();
        this.posZ = lllllllllllllIIIlIIlIIllIIIlIIlI.readDouble();
        this.xpValue = lllllllllllllIIIlIIlIIllIIIlIIlI.readShort();
    }
    
    public SPacketSpawnExperienceOrb() {
    }
    
    @Override
    public void processPacket(final INetHandlerPlayClient lllllllllllllIIIlIIlIIllIIIIIllI) {
        lllllllllllllIIIlIIlIIllIIIIIllI.handleSpawnExperienceOrb(this);
    }
}
