package net.minecraft.network.play.server;

import net.minecraft.network.play.*;
import net.minecraft.network.datasync.*;
import java.util.*;
import net.minecraft.network.*;
import java.io.*;
import javax.annotation.*;
import net.minecraft.entity.player.*;

public class SPacketSpawnPlayer implements Packet<INetHandlerPlayClient>
{
    private /* synthetic */ UUID uniqueId;
    private /* synthetic */ byte yaw;
    private /* synthetic */ EntityDataManager watcher;
    private /* synthetic */ double z;
    private /* synthetic */ double y;
    private /* synthetic */ double x;
    private /* synthetic */ int entityId;
    private /* synthetic */ byte pitch;
    private /* synthetic */ List<EntityDataManager.DataEntry<?>> dataManagerEntries;
    
    @Override
    public void processPacket(final INetHandlerPlayClient lllllllllllllIllllllIIIIIIlllIlI) {
        lllllllllllllIllllllIIIIIIlllIlI.handleSpawnPlayer(this);
    }
    
    @Override
    public void writePacketData(final PacketBuffer lllllllllllllIllllllIIIIIlIIIIlI) throws IOException {
        lllllllllllllIllllllIIIIIlIIIIlI.writeVarIntToBuffer(this.entityId);
        lllllllllllllIllllllIIIIIlIIIIlI.writeUuid(this.uniqueId);
        lllllllllllllIllllllIIIIIlIIIIlI.writeDouble(this.x);
        lllllllllllllIllllllIIIIIlIIIIlI.writeDouble(this.y);
        lllllllllllllIllllllIIIIIlIIIIlI.writeDouble(this.z);
        lllllllllllllIllllllIIIIIlIIIIlI.writeByte(this.yaw);
        lllllllllllllIllllllIIIIIlIIIIlI.writeByte(this.pitch);
        this.watcher.writeEntries(lllllllllllllIllllllIIIIIlIIIIlI);
    }
    
    @Nullable
    public List<EntityDataManager.DataEntry<?>> getDataManagerEntries() {
        return this.dataManagerEntries;
    }
    
    public double getZ() {
        return this.z;
    }
    
    public SPacketSpawnPlayer(final EntityPlayer lllllllllllllIllllllIIIIIlIIlllI) {
        this.entityId = lllllllllllllIllllllIIIIIlIIlllI.getEntityId();
        this.uniqueId = lllllllllllllIllllllIIIIIlIIlllI.getGameProfile().getId();
        this.x = lllllllllllllIllllllIIIIIlIIlllI.posX;
        this.y = lllllllllllllIllllllIIIIIlIIlllI.posY;
        this.z = lllllllllllllIllllllIIIIIlIIlllI.posZ;
        this.yaw = (byte)(lllllllllllllIllllllIIIIIlIIlllI.rotationYaw * 256.0f / 360.0f);
        this.pitch = (byte)(lllllllllllllIllllllIIIIIlIIlllI.rotationPitch * 256.0f / 360.0f);
        this.watcher = lllllllllllllIllllllIIIIIlIIlllI.getDataManager();
    }
    
    public int getEntityID() {
        return this.entityId;
    }
    
    public SPacketSpawnPlayer() {
    }
    
    public double getY() {
        return this.y;
    }
    
    public byte getPitch() {
        return this.pitch;
    }
    
    @Override
    public void readPacketData(final PacketBuffer lllllllllllllIllllllIIIIIlIIlIII) throws IOException {
        this.entityId = lllllllllllllIllllllIIIIIlIIlIII.readVarIntFromBuffer();
        this.uniqueId = lllllllllllllIllllllIIIIIlIIlIII.readUuid();
        this.x = lllllllllllllIllllllIIIIIlIIlIII.readDouble();
        this.y = lllllllllllllIllllllIIIIIlIIlIII.readDouble();
        this.z = lllllllllllllIllllllIIIIIlIIlIII.readDouble();
        this.yaw = lllllllllllllIllllllIIIIIlIIlIII.readByte();
        this.pitch = lllllllllllllIllllllIIIIIlIIlIII.readByte();
        this.dataManagerEntries = EntityDataManager.readEntries(lllllllllllllIllllllIIIIIlIIlIII);
    }
    
    public UUID getUniqueId() {
        return this.uniqueId;
    }
    
    public byte getYaw() {
        return this.yaw;
    }
    
    public double getX() {
        return this.x;
    }
}
