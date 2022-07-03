package net.minecraft.network.play.client;

import net.minecraft.network.play.*;
import net.minecraft.network.*;
import java.io.*;

public class CPacketPlayer implements Packet<INetHandlerPlayServer>
{
    public /* synthetic */ boolean onGround;
    public /* synthetic */ double z;
    public /* synthetic */ float yaw;
    public /* synthetic */ boolean moving;
    public /* synthetic */ double x;
    public /* synthetic */ boolean rotating;
    public /* synthetic */ double y;
    public /* synthetic */ float pitch;
    
    public CPacketPlayer(final boolean lllllllllllllllIIIIIIlIIIIIIllIl) {
        this.onGround = lllllllllllllllIIIIIIlIIIIIIllIl;
    }
    
    public CPacketPlayer() {
    }
    
    public float getPitch(final float lllllllllllllllIIIIIIIllllIlIlll) {
        return this.rotating ? this.pitch : lllllllllllllllIIIIIIIllllIlIlll;
    }
    
    public double getZ(final double lllllllllllllllIIIIIIIlllllIIlll) {
        return this.moving ? this.z : lllllllllllllllIIIIIIIlllllIIlll;
    }
    
    public double getX(final double lllllllllllllllIIIIIIIllllllIlIl) {
        return this.moving ? this.x : lllllllllllllllIIIIIIIllllllIlIl;
    }
    
    public boolean setOnGround(final boolean lllllllllllllllIIIIIIIlllllIIIll) {
        this.onGround = lllllllllllllllIIIIIIIlllllIIIll;
        return lllllllllllllllIIIIIIIlllllIIIll;
    }
    
    @Override
    public void processPacket(final INetHandlerPlayServer lllllllllllllllIIIIIIlIIIIIIIlIl) {
        lllllllllllllllIIIIIIlIIIIIIIlIl.processPlayer(this);
    }
    
    public double getY(final double lllllllllllllllIIIIIIIlllllIllll) {
        return this.moving ? this.y : lllllllllllllllIIIIIIIlllllIllll;
    }
    
    @Override
    public void readPacketData(final PacketBuffer lllllllllllllllIIIIIIIllllllllll) throws IOException {
        this.onGround = (lllllllllllllllIIIIIIIllllllllll.readUnsignedByte() != 0);
    }
    
    public boolean isOnGround() {
        return this.onGround;
    }
    
    public float getYaw(final float lllllllllllllllIIIIIIIllllIlllIl) {
        return this.rotating ? this.yaw : lllllllllllllllIIIIIIIllllIlllIl;
    }
    
    @Override
    public void writePacketData(final PacketBuffer lllllllllllllllIIIIIIIlllllllIIl) throws IOException {
        lllllllllllllllIIIIIIIlllllllIIl.writeByte(this.onGround ? 1 : 0);
    }
    
    public static class PositionRotation extends CPacketPlayer
    {
        @Override
        public void writePacketData(final PacketBuffer lIlllIllllllll) throws IOException {
            lIlllIllllllll.writeDouble(this.x);
            lIlllIllllllll.writeDouble(this.y);
            lIlllIllllllll.writeDouble(this.z);
            lIlllIllllllll.writeFloat(this.yaw);
            lIlllIllllllll.writeFloat(this.pitch);
            super.writePacketData(lIlllIllllllll);
        }
        
        @Override
        public void readPacketData(final PacketBuffer lIllllIIIIIlIl) throws IOException {
            this.x = lIllllIIIIIlIl.readDouble();
            this.y = lIllllIIIIIlIl.readDouble();
            this.z = lIllllIIIIIlIl.readDouble();
            this.yaw = lIllllIIIIIlIl.readFloat();
            this.pitch = lIllllIIIIIlIl.readFloat();
            super.readPacketData(lIllllIIIIIlIl);
        }
        
        public PositionRotation(final double lIllllIIIlIIII, final double lIllllIIIIllll, final double lIllllIIIlIlIl, final float lIllllIIIIllIl, final float lIllllIIIIllII, final boolean lIllllIIIIlIll) {
            this.x = lIllllIIIlIIII;
            this.y = lIllllIIIIllll;
            this.z = lIllllIIIlIlIl;
            this.yaw = lIllllIIIIllIl;
            this.pitch = lIllllIIIIllII;
            this.onGround = lIllllIIIIlIll;
            this.rotating = true;
            this.moving = true;
        }
        
        public PositionRotation() {
            this.moving = true;
            this.rotating = true;
        }
    }
    
    public static class Position extends CPacketPlayer
    {
        @Override
        public void writePacketData(final PacketBuffer llllllllllllllllIlIlllIIlIIIIllI) throws IOException {
            llllllllllllllllIlIlllIIlIIIIllI.writeDouble(this.x);
            llllllllllllllllIlIlllIIlIIIIllI.writeDouble(this.y);
            llllllllllllllllIlIlllIIlIIIIllI.writeDouble(this.z);
            super.writePacketData(llllllllllllllllIlIlllIIlIIIIllI);
        }
        
        public Position() {
            this.moving = true;
        }
        
        public Position(final double llllllllllllllllIlIlllIIlIIllIII, final double llllllllllllllllIlIlllIIlIIlIIlI, final double llllllllllllllllIlIlllIIlIIlIIIl, final boolean llllllllllllllllIlIlllIIlIIlIlIl) {
            this.x = llllllllllllllllIlIlllIIlIIllIII;
            this.y = llllllllllllllllIlIlllIIlIIlIIlI;
            this.z = llllllllllllllllIlIlllIIlIIlIIIl;
            this.onGround = llllllllllllllllIlIlllIIlIIlIlIl;
            this.moving = true;
        }
        
        @Override
        public void readPacketData(final PacketBuffer llllllllllllllllIlIlllIIlIIIllII) throws IOException {
            this.x = llllllllllllllllIlIlllIIlIIIllII.readDouble();
            this.y = llllllllllllllllIlIlllIIlIIIllII.readDouble();
            this.z = llllllllllllllllIlIlllIIlIIIllII.readDouble();
            super.readPacketData(llllllllllllllllIlIlllIIlIIIllII);
        }
    }
    
    public static class Rotation extends CPacketPlayer
    {
        @Override
        public void writePacketData(final PacketBuffer llllllllllllllIIIIlIIlllllIllIll) throws IOException {
            llllllllllllllIIIIlIIlllllIllIll.writeFloat(this.yaw);
            llllllllllllllIIIIlIIlllllIllIll.writeFloat(this.pitch);
            super.writePacketData(llllllllllllllIIIIlIIlllllIllIll);
        }
        
        @Override
        public void readPacketData(final PacketBuffer llllllllllllllIIIIlIIllllllIIIIl) throws IOException {
            this.yaw = llllllllllllllIIIIlIIllllllIIIIl.readFloat();
            this.pitch = llllllllllllllIIIIlIIllllllIIIIl.readFloat();
            super.readPacketData(llllllllllllllIIIIlIIllllllIIIIl);
        }
        
        public Rotation() {
            this.rotating = true;
        }
        
        public Rotation(final float llllllllllllllIIIIlIIllllllIlIll, final float llllllllllllllIIIIlIIllllllIIllI, final boolean llllllllllllllIIIIlIIllllllIIlIl) {
            this.yaw = llllllllllllllIIIIlIIllllllIlIll;
            this.pitch = llllllllllllllIIIIlIIllllllIIllI;
            this.onGround = llllllllllllllIIIIlIIllllllIIlIl;
            this.rotating = true;
        }
    }
}
