package com.viaversion.viaversion.protocols.protocol1_9_3to1_9_1_2.types;

import com.viaversion.viaversion.protocols.protocol1_9_3to1_9_1_2.storage.*;
import com.viaversion.viaversion.api.type.*;
import com.viaversion.viaversion.api.type.types.minecraft.*;
import io.netty.buffer.*;
import com.viaversion.viaversion.api.type.types.version.*;
import com.viaversion.viaversion.protocols.protocol1_10to1_9_3.*;
import com.viaversion.viaversion.api.protocol.*;
import com.viaversion.viaversion.api.*;
import com.viaversion.viaversion.api.minecraft.*;
import com.viaversion.viaversion.libs.opennbt.tag.builtin.*;
import com.viaversion.viaversion.api.minecraft.chunks.*;
import java.util.*;

public class Chunk1_9_1_2Type extends PartialType<Chunk, ClientWorld>
{
    @Override
    public Class<? extends Type> getBaseClass() {
        return BaseChunkType.class;
    }
    
    public Chunk1_9_1_2Type(final ClientWorld lllllllllllllIlllIIIIlIIIllIlIIl) {
        super(lllllllllllllIlllIIIIlIIIllIlIIl, Chunk.class);
    }
    
    @Override
    public void write(final ByteBuf lllllllllllllIlllIIIIlIIIIIlllll, final ClientWorld lllllllllllllIlllIIIIlIIIIlIIIlI, final Chunk lllllllllllllIlllIIIIlIIIIlIIIIl) throws Exception {
        lllllllllllllIlllIIIIlIIIIIlllll.writeInt(lllllllllllllIlllIIIIlIIIIlIIIIl.getX());
        lllllllllllllIlllIIIIlIIIIIlllll.writeInt(lllllllllllllIlllIIIIlIIIIlIIIIl.getZ());
        lllllllllllllIlllIIIIlIIIIIlllll.writeBoolean(lllllllllllllIlllIIIIlIIIIlIIIIl.isFullChunk());
        Type.VAR_INT.writePrimitive(lllllllllllllIlllIIIIlIIIIIlllll, lllllllllllllIlllIIIIlIIIIlIIIIl.getBitmask());
        final ByteBuf lllllllllllllIlllIIIIlIIIIlIIIII = lllllllllllllIlllIIIIlIIIIIlllll.alloc().buffer();
        try {
            for (int lllllllllllllIlllIIIIlIIIIlIIllI = 0; lllllllllllllIlllIIIIlIIIIlIIllI < 16; ++lllllllllllllIlllIIIIlIIIIlIIllI) {
                final ChunkSection lllllllllllllIlllIIIIlIIIIlIIlll = lllllllllllllIlllIIIIlIIIIlIIIIl.getSections()[lllllllllllllIlllIIIIlIIIIlIIllI];
                if (lllllllllllllIlllIIIIlIIIIlIIlll != null) {
                    Types1_9.CHUNK_SECTION.write(lllllllllllllIlllIIIIlIIIIlIIIII, lllllllllllllIlllIIIIlIIIIlIIlll);
                    lllllllllllllIlllIIIIlIIIIlIIlll.getLight().writeBlockLight(lllllllllllllIlllIIIIlIIIIlIIIII);
                    if (lllllllllllllIlllIIIIlIIIIlIIlll.getLight().hasSkyLight()) {
                        lllllllllllllIlllIIIIlIIIIlIIlll.getLight().writeSkyLight(lllllllllllllIlllIIIIlIIIIlIIIII);
                    }
                }
            }
            lllllllllllllIlllIIIIlIIIIlIIIII.readerIndex(0);
            Type.VAR_INT.writePrimitive(lllllllllllllIlllIIIIlIIIIIlllll, lllllllllllllIlllIIIIlIIIIlIIIII.readableBytes() + (lllllllllllllIlllIIIIlIIIIlIIIIl.isBiomeData() ? 256 : 0));
            lllllllllllllIlllIIIIlIIIIIlllll.writeBytes(lllllllllllllIlllIIIIlIIIIlIIIII);
        }
        finally {
            lllllllllllllIlllIIIIlIIIIlIIIII.release();
        }
        if (lllllllllllllIlllIIIIlIIIIlIIIIl.isBiomeData()) {
            final byte lllllllllllllIlllIIIIlIIIIIlllII = (Object)lllllllllllllIlllIIIIlIIIIlIIIIl.getBiomeData();
            final int length = lllllllllllllIlllIIIIlIIIIIlllII.length;
            for (short lllllllllllllIlllIIIIlIIIIIllIlI = 0; lllllllllllllIlllIIIIlIIIIIllIlI < length; ++lllllllllllllIlllIIIIlIIIIIllIlI) {
                final int lllllllllllllIlllIIIIlIIIIlIIlIl = lllllllllllllIlllIIIIlIIIIIlllII[lllllllllllllIlllIIIIlIIIIIllIlI];
                lllllllllllllIlllIIIIlIIIIIlllll.writeByte((int)(byte)lllllllllllllIlllIIIIlIIIIlIIlIl);
            }
        }
    }
    
    @Override
    public Chunk read(final ByteBuf lllllllllllllIlllIIIIlIIIlIIIlIl, final ClientWorld lllllllllllllIlllIIIIlIIIIlllIIl) throws Exception {
        final boolean lllllllllllllIlllIIIIlIIIlIIIIll = lllllllllllllIlllIIIIlIIIIlllIIl.getUser().getProtocolInfo().getPipeline().contains(Protocol1_10To1_9_3_4.class) && Via.getConfig().isReplacePistons();
        final int lllllllllllllIlllIIIIlIIIlIIIIlI = Via.getConfig().getPistonReplacementId();
        final int lllllllllllllIlllIIIIlIIIlIIIIIl = lllllllllllllIlllIIIIlIIIlIIIlIl.readInt();
        final int lllllllllllllIlllIIIIlIIIlIIIIII = lllllllllllllIlllIIIIlIIIlIIIlIl.readInt();
        final boolean lllllllllllllIlllIIIIlIIIIllllll = lllllllllllllIlllIIIIlIIIlIIIlIl.readBoolean();
        final int lllllllllllllIlllIIIIlIIIIlllllI = Type.VAR_INT.readPrimitive(lllllllllllllIlllIIIIlIIIlIIIlIl);
        Type.VAR_INT.readPrimitive(lllllllllllllIlllIIIIlIIIlIIIlIl);
        final BitSet lllllllllllllIlllIIIIlIIIIllllIl = new BitSet(16);
        final ChunkSection[] lllllllllllllIlllIIIIlIIIIllllII = new ChunkSection[16];
        for (int lllllllllllllIlllIIIIlIIIlIIlIlI = 0; lllllllllllllIlllIIIIlIIIlIIlIlI < 16; ++lllllllllllllIlllIIIIlIIIlIIlIlI) {
            if ((lllllllllllllIlllIIIIlIIIIlllllI & 1 << lllllllllllllIlllIIIIlIIIlIIlIlI) != 0x0) {
                lllllllllllllIlllIIIIlIIIIllllIl.set(lllllllllllllIlllIIIIlIIIlIIlIlI);
            }
        }
        for (int lllllllllllllIlllIIIIlIIIlIIlIII = 0; lllllllllllllIlllIIIIlIIIlIIlIII < 16; ++lllllllllllllIlllIIIIlIIIlIIlIII) {
            if (lllllllllllllIlllIIIIlIIIIllllIl.get(lllllllllllllIlllIIIIlIIIlIIlIII)) {
                final ChunkSection lllllllllllllIlllIIIIlIIIlIIlIIl = Types1_9.CHUNK_SECTION.read(lllllllllllllIlllIIIIlIIIlIIIlIl);
                lllllllllllllIlllIIIIlIIIIllllII[lllllllllllllIlllIIIIlIIIlIIlIII] = lllllllllllllIlllIIIIlIIIlIIlIIl;
                lllllllllllllIlllIIIIlIIIlIIlIIl.getLight().readBlockLight(lllllllllllllIlllIIIIlIIIlIIIlIl);
                if (lllllllllllllIlllIIIIlIIIIlllIIl.getEnvironment() == Environment.NORMAL) {
                    lllllllllllllIlllIIIIlIIIlIIlIIl.getLight().readSkyLight(lllllllllllllIlllIIIIlIIIlIIIlIl);
                }
                if (lllllllllllllIlllIIIIlIIIlIIIIll) {
                    lllllllllllllIlllIIIIlIIIlIIlIIl.replacePaletteEntry(36, lllllllllllllIlllIIIIlIIIlIIIIlI);
                }
            }
        }
        final int[] lllllllllllllIlllIIIIlIIIIlllIll = (int[])(lllllllllllllIlllIIIIlIIIIllllll ? new int[256] : null);
        if (lllllllllllllIlllIIIIlIIIIllllll) {
            for (int lllllllllllllIlllIIIIlIIIlIIIlll = 0; lllllllllllllIlllIIIIlIIIlIIIlll < 256; ++lllllllllllllIlllIIIIlIIIlIIIlll) {
                lllllllllllllIlllIIIIlIIIIlllIll[lllllllllllllIlllIIIIlIIIlIIIlll] = (lllllllllllllIlllIIIIlIIIlIIIlIl.readByte() & 0xFF);
            }
        }
        return new BaseChunk(lllllllllllllIlllIIIIlIIIlIIIIIl, lllllllllllllIlllIIIIlIIIlIIIIII, lllllllllllllIlllIIIIlIIIIllllll, false, lllllllllllllIlllIIIIlIIIIlllllI, lllllllllllllIlllIIIIlIIIIllllII, lllllllllllllIlllIIIIlIIIIlllIll, new ArrayList<CompoundTag>());
    }
}
