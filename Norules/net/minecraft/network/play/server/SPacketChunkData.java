package net.minecraft.network.play.server;

import net.minecraft.network.play.*;
import net.minecraft.nbt.*;
import io.netty.buffer.*;
import java.io.*;
import net.minecraft.world.chunk.*;
import net.minecraft.world.chunk.storage.*;
import com.google.common.collect.*;
import java.util.*;
import net.minecraft.util.math.*;
import net.minecraft.tileentity.*;
import net.minecraft.network.*;

public class SPacketChunkData implements Packet<INetHandlerPlayClient>
{
    private /* synthetic */ int chunkX;
    private /* synthetic */ int chunkZ;
    private /* synthetic */ int availableSections;
    private /* synthetic */ byte[] buffer;
    private /* synthetic */ List<NBTTagCompound> tileEntityTags;
    private /* synthetic */ boolean loadChunk;
    
    public boolean doChunkLoad() {
        return this.loadChunk;
    }
    
    private ByteBuf getWriteBuffer() {
        final ByteBuf llllllllllllllllIllIllIlllllIIII = Unpooled.wrappedBuffer(this.buffer);
        llllllllllllllllIllIllIlllllIIII.writerIndex(0);
        return llllllllllllllllIllIllIlllllIIII;
    }
    
    @Override
    public void writePacketData(final PacketBuffer llllllllllllllllIllIlllIIIIlIIlI) throws IOException {
        llllllllllllllllIllIlllIIIIlIIlI.writeInt(this.chunkX);
        llllllllllllllllIllIlllIIIIlIIlI.writeInt(this.chunkZ);
        llllllllllllllllIllIlllIIIIlIIlI.writeBoolean(this.loadChunk);
        llllllllllllllllIllIlllIIIIlIIlI.writeVarIntToBuffer(this.availableSections);
        llllllllllllllllIllIlllIIIIlIIlI.writeVarIntToBuffer(this.buffer.length);
        llllllllllllllllIllIlllIIIIlIIlI.writeBytes(this.buffer);
        llllllllllllllllIllIlllIIIIlIIlI.writeVarIntToBuffer(this.tileEntityTags.size());
        for (final NBTTagCompound llllllllllllllllIllIlllIIIIlIlIl : this.tileEntityTags) {
            llllllllllllllllIllIlllIIIIlIIlI.writeNBTTagCompoundToBuffer(llllllllllllllllIllIlllIIIIlIlIl);
        }
    }
    
    public int getChunkZ() {
        return this.chunkZ;
    }
    
    protected int calculateChunkSize(final Chunk llllllllllllllllIllIllIllIIIIlII, final boolean llllllllllllllllIllIllIllIIIIIlI, final int llllllllllllllllIllIllIllIIIIIII) {
        int llllllllllllllllIllIllIllIIIllII = 0;
        final ExtendedBlockStorage[] llllllllllllllllIllIllIllIIIlIll = llllllllllllllllIllIllIllIIIIlII.getBlockStorageArray();
        for (int llllllllllllllllIllIllIllIIIlIlI = 0, llllllllllllllllIllIllIllIIIlIIl = llllllllllllllllIllIllIllIIIlIll.length; llllllllllllllllIllIllIllIIIlIlI < llllllllllllllllIllIllIllIIIlIIl; ++llllllllllllllllIllIllIllIIIlIlI) {
            final ExtendedBlockStorage llllllllllllllllIllIllIllIIIIlll = llllllllllllllllIllIllIllIIIlIll[llllllllllllllllIllIllIllIIIlIlI];
            if (llllllllllllllllIllIllIllIIIIlll != Chunk.NULL_BLOCK_STORAGE && (!this.doChunkLoad() || !llllllllllllllllIllIllIllIIIIlll.isEmpty()) && (llllllllllllllllIllIllIllIIIIIII & 1 << llllllllllllllllIllIllIllIIIlIlI) != 0x0) {
                llllllllllllllllIllIllIllIIIllII += llllllllllllllllIllIllIllIIIIlll.getData().getSerializedSize();
                llllllllllllllllIllIllIllIIIllII += llllllllllllllllIllIllIllIIIIlll.getBlocklightArray().getData().length;
                if (llllllllllllllllIllIllIllIIIIIlI) {
                    llllllllllllllllIllIllIllIIIllII += llllllllllllllllIllIllIllIIIIlll.getSkylightArray().getData().length;
                }
            }
        }
        if (this.doChunkLoad()) {
            llllllllllllllllIllIllIllIIIllII += llllllllllllllllIllIllIllIIIIlII.getBiomeArray().length;
        }
        return llllllllllllllllIllIllIllIIIllII;
    }
    
    public SPacketChunkData() {
    }
    
    @Override
    public void processPacket(final INetHandlerPlayClient llllllllllllllllIllIlllIIIIIIIlI) {
        llllllllllllllllIllIlllIIIIIIIlI.handleChunkData(this);
    }
    
    public SPacketChunkData(final Chunk llllllllllllllllIllIlllIIlIIlIll, final int llllllllllllllllIllIlllIIlIlIllI) {
        this.chunkX = llllllllllllllllIllIlllIIlIIlIll.xPosition;
        this.chunkZ = llllllllllllllllIllIlllIIlIIlIll.zPosition;
        this.loadChunk = (llllllllllllllllIllIlllIIlIlIllI == 65535);
        final boolean llllllllllllllllIllIlllIIlIlIlIl = llllllllllllllllIllIlllIIlIIlIll.getWorld().provider.func_191066_m();
        this.buffer = new byte[this.calculateChunkSize(llllllllllllllllIllIlllIIlIIlIll, llllllllllllllllIllIlllIIlIlIlIl, llllllllllllllllIllIlllIIlIlIllI)];
        this.availableSections = this.extractChunkData(new PacketBuffer(this.getWriteBuffer()), llllllllllllllllIllIlllIIlIIlIll, llllllllllllllllIllIlllIIlIlIlIl, llllllllllllllllIllIlllIIlIlIllI);
        this.tileEntityTags = (List<NBTTagCompound>)Lists.newArrayList();
        for (final Map.Entry<BlockPos, TileEntity> llllllllllllllllIllIlllIIlIlIIll : llllllllllllllllIllIlllIIlIIlIll.getTileEntityMap().entrySet()) {
            final BlockPos llllllllllllllllIllIlllIIlIlIIIl = llllllllllllllllIllIlllIIlIlIIll.getKey();
            final TileEntity llllllllllllllllIllIlllIIlIIllll = llllllllllllllllIllIlllIIlIlIIll.getValue();
            final int llllllllllllllllIllIlllIIlIIlllI = llllllllllllllllIllIlllIIlIlIIIl.getY() >> 4;
            if (this.doChunkLoad() || (llllllllllllllllIllIlllIIlIlIllI & 1 << llllllllllllllllIllIlllIIlIIlllI) != 0x0) {
                final NBTTagCompound llllllllllllllllIllIlllIIlIIllIl = llllllllllllllllIllIlllIIlIIllll.getUpdateTag();
                this.tileEntityTags.add(llllllllllllllllIllIlllIIlIIllIl);
            }
        }
    }
    
    @Override
    public void readPacketData(final PacketBuffer llllllllllllllllIllIlllIIIlIIIIl) throws IOException {
        this.chunkX = llllllllllllllllIllIlllIIIlIIIIl.readInt();
        this.chunkZ = llllllllllllllllIllIlllIIIlIIIIl.readInt();
        this.loadChunk = llllllllllllllllIllIlllIIIlIIIIl.readBoolean();
        this.availableSections = llllllllllllllllIllIlllIIIlIIIIl.readVarIntFromBuffer();
        final int llllllllllllllllIllIlllIIIlIlIII = llllllllllllllllIllIlllIIIlIIIIl.readVarIntFromBuffer();
        if (llllllllllllllllIllIlllIIIlIlIII > 2097152) {
            throw new RuntimeException("Chunk Packet trying to allocate too much memory on read.");
        }
        this.buffer = new byte[llllllllllllllllIllIlllIIIlIlIII];
        llllllllllllllllIllIlllIIIlIIIIl.readBytes(this.buffer);
        final int llllllllllllllllIllIlllIIIlIIllI = llllllllllllllllIllIlllIIIlIIIIl.readVarIntFromBuffer();
        this.tileEntityTags = (List<NBTTagCompound>)Lists.newArrayList();
        for (int llllllllllllllllIllIlllIIIlIIlII = 0; llllllllllllllllIllIlllIIIlIIlII < llllllllllllllllIllIlllIIIlIIllI; ++llllllllllllllllIllIlllIIIlIIlII) {
            this.tileEntityTags.add(llllllllllllllllIllIlllIIIlIIIIl.readNBTTagCompoundFromBuffer());
        }
    }
    
    public int getChunkX() {
        return this.chunkX;
    }
    
    public int extractChunkData(final PacketBuffer llllllllllllllllIllIllIlllIIIlll, final Chunk llllllllllllllllIllIllIlllIIIllI, final boolean llllllllllllllllIllIllIlllIIIlIl, final int llllllllllllllllIllIllIllIlllIIl) {
        int llllllllllllllllIllIllIlllIIIIll = 0;
        final ExtendedBlockStorage[] llllllllllllllllIllIllIlllIIIIlI = llllllllllllllllIllIllIlllIIIllI.getBlockStorageArray();
        for (int llllllllllllllllIllIllIlllIIIIIl = 0, llllllllllllllllIllIllIlllIIIIII = llllllllllllllllIllIllIlllIIIIlI.length; llllllllllllllllIllIllIlllIIIIIl < llllllllllllllllIllIllIlllIIIIII; ++llllllllllllllllIllIllIlllIIIIIl) {
            final ExtendedBlockStorage llllllllllllllllIllIllIllIllllll = llllllllllllllllIllIllIlllIIIIlI[llllllllllllllllIllIllIlllIIIIIl];
            if (llllllllllllllllIllIllIllIllllll != Chunk.NULL_BLOCK_STORAGE && (!this.doChunkLoad() || !llllllllllllllllIllIllIllIllllll.isEmpty()) && (llllllllllllllllIllIllIllIlllIIl & 1 << llllllllllllllllIllIllIlllIIIIIl) != 0x0) {
                llllllllllllllllIllIllIlllIIIIll |= 1 << llllllllllllllllIllIllIlllIIIIIl;
                llllllllllllllllIllIllIllIllllll.getData().write(llllllllllllllllIllIllIlllIIIlll);
                llllllllllllllllIllIllIlllIIIlll.writeBytes(llllllllllllllllIllIllIllIllllll.getBlocklightArray().getData());
                if (llllllllllllllllIllIllIlllIIIlIl) {
                    llllllllllllllllIllIllIlllIIIlll.writeBytes(llllllllllllllllIllIllIllIllllll.getSkylightArray().getData());
                }
            }
        }
        if (this.doChunkLoad()) {
            llllllllllllllllIllIllIlllIIIlll.writeBytes(llllllllllllllllIllIllIlllIIIllI.getBiomeArray());
        }
        return llllllllllllllllIllIllIlllIIIIll;
    }
    
    public List<NBTTagCompound> getTileEntityTags() {
        return this.tileEntityTags;
    }
    
    public int getExtractedSize() {
        return this.availableSections;
    }
    
    public PacketBuffer getReadBuffer() {
        return new PacketBuffer(Unpooled.wrappedBuffer(this.buffer));
    }
}
