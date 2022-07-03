package net.minecraft.network.play.server;

import net.minecraft.network.play.*;
import net.minecraft.network.datasync.*;
import java.util.*;
import javax.annotation.*;
import java.io.*;
import net.minecraft.network.*;
import net.minecraft.entity.*;

public class SPacketSpawnMob implements Packet<INetHandlerPlayClient>
{
    private /* synthetic */ int velocityZ;
    private /* synthetic */ double z;
    private /* synthetic */ int type;
    private /* synthetic */ double x;
    private /* synthetic */ byte yaw;
    private /* synthetic */ byte pitch;
    private /* synthetic */ int velocityY;
    private /* synthetic */ double y;
    private /* synthetic */ EntityDataManager dataManager;
    private /* synthetic */ byte headPitch;
    private /* synthetic */ int velocityX;
    private /* synthetic */ int entityId;
    private /* synthetic */ List<EntityDataManager.DataEntry<?>> dataManagerEntries;
    private /* synthetic */ UUID uniqueId;
    
    public int getEntityType() {
        return this.type;
    }
    
    @Nullable
    public List<EntityDataManager.DataEntry<?>> getDataManagerEntries() {
        return this.dataManagerEntries;
    }
    
    public SPacketSpawnMob(final EntityLivingBase lllllllllllllIIIllIIlllllIIlIIlI) {
        this.entityId = lllllllllllllIIIllIIlllllIIlIIlI.getEntityId();
        this.uniqueId = lllllllllllllIIIllIIlllllIIlIIlI.getUniqueID();
        this.type = EntityList.field_191308_b.getIDForObject(lllllllllllllIIIllIIlllllIIlIIlI.getClass());
        this.x = lllllllllllllIIIllIIlllllIIlIIlI.posX;
        this.y = lllllllllllllIIIllIIlllllIIlIIlI.posY;
        this.z = lllllllllllllIIIllIIlllllIIlIIlI.posZ;
        this.yaw = (byte)(lllllllllllllIIIllIIlllllIIlIIlI.rotationYaw * 256.0f / 360.0f);
        this.pitch = (byte)(lllllllllllllIIIllIIlllllIIlIIlI.rotationPitch * 256.0f / 360.0f);
        this.headPitch = (byte)(lllllllllllllIIIllIIlllllIIlIIlI.rotationYawHead * 256.0f / 360.0f);
        final double lllllllllllllIIIllIIlllllIIlIIIl = 3.9;
        double lllllllllllllIIIllIIlllllIIlIIII = lllllllllllllIIIllIIlllllIIlIIlI.motionX;
        double lllllllllllllIIIllIIlllllIIIllll = lllllllllllllIIIllIIlllllIIlIIlI.motionY;
        double lllllllllllllIIIllIIlllllIIIlllI = lllllllllllllIIIllIIlllllIIlIIlI.motionZ;
        if (lllllllllllllIIIllIIlllllIIlIIII < -3.9) {
            lllllllllllllIIIllIIlllllIIlIIII = -3.9;
        }
        if (lllllllllllllIIIllIIlllllIIIllll < -3.9) {
            lllllllllllllIIIllIIlllllIIIllll = -3.9;
        }
        if (lllllllllllllIIIllIIlllllIIIlllI < -3.9) {
            lllllllllllllIIIllIIlllllIIIlllI = -3.9;
        }
        if (lllllllllllllIIIllIIlllllIIlIIII > 3.9) {
            lllllllllllllIIIllIIlllllIIlIIII = 3.9;
        }
        if (lllllllllllllIIIllIIlllllIIIllll > 3.9) {
            lllllllllllllIIIllIIlllllIIIllll = 3.9;
        }
        if (lllllllllllllIIIllIIlllllIIIlllI > 3.9) {
            lllllllllllllIIIllIIlllllIIIlllI = 3.9;
        }
        this.velocityX = (int)(lllllllllllllIIIllIIlllllIIlIIII * 8000.0);
        this.velocityY = (int)(lllllllllllllIIIllIIlllllIIIllll * 8000.0);
        this.velocityZ = (int)(lllllllllllllIIIllIIlllllIIIlllI * 8000.0);
        this.dataManager = lllllllllllllIIIllIIlllllIIlIIlI.getDataManager();
    }
    
    public int getVelocityY() {
        return this.velocityY;
    }
    
    public byte getPitch() {
        return this.pitch;
    }
    
    public double getZ() {
        return this.z;
    }
    
    public int getEntityID() {
        return this.entityId;
    }
    
    public double getY() {
        return this.y;
    }
    
    public SPacketSpawnMob() {
    }
    
    @Override
    public void processPacket(final INetHandlerPlayClient lllllllllllllIIIllIIllllIllllIII) {
        lllllllllllllIIIllIIllllIllllIII.handleSpawnMob(this);
    }
    
    public byte getYaw() {
        return this.yaw;
    }
    
    public int getVelocityX() {
        return this.velocityX;
    }
    
    public int getVelocityZ() {
        return this.velocityZ;
    }
    
    @Override
    public void readPacketData(final PacketBuffer lllllllllllllIIIllIIlllllIIIIIlI) throws IOException {
        this.entityId = lllllllllllllIIIllIIlllllIIIIIlI.readVarIntFromBuffer();
        this.uniqueId = lllllllllllllIIIllIIlllllIIIIIlI.readUuid();
        this.type = lllllllllllllIIIllIIlllllIIIIIlI.readVarIntFromBuffer();
        this.x = lllllllllllllIIIllIIlllllIIIIIlI.readDouble();
        this.y = lllllllllllllIIIllIIlllllIIIIIlI.readDouble();
        this.z = lllllllllllllIIIllIIlllllIIIIIlI.readDouble();
        this.yaw = lllllllllllllIIIllIIlllllIIIIIlI.readByte();
        this.pitch = lllllllllllllIIIllIIlllllIIIIIlI.readByte();
        this.headPitch = lllllllllllllIIIllIIlllllIIIIIlI.readByte();
        this.velocityX = lllllllllllllIIIllIIlllllIIIIIlI.readShort();
        this.velocityY = lllllllllllllIIIllIIlllllIIIIIlI.readShort();
        this.velocityZ = lllllllllllllIIIllIIlllllIIIIIlI.readShort();
        this.dataManagerEntries = EntityDataManager.readEntries(lllllllllllllIIIllIIlllllIIIIIlI);
    }
    
    public double getX() {
        return this.x;
    }
    
    @Override
    public void writePacketData(final PacketBuffer lllllllllllllIIIllIIllllIllllllI) throws IOException {
        lllllllllllllIIIllIIllllIllllllI.writeVarIntToBuffer(this.entityId);
        lllllllllllllIIIllIIllllIllllllI.writeUuid(this.uniqueId);
        lllllllllllllIIIllIIllllIllllllI.writeVarIntToBuffer(this.type);
        lllllllllllllIIIllIIllllIllllllI.writeDouble(this.x);
        lllllllllllllIIIllIIllllIllllllI.writeDouble(this.y);
        lllllllllllllIIIllIIllllIllllllI.writeDouble(this.z);
        lllllllllllllIIIllIIllllIllllllI.writeByte(this.yaw);
        lllllllllllllIIIllIIllllIllllllI.writeByte(this.pitch);
        lllllllllllllIIIllIIllllIllllllI.writeByte(this.headPitch);
        lllllllllllllIIIllIIllllIllllllI.writeShort(this.velocityX);
        lllllllllllllIIIllIIllllIllllllI.writeShort(this.velocityY);
        lllllllllllllIIIllIIllllIllllllI.writeShort(this.velocityZ);
        this.dataManager.writeEntries(lllllllllllllIIIllIIllllIllllllI);
    }
    
    public byte getHeadPitch() {
        return this.headPitch;
    }
    
    public UUID getUniqueId() {
        return this.uniqueId;
    }
}
