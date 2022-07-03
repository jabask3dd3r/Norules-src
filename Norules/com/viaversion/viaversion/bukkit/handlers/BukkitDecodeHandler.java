package com.viaversion.viaversion.bukkit.handlers;

import io.netty.handler.codec.*;
import com.viaversion.viaversion.api.connection.*;
import io.netty.channel.*;
import com.viaversion.viaversion.util.*;
import com.viaversion.viaversion.bukkit.util.*;
import com.viaversion.viaversion.api.protocol.packet.*;
import com.viaversion.viaversion.api.*;
import io.netty.buffer.*;
import com.viaversion.viaversion.exception.*;
import java.util.function.*;
import java.util.*;
import java.lang.reflect.*;

public class BukkitDecodeHandler extends ByteToMessageDecoder
{
    private final /* synthetic */ UserConnection info;
    private final /* synthetic */ ByteToMessageDecoder minecraftDecoder;
    
    public void exceptionCaught(final ChannelHandlerContext lllllllllllllIIIIlllIIlllIIlIIIl, final Throwable lllllllllllllIIIIlllIIlllIIlIIII) throws Exception {
        if (PipelineUtil.containsCause(lllllllllllllIIIIlllIIlllIIlIIII, CancelCodecException.class)) {
            return;
        }
        super.exceptionCaught(lllllllllllllIIIIlllIIlllIIlIIIl, lllllllllllllIIIIlllIIlllIIlIIII);
        if (!NMSUtil.isDebugPropertySet() && PipelineUtil.containsCause(lllllllllllllIIIIlllIIlllIIlIIII, InformativeException.class) && (this.info.getProtocolInfo().getState() != State.HANDSHAKE || Via.getManager().isDebug())) {
            lllllllllllllIIIIlllIIlllIIlIIII.printStackTrace();
        }
    }
    
    protected void decode(final ChannelHandlerContext lllllllllllllIIIIlllIIlllIlIIIII, final ByteBuf lllllllllllllIIIIlllIIlllIIllIlI, final List<Object> lllllllllllllIIIIlllIIlllIIllllI) throws Exception {
        if (!this.info.checkServerboundPacket()) {
            lllllllllllllIIIIlllIIlllIIllIlI.clear();
            throw CancelDecoderException.generate(null);
        }
        ByteBuf lllllllllllllIIIIlllIIlllIIlllIl = null;
        try {
            if (this.info.shouldTransformPacket()) {
                lllllllllllllIIIIlllIIlllIIlllIl = lllllllllllllIIIIlllIIlllIlIIIII.alloc().buffer().writeBytes(lllllllllllllIIIIlllIIlllIIllIlI);
                this.info.transformServerbound(lllllllllllllIIIIlllIIlllIIlllIl, (Function<Throwable, Exception>)CancelDecoderException::generate);
            }
            try {
                lllllllllllllIIIIlllIIlllIIllllI.addAll(PipelineUtil.callDecode(this.minecraftDecoder, lllllllllllllIIIIlllIIlllIlIIIII, (lllllllllllllIIIIlllIIlllIIlllIl == null) ? lllllllllllllIIIIlllIIlllIIllIlI : lllllllllllllIIIIlllIIlllIIlllIl));
            }
            catch (InvocationTargetException lllllllllllllIIIIlllIIlllIlIIIlI) {
                if (lllllllllllllIIIIlllIIlllIlIIIlI.getCause() instanceof Exception) {
                    throw (Exception)lllllllllllllIIIIlllIIlllIlIIIlI.getCause();
                }
                if (lllllllllllllIIIIlllIIlllIlIIIlI.getCause() instanceof Error) {
                    throw (Error)lllllllllllllIIIIlllIIlllIlIIIlI.getCause();
                }
            }
        }
        finally {
            if (lllllllllllllIIIIlllIIlllIIlllIl != null) {
                lllllllllllllIIIIlllIIlllIIlllIl.release();
            }
        }
    }
    
    public BukkitDecodeHandler(final UserConnection lllllllllllllIIIIlllIIlllIlIlllI, final ByteToMessageDecoder lllllllllllllIIIIlllIIlllIlIllIl) {
        this.info = lllllllllllllIIIIlllIIlllIlIlllI;
        this.minecraftDecoder = lllllllllllllIIIIlllIIlllIlIllIl;
    }
}
