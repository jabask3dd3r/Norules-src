package com.viaversion.viaversion.bukkit.handlers;

import io.netty.handler.codec.*;
import com.viaversion.viaversion.api.connection.*;
import io.netty.channel.*;
import com.viaversion.viaversion.util.*;
import com.viaversion.viaversion.bukkit.util.*;
import com.viaversion.viaversion.api.protocol.packet.*;
import com.viaversion.viaversion.api.*;
import io.netty.buffer.*;
import com.viaversion.viaversion.handlers.*;
import java.lang.reflect.*;
import com.viaversion.viaversion.exception.*;
import java.util.function.*;

public class BukkitEncodeHandler extends MessageToByteEncoder implements ViaCodecHandler
{
    private static /* synthetic */ Field versionField;
    private final /* synthetic */ UserConnection info;
    private final /* synthetic */ MessageToByteEncoder minecraftEncoder;
    
    public BukkitEncodeHandler(final UserConnection lllllllllllllIIIlIlIIllllIIlllII, final MessageToByteEncoder lllllllllllllIIIlIlIIllllIIllIII) {
        this.info = lllllllllllllIIIlIlIIllllIIlllII;
        this.minecraftEncoder = lllllllllllllIIIlIlIIllllIIllIII;
    }
    
    public void exceptionCaught(final ChannelHandlerContext lllllllllllllIIIlIlIIlllIllllIll, final Throwable lllllllllllllIIIlIlIIlllIllllIlI) throws Exception {
        if (PipelineUtil.containsCause(lllllllllllllIIIlIlIIlllIllllIlI, CancelCodecException.class)) {
            return;
        }
        super.exceptionCaught(lllllllllllllIIIlIlIIlllIllllIll, lllllllllllllIIIlIlIIlllIllllIlI);
        if (!NMSUtil.isDebugPropertySet() && PipelineUtil.containsCause(lllllllllllllIIIlIlIIlllIllllIlI, InformativeException.class) && (this.info.getProtocolInfo().getState() != State.HANDSHAKE || Via.getManager().isDebug())) {
            lllllllllllllIIIlIlIIlllIllllIlI.printStackTrace();
        }
    }
    
    protected void encode(final ChannelHandlerContext lllllllllllllIIIlIlIIllllIIlIIII, final Object lllllllllllllIIIlIlIIllllIIIlIll, final ByteBuf lllllllllllllIIIlIlIIllllIIIlIlI) throws Exception {
        if (BukkitEncodeHandler.versionField != null) {
            BukkitEncodeHandler.versionField.set(this.minecraftEncoder, BukkitEncodeHandler.versionField.get(this));
        }
        if (!(lllllllllllllIIIlIlIIllllIIIlIll instanceof ByteBuf)) {
            try {
                PipelineUtil.callEncode(this.minecraftEncoder, (ChannelHandlerContext)new ChannelHandlerContextWrapper(lllllllllllllIIIlIlIIllllIIlIIII, this), lllllllllllllIIIlIlIIllllIIIlIll, lllllllllllllIIIlIlIIllllIIIlIlI);
            }
            catch (InvocationTargetException lllllllllllllIIIlIlIIllllIIlIIlI) {
                if (lllllllllllllIIIlIlIIllllIIlIIlI.getCause() instanceof Exception) {
                    throw (Exception)lllllllllllllIIIlIlIIllllIIlIIlI.getCause();
                }
                if (lllllllllllllIIIlIlIIllllIIlIIlI.getCause() instanceof Error) {
                    throw (Error)lllllllllllllIIIlIlIIllllIIlIIlI.getCause();
                }
            }
        }
        else {
            lllllllllllllIIIlIlIIllllIIIlIlI.writeBytes((ByteBuf)lllllllllllllIIIlIlIIllllIIIlIll);
        }
        this.transform(lllllllllllllIIIlIlIIllllIIIlIlI);
    }
    
    public void transform(final ByteBuf lllllllllllllIIIlIlIIllllIIIIlIl) throws Exception {
        if (!this.info.checkClientboundPacket()) {
            throw CancelEncoderException.generate(null);
        }
        if (!this.info.shouldTransformPacket()) {
            return;
        }
        this.info.transformClientbound(lllllllllllllIIIlIlIIllllIIIIlIl, (Function<Throwable, Exception>)CancelEncoderException::generate);
    }
    
    static {
        try {
            (BukkitEncodeHandler.versionField = NMSUtil.nms("PacketEncoder", "net.minecraft.network.PacketEncoder").getDeclaredField("version")).setAccessible(true);
        }
        catch (Exception ex) {}
    }
}
