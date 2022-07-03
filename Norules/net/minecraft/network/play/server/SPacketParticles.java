package net.minecraft.network.play.server;

import net.minecraft.network.play.*;
import net.minecraft.util.*;
import java.io.*;
import net.minecraft.network.*;

public class SPacketParticles implements Packet<INetHandlerPlayClient>
{
    private /* synthetic */ int[] particleArguments;
    private /* synthetic */ float xCoord;
    private /* synthetic */ float zOffset;
    private /* synthetic */ float yCoord;
    private /* synthetic */ float particleSpeed;
    private /* synthetic */ float zCoord;
    private /* synthetic */ EnumParticleTypes particleType;
    private /* synthetic */ float xOffset;
    private /* synthetic */ int particleCount;
    private /* synthetic */ boolean longDistance;
    private /* synthetic */ float yOffset;
    
    public float getXOffset() {
        return this.xOffset;
    }
    
    public int[] getParticleArgs() {
        return this.particleArguments;
    }
    
    @Override
    public void readPacketData(final PacketBuffer lllllllllllllIlIIlIIIIllIIlIIIll) throws IOException {
        this.particleType = EnumParticleTypes.getParticleFromId(lllllllllllllIlIIlIIIIllIIlIIIll.readInt());
        if (this.particleType == null) {
            this.particleType = EnumParticleTypes.BARRIER;
        }
        this.longDistance = lllllllllllllIlIIlIIIIllIIlIIIll.readBoolean();
        this.xCoord = lllllllllllllIlIIlIIIIllIIlIIIll.readFloat();
        this.yCoord = lllllllllllllIlIIlIIIIllIIlIIIll.readFloat();
        this.zCoord = lllllllllllllIlIIlIIIIllIIlIIIll.readFloat();
        this.xOffset = lllllllllllllIlIIlIIIIllIIlIIIll.readFloat();
        this.yOffset = lllllllllllllIlIIlIIIIllIIlIIIll.readFloat();
        this.zOffset = lllllllllllllIlIIlIIIIllIIlIIIll.readFloat();
        this.particleSpeed = lllllllllllllIlIIlIIIIllIIlIIIll.readFloat();
        this.particleCount = lllllllllllllIlIIlIIIIllIIlIIIll.readInt();
        final int lllllllllllllIlIIlIIIIllIIlIIllI = this.particleType.getArgumentCount();
        this.particleArguments = new int[lllllllllllllIlIIlIIIIllIIlIIllI];
        for (int lllllllllllllIlIIlIIIIllIIlIIlIl = 0; lllllllllllllIlIIlIIIIllIIlIIlIl < lllllllllllllIlIIlIIIIllIIlIIllI; ++lllllllllllllIlIIlIIIIllIIlIIlIl) {
            this.particleArguments[lllllllllllllIlIIlIIIIllIIlIIlIl] = lllllllllllllIlIIlIIIIllIIlIIIll.readVarIntFromBuffer();
        }
    }
    
    public boolean isLongDistance() {
        return this.longDistance;
    }
    
    public double getZCoordinate() {
        return this.zCoord;
    }
    
    public EnumParticleTypes getParticleType() {
        return this.particleType;
    }
    
    public float getParticleSpeed() {
        return this.particleSpeed;
    }
    
    public SPacketParticles() {
    }
    
    public float getYOffset() {
        return this.yOffset;
    }
    
    public int getParticleCount() {
        return this.particleCount;
    }
    
    public double getXCoordinate() {
        return this.xCoord;
    }
    
    @Override
    public void writePacketData(final PacketBuffer lllllllllllllIlIIlIIIIllIIIllIll) throws IOException {
        lllllllllllllIlIIlIIIIllIIIllIll.writeInt(this.particleType.getParticleID());
        lllllllllllllIlIIlIIIIllIIIllIll.writeBoolean(this.longDistance);
        lllllllllllllIlIIlIIIIllIIIllIll.writeFloat(this.xCoord);
        lllllllllllllIlIIlIIIIllIIIllIll.writeFloat(this.yCoord);
        lllllllllllllIlIIlIIIIllIIIllIll.writeFloat(this.zCoord);
        lllllllllllllIlIIlIIIIllIIIllIll.writeFloat(this.xOffset);
        lllllllllllllIlIIlIIIIllIIIllIll.writeFloat(this.yOffset);
        lllllllllllllIlIIlIIIIllIIIllIll.writeFloat(this.zOffset);
        lllllllllllllIlIIlIIIIllIIIllIll.writeFloat(this.particleSpeed);
        lllllllllllllIlIIlIIIIllIIIllIll.writeInt(this.particleCount);
        for (int lllllllllllllIlIIlIIIIllIIIllIlI = this.particleType.getArgumentCount(), lllllllllllllIlIIlIIIIllIIIllIIl = 0; lllllllllllllIlIIlIIIIllIIIllIIl < lllllllllllllIlIIlIIIIllIIIllIlI; ++lllllllllllllIlIIlIIIIllIIIllIIl) {
            lllllllllllllIlIIlIIIIllIIIllIll.writeVarIntToBuffer(this.particleArguments[lllllllllllllIlIIlIIIIllIIIllIIl]);
        }
    }
    
    public double getYCoordinate() {
        return this.yCoord;
    }
    
    public float getZOffset() {
        return this.zOffset;
    }
    
    public SPacketParticles(final EnumParticleTypes lllllllllllllIlIIlIIIIllIIllIlll, final boolean lllllllllllllIlIIlIIIIllIlIIIIlI, final float lllllllllllllIlIIlIIIIllIlIIIIIl, final float lllllllllllllIlIIlIIIIllIIllIlII, final float lllllllllllllIlIIlIIIIllIIllIIll, final float lllllllllllllIlIIlIIIIllIIllIIlI, final float lllllllllllllIlIIlIIIIllIIllllIl, final float lllllllllllllIlIIlIIIIllIIllIIII, final float lllllllllllllIlIIlIIIIllIIlIllll, final int lllllllllllllIlIIlIIIIllIIlIlllI, final int... lllllllllllllIlIIlIIIIllIIlllIIl) {
        this.particleType = lllllllllllllIlIIlIIIIllIIllIlll;
        this.longDistance = lllllllllllllIlIIlIIIIllIlIIIIlI;
        this.xCoord = lllllllllllllIlIIlIIIIllIlIIIIIl;
        this.yCoord = lllllllllllllIlIIlIIIIllIIllIlII;
        this.zCoord = lllllllllllllIlIIlIIIIllIIllIIll;
        this.xOffset = lllllllllllllIlIIlIIIIllIIllIIlI;
        this.yOffset = lllllllllllllIlIIlIIIIllIIllllIl;
        this.zOffset = lllllllllllllIlIIlIIIIllIIllIIII;
        this.particleSpeed = lllllllllllllIlIIlIIIIllIIlIllll;
        this.particleCount = lllllllllllllIlIIlIIIIllIIlIlllI;
        this.particleArguments = lllllllllllllIlIIlIIIIllIIlllIIl;
    }
    
    @Override
    public void processPacket(final INetHandlerPlayClient lllllllllllllIlIIlIIIIlIlllIlllI) {
        lllllllllllllIlIIlIIIIlIlllIlllI.handleParticles(this);
    }
}
