package de.gerrygames.viarewind.protocol.protocol1_8to1_9.types;

import com.viaversion.viaversion.protocols.protocol1_9_3to1_9_1_2.storage.*;
import com.viaversion.viaversion.api.type.*;
import io.netty.buffer.*;
import com.viaversion.viaversion.api.minecraft.chunks.*;
import com.viaversion.viaversion.api.*;
import java.util.logging.*;
import com.viaversion.viaversion.libs.opennbt.tag.builtin.*;
import java.util.*;
import com.viaversion.viaversion.api.minecraft.*;

public class Chunk1_8Type extends PartialType<Chunk, ClientWorld>
{
    private static final /* synthetic */ Type<ChunkSection> CHUNK_SECTION_TYPE;
    
    static {
        CHUNK_SECTION_TYPE = new ChunkSectionType1_8();
    }
    
    @Override
    public Chunk read(final ByteBuf lllllllllllllIlIllIlllllIlIIIlII, final ClientWorld lllllllllllllIlIllIlllllIlIIlllI) throws Exception {
        final int lllllllllllllIlIllIlllllIlIIllIl = lllllllllllllIlIllIlllllIlIIIlII.readInt();
        final int lllllllllllllIlIllIlllllIlIIllII = lllllllllllllIlIllIlllllIlIIIlII.readInt();
        final boolean lllllllllllllIlIllIlllllIlIIlIll = lllllllllllllIlIllIlllllIlIIIlII.readByte() != 0;
        final int lllllllllllllIlIllIlllllIlIIlIlI = lllllllllllllIlIllIlllllIlIIIlII.readUnsignedShort();
        final int lllllllllllllIlIllIlllllIlIIlIIl = Type.VAR_INT.readPrimitive(lllllllllllllIlIllIlllllIlIIIlII);
        if (lllllllllllllIlIllIlllllIlIIlIlI == 0 && lllllllllllllIlIllIlllllIlIIlIll) {
            if (lllllllllllllIlIllIlllllIlIIlIIl >= 256) {
                lllllllllllllIlIllIlllllIlIIIlII.readerIndex(lllllllllllllIlIllIlllllIlIIIlII.readerIndex() + 256);
            }
            return new Chunk1_8(lllllllllllllIlIllIlllllIlIIllIl, lllllllllllllIlIllIlllllIlIIllII);
        }
        final ChunkSection[] lllllllllllllIlIllIlllllIlIIlIII = new ChunkSection[16];
        int[] lllllllllllllIlIllIlllllIlIIIlll = null;
        final int lllllllllllllIlIllIlllllIlIIIllI = lllllllllllllIlIllIlllllIlIIIlII.readerIndex();
        for (int lllllllllllllIlIllIlllllIlIlIlII = 0; lllllllllllllIlIllIlllllIlIlIlII < 16; ++lllllllllllllIlIllIlllllIlIlIlII) {
            if ((lllllllllllllIlIllIlllllIlIIlIlI & 1 << lllllllllllllIlIllIlllllIlIlIlII) != 0x0) {
                lllllllllllllIlIllIlllllIlIIlIII[lllllllllllllIlIllIlllllIlIlIlII] = Chunk1_8Type.CHUNK_SECTION_TYPE.read(lllllllllllllIlIllIlllllIlIIIlII);
            }
        }
        for (int lllllllllllllIlIllIlllllIlIlIIll = 0; lllllllllllllIlIllIlllllIlIlIIll < 16; ++lllllllllllllIlIllIlllllIlIlIIll) {
            if ((lllllllllllllIlIllIlllllIlIIlIlI & 1 << lllllllllllllIlIllIlllllIlIlIIll) != 0x0) {
                lllllllllllllIlIllIlllllIlIIlIII[lllllllllllllIlIllIlllllIlIlIIll].getLight().readBlockLight(lllllllllllllIlIllIlllllIlIIIlII);
            }
        }
        int lllllllllllllIlIllIlllllIlIIIlIl = lllllllllllllIlIllIlllllIlIIlIIl - (lllllllllllllIlIllIlllllIlIIIlII.readerIndex() - lllllllllllllIlIllIlllllIlIIIllI);
        if (lllllllllllllIlIllIlllllIlIIIlIl >= 2048) {
            for (int lllllllllllllIlIllIlllllIlIlIIlI = 0; lllllllllllllIlIllIlllllIlIlIIlI < 16; ++lllllllllllllIlIllIlllllIlIlIIlI) {
                if ((lllllllllllllIlIllIlllllIlIIlIlI & 1 << lllllllllllllIlIllIlllllIlIlIIlI) != 0x0) {
                    lllllllllllllIlIllIlllllIlIIlIII[lllllllllllllIlIllIlllllIlIlIIlI].getLight().readSkyLight(lllllllllllllIlIllIlllllIlIIIlII);
                    lllllllllllllIlIllIlllllIlIIIlIl -= 2048;
                }
            }
        }
        if (lllllllllllllIlIllIlllllIlIIIlIl >= 256) {
            lllllllllllllIlIllIlllllIlIIIlll = new int[256];
            for (int lllllllllllllIlIllIlllllIlIlIIIl = 0; lllllllllllllIlIllIlllllIlIlIIIl < 256; ++lllllllllllllIlIllIlllllIlIlIIIl) {
                lllllllllllllIlIllIlllllIlIIIlll[lllllllllllllIlIllIlllllIlIlIIIl] = (lllllllllllllIlIllIlllllIlIIIlII.readByte() & 0xFF);
            }
            lllllllllllllIlIllIlllllIlIIIlIl -= 256;
        }
        if (lllllllllllllIlIllIlllllIlIIIlIl > 0) {
            Via.getPlatform().getLogger().log(Level.WARNING, String.valueOf(new StringBuilder().append(lllllllllllllIlIllIlllllIlIIIlIl).append(" Bytes left after reading chunks! (").append(lllllllllllllIlIllIlllllIlIIlIll).append(")")));
        }
        return new Chunk1_8(lllllllllllllIlIllIlllllIlIIllIl, lllllllllllllIlIllIlllllIlIIllII, lllllllllllllIlIllIlllllIlIIlIll, lllllllllllllIlIllIlllllIlIIlIlI, lllllllllllllIlIllIlllllIlIIlIII, lllllllllllllIlIllIlllllIlIIIlll, new ArrayList<CompoundTag>());
    }
    
    @Override
    public void write(final ByteBuf lllllllllllllIlIllIlllllIIlIlIll, final ClientWorld lllllllllllllIlIllIlllllIIlIIlIl, final Chunk lllllllllllllIlIllIlllllIIlIIlII) throws Exception {
        final ByteBuf lllllllllllllIlIllIlllllIIlIlIII = lllllllllllllIlIllIlllllIIlIlIll.alloc().buffer();
        for (int lllllllllllllIlIllIlllllIIllIIII = 0; lllllllllllllIlIllIlllllIIllIIII < lllllllllllllIlIllIlllllIIlIIlII.getSections().length; ++lllllllllllllIlIllIlllllIIllIIII) {
            if ((lllllllllllllIlIllIlllllIIlIIlII.getBitmask() & 1 << lllllllllllllIlIllIlllllIIllIIII) != 0x0) {
                Chunk1_8Type.CHUNK_SECTION_TYPE.write(lllllllllllllIlIllIlllllIIlIlIII, lllllllllllllIlIllIlllllIIlIIlII.getSections()[lllllllllllllIlIllIlllllIIllIIII]);
            }
        }
        for (int lllllllllllllIlIllIlllllIIlIllll = 0; lllllllllllllIlIllIlllllIIlIllll < lllllllllllllIlIllIlllllIIlIIlII.getSections().length; ++lllllllllllllIlIllIlllllIIlIllll) {
            if ((lllllllllllllIlIllIlllllIIlIIlII.getBitmask() & 1 << lllllllllllllIlIllIlllllIIlIllll) != 0x0) {
                lllllllllllllIlIllIlllllIIlIIlII.getSections()[lllllllllllllIlIllIlllllIIlIllll].getLight().writeBlockLight(lllllllllllllIlIllIlllllIIlIlIII);
            }
        }
        final boolean lllllllllllllIlIllIlllllIIlIIlll = lllllllllllllIlIllIlllllIIlIIlIl.getEnvironment() == Environment.NORMAL;
        if (lllllllllllllIlIllIlllllIIlIIlll) {
            for (int lllllllllllllIlIllIlllllIIlIlllI = 0; lllllllllllllIlIllIlllllIIlIlllI < lllllllllllllIlIllIlllllIIlIIlII.getSections().length; ++lllllllllllllIlIllIlllllIIlIlllI) {
                if ((lllllllllllllIlIllIlllllIIlIIlII.getBitmask() & 1 << lllllllllllllIlIllIlllllIIlIlllI) != 0x0) {
                    lllllllllllllIlIllIlllllIIlIIlII.getSections()[lllllllllllllIlIllIlllllIIlIlllI].getLight().writeSkyLight(lllllllllllllIlIllIlllllIIlIlIII);
                }
            }
        }
        if (lllllllllllllIlIllIlllllIIlIIlII.isFullChunk() && lllllllllllllIlIllIlllllIIlIIlII.isBiomeData()) {
            final char lllllllllllllIlIllIlllllIIlIIIIl = (Object)lllllllllllllIlIllIlllllIIlIIlII.getBiomeData();
            for (long lllllllllllllIlIllIlllllIIlIIIII = lllllllllllllIlIllIlllllIIlIIIIl.length, lllllllllllllIlIllIlllllIIIlllll = 0; lllllllllllllIlIllIlllllIIIlllll < lllllllllllllIlIllIlllllIIlIIIII; ++lllllllllllllIlIllIlllllIIIlllll) {
                final int lllllllllllllIlIllIlllllIIlIllIl = lllllllllllllIlIllIlllllIIlIIIIl[lllllllllllllIlIllIlllllIIIlllll];
                lllllllllllllIlIllIlllllIIlIlIII.writeByte((int)(byte)lllllllllllllIlIllIlllllIIlIllIl);
            }
        }
        lllllllllllllIlIllIlllllIIlIlIll.writeInt(lllllllllllllIlIllIlllllIIlIIlII.getX());
        lllllllllllllIlIllIlllllIIlIlIll.writeInt(lllllllllllllIlIllIlllllIIlIIlII.getZ());
        lllllllllllllIlIllIlllllIIlIlIll.writeBoolean(lllllllllllllIlIllIlllllIIlIIlII.isFullChunk());
        lllllllllllllIlIllIlllllIIlIlIll.writeShort(lllllllllllllIlIllIlllllIIlIIlII.getBitmask());
        Type.VAR_INT.writePrimitive(lllllllllllllIlIllIlllllIIlIlIll, lllllllllllllIlIllIlllllIIlIlIII.readableBytes());
        lllllllllllllIlIllIlllllIIlIlIll.writeBytes(lllllllllllllIlIllIlllllIIlIlIII, lllllllllllllIlIllIlllllIIlIlIII.readableBytes());
        lllllllllllllIlIllIlllllIIlIlIII.release();
    }
    
    public Chunk1_8Type(final ClientWorld lllllllllllllIlIllIlllllIllIIIII) {
        super(lllllllllllllIlIllIlllllIllIIIII, Chunk.class);
    }
}
