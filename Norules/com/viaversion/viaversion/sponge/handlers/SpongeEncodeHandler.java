package com.viaversion.viaversion.sponge.handlers;

import io.netty.handler.codec.*;
import com.viaversion.viaversion.api.connection.*;
import io.netty.channel.*;
import io.netty.buffer.*;
import com.viaversion.viaversion.handlers.*;
import com.viaversion.viaversion.util.*;
import java.lang.reflect.*;
import com.viaversion.viaversion.exception.*;
import java.util.function.*;

public class SpongeEncodeHandler extends MessageToByteEncoder<Object> implements ViaCodecHandler
{
    private final /* synthetic */ MessageToByteEncoder<?> minecraftEncoder;
    private final /* synthetic */ UserConnection info;
    
    protected void encode(final ChannelHandlerContext lllllllllllllIIIlllIlIlIlIlIllll, final Object lllllllllllllIIIlllIlIlIlIlIlIlI, final ByteBuf lllllllllllllIIIlllIlIlIlIlIlIIl) throws Exception {
        if (!(lllllllllllllIIIlllIlIlIlIlIlIlI instanceof ByteBuf)) {
            try {
                PipelineUtil.callEncode(this.minecraftEncoder, (ChannelHandlerContext)new ChannelHandlerContextWrapper(lllllllllllllIIIlllIlIlIlIlIllll, this), lllllllllllllIIIlllIlIlIlIlIlIlI, lllllllllllllIIIlllIlIlIlIlIlIIl);
            }
            catch (InvocationTargetException lllllllllllllIIIlllIlIlIlIllIIIl) {
                if (lllllllllllllIIIlllIlIlIlIllIIIl.getCause() instanceof Exception) {
                    throw (Exception)lllllllllllllIIIlllIlIlIlIllIIIl.getCause();
                }
                if (lllllllllllllIIIlllIlIlIlIllIIIl.getCause() instanceof Error) {
                    throw (Error)lllllllllllllIIIlllIlIlIlIllIIIl.getCause();
                }
            }
        }
        else {
            lllllllllllllIIIlllIlIlIlIlIlIIl.writeBytes((ByteBuf)lllllllllllllIIIlllIlIlIlIlIlIlI);
        }
        this.transform(lllllllllllllIIIlllIlIlIlIlIlIIl);
    }
    
    public SpongeEncodeHandler(final UserConnection lllllllllllllIIIlllIlIlIlIlllIll, final MessageToByteEncoder<?> lllllllllllllIIIlllIlIlIlIllIlll) {
        this.info = lllllllllllllIIIlllIlIlIlIlllIll;
        this.minecraftEncoder = lllllllllllllIIIlllIlIlIlIllIlll;
    }
    
    public void exceptionCaught(final ChannelHandlerContext lllllllllllllIIIlllIlIlIlIIlllIl, final Throwable lllllllllllllIIIlllIlIlIlIIlllII) throws Exception {
        if (lllllllllllllIIIlllIlIlIlIIlllII instanceof CancelCodecException) {
            return;
        }
        super.exceptionCaught(lllllllllllllIIIlllIlIlIlIIlllIl, lllllllllllllIIIlllIlIlIlIIlllII);
    }
    
    public void transform(final ByteBuf lllllllllllllIIIlllIlIlIlIlIIIlI) throws Exception {
        if (!this.info.checkClientboundPacket()) {
            throw CancelEncoderException.generate(null);
        }
        if (!this.info.shouldTransformPacket()) {
            return;
        }
        this.info.transformClientbound(lllllllllllllIIIlllIlIlIlIlIIIlI, (Function<Throwable, Exception>)CancelEncoderException::generate);
    }
}
