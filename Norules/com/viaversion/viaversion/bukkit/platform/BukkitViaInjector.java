package com.viaversion.viaversion.bukkit.platform;

import com.viaversion.viaversion.api.platform.*;
import org.bukkit.*;
import com.viaversion.viaversion.bukkit.util.*;
import com.viaversion.viaversion.api.*;
import com.viaversion.viaversion.util.*;
import java.lang.reflect.*;
import com.viaversion.viaversion.bukkit.handlers.*;
import org.bukkit.plugin.*;
import io.netty.channel.*;
import java.util.*;
import com.viaversion.viaversion.libs.gson.*;

public class BukkitViaInjector implements ViaInjector
{
    private /* synthetic */ boolean protocolLib;
    private final /* synthetic */ List<Pair<Field, Object>> injectedLists;
    private final /* synthetic */ List<ChannelFuture> injectedFutures;
    
    @Override
    public int getServerProtocolVersion() throws Exception {
        if (PaperViaInjector.PAPER_PROTOCOL_METHOD) {
            return Bukkit.getUnsafe().getProtocolVersion();
        }
        try {
            final Class<?> lllllllllllllIllIlllIIIllIlIllII = NMSUtil.nms("MinecraftServer", "net.minecraft.server.MinecraftServer");
            final Object lllllllllllllIllIlllIIIllIlIlIll = ReflectionUtil.invokeStatic(lllllllllllllIllIlllIIIllIlIllII, "getServer");
            final Class<?> lllllllllllllIllIlllIIIllIlIlIlI = NMSUtil.nms("ServerPing", "net.minecraft.network.protocol.status.ServerPing");
            Object lllllllllllllIllIlllIIIllIlIlIIl = null;
            final Field[] declaredFields = lllllllllllllIllIlllIIIllIlIllII.getDeclaredFields();
            final int length = declaredFields.length;
            for (long lllllllllllllIllIlllIIIllIlIIIII = 0; lllllllllllllIllIlllIIIllIlIIIII < length; ++lllllllllllllIllIlllIIIllIlIIIII) {
                final Field lllllllllllllIllIlllIIIllIllIIIl = declaredFields[lllllllllllllIllIlllIIIllIlIIIII];
                if (lllllllllllllIllIlllIIIllIllIIIl.getType() != null && lllllllllllllIllIlllIIIllIllIIIl.getType().getSimpleName().equals("ServerPing")) {
                    lllllllllllllIllIlllIIIllIllIIIl.setAccessible(true);
                    lllllllllllllIllIlllIIIllIlIlIIl = lllllllllllllIllIlllIIIllIllIIIl.get(lllllllllllllIllIlllIIIllIlIlIll);
                }
            }
            if (lllllllllllllIllIlllIIIllIlIlIIl != null) {
                Object lllllllllllllIllIlllIIIllIlIllIl = null;
                final Field[] declaredFields2 = lllllllllllllIllIlllIIIllIlIlIlI.getDeclaredFields();
                long lllllllllllllIllIlllIIIllIlIIIII = declaredFields2.length;
                for (final Field lllllllllllllIllIlllIIIllIllIIII : declaredFields2) {
                    if (lllllllllllllIllIlllIIIllIllIIII.getType() != null && lllllllllllllIllIlllIIIllIllIIII.getType().getSimpleName().endsWith("ServerData")) {
                        lllllllllllllIllIlllIIIllIllIIII.setAccessible(true);
                        lllllllllllllIllIlllIIIllIlIllIl = lllllllllllllIllIlllIIIllIllIIII.get(lllllllllllllIllIlllIIIllIlIlIIl);
                    }
                }
                if (lllllllllllllIllIlllIIIllIlIllIl != null) {
                    int lllllllllllllIllIlllIIIllIlIlllI = -1;
                    lllllllllllllIllIlllIIIllIlIIIII = (long)(Object)lllllllllllllIllIlllIIIllIlIllIl.getClass().getDeclaredFields();
                    final int length2 = lllllllllllllIllIlllIIIllIlIIIII.length;
                    for (Exception lllllllllllllIllIlllIIIllIIllllI = (Exception)0; lllllllllllllIllIlllIIIllIIllllI < length2; ++lllllllllllllIllIlllIIIllIIllllI) {
                        final Field lllllllllllllIllIlllIIIllIlIllll = lllllllllllllIllIlllIIIllIlIIIII[lllllllllllllIllIlllIIIllIIllllI];
                        if (lllllllllllllIllIlllIIIllIlIllll.getType() != null && lllllllllllllIllIlllIIIllIlIllll.getType() == Integer.TYPE) {
                            lllllllllllllIllIlllIIIllIlIllll.setAccessible(true);
                            lllllllllllllIllIlllIIIllIlIlllI = (int)lllllllllllllIllIlllIIIllIlIllll.get(lllllllllllllIllIlllIIIllIlIllIl);
                        }
                    }
                    if (lllllllllllllIllIlllIIIllIlIlllI != -1) {
                        return lllllllllllllIllIlllIIIllIlIlllI;
                    }
                }
            }
        }
        catch (Exception lllllllllllllIllIlllIIIllIlIlIII) {
            throw new Exception("Failed to get server", lllllllllllllIllIlllIIIllIlIlIII);
        }
        throw new Exception("Failed to get server");
    }
    
    @Override
    public void inject() throws Exception {
        if (PaperViaInjector.PAPER_INJECTION_METHOD) {
            PaperViaInjector.setPaperChannelInitializeListener();
            return;
        }
        try {
            final Object lllllllllllllIllIlllIIlIIIIIIlIl = getServerConnection();
            if (lllllllllllllIllIlllIIlIIIIIIlIl == null) {
                throw new Exception("We failed to find the core component 'ServerConnection', please file an issue on our GitHub.");
            }
            final byte lllllllllllllIllIlllIIlIIIIIIIII = (Object)lllllllllllllIllIlllIIlIIIIIIlIl.getClass().getDeclaredFields();
            final double lllllllllllllIllIlllIIIlllllllll = lllllllllllllIllIlllIIlIIIIIIIII.length;
            for (short lllllllllllllIllIlllIIIllllllllI = 0; lllllllllllllIllIlllIIIllllllllI < lllllllllllllIllIlllIIIlllllllll; ++lllllllllllllIllIlllIIIllllllllI) {
                final Field lllllllllllllIllIlllIIlIIIIIIllI = lllllllllllllIllIlllIIlIIIIIIIII[lllllllllllllIllIlllIIIllllllllI];
                lllllllllllllIllIlllIIlIIIIIIllI.setAccessible(true);
                final Object lllllllllllllIllIlllIIlIIIIIIlll = lllllllllllllIllIlllIIlIIIIIIllI.get(lllllllllllllIllIlllIIlIIIIIIlIl);
                if (lllllllllllllIllIlllIIlIIIIIIlll instanceof List) {
                    final List lllllllllllllIllIlllIIlIIIIIlIII = new ListWrapper((List)lllllllllllllIllIlllIIlIIIIIIlll) {
                        @Override
                        public void handleAdd(final Object lllllllllllllIllIllIIIllIIIlIIll) {
                            if (lllllllllllllIllIllIIIllIIIlIIll instanceof ChannelFuture) {
                                try {
                                    BukkitViaInjector.this.injectChannelFuture((ChannelFuture)lllllllllllllIllIllIIIllIIIlIIll);
                                }
                                catch (Exception lllllllllllllIllIllIIIllIIIlIlll) {
                                    lllllllllllllIllIllIIIllIIIlIlll.printStackTrace();
                                }
                            }
                        }
                    };
                    this.injectedLists.add(new Pair<Field, Object>(lllllllllllllIllIlllIIlIIIIIIllI, lllllllllllllIllIlllIIlIIIIIIlIl));
                    lllllllllllllIllIlllIIlIIIIIIllI.set(lllllllllllllIllIlllIIlIIIIIIlIl, lllllllllllllIllIlllIIlIIIIIlIII);
                    synchronized (lllllllllllllIllIlllIIlIIIIIlIII) {
                        for (final Object lllllllllllllIllIlllIIlIIIIIlIIl : (List)lllllllllllllIllIlllIIlIIIIIIlll) {
                            if (!(lllllllllllllIllIlllIIlIIIIIlIIl instanceof ChannelFuture)) {
                                break;
                            }
                            this.injectChannelFuture((ChannelFuture)lllllllllllllIllIlllIIlIIIIIlIIl);
                        }
                    }
                }
            }
        }
        catch (Exception lllllllllllllIllIlllIIlIIIIIIlII) {
            Via.getPlatform().getLogger().severe("Unable to inject ViaVersion, please post these details on our GitHub and ensure you're using a compatible server version.");
            throw lllllllllllllIllIlllIIlIIIIIIlII;
        }
    }
    
    public BukkitViaInjector() {
        this.injectedFutures = new ArrayList<ChannelFuture>();
        this.injectedLists = new ArrayList<Pair<Field, Object>>();
    }
    
    @Override
    public String getEncoderName() {
        return "encoder";
    }
    
    @Override
    public String getDecoderName() {
        return this.protocolLib ? "protocol_lib_decoder" : "decoder";
    }
    
    public void setProtocolLib(final boolean lllllllllllllIllIlllIIIlIIllIllI) {
        this.protocolLib = lllllllllllllIllIlllIIIlIIllIllI;
    }
    
    public static boolean isBinded() {
        if (PaperViaInjector.PAPER_INJECTION_METHOD) {
            return true;
        }
        try {
            final Object lllllllllllllIllIlllIIIlIllllIIl = getServerConnection();
            if (lllllllllllllIllIlllIIIlIllllIIl == null) {
                return false;
            }
            final char lllllllllllllIllIlllIIIlIlllIlll = (Object)lllllllllllllIllIlllIIIlIllllIIl.getClass().getDeclaredFields();
            final int lllllllllllllIllIlllIIIlIlllIllI = lllllllllllllIllIlllIIIlIlllIlll.length;
            for (char lllllllllllllIllIlllIIIlIlllIlIl = '\0'; lllllllllllllIllIlllIIIlIlllIlIl < lllllllllllllIllIlllIIIlIlllIllI; ++lllllllllllllIllIlllIIIlIlllIlIl) {
                final Field lllllllllllllIllIlllIIIlIllllIlI = lllllllllllllIllIlllIIIlIlllIlll[lllllllllllllIllIlllIIIlIlllIlIl];
                lllllllllllllIllIlllIIIlIllllIlI.setAccessible(true);
                final Object lllllllllllllIllIlllIIIlIllllIll = lllllllllllllIllIlllIIIlIllllIlI.get(lllllllllllllIllIlllIIIlIllllIIl);
                if (lllllllllllllIllIlllIIIlIllllIll instanceof List) {
                    synchronized (lllllllllllllIllIlllIIIlIllllIll) {
                        final int lllllllllllllIllIlllIIIlIlllIIIl = (int)((List)lllllllllllllIllIlllIIIlIllllIll).iterator();
                        if (((Iterator)lllllllllllllIllIlllIIIlIlllIIIl).hasNext()) {
                            final Object lllllllllllllIllIlllIIIlIlllllII = ((Iterator<Object>)lllllllllllllIllIlllIIIlIlllIIIl).next();
                            if (lllllllllllllIllIlllIIIlIlllllII instanceof ChannelFuture) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        catch (Exception ex) {}
        return false;
    }
    
    @Override
    public boolean lateProtocolVersionSetting() {
        return true;
    }
    
    public static void patchLists() throws Exception {
        if (PaperViaInjector.PAPER_INJECTION_METHOD) {
            return;
        }
        final Object lllllllllllllIllIlllIIIlIlIIIIIl = getServerConnection();
        if (lllllllllllllIllIlllIIIlIlIIIIIl == null) {
            Via.getPlatform().getLogger().warning("We failed to find the core component 'ServerConnection', please file an issue on our GitHub.");
            return;
        }
        final float lllllllllllllIllIlllIIIlIIllllll = (Object)lllllllllllllIllIlllIIIlIlIIIIIl.getClass().getDeclaredFields();
        final long lllllllllllllIllIlllIIIlIIlllllI = lllllllllllllIllIlllIIIlIIllllll.length;
        for (String lllllllllllllIllIlllIIIlIIllllIl = (String)0; lllllllllllllIllIlllIIIlIIllllIl < lllllllllllllIllIlllIIIlIIlllllI; ++lllllllllllllIllIlllIIIlIIllllIl) {
            final Field lllllllllllllIllIlllIIIlIlIIIIlI = lllllllllllllIllIlllIIIlIIllllll[lllllllllllllIllIlllIIIlIIllllIl];
            lllllllllllllIllIlllIIIlIlIIIIlI.setAccessible(true);
            final Object lllllllllllllIllIlllIIIlIlIIIlII = lllllllllllllIllIlllIIIlIlIIIIlI.get(lllllllllllllIllIlllIIIlIlIIIIIl);
            if (lllllllllllllIllIlllIIIlIlIIIlII instanceof List) {
                if (!(lllllllllllllIllIlllIIIlIlIIIlII instanceof ConcurrentList)) {
                    final ConcurrentList lllllllllllllIllIlllIIIlIlIIIIll = new ConcurrentList();
                    lllllllllllllIllIlllIIIlIlIIIIll.addAll((Collection)lllllllllllllIllIlllIIIlIlIIIlII);
                    lllllllllllllIllIlllIIIlIlIIIIlI.set(lllllllllllllIllIlllIIIlIlIIIIIl, lllllllllllllIllIlllIIIlIlIIIIll);
                }
            }
        }
    }
    
    public static Object getServerConnection() throws Exception {
        final Class<?> lllllllllllllIllIlllIIIllIIlIIII = NMSUtil.nms("MinecraftServer", "net.minecraft.server.MinecraftServer");
        final Object lllllllllllllIllIlllIIIllIIIllll = ReflectionUtil.invokeStatic(lllllllllllllIllIlllIIIllIIlIIII, "getServer");
        Object lllllllllllllIllIlllIIIllIIIlllI = null;
        final float lllllllllllllIllIlllIIIllIIIlIlI = (Object)lllllllllllllIllIlllIIIllIIlIIII.getDeclaredMethods();
        final short lllllllllllllIllIlllIIIllIIIlIIl = (short)lllllllllllllIllIlllIIIllIIIlIlI.length;
        for (float lllllllllllllIllIlllIIIllIIIlIII = 0; lllllllllllllIllIlllIIIllIIIlIII < lllllllllllllIllIlllIIIllIIIlIIl; ++lllllllllllllIllIlllIIIllIIIlIII) {
            final Method lllllllllllllIllIlllIIIllIIlIIIl = lllllllllllllIllIlllIIIllIIIlIlI[lllllllllllllIllIlllIIIllIIIlIII];
            if (lllllllllllllIllIlllIIIllIIlIIIl.getReturnType() != null && lllllllllllllIllIlllIIIllIIlIIIl.getReturnType().getSimpleName().equals("ServerConnection") && lllllllllllllIllIlllIIIllIIlIIIl.getParameterTypes().length == 0) {
                lllllllllllllIllIlllIIIllIIIlllI = lllllllllllllIllIlllIIIllIIlIIIl.invoke(lllllllllllllIllIlllIIIllIIIllll, new Object[0]);
            }
        }
        return lllllllllllllIllIlllIIIllIIIlllI;
    }
    
    private void injectChannelFuture(final ChannelFuture lllllllllllllIllIlllIIIllllIIIIl) throws Exception {
        try {
            final List<String> lllllllllllllIllIlllIIIllllIIlll = (List<String>)lllllllllllllIllIlllIIIllllIIIIl.channel().pipeline().names();
            ChannelHandler lllllllllllllIllIlllIIIllllIIllI = null;
            for (final String lllllllllllllIllIlllIIIllllIllIl : lllllllllllllIllIlllIIIllllIIlll) {
                final ChannelHandler lllllllllllllIllIlllIIIllllIlllI = lllllllllllllIllIlllIIIllllIIIIl.channel().pipeline().get(lllllllllllllIllIlllIIIllllIllIl);
                try {
                    ReflectionUtil.get(lllllllllllllIllIlllIIIllllIlllI, "childHandler", ChannelInitializer.class);
                    lllllllllllllIllIlllIIIllllIIllI = lllllllllllllIllIlllIIIllllIlllI;
                }
                catch (Exception ex) {}
            }
            if (lllllllllllllIllIlllIIIllllIIllI == null) {
                lllllllllllllIllIlllIIIllllIIllI = lllllllllllllIllIlllIIIllllIIIIl.channel().pipeline().first();
            }
            try {
                final ChannelInitializer<Channel> lllllllllllllIllIlllIIIllllIllII = (ChannelInitializer<Channel>)ReflectionUtil.get(lllllllllllllIllIlllIIIllllIIllI, "childHandler", ChannelInitializer.class);
                final ChannelInitializer lllllllllllllIllIlllIIIllllIlIll = new BukkitChannelInitializer(lllllllllllllIllIlllIIIllllIllII);
                ReflectionUtil.set(lllllllllllllIllIlllIIIllllIIllI, "childHandler", lllllllllllllIllIlllIIIllllIlIll);
                this.injectedFutures.add(lllllllllllllIllIlllIIIllllIIIIl);
            }
            catch (NoSuchFieldException lllllllllllllIllIlllIIIllllIlIII) {
                final ClassLoader lllllllllllllIllIlllIIIllllIlIIl = lllllllllllllIllIlllIIIllllIIllI.getClass().getClassLoader();
                if (lllllllllllllIllIlllIIIllllIlIIl.getClass().getName().equals("org.bukkit.plugin.java.PluginClassLoader")) {
                    final PluginDescriptionFile lllllllllllllIllIlllIIIllllIlIlI = ReflectionUtil.get(lllllllllllllIllIlllIIIllllIlIIl, "description", PluginDescriptionFile.class);
                    throw new Exception(String.valueOf(new StringBuilder().append("Unable to inject, due to ").append(lllllllllllllIllIlllIIIllllIIllI.getClass().getName()).append(", try without the plugin ").append(lllllllllllllIllIlllIIIllllIlIlI.getName()).append("?")));
                }
                throw new Exception(String.valueOf(new StringBuilder().append("Unable to find core component 'childHandler', please check your plugins. issue: ").append(lllllllllllllIllIlllIIIllllIIllI.getClass().getName())));
            }
        }
        catch (Exception lllllllllllllIllIlllIIIllllIIlIl) {
            Via.getPlatform().getLogger().severe("We failed to inject ViaVersion, have you got late-bind enabled with something else?");
            throw lllllllllllllIllIlllIIIllllIIlIl;
        }
    }
    
    @Override
    public void uninject() throws Exception {
        if (PaperViaInjector.PAPER_INJECTION_METHOD) {
            PaperViaInjector.removePaperChannelInitializeListener();
            return;
        }
        for (final ChannelFuture lllllllllllllIllIlllIIIlllIIlIlI : this.injectedFutures) {
            final List<String> lllllllllllllIllIlllIIIlllIIllII = (List<String>)lllllllllllllIllIlllIIIlllIIlIlI.channel().pipeline().names();
            ChannelHandler lllllllllllllIllIlllIIIlllIIlIll = null;
            for (final String lllllllllllllIllIlllIIIlllIIllll : lllllllllllllIllIlllIIIlllIIllII) {
                final ChannelHandler lllllllllllllIllIlllIIIlllIlIIII = lllllllllllllIllIlllIIIlllIIlIlI.channel().pipeline().get(lllllllllllllIllIlllIIIlllIIllll);
                try {
                    final ChannelInitializer<Channel> lllllllllllllIllIlllIIIlllIlIIIl = (ChannelInitializer<Channel>)ReflectionUtil.get(lllllllllllllIllIlllIIIlllIlIIII, "childHandler", ChannelInitializer.class);
                    if (!(lllllllllllllIllIlllIIIlllIlIIIl instanceof BukkitChannelInitializer)) {
                        continue;
                    }
                    lllllllllllllIllIlllIIIlllIIlIll = lllllllllllllIllIlllIIIlllIlIIII;
                }
                catch (Exception ex) {}
            }
            if (lllllllllllllIllIlllIIIlllIIlIll == null) {
                lllllllllllllIllIlllIIIlllIIlIll = lllllllllllllIllIlllIIIlllIIlIlI.channel().pipeline().first();
            }
            try {
                final ChannelInitializer<Channel> lllllllllllllIllIlllIIIlllIIlllI = (ChannelInitializer<Channel>)ReflectionUtil.get(lllllllllllllIllIlllIIIlllIIlIll, "childHandler", ChannelInitializer.class);
                if (!(lllllllllllllIllIlllIIIlllIIlllI instanceof BukkitChannelInitializer)) {
                    continue;
                }
                ReflectionUtil.set(lllllllllllllIllIlllIIIlllIIlIll, "childHandler", ((BukkitChannelInitializer)lllllllllllllIllIlllIIIlllIIlllI).getOriginal());
            }
            catch (Exception lllllllllllllIllIlllIIIlllIIllIl) {
                Via.getPlatform().getLogger().severe("Failed to remove injection handler, reload won't work with connections, please reboot!");
            }
        }
        this.injectedFutures.clear();
        for (final Pair<Field, Object> lllllllllllllIllIlllIIIlllIIIlll : this.injectedLists) {
            try {
                final Object lllllllllllllIllIlllIIIlllIIlIIl = lllllllllllllIllIlllIIIlllIIIlll.getKey().get(lllllllllllllIllIlllIIIlllIIIlll.getValue());
                if (!(lllllllllllllIllIlllIIIlllIIlIIl instanceof ListWrapper)) {
                    continue;
                }
                lllllllllllllIllIlllIIIlllIIIlll.getKey().set(lllllllllllllIllIlllIIIlllIIIlll.getValue(), ((ListWrapper)lllllllllllllIllIlllIIIlllIIlIIl).getOriginalList());
            }
            catch (IllegalAccessException lllllllllllllIllIlllIIIlllIIlIII) {
                Via.getPlatform().getLogger().severe("Failed to remove injection, reload won't work with connections, please reboot!");
            }
        }
        this.injectedLists.clear();
    }
    
    @Override
    public JsonObject getDump() {
        final JsonObject lllllllllllllIllIlllIIIlIlIllIlI = new JsonObject();
        final JsonArray lllllllllllllIllIlllIIIlIlIllIIl = new JsonArray();
        for (final ChannelFuture lllllllllllllIllIlllIIIlIlIllllI : this.injectedFutures) {
            final JsonObject lllllllllllllIllIlllIIIlIllIIIII = new JsonObject();
            lllllllllllllIllIlllIIIlIllIIIII.addProperty("futureClass", lllllllllllllIllIlllIIIlIlIllllI.getClass().getName());
            lllllllllllllIllIlllIIIlIllIIIII.addProperty("channelClass", lllllllllllllIllIlllIIIlIlIllllI.channel().getClass().getName());
            final JsonArray lllllllllllllIllIlllIIIlIlIlllll = new JsonArray();
            for (final String lllllllllllllIllIlllIIIlIllIIIIl : lllllllllllllIllIlllIIIlIlIllllI.channel().pipeline().names()) {
                final JsonObject lllllllllllllIllIlllIIIlIllIIIlI = new JsonObject();
                lllllllllllllIllIlllIIIlIllIIIlI.addProperty("name", lllllllllllllIllIlllIIIlIllIIIIl);
                if (lllllllllllllIllIlllIIIlIlIllllI.channel().pipeline().get(lllllllllllllIllIlllIIIlIllIIIIl) != null) {
                    lllllllllllllIllIlllIIIlIllIIIlI.addProperty("class", lllllllllllllIllIlllIIIlIlIllllI.channel().pipeline().get(lllllllllllllIllIlllIIIlIllIIIIl).getClass().getName());
                    try {
                        final Object lllllllllllllIllIlllIIIlIllIIIll = ReflectionUtil.get(lllllllllllllIllIlllIIIlIlIllllI.channel().pipeline().get(lllllllllllllIllIlllIIIlIllIIIIl), "childHandler", ChannelInitializer.class);
                        lllllllllllllIllIlllIIIlIllIIIlI.addProperty("childClass", lllllllllllllIllIlllIIIlIllIIIll.getClass().getName());
                        if (lllllllllllllIllIlllIIIlIllIIIll instanceof BukkitChannelInitializer) {
                            lllllllllllllIllIlllIIIlIllIIIlI.addProperty("oldInit", ((BukkitChannelInitializer)lllllllllllllIllIlllIIIlIllIIIll).getOriginal().getClass().getName());
                        }
                    }
                    catch (Exception ex) {}
                }
                lllllllllllllIllIlllIIIlIlIlllll.add(lllllllllllllIllIlllIIIlIllIIIlI);
            }
            lllllllllllllIllIlllIIIlIllIIIII.add("pipeline", lllllllllllllIllIlllIIIlIlIlllll);
            lllllllllllllIllIlllIIIlIlIllIIl.add(lllllllllllllIllIlllIIIlIllIIIII);
        }
        lllllllllllllIllIlllIIIlIlIllIlI.add("injectedChannelInitializers", lllllllllllllIllIlllIIIlIlIllIIl);
        final JsonObject lllllllllllllIllIlllIIIlIlIllIII = new JsonObject();
        final JsonObject lllllllllllllIllIlllIIIlIlIlIlll = new JsonObject();
        try {
            for (final Pair<Field, Object> lllllllllllllIllIlllIIIlIlIlllII : this.injectedLists) {
                final Object lllllllllllllIllIlllIIIlIlIlllIl = lllllllllllllIllIlllIIIlIlIlllII.getKey().get(lllllllllllllIllIlllIIIlIlIlllII.getValue());
                lllllllllllllIllIlllIIIlIlIlIlll.addProperty(lllllllllllllIllIlllIIIlIlIlllII.getKey().getName(), lllllllllllllIllIlllIIIlIlIlllIl.getClass().getName());
                if (lllllllllllllIllIlllIIIlIlIlllIl instanceof ListWrapper) {
                    lllllllllllllIllIlllIIIlIlIllIII.addProperty(lllllllllllllIllIlllIIIlIlIlllII.getKey().getName(), ((ListWrapper)lllllllllllllIllIlllIIIlIlIlllIl).getOriginalList().getClass().getName());
                }
            }
            lllllllllllllIllIlllIIIlIlIllIlI.add("wrappedLists", lllllllllllllIllIlllIIIlIlIllIII);
            lllllllllllllIllIlllIIIlIlIllIlI.add("currentLists", lllllllllllllIllIlllIIIlIlIlIlll);
        }
        catch (Exception ex2) {}
        lllllllllllllIllIlllIIIlIlIllIlI.addProperty("binded", isBinded());
        return lllllllllllllIllIlllIIIlIlIllIlI;
    }
}
