package com.viaversion.viaversion.api.type.types.version;

import com.viaversion.viaversion.api.type.*;
import io.netty.buffer.*;
import java.util.*;
import java.util.function.*;
import com.viaversion.viaversion.api.minecraft.chunks.*;
import com.viaversion.viaversion.util.*;

public class ChunkSectionType1_16 extends Type<ChunkSection>
{
    @Override
    public void write(final ByteBuf lllllllllllllIllIIlllIllIIIlIlll, final ChunkSection lllllllllllllIllIIlllIllIIIlIllI) throws Exception {
        int lllllllllllllIllIIlllIllIIIllIIl;
        for (lllllllllllllIllIIlllIllIIIllIIl = 4; lllllllllllllIllIIlllIllIIIlIllI.getPaletteSize() > 1 << lllllllllllllIllIIlllIllIIIllIIl; ++lllllllllllllIllIIlllIllIIIllIIl) {}
        if (lllllllllllllIllIIlllIllIIIllIIl > 8) {
            lllllllllllllIllIIlllIllIIIllIIl = 15;
        }
        lllllllllllllIllIIlllIllIIIlIlll.writeByte(lllllllllllllIllIIlllIllIIIllIIl);
        if (lllllllllllllIllIIlllIllIIIllIIl != 15) {
            Type.VAR_INT.writePrimitive(lllllllllllllIllIIlllIllIIIlIlll, lllllllllllllIllIIlllIllIIIlIllI.getPaletteSize());
            for (int lllllllllllllIllIIlllIllIIlIIIlI = 0; lllllllllllllIllIIlllIllIIlIIIlI < lllllllllllllIllIIlllIllIIIlIllI.getPaletteSize(); ++lllllllllllllIllIIlllIllIIlIIIlI) {
                Type.VAR_INT.writePrimitive(lllllllllllllIllIIlllIllIIIlIlll, lllllllllllllIllIIlllIllIIIlIllI.getPaletteEntry(lllllllllllllIllIIlllIllIIlIIIlI));
            }
        }
        final int lllllllllllllllllIIIllIllIlllIll = lllllllllllllIllIIlllIllIIIllIIl;
        final int lllllllllllllllllIIIllIllIlllIlI = 4096;
        IntToLongFunction lllllllllllllllllIIIllIllIlllIIl;
        if (lllllllllllllIllIIlllIllIIIllIIl == 15) {
            Objects.requireNonNull(lllllllllllllIllIIlllIllIIIlIllI);
            lllllllllllllllllIIIllIllIlllIIl = lllllllllllllIllIIlllIllIIIlIllI::getFlatBlock;
        }
        else {
            Objects.requireNonNull(lllllllllllllIllIIlllIllIIIlIllI);
            lllllllllllllllllIIIllIllIlllIIl = lllllllllllllIllIIlllIllIIIlIllI::getPaletteIndex;
        }
        final long[] lllllllllllllIllIIlllIllIIIllIII = CompactArrayUtil.createCompactArrayWithPadding(lllllllllllllllllIIIllIllIlllIll, lllllllllllllllllIIIllIllIlllIlI, lllllllllllllllllIIIllIllIlllIIl);
        Type.VAR_INT.writePrimitive(lllllllllllllIllIIlllIllIIIlIlll, lllllllllllllIllIIlllIllIIIllIII.length);
        final String lllllllllllllIllIIlllIllIIIlIIll = (Object)lllllllllllllIllIIlllIllIIIllIII;
        final String lllllllllllllIllIIlllIllIIIlIIlI = (String)lllllllllllllIllIIlllIllIIIlIIll.length;
        for (char lllllllllllllIllIIlllIllIIIlIIIl = '\0'; lllllllllllllIllIIlllIllIIIlIIIl < lllllllllllllIllIIlllIllIIIlIIlI; ++lllllllllllllIllIIlllIllIIIlIIIl) {
            final long lllllllllllllIllIIlllIllIIIlllll = lllllllllllllIllIIlllIllIIIlIIll[lllllllllllllIllIIlllIllIIIlIIIl];
            lllllllllllllIllIIlllIllIIIlIlll.writeLong(lllllllllllllIllIIlllIllIIIlllll);
        }
    }
    
    static {
        GLOBAL_PALETTE = 15;
    }
    
    public ChunkSectionType1_16() {
        super("Chunk Section Type", ChunkSection.class);
    }
    
    @Override
    public ChunkSection read(final ByteBuf lllllllllllllIllIIlllIllIlIIlIII) throws Exception {
        final int lllllllllllllIllIIlllIllIlIIlllI;
        int lllllllllllllIllIIlllIllIlIlIIII = lllllllllllllIllIIlllIllIlIIlllI = lllllllllllllIllIIlllIllIlIIlIII.readUnsignedByte();
        if (lllllllllllllIllIIlllIllIlIlIIII == 0 || lllllllllllllIllIIlllIllIlIlIIII > 8) {
            lllllllllllllIllIIlllIllIlIlIIII = 15;
        }
        ChunkSection lllllllllllllIllIIlllIllIlIIllII;
        if (lllllllllllllIllIIlllIllIlIlIIII != 15) {
            final int lllllllllllllIllIIlllIllIlIlllIl = Type.VAR_INT.readPrimitive(lllllllllllllIllIIlllIllIlIIlIII);
            final ChunkSection lllllllllllllIllIIlllIllIlIlllII = new ChunkSectionImpl(false, lllllllllllllIllIIlllIllIlIlllIl);
            for (int lllllllllllllIllIIlllIllIlIlllll = 0; lllllllllllllIllIIlllIllIlIlllll < lllllllllllllIllIIlllIllIlIlllIl; ++lllllllllllllIllIIlllIllIlIlllll) {
                lllllllllllllIllIIlllIllIlIlllII.addPaletteEntry(Type.VAR_INT.readPrimitive(lllllllllllllIllIIlllIllIlIIlIII));
            }
        }
        else {
            lllllllllllllIllIIlllIllIlIIllII = new ChunkSectionImpl(false);
        }
        final long[] lllllllllllllIllIIlllIllIlIIlIlI = new long[Type.VAR_INT.readPrimitive(lllllllllllllIllIIlllIllIlIIlIII)];
        if (lllllllllllllIllIIlllIllIlIIlIlI.length > 0) {
            final char lllllllllllllIllIIlllIllIlIllIII = (char)(64 / lllllllllllllIllIIlllIllIlIlIIII);
            final int lllllllllllllIllIIlllIllIlIlIllI = ('\u1000' + lllllllllllllIllIIlllIllIlIllIII - 1) / lllllllllllllIllIIlllIllIlIllIII;
            if (lllllllllllllIllIIlllIllIlIIlIlI.length != lllllllllllllIllIIlllIllIlIlIllI) {
                throw new IllegalStateException(String.valueOf(new StringBuilder().append("Block data length (").append(lllllllllllllIllIIlllIllIlIIlIlI.length).append(") does not match expected length (").append(lllllllllllllIllIIlllIllIlIlIllI).append(")! bitsPerBlock=").append(lllllllllllllIllIIlllIllIlIlIIII).append(", originalBitsPerBlock=").append(lllllllllllllIllIIlllIllIlIIlllI)));
            }
            for (int lllllllllllllIllIIlllIllIlIllIlI = 0; lllllllllllllIllIIlllIllIlIllIlI < lllllllllllllIllIIlllIllIlIIlIlI.length; ++lllllllllllllIllIIlllIllIlIllIlI) {
                lllllllllllllIllIIlllIllIlIIlIlI[lllllllllllllIllIIlllIllIlIllIlI] = lllllllllllllIllIIlllIllIlIIlIII.readLong();
            }
            final int lllllllllllllllllIIIllIllIIllIlI = lllllllllllllIllIIlllIllIlIlIIII;
            final int lllllllllllllllllIIIllIllIIIllll = 4096;
            final long[] lllllllllllllllllIIIllIllIIIlllI = lllllllllllllIllIIlllIllIlIIlIlI;
            BiIntConsumer lllllllllllllllllIIIllIllIIIllIl;
            if (lllllllllllllIllIIlllIllIlIlIIII == 15) {
                final ChunkSection chunkSection = lllllllllllllIllIIlllIllIlIIllII;
                Objects.requireNonNull(chunkSection);
                lllllllllllllllllIIIllIllIIIllIl = chunkSection::setFlatBlock;
            }
            else {
                final ChunkSection chunkSection2 = lllllllllllllIllIIlllIllIlIIllII;
                Objects.requireNonNull(chunkSection2);
                lllllllllllllllllIIIllIllIIIllIl = chunkSection2::setPaletteIndex;
            }
            CompactArrayUtil.iterateCompactArrayWithPadding(lllllllllllllllllIIIllIllIIllIlI, lllllllllllllllllIIIllIllIIIllll, lllllllllllllllllIIIllIllIIIlllI, lllllllllllllllllIIIllIllIIIllIl);
        }
        return lllllllllllllIllIIlllIllIlIIllII;
    }
}
