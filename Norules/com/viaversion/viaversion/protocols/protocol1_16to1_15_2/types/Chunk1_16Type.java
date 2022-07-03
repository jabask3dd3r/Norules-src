package com.viaversion.viaversion.protocols.protocol1_16to1_15_2.types;

import com.viaversion.viaversion.api.type.*;
import com.viaversion.viaversion.libs.opennbt.tag.builtin.*;
import io.netty.buffer.*;
import com.viaversion.viaversion.api.type.types.minecraft.*;
import com.viaversion.viaversion.api.type.types.version.*;
import com.viaversion.viaversion.api.*;
import com.viaversion.viaversion.api.minecraft.chunks.*;
import java.util.*;

public class Chunk1_16Type extends Type<Chunk>
{
    private static final /* synthetic */ CompoundTag[] EMPTY_COMPOUNDS;
    
    public Chunk1_16Type() {
        super(Chunk.class);
    }
    
    @Override
    public Class<? extends Type> getBaseClass() {
        return BaseChunkType.class;
    }
    
    static {
        EMPTY_COMPOUNDS = new CompoundTag[0];
    }
    
    @Override
    public void write(final ByteBuf lllllllllllllIllIIIlIIlIlllIIIII, final Chunk lllllllllllllIllIIIlIIlIllIlllll) throws Exception {
        lllllllllllllIllIIIlIIlIlllIIIII.writeInt(lllllllllllllIllIIIlIIlIllIlllll.getX());
        lllllllllllllIllIIIlIIlIlllIIIII.writeInt(lllllllllllllIllIIIlIIlIllIlllll.getZ());
        lllllllllllllIllIIIlIIlIlllIIIII.writeBoolean(lllllllllllllIllIIIlIIlIllIlllll.isFullChunk());
        lllllllllllllIllIIIlIIlIlllIIIII.writeBoolean(lllllllllllllIllIIIlIIlIllIlllll.isIgnoreOldLightData());
        Type.VAR_INT.writePrimitive(lllllllllllllIllIIIlIIlIlllIIIII, lllllllllllllIllIIIlIIlIllIlllll.getBitmask());
        Type.NBT.write(lllllllllllllIllIIIlIIlIlllIIIII, lllllllllllllIllIIIlIIlIllIlllll.getHeightMap());
        if (lllllllllllllIllIIIlIIlIllIlllll.isBiomeData()) {
            for (final int lllllllllllllIllIIIlIIlIlllIIlll : lllllllllllllIllIIIlIIlIllIlllll.getBiomeData()) {
                lllllllllllllIllIIIlIIlIlllIIIII.writeInt(lllllllllllllIllIIIlIIlIlllIIlll);
            }
        }
        final ByteBuf lllllllllllllIllIIIlIIlIlllIIIIl = lllllllllllllIllIIIlIIlIlllIIIII.alloc().buffer();
        try {
            for (int lllllllllllllIllIIIlIIlIlllIIlIl = 0; lllllllllllllIllIIIlIIlIlllIIlIl < 16; ++lllllllllllllIllIIIlIIlIlllIIlIl) {
                final ChunkSection lllllllllllllIllIIIlIIlIlllIIllI = lllllllllllllIllIIIlIIlIllIlllll.getSections()[lllllllllllllIllIIIlIIlIlllIIlIl];
                if (lllllllllllllIllIIIlIIlIlllIIllI != null) {
                    lllllllllllllIllIIIlIIlIlllIIIIl.writeShort(lllllllllllllIllIIIlIIlIlllIIllI.getNonAirBlocksCount());
                    Types1_16.CHUNK_SECTION.write(lllllllllllllIllIIIlIIlIlllIIIIl, lllllllllllllIllIIIlIIlIlllIIllI);
                }
            }
            lllllllllllllIllIIIlIIlIlllIIIIl.readerIndex(0);
            Type.VAR_INT.writePrimitive(lllllllllllllIllIIIlIIlIlllIIIII, lllllllllllllIllIIIlIIlIlllIIIIl.readableBytes());
            lllllllllllllIllIIIlIIlIlllIIIII.writeBytes(lllllllllllllIllIIIlIIlIlllIIIIl);
        }
        finally {
            lllllllllllllIllIIIlIIlIlllIIIIl.release();
        }
        Type.NBT_ARRAY.write(lllllllllllllIllIIIlIIlIlllIIIII, lllllllllllllIllIIIlIIlIllIlllll.getBlockEntities().toArray(Chunk1_16Type.EMPTY_COMPOUNDS));
    }
    
    @Override
    public Chunk read(final ByteBuf lllllllllllllIllIIIlIIlIlllllIlI) throws Exception {
        final int lllllllllllllIllIIIlIIllIIIIIIll = lllllllllllllIllIIIlIIlIlllllIlI.readInt();
        final int lllllllllllllIllIIIlIIllIIIIIIlI = lllllllllllllIllIIIlIIlIlllllIlI.readInt();
        final boolean lllllllllllllIllIIIlIIllIIIIIIIl = lllllllllllllIllIIIlIIlIlllllIlI.readBoolean();
        final boolean lllllllllllllIllIIIlIIllIIIIIIII = lllllllllllllIllIIIlIIlIlllllIlI.readBoolean();
        final int lllllllllllllIllIIIlIIlIllllllll = Type.VAR_INT.readPrimitive(lllllllllllllIllIIIlIIlIlllllIlI);
        final CompoundTag lllllllllllllIllIIIlIIlIlllllllI = Type.NBT.read(lllllllllllllIllIIIlIIlIlllllIlI);
        final int[] lllllllllllllIllIIIlIIlIllllllIl = (int[])(lllllllllllllIllIIIlIIllIIIIIIIl ? new int[1024] : null);
        if (lllllllllllllIllIIIlIIllIIIIIIIl) {
            for (int lllllllllllllIllIIIlIIllIIIIlIlI = 0; lllllllllllllIllIIIlIIllIIIIlIlI < 1024; ++lllllllllllllIllIIIlIIllIIIIlIlI) {
                lllllllllllllIllIIIlIIlIllllllIl[lllllllllllllIllIIIlIIllIIIIlIlI] = lllllllllllllIllIIIlIIlIlllllIlI.readInt();
            }
        }
        Type.VAR_INT.readPrimitive(lllllllllllllIllIIIlIIlIlllllIlI);
        final ChunkSection[] lllllllllllllIllIIIlIIlIllllllII = new ChunkSection[16];
        for (int lllllllllllllIllIIIlIIllIIIIIlll = 0; lllllllllllllIllIIIlIIllIIIIIlll < 16; ++lllllllllllllIllIIIlIIllIIIIIlll) {
            if ((lllllllllllllIllIIIlIIlIllllllll & 1 << lllllllllllllIllIIIlIIllIIIIIlll) != 0x0) {
                final short lllllllllllllIllIIIlIIllIIIIlIIl = lllllllllllllIllIIIlIIlIlllllIlI.readShort();
                final ChunkSection lllllllllllllIllIIIlIIllIIIIlIII = Types1_16.CHUNK_SECTION.read(lllllllllllllIllIIIlIIlIlllllIlI);
                lllllllllllllIllIIIlIIllIIIIlIII.setNonAirBlocksCount(lllllllllllllIllIIIlIIllIIIIlIIl);
                lllllllllllllIllIIIlIIlIllllllII[lllllllllllllIllIIIlIIllIIIIIlll] = lllllllllllllIllIIIlIIllIIIIlIII;
            }
        }
        final List<CompoundTag> lllllllllllllIllIIIlIIlIlllllIll = new ArrayList<CompoundTag>(Arrays.asList((CompoundTag[])Type.NBT_ARRAY.read(lllllllllllllIllIIIlIIlIlllllIlI)));
        if (lllllllllllllIllIIIlIIlIlllllIlI.readableBytes() > 0) {
            final byte[] lllllllllllllIllIIIlIIllIIIIIllI = Type.REMAINING_BYTES.read(lllllllllllllIllIIIlIIlIlllllIlI);
            if (Via.getManager().isDebug()) {
                Via.getPlatform().getLogger().warning(String.valueOf(new StringBuilder().append("Found ").append(lllllllllllllIllIIIlIIllIIIIIllI.length).append(" more bytes than expected while reading the chunk: ").append(lllllllllllllIllIIIlIIllIIIIIIll).append("/").append(lllllllllllllIllIIIlIIllIIIIIIlI)));
            }
        }
        return new BaseChunk(lllllllllllllIllIIIlIIllIIIIIIll, lllllllllllllIllIIIlIIllIIIIIIlI, lllllllllllllIllIIIlIIllIIIIIIIl, lllllllllllllIllIIIlIIllIIIIIIII, lllllllllllllIllIIIlIIlIllllllll, lllllllllllllIllIIIlIIlIllllllII, lllllllllllllIllIIIlIIlIllllllIl, lllllllllllllIllIIIlIIlIlllllllI, lllllllllllllIllIIIlIIlIlllllIll);
    }
}
