package com.viaversion.viaversion.protocols.protocol1_9_1_2to1_9_3_4.types;

import com.viaversion.viaversion.protocols.protocol1_9_3to1_9_1_2.storage.*;
import io.netty.buffer.*;
import com.viaversion.viaversion.api.type.*;
import com.viaversion.viaversion.api.type.types.version.*;
import com.viaversion.viaversion.api.minecraft.*;
import com.viaversion.viaversion.libs.opennbt.tag.builtin.*;
import com.viaversion.viaversion.api.*;
import com.viaversion.viaversion.api.minecraft.chunks.*;
import java.util.*;
import com.viaversion.viaversion.api.type.types.minecraft.*;

public class Chunk1_9_3_4Type extends PartialType<Chunk, ClientWorld>
{
    public Chunk1_9_3_4Type(final ClientWorld lllllllllllllIIlIlIlllllIlllllIl) {
        super(lllllllllllllIIlIlIlllllIlllllIl, Chunk.class);
    }
    
    @Override
    public Chunk read(final ByteBuf lllllllllllllIIlIlIlllllIllIllIl, final ClientWorld lllllllllllllIIlIlIlllllIllIIIll) throws Exception {
        final int lllllllllllllIIlIlIlllllIllIlIll = lllllllllllllIIlIlIlllllIllIllIl.readInt();
        final int lllllllllllllIIlIlIlllllIllIlIlI = lllllllllllllIIlIlIlllllIllIllIl.readInt();
        final boolean lllllllllllllIIlIlIlllllIllIlIIl = lllllllllllllIIlIlIlllllIllIllIl.readBoolean();
        final int lllllllllllllIIlIlIlllllIllIlIII = Type.VAR_INT.readPrimitive(lllllllllllllIIlIlIlllllIllIllIl);
        Type.VAR_INT.readPrimitive(lllllllllllllIIlIlIlllllIllIllIl);
        final ChunkSection[] lllllllllllllIIlIlIlllllIllIIlll = new ChunkSection[16];
        for (int lllllllllllllIIlIlIlllllIlllIIIl = 0; lllllllllllllIIlIlIlllllIlllIIIl < 16; ++lllllllllllllIIlIlIlllllIlllIIIl) {
            if ((lllllllllllllIIlIlIlllllIllIlIII & 1 << lllllllllllllIIlIlIlllllIlllIIIl) != 0x0) {
                final ChunkSection lllllllllllllIIlIlIlllllIlllIIlI = Types1_9.CHUNK_SECTION.read(lllllllllllllIIlIlIlllllIllIllIl);
                lllllllllllllIIlIlIlllllIllIIlll[lllllllllllllIIlIlIlllllIlllIIIl] = lllllllllllllIIlIlIlllllIlllIIlI;
                lllllllllllllIIlIlIlllllIlllIIlI.getLight().readBlockLight(lllllllllllllIIlIlIlllllIllIllIl);
                if (lllllllllllllIIlIlIlllllIllIIIll.getEnvironment() == Environment.NORMAL) {
                    lllllllllllllIIlIlIlllllIlllIIlI.getLight().readSkyLight(lllllllllllllIIlIlIlllllIllIllIl);
                }
            }
        }
        final int[] lllllllllllllIIlIlIlllllIllIIllI = (int[])(lllllllllllllIIlIlIlllllIllIlIIl ? new int[256] : null);
        if (lllllllllllllIIlIlIlllllIllIlIIl) {
            for (int lllllllllllllIIlIlIlllllIlllIIII = 0; lllllllllllllIIlIlIlllllIlllIIII < 256; ++lllllllllllllIIlIlIlllllIlllIIII) {
                lllllllllllllIIlIlIlllllIllIIllI[lllllllllllllIIlIlIlllllIlllIIII] = (lllllllllllllIIlIlIlllllIllIllIl.readByte() & 0xFF);
            }
        }
        final List<CompoundTag> lllllllllllllIIlIlIlllllIllIIlIl = new ArrayList<CompoundTag>(Arrays.asList((CompoundTag[])Type.NBT_ARRAY.read(lllllllllllllIIlIlIlllllIllIllIl)));
        if (lllllllllllllIIlIlIlllllIllIllIl.readableBytes() > 0) {
            final byte[] lllllllllllllIIlIlIlllllIllIllll = Type.REMAINING_BYTES.read(lllllllllllllIIlIlIlllllIllIllIl);
            if (Via.getManager().isDebug()) {
                Via.getPlatform().getLogger().warning(String.valueOf(new StringBuilder().append("Found ").append(lllllllllllllIIlIlIlllllIllIllll.length).append(" more bytes than expected while reading the chunk: ").append(lllllllllllllIIlIlIlllllIllIlIll).append("/").append(lllllllllllllIIlIlIlllllIllIlIlI)));
            }
        }
        return new BaseChunk(lllllllllllllIIlIlIlllllIllIlIll, lllllllllllllIIlIlIlllllIllIlIlI, lllllllllllllIIlIlIlllllIllIlIIl, false, lllllllllllllIIlIlIlllllIllIlIII, lllllllllllllIIlIlIlllllIllIIlll, lllllllllllllIIlIlIlllllIllIIllI, lllllllllllllIIlIlIlllllIllIIlIl);
    }
    
    @Override
    public void write(final ByteBuf lllllllllllllIIlIlIlllllIlIIllll, final ClientWorld lllllllllllllIIlIlIlllllIlIIlllI, final Chunk lllllllllllllIIlIlIlllllIlIIllIl) throws Exception {
        lllllllllllllIIlIlIlllllIlIIllll.writeInt(lllllllllllllIIlIlIlllllIlIIllIl.getX());
        lllllllllllllIIlIlIlllllIlIIllll.writeInt(lllllllllllllIIlIlIlllllIlIIllIl.getZ());
        lllllllllllllIIlIlIlllllIlIIllll.writeBoolean(lllllllllllllIIlIlIlllllIlIIllIl.isFullChunk());
        Type.VAR_INT.writePrimitive(lllllllllllllIIlIlIlllllIlIIllll, lllllllllllllIIlIlIlllllIlIIllIl.getBitmask());
        final ByteBuf lllllllllllllIIlIlIlllllIlIIllII = lllllllllllllIIlIlIlllllIlIIllll.alloc().buffer();
        try {
            for (int lllllllllllllIIlIlIlllllIlIlIIlI = 0; lllllllllllllIIlIlIlllllIlIlIIlI < 16; ++lllllllllllllIIlIlIlllllIlIlIIlI) {
                final ChunkSection lllllllllllllIIlIlIlllllIlIlIIll = lllllllllllllIIlIlIlllllIlIIllIl.getSections()[lllllllllllllIIlIlIlllllIlIlIIlI];
                if (lllllllllllllIIlIlIlllllIlIlIIll != null) {
                    Types1_9.CHUNK_SECTION.write(lllllllllllllIIlIlIlllllIlIIllII, lllllllllllllIIlIlIlllllIlIlIIll);
                    lllllllllllllIIlIlIlllllIlIlIIll.getLight().writeBlockLight(lllllllllllllIIlIlIlllllIlIIllII);
                    if (lllllllllllllIIlIlIlllllIlIlIIll.getLight().hasSkyLight()) {
                        lllllllllllllIIlIlIlllllIlIlIIll.getLight().writeSkyLight(lllllllllllllIIlIlIlllllIlIIllII);
                    }
                }
            }
            lllllllllllllIIlIlIlllllIlIIllII.readerIndex(0);
            Type.VAR_INT.writePrimitive(lllllllllllllIIlIlIlllllIlIIllll, lllllllllllllIIlIlIlllllIlIIllII.readableBytes() + (lllllllllllllIIlIlIlllllIlIIllIl.isBiomeData() ? 256 : 0));
            lllllllllllllIIlIlIlllllIlIIllll.writeBytes(lllllllllllllIIlIlIlllllIlIIllII);
        }
        finally {
            lllllllllllllIIlIlIlllllIlIIllII.release();
        }
        if (lllllllllllllIIlIlIlllllIlIIllIl.isBiomeData()) {
            for (final int lllllllllllllIIlIlIlllllIlIlIIIl : lllllllllllllIIlIlIlllllIlIIllIl.getBiomeData()) {
                lllllllllllllIIlIlIlllllIlIIllll.writeByte((int)(byte)lllllllllllllIIlIlIlllllIlIlIIIl);
            }
        }
        Type.NBT_ARRAY.write(lllllllllllllIIlIlIlllllIlIIllll, lllllllllllllIIlIlIlllllIlIIllIl.getBlockEntities().toArray(new CompoundTag[0]));
    }
    
    @Override
    public Class<? extends Type> getBaseClass() {
        return BaseChunkType.class;
    }
}
