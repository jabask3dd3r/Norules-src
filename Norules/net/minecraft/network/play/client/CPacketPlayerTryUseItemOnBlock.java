package net.minecraft.network.play.client;

import net.minecraft.network.play.*;
import net.minecraft.util.math.*;
import net.minecraft.util.*;
import java.io.*;
import net.minecraft.network.*;

public class CPacketPlayerTryUseItemOnBlock implements Packet<INetHandlerPlayServer>
{
    private /* synthetic */ EnumFacing placedBlockDirection;
    private /* synthetic */ BlockPos position;
    private /* synthetic */ float facingZ;
    private /* synthetic */ float facingX;
    private /* synthetic */ EnumHand hand;
    private /* synthetic */ float facingY;
    
    public EnumHand getHand() {
        return this.hand;
    }
    
    public float getFacingX() {
        return this.facingX;
    }
    
    public CPacketPlayerTryUseItemOnBlock() {
    }
    
    @Override
    public void processPacket(final INetHandlerPlayServer llllllllllllllIIIlIllIIlIIllIllI) {
        llllllllllllllIIIlIllIIlIIllIllI.processRightClickBlock(this);
    }
    
    public CPacketPlayerTryUseItemOnBlock(final BlockPos llllllllllllllIIIlIllIIlIlIlIIlI, final EnumFacing llllllllllllllIIIlIllIIlIlIlIIIl, final EnumHand llllllllllllllIIIlIllIIlIlIlIIII, final float llllllllllllllIIIlIllIIlIlIIlIII, final float llllllllllllllIIIlIllIIlIlIIlllI, final float llllllllllllllIIIlIllIIlIlIIIllI) {
        this.position = llllllllllllllIIIlIllIIlIlIlIIlI;
        this.placedBlockDirection = llllllllllllllIIIlIllIIlIlIlIIIl;
        this.hand = llllllllllllllIIIlIllIIlIlIlIIII;
        this.facingX = llllllllllllllIIIlIllIIlIlIIlIII;
        this.facingY = llllllllllllllIIIlIllIIlIlIIlllI;
        this.facingZ = llllllllllllllIIIlIllIIlIlIIIllI;
    }
    
    @Override
    public void readPacketData(final PacketBuffer llllllllllllllIIIlIllIIlIlIIIIlI) throws IOException {
        this.position = llllllllllllllIIIlIllIIlIlIIIIlI.readBlockPos();
        this.placedBlockDirection = llllllllllllllIIIlIllIIlIlIIIIlI.readEnumValue(EnumFacing.class);
        this.hand = llllllllllllllIIIlIllIIlIlIIIIlI.readEnumValue(EnumHand.class);
        this.facingX = llllllllllllllIIIlIllIIlIlIIIIlI.readFloat();
        this.facingY = llllllllllllllIIIlIllIIlIlIIIIlI.readFloat();
        this.facingZ = llllllllllllllIIIlIllIIlIlIIIIlI.readFloat();
    }
    
    public BlockPos getPos() {
        return this.position;
    }
    
    public float getFacingY() {
        return this.facingY;
    }
    
    public float getFacingZ() {
        return this.facingZ;
    }
    
    public EnumFacing getDirection() {
        return this.placedBlockDirection;
    }
    
    @Override
    public void writePacketData(final PacketBuffer llllllllllllllIIIlIllIIlIIllllII) throws IOException {
        llllllllllllllIIIlIllIIlIIllllII.writeBlockPos(this.position);
        llllllllllllllIIIlIllIIlIIllllII.writeEnumValue(this.placedBlockDirection);
        llllllllllllllIIIlIllIIlIIllllII.writeEnumValue(this.hand);
        llllllllllllllIIIlIllIIlIIllllII.writeFloat(this.facingX);
        llllllllllllllIIIlIllIIlIIllllII.writeFloat(this.facingY);
        llllllllllllllIIIlIllIIlIIllllII.writeFloat(this.facingZ);
    }
}
