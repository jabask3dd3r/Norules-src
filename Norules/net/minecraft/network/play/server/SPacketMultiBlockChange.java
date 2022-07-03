package net.minecraft.network.play.server;

import net.minecraft.network.play.*;
import net.minecraft.network.*;
import net.minecraft.block.*;
import java.io.*;
import net.minecraft.world.chunk.*;
import net.minecraft.block.state.*;
import net.minecraft.util.math.*;

public class SPacketMultiBlockChange implements Packet<INetHandlerPlayClient>
{
    private /* synthetic */ BlockUpdateData[] changedBlocks;
    private /* synthetic */ ChunkPos chunkPos;
    
    public SPacketMultiBlockChange() {
    }
    
    @Override
    public void writePacketData(final PacketBuffer llllllllllllllIlIIllIIlIIIIIIIII) throws IOException {
        llllllllllllllIlIIllIIlIIIIIIIII.writeInt(this.chunkPos.chunkXPos);
        llllllllllllllIlIIllIIlIIIIIIIII.writeInt(this.chunkPos.chunkZPos);
        llllllllllllllIlIIllIIlIIIIIIIII.writeVarIntToBuffer(this.changedBlocks.length);
        final byte llllllllllllllIlIIllIIIlllllIlIl;
        final float llllllllllllllIlIIllIIIlllllIlll = ((BlockUpdateData[])(Object)(llllllllllllllIlIIllIIIlllllIlIl = (byte)(Object)this.changedBlocks)).length;
        for (short llllllllllllllIlIIllIIIllllllIIl = 0; llllllllllllllIlIIllIIIllllllIIl < llllllllllllllIlIIllIIIlllllIlll; ++llllllllllllllIlIIllIIIllllllIIl) {
            final BlockUpdateData llllllllllllllIlIIllIIIllllllllI = llllllllllllllIlIIllIIIlllllIlIl[llllllllllllllIlIIllIIIllllllIIl];
            llllllllllllllIlIIllIIlIIIIIIIII.writeShort(llllllllllllllIlIIllIIIllllllllI.getOffset());
            llllllllllllllIlIIllIIlIIIIIIIII.writeVarIntToBuffer(Block.BLOCK_STATE_IDS.get(llllllllllllllIlIIllIIIllllllllI.getBlockState()));
        }
    }
    
    public SPacketMultiBlockChange(final int llllllllllllllIlIIllIIlIIIlIllll, final short[] llllllllllllllIlIIllIIlIIIlIllIl, final Chunk llllllllllllllIlIIllIIlIIIlIlIll) {
        this.chunkPos = new ChunkPos(llllllllllllllIlIIllIIlIIIlIlIll.xPosition, llllllllllllllIlIIllIIlIIIlIlIll.zPosition);
        this.changedBlocks = new BlockUpdateData[llllllllllllllIlIIllIIlIIIlIllll];
        for (int llllllllllllllIlIIllIIlIIIlIlIIl = 0; llllllllllllllIlIIllIIlIIIlIlIIl < this.changedBlocks.length; ++llllllllllllllIlIIllIIlIIIlIlIIl) {
            this.changedBlocks[llllllllllllllIlIIllIIlIIIlIlIIl] = new BlockUpdateData(llllllllllllllIlIIllIIlIIIlIllIl[llllllllllllllIlIIllIIlIIIlIlIIl], llllllllllllllIlIIllIIlIIIlIlIll);
        }
    }
    
    @Override
    public void processPacket(final INetHandlerPlayClient llllllllllllllIlIIllIIIllllIlIlI) {
        llllllllllllllIlIIllIIIllllIlIlI.handleMultiBlockChange(this);
    }
    
    @Override
    public void readPacketData(final PacketBuffer llllllllllllllIlIIllIIlIIIIlIlII) throws IOException {
        this.chunkPos = new ChunkPos(llllllllllllllIlIIllIIlIIIIlIlII.readInt(), llllllllllllllIlIIllIIlIIIIlIlII.readInt());
        this.changedBlocks = new BlockUpdateData[llllllllllllllIlIIllIIlIIIIlIlII.readVarIntFromBuffer()];
        for (int llllllllllllllIlIIllIIlIIIIlIllI = 0; llllllllllllllIlIIllIIlIIIIlIllI < this.changedBlocks.length; ++llllllllllllllIlIIllIIlIIIIlIllI) {
            this.changedBlocks[llllllllllllllIlIIllIIlIIIIlIllI] = new BlockUpdateData(llllllllllllllIlIIllIIlIIIIlIlII.readShort(), Block.BLOCK_STATE_IDS.getByValue(llllllllllllllIlIIllIIlIIIIlIlII.readVarIntFromBuffer()));
        }
    }
    
    public BlockUpdateData[] getChangedBlocks() {
        return this.changedBlocks;
    }
    
    public class BlockUpdateData
    {
        private final /* synthetic */ IBlockState blockState;
        private final /* synthetic */ short offset;
        
        public BlockUpdateData(final short llllllllllllIlllllIIlllIlIlllIIl, final IBlockState llllllllllllIlllllIIlllIlIlllIII) {
            this.offset = llllllllllllIlllllIIlllIlIlllIIl;
            this.blockState = llllllllllllIlllllIIlllIlIlllIII;
        }
        
        public BlockPos getPos() {
            return new BlockPos(SPacketMultiBlockChange.this.chunkPos.getBlock(this.offset >> 12 & 0xF, this.offset & 0xFF, this.offset >> 8 & 0xF));
        }
        
        public short getOffset() {
            return this.offset;
        }
        
        public BlockUpdateData(final short llllllllllllIlllllIIlllIlIlIlIlI, final Chunk llllllllllllIlllllIIlllIlIlIlIIl) {
            this.offset = llllllllllllIlllllIIlllIlIlIlIlI;
            this.blockState = llllllllllllIlllllIIlllIlIlIlIIl.getBlockState(this.getPos());
        }
        
        public IBlockState getBlockState() {
            return this.blockState;
        }
    }
}
