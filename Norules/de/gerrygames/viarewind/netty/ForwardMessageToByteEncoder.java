package de.gerrygames.viarewind.netty;

import io.netty.handler.codec.*;
import io.netty.buffer.*;
import io.netty.channel.*;

public class ForwardMessageToByteEncoder extends MessageToByteEncoder<ByteBuf>
{
    protected void encode(final ChannelHandlerContext lllllllllllllIIlIlIIlIllIlIlIIlI, final ByteBuf lllllllllllllIIlIlIIlIllIlIlIIIl, final ByteBuf lllllllllllllIIlIlIIlIllIlIIlllI) throws Exception {
        lllllllllllllIIlIlIIlIllIlIIlllI.writeBytes(lllllllllllllIIlIlIIlIllIlIlIIIl);
    }
}
