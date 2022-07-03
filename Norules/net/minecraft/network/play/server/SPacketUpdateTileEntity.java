package net.minecraft.network.play.server;

import net.minecraft.network.play.*;
import net.minecraft.nbt.*;
import net.minecraft.util.math.*;
import net.minecraft.network.*;
import java.io.*;

public class SPacketUpdateTileEntity implements Packet<INetHandlerPlayClient>
{
    private /* synthetic */ NBTTagCompound nbt;
    private /* synthetic */ int metadata;
    private /* synthetic */ BlockPos blockPos;
    
    @Override
    public void readPacketData(final PacketBuffer lllIlIlIIIlllll) throws IOException {
        this.blockPos = lllIlIlIIIlllll.readBlockPos();
        this.metadata = lllIlIlIIIlllll.readUnsignedByte();
        this.nbt = lllIlIlIIIlllll.readNBTTagCompoundFromBuffer();
    }
    
    public SPacketUpdateTileEntity() {
    }
    
    @Override
    public void processPacket(final INetHandlerPlayClient lllIlIlIIIlIlIl) {
        lllIlIlIIIlIlIl.handleUpdateTileEntity(this);
    }
    
    public SPacketUpdateTileEntity(final BlockPos lllIlIlIIlIlIll, final int lllIlIlIIlIIllI, final NBTTagCompound lllIlIlIIlIIlIl) {
        this.blockPos = lllIlIlIIlIlIll;
        this.metadata = lllIlIlIIlIIllI;
        this.nbt = lllIlIlIIlIIlIl;
    }
    
    public int getTileEntityType() {
        return this.metadata;
    }
    
    public BlockPos getPos() {
        return this.blockPos;
    }
    
    public NBTTagCompound getNbtCompound() {
        return this.nbt;
    }
    
    @Override
    public void writePacketData(final PacketBuffer lllIlIlIIIllIll) throws IOException {
        lllIlIlIIIllIll.writeBlockPos(this.blockPos);
        lllIlIlIIIllIll.writeByte((byte)this.metadata);
        lllIlIlIIIllIll.writeNBTTagCompoundToBuffer(this.nbt);
    }
}
