package com.viaversion.viaversion.protocols.protocol1_16_2to1_16_1.types;

import com.viaversion.viaversion.api.type.*;
import com.viaversion.viaversion.libs.opennbt.tag.builtin.*;
import io.netty.buffer.*;
import com.viaversion.viaversion.api.type.types.version.*;
import com.viaversion.viaversion.api.*;
import com.viaversion.viaversion.api.minecraft.chunks.*;
import java.util.*;
import com.viaversion.viaversion.api.type.types.minecraft.*;

public class Chunk1_16_2Type extends Type<Chunk>
{
    private static final /* synthetic */ CompoundTag[] EMPTY_COMPOUNDS;
    
    @Override
    public void write(final ByteBuf lllllllllllllllllllIIIIllIllIllI, final Chunk lllllllllllllllllllIIIIllIllIIlI) throws Exception {
        lllllllllllllllllllIIIIllIllIllI.writeInt(lllllllllllllllllllIIIIllIllIIlI.getX());
        lllllllllllllllllllIIIIllIllIllI.writeInt(lllllllllllllllllllIIIIllIllIIlI.getZ());
        lllllllllllllllllllIIIIllIllIllI.writeBoolean(lllllllllllllllllllIIIIllIllIIlI.isFullChunk());
        Type.VAR_INT.writePrimitive(lllllllllllllllllllIIIIllIllIllI, lllllllllllllllllllIIIIllIllIIlI.getBitmask());
        Type.NBT.write(lllllllllllllllllllIIIIllIllIllI, lllllllllllllllllllIIIIllIllIIlI.getHeightMap());
        if (lllllllllllllllllllIIIIllIllIIlI.isBiomeData()) {
            Type.VAR_INT_ARRAY_PRIMITIVE.write(lllllllllllllllllllIIIIllIllIllI, lllllllllllllllllllIIIIllIllIIlI.getBiomeData());
        }
        final ByteBuf lllllllllllllllllllIIIIllIllIlII = lllllllllllllllllllIIIIllIllIllI.alloc().buffer();
        try {
            for (int lllllllllllllllllllIIIIllIlllIII = 0; lllllllllllllllllllIIIIllIlllIII < 16; ++lllllllllllllllllllIIIIllIlllIII) {
                final ChunkSection lllllllllllllllllllIIIIllIlllIIl = lllllllllllllllllllIIIIllIllIIlI.getSections()[lllllllllllllllllllIIIIllIlllIII];
                if (lllllllllllllllllllIIIIllIlllIIl != null) {
                    lllllllllllllllllllIIIIllIllIlII.writeShort(lllllllllllllllllllIIIIllIlllIIl.getNonAirBlocksCount());
                    Types1_16.CHUNK_SECTION.write(lllllllllllllllllllIIIIllIllIlII, lllllllllllllllllllIIIIllIlllIIl);
                }
            }
            lllllllllllllllllllIIIIllIllIlII.readerIndex(0);
            Type.VAR_INT.writePrimitive(lllllllllllllllllllIIIIllIllIllI, lllllllllllllllllllIIIIllIllIlII.readableBytes());
            lllllllllllllllllllIIIIllIllIllI.writeBytes(lllllllllllllllllllIIIIllIllIlII);
        }
        finally {
            lllllllllllllllllllIIIIllIllIlII.release();
        }
        Type.NBT_ARRAY.write(lllllllllllllllllllIIIIllIllIllI, lllllllllllllllllllIIIIllIllIIlI.getBlockEntities().toArray(Chunk1_16_2Type.EMPTY_COMPOUNDS));
    }
    
    public Chunk1_16_2Type() {
        super(Chunk.class);
    }
    
    @Override
    public Chunk read(final ByteBuf lllllllllllllllllllIIIIlllIlIIll) throws Exception {
        final int lllllllllllllllllllIIIIlllIlIIlI = lllllllllllllllllllIIIIlllIlIIll.readInt();
        final int lllllllllllllllllllIIIIlllIlIIIl = lllllllllllllllllllIIIIlllIlIIll.readInt();
        final boolean lllllllllllllllllllIIIIlllIlIIII = lllllllllllllllllllIIIIlllIlIIll.readBoolean();
        final int lllllllllllllllllllIIIIlllIIllll = Type.VAR_INT.readPrimitive(lllllllllllllllllllIIIIlllIlIIll);
        final CompoundTag lllllllllllllllllllIIIIlllIIlllI = Type.NBT.read(lllllllllllllllllllIIIIlllIlIIll);
        int[] lllllllllllllllllllIIIIlllIIllIl = null;
        if (lllllllllllllllllllIIIIlllIlIIII) {
            lllllllllllllllllllIIIIlllIIllIl = Type.VAR_INT_ARRAY_PRIMITIVE.read(lllllllllllllllllllIIIIlllIlIIll);
        }
        Type.VAR_INT.readPrimitive(lllllllllllllllllllIIIIlllIlIIll);
        final ChunkSection[] lllllllllllllllllllIIIIlllIIllII = new ChunkSection[16];
        for (int lllllllllllllllllllIIIIlllIlIllI = 0; lllllllllllllllllllIIIIlllIlIllI < 16; ++lllllllllllllllllllIIIIlllIlIllI) {
            if ((lllllllllllllllllllIIIIlllIIllll & 1 << lllllllllllllllllllIIIIlllIlIllI) != 0x0) {
                final short lllllllllllllllllllIIIIlllIllIII = lllllllllllllllllllIIIIlllIlIIll.readShort();
                final ChunkSection lllllllllllllllllllIIIIlllIlIlll = Types1_16.CHUNK_SECTION.read(lllllllllllllllllllIIIIlllIlIIll);
                lllllllllllllllllllIIIIlllIlIlll.setNonAirBlocksCount(lllllllllllllllllllIIIIlllIllIII);
                lllllllllllllllllllIIIIlllIIllII[lllllllllllllllllllIIIIlllIlIllI] = lllllllllllllllllllIIIIlllIlIlll;
            }
        }
        final List<CompoundTag> lllllllllllllllllllIIIIlllIIlIll = new ArrayList<CompoundTag>(Arrays.asList((CompoundTag[])Type.NBT_ARRAY.read(lllllllllllllllllllIIIIlllIlIIll)));
        if (lllllllllllllllllllIIIIlllIlIIll.readableBytes() > 0) {
            final byte[] lllllllllllllllllllIIIIlllIlIlIl = Type.REMAINING_BYTES.read(lllllllllllllllllllIIIIlllIlIIll);
            if (Via.getManager().isDebug()) {
                Via.getPlatform().getLogger().warning(String.valueOf(new StringBuilder().append("Found ").append(lllllllllllllllllllIIIIlllIlIlIl.length).append(" more bytes than expected while reading the chunk: ").append(lllllllllllllllllllIIIIlllIlIIlI).append("/").append(lllllllllllllllllllIIIIlllIlIIIl)));
            }
        }
        return new BaseChunk(lllllllllllllllllllIIIIlllIlIIlI, lllllllllllllllllllIIIIlllIlIIIl, lllllllllllllllllllIIIIlllIlIIII, false, lllllllllllllllllllIIIIlllIIllll, lllllllllllllllllllIIIIlllIIllII, lllllllllllllllllllIIIIlllIIllIl, lllllllllllllllllllIIIIlllIIlllI, lllllllllllllllllllIIIIlllIIlIll);
    }
    
    @Override
    public Class<? extends Type> getBaseClass() {
        return BaseChunkType.class;
    }
    
    static {
        EMPTY_COMPOUNDS = new CompoundTag[0];
    }
}
