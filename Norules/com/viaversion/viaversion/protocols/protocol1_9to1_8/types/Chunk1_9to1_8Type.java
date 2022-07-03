package com.viaversion.viaversion.protocols.protocol1_9to1_8.types;

import com.viaversion.viaversion.protocols.protocol1_9to1_8.storage.*;
import com.viaversion.viaversion.api.type.*;
import com.viaversion.viaversion.api.type.types.minecraft.*;
import io.netty.buffer.*;
import com.viaversion.viaversion.api.minecraft.chunks.*;
import com.viaversion.viaversion.protocols.protocol1_10to1_9_3.*;
import com.viaversion.viaversion.api.protocol.*;
import com.viaversion.viaversion.api.*;
import com.viaversion.viaversion.api.type.types.version.*;
import java.util.logging.*;
import com.viaversion.viaversion.libs.opennbt.tag.builtin.*;
import java.util.*;

public class Chunk1_9to1_8Type extends PartialType<Chunk, ClientChunks>
{
    @Override
    public Class<? extends Type> getBaseClass() {
        return BaseChunkType.class;
    }
    
    @Override
    public void write(final ByteBuf lllllllllllllIIIIlIllllIIllIIlII, final ClientChunks lllllllllllllIIIIlIllllIIllIIIll, final Chunk lllllllllllllIIIIlIllllIIlIllllI) throws Exception {
        if (!(lllllllllllllIIIIlIllllIIlIllllI instanceof Chunk1_8)) {
            throw new Exception(String.valueOf(new StringBuilder().append("Incompatible chunk, ").append(lllllllllllllIIIIlIllllIIlIllllI.getClass())));
        }
        final Chunk1_8 lllllllllllllIIIIlIllllIIllIIIIl = (Chunk1_8)lllllllllllllIIIIlIllllIIlIllllI;
        lllllllllllllIIIIlIllllIIllIIlII.writeInt(lllllllllllllIIIIlIllllIIllIIIIl.getX());
        lllllllllllllIIIIlIllllIIllIIlII.writeInt(lllllllllllllIIIIlIllllIIllIIIIl.getZ());
        if (lllllllllllllIIIIlIllllIIllIIIIl.isUnloadPacket()) {
            return;
        }
        lllllllllllllIIIIlIllllIIllIIlII.writeByte((int)(lllllllllllllIIIIlIllllIIllIIIIl.isFullChunk() ? 1 : 0));
        Type.VAR_INT.writePrimitive(lllllllllllllIIIIlIllllIIllIIlII, lllllllllllllIIIIlIllllIIllIIIIl.getBitmask());
        final ByteBuf lllllllllllllIIIIlIllllIIllIIIII = lllllllllllllIIIIlIllllIIllIIlII.alloc().buffer();
        try {
            for (int lllllllllllllIIIIlIllllIIllIIlll = 0; lllllllllllllIIIIlIllllIIllIIlll < 16; ++lllllllllllllIIIIlIllllIIllIIlll) {
                final ChunkSection lllllllllllllIIIIlIllllIIllIlIII = lllllllllllllIIIIlIllllIIllIIIIl.getSections()[lllllllllllllIIIIlIllllIIllIIlll];
                if (lllllllllllllIIIIlIllllIIllIlIII != null) {
                    Types1_9.CHUNK_SECTION.write(lllllllllllllIIIIlIllllIIllIIIII, lllllllllllllIIIIlIllllIIllIlIII);
                    lllllllllllllIIIIlIllllIIllIlIII.getLight().writeBlockLight(lllllllllllllIIIIlIllllIIllIIIII);
                    if (lllllllllllllIIIIlIllllIIllIlIII.getLight().hasSkyLight()) {
                        lllllllllllllIIIIlIllllIIllIlIII.getLight().writeSkyLight(lllllllllllllIIIIlIllllIIllIIIII);
                    }
                }
            }
            lllllllllllllIIIIlIllllIIllIIIII.readerIndex(0);
            Type.VAR_INT.writePrimitive(lllllllllllllIIIIlIllllIIllIIlII, lllllllllllllIIIIlIllllIIllIIIII.readableBytes() + (lllllllllllllIIIIlIllllIIllIIIIl.hasBiomeData() ? 256 : 0));
            lllllllllllllIIIIlIllllIIllIIlII.writeBytes(lllllllllllllIIIIlIllllIIllIIIII);
        }
        finally {
            lllllllllllllIIIIlIllllIIllIIIII.release();
        }
        if (lllllllllllllIIIIlIllllIIllIIIIl.hasBiomeData()) {
            final short lllllllllllllIIIIlIllllIIlIllIll = (Object)lllllllllllllIIIIlIllllIIllIIIIl.getBiomeData();
            final double lllllllllllllIIIIlIllllIIlIllIlI = lllllllllllllIIIIlIllllIIlIllIll.length;
            for (byte lllllllllllllIIIIlIllllIIlIllIIl = 0; lllllllllllllIIIIlIllllIIlIllIIl < lllllllllllllIIIIlIllllIIlIllIlI; ++lllllllllllllIIIIlIllllIIlIllIIl) {
                final int lllllllllllllIIIIlIllllIIllIIllI = lllllllllllllIIIIlIllllIIlIllIll[lllllllllllllIIIIlIllllIIlIllIIl];
                lllllllllllllIIIIlIllllIIllIIlII.writeByte((int)(byte)lllllllllllllIIIIlIllllIIllIIllI);
            }
        }
    }
    
    public Chunk1_9to1_8Type(final ClientChunks lllllllllllllIIIIlIllllIlIllIllI) {
        super(lllllllllllllIIIIlIllllIlIllIllI, Chunk.class);
    }
    
    private static long toLong(final int lllllllllllllIIIIlIllllIlIlIllll, final int lllllllllllllIIIIlIllllIlIlIlllI) {
        return ((long)lllllllllllllIIIIlIllllIlIlIllll << 32) + lllllllllllllIIIIlIllllIlIlIlllI + 2147483648L;
    }
    
    static {
        BIOME_DATA_LENGTH = 256;
        SECTION_SIZE = 16;
        SECTION_COUNT = 16;
    }
    
    @Override
    public Chunk read(final ByteBuf lllllllllllllIIIIlIllllIlIIIIIlI, final ClientChunks lllllllllllllIIIIlIllllIlIIlIIlI) throws Exception {
        final boolean lllllllllllllIIIIlIllllIlIIlIIIl = lllllllllllllIIIIlIllllIlIIlIIlI.getUser().getProtocolInfo().getPipeline().contains(Protocol1_10To1_9_3_4.class) && Via.getConfig().isReplacePistons();
        final int lllllllllllllIIIIlIllllIlIIlIIII = Via.getConfig().getPistonReplacementId();
        final int lllllllllllllIIIIlIllllIlIIIllll = lllllllllllllIIIIlIllllIlIIIIIlI.readInt();
        final int lllllllllllllIIIIlIllllIlIIIlllI = lllllllllllllIIIIlIllllIlIIIIIlI.readInt();
        final long lllllllllllllIIIIlIllllIlIIIllIl = toLong(lllllllllllllIIIIlIllllIlIIIllll, lllllllllllllIIIIlIllllIlIIIlllI);
        final boolean lllllllllllllIIIIlIllllIlIIIllII = lllllllllllllIIIIlIllllIlIIIIIlI.readByte() != 0;
        final int lllllllllllllIIIIlIllllIlIIIlIll = lllllllllllllIIIIlIllllIlIIIIIlI.readUnsignedShort();
        final int lllllllllllllIIIIlIllllIlIIIlIlI = Type.VAR_INT.readPrimitive(lllllllllllllIIIIlIllllIlIIIIIlI);
        final BitSet lllllllllllllIIIIlIllllIlIIIlIIl = new BitSet(16);
        final ChunkSection[] lllllllllllllIIIIlIllllIlIIIlIII = new ChunkSection[16];
        int[] lllllllllllllIIIIlIllllIlIIIIlll = null;
        for (int lllllllllllllIIIIlIllllIlIIllIlI = 0; lllllllllllllIIIIlIllllIlIIllIlI < 16; ++lllllllllllllIIIIlIllllIlIIllIlI) {
            if ((lllllllllllllIIIIlIllllIlIIIlIll & 1 << lllllllllllllIIIIlIllllIlIIllIlI) != 0x0) {
                lllllllllllllIIIIlIllllIlIIIlIIl.set(lllllllllllllIIIIlIllllIlIIllIlI);
            }
        }
        final int lllllllllllllIIIIlIllllIlIIIIllI = lllllllllllllIIIIlIllllIlIIIlIIl.cardinality();
        final boolean lllllllllllllIIIIlIllllIlIIIIlIl = lllllllllllllIIIIlIllllIlIIlIIlI.getBulkChunks().remove(lllllllllllllIIIIlIllllIlIIIllIl);
        if (lllllllllllllIIIIlIllllIlIIIIllI == 0 && lllllllllllllIIIIlIllllIlIIIllII && !lllllllllllllIIIIlIllllIlIIIIlIl && lllllllllllllIIIIlIllllIlIIlIIlI.getLoadedChunks().contains(lllllllllllllIIIIlIllllIlIIIllIl)) {
            lllllllllllllIIIIlIllllIlIIlIIlI.getLoadedChunks().remove(lllllllllllllIIIIlIllllIlIIIllIl);
            return new Chunk1_8(lllllllllllllIIIIlIllllIlIIIllll, lllllllllllllIIIIlIllllIlIIIlllI);
        }
        final int lllllllllllllIIIIlIllllIlIIIIlII = lllllllllllllIIIIlIllllIlIIIIIlI.readerIndex();
        lllllllllllllIIIIlIllllIlIIlIIlI.getLoadedChunks().add(lllllllllllllIIIIlIllllIlIIIllIl);
        for (int lllllllllllllIIIIlIllllIlIIllIII = 0; lllllllllllllIIIIlIllllIlIIllIII < 16; ++lllllllllllllIIIIlIllllIlIIllIII) {
            if (lllllllllllllIIIIlIllllIlIIIlIIl.get(lllllllllllllIIIIlIllllIlIIllIII)) {
                final ChunkSection lllllllllllllIIIIlIllllIlIIllIIl = Types1_8.CHUNK_SECTION.read(lllllllllllllIIIIlIllllIlIIIIIlI);
                lllllllllllllIIIIlIllllIlIIIlIII[lllllllllllllIIIIlIllllIlIIllIII] = lllllllllllllIIIIlIllllIlIIllIIl;
                if (lllllllllllllIIIIlIllllIlIIlIIIl) {
                    lllllllllllllIIIIlIllllIlIIllIIl.replacePaletteEntry(36, lllllllllllllIIIIlIllllIlIIlIIII);
                }
            }
        }
        for (int lllllllllllllIIIIlIllllIlIIlIlll = 0; lllllllllllllIIIIlIllllIlIIlIlll < 16; ++lllllllllllllIIIIlIllllIlIIlIlll) {
            if (lllllllllllllIIIIlIllllIlIIIlIIl.get(lllllllllllllIIIIlIllllIlIIlIlll)) {
                lllllllllllllIIIIlIllllIlIIIlIII[lllllllllllllIIIIlIllllIlIIlIlll].getLight().readBlockLight(lllllllllllllIIIIlIllllIlIIIIIlI);
            }
        }
        int lllllllllllllIIIIlIllllIlIIIIIll = lllllllllllllIIIIlIllllIlIIIlIlI - (lllllllllllllIIIIlIllllIlIIIIIlI.readerIndex() - lllllllllllllIIIIlIllllIlIIIIlII);
        if (lllllllllllllIIIIlIllllIlIIIIIll >= 2048) {
            for (int lllllllllllllIIIIlIllllIlIIlIllI = 0; lllllllllllllIIIIlIllllIlIIlIllI < 16; ++lllllllllllllIIIIlIllllIlIIlIllI) {
                if (lllllllllllllIIIIlIllllIlIIIlIIl.get(lllllllllllllIIIIlIllllIlIIlIllI)) {
                    lllllllllllllIIIIlIllllIlIIIlIII[lllllllllllllIIIIlIllllIlIIlIllI].getLight().readSkyLight(lllllllllllllIIIIlIllllIlIIIIIlI);
                    lllllllllllllIIIIlIllllIlIIIIIll -= 2048;
                }
            }
        }
        if (lllllllllllllIIIIlIllllIlIIIIIll >= 256) {
            lllllllllllllIIIIlIllllIlIIIIlll = new int[256];
            for (int lllllllllllllIIIIlIllllIlIIlIlIl = 0; lllllllllllllIIIIlIllllIlIIlIlIl < 256; ++lllllllllllllIIIIlIllllIlIIlIlIl) {
                lllllllllllllIIIIlIllllIlIIIIlll[lllllllllllllIIIIlIllllIlIIlIlIl] = (lllllllllllllIIIIlIllllIlIIIIIlI.readByte() & 0xFF);
            }
            lllllllllllllIIIIlIllllIlIIIIIll -= 256;
        }
        if (lllllllllllllIIIIlIllllIlIIIIIll > 0) {
            Via.getPlatform().getLogger().log(Level.WARNING, String.valueOf(new StringBuilder().append(lllllllllllllIIIIlIllllIlIIIIIll).append(" Bytes left after reading chunks! (").append(lllllllllllllIIIIlIllllIlIIIllII).append(")")));
        }
        return new Chunk1_8(lllllllllllllIIIIlIllllIlIIIllll, lllllllllllllIIIIlIllllIlIIIlllI, lllllllllllllIIIIlIllllIlIIIllII, lllllllllllllIIIIlIllllIlIIIlIll, lllllllllllllIIIIlIllllIlIIIlIII, lllllllllllllIIIIlIllllIlIIIIlll, new ArrayList<CompoundTag>());
    }
}
