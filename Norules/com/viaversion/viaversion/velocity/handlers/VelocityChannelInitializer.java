package com.viaversion.viaversion.velocity.handlers;

import java.lang.reflect.*;
import com.viaversion.viaversion.connection.*;
import com.viaversion.viaversion.protocol.*;
import io.netty.channel.*;
import com.viaversion.viaversion.api.connection.*;

public class VelocityChannelInitializer extends ChannelInitializer<Channel>
{
    private static final /* synthetic */ Method INIT_CHANNEL;
    private final /* synthetic */ boolean clientSide;
    private final /* synthetic */ ChannelInitializer<?> original;
    
    protected void initChannel(final Channel lllllllllllllIIlIIIIlIIIlIIllIlI) throws Exception {
        VelocityChannelInitializer.INIT_CHANNEL.invoke(this.original, lllllllllllllIIlIIIIlIIIlIIllIlI);
        final UserConnection lllllllllllllIIlIIIIlIIIlIIlllII = new UserConnectionImpl(lllllllllllllIIlIIIIlIIIlIIllIlI, this.clientSide);
        new ProtocolPipelineImpl(lllllllllllllIIlIIIIlIIIlIIlllII);
        lllllllllllllIIlIIIIlIIIlIIllIlI.pipeline().addBefore("minecraft-encoder", "via-encoder", (ChannelHandler)new VelocityEncodeHandler(lllllllllllllIIlIIIIlIIIlIIlllII));
        lllllllllllllIIlIIIIlIIIlIIllIlI.pipeline().addBefore("minecraft-decoder", "via-decoder", (ChannelHandler)new VelocityDecodeHandler(lllllllllllllIIlIIIIlIIIlIIlllII));
    }
    
    static {
        VIA_DECODER = "via-decoder";
        MINECRAFT_ENCODER = "minecraft-encoder";
        MINECRAFT_DECODER = "minecraft-decoder";
        VIA_ENCODER = "via-encoder";
        try {
            (INIT_CHANNEL = ChannelInitializer.class.getDeclaredMethod("initChannel", Channel.class)).setAccessible(true);
            final Class<?> lllllllllllllIIlIIIIlIIIlIIlIlll = Class.forName("com.velocitypowered.proxy.protocol.VelocityConnectionEvent");
            COMPRESSION_ENABLED_EVENT = lllllllllllllIIlIIIIlIIIlIIlIlll.getDeclaredField("COMPRESSION_ENABLED").get(null);
        }
        catch (ReflectiveOperationException lllllllllllllIIlIIIIlIIIlIIlIllI) {
            throw new RuntimeException(lllllllllllllIIlIIIIlIIIlIIlIllI);
        }
    }
    
    public VelocityChannelInitializer(final ChannelInitializer<?> lllllllllllllIIlIIIIlIIIlIlIIIll, final boolean lllllllllllllIIlIIIIlIIIlIlIIIlI) {
        this.original = lllllllllllllIIlIIIIlIIIlIlIIIll;
        this.clientSide = lllllllllllllIIlIIIIlIIIlIlIIIlI;
    }
}
