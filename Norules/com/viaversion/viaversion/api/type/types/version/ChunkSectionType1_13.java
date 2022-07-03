package com.viaversion.viaversion.api.type.types.version;

import com.viaversion.viaversion.api.type.*;
import io.netty.buffer.*;
import com.viaversion.viaversion.api.minecraft.chunks.*;
import java.util.*;
import com.viaversion.viaversion.util.*;
import java.util.function.*;

public class ChunkSectionType1_13 extends Type<ChunkSection>
{
    static {
        GLOBAL_PALETTE = 14;
    }
    
    @Override
    public ChunkSection read(final ByteBuf lllllllllllllllIllIllllIllIIllll) throws Exception {
        final int lllllllllllllllIllIllllIllIIllIl;
        int lllllllllllllllIllIllllIllIIlllI = lllllllllllllllIllIllllIllIIllIl = lllllllllllllllIllIllllIllIIllll.readUnsignedByte();
        if (lllllllllllllllIllIllllIllIIlllI == 0 || lllllllllllllllIllIllllIllIIlllI > 8) {
            lllllllllllllllIllIllllIllIIlllI = 14;
        }
        ChunkSection lllllllllllllllIllIllllIllIIllII;
        if (lllllllllllllllIllIllllIllIIlllI != 14) {
            final int lllllllllllllllIllIllllIllIlIlII = Type.VAR_INT.readPrimitive(lllllllllllllllIllIllllIllIIllll);
            final ChunkSection lllllllllllllllIllIllllIllIlIIll = new ChunkSectionImpl(true, lllllllllllllllIllIllllIllIlIlII);
            for (int lllllllllllllllIllIllllIllIlIlIl = 0; lllllllllllllllIllIllllIllIlIlIl < lllllllllllllllIllIllllIllIlIlII; ++lllllllllllllllIllIllllIllIlIlIl) {
                lllllllllllllllIllIllllIllIlIIll.addPaletteEntry(Type.VAR_INT.readPrimitive(lllllllllllllllIllIllllIllIIllll));
            }
        }
        else {
            lllllllllllllllIllIllllIllIIllII = new ChunkSectionImpl(true);
        }
        final long[] lllllllllllllllIllIllllIllIIlIll = new long[Type.VAR_INT.readPrimitive(lllllllllllllllIllIllllIllIIllll)];
        if (lllllllllllllllIllIllllIllIIlIll.length > 0) {
            final int lllllllllllllllIllIllllIllIlIIIl = (int)Math.ceil(4096 * lllllllllllllllIllIllllIllIIlllI / 64.0);
            if (lllllllllllllllIllIllllIllIIlIll.length != lllllllllllllllIllIllllIllIlIIIl) {
                throw new IllegalStateException(String.valueOf(new StringBuilder().append("Block data length (").append(lllllllllllllllIllIllllIllIIlIll.length).append(") does not match expected length (").append(lllllllllllllllIllIllllIllIlIIIl).append(")! bitsPerBlock=").append(lllllllllllllllIllIllllIllIIlllI).append(", originalBitsPerBlock=").append(lllllllllllllllIllIllllIllIIllIl)));
            }
            for (int lllllllllllllllIllIllllIllIlIIlI = 0; lllllllllllllllIllIllllIllIlIIlI < lllllllllllllllIllIllllIllIIlIll.length; ++lllllllllllllllIllIllllIllIlIIlI) {
                lllllllllllllllIllIllllIllIIlIll[lllllllllllllllIllIllllIllIlIIlI] = lllllllllllllllIllIllllIllIIllll.readLong();
            }
            final int lllllllllllllllllIIIllIlIlIIIlIl = lllllllllllllllIllIllllIllIIlllI;
            final int lllllllllllllllllIIIllIlIlIIIlII = 4096;
            final long[] lllllllllllllllllIIIllIlIlIIIIll = lllllllllllllllIllIllllIllIIlIll;
            BiIntConsumer lllllllllllllllllIIIllIlIlIIIIlI;
            if (lllllllllllllllIllIllllIllIIlllI == 14) {
                final ChunkSection chunkSection = lllllllllllllllIllIllllIllIIllII;
                Objects.requireNonNull(chunkSection);
                lllllllllllllllllIIIllIlIlIIIIlI = chunkSection::setFlatBlock;
            }
            else {
                final ChunkSection chunkSection2 = lllllllllllllllIllIllllIllIIllII;
                Objects.requireNonNull(chunkSection2);
                lllllllllllllllllIIIllIlIlIIIIlI = chunkSection2::setPaletteIndex;
            }
            CompactArrayUtil.iterateCompactArray(lllllllllllllllllIIIllIlIlIIIlIl, lllllllllllllllllIIIllIlIlIIIlII, lllllllllllllllllIIIllIlIlIIIIll, lllllllllllllllllIIIllIlIlIIIIlI);
        }
        return lllllllllllllllIllIllllIllIIllII;
    }
    
    @Override
    public void write(final ByteBuf lllllllllllllllIllIllllIlIllIlII, final ChunkSection lllllllllllllllIllIllllIlIllIIll) throws Exception {
        int lllllllllllllllIllIllllIlIllIllI;
        for (lllllllllllllllIllIllllIlIllIllI = 4; lllllllllllllllIllIllllIlIllIIll.getPaletteSize() > 1 << lllllllllllllllIllIllllIlIllIllI; ++lllllllllllllllIllIllllIlIllIllI) {}
        if (lllllllllllllllIllIllllIlIllIllI > 8) {
            lllllllllllllllIllIllllIlIllIllI = 14;
        }
        lllllllllllllllIllIllllIlIllIlII.writeByte(lllllllllllllllIllIllllIlIllIllI);
        if (lllllllllllllllIllIllllIlIllIllI != 14) {
            Type.VAR_INT.writePrimitive(lllllllllllllllIllIllllIlIllIlII, lllllllllllllllIllIllllIlIllIIll.getPaletteSize());
            for (int lllllllllllllllIllIllllIlIlllIll = 0; lllllllllllllllIllIllllIlIlllIll < lllllllllllllllIllIllllIlIllIIll.getPaletteSize(); ++lllllllllllllllIllIllllIlIlllIll) {
                Type.VAR_INT.writePrimitive(lllllllllllllllIllIllllIlIllIlII, lllllllllllllllIllIllllIlIllIIll.getPaletteEntry(lllllllllllllllIllIllllIlIlllIll));
            }
        }
        final int lllllllllllllllllIIIllIlIllIllll = lllllllllllllllIllIllllIlIllIllI;
        final int lllllllllllllllllIIIllIlIllIlllI = 4096;
        IntToLongFunction lllllllllllllllllIIIllIlIllIlIII;
        if (lllllllllllllllIllIllllIlIllIllI == 14) {
            Objects.requireNonNull(lllllllllllllllIllIllllIlIllIIll);
            lllllllllllllllllIIIllIlIllIlIII = lllllllllllllllIllIllllIlIllIIll::getFlatBlock;
        }
        else {
            Objects.requireNonNull(lllllllllllllllIllIllllIlIllIIll);
            lllllllllllllllllIIIllIlIllIlIII = lllllllllllllllIllIllllIlIllIIll::getPaletteIndex;
        }
        final long[] lllllllllllllllIllIllllIlIllIlIl = CompactArrayUtil.createCompactArray(lllllllllllllllllIIIllIlIllIllll, lllllllllllllllllIIIllIlIllIlllI, lllllllllllllllllIIIllIlIllIlIII);
        Type.VAR_INT.writePrimitive(lllllllllllllllIllIllllIlIllIlII, lllllllllllllllIllIllllIlIllIlIl.length);
        final String lllllllllllllllIllIllllIlIllIIII = (Object)lllllllllllllllIllIllllIlIllIlIl;
        final double lllllllllllllllIllIllllIlIlIllll = lllllllllllllllIllIllllIlIllIIII.length;
        for (float lllllllllllllllIllIllllIlIlIlllI = 0; lllllllllllllllIllIllllIlIlIlllI < lllllllllllllllIllIllllIlIlIllll; ++lllllllllllllllIllIllllIlIlIlllI) {
            final long lllllllllllllllIllIllllIlIlllIlI = lllllllllllllllIllIllllIlIllIIII[lllllllllllllllIllIllllIlIlIlllI];
            lllllllllllllllIllIllllIlIllIlII.writeLong(lllllllllllllllIllIllllIlIlllIlI);
        }
    }
    
    public ChunkSectionType1_13() {
        super("Chunk Section Type", ChunkSection.class);
    }
}
