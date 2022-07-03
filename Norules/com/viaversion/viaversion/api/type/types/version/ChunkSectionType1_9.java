package com.viaversion.viaversion.api.type.types.version;

import com.viaversion.viaversion.api.type.*;
import io.netty.buffer.*;
import com.viaversion.viaversion.api.minecraft.chunks.*;
import java.util.*;
import com.viaversion.viaversion.util.*;
import java.util.function.*;

public class ChunkSectionType1_9 extends Type<ChunkSection>
{
    @Override
    public ChunkSection read(final ByteBuf llIIIlllIlllIII) throws Exception {
        final int llIIIlllIllllII;
        int llIIIlllIllllIl = llIIIlllIllllII = llIIIlllIlllIII.readUnsignedByte();
        if (llIIIlllIllllIl == 0) {
            llIIIlllIllllIl = 13;
        }
        if (llIIIlllIllllIl < 4) {
            llIIIlllIllllIl = 4;
        }
        if (llIIIlllIllllIl > 8) {
            llIIIlllIllllIl = 13;
        }
        final int llIIIlllIlllIll = Type.VAR_INT.readPrimitive(llIIIlllIlllIII);
        final ChunkSection llIIIlllIlllIlI = (llIIIlllIllllIl != 13) ? new ChunkSectionImpl(true, llIIIlllIlllIll) : new ChunkSectionImpl(true);
        for (int llIIIllllIIIIlI = 0; llIIIllllIIIIlI < llIIIlllIlllIll; ++llIIIllllIIIIlI) {
            if (llIIIlllIllllIl != 13) {
                llIIIlllIlllIlI.addPaletteEntry(Type.VAR_INT.readPrimitive(llIIIlllIlllIII));
            }
            else {
                Type.VAR_INT.readPrimitive(llIIIlllIlllIII);
            }
        }
        final long[] llIIIlllIlllIIl = new long[Type.VAR_INT.readPrimitive(llIIIlllIlllIII)];
        if (llIIIlllIlllIIl.length > 0) {
            final int llIIIllllIIIIII = (int)Math.ceil(4096 * llIIIlllIllllIl / 64.0);
            if (llIIIlllIlllIIl.length != llIIIllllIIIIII) {
                throw new IllegalStateException(String.valueOf(new StringBuilder().append("Block data length (").append(llIIIlllIlllIIl.length).append(") does not match expected length (").append(llIIIllllIIIIII).append(")! bitsPerBlock=").append(llIIIlllIllllIl).append(", originalBitsPerBlock=").append(llIIIlllIllllII)));
            }
            for (int llIIIllllIIIIIl = 0; llIIIllllIIIIIl < llIIIlllIlllIIl.length; ++llIIIllllIIIIIl) {
                llIIIlllIlllIIl[llIIIllllIIIIIl] = llIIIlllIlllIII.readLong();
            }
            final int lllllllllllllllllIIIllIlIlIIIlIl = llIIIlllIllllIl;
            final int lllllllllllllllllIIIllIlIlIIIlII = 4096;
            final long[] lllllllllllllllllIIIllIlIlIIIIll = llIIIlllIlllIIl;
            BiIntConsumer lllllllllllllllllIIIllIlIlIIIIlI;
            if (llIIIlllIllllIl == 13) {
                final ChunkSection chunkSection = llIIIlllIlllIlI;
                Objects.requireNonNull(chunkSection);
                lllllllllllllllllIIIllIlIlIIIIlI = chunkSection::setFlatBlock;
            }
            else {
                final ChunkSection chunkSection2 = llIIIlllIlllIlI;
                Objects.requireNonNull(chunkSection2);
                lllllllllllllllllIIIllIlIlIIIIlI = chunkSection2::setPaletteIndex;
            }
            CompactArrayUtil.iterateCompactArray(lllllllllllllllllIIIllIlIlIIIlIl, lllllllllllllllllIIIllIlIlIIIlII, lllllllllllllllllIIIllIlIlIIIIll, lllllllllllllllllIIIllIlIlIIIIlI);
        }
        return llIIIlllIlllIlI;
    }
    
    public ChunkSectionType1_9() {
        super("Chunk Section Type", ChunkSection.class);
    }
    
    @Override
    public void write(final ByteBuf llIIIlllIlIIlII, final ChunkSection llIIIlllIlIIIll) throws Exception {
        int llIIIlllIlIIIlI;
        for (llIIIlllIlIIIlI = 4; llIIIlllIlIIIll.getPaletteSize() > 1 << llIIIlllIlIIIlI; ++llIIIlllIlIIIlI) {}
        if (llIIIlllIlIIIlI > 8) {
            llIIIlllIlIIIlI = 13;
        }
        final long llIIIlllIlIIIIl = (1L << llIIIlllIlIIIlI) - 1L;
        llIIIlllIlIIlII.writeByte(llIIIlllIlIIIlI);
        if (llIIIlllIlIIIlI != 13) {
            Type.VAR_INT.writePrimitive(llIIIlllIlIIlII, llIIIlllIlIIIll.getPaletteSize());
            for (int llIIIlllIlIIlll = 0; llIIIlllIlIIlll < llIIIlllIlIIIll.getPaletteSize(); ++llIIIlllIlIIlll) {
                Type.VAR_INT.writePrimitive(llIIIlllIlIIlII, llIIIlllIlIIIll.getPaletteEntry(llIIIlllIlIIlll));
            }
        }
        else {
            Type.VAR_INT.writePrimitive(llIIIlllIlIIlII, 0);
        }
        final int lllllllllllllllllIIIllIlIllIllll = llIIIlllIlIIIlI;
        final int lllllllllllllllllIIIllIlIllIlllI = 4096;
        IntToLongFunction lllllllllllllllllIIIllIlIllIlIII;
        if (llIIIlllIlIIIlI == 13) {
            Objects.requireNonNull(llIIIlllIlIIIll);
            lllllllllllllllllIIIllIlIllIlIII = llIIIlllIlIIIll::getFlatBlock;
        }
        else {
            Objects.requireNonNull(llIIIlllIlIIIll);
            lllllllllllllllllIIIllIlIllIlIII = llIIIlllIlIIIll::getPaletteIndex;
        }
        final long[] llIIIlllIlIIIII = CompactArrayUtil.createCompactArray(lllllllllllllllllIIIllIlIllIllll, lllllllllllllllllIIIllIlIllIlllI, lllllllllllllllllIIIllIlIllIlIII);
        Type.VAR_INT.writePrimitive(llIIIlllIlIIlII, llIIIlllIlIIIII.length);
        final char llIIIlllIIllIlI = (Object)llIIIlllIlIIIII;
        final String llIIIlllIIllIIl = (String)llIIIlllIIllIlI.length;
        for (Exception llIIIlllIIllIII = (Exception)0; llIIIlllIIllIII < llIIIlllIIllIIl; ++llIIIlllIIllIII) {
            final long llIIIlllIlIIllI = llIIIlllIIllIlI[llIIIlllIIllIII];
            llIIIlllIlIIlII.writeLong(llIIIlllIlIIllI);
        }
    }
    
    static {
        GLOBAL_PALETTE = 13;
    }
}
