package com.viaversion.viaversion.protocols.protocol1_14to1_13_2.types;

import com.viaversion.viaversion.api.type.*;
import io.netty.buffer.*;
import com.viaversion.viaversion.libs.opennbt.tag.builtin.*;
import com.viaversion.viaversion.api.type.types.version.*;
import com.viaversion.viaversion.api.*;
import com.viaversion.viaversion.api.minecraft.chunks.*;
import java.util.*;
import com.viaversion.viaversion.api.type.types.minecraft.*;

public class Chunk1_14Type extends Type<Chunk>
{
    @Override
    public Chunk read(final ByteBuf llllllllllllllllIIIIIllIlIllllII) throws Exception {
        final int llllllllllllllllIIIIIllIllIIIlII = llllllllllllllllIIIIIllIlIllllII.readInt();
        final int llllllllllllllllIIIIIllIllIIIIll = llllllllllllllllIIIIIllIlIllllII.readInt();
        final boolean llllllllllllllllIIIIIllIllIIIIlI = llllllllllllllllIIIIIllIlIllllII.readBoolean();
        final int llllllllllllllllIIIIIllIllIIIIIl = Type.VAR_INT.readPrimitive(llllllllllllllllIIIIIllIlIllllII);
        final CompoundTag llllllllllllllllIIIIIllIllIIIIII = Type.NBT.read(llllllllllllllllIIIIIllIlIllllII);
        Type.VAR_INT.readPrimitive(llllllllllllllllIIIIIllIlIllllII);
        final ChunkSection[] llllllllllllllllIIIIIllIlIllllll = new ChunkSection[16];
        for (int llllllllllllllllIIIIIllIllIIlIIl = 0; llllllllllllllllIIIIIllIllIIlIIl < 16; ++llllllllllllllllIIIIIllIllIIlIIl) {
            if ((llllllllllllllllIIIIIllIllIIIIIl & 1 << llllllllllllllllIIIIIllIllIIlIIl) != 0x0) {
                final short llllllllllllllllIIIIIllIllIIlIll = llllllllllllllllIIIIIllIlIllllII.readShort();
                final ChunkSection llllllllllllllllIIIIIllIllIIlIlI = Types1_13.CHUNK_SECTION.read(llllllllllllllllIIIIIllIlIllllII);
                llllllllllllllllIIIIIllIllIIlIlI.setNonAirBlocksCount(llllllllllllllllIIIIIllIllIIlIll);
                llllllllllllllllIIIIIllIlIllllll[llllllllllllllllIIIIIllIllIIlIIl] = llllllllllllllllIIIIIllIllIIlIlI;
            }
        }
        final int[] llllllllllllllllIIIIIllIlIlllllI = (int[])(llllllllllllllllIIIIIllIllIIIIlI ? new int[256] : null);
        if (llllllllllllllllIIIIIllIllIIIIlI) {
            for (int llllllllllllllllIIIIIllIllIIlIII = 0; llllllllllllllllIIIIIllIllIIlIII < 256; ++llllllllllllllllIIIIIllIllIIlIII) {
                llllllllllllllllIIIIIllIlIlllllI[llllllllllllllllIIIIIllIllIIlIII] = llllllllllllllllIIIIIllIlIllllII.readInt();
            }
        }
        final List<CompoundTag> llllllllllllllllIIIIIllIlIllllIl = new ArrayList<CompoundTag>(Arrays.asList((CompoundTag[])Type.NBT_ARRAY.read(llllllllllllllllIIIIIllIlIllllII)));
        if (llllllllllllllllIIIIIllIlIllllII.readableBytes() > 0) {
            final byte[] llllllllllllllllIIIIIllIllIIIlll = Type.REMAINING_BYTES.read(llllllllllllllllIIIIIllIlIllllII);
            if (Via.getManager().isDebug()) {
                Via.getPlatform().getLogger().warning(String.valueOf(new StringBuilder().append("Found ").append(llllllllllllllllIIIIIllIllIIIlll.length).append(" more bytes than expected while reading the chunk: ").append(llllllllllllllllIIIIIllIllIIIlII).append("/").append(llllllllllllllllIIIIIllIllIIIIll)));
            }
        }
        return new BaseChunk(llllllllllllllllIIIIIllIllIIIlII, llllllllllllllllIIIIIllIllIIIIll, llllllllllllllllIIIIIllIllIIIIlI, false, llllllllllllllllIIIIIllIllIIIIIl, llllllllllllllllIIIIIllIlIllllll, llllllllllllllllIIIIIllIlIlllllI, llllllllllllllllIIIIIllIllIIIIII, llllllllllllllllIIIIIllIlIllllIl);
    }
    
    @Override
    public Class<? extends Type> getBaseClass() {
        return BaseChunkType.class;
    }
    
    @Override
    public void write(final ByteBuf llllllllllllllllIIIIIllIlIlIIlll, final Chunk llllllllllllllllIIIIIllIlIlIIIll) throws Exception {
        llllllllllllllllIIIIIllIlIlIIlll.writeInt(llllllllllllllllIIIIIllIlIlIIIll.getX());
        llllllllllllllllIIIIIllIlIlIIlll.writeInt(llllllllllllllllIIIIIllIlIlIIIll.getZ());
        llllllllllllllllIIIIIllIlIlIIlll.writeBoolean(llllllllllllllllIIIIIllIlIlIIIll.isFullChunk());
        Type.VAR_INT.writePrimitive(llllllllllllllllIIIIIllIlIlIIlll, llllllllllllllllIIIIIllIlIlIIIll.getBitmask());
        Type.NBT.write(llllllllllllllllIIIIIllIlIlIIlll, llllllllllllllllIIIIIllIlIlIIIll.getHeightMap());
        final ByteBuf llllllllllllllllIIIIIllIlIlIIlIl = llllllllllllllllIIIIIllIlIlIIlll.alloc().buffer();
        try {
            for (int llllllllllllllllIIIIIllIlIlIlIlI = 0; llllllllllllllllIIIIIllIlIlIlIlI < 16; ++llllllllllllllllIIIIIllIlIlIlIlI) {
                final ChunkSection llllllllllllllllIIIIIllIlIlIlIll = llllllllllllllllIIIIIllIlIlIIIll.getSections()[llllllllllllllllIIIIIllIlIlIlIlI];
                if (llllllllllllllllIIIIIllIlIlIlIll != null) {
                    llllllllllllllllIIIIIllIlIlIIlIl.writeShort(llllllllllllllllIIIIIllIlIlIlIll.getNonAirBlocksCount());
                    Types1_13.CHUNK_SECTION.write(llllllllllllllllIIIIIllIlIlIIlIl, llllllllllllllllIIIIIllIlIlIlIll);
                }
            }
            llllllllllllllllIIIIIllIlIlIIlIl.readerIndex(0);
            Type.VAR_INT.writePrimitive(llllllllllllllllIIIIIllIlIlIIlll, llllllllllllllllIIIIIllIlIlIIlIl.readableBytes() + (llllllllllllllllIIIIIllIlIlIIIll.isBiomeData() ? 1024 : 0));
            llllllllllllllllIIIIIllIlIlIIlll.writeBytes(llllllllllllllllIIIIIllIlIlIIlIl);
        }
        finally {
            llllllllllllllllIIIIIllIlIlIIlIl.release();
        }
        if (llllllllllllllllIIIIIllIlIlIIIll.isBiomeData()) {
            final int[] biomeData = llllllllllllllllIIIIIllIlIlIIIll.getBiomeData();
            final short llllllllllllllllIIIIIllIlIlIIIII = (short)biomeData.length;
            for (long llllllllllllllllIIIIIllIlIIlllll = 0; llllllllllllllllIIIIIllIlIIlllll < llllllllllllllllIIIIIllIlIlIIIII; ++llllllllllllllllIIIIIllIlIIlllll) {
                final int llllllllllllllllIIIIIllIlIlIlIIl = biomeData[llllllllllllllllIIIIIllIlIIlllll];
                llllllllllllllllIIIIIllIlIlIIlll.writeInt(llllllllllllllllIIIIIllIlIlIlIIl & 0xFF);
            }
        }
        Type.NBT_ARRAY.write(llllllllllllllllIIIIIllIlIlIIlll, llllllllllllllllIIIIIllIlIlIIIll.getBlockEntities().toArray(new CompoundTag[0]));
    }
    
    public Chunk1_14Type() {
        super(Chunk.class);
    }
}
