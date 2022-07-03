package net.minecraft.network.play.server;

import net.minecraft.network.play.*;
import java.io.*;
import net.minecraft.network.*;
import net.minecraft.world.*;
import net.minecraft.entity.*;

public class SPacketEntity implements Packet<INetHandlerPlayClient>
{
    protected /* synthetic */ byte pitch;
    protected /* synthetic */ boolean rotating;
    protected /* synthetic */ int posX;
    protected /* synthetic */ int posY;
    protected /* synthetic */ byte yaw;
    protected /* synthetic */ int entityId;
    protected /* synthetic */ int posZ;
    protected /* synthetic */ boolean onGround;
    
    public int getY() {
        return this.posY;
    }
    
    public boolean getOnGround() {
        return this.onGround;
    }
    
    public byte getYaw() {
        return this.yaw;
    }
    
    @Override
    public void writePacketData(final PacketBuffer lllllllllllllIIlllIIllIIlIIIIllI) throws IOException {
        lllllllllllllIIlllIIllIIlIIIIllI.writeVarIntToBuffer(this.entityId);
    }
    
    public int getZ() {
        return this.posZ;
    }
    
    @Override
    public void readPacketData(final PacketBuffer lllllllllllllIIlllIIllIIlIIlIIll) throws IOException {
        this.entityId = lllllllllllllIIlllIIllIIlIIlIIll.readVarIntFromBuffer();
    }
    
    public int getX() {
        return this.posX;
    }
    
    public SPacketEntity(final int lllllllllllllIIlllIIllIIlIIllIll) {
        this.entityId = lllllllllllllIIlllIIllIIlIIllIll;
    }
    
    public byte getPitch() {
        return this.pitch;
    }
    
    @Override
    public void processPacket(final INetHandlerPlayClient lllllllllllllIIlllIIllIIIllllIlI) {
        lllllllllllllIIlllIIllIIIllllIlI.handleEntityMovement(this);
    }
    
    public SPacketEntity() {
    }
    
    @Override
    public String toString() {
        return String.valueOf(new StringBuilder("Entity_").append(super.toString()));
    }
    
    public Entity getEntity(final World lllllllllllllIIlllIIllIIIllIlIII) {
        return lllllllllllllIIlllIIllIIIllIlIII.getEntityByID(this.entityId);
    }
    
    public boolean isRotating() {
        return this.rotating;
    }
    
    public static class S16PacketEntityLook extends SPacketEntity
    {
        @Override
        public void readPacketData(final PacketBuffer lllllllllllllIIIllIllIlIlIlIIlll) throws IOException {
            super.readPacketData(lllllllllllllIIIllIllIlIlIlIIlll);
            this.yaw = lllllllllllllIIIllIllIlIlIlIIlll.readByte();
            this.pitch = lllllllllllllIIIllIllIlIlIlIIlll.readByte();
            this.onGround = lllllllllllllIIIllIllIlIlIlIIlll.readBoolean();
        }
        
        @Override
        public void writePacketData(final PacketBuffer lllllllllllllIIIllIllIlIlIIlllll) throws IOException {
            super.writePacketData(lllllllllllllIIIllIllIlIlIIlllll);
            lllllllllllllIIIllIllIlIlIIlllll.writeByte(this.yaw);
            lllllllllllllIIIllIllIlIlIIlllll.writeByte(this.pitch);
            lllllllllllllIIIllIllIlIlIIlllll.writeBoolean(this.onGround);
        }
        
        public S16PacketEntityLook(final int lllllllllllllIIIllIllIlIlIlIlllI, final byte lllllllllllllIIIllIllIlIlIlIllIl, final byte lllllllllllllIIIllIllIlIlIllIIIl, final boolean lllllllllllllIIIllIllIlIlIlIlIll) {
            super(lllllllllllllIIIllIllIlIlIlIlllI);
            this.yaw = lllllllllllllIIIllIllIlIlIlIllIl;
            this.pitch = lllllllllllllIIIllIllIlIlIllIIIl;
            this.rotating = true;
            this.onGround = lllllllllllllIIIllIllIlIlIlIlIll;
        }
        
        public S16PacketEntityLook() {
            this.rotating = true;
        }
    }
    
    public static class S15PacketEntityRelMove extends SPacketEntity
    {
        public S15PacketEntityRelMove(final int llllllllllllllIlIllIIIlllllIIIlI, final long llllllllllllllIlIllIIIlllllIIlll, final long llllllllllllllIlIllIIIlllllIIllI, final long llllllllllllllIlIllIIIlllllIIlIl, final boolean llllllllllllllIlIllIIIlllllIIlII) {
            super(llllllllllllllIlIllIIIlllllIIIlI);
            this.posX = (int)llllllllllllllIlIllIIIlllllIIlll;
            this.posY = (int)llllllllllllllIlIllIIIlllllIIllI;
            this.posZ = (int)llllllllllllllIlIllIIIlllllIIlIl;
            this.onGround = llllllllllllllIlIllIIIlllllIIlII;
        }
        
        public S15PacketEntityRelMove() {
        }
        
        @Override
        public void readPacketData(final PacketBuffer llllllllllllllIlIllIIIllllIllIII) throws IOException {
            super.readPacketData(llllllllllllllIlIllIIIllllIllIII);
            this.posX = llllllllllllllIlIllIIIllllIllIII.readShort();
            this.posY = llllllllllllllIlIllIIIllllIllIII.readShort();
            this.posZ = llllllllllllllIlIllIIIllllIllIII.readShort();
            this.onGround = llllllllllllllIlIllIIIllllIllIII.readBoolean();
        }
        
        @Override
        public void writePacketData(final PacketBuffer llllllllllllllIlIllIIIllllIlIlII) throws IOException {
            super.writePacketData(llllllllllllllIlIllIIIllllIlIlII);
            llllllllllllllIlIllIIIllllIlIlII.writeShort(this.posX);
            llllllllllllllIlIllIIIllllIlIlII.writeShort(this.posY);
            llllllllllllllIlIllIIIllllIlIlII.writeShort(this.posZ);
            llllllllllllllIlIllIIIllllIlIlII.writeBoolean(this.onGround);
        }
    }
    
    public static class S17PacketEntityLookMove extends SPacketEntity
    {
        public S17PacketEntityLookMove(final int lllllllllllllIIIlIlIllllIIlIIlIl, final long lllllllllllllIIIlIlIllllIIIlllII, final long lllllllllllllIIIlIlIllllIIIllIll, final long lllllllllllllIIIlIlIllllIIlIIIlI, final byte lllllllllllllIIIlIlIllllIIIllIIl, final byte lllllllllllllIIIlIlIllllIIlIIIII, final boolean lllllllllllllIIIlIlIllllIIIlIlll) {
            super(lllllllllllllIIIlIlIllllIIlIIlIl);
            this.posX = (int)lllllllllllllIIIlIlIllllIIIlllII;
            this.posY = (int)lllllllllllllIIIlIlIllllIIIllIll;
            this.posZ = (int)lllllllllllllIIIlIlIllllIIlIIIlI;
            this.yaw = lllllllllllllIIIlIlIllllIIIllIIl;
            this.pitch = lllllllllllllIIIlIlIllllIIlIIIII;
            this.onGround = lllllllllllllIIIlIlIllllIIIlIlll;
            this.rotating = true;
        }
        
        @Override
        public void writePacketData(final PacketBuffer lllllllllllllIIIlIlIllllIIIIllIl) throws IOException {
            super.writePacketData(lllllllllllllIIIlIlIllllIIIIllIl);
            lllllllllllllIIIlIlIllllIIIIllIl.writeShort(this.posX);
            lllllllllllllIIIlIlIllllIIIIllIl.writeShort(this.posY);
            lllllllllllllIIIlIlIllllIIIIllIl.writeShort(this.posZ);
            lllllllllllllIIIlIlIllllIIIIllIl.writeByte(this.yaw);
            lllllllllllllIIIlIlIllllIIIIllIl.writeByte(this.pitch);
            lllllllllllllIIIlIlIllllIIIIllIl.writeBoolean(this.onGround);
        }
        
        @Override
        public void readPacketData(final PacketBuffer lllllllllllllIIIlIlIllllIIIlIIll) throws IOException {
            super.readPacketData(lllllllllllllIIIlIlIllllIIIlIIll);
            this.posX = lllllllllllllIIIlIlIllllIIIlIIll.readShort();
            this.posY = lllllllllllllIIIlIlIllllIIIlIIll.readShort();
            this.posZ = lllllllllllllIIIlIlIllllIIIlIIll.readShort();
            this.yaw = lllllllllllllIIIlIlIllllIIIlIIll.readByte();
            this.pitch = lllllllllllllIIIlIlIllllIIIlIIll.readByte();
            this.onGround = lllllllllllllIIIlIlIllllIIIlIIll.readBoolean();
        }
        
        public S17PacketEntityLookMove() {
            this.rotating = true;
        }
    }
}
