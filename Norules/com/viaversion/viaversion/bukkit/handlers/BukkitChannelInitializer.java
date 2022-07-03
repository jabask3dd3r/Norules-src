package com.viaversion.viaversion.bukkit.handlers;

import java.lang.reflect.*;
import com.viaversion.viaversion.connection.*;
import com.viaversion.viaversion.protocol.*;
import com.viaversion.viaversion.bukkit.classgenerator.*;
import io.netty.handler.codec.*;
import io.netty.channel.*;
import com.viaversion.viaversion.api.connection.*;
import com.viaversion.viaversion.classgenerator.generated.*;

public class BukkitChannelInitializer extends ChannelInitializer<Channel>
{
    private final /* synthetic */ ChannelInitializer<Channel> original;
    private /* synthetic */ Method method;
    
    public BukkitChannelInitializer(final ChannelInitializer<Channel> lllllllllllllIlIllIIIlllIlIIIlIl) {
        this.original = lllllllllllllIlIllIIIlllIlIIIlIl;
        try {
            this.method = ChannelInitializer.class.getDeclaredMethod("initChannel", Channel.class);
            this.method.setAccessible(true);
        }
        catch (NoSuchMethodException lllllllllllllIlIllIIIlllIlIIIlll) {
            lllllllllllllIlIllIIIlllIlIIIlll.printStackTrace();
        }
    }
    
    public ChannelInitializer<Channel> getOriginal() {
        return this.original;
    }
    
    public static void afterChannelInitialize(final Channel lllllllllllllIlIllIIIlllIIllIIll) {
        final UserConnection lllllllllllllIlIllIIIlllIIllIIlI = new UserConnectionImpl(lllllllllllllIlIllIIIlllIIllIIll);
        new ProtocolPipelineImpl(lllllllllllllIlIllIIIlllIIllIIlI);
        final HandlerConstructor lllllllllllllIlIllIIIlllIIllIIIl = ClassGenerator.getConstructor();
        final MessageToByteEncoder lllllllllllllIlIllIIIlllIIllIIII = lllllllllllllIlIllIIIlllIIllIIIl.newEncodeHandler(lllllllllllllIlIllIIIlllIIllIIlI, (MessageToByteEncoder)lllllllllllllIlIllIIIlllIIllIIll.pipeline().get("encoder"));
        final ByteToMessageDecoder lllllllllllllIlIllIIIlllIIlIllll = lllllllllllllIlIllIIIlllIIllIIIl.newDecodeHandler(lllllllllllllIlIllIIIlllIIllIIlI, (ByteToMessageDecoder)lllllllllllllIlIllIIIlllIIllIIll.pipeline().get("decoder"));
        lllllllllllllIlIllIIIlllIIllIIll.pipeline().replace("encoder", "encoder", (ChannelHandler)lllllllllllllIlIllIIIlllIIllIIII);
        lllllllllllllIlIllIIIlllIIllIIll.pipeline().replace("decoder", "decoder", (ChannelHandler)lllllllllllllIlIllIIIlllIIlIllll);
    }
    
    protected void initChannel(final Channel lllllllllllllIlIllIIIlllIIlllIll) throws Exception {
        this.method.invoke(this.original, lllllllllllllIlIllIIIlllIIlllIll);
        afterChannelInitialize(lllllllllllllIlIllIIIlllIIlllIll);
    }
}
