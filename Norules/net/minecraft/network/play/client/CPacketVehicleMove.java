package net.minecraft.network.play.client;

import net.minecraft.network.play.*;
import net.minecraft.entity.*;
import java.io.*;
import net.minecraft.network.*;

public class CPacketVehicleMove implements Packet<INetHandlerPlayServer>
{
    private /* synthetic */ float pitch;
    private /* synthetic */ double y;
    private /* synthetic */ double z;
    private /* synthetic */ double x;
    private /* synthetic */ float yaw;
    
    public double getZ() {
        return this.z;
    }
    
    public CPacketVehicleMove(final Entity lllllllllllllIIIlIlllIlllllIIIIl) {
        this.x = lllllllllllllIIIlIlllIlllllIIIIl.posX;
        this.y = lllllllllllllIIIlIlllIlllllIIIIl.posY;
        this.z = lllllllllllllIIIlIlllIlllllIIIIl.posZ;
        this.yaw = lllllllllllllIIIlIlllIlllllIIIIl.rotationYaw;
        this.pitch = lllllllllllllIIIlIlllIlllllIIIIl.rotationPitch;
    }
    
    public CPacketVehicleMove() {
    }
    
    public double getX() {
        return this.x;
    }
    
    @Override
    public void processPacket(final INetHandlerPlayServer lllllllllllllIIIlIlllIllllIlIIIl) {
        lllllllllllllIIIlIlllIllllIlIIIl.processVehicleMove(this);
    }
    
    public float getYaw() {
        return this.yaw;
    }
    
    public double getY() {
        return this.y;
    }
    
    @Override
    public void writePacketData(final PacketBuffer lllllllllllllIIIlIlllIllllIlIlIl) throws IOException {
        lllllllllllllIIIlIlllIllllIlIlIl.writeDouble(this.x);
        lllllllllllllIIIlIlllIllllIlIlIl.writeDouble(this.y);
        lllllllllllllIIIlIlllIllllIlIlIl.writeDouble(this.z);
        lllllllllllllIIIlIlllIllllIlIlIl.writeFloat(this.yaw);
        lllllllllllllIIIlIlllIllllIlIlIl.writeFloat(this.pitch);
    }
    
    @Override
    public void readPacketData(final PacketBuffer lllllllllllllIIIlIlllIllllIllIll) throws IOException {
        this.x = lllllllllllllIIIlIlllIllllIllIll.readDouble();
        this.y = lllllllllllllIIIlIlllIllllIllIll.readDouble();
        this.z = lllllllllllllIIIlIlllIllllIllIll.readDouble();
        this.yaw = lllllllllllllIIIlIlllIllllIllIll.readFloat();
        this.pitch = lllllllllllllIIIlIlllIllllIllIll.readFloat();
    }
    
    public float getPitch() {
        return this.pitch;
    }
}
