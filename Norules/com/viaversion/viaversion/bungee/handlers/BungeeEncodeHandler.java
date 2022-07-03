package com.viaversion.viaversion.bungee.handlers;

import io.netty.handler.codec.*;
import io.netty.buffer.*;
import com.viaversion.viaversion.api.connection.*;
import io.netty.channel.*;
import com.viaversion.viaversion.bungee.util.*;
import java.util.*;
import com.viaversion.viaversion.exception.*;
import java.util.function.*;

@ChannelHandler.Sharable
public class BungeeEncodeHandler extends MessageToMessageEncoder<ByteBuf>
{
    private final /* synthetic */ UserConnection info;
    private /* synthetic */ boolean handledCompression;
    
    public void exceptionCaught(final ChannelHandlerContext lllllllllllllIlIIIIllIlIIIlIllII, final Throwable lllllllllllllIlIIIIllIlIIIlIlIll) throws Exception {
        if (lllllllllllllIlIIIIllIlIIIlIlIll instanceof CancelCodecException) {
            return;
        }
        super.exceptionCaught(lllllllllllllIlIIIIllIlIIIlIllII, lllllllllllllIlIIIIllIlIIIlIlIll);
    }
    
    private void recompress(final ChannelHandlerContext lllllllllllllIlIIIIllIlIIIllIlII, final ByteBuf lllllllllllllIlIIIIllIlIIIllIIll) {
        final ByteBuf lllllllllllllIlIIIIllIlIIIllIlIl = BungeePipelineUtil.compress(lllllllllllllIlIIIIllIlIIIllIlII, lllllllllllllIlIIIIllIlIIIllIIll);
        try {
            lllllllllllllIlIIIIllIlIIIllIIll.clear().writeBytes(lllllllllllllIlIIIIllIlIIIllIlIl);
        }
        finally {
            lllllllllllllIlIIIIllIlIIIllIlIl.release();
        }
    }
    
    public BungeeEncodeHandler(final UserConnection lllllllllllllIlIIIIllIlIIllIlIII) {
        this.info = lllllllllllllIlIIIIllIlIIllIlIII;
    }
    
    protected void encode(final ChannelHandlerContext lllllllllllllIlIIIIllIlIIlIlIlll, final ByteBuf lllllllllllllIlIIIIllIlIIlIllIll, final List<Object> lllllllllllllIlIIIIllIlIIlIlIlIl) throws Exception {
        if (!lllllllllllllIlIIIIllIlIIlIlIlll.channel().isActive()) {
            throw CancelEncoderException.generate(null);
        }
        if (!this.info.checkClientboundPacket()) {
            throw CancelEncoderException.generate(null);
        }
        if (!this.info.shouldTransformPacket()) {
            lllllllllllllIlIIIIllIlIIlIlIlIl.add(lllllllllllllIlIIIIllIlIIlIllIll.retain());
            return;
        }
        final ByteBuf lllllllllllllIlIIIIllIlIIlIllIIl = lllllllllllllIlIIIIllIlIIlIlIlll.alloc().buffer().writeBytes(lllllllllllllIlIIIIllIlIIlIllIll);
        try {
            final boolean lllllllllllllIlIIIIllIlIIlIllllI = this.handleCompressionOrder(lllllllllllllIlIIIIllIlIIlIlIlll, lllllllllllllIlIIIIllIlIIlIllIIl);
            this.info.transformClientbound(lllllllllllllIlIIIIllIlIIlIllIIl, (Function<Throwable, Exception>)CancelEncoderException::generate);
            if (lllllllllllllIlIIIIllIlIIlIllllI) {
                this.recompress(lllllllllllllIlIIIIllIlIIlIlIlll, lllllllllllllIlIIIIllIlIIlIllIIl);
            }
            lllllllllllllIlIIIIllIlIIlIlIlIl.add(lllllllllllllIlIIIIllIlIIlIllIIl.retain());
        }
        finally {
            lllllllllllllIlIIIIllIlIIlIllIIl.release();
        }
    }
    
    private boolean handleCompressionOrder(final ChannelHandlerContext lllllllllllllIlIIIIllIlIIlIIIllI, final ByteBuf lllllllllllllIlIIIIllIlIIlIIIIIl) {
        boolean lllllllllllllIlIIIIllIlIIlIIIlII = false;
        if (!this.handledCompression && lllllllllllllIlIIIIllIlIIlIIIllI.pipeline().names().indexOf("compress") > lllllllllllllIlIIIIllIlIIlIIIllI.pipeline().names().indexOf("via-encoder")) {
            final ByteBuf lllllllllllllIlIIIIllIlIIlIIlIlI = BungeePipelineUtil.decompress(lllllllllllllIlIIIIllIlIIlIIIllI, lllllllllllllIlIIIIllIlIIlIIIIIl);
            if (lllllllllllllIlIIIIllIlIIlIIIIIl != lllllllllllllIlIIIIllIlIIlIIlIlI) {
                try {
                    lllllllllllllIlIIIIllIlIIlIIIIIl.clear().writeBytes(lllllllllllllIlIIIIllIlIIlIIlIlI);
                }
                finally {
                    lllllllllllllIlIIIIllIlIIlIIlIlI.release();
                }
            }
            final ChannelHandler lllllllllllllIlIIIIllIlIIlIIlIIl = lllllllllllllIlIIIIllIlIIlIIIllI.pipeline().get("via-decoder");
            final ChannelHandler lllllllllllllIlIIIIllIlIIlIIlIII = lllllllllllllIlIIIIllIlIIlIIIllI.pipeline().get("via-encoder");
            lllllllllllllIlIIIIllIlIIlIIIllI.pipeline().remove(lllllllllllllIlIIIIllIlIIlIIlIIl);
            lllllllllllllIlIIIIllIlIIlIIIllI.pipeline().remove(lllllllllllllIlIIIIllIlIIlIIlIII);
            lllllllllllllIlIIIIllIlIIlIIIllI.pipeline().addAfter("decompress", "via-decoder", lllllllllllllIlIIIIllIlIIlIIlIIl);
            lllllllllllllIlIIIIllIlIIlIIIllI.pipeline().addAfter("compress", "via-encoder", lllllllllllllIlIIIIllIlIIlIIlIII);
            lllllllllllllIlIIIIllIlIIlIIIlII = true;
            this.handledCompression = true;
        }
        return lllllllllllllIlIIIIllIlIIlIIIlII;
    }
}
