package com.viaversion.viaversion.sponge.platform;

import com.viaversion.viaversion.api.platform.*;
import java.lang.reflect.*;
import com.viaversion.viaversion.sponge.handlers.*;
import com.viaversion.viaversion.api.*;
import com.viaversion.viaversion.util.*;
import io.netty.channel.*;
import org.spongepowered.api.*;
import java.util.*;
import com.viaversion.viaversion.libs.gson.*;

public class SpongeViaInjector implements ViaInjector
{
    private /* synthetic */ List<ChannelFuture> injectedFutures;
    private /* synthetic */ List<Pair<Field, Object>> injectedLists;
    
    public static Object getServerConnection() throws Exception {
        final Class<?> llllllllllllllllllIlIlIIlIllIIlI = Class.forName("net.minecraft.server.MinecraftServer");
        final Object llllllllllllllllllIlIlIIlIllIIIl = getServer();
        Object llllllllllllllllllIlIlIIlIllIIII = null;
        final Exception llllllllllllllllllIlIlIIlIlIllII = (Object)llllllllllllllllllIlIlIIlIllIIlI.getDeclaredMethods();
        final int llllllllllllllllllIlIlIIlIlIlIll = llllllllllllllllllIlIlIIlIlIllII.length;
        for (long llllllllllllllllllIlIlIIlIlIlIlI = 0; llllllllllllllllllIlIlIIlIlIlIlI < llllllllllllllllllIlIlIIlIlIlIll; ++llllllllllllllllllIlIlIIlIlIlIlI) {
            final Method llllllllllllllllllIlIlIIlIllIIll = llllllllllllllllllIlIlIIlIlIllII[llllllllllllllllllIlIlIIlIlIlIlI];
            if (llllllllllllllllllIlIlIIlIllIIll.getReturnType() != null && llllllllllllllllllIlIlIIlIllIIll.getReturnType().getSimpleName().equals("NetworkSystem") && llllllllllllllllllIlIlIIlIllIIll.getParameterTypes().length == 0) {
                llllllllllllllllllIlIlIIlIllIIII = llllllllllllllllllIlIlIIlIllIIll.invoke(llllllllllllllllllIlIlIIlIllIIIl, new Object[0]);
            }
        }
        return llllllllllllllllllIlIlIIlIllIIII;
    }
    
    @Override
    public String getDecoderName() {
        return "decoder";
    }
    
    @Override
    public void uninject() {
        for (final ChannelFuture llllllllllllllllllIlIlIIllIlIIIl : this.injectedFutures) {
            final List<String> llllllllllllllllllIlIlIIllIlIIll = (List<String>)llllllllllllllllllIlIlIIllIlIIIl.channel().pipeline().names();
            ChannelHandler llllllllllllllllllIlIlIIllIlIIlI = null;
            for (final String llllllllllllllllllIlIlIIllIlIllI : llllllllllllllllllIlIlIIllIlIIll) {
                final ChannelHandler llllllllllllllllllIlIlIIllIlIlll = llllllllllllllllllIlIlIIllIlIIIl.channel().pipeline().get(llllllllllllllllllIlIlIIllIlIllI);
                try {
                    final ChannelInitializer<Channel> llllllllllllllllllIlIlIIllIllIII = (ChannelInitializer<Channel>)ReflectionUtil.get(llllllllllllllllllIlIlIIllIlIlll, "childHandler", ChannelInitializer.class);
                    if (!(llllllllllllllllllIlIlIIllIllIII instanceof SpongeChannelInitializer)) {
                        continue;
                    }
                    llllllllllllllllllIlIlIIllIlIIlI = llllllllllllllllllIlIlIIllIlIlll;
                }
                catch (Exception ex) {}
            }
            if (llllllllllllllllllIlIlIIllIlIIlI == null) {
                llllllllllllllllllIlIlIIllIlIIlI = llllllllllllllllllIlIlIIllIlIIIl.channel().pipeline().first();
            }
            try {
                final ChannelInitializer<Channel> llllllllllllllllllIlIlIIllIlIlIl = (ChannelInitializer<Channel>)ReflectionUtil.get(llllllllllllllllllIlIlIIllIlIIlI, "childHandler", ChannelInitializer.class);
                if (!(llllllllllllllllllIlIlIIllIlIlIl instanceof SpongeChannelInitializer)) {
                    continue;
                }
                ReflectionUtil.set(llllllllllllllllllIlIlIIllIlIIlI, "childHandler", ((SpongeChannelInitializer)llllllllllllllllllIlIlIIllIlIlIl).getOriginal());
            }
            catch (Exception llllllllllllllllllIlIlIIllIlIlII) {
                Via.getPlatform().getLogger().severe("Failed to remove injection handler, reload won't work with connections, please reboot!");
            }
        }
        this.injectedFutures.clear();
        for (final Pair<Field, Object> llllllllllllllllllIlIlIIllIIlllI : this.injectedLists) {
            try {
                final Object llllllllllllllllllIlIlIIllIlIIII = llllllllllllllllllIlIlIIllIIlllI.getKey().get(llllllllllllllllllIlIlIIllIIlllI.getValue());
                if (!(llllllllllllllllllIlIlIIllIlIIII instanceof ListWrapper)) {
                    continue;
                }
                llllllllllllllllllIlIlIIllIIlllI.getKey().set(llllllllllllllllllIlIlIIllIIlllI.getValue(), ((ListWrapper)llllllllllllllllllIlIlIIllIlIIII).getOriginalList());
            }
            catch (IllegalAccessException llllllllllllllllllIlIlIIllIIllll) {
                Via.getPlatform().getLogger().severe("Failed to remove injection, reload won't work with connections, please reboot!");
            }
        }
        this.injectedLists.clear();
    }
    
    private void injectChannelFuture(final ChannelFuture llllllllllllllllllIlIlIIlllIlIIl) throws Exception {
        try {
            final List<String> llllllllllllllllllIlIlIIlllIllll = (List<String>)llllllllllllllllllIlIlIIlllIlIIl.channel().pipeline().names();
            ChannelHandler llllllllllllllllllIlIlIIlllIlllI = null;
            for (final String llllllllllllllllllIlIlIIllllIIll : llllllllllllllllllIlIlIIlllIllll) {
                final ChannelHandler llllllllllllllllllIlIlIIllllIlII = llllllllllllllllllIlIlIIlllIlIIl.channel().pipeline().get(llllllllllllllllllIlIlIIllllIIll);
                try {
                    ReflectionUtil.get(llllllllllllllllllIlIlIIllllIlII, "childHandler", ChannelInitializer.class);
                    llllllllllllllllllIlIlIIlllIlllI = llllllllllllllllllIlIlIIllllIlII;
                }
                catch (Exception ex) {}
            }
            if (llllllllllllllllllIlIlIIlllIlllI == null) {
                llllllllllllllllllIlIlIIlllIlllI = llllllllllllllllllIlIlIIlllIlIIl.channel().pipeline().first();
            }
            try {
                final ChannelInitializer<Channel> llllllllllllllllllIlIlIIllllIIlI = (ChannelInitializer<Channel>)ReflectionUtil.get(llllllllllllllllllIlIlIIlllIlllI, "childHandler", ChannelInitializer.class);
                final ChannelInitializer llllllllllllllllllIlIlIIllllIIIl = new SpongeChannelInitializer(llllllllllllllllllIlIlIIllllIIlI);
                ReflectionUtil.set(llllllllllllllllllIlIlIIlllIlllI, "childHandler", llllllllllllllllllIlIlIIllllIIIl);
                this.injectedFutures.add(llllllllllllllllllIlIlIIlllIlIIl);
            }
            catch (NoSuchFieldException llllllllllllllllllIlIlIIllllIIII) {
                throw new Exception(String.valueOf(new StringBuilder().append("Unable to find core component 'childHandler', please check your plugins. issue: ").append(llllllllllllllllllIlIlIIlllIlllI.getClass().getName())));
            }
        }
        catch (Exception llllllllllllllllllIlIlIIlllIllIl) {
            Via.getPlatform().getLogger().severe("We failed to inject ViaVersion, have you got late-bind enabled with something else?");
            throw llllllllllllllllllIlIlIIlllIllIl;
        }
    }
    
    public static Object getServer() throws Exception {
        return Sponge.getServer();
    }
    
    @Override
    public int getServerProtocolVersion() throws Exception {
        final MinecraftVersion llllllllllllllllllIlIlIIlIllllll = Sponge.getPlatform().getMinecraftVersion();
        try {
            return (int)llllllllllllllllllIlIlIIlIllllll.getClass().getDeclaredMethod("getProtocol", (Class<?>[])new Class[0]).invoke(llllllllllllllllllIlIlIIlIllllll, new Object[0]);
        }
        catch (Exception llllllllllllllllllIlIlIIllIIIIIl) {
            throw new Exception("Failed to get server protocol", llllllllllllllllllIlIlIIllIIIIIl);
        }
    }
    
    @Override
    public void inject() throws Exception {
        try {
            final Object llllllllllllllllllIlIlIlIIIIlIll = getServerConnection();
            if (llllllllllllllllllIlIlIlIIIIlIll == null) {
                throw new Exception("We failed to find the core component 'ServerConnection', please file an issue on our GitHub.");
            }
            final String llllllllllllllllllIlIlIlIIIIIllI = (Object)llllllllllllllllllIlIlIlIIIIlIll.getClass().getDeclaredFields();
            final Exception llllllllllllllllllIlIlIlIIIIIlIl = (Exception)llllllllllllllllllIlIlIlIIIIIllI.length;
            for (char llllllllllllllllllIlIlIlIIIIIlII = '\0'; llllllllllllllllllIlIlIlIIIIIlII < llllllllllllllllllIlIlIlIIIIIlIl; ++llllllllllllllllllIlIlIlIIIIIlII) {
                final Field llllllllllllllllllIlIlIlIIIIllII = llllllllllllllllllIlIlIlIIIIIllI[llllllllllllllllllIlIlIlIIIIIlII];
                llllllllllllllllllIlIlIlIIIIllII.setAccessible(true);
                final Object llllllllllllllllllIlIlIlIIIIllIl = llllllllllllllllllIlIlIlIIIIllII.get(llllllllllllllllllIlIlIlIIIIlIll);
                if (llllllllllllllllllIlIlIlIIIIllIl instanceof List) {
                    final List llllllllllllllllllIlIlIlIIIIlllI = new ListWrapper((List)llllllllllllllllllIlIlIlIIIIllIl) {
                        @Override
                        public void handleAdd(final Object lllllllllllllIIlIIIIlIllIlIIlIll) {
                            if (lllllllllllllIIlIIIIlIllIlIIlIll instanceof ChannelFuture) {
                                try {
                                    SpongeViaInjector.this.injectChannelFuture((ChannelFuture)lllllllllllllIIlIIIIlIllIlIIlIll);
                                }
                                catch (Exception lllllllllllllIIlIIIIlIllIlIIllIl) {
                                    lllllllllllllIIlIIIIlIllIlIIllIl.printStackTrace();
                                }
                            }
                        }
                    };
                    this.injectedLists.add(new Pair<Field, Object>(llllllllllllllllllIlIlIlIIIIllII, llllllllllllllllllIlIlIlIIIIlIll));
                    llllllllllllllllllIlIlIlIIIIllII.set(llllllllllllllllllIlIlIlIIIIlIll, llllllllllllllllllIlIlIlIIIIlllI);
                    synchronized (llllllllllllllllllIlIlIlIIIIlllI) {
                        for (final Object llllllllllllllllllIlIlIlIIIIllll : (List)llllllllllllllllllIlIlIlIIIIllIl) {
                            if (!(llllllllllllllllllIlIlIlIIIIllll instanceof ChannelFuture)) {
                                break;
                            }
                            this.injectChannelFuture((ChannelFuture)llllllllllllllllllIlIlIlIIIIllll);
                        }
                    }
                }
            }
        }
        catch (Exception llllllllllllllllllIlIlIlIIIIlIlI) {
            Via.getPlatform().getLogger().severe("Unable to inject ViaVersion, please post these details on our GitHub and ensure you're using a compatible server version.");
            throw llllllllllllllllllIlIlIlIIIIlIlI;
        }
    }
    
    public SpongeViaInjector() {
        this.injectedFutures = new ArrayList<ChannelFuture>();
        this.injectedLists = new ArrayList<Pair<Field, Object>>();
    }
    
    @Override
    public String getEncoderName() {
        return "encoder";
    }
    
    @Override
    public JsonObject getDump() {
        final JsonObject llllllllllllllllllIlIlIIlIIlIlII = new JsonObject();
        final JsonArray llllllllllllllllllIlIlIIlIIlIIll = new JsonArray();
        for (final ChannelFuture llllllllllllllllllIlIlIIlIIllIII : this.injectedFutures) {
            final JsonObject llllllllllllllllllIlIlIIlIIllIlI = new JsonObject();
            llllllllllllllllllIlIlIIlIIllIlI.addProperty("futureClass", llllllllllllllllllIlIlIIlIIllIII.getClass().getName());
            llllllllllllllllllIlIlIIlIIllIlI.addProperty("channelClass", llllllllllllllllllIlIlIIlIIllIII.channel().getClass().getName());
            final JsonArray llllllllllllllllllIlIlIIlIIllIIl = new JsonArray();
            for (final String llllllllllllllllllIlIlIIlIIllIll : llllllllllllllllllIlIlIIlIIllIII.channel().pipeline().names()) {
                final JsonObject llllllllllllllllllIlIlIIlIIlllII = new JsonObject();
                llllllllllllllllllIlIlIIlIIlllII.addProperty("name", llllllllllllllllllIlIlIIlIIllIll);
                if (llllllllllllllllllIlIlIIlIIllIII.channel().pipeline().get(llllllllllllllllllIlIlIIlIIllIll) != null) {
                    llllllllllllllllllIlIlIIlIIlllII.addProperty("class", llllllllllllllllllIlIlIIlIIllIII.channel().pipeline().get(llllllllllllllllllIlIlIIlIIllIll).getClass().getName());
                    try {
                        final Object llllllllllllllllllIlIlIIlIIlllIl = ReflectionUtil.get(llllllllllllllllllIlIlIIlIIllIII.channel().pipeline().get(llllllllllllllllllIlIlIIlIIllIll), "childHandler", ChannelInitializer.class);
                        llllllllllllllllllIlIlIIlIIlllII.addProperty("childClass", llllllllllllllllllIlIlIIlIIlllIl.getClass().getName());
                        if (llllllllllllllllllIlIlIIlIIlllIl instanceof SpongeChannelInitializer) {
                            llllllllllllllllllIlIlIIlIIlllII.addProperty("oldInit", ((SpongeChannelInitializer)llllllllllllllllllIlIlIIlIIlllIl).getOriginal().getClass().getName());
                        }
                    }
                    catch (Exception ex) {}
                }
                llllllllllllllllllIlIlIIlIIllIIl.add(llllllllllllllllllIlIlIIlIIlllII);
            }
            llllllllllllllllllIlIlIIlIIllIlI.add("pipeline", llllllllllllllllllIlIlIIlIIllIIl);
            llllllllllllllllllIlIlIIlIIlIIll.add(llllllllllllllllllIlIlIIlIIllIlI);
        }
        llllllllllllllllllIlIlIIlIIlIlII.add("injectedChannelInitializers", llllllllllllllllllIlIlIIlIIlIIll);
        final JsonObject llllllllllllllllllIlIlIIlIIlIIlI = new JsonObject();
        final JsonObject llllllllllllllllllIlIlIIlIIlIIIl = new JsonObject();
        try {
            for (final Pair<Field, Object> llllllllllllllllllIlIlIIlIIlIllI : this.injectedLists) {
                final Object llllllllllllllllllIlIlIIlIIlIlll = llllllllllllllllllIlIlIIlIIlIllI.getKey().get(llllllllllllllllllIlIlIIlIIlIllI.getValue());
                llllllllllllllllllIlIlIIlIIlIIIl.addProperty(llllllllllllllllllIlIlIIlIIlIllI.getKey().getName(), llllllllllllllllllIlIlIIlIIlIlll.getClass().getName());
                if (llllllllllllllllllIlIlIIlIIlIlll instanceof ListWrapper) {
                    llllllllllllllllllIlIlIIlIIlIIlI.addProperty(llllllllllllllllllIlIlIIlIIlIllI.getKey().getName(), ((ListWrapper)llllllllllllllllllIlIlIIlIIlIlll).getOriginalList().getClass().getName());
                }
            }
            llllllllllllllllllIlIlIIlIIlIlII.add("wrappedLists", llllllllllllllllllIlIlIIlIIlIIlI);
            llllllllllllllllllIlIlIIlIIlIlII.add("currentLists", llllllllllllllllllIlIlIIlIIlIIIl);
        }
        catch (Exception ex2) {}
        return llllllllllllllllllIlIlIIlIIlIlII;
    }
    
    @Override
    public boolean lateProtocolVersionSetting() {
        return true;
    }
}
