package net.minecraft.network.play.server;

import net.minecraft.network.play.*;
import java.util.*;
import net.minecraft.entity.*;
import net.minecraft.util.math.*;
import net.minecraft.network.*;
import java.io.*;

public class SPacketSpawnObject implements Packet<INetHandlerPlayClient>
{
    private /* synthetic */ double y;
    private /* synthetic */ int pitch;
    private /* synthetic */ double x;
    private /* synthetic */ double z;
    private /* synthetic */ int speedZ;
    private /* synthetic */ int data;
    private /* synthetic */ int type;
    private /* synthetic */ int yaw;
    private /* synthetic */ int entityId;
    private /* synthetic */ int speedX;
    private /* synthetic */ int speedY;
    private /* synthetic */ UUID uniqueId;
    
    public int getYaw() {
        return this.yaw;
    }
    
    public int getSpeedY() {
        return this.speedY;
    }
    
    public double getZ() {
        return this.z;
    }
    
    public void setData(final int llllllllllllllIlllIIllIIlllIlIII) {
        this.data = llllllllllllllIlllIIllIIlllIlIII;
    }
    
    public void setSpeedX(final int llllllllllllllIlllIIllIIlllllIlI) {
        this.speedX = llllllllllllllIlllIIllIIlllllIlI;
    }
    
    public SPacketSpawnObject() {
    }
    
    public double getX() {
        return this.x;
    }
    
    public SPacketSpawnObject(final Entity llllllllllllllIlllIIllIlIlIllIll, final int llllllllllllllIlllIIllIlIlIllIlI) {
        this(llllllllllllllIlllIIllIlIlIllIll, llllllllllllllIlllIIllIlIlIllIlI, 0);
    }
    
    public SPacketSpawnObject(final Entity llllllllllllllIlllIIllIlIlIIlllI, final int llllllllllllllIlllIIllIlIlIlIIlI, final int llllllllllllllIlllIIllIlIlIlIIIl) {
        this.entityId = llllllllllllllIlllIIllIlIlIIlllI.getEntityId();
        this.uniqueId = llllllllllllllIlllIIllIlIlIIlllI.getUniqueID();
        this.x = llllllllllllllIlllIIllIlIlIIlllI.posX;
        this.y = llllllllllllllIlllIIllIlIlIIlllI.posY;
        this.z = llllllllllllllIlllIIllIlIlIIlllI.posZ;
        this.pitch = MathHelper.floor(llllllllllllllIlllIIllIlIlIIlllI.rotationPitch * 256.0f / 360.0f);
        this.yaw = MathHelper.floor(llllllllllllllIlllIIllIlIlIIlllI.rotationYaw * 256.0f / 360.0f);
        this.type = llllllllllllllIlllIIllIlIlIlIIlI;
        this.data = llllllllllllllIlllIIllIlIlIlIIIl;
        final double llllllllllllllIlllIIllIlIlIlIIII = 3.9;
        this.speedX = (int)(MathHelper.clamp(llllllllllllllIlllIIllIlIlIIlllI.motionX, -3.9, 3.9) * 8000.0);
        this.speedY = (int)(MathHelper.clamp(llllllllllllllIlllIIllIlIlIIlllI.motionY, -3.9, 3.9) * 8000.0);
        this.speedZ = (int)(MathHelper.clamp(llllllllllllllIlllIIllIlIlIIlllI.motionZ, -3.9, 3.9) * 8000.0);
    }
    
    public SPacketSpawnObject(final Entity llllllllllllllIlllIIllIlIIllIlll, final int llllllllllllllIlllIIllIlIIllIllI, final int llllllllllllllIlllIIllIlIIlllIll, final BlockPos llllllllllllllIlllIIllIlIIlllIIl) {
        this(llllllllllllllIlllIIllIlIIllIlll, llllllllllllllIlllIIllIlIIllIllI, llllllllllllllIlllIIllIlIIlllIll);
        this.x = llllllllllllllIlllIIllIlIIlllIIl.getX();
        this.y = llllllllllllllIlllIIllIlIIlllIIl.getY();
        this.z = llllllllllllllIlllIIllIlIIlllIIl.getZ();
    }
    
    public int getEntityID() {
        return this.entityId;
    }
    
    public void setSpeedZ(final int llllllllllllllIlllIIllIIlllIlllI) {
        this.speedZ = llllllllllllllIlllIIllIIlllIlllI;
    }
    
    public void setSpeedY(final int llllllllllllllIlllIIllIIllllIlII) {
        this.speedY = llllllllllllllIlllIIllIIllllIlII;
    }
    
    public int getPitch() {
        return this.pitch;
    }
    
    public int getSpeedZ() {
        return this.speedZ;
    }
    
    @Override
    public void writePacketData(final PacketBuffer llllllllllllllIlllIIllIlIIlIlIlI) throws IOException {
        llllllllllllllIlllIIllIlIIlIlIlI.writeVarIntToBuffer(this.entityId);
        llllllllllllllIlllIIllIlIIlIlIlI.writeUuid(this.uniqueId);
        llllllllllllllIlllIIllIlIIlIlIlI.writeByte(this.type);
        llllllllllllllIlllIIllIlIIlIlIlI.writeDouble(this.x);
        llllllllllllllIlllIIllIlIIlIlIlI.writeDouble(this.y);
        llllllllllllllIlllIIllIlIIlIlIlI.writeDouble(this.z);
        llllllllllllllIlllIIllIlIIlIlIlI.writeByte(this.pitch);
        llllllllllllllIlllIIllIlIIlIlIlI.writeByte(this.yaw);
        llllllllllllllIlllIIllIlIIlIlIlI.writeInt(this.data);
        llllllllllllllIlllIIllIlIIlIlIlI.writeShort(this.speedX);
        llllllllllllllIlllIIllIlIIlIlIlI.writeShort(this.speedY);
        llllllllllllllIlllIIllIlIIlIlIlI.writeShort(this.speedZ);
    }
    
    public int getSpeedX() {
        return this.speedX;
    }
    
    public double getY() {
        return this.y;
    }
    
    public int getType() {
        return this.type;
    }
    
    public int getData() {
        return this.data;
    }
    
    @Override
    public void processPacket(final INetHandlerPlayClient llllllllllllllIlllIIllIlIIlIIlII) {
        llllllllllllllIlllIIllIlIIlIIlII.handleSpawnObject(this);
    }
    
    public UUID getUniqueId() {
        return this.uniqueId;
    }
    
    @Override
    public void readPacketData(final PacketBuffer llllllllllllllIlllIIllIlIIllIIII) throws IOException {
        this.entityId = llllllllllllllIlllIIllIlIIllIIII.readVarIntFromBuffer();
        this.uniqueId = llllllllllllllIlllIIllIlIIllIIII.readUuid();
        this.type = llllllllllllllIlllIIllIlIIllIIII.readByte();
        this.x = llllllllllllllIlllIIllIlIIllIIII.readDouble();
        this.y = llllllllllllllIlllIIllIlIIllIIII.readDouble();
        this.z = llllllllllllllIlllIIllIlIIllIIII.readDouble();
        this.pitch = llllllllllllllIlllIIllIlIIllIIII.readByte();
        this.yaw = llllllllllllllIlllIIllIlIIllIIII.readByte();
        this.data = llllllllllllllIlllIIllIlIIllIIII.readInt();
        this.speedX = llllllllllllllIlllIIllIlIIllIIII.readShort();
        this.speedY = llllllllllllllIlllIIllIlIIllIIII.readShort();
        this.speedZ = llllllllllllllIlllIIllIlIIllIIII.readShort();
    }
}
