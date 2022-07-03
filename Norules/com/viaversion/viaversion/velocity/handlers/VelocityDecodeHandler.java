package com.viaversion.viaversion.velocity.handlers;

import io.netty.handler.codec.*;
import io.netty.buffer.*;
import com.viaversion.viaversion.api.connection.*;
import io.netty.channel.*;
import java.util.*;
import com.viaversion.viaversion.exception.*;
import java.util.function.*;

@ChannelHandler.Sharable
public class VelocityDecodeHandler extends MessageToMessageDecoder<ByteBuf>
{
    private final /* synthetic */ UserConnection info;
    
    public void userEventTriggered(final ChannelHandlerContext lllllllllllllllIIlIlIIIIllIllIlI, final Object lllllllllllllllIIlIlIIIIllIllIIl) throws Exception {
        if (lllllllllllllllIIlIlIIIIllIllIIl != VelocityChannelInitializer.COMPRESSION_ENABLED_EVENT) {
            super.userEventTriggered(lllllllllllllllIIlIlIIIIllIllIlI, lllllllllllllllIIlIlIIIIllIllIIl);
            return;
        }
        final ChannelPipeline lllllllllllllllIIlIlIIIIllIllllI = lllllllllllllllIIlIlIIIIllIllIlI.pipeline();
        final ChannelHandler lllllllllllllllIIlIlIIIIllIlllIl = lllllllllllllllIIlIlIIIIllIllllI.get("via-encoder");
        lllllllllllllllIIlIlIIIIllIllllI.remove(lllllllllllllllIIlIlIIIIllIlllIl);
        lllllllllllllllIIlIlIIIIllIllllI.addBefore("minecraft-encoder", "via-encoder", lllllllllllllllIIlIlIIIIllIlllIl);
        final ChannelHandler lllllllllllllllIIlIlIIIIllIlllII = lllllllllllllllIIlIlIIIIllIllllI.get("via-decoder");
        lllllllllllllllIIlIlIIIIllIllllI.remove(lllllllllllllllIIlIlIIIIllIlllII);
        lllllllllllllllIIlIlIIIIllIllllI.addBefore("minecraft-decoder", "via-decoder", lllllllllllllllIIlIlIIIIllIlllII);
        super.userEventTriggered(lllllllllllllllIIlIlIIIIllIllIlI, lllllllllllllllIIlIlIIIIllIllIIl);
    }
    
    public void exceptionCaught(final ChannelHandlerContext lllllllllllllllIIlIlIIIIlllIllII, final Throwable lllllllllllllllIIlIlIIIIlllIlIll) throws Exception {
        if (lllllllllllllllIIlIlIIIIlllIlIll instanceof CancelCodecException) {
            return;
        }
        super.exceptionCaught(lllllllllllllllIIlIlIIIIlllIllII, lllllllllllllllIIlIlIIIIlllIlIll);
    }
    
    public VelocityDecodeHandler(final UserConnection lllllllllllllllIIlIlIIIlIIIIIlII) {
        this.info = lllllllllllllllIIlIlIIIlIIIIIlII;
    }
    
    protected void decode(final ChannelHandlerContext lllllllllllllllIIlIlIIIIllllIlIl, final ByteBuf lllllllllllllllIIlIlIIIIllllIlII, final List<Object> lllllllllllllllIIlIlIIIIllllIIll) throws Exception {
        if (!this.info.checkIncomingPacket()) {
            throw CancelDecoderException.generate(null);
        }
        if (!this.info.shouldTransformPacket()) {
            lllllllllllllllIIlIlIIIIllllIIll.add(lllllllllllllllIIlIlIIIIllllIlII.retain());
            return;
        }
        final ByteBuf lllllllllllllllIIlIlIIIIllllIlll = lllllllllllllllIIlIlIIIIllllIlIl.alloc().buffer().writeBytes(lllllllllllllllIIlIlIIIIllllIlII);
        try {
            this.info.transformIncoming(lllllllllllllllIIlIlIIIIllllIlll, (Function<Throwable, Exception>)CancelDecoderException::generate);
            lllllllllllllllIIlIlIIIIllllIIll.add(lllllllllllllllIIlIlIIIIllllIlll.retain());
        }
        finally {
            lllllllllllllllIIlIlIIIIllllIlll.release();
        }
    }
}
