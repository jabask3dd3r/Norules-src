package net.minecraft.network.play.server;

import net.minecraft.network.play.*;
import java.io.*;
import net.minecraft.entity.*;
import net.minecraft.network.*;

public class SPacketEntityTeleport implements Packet<INetHandlerPlayClient>
{
    private /* synthetic */ byte yaw;
    public /* synthetic */ double posX;
    public /* synthetic */ boolean onGround;
    private /* synthetic */ byte pitch;
    public /* synthetic */ double posZ;
    private /* synthetic */ int entityId;
    public /* synthetic */ double posY;
    
    @Override
    public void readPacketData(final PacketBuffer lllllllllllllllIIlIIIlllIlIlIlII) throws IOException {
        this.entityId = lllllllllllllllIIlIIIlllIlIlIlII.readVarIntFromBuffer();
        this.posX = lllllllllllllllIIlIIIlllIlIlIlII.readDouble();
        this.posY = lllllllllllllllIIlIIIlllIlIlIlII.readDouble();
        this.posZ = lllllllllllllllIIlIIIlllIlIlIlII.readDouble();
        this.yaw = lllllllllllllllIIlIIIlllIlIlIlII.readByte();
        this.pitch = lllllllllllllllIIlIIIlllIlIlIlII.readByte();
        this.onGround = lllllllllllllllIIlIIIlllIlIlIlII.readBoolean();
    }
    
    public int getEntityId() {
        return this.entityId;
    }
    
    public double getX() {
        return this.posX;
    }
    
    public double getY() {
        return this.posY;
    }
    
    public byte getPitch() {
        return this.pitch;
    }
    
    public SPacketEntityTeleport(final Entity lllllllllllllllIIlIIIlllIlIllIII) {
        this.entityId = lllllllllllllllIIlIIIlllIlIllIII.getEntityId();
        this.posX = lllllllllllllllIIlIIIlllIlIllIII.posX;
        this.posY = lllllllllllllllIIlIIIlllIlIllIII.posY;
        this.posZ = lllllllllllllllIIlIIIlllIlIllIII.posZ;
        this.yaw = (byte)(lllllllllllllllIIlIIIlllIlIllIII.rotationYaw * 256.0f / 360.0f);
        this.pitch = (byte)(lllllllllllllllIIlIIIlllIlIllIII.rotationPitch * 256.0f / 360.0f);
        this.onGround = lllllllllllllllIIlIIIlllIlIllIII.onGround;
    }
    
    public byte getYaw() {
        return this.yaw;
    }
    
    @Override
    public void processPacket(final INetHandlerPlayClient lllllllllllllllIIlIIIlllIlIIlIII) {
        lllllllllllllllIIlIIIlllIlIIlIII.handleEntityTeleport(this);
    }
    
    public double getZ() {
        return this.posZ;
    }
    
    @Override
    public void writePacketData(final PacketBuffer lllllllllllllllIIlIIIlllIlIIlllI) throws IOException {
        lllllllllllllllIIlIIIlllIlIIlllI.writeVarIntToBuffer(this.entityId);
        lllllllllllllllIIlIIIlllIlIIlllI.writeDouble(this.posX);
        lllllllllllllllIIlIIIlllIlIIlllI.writeDouble(this.posY);
        lllllllllllllllIIlIIIlllIlIIlllI.writeDouble(this.posZ);
        lllllllllllllllIIlIIIlllIlIIlllI.writeByte(this.yaw);
        lllllllllllllllIIlIIIlllIlIIlllI.writeByte(this.pitch);
        lllllllllllllllIIlIIIlllIlIIlllI.writeBoolean(this.onGround);
    }
    
    public SPacketEntityTeleport() {
    }
    
    public boolean getOnGround() {
        return this.onGround;
    }
}
