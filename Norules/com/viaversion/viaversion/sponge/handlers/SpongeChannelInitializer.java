package com.viaversion.viaversion.sponge.handlers;

import java.lang.reflect.*;
import com.viaversion.viaversion.api.*;
import io.netty.channel.socket.*;
import com.viaversion.viaversion.connection.*;
import com.viaversion.viaversion.protocol.*;
import io.netty.handler.codec.*;
import io.netty.channel.*;
import com.viaversion.viaversion.api.connection.*;

public class SpongeChannelInitializer extends ChannelInitializer<Channel>
{
    private final /* synthetic */ ChannelInitializer<Channel> original;
    private /* synthetic */ Method method;
    
    public ChannelInitializer<Channel> getOriginal() {
        return this.original;
    }
    
    protected void initChannel(final Channel lllllllllllllIlIIIIIlIIlIlIlIIll) throws Exception {
        if (Via.getAPI().getServerVersion().isKnown() && lllllllllllllIlIIIIIlIIlIlIlIIll instanceof SocketChannel) {
            final UserConnection lllllllllllllIlIIIIIlIIlIlIllIIl = new UserConnectionImpl(lllllllllllllIlIIIIIlIIlIlIlIIll);
            new ProtocolPipelineImpl(lllllllllllllIlIIIIIlIIlIlIllIIl);
            this.method.invoke(this.original, lllllllllllllIlIIIIIlIIlIlIlIIll);
            final MessageToByteEncoder lllllllllllllIlIIIIIlIIlIlIllIII = new SpongeEncodeHandler(lllllllllllllIlIIIIIlIIlIlIllIIl, (MessageToByteEncoder<?>)lllllllllllllIlIIIIIlIIlIlIlIIll.pipeline().get("encoder"));
            final ByteToMessageDecoder lllllllllllllIlIIIIIlIIlIlIlIlll = new SpongeDecodeHandler(lllllllllllllIlIIIIIlIIlIlIllIIl, (ByteToMessageDecoder)lllllllllllllIlIIIIIlIIlIlIlIIll.pipeline().get("decoder"));
            lllllllllllllIlIIIIIlIIlIlIlIIll.pipeline().replace("encoder", "encoder", (ChannelHandler)lllllllllllllIlIIIIIlIIlIlIllIII);
            lllllllllllllIlIIIIIlIIlIlIlIIll.pipeline().replace("decoder", "decoder", (ChannelHandler)lllllllllllllIlIIIIIlIIlIlIlIlll);
        }
        else {
            this.method.invoke(this.original, lllllllllllllIlIIIIIlIIlIlIlIIll);
        }
    }
    
    public SpongeChannelInitializer(final ChannelInitializer<Channel> lllllllllllllIlIIIIIlIIlIllIIIII) {
        this.original = lllllllllllllIlIIIIIlIIlIllIIIII;
        try {
            this.method = ChannelInitializer.class.getDeclaredMethod("initChannel", Channel.class);
            this.method.setAccessible(true);
        }
        catch (NoSuchMethodException lllllllllllllIlIIIIIlIIlIllIIlII) {
            lllllllllllllIlIIIIIlIIlIllIIlII.printStackTrace();
        }
    }
}
