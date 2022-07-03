package com.viaversion.viaversion.bungee.handlers;

import java.lang.reflect.*;
import com.viaversion.viaversion.connection.*;
import com.viaversion.viaversion.protocol.*;
import io.netty.channel.*;
import com.viaversion.viaversion.api.connection.*;

public class BungeeChannelInitializer extends ChannelInitializer<Channel>
{
    private final /* synthetic */ ChannelInitializer<Channel> original;
    private /* synthetic */ Method method;
    
    public ChannelInitializer<Channel> getOriginal() {
        return this.original;
    }
    
    public BungeeChannelInitializer(final ChannelInitializer<Channel> llllllllllllllIIlIlIIIllIlllllIl) {
        this.original = llllllllllllllIIlIlIIIllIlllllIl;
        try {
            this.method = ChannelInitializer.class.getDeclaredMethod("initChannel", Channel.class);
            this.method.setAccessible(true);
        }
        catch (NoSuchMethodException llllllllllllllIIlIlIIIllIlllllll) {
            llllllllllllllIIlIlIIIllIlllllll.printStackTrace();
        }
    }
    
    protected void initChannel(final Channel llllllllllllllIIlIlIIIllIllIlllI) throws Exception {
        if (!llllllllllllllIIlIlIIIllIllIlllI.isActive()) {
            return;
        }
        final UserConnection llllllllllllllIIlIlIIIllIlllIIlI = new UserConnectionImpl(llllllllllllllIIlIlIIIllIllIlllI);
        new ProtocolPipelineImpl(llllllllllllllIIlIlIIIllIlllIIlI);
        this.method.invoke(this.original, llllllllllllllIIlIlIIIllIllIlllI);
        if (!llllllllllllllIIlIlIIIllIllIlllI.isActive()) {
            return;
        }
        if (llllllllllllllIIlIlIIIllIllIlllI.pipeline().get("packet-encoder") == null) {
            return;
        }
        if (llllllllllllllIIlIlIIIllIllIlllI.pipeline().get("packet-decoder") == null) {
            return;
        }
        final BungeeEncodeHandler llllllllllllllIIlIlIIIllIlllIIIl = new BungeeEncodeHandler(llllllllllllllIIlIlIIIllIlllIIlI);
        final BungeeDecodeHandler llllllllllllllIIlIlIIIllIlllIIII = new BungeeDecodeHandler(llllllllllllllIIlIlIIIllIlllIIlI);
        llllllllllllllIIlIlIIIllIllIlllI.pipeline().addBefore("packet-encoder", "via-encoder", (ChannelHandler)llllllllllllllIIlIlIIIllIlllIIIl);
        llllllllllllllIIlIlIIIllIllIlllI.pipeline().addBefore("packet-decoder", "via-decoder", (ChannelHandler)llllllllllllllIIlIlIIIllIlllIIII);
    }
}
