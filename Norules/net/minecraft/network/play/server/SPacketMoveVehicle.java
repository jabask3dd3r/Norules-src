package net.minecraft.network.play.server;

import net.minecraft.network.play.*;
import net.minecraft.network.*;
import java.io.*;
import net.minecraft.entity.*;

public class SPacketMoveVehicle implements Packet<INetHandlerPlayClient>
{
    private /* synthetic */ double z;
    private /* synthetic */ double x;
    private /* synthetic */ float yaw;
    private /* synthetic */ double y;
    private /* synthetic */ float pitch;
    
    public SPacketMoveVehicle() {
    }
    
    public float getYaw() {
        return this.yaw;
    }
    
    @Override
    public void writePacketData(final PacketBuffer lllllllllllllIlIIIIlIlIIllIIIlIl) throws IOException {
        lllllllllllllIlIIIIlIlIIllIIIlIl.writeDouble(this.x);
        lllllllllllllIlIIIIlIlIIllIIIlIl.writeDouble(this.y);
        lllllllllllllIlIIIIlIlIIllIIIlIl.writeDouble(this.z);
        lllllllllllllIlIIIIlIlIIllIIIlIl.writeFloat(this.yaw);
        lllllllllllllIlIIIIlIlIIllIIIlIl.writeFloat(this.pitch);
    }
    
    @Override
    public void processPacket(final INetHandlerPlayClient lllllllllllllIlIIIIlIlIIllIIIIIl) {
        lllllllllllllIlIIIIlIlIIllIIIIIl.handleMoveVehicle(this);
    }
    
    public double getY() {
        return this.y;
    }
    
    public double getX() {
        return this.x;
    }
    
    @Override
    public void readPacketData(final PacketBuffer lllllllllllllIlIIIIlIlIIllIIlIll) throws IOException {
        this.x = lllllllllllllIlIIIIlIlIIllIIlIll.readDouble();
        this.y = lllllllllllllIlIIIIlIlIIllIIlIll.readDouble();
        this.z = lllllllllllllIlIIIIlIlIIllIIlIll.readDouble();
        this.yaw = lllllllllllllIlIIIIlIlIIllIIlIll.readFloat();
        this.pitch = lllllllllllllIlIIIIlIlIIllIIlIll.readFloat();
    }
    
    public float getPitch() {
        return this.pitch;
    }
    
    public SPacketMoveVehicle(final Entity lllllllllllllIlIIIIlIlIIllIlIIIl) {
        this.x = lllllllllllllIlIIIIlIlIIllIlIIIl.posX;
        this.y = lllllllllllllIlIIIIlIlIIllIlIIIl.posY;
        this.z = lllllllllllllIlIIIIlIlIIllIlIIIl.posZ;
        this.yaw = lllllllllllllIlIIIIlIlIIllIlIIIl.rotationYaw;
        this.pitch = lllllllllllllIlIIIIlIlIIllIlIIIl.rotationPitch;
    }
    
    public double getZ() {
        return this.z;
    }
}
