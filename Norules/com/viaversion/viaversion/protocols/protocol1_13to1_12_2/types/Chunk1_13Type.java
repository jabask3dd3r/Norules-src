package com.viaversion.viaversion.protocols.protocol1_13to1_12_2.types;

import com.viaversion.viaversion.protocols.protocol1_9_3to1_9_1_2.storage.*;
import io.netty.buffer.*;
import com.viaversion.viaversion.api.type.*;
import com.viaversion.viaversion.api.type.types.version.*;
import com.viaversion.viaversion.api.minecraft.*;
import com.viaversion.viaversion.api.*;
import java.util.logging.*;
import com.viaversion.viaversion.libs.opennbt.tag.builtin.*;
import com.viaversion.viaversion.api.minecraft.chunks.*;
import java.util.*;
import com.viaversion.viaversion.api.type.types.minecraft.*;

public class Chunk1_13Type extends PartialType<Chunk, ClientWorld>
{
    @Override
    public Chunk read(final ByteBuf lllllllllllllllIllllIIllllllIIlI, final ClientWorld lllllllllllllllIllllIIlllllllIll) throws Exception {
        final int lllllllllllllllIllllIIlllllllIlI = lllllllllllllllIllllIIllllllIIlI.readInt();
        final int lllllllllllllllIllllIIlllllllIIl = lllllllllllllllIllllIIllllllIIlI.readInt();
        final boolean lllllllllllllllIllllIIlllllllIII = lllllllllllllllIllllIIllllllIIlI.readBoolean();
        final int lllllllllllllllIllllIIllllllIlll = Type.VAR_INT.readPrimitive(lllllllllllllllIllllIIllllllIIlI);
        final ByteBuf lllllllllllllllIllllIIllllllIllI = lllllllllllllllIllllIIllllllIIlI.readSlice(Type.VAR_INT.readPrimitive(lllllllllllllllIllllIIllllllIIlI));
        final ChunkSection[] lllllllllllllllIllllIIllllllIlIl = new ChunkSection[16];
        for (int lllllllllllllllIllllIlIIIIIIIIII = 0; lllllllllllllllIllllIlIIIIIIIIII < 16; ++lllllllllllllllIllllIlIIIIIIIIII) {
            if ((lllllllllllllllIllllIIllllllIlll & 1 << lllllllllllllllIllllIlIIIIIIIIII) != 0x0) {
                final ChunkSection lllllllllllllllIllllIlIIIIIIIIIl = Types1_13.CHUNK_SECTION.read(lllllllllllllllIllllIIllllllIllI);
                lllllllllllllllIllllIIllllllIlIl[lllllllllllllllIllllIlIIIIIIIIII] = lllllllllllllllIllllIlIIIIIIIIIl;
                lllllllllllllllIllllIlIIIIIIIIIl.getLight().readBlockLight(lllllllllllllllIllllIIllllllIllI);
                if (lllllllllllllllIllllIIlllllllIll.getEnvironment() == Environment.NORMAL) {
                    lllllllllllllllIllllIlIIIIIIIIIl.getLight().readSkyLight(lllllllllllllllIllllIIllllllIllI);
                }
            }
        }
        final int[] lllllllllllllllIllllIIllllllIlII = (int[])(lllllllllllllllIllllIIlllllllIII ? new int[256] : null);
        if (lllllllllllllllIllllIIlllllllIII) {
            if (lllllllllllllllIllllIIllllllIllI.readableBytes() >= 1024) {
                for (int lllllllllllllllIllllIIllllllllll = 0; lllllllllllllllIllllIIllllllllll < 256; ++lllllllllllllllIllllIIllllllllll) {
                    lllllllllllllllIllllIIllllllIlII[lllllllllllllllIllllIIllllllllll] = lllllllllllllllIllllIIllllllIllI.readInt();
                }
            }
            else {
                Via.getPlatform().getLogger().log(Level.WARNING, String.valueOf(new StringBuilder().append("Chunk x=").append(lllllllllllllllIllllIIlllllllIlI).append(" z=").append(lllllllllllllllIllllIIlllllllIIl).append(" doesn't have biome data!")));
            }
        }
        final List<CompoundTag> lllllllllllllllIllllIIllllllIIll = new ArrayList<CompoundTag>(Arrays.asList((CompoundTag[])Type.NBT_ARRAY.read(lllllllllllllllIllllIIllllllIIlI)));
        if (lllllllllllllllIllllIIllllllIIlI.readableBytes() > 0) {
            final byte[] lllllllllllllllIllllIIlllllllllI = Type.REMAINING_BYTES.read(lllllllllllllllIllllIIllllllIIlI);
            if (Via.getManager().isDebug()) {
                Via.getPlatform().getLogger().warning(String.valueOf(new StringBuilder().append("Found ").append(lllllllllllllllIllllIIlllllllllI.length).append(" more bytes than expected while reading the chunk: ").append(lllllllllllllllIllllIIlllllllIlI).append("/").append(lllllllllllllllIllllIIlllllllIIl)));
            }
        }
        return new BaseChunk(lllllllllllllllIllllIIlllllllIlI, lllllllllllllllIllllIIlllllllIIl, lllllllllllllllIllllIIlllllllIII, false, lllllllllllllllIllllIIllllllIlll, lllllllllllllllIllllIIllllllIlIl, lllllllllllllllIllllIIllllllIlII, lllllllllllllllIllllIIllllllIIll);
    }
    
    @Override
    public Class<? extends Type> getBaseClass() {
        return BaseChunkType.class;
    }
    
    public Chunk1_13Type(final ClientWorld lllllllllllllllIllllIlIIIIIIllIl) {
        super(lllllllllllllllIllllIlIIIIIIllIl, Chunk.class);
    }
    
    @Override
    public void write(final ByteBuf lllllllllllllllIllllIIllllIlllII, final ClientWorld lllllllllllllllIllllIIllllIllIll, final Chunk lllllllllllllllIllllIIllllIlIlll) throws Exception {
        lllllllllllllllIllllIIllllIlllII.writeInt(lllllllllllllllIllllIIllllIlIlll.getX());
        lllllllllllllllIllllIIllllIlllII.writeInt(lllllllllllllllIllllIIllllIlIlll.getZ());
        lllllllllllllllIllllIIllllIlllII.writeBoolean(lllllllllllllllIllllIIllllIlIlll.isFullChunk());
        Type.VAR_INT.writePrimitive(lllllllllllllllIllllIIllllIlllII, lllllllllllllllIllllIIllllIlIlll.getBitmask());
        final ByteBuf lllllllllllllllIllllIIllllIllIIl = lllllllllllllllIllllIIllllIlllII.alloc().buffer();
        try {
            for (int lllllllllllllllIllllIIllllIlllll = 0; lllllllllllllllIllllIIllllIlllll < 16; ++lllllllllllllllIllllIIllllIlllll) {
                final ChunkSection lllllllllllllllIllllIIlllllIIIII = lllllllllllllllIllllIIllllIlIlll.getSections()[lllllllllllllllIllllIIllllIlllll];
                if (lllllllllllllllIllllIIlllllIIIII != null) {
                    Types1_13.CHUNK_SECTION.write(lllllllllllllllIllllIIllllIllIIl, lllllllllllllllIllllIIlllllIIIII);
                    lllllllllllllllIllllIIlllllIIIII.getLight().writeBlockLight(lllllllllllllllIllllIIllllIllIIl);
                    if (lllllllllllllllIllllIIlllllIIIII.getLight().hasSkyLight()) {
                        lllllllllllllllIllllIIlllllIIIII.getLight().writeSkyLight(lllllllllllllllIllllIIllllIllIIl);
                    }
                }
            }
            lllllllllllllllIllllIIllllIllIIl.readerIndex(0);
            Type.VAR_INT.writePrimitive(lllllllllllllllIllllIIllllIlllII, lllllllllllllllIllllIIllllIllIIl.readableBytes() + (lllllllllllllllIllllIIllllIlIlll.isBiomeData() ? 1024 : 0));
            lllllllllllllllIllllIIllllIlllII.writeBytes(lllllllllllllllIllllIIllllIllIIl);
        }
        finally {
            lllllllllllllllIllllIIllllIllIIl.release();
        }
        if (lllllllllllllllIllllIIllllIlIlll.isBiomeData()) {
            final int[] biomeData = lllllllllllllllIllllIIllllIlIlll.getBiomeData();
            final short lllllllllllllllIllllIIllllIlIlII = (short)biomeData.length;
            for (String lllllllllllllllIllllIIllllIlIIll = (String)0; lllllllllllllllIllllIIllllIlIIll < lllllllllllllllIllllIIllllIlIlII; ++lllllllllllllllIllllIIllllIlIIll) {
                final int lllllllllllllllIllllIIllllIllllI = biomeData[lllllllllllllllIllllIIllllIlIIll];
                lllllllllllllllIllllIIllllIlllII.writeInt(lllllllllllllllIllllIIllllIllllI);
            }
        }
        Type.NBT_ARRAY.write(lllllllllllllllIllllIIllllIlllII, lllllllllllllllIllllIIllllIlIlll.getBlockEntities().toArray(new CompoundTag[0]));
    }
}
