package de.gerrygames.viarewind.protocol.protocol1_7_6_10to1_8.chunks;

import com.viaversion.viaversion.api.protocol.packet.*;
import com.viaversion.viaversion.api.type.*;
import com.viaversion.viaversion.api.type.types.*;
import java.util.zip.*;
import de.gerrygames.viarewind.storage.*;
import de.gerrygames.viarewind.protocol.protocol1_7_6_10to1_8.items.*;
import io.netty.buffer.*;
import de.gerrygames.viarewind.replacement.*;

public class ChunkPacketTransformer
{
    private static int calcSize(final int llIIlIIIlllIIl, final boolean llIIlIIIllIIIl, final boolean llIIlIIIllIIII) {
        final int llIIlIIIllIllI = llIIlIIIlllIIl * 2 * 16 * 16 * 16;
        final int llIIlIIIllIlIl = llIIlIIIlllIIl * 16 * 16 * 16 / 2;
        final int llIIlIIIllIlII = llIIlIIIllIIIl ? (llIIlIIIlllIIl * 16 * 16 * 16 / 2) : 0;
        final int llIIlIIIllIIll = llIIlIIIllIIII ? 256 : 0;
        return llIIlIIIllIllI + llIIlIIIllIlIl + llIIlIIIllIlII + llIIlIIIllIIll;
    }
    
    public static void transformChunkBulk(final PacketWrapper llIIlIIIIlIlIl) throws Exception {
        final boolean llIIlIIIIlIlII = llIIlIIIIlIlIl.read((Type<Boolean>)Type.BOOLEAN);
        final int llIIlIIIIlIIll = llIIlIIIIlIlIl.read((Type<Integer>)Type.VAR_INT);
        final int[] llIIlIIIIlIIlI = new int[llIIlIIIIlIIll];
        final int[] llIIlIIIIlIIIl = new int[llIIlIIIIlIIll];
        final int[] llIIlIIIIlIIII = new int[llIIlIIIIlIIll];
        final byte[][] llIIlIIIIIllll = new byte[llIIlIIIIlIIll][];
        for (int llIIlIIIIllIll = 0; llIIlIIIIllIll < llIIlIIIIlIIll; ++llIIlIIIIllIll) {
            llIIlIIIIlIIlI[llIIlIIIIllIll] = llIIlIIIIlIlIl.read((Type<Integer>)Type.INT);
            llIIlIIIIlIIIl[llIIlIIIIllIll] = llIIlIIIIlIlIl.read((Type<Integer>)Type.INT);
            llIIlIIIIlIIII[llIIlIIIIllIll] = llIIlIIIIlIlIl.read((Type<Integer>)Type.UNSIGNED_SHORT);
        }
        int llIIlIIIIIlllI = 0;
        for (int llIIlIIIIllIII = 0; llIIlIIIIllIII < llIIlIIIIlIIll; ++llIIlIIIIllIII) {
            final int llIIlIIIIllIlI = calcSize(Integer.bitCount(llIIlIIIIlIIII[llIIlIIIIllIII]), llIIlIIIIlIlII, true);
            final CustomByteType llIIlIIIIllIIl = new CustomByteType(llIIlIIIIllIlI);
            llIIlIIIIIllll[llIIlIIIIllIII] = transformChunkData(llIIlIIIIlIlIl.read((Type<byte[]>)llIIlIIIIllIIl), llIIlIIIIlIIII[llIIlIIIIllIII], llIIlIIIIlIlII, true);
            llIIlIIIIIlllI += llIIlIIIIIllll[llIIlIIIIllIII].length;
        }
        llIIlIIIIlIlIl.write(Type.SHORT, (short)llIIlIIIIlIIll);
        final byte[] llIIlIIIIIllIl = new byte[llIIlIIIIIlllI];
        int llIIlIIIIIllII = 0;
        for (int llIIlIIIIlIlll = 0; llIIlIIIIlIlll < llIIlIIIIlIIll; ++llIIlIIIIlIlll) {
            System.arraycopy(llIIlIIIIIllll[llIIlIIIIlIlll], 0, llIIlIIIIIllIl, llIIlIIIIIllII, llIIlIIIIIllll[llIIlIIIIlIlll].length);
            llIIlIIIIIllII += llIIlIIIIIllll[llIIlIIIIlIlll].length;
        }
        final Deflater llIIlIIIIIlIll = new Deflater(4);
        llIIlIIIIIlIll.reset();
        llIIlIIIIIlIll.setInput(llIIlIIIIIllIl);
        llIIlIIIIIlIll.finish();
        final byte[] llIIlIIIIIlIlI = new byte[llIIlIIIIIllIl.length + 100];
        final int llIIlIIIIIlIIl = llIIlIIIIIlIll.deflate(llIIlIIIIIlIlI);
        final byte[] llIIlIIIIIlIII = new byte[llIIlIIIIIlIIl];
        System.arraycopy(llIIlIIIIIlIlI, 0, llIIlIIIIIlIII, 0, llIIlIIIIIlIIl);
        llIIlIIIIlIlIl.write(Type.INT, llIIlIIIIIlIIl);
        llIIlIIIIlIlIl.write(Type.BOOLEAN, llIIlIIIIlIlII);
        final CustomByteType llIIlIIIIIIlll = new CustomByteType(llIIlIIIIIlIIl);
        llIIlIIIIlIlIl.write((Type<byte[]>)llIIlIIIIIIlll, llIIlIIIIIlIII);
        for (int llIIlIIIIlIllI = 0; llIIlIIIIlIllI < llIIlIIIIlIIll; ++llIIlIIIIlIllI) {
            llIIlIIIIlIlIl.write(Type.INT, llIIlIIIIlIIlI[llIIlIIIIlIllI]);
            llIIlIIIIlIlIl.write(Type.INT, llIIlIIIIlIIIl[llIIlIIIIlIllI]);
            llIIlIIIIlIlIl.write(Type.SHORT, (short)llIIlIIIIlIIII[llIIlIIIIlIllI]);
            llIIlIIIIlIlIl.write(Type.SHORT, (Short)0);
        }
    }
    
    private static byte[] transformChunkData(byte[] llIIlIIlIIlllI, final int llIIlIIlIlIlIl, final boolean llIIlIIlIIllII, final boolean llIIlIIlIIlIll) {
        int llIIlIIlIlIIlI = 0;
        final ByteBuf llIIlIIlIlIIIl = Unpooled.buffer();
        final ByteBuf llIIlIIlIlIIII = Unpooled.buffer();
        for (int llIIlIIlIlIlll = 0; llIIlIIlIlIlll < 16; ++llIIlIIlIlIlll) {
            if ((llIIlIIlIlIlIl & 1 << llIIlIIlIlIlll) != 0x0) {
                byte llIIlIIlIllIII = 0;
                for (int llIIlIIlIllIIl = 0; llIIlIIlIllIIl < 4096; ++llIIlIIlIllIIl) {
                    final short llIIlIIlIlllIl = (short)((llIIlIIlIIlllI[llIIlIIlIlIIlI + 1] & 0xFF) << 8 | (llIIlIIlIIlllI[llIIlIIlIlIIlI] & 0xFF));
                    llIIlIIlIlIIlI += 2;
                    int llIIlIIlIlllII = BlockState.extractId(llIIlIIlIlllIl);
                    int llIIlIIlIllIll = BlockState.extractData(llIIlIIlIlllIl);
                    final Replacement llIIlIIlIllIlI = ReplacementRegistry1_7_6_10to1_8.getReplacement(llIIlIIlIlllII, llIIlIIlIllIll);
                    if (llIIlIIlIllIlI != null) {
                        llIIlIIlIlllII = llIIlIIlIllIlI.getId();
                        llIIlIIlIllIll = llIIlIIlIllIlI.replaceData(llIIlIIlIllIll);
                    }
                    llIIlIIlIlIIIl.writeByte(llIIlIIlIlllII);
                    if (llIIlIIlIllIIl % 2 == 0) {
                        llIIlIIlIllIII = (byte)(llIIlIIlIllIll & 0xF);
                    }
                    else {
                        llIIlIIlIlIIII.writeByte(llIIlIIlIllIII | (llIIlIIlIllIll & 0xF) << 4);
                    }
                }
            }
        }
        llIIlIIlIlIIIl.writeBytes(llIIlIIlIlIIII);
        llIIlIIlIlIIII.release();
        final int llIIlIIlIIllll = Integer.bitCount(llIIlIIlIlIlIl);
        llIIlIIlIlIIIl.writeBytes(llIIlIIlIIlllI, llIIlIIlIlIIlI, 2048 * llIIlIIlIIllll);
        llIIlIIlIlIIlI += 2048 * llIIlIIlIIllll;
        if (llIIlIIlIIllII) {
            llIIlIIlIlIIIl.writeBytes(llIIlIIlIIlllI, llIIlIIlIlIIlI, 2048 * llIIlIIlIIllll);
            llIIlIIlIlIIlI += 2048 * llIIlIIlIIllll;
        }
        if (llIIlIIlIIlIll && llIIlIIlIlIIlI + 256 <= llIIlIIlIIlllI.length) {
            llIIlIIlIlIIIl.writeBytes(llIIlIIlIIlllI, llIIlIIlIlIIlI, 256);
            llIIlIIlIlIIlI += 256;
        }
        llIIlIIlIIlllI = new byte[llIIlIIlIlIIIl.readableBytes()];
        llIIlIIlIlIIIl.readBytes(llIIlIIlIIlllI);
        llIIlIIlIlIIIl.release();
        return llIIlIIlIIlllI;
    }
}
