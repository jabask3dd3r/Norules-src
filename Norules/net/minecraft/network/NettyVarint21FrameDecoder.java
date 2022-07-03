package net.minecraft.network;

import io.netty.channel.*;
import java.util.*;
import io.netty.buffer.*;
import io.netty.handler.codec.*;

public class NettyVarint21FrameDecoder extends ByteToMessageDecoder
{
    protected void decode(final ChannelHandlerContext lllllllllllllIIIIlIIIIIlllllIlll, final ByteBuf lllllllllllllIIIIlIIIIIlllllIllI, final List<Object> lllllllllllllIIIIlIIIIIlllllIlIl) throws Exception {
        lllllllllllllIIIIlIIIIIlllllIllI.markReaderIndex();
        final byte[] lllllllllllllIIIIlIIIIIlllllIlII = new byte[3];
        for (int lllllllllllllIIIIlIIIIIlllllIIll = 0; lllllllllllllIIIIlIIIIIlllllIIll < lllllllllllllIIIIlIIIIIlllllIlII.length; ++lllllllllllllIIIIlIIIIIlllllIIll) {
            if (!lllllllllllllIIIIlIIIIIlllllIllI.isReadable()) {
                lllllllllllllIIIIlIIIIIlllllIllI.resetReaderIndex();
                return;
            }
            lllllllllllllIIIIlIIIIIlllllIlII[lllllllllllllIIIIlIIIIIlllllIIll] = lllllllllllllIIIIlIIIIIlllllIllI.readByte();
            if (lllllllllllllIIIIlIIIIIlllllIlII[lllllllllllllIIIIlIIIIIlllllIIll] >= 0) {
                final PacketBuffer lllllllllllllIIIIlIIIIIlllllIIlI = new PacketBuffer(Unpooled.wrappedBuffer(lllllllllllllIIIIlIIIIIlllllIlII));
                try {
                    final int lllllllllllllIIIIlIIIIIlllllIIIl = lllllllllllllIIIIlIIIIIlllllIIlI.readVarIntFromBuffer();
                    if (lllllllllllllIIIIlIIIIIlllllIllI.readableBytes() >= lllllllllllllIIIIlIIIIIlllllIIIl) {
                        lllllllllllllIIIIlIIIIIlllllIlIl.add(lllllllllllllIIIIlIIIIIlllllIllI.readBytes(lllllllllllllIIIIlIIIIIlllllIIIl));
                        return;
                    }
                    lllllllllllllIIIIlIIIIIlllllIllI.resetReaderIndex();
                }
                finally {
                    lllllllllllllIIIIlIIIIIlllllIIlI.release();
                }
                lllllllllllllIIIIlIIIIIlllllIIlI.release();
                return;
            }
        }
        throw new CorruptedFrameException("length wider than 21-bit");
    }
}
