package com.viaversion.viaversion.sponge.handlers;

import io.netty.handler.codec.*;
import com.viaversion.viaversion.api.connection.*;
import io.netty.channel.*;
import io.netty.buffer.*;
import com.viaversion.viaversion.exception.*;
import java.util.function.*;
import com.viaversion.viaversion.util.*;
import java.util.*;
import java.lang.reflect.*;

public class SpongeDecodeHandler extends ByteToMessageDecoder
{
    private final /* synthetic */ UserConnection info;
    private final /* synthetic */ ByteToMessageDecoder minecraftDecoder;
    
    public SpongeDecodeHandler(final UserConnection lllllllllllllllIlIlIIIlIIllIlIIl, final ByteToMessageDecoder lllllllllllllllIlIlIIIlIIllIlIll) {
        this.info = lllllllllllllllIlIlIIIlIIllIlIIl;
        this.minecraftDecoder = lllllllllllllllIlIlIIIlIIllIlIll;
    }
    
    public void exceptionCaught(final ChannelHandlerContext lllllllllllllllIlIlIIIlIIlIIllll, final Throwable lllllllllllllllIlIlIIIlIIlIIlllI) throws Exception {
        if (lllllllllllllllIlIlIIIlIIlIIlllI instanceof CancelCodecException) {
            return;
        }
        super.exceptionCaught(lllllllllllllllIlIlIIIlIIlIIllll, lllllllllllllllIlIlIIIlIIlIIlllI);
    }
    
    protected void decode(final ChannelHandlerContext lllllllllllllllIlIlIIIlIIlIllllI, final ByteBuf lllllllllllllllIlIlIIIlIIlIllIII, final List<Object> lllllllllllllllIlIlIIIlIIlIlIlll) throws Exception {
        if (!this.info.checkServerboundPacket()) {
            lllllllllllllllIlIlIIIlIIlIllIII.clear();
            throw CancelDecoderException.generate(null);
        }
        ByteBuf lllllllllllllllIlIlIIIlIIlIllIll = null;
        try {
            if (this.info.shouldTransformPacket()) {
                lllllllllllllllIlIlIIIlIIlIllIll = lllllllllllllllIlIlIIIlIIlIllllI.alloc().buffer().writeBytes(lllllllllllllllIlIlIIIlIIlIllIII);
                this.info.transformServerbound(lllllllllllllllIlIlIIIlIIlIllIll, (Function<Throwable, Exception>)CancelDecoderException::generate);
            }
            try {
                lllllllllllllllIlIlIIIlIIlIlIlll.addAll(PipelineUtil.callDecode(this.minecraftDecoder, lllllllllllllllIlIlIIIlIIlIllllI, (lllllllllllllllIlIlIIIlIIlIllIll == null) ? lllllllllllllllIlIlIIIlIIlIllIII : lllllllllllllllIlIlIIIlIIlIllIll));
            }
            catch (InvocationTargetException lllllllllllllllIlIlIIIlIIllIIIII) {
                if (lllllllllllllllIlIlIIIlIIllIIIII.getCause() instanceof Exception) {
                    throw (Exception)lllllllllllllllIlIlIIIlIIllIIIII.getCause();
                }
                if (lllllllllllllllIlIlIIIlIIllIIIII.getCause() instanceof Error) {
                    throw (Error)lllllllllllllllIlIlIIIlIIllIIIII.getCause();
                }
            }
        }
        finally {
            if (lllllllllllllllIlIlIIIlIIlIllIll != null) {
                lllllllllllllllIlIlIIIlIIlIllIll.release();
            }
        }
    }
}
