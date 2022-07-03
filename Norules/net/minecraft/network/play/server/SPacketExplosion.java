package net.minecraft.network.play.server;

import net.minecraft.network.play.*;
import java.util.*;
import com.google.common.collect.*;
import java.io.*;
import net.minecraft.network.*;
import net.minecraft.util.math.*;

public class SPacketExplosion implements Packet<INetHandlerPlayClient>
{
    private /* synthetic */ float motionX;
    private /* synthetic */ float motionY;
    private /* synthetic */ double posY;
    private /* synthetic */ List<BlockPos> affectedBlockPositions;
    private /* synthetic */ double posZ;
    private /* synthetic */ float strength;
    private /* synthetic */ float motionZ;
    private /* synthetic */ double posX;
    
    public List<BlockPos> getAffectedBlockPositions() {
        return this.affectedBlockPositions;
    }
    
    @Override
    public void processPacket(final INetHandlerPlayClient lllllllllllllIlIlIIlllllIlllIIIl) {
        lllllllllllllIlIlIIlllllIlllIIIl.handleExplosion(this);
    }
    
    public float getMotionY() {
        return this.motionY;
    }
    
    public double getX() {
        return this.posX;
    }
    
    public float getMotionZ() {
        return this.motionZ;
    }
    
    @Override
    public void readPacketData(final PacketBuffer lllllllllllllIlIlIIllllllIlIIllI) throws IOException {
        this.posX = lllllllllllllIlIlIIllllllIlIIllI.readFloat();
        this.posY = lllllllllllllIlIlIIllllllIlIIllI.readFloat();
        this.posZ = lllllllllllllIlIlIIllllllIlIIllI.readFloat();
        this.strength = lllllllllllllIlIlIIllllllIlIIllI.readFloat();
        final int lllllllllllllIlIlIIllllllIlIIlIl = lllllllllllllIlIlIIllllllIlIIllI.readInt();
        this.affectedBlockPositions = (List<BlockPos>)Lists.newArrayListWithCapacity(lllllllllllllIlIlIIllllllIlIIlIl);
        final int lllllllllllllIlIlIIllllllIlIIlII = (int)this.posX;
        final int lllllllllllllIlIlIIllllllIlIIIll = (int)this.posY;
        final int lllllllllllllIlIlIIllllllIlIIIlI = (int)this.posZ;
        for (int lllllllllllllIlIlIIllllllIlIIIIl = 0; lllllllllllllIlIlIIllllllIlIIIIl < lllllllllllllIlIlIIllllllIlIIlIl; ++lllllllllllllIlIlIIllllllIlIIIIl) {
            final int lllllllllllllIlIlIIllllllIlIIIII = lllllllllllllIlIlIIllllllIlIIllI.readByte() + lllllllllllllIlIlIIllllllIlIIlII;
            final int lllllllllllllIlIlIIllllllIIlllll = lllllllllllllIlIlIIllllllIlIIllI.readByte() + lllllllllllllIlIlIIllllllIlIIIll;
            final int lllllllllllllIlIlIIllllllIIllllI = lllllllllllllIlIlIIllllllIlIIllI.readByte() + lllllllllllllIlIlIIllllllIlIIIlI;
            this.affectedBlockPositions.add(new BlockPos(lllllllllllllIlIlIIllllllIlIIIII, lllllllllllllIlIlIIllllllIIlllll, lllllllllllllIlIlIIllllllIIllllI));
        }
        this.motionX = lllllllllllllIlIlIIllllllIlIIllI.readFloat();
        this.motionY = lllllllllllllIlIlIIllllllIlIIllI.readFloat();
        this.motionZ = lllllllllllllIlIlIIllllllIlIIllI.readFloat();
    }
    
    public float getStrength() {
        return this.strength;
    }
    
    public float getMotionX() {
        return this.motionX;
    }
    
    public double getZ() {
        return this.posZ;
    }
    
    public SPacketExplosion(final double lllllllllllllIlIlIIllllllIllIlll, final double lllllllllllllIlIlIIllllllIllIllI, final double lllllllllllllIlIlIIllllllIllIlIl, final float lllllllllllllIlIlIIllllllIlllIll, final List<BlockPos> lllllllllllllIlIlIIllllllIllIIll, final Vec3d lllllllllllllIlIlIIllllllIlllIIl) {
        this.posX = lllllllllllllIlIlIIllllllIllIlll;
        this.posY = lllllllllllllIlIlIIllllllIllIllI;
        this.posZ = lllllllllllllIlIlIIllllllIllIlIl;
        this.strength = lllllllllllllIlIlIIllllllIlllIll;
        this.affectedBlockPositions = (List<BlockPos>)Lists.newArrayList((Iterable)lllllllllllllIlIlIIllllllIllIIll);
        if (lllllllllllllIlIlIIllllllIlllIIl != null) {
            this.motionX = (float)lllllllllllllIlIlIIllllllIlllIIl.xCoord;
            this.motionY = (float)lllllllllllllIlIlIIllllllIlllIIl.yCoord;
            this.motionZ = (float)lllllllllllllIlIlIIllllllIlllIIl.zCoord;
        }
    }
    
    public double getY() {
        return this.posY;
    }
    
    public SPacketExplosion() {
    }
    
    @Override
    public void writePacketData(final PacketBuffer lllllllllllllIlIlIIlllllIlllllll) throws IOException {
        lllllllllllllIlIlIIlllllIlllllll.writeFloat((float)this.posX);
        lllllllllllllIlIlIIlllllIlllllll.writeFloat((float)this.posY);
        lllllllllllllIlIlIIlllllIlllllll.writeFloat((float)this.posZ);
        lllllllllllllIlIlIIlllllIlllllll.writeFloat(this.strength);
        lllllllllllllIlIlIIlllllIlllllll.writeInt(this.affectedBlockPositions.size());
        final int lllllllllllllIlIlIIllllllIIIIlll = (int)this.posX;
        final int lllllllllllllIlIlIIllllllIIIIllI = (int)this.posY;
        final int lllllllllllllIlIlIIllllllIIIIlIl = (int)this.posZ;
        for (final BlockPos lllllllllllllIlIlIIllllllIIIIlII : this.affectedBlockPositions) {
            final int lllllllllllllIlIlIIllllllIIIIIll = lllllllllllllIlIlIIllllllIIIIlII.getX() - lllllllllllllIlIlIIllllllIIIIlll;
            final int lllllllllllllIlIlIIllllllIIIIIlI = lllllllllllllIlIlIIllllllIIIIlII.getY() - lllllllllllllIlIlIIllllllIIIIllI;
            final int lllllllllllllIlIlIIllllllIIIIIIl = lllllllllllllIlIlIIllllllIIIIlII.getZ() - lllllllllllllIlIlIIllllllIIIIlIl;
            lllllllllllllIlIlIIlllllIlllllll.writeByte(lllllllllllllIlIlIIllllllIIIIIll);
            lllllllllllllIlIlIIlllllIlllllll.writeByte(lllllllllllllIlIlIIllllllIIIIIlI);
            lllllllllllllIlIlIIlllllIlllllll.writeByte(lllllllllllllIlIlIIllllllIIIIIIl);
        }
        lllllllllllllIlIlIIlllllIlllllll.writeFloat(this.motionX);
        lllllllllllllIlIlIIlllllIlllllll.writeFloat(this.motionY);
        lllllllllllllIlIlIIlllllIlllllll.writeFloat(this.motionZ);
    }
}
