package com.viaversion.viaversion.protocols.protocol1_17to1_16_4.types;

import com.viaversion.viaversion.api.type.*;
import com.viaversion.viaversion.libs.opennbt.tag.builtin.*;
import io.netty.buffer.*;
import com.viaversion.viaversion.api.type.types.version.*;
import com.viaversion.viaversion.api.type.types.minecraft.*;
import com.viaversion.viaversion.api.*;
import com.viaversion.viaversion.api.minecraft.chunks.*;
import java.util.*;
import com.google.common.base.*;

public final class Chunk1_17Type extends Type<Chunk>
{
    private final /* synthetic */ int ySectionCount;
    private static final /* synthetic */ CompoundTag[] EMPTY_COMPOUNDS;
    
    @Override
    public void write(final ByteBuf lllllllllllllllllIlllIIllllIllIl, final Chunk lllllllllllllllllIlllIIllllIllll) throws Exception {
        lllllllllllllllllIlllIIllllIllIl.writeInt(lllllllllllllllllIlllIIllllIllll.getX());
        lllllllllllllllllIlllIIllllIllIl.writeInt(lllllllllllllllllIlllIIllllIllll.getZ());
        Type.LONG_ARRAY_PRIMITIVE.write(lllllllllllllllllIlllIIllllIllIl, lllllllllllllllllIlllIIllllIllll.getChunkMask().toLongArray());
        Type.NBT.write(lllllllllllllllllIlllIIllllIllIl, lllllllllllllllllIlllIIllllIllll.getHeightMap());
        Type.VAR_INT_ARRAY_PRIMITIVE.write(lllllllllllllllllIlllIIllllIllIl, lllllllllllllllllIlllIIllllIllll.getBiomeData());
        final ByteBuf lllllllllllllllllIlllIIllllIlllI = lllllllllllllllllIlllIIllllIllIl.alloc().buffer();
        try {
            final boolean lllllllllllllllllIlllIIllllIlIIl;
            final ChunkSection[] lllllllllllllllllIlllIIlllllIIlI = (Object)(lllllllllllllllllIlllIIllllIlIIl = (boolean)(Object)lllllllllllllllllIlllIIllllIllll.getSections());
            final String lllllllllllllllllIlllIIllllIlIII = (String)lllllllllllllllllIlllIIllllIlIIl.length;
            for (boolean lllllllllllllllllIlllIIllllIIlll = false; lllllllllllllllllIlllIIllllIIlll < lllllllllllllllllIlllIIllllIlIII; ++lllllllllllllllllIlllIIllllIIlll) {
                final ChunkSection lllllllllllllllllIlllIIlllllIIll = lllllllllllllllllIlllIIllllIlIIl[lllllllllllllllllIlllIIllllIIlll];
                if (lllllllllllllllllIlllIIlllllIIll != null) {
                    lllllllllllllllllIlllIIllllIlllI.writeShort(lllllllllllllllllIlllIIlllllIIll.getNonAirBlocksCount());
                    Types1_16.CHUNK_SECTION.write(lllllllllllllllllIlllIIllllIlllI, lllllllllllllllllIlllIIlllllIIll);
                }
            }
            lllllllllllllllllIlllIIllllIlllI.readerIndex(0);
            Type.VAR_INT.writePrimitive(lllllllllllllllllIlllIIllllIllIl, lllllllllllllllllIlllIIllllIlllI.readableBytes());
            lllllllllllllllllIlllIIllllIllIl.writeBytes(lllllllllllllllllIlllIIllllIlllI);
        }
        finally {
            lllllllllllllllllIlllIIllllIlllI.release();
        }
        Type.NBT_ARRAY.write(lllllllllllllllllIlllIIllllIllIl, lllllllllllllllllIlllIIllllIllll.getBlockEntities().toArray(Chunk1_17Type.EMPTY_COMPOUNDS));
    }
    
    @Override
    public Class<? extends Type> getBaseClass() {
        return BaseChunkType.class;
    }
    
    static {
        EMPTY_COMPOUNDS = new CompoundTag[0];
    }
    
    @Override
    public Chunk read(final ByteBuf lllllllllllllllllIlllIlIIIIIIllI) throws Exception {
        final int lllllllllllllllllIlllIlIIIIIlllI = lllllllllllllllllIlllIlIIIIIIllI.readInt();
        final int lllllllllllllllllIlllIlIIIIIllIl = lllllllllllllllllIlllIlIIIIIIllI.readInt();
        final BitSet lllllllllllllllllIlllIlIIIIIllII = BitSet.valueOf(Type.LONG_ARRAY_PRIMITIVE.read(lllllllllllllllllIlllIlIIIIIIllI));
        final CompoundTag lllllllllllllllllIlllIlIIIIIlIll = Type.NBT.read(lllllllllllllllllIlllIlIIIIIIllI);
        final int[] lllllllllllllllllIlllIlIIIIIlIlI = Type.VAR_INT_ARRAY_PRIMITIVE.read(lllllllllllllllllIlllIlIIIIIIllI);
        Type.VAR_INT.readPrimitive(lllllllllllllllllIlllIlIIIIIIllI);
        final ChunkSection[] lllllllllllllllllIlllIlIIIIIlIIl = new ChunkSection[this.ySectionCount];
        for (int lllllllllllllllllIlllIlIIIIlIIlI = 0; lllllllllllllllllIlllIlIIIIlIIlI < this.ySectionCount; ++lllllllllllllllllIlllIlIIIIlIIlI) {
            if (lllllllllllllllllIlllIlIIIIIllII.get(lllllllllllllllllIlllIlIIIIlIIlI)) {
                final short lllllllllllllllllIlllIlIIIIlIlII = lllllllllllllllllIlllIlIIIIIIllI.readShort();
                final ChunkSection lllllllllllllllllIlllIlIIIIlIIll = Types1_16.CHUNK_SECTION.read(lllllllllllllllllIlllIlIIIIIIllI);
                lllllllllllllllllIlllIlIIIIlIIll.setNonAirBlocksCount(lllllllllllllllllIlllIlIIIIlIlII);
                lllllllllllllllllIlllIlIIIIIlIIl[lllllllllllllllllIlllIlIIIIlIIlI] = lllllllllllllllllIlllIlIIIIlIIll;
            }
        }
        final List<CompoundTag> lllllllllllllllllIlllIlIIIIIlIII = new ArrayList<CompoundTag>(Arrays.asList((CompoundTag[])Type.NBT_ARRAY.read(lllllllllllllllllIlllIlIIIIIIllI)));
        if (lllllllllllllllllIlllIlIIIIIIllI.readableBytes() > 0) {
            final byte[] lllllllllllllllllIlllIlIIIIlIIIl = Type.REMAINING_BYTES.read(lllllllllllllllllIlllIlIIIIIIllI);
            if (Via.getManager().isDebug()) {
                Via.getPlatform().getLogger().warning(String.valueOf(new StringBuilder().append("Found ").append(lllllllllllllllllIlllIlIIIIlIIIl.length).append(" more bytes than expected while reading the chunk: ").append(lllllllllllllllllIlllIlIIIIIlllI).append("/").append(lllllllllllllllllIlllIlIIIIIllIl)));
            }
        }
        return new BaseChunk(lllllllllllllllllIlllIlIIIIIlllI, lllllllllllllllllIlllIlIIIIIllIl, true, false, lllllllllllllllllIlllIlIIIIIllII, lllllllllllllllllIlllIlIIIIIlIIl, lllllllllllllllllIlllIlIIIIIlIlI, lllllllllllllllllIlllIlIIIIIlIll, lllllllllllllllllIlllIlIIIIIlIII);
    }
    
    public Chunk1_17Type(final int lllllllllllllllllIlllIlIIIlIIIlI) {
        super(Chunk.class);
        Preconditions.checkArgument(lllllllllllllllllIlllIlIIIlIIIlI > 0);
        this.ySectionCount = lllllllllllllllllIlllIlIIIlIIIlI;
    }
}
