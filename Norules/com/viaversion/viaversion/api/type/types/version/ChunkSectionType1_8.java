package com.viaversion.viaversion.api.type.types.version;

import com.viaversion.viaversion.api.type.*;
import io.netty.buffer.*;
import com.viaversion.viaversion.api.minecraft.chunks.*;
import java.nio.*;

public class ChunkSectionType1_8 extends Type<ChunkSection>
{
    @Override
    public void write(final ByteBuf lllllllllllllIIIlIlIlIIIIlIlIlIl, final ChunkSection lllllllllllllIIIlIlIlIIIIlIlIlII) throws Exception {
        throw new UnsupportedOperationException();
    }
    
    public ChunkSectionType1_8() {
        super("Chunk Section Type", ChunkSection.class);
    }
    
    @Override
    public ChunkSection read(final ByteBuf lllllllllllllIIIlIlIlIIIIllIIIII) throws Exception {
        final ChunkSection lllllllllllllIIIlIlIlIIIIlIlllll = new ChunkSectionImpl(true);
        lllllllllllllIIIlIlIlIIIIlIlllll.addPaletteEntry(0);
        final ByteBuf lllllllllllllIIIlIlIlIIIIlIllllI = lllllllllllllIIIlIlIlIIIIllIIIII.order(ByteOrder.LITTLE_ENDIAN);
        for (int lllllllllllllIIIlIlIlIIIIllIIIlI = 0; lllllllllllllIIIlIlIlIIIIllIIIlI < 4096; ++lllllllllllllIIIlIlIlIIIIllIIIlI) {
            final int lllllllllllllIIIlIlIlIIIIllIIlIl = lllllllllllllIIIlIlIlIIIIlIllllI.readShort();
            final int lllllllllllllIIIlIlIlIIIIllIIlII = lllllllllllllIIIlIlIlIIIIllIIlIl >> 4;
            final int lllllllllllllIIIlIlIlIIIIllIIIll = lllllllllllllIIIlIlIlIIIIllIIlIl & 0xF;
            lllllllllllllIIIlIlIlIIIIlIlllll.setBlockWithData(lllllllllllllIIIlIlIlIIIIllIIIlI, lllllllllllllIIIlIlIlIIIIllIIlII, lllllllllllllIIIlIlIlIIIIllIIIll);
        }
        return lllllllllllllIIIlIlIlIIIIlIlllll;
    }
}
