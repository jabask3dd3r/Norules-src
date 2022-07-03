package com.viaversion.viaversion.protocols.protocol1_15to1_14_4.types;

import com.viaversion.viaversion.api.type.*;
import com.viaversion.viaversion.libs.opennbt.tag.builtin.*;
import io.netty.buffer.*;
import com.viaversion.viaversion.api.type.types.version.*;
import com.viaversion.viaversion.api.*;
import com.viaversion.viaversion.api.minecraft.chunks.*;
import java.util.*;
import com.viaversion.viaversion.api.type.types.minecraft.*;

public class Chunk1_15Type extends Type<Chunk>
{
    private static final /* synthetic */ CompoundTag[] EMPTY_COMPOUNDS;
    
    @Override
    public Chunk read(final ByteBuf llllllllllllllIIllIIIlIIIIIlllll) throws Exception {
        final int llllllllllllllIIllIIIlIIIIIllllI = llllllllllllllIIllIIIlIIIIIlllll.readInt();
        final int llllllllllllllIIllIIIlIIIIIlllIl = llllllllllllllIIllIIIlIIIIIlllll.readInt();
        final boolean llllllllllllllIIllIIIlIIIIIlllII = llllllllllllllIIllIIIlIIIIIlllll.readBoolean();
        final int llllllllllllllIIllIIIlIIIIIllIll = Type.VAR_INT.readPrimitive(llllllllllllllIIllIIIlIIIIIlllll);
        final CompoundTag llllllllllllllIIllIIIlIIIIIllIlI = Type.NBT.read(llllllllllllllIIllIIIlIIIIIlllll);
        final int[] llllllllllllllIIllIIIlIIIIIllIIl = (int[])(llllllllllllllIIllIIIlIIIIIlllII ? new int[1024] : null);
        if (llllllllllllllIIllIIIlIIIIIlllII) {
            for (int llllllllllllllIIllIIIlIIIIlIIlIl = 0; llllllllllllllIIllIIIlIIIIlIIlIl < 1024; ++llllllllllllllIIllIIIlIIIIlIIlIl) {
                llllllllllllllIIllIIIlIIIIIllIIl[llllllllllllllIIllIIIlIIIIlIIlIl] = llllllllllllllIIllIIIlIIIIIlllll.readInt();
            }
        }
        Type.VAR_INT.readPrimitive(llllllllllllllIIllIIIlIIIIIlllll);
        final ChunkSection[] llllllllllllllIIllIIIlIIIIIllIII = new ChunkSection[16];
        for (int llllllllllllllIIllIIIlIIIIlIIIlI = 0; llllllllllllllIIllIIIlIIIIlIIIlI < 16; ++llllllllllllllIIllIIIlIIIIlIIIlI) {
            if ((llllllllllllllIIllIIIlIIIIIllIll & 1 << llllllllllllllIIllIIIlIIIIlIIIlI) != 0x0) {
                final short llllllllllllllIIllIIIlIIIIlIIlII = llllllllllllllIIllIIIlIIIIIlllll.readShort();
                final ChunkSection llllllllllllllIIllIIIlIIIIlIIIll = Types1_13.CHUNK_SECTION.read(llllllllllllllIIllIIIlIIIIIlllll);
                llllllllllllllIIllIIIlIIIIlIIIll.setNonAirBlocksCount(llllllllllllllIIllIIIlIIIIlIIlII);
                llllllllllllllIIllIIIlIIIIIllIII[llllllllllllllIIllIIIlIIIIlIIIlI] = llllllllllllllIIllIIIlIIIIlIIIll;
            }
        }
        final List<CompoundTag> llllllllllllllIIllIIIlIIIIIlIlll = new ArrayList<CompoundTag>(Arrays.asList((CompoundTag[])Type.NBT_ARRAY.read(llllllllllllllIIllIIIlIIIIIlllll)));
        if (llllllllllllllIIllIIIlIIIIIlllll.readableBytes() > 0) {
            final byte[] llllllllllllllIIllIIIlIIIIlIIIIl = Type.REMAINING_BYTES.read(llllllllllllllIIllIIIlIIIIIlllll);
            if (Via.getManager().isDebug()) {
                Via.getPlatform().getLogger().warning(String.valueOf(new StringBuilder().append("Found ").append(llllllllllllllIIllIIIlIIIIlIIIIl.length).append(" more bytes than expected while reading the chunk: ").append(llllllllllllllIIllIIIlIIIIIllllI).append("/").append(llllllllllllllIIllIIIlIIIIIlllIl)));
            }
        }
        return new BaseChunk(llllllllllllllIIllIIIlIIIIIllllI, llllllllllllllIIllIIIlIIIIIlllIl, llllllllllllllIIllIIIlIIIIIlllII, false, llllllllllllllIIllIIIlIIIIIllIll, llllllllllllllIIllIIIlIIIIIllIII, llllllllllllllIIllIIIlIIIIIllIIl, llllllllllllllIIllIIIlIIIIIllIlI, llllllllllllllIIllIIIlIIIIIlIlll);
    }
    
    public Chunk1_15Type() {
        super(Chunk.class);
    }
    
    @Override
    public Class<? extends Type> getBaseClass() {
        return BaseChunkType.class;
    }
    
    @Override
    public void write(final ByteBuf llllllllllllllIIllIIIIllllllllIl, final Chunk llllllllllllllIIllIIIIllllllllII) throws Exception {
        llllllllllllllIIllIIIIllllllllIl.writeInt(llllllllllllllIIllIIIIllllllllII.getX());
        llllllllllllllIIllIIIIllllllllIl.writeInt(llllllllllllllIIllIIIIllllllllII.getZ());
        llllllllllllllIIllIIIIllllllllIl.writeBoolean(llllllllllllllIIllIIIIllllllllII.isFullChunk());
        Type.VAR_INT.writePrimitive(llllllllllllllIIllIIIIllllllllIl, llllllllllllllIIllIIIIllllllllII.getBitmask());
        Type.NBT.write(llllllllllllllIIllIIIIllllllllIl, llllllllllllllIIllIIIIllllllllII.getHeightMap());
        if (llllllllllllllIIllIIIIllllllllII.isBiomeData()) {
            final boolean llllllllllllllIIllIIIIlllllllIll = (Object)llllllllllllllIIllIIIIllllllllII.getBiomeData();
            final float llllllllllllllIIllIIIIlllllllIlI = llllllllllllllIIllIIIIlllllllIll.length;
            for (final int llllllllllllllIIllIIIlIIIIIIIlII : llllllllllllllIIllIIIIlllllllIll) {
                llllllllllllllIIllIIIIllllllllIl.writeInt(llllllllllllllIIllIIIlIIIIIIIlII);
            }
        }
        final ByteBuf llllllllllllllIIllIIIIlllllllllI = llllllllllllllIIllIIIIllllllllIl.alloc().buffer();
        try {
            for (int llllllllllllllIIllIIIlIIIIIIIIlI = 0; llllllllllllllIIllIIIlIIIIIIIIlI < 16; ++llllllllllllllIIllIIIlIIIIIIIIlI) {
                final ChunkSection llllllllllllllIIllIIIlIIIIIIIIll = llllllllllllllIIllIIIIllllllllII.getSections()[llllllllllllllIIllIIIlIIIIIIIIlI];
                if (llllllllllllllIIllIIIlIIIIIIIIll != null) {
                    llllllllllllllIIllIIIIlllllllllI.writeShort(llllllllllllllIIllIIIlIIIIIIIIll.getNonAirBlocksCount());
                    Types1_13.CHUNK_SECTION.write(llllllllllllllIIllIIIIlllllllllI, llllllllllllllIIllIIIlIIIIIIIIll);
                }
            }
            llllllllllllllIIllIIIIlllllllllI.readerIndex(0);
            Type.VAR_INT.writePrimitive(llllllllllllllIIllIIIIllllllllIl, llllllllllllllIIllIIIIlllllllllI.readableBytes());
            llllllllllllllIIllIIIIllllllllIl.writeBytes(llllllllllllllIIllIIIIlllllllllI);
        }
        finally {
            llllllllllllllIIllIIIIlllllllllI.release();
        }
        Type.NBT_ARRAY.write(llllllllllllllIIllIIIIllllllllIl, llllllllllllllIIllIIIIllllllllII.getBlockEntities().toArray(Chunk1_15Type.EMPTY_COMPOUNDS));
    }
    
    static {
        EMPTY_COMPOUNDS = new CompoundTag[0];
    }
}
