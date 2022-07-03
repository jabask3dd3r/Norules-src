package com.viaversion.viaversion.bungee.handlers;

import io.netty.handler.codec.*;
import io.netty.buffer.*;
import com.viaversion.viaversion.api.connection.*;
import io.netty.channel.*;
import java.util.*;
import java.util.function.*;
import com.viaversion.viaversion.exception.*;

@ChannelHandler.Sharable
public class BungeeDecodeHandler extends MessageToMessageDecoder<ByteBuf>
{
    private final /* synthetic */ UserConnection info;
    
    protected void decode(final ChannelHandlerContext lllllllllllllIIIlIlIIIlIlIIIllII, final ByteBuf lllllllllllllIIIlIlIIIlIlIIIlIll, final List<Object> lllllllllllllIIIlIlIIIlIlIIIlIlI) throws Exception {
        if (!lllllllllllllIIIlIlIIIlIlIIIllII.channel().isActive()) {
            throw CancelDecoderException.generate(null);
        }
        if (!this.info.checkServerboundPacket()) {
            throw CancelDecoderException.generate(null);
        }
        if (!this.info.shouldTransformPacket()) {
            lllllllllllllIIIlIlIIIlIlIIIlIlI.add(lllllllllllllIIIlIlIIIlIlIIIlIll.retain());
            return;
        }
        final ByteBuf lllllllllllllIIIlIlIIIlIlIIIlIIl = lllllllllllllIIIlIlIIIlIlIIIllII.alloc().buffer().writeBytes(lllllllllllllIIIlIlIIIlIlIIIlIll);
        try {
            this.info.transformServerbound(lllllllllllllIIIlIlIIIlIlIIIlIIl, (Function<Throwable, Exception>)CancelDecoderException::generate);
            lllllllllllllIIIlIlIIIlIlIIIlIlI.add(lllllllllllllIIIlIlIIIlIlIIIlIIl.retain());
        }
        finally {
            lllllllllllllIIIlIlIIIlIlIIIlIIl.release();
        }
    }
    
    public void exceptionCaught(final ChannelHandlerContext lllllllllllllIIIlIlIIIlIIlllllIl, final Throwable lllllllllllllIIIlIlIIIlIIlllllII) throws Exception {
        if (lllllllllllllIIIlIlIIIlIIlllllII instanceof CancelCodecException) {
            return;
        }
        super.exceptionCaught(lllllllllllllIIIlIlIIIlIIlllllIl, lllllllllllllIIIlIlIIIlIIlllllII);
    }
    
    public BungeeDecodeHandler(final UserConnection lllllllllllllIIIlIlIIIlIlIIlIllI) {
        this.info = lllllllllllllIIIlIlIIIlIlIIlIllI;
    }
}
