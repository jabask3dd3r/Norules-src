package net.minecraft.network;

import io.netty.handler.codec.*;
import io.netty.buffer.*;
import io.netty.channel.*;

@ChannelHandler.Sharable
public class NettyVarint21FrameEncoder extends MessageToByteEncoder<ByteBuf>
{
    protected void encode(final ChannelHandlerContext lllllllllllllIllIllllIllIIIIIIII, final ByteBuf lllllllllllllIllIllllIlIllllllll, final ByteBuf lllllllllllllIllIllllIlIllllllIl) throws Exception {
        final int lllllllllllllIllIllllIlIlllllIll = lllllllllllllIllIllllIlIllllllll.readableBytes();
        final int lllllllllllllIllIllllIlIlllllIIl = PacketBuffer.getVarIntSize(lllllllllllllIllIllllIlIlllllIll);
        if (lllllllllllllIllIllllIlIlllllIIl > 3) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder("unable to fit ").append(lllllllllllllIllIllllIlIlllllIll).append(" into ").append(3)));
        }
        final PacketBuffer lllllllllllllIllIllllIlIlllllIII = new PacketBuffer(lllllllllllllIllIllllIlIllllllIl);
        lllllllllllllIllIllllIlIlllllIII.ensureWritable(lllllllllllllIllIllllIlIlllllIIl + lllllllllllllIllIllllIlIlllllIll);
        lllllllllllllIllIllllIlIlllllIII.writeVarIntToBuffer(lllllllllllllIllIllllIlIlllllIll);
        lllllllllllllIllIllllIlIlllllIII.writeBytes(lllllllllllllIllIllllIlIllllllll, lllllllllllllIllIllllIlIllllllll.readerIndex(), lllllllllllllIllIllllIlIlllllIll);
    }
}
