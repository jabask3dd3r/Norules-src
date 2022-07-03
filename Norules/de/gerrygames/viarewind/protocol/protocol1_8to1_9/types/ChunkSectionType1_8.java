package de.gerrygames.viarewind.protocol.protocol1_8to1_9.types;

import com.viaversion.viaversion.api.type.*;
import io.netty.buffer.*;
import com.viaversion.viaversion.api.minecraft.chunks.*;
import java.nio.*;

public class ChunkSectionType1_8 extends Type<ChunkSection>
{
    @Override
    public ChunkSection read(final ByteBuf lllllllllllllIlIlIIllIlIlllIllll) throws Exception {
        final ChunkSection lllllllllllllIlIlIIllIlIllllIIlI = new ChunkSectionImpl(true);
        final byte[] lllllllllllllIlIlIIllIlIllllIIIl = new byte[8192];
        lllllllllllllIlIlIIllIlIlllIllll.readBytes(lllllllllllllIlIlIIllIlIllllIIIl);
        final ShortBuffer lllllllllllllIlIlIIllIlIllllIIII = ByteBuffer.wrap(lllllllllllllIlIlIIllIlIllllIIIl).order(ByteOrder.LITTLE_ENDIAN).asShortBuffer();
        for (int lllllllllllllIlIlIIllIlIllllIlIl = 0; lllllllllllllIlIlIIllIlIllllIlIl < 4096; ++lllllllllllllIlIlIIllIlIllllIlIl) {
            final int lllllllllllllIlIlIIllIlIlllllIII = lllllllllllllIlIlIIllIlIllllIIII.get();
            final int lllllllllllllIlIlIIllIlIllllIlll = lllllllllllllIlIlIIllIlIlllllIII >> 4;
            final int lllllllllllllIlIlIIllIlIllllIllI = lllllllllllllIlIlIIllIlIlllllIII & 0xF;
            lllllllllllllIlIlIIllIlIllllIIlI.setBlockWithData(lllllllllllllIlIlIIllIlIllllIlIl, lllllllllllllIlIlIIllIlIllllIlll, lllllllllllllIlIlIIllIlIllllIllI);
        }
        return lllllllllllllIlIlIIllIlIllllIIlI;
    }
    
    @Override
    public void write(final ByteBuf lllllllllllllIlIlIIllIlIllIllIlI, final ChunkSection lllllllllllllIlIlIIllIlIllIllIIl) throws Exception {
        for (int lllllllllllllIlIlIIllIlIllIllllI = 0; lllllllllllllIlIlIIllIlIllIllllI < 16; ++lllllllllllllIlIlIIllIlIllIllllI) {
            for (int lllllllllllllIlIlIIllIlIllIlllll = 0; lllllllllllllIlIlIIllIlIllIlllll < 16; ++lllllllllllllIlIlIIllIlIllIlllll) {
                for (int lllllllllllllIlIlIIllIlIlllIIIII = 0; lllllllllllllIlIlIIllIlIlllIIIII < 16; ++lllllllllllllIlIlIIllIlIlllIIIII) {
                    final int lllllllllllllIlIlIIllIlIlllIIIIl = lllllllllllllIlIlIIllIlIllIllIIl.getFlatBlock(lllllllllllllIlIlIIllIlIlllIIIII, lllllllllllllIlIlIIllIlIllIllllI, lllllllllllllIlIlIIllIlIllIlllll);
                    lllllllllllllIlIlIIllIlIllIllIlI.writeByte(lllllllllllllIlIlIIllIlIlllIIIIl);
                    lllllllllllllIlIlIIllIlIllIllIlI.writeByte(lllllllllllllIlIlIIllIlIlllIIIIl >> 8);
                }
            }
        }
    }
    
    public ChunkSectionType1_8() {
        super("Chunk Section Type", ChunkSection.class);
    }
}
