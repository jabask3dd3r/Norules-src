package com.viaversion.viaversion.bungee.platform;

import com.viaversion.viaversion.api.platform.*;
import com.viaversion.viaversion.compatibility.*;
import com.viaversion.viaversion.libs.fastutil.ints.*;
import com.viaversion.viaversion.compatibility.unsafe.*;
import com.viaversion.viaversion.bungee.handlers.*;
import io.netty.channel.*;
import com.viaversion.viaversion.api.*;
import java.lang.reflect.*;
import com.viaversion.viaversion.libs.gson.*;
import java.util.*;
import com.viaversion.viaversion.util.*;

public class BungeeViaInjector implements ViaInjector
{
    private final /* synthetic */ ForcefulFieldModifier forcefulFieldModifier;
    
    @Override
    public String getEncoderName() {
        return "via-encoder";
    }
    
    @Override
    public IntSortedSet getServerProtocolVersions() throws Exception {
        return new IntLinkedOpenHashSet(this.getBungeeSupportedVersions());
    }
    
    public BungeeViaInjector() {
        try {
            this.forcefulFieldModifier = new UnsafeBackedForcefulFieldModifier();
        }
        catch (ReflectiveOperationException llllllllllllllllIIIllIlllllIllIl) {
            throw new IllegalStateException("Cannot create a modifier accessor", llllllllllllllllIIIllIlllllIllIl);
        }
    }
    
    @Override
    public void inject() throws Exception {
        try {
            final Class<?> llllllllllllllllIIIllIlllllIIlIl = Class.forName("net.md_5.bungee.netty.PipelineUtils");
            final Field llllllllllllllllIIIllIlllllIIlII = llllllllllllllllIIIllIlllllIIlIl.getDeclaredField("SERVER_CHILD");
            llllllllllllllllIIIllIlllllIIlII.setAccessible(true);
            final BungeeChannelInitializer llllllllllllllllIIIllIlllllIIIll = new BungeeChannelInitializer((ChannelInitializer<Channel>)llllllllllllllllIIIllIlllllIIlII.get(null));
            this.forcefulFieldModifier.setField(llllllllllllllllIIIllIlllllIIlII, null, llllllllllllllllIIIllIlllllIIIll);
        }
        catch (Exception llllllllllllllllIIIllIlllllIIIlI) {
            Via.getPlatform().getLogger().severe("Unable to inject ViaVersion, please post these details on our GitHub and ensure you're using a compatible server version.");
            throw llllllllllllllllIIIllIlllllIIIlI;
        }
    }
    
    @Override
    public int getServerProtocolVersion() throws Exception {
        return this.getBungeeSupportedVersions().get(0);
    }
    
    @Override
    public JsonObject getDump() {
        final JsonObject llllllllllllllllIIIllIllllIIIllI = new JsonObject();
        try {
            final ChannelInitializer<Channel> llllllllllllllllIIIllIllllIIlIII = this.getChannelInitializer();
            llllllllllllllllIIIllIllllIIIllI.addProperty("currentInitializer", llllllllllllllllIIIllIllllIIlIII.getClass().getName());
            if (llllllllllllllllIIIllIllllIIlIII instanceof BungeeChannelInitializer) {
                llllllllllllllllIIIllIllllIIIllI.addProperty("originalInitializer", ((BungeeChannelInitializer)llllllllllllllllIIIllIllllIIlIII).getOriginal().getClass().getName());
            }
        }
        catch (Exception ex) {}
        return llllllllllllllllIIIllIllllIIIllI;
    }
    
    @Override
    public void uninject() {
        Via.getPlatform().getLogger().severe("ViaVersion cannot remove itself from Bungee without a reboot!");
    }
    
    @Override
    public String getDecoderName() {
        return "via-decoder";
    }
    
    private List<Integer> getBungeeSupportedVersions() throws Exception {
        return ReflectionUtil.getStatic(Class.forName("net.md_5.bungee.protocol.ProtocolConstants"), "SUPPORTED_VERSION_IDS", (Class<List<Integer>>)List.class);
    }
    
    private ChannelInitializer<Channel> getChannelInitializer() throws Exception {
        final Class<?> llllllllllllllllIIIllIllllIIllll = Class.forName("net.md_5.bungee.netty.PipelineUtils");
        final Field llllllllllllllllIIIllIllllIIlllI = llllllllllllllllIIIllIllllIIllll.getDeclaredField("SERVER_CHILD");
        llllllllllllllllIIIllIllllIIlllI.setAccessible(true);
        return (ChannelInitializer<Channel>)llllllllllllllllIIIllIllllIIlllI.get(null);
    }
}
