package com.viaversion.viaversion.velocity.handlers;

import io.netty.handler.codec.*;
import io.netty.buffer.*;
import com.viaversion.viaversion.api.connection.*;
import io.netty.channel.*;
import java.util.*;
import com.viaversion.viaversion.exception.*;
import java.util.function.*;

@ChannelHandler.Sharable
public class VelocityEncodeHandler extends MessageToMessageEncoder<ByteBuf>
{
    private final /* synthetic */ UserConnection info;
    
    public VelocityEncodeHandler(final UserConnection lllllllllllllIllIlllIllIllIlIlll) {
        this.info = lllllllllllllIllIlllIllIllIlIlll;
    }
    
    public void exceptionCaught(final ChannelHandlerContext lllllllllllllIllIlllIllIllIIIIIl, final Throwable lllllllllllllIllIlllIllIllIIIIII) throws Exception {
        if (lllllllllllllIllIlllIllIllIIIIII instanceof CancelCodecException) {
            return;
        }
        super.exceptionCaught(lllllllllllllIllIlllIllIllIIIIIl, lllllllllllllIllIlllIllIllIIIIII);
    }
    
    protected void encode(final ChannelHandlerContext lllllllllllllIllIlllIllIllIIllll, final ByteBuf lllllllllllllIllIlllIllIllIIlllI, final List<Object> lllllllllllllIllIlllIllIllIIllIl) throws Exception {
        if (!this.info.checkOutgoingPacket()) {
            throw CancelEncoderException.generate(null);
        }
        if (!this.info.shouldTransformPacket()) {
            lllllllllllllIllIlllIllIllIIllIl.add(lllllllllllllIllIlllIllIllIIlllI.retain());
            return;
        }
        final ByteBuf lllllllllllllIllIlllIllIllIIllII = lllllllllllllIllIlllIllIllIIllll.alloc().buffer().writeBytes(lllllllllllllIllIlllIllIllIIlllI);
        try {
            this.info.transformOutgoing(lllllllllllllIllIlllIllIllIIllII, (Function<Throwable, Exception>)CancelEncoderException::generate);
            lllllllllllllIllIlllIllIllIIllIl.add(lllllllllllllIllIlllIllIllIIllII.retain());
        }
        finally {
            lllllllllllllIllIlllIllIllIIllII.release();
        }
    }
}
