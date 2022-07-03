package de.gerrygames.viarewind.protocol.protocol1_7_6_10to1_8.types;

import com.viaversion.viaversion.api.type.*;
import com.viaversion.viaversion.protocols.protocol1_9_3to1_9_1_2.storage.*;
import io.netty.buffer.*;
import com.viaversion.viaversion.api.minecraft.*;
import java.util.zip.*;
import com.viaversion.viaversion.api.minecraft.chunks.*;

public class Chunk1_7_10Type extends PartialType<Chunk, ClientWorld>
{
    public Chunk1_7_10Type(final ClientWorld lllllllllllllIllIIIIllIllllIIIlI) {
        super(lllllllllllllIllIIIIllIllllIIIlI, Chunk.class);
    }
    
    @Override
    public Chunk read(final ByteBuf lllllllllllllIllIIIIllIlllIllllI, final ClientWorld lllllllllllllIllIIIIllIlllIlllIl) throws Exception {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public void write(final ByteBuf lllllllllllllIllIIIIllIlllIIIIII, final ClientWorld lllllllllllllIllIIIIllIllIllIlIl, final Chunk lllllllllllllIllIIIIllIllIllIlII) throws Exception {
        lllllllllllllIllIIIIllIlllIIIIII.writeInt(lllllllllllllIllIIIIllIllIllIlII.getX());
        lllllllllllllIllIIIIllIlllIIIIII.writeInt(lllllllllllllIllIIIIllIllIllIlII.getZ());
        lllllllllllllIllIIIIllIlllIIIIII.writeBoolean(lllllllllllllIllIIIIllIllIllIlII.isFullChunk());
        lllllllllllllIllIIIIllIlllIIIIII.writeShort(lllllllllllllIllIIIIllIllIllIlII.getBitmask());
        lllllllllllllIllIIIIllIlllIIIIII.writeShort(0);
        final ByteBuf lllllllllllllIllIIIIllIllIllllIl = lllllllllllllIllIIIIllIlllIIIIII.alloc().buffer();
        final ByteBuf lllllllllllllIllIIIIllIllIllllII = lllllllllllllIllIIIIllIlllIIIIII.alloc().buffer();
        for (int lllllllllllllIllIIIIllIlllIIIlll = 0; lllllllllllllIllIIIIllIlllIIIlll < lllllllllllllIllIIIIllIllIllIlII.getSections().length; ++lllllllllllllIllIIIIllIlllIIIlll) {
            if ((lllllllllllllIllIIIIllIllIllIlII.getBitmask() & 1 << lllllllllllllIllIIIIllIlllIIIlll) != 0x0) {
                final ChunkSection lllllllllllllIllIIIIllIlllIIlIII = lllllllllllllIllIIIIllIllIllIlII.getSections()[lllllllllllllIllIIIIllIlllIIIlll];
                for (int lllllllllllllIllIIIIllIlllIIlIIl = 0; lllllllllllllIllIIIIllIlllIIlIIl < 16; ++lllllllllllllIllIIIIllIlllIIlIIl) {
                    for (int lllllllllllllIllIIIIllIlllIIlIlI = 0; lllllllllllllIllIIIIllIlllIIlIlI < 16; ++lllllllllllllIllIIIIllIlllIIlIlI) {
                        int lllllllllllllIllIIIIllIlllIIlIll = 0;
                        for (int lllllllllllllIllIIIIllIlllIIllII = 0; lllllllllllllIllIIIIllIlllIIllII < 16; ++lllllllllllllIllIIIIllIlllIIllII) {
                            final int lllllllllllllIllIIIIllIlllIIlllI = lllllllllllllIllIIIIllIlllIIlIII.getFlatBlock(lllllllllllllIllIIIIllIlllIIllII, lllllllllllllIllIIIIllIlllIIlIIl, lllllllllllllIllIIIIllIlllIIlIlI);
                            lllllllllllllIllIIIIllIllIllllIl.writeByte(lllllllllllllIllIIIIllIlllIIlllI >> 4);
                            final int lllllllllllllIllIIIIllIlllIIllIl = lllllllllllllIllIIIIllIlllIIlllI & 0xF;
                            if (lllllllllllllIllIIIIllIlllIIllII % 2 == 0) {
                                lllllllllllllIllIIIIllIlllIIlIll = lllllllllllllIllIIIIllIlllIIllIl;
                            }
                            else {
                                lllllllllllllIllIIIIllIllIllllII.writeByte(lllllllllllllIllIIIIllIlllIIllIl << 4 | lllllllllllllIllIIIIllIlllIIlIll);
                            }
                        }
                    }
                }
            }
        }
        lllllllllllllIllIIIIllIllIllllIl.writeBytes(lllllllllllllIllIIIIllIllIllllII);
        lllllllllllllIllIIIIllIllIllllII.release();
        for (int lllllllllllllIllIIIIllIlllIIIllI = 0; lllllllllllllIllIIIIllIlllIIIllI < lllllllllllllIllIIIIllIllIllIlII.getSections().length; ++lllllllllllllIllIIIIllIlllIIIllI) {
            if ((lllllllllllllIllIIIIllIllIllIlII.getBitmask() & 1 << lllllllllllllIllIIIIllIlllIIIllI) != 0x0) {
                lllllllllllllIllIIIIllIllIllIlII.getSections()[lllllllllllllIllIIIIllIlllIIIllI].getLight().writeBlockLight(lllllllllllllIllIIIIllIllIllllIl);
            }
        }
        final boolean lllllllllllllIllIIIIllIllIlllIll = lllllllllllllIllIIIIllIllIllIlIl != null && lllllllllllllIllIIIIllIllIllIlIl.getEnvironment() == Environment.NORMAL;
        if (lllllllllllllIllIIIIllIllIlllIll) {
            for (int lllllllllllllIllIIIIllIlllIIIlIl = 0; lllllllllllllIllIIIIllIlllIIIlIl < lllllllllllllIllIIIIllIllIllIlII.getSections().length; ++lllllllllllllIllIIIIllIlllIIIlIl) {
                if ((lllllllllllllIllIIIIllIllIllIlII.getBitmask() & 1 << lllllllllllllIllIIIIllIlllIIIlIl) != 0x0) {
                    lllllllllllllIllIIIIllIllIllIlII.getSections()[lllllllllllllIllIIIIllIlllIIIlIl].getLight().writeSkyLight(lllllllllllllIllIIIIllIllIllllIl);
                }
            }
        }
        if (lllllllllllllIllIIIIllIllIllIlII.isFullChunk() && lllllllllllllIllIIIIllIllIllIlII.isBiomeData()) {
            final int[] biomeData = lllllllllllllIllIIIIllIllIllIlII.getBiomeData();
            final double lllllllllllllIllIIIIllIllIlIllll = biomeData.length;
            for (byte lllllllllllllIllIIIIllIllIlIlllI = 0; lllllllllllllIllIIIIllIllIlIlllI < lllllllllllllIllIIIIllIllIlIllll; ++lllllllllllllIllIIIIllIllIlIlllI) {
                final int lllllllllllllIllIIIIllIlllIIIlII = biomeData[lllllllllllllIllIIIIllIllIlIlllI];
                lllllllllllllIllIIIIllIllIllllIl.writeByte((int)(byte)lllllllllllllIllIIIIllIlllIIIlII);
            }
        }
        lllllllllllllIllIIIIllIllIllllIl.readerIndex(0);
        final byte[] lllllllllllllIllIIIIllIllIlllIlI = new byte[lllllllllllllIllIIIIllIllIllllIl.readableBytes()];
        lllllllllllllIllIIIIllIllIllllIl.readBytes(lllllllllllllIllIIIIllIllIlllIlI);
        lllllllllllllIllIIIIllIllIllllIl.release();
        final Deflater lllllllllllllIllIIIIllIllIlllIIl = new Deflater(4);
        try {
            lllllllllllllIllIIIIllIllIlllIIl.setInput(lllllllllllllIllIIIIllIllIlllIlI, 0, lllllllllllllIllIIIIllIllIlllIlI.length);
            lllllllllllllIllIIIIllIllIlllIIl.finish();
            final byte[] lllllllllllllIllIIIIllIlllIIIIll = new byte[lllllllllllllIllIIIIllIllIlllIlI.length];
            final int lllllllllllllIllIIIIllIlllIIIIlI = lllllllllllllIllIIIIllIllIlllIIl.deflate(lllllllllllllIllIIIIllIlllIIIIll);
        }
        finally {
            lllllllllllllIllIIIIllIllIlllIIl.end();
        }
        final int lllllllllllllIllIIIIllIllIllIlll;
        lllllllllllllIllIIIIllIlllIIIIII.writeInt(lllllllllllllIllIIIIllIllIllIlll);
        final byte[] lllllllllllllIllIIIIllIllIlllIII;
        lllllllllllllIllIIIIllIlllIIIIII.writeBytes(lllllllllllllIllIIIIllIllIlllIII, 0, lllllllllllllIllIIIIllIllIllIlll);
    }
}
