package com.viaversion.viaversion.velocity.platform;

import com.viaversion.viaversion.api.platform.*;
import com.viaversion.viaversion.api.*;
import com.viaversion.viaversion.*;
import com.viaversion.viaversion.util.*;
import io.netty.channel.*;
import com.viaversion.viaversion.velocity.handlers.*;
import com.viaversion.viaversion.api.protocol.version.*;
import java.lang.reflect.*;
import com.viaversion.viaversion.libs.gson.*;
import com.viaversion.viaversion.libs.fastutil.ints.*;

public class VelocityViaInjector implements ViaInjector
{
    public static /* synthetic */ Method getPlayerInfoForwardingMode;
    
    @Override
    public int getServerProtocolVersion() throws Exception {
        return getLowestSupportedProtocolVersion();
    }
    
    @Override
    public String getEncoderName() {
        return "via-encoder";
    }
    
    @Override
    public void inject() throws Exception {
        Via.getPlatform().getLogger().info("Replacing channel initializers; you can safely ignore the following two warnings.");
        final Object lllllllllllllIlIlIIIllIlIIllIlII = ReflectionUtil.get(VelocityPlugin.PROXY, "cm", Object.class);
        final Object lllllllllllllIlIlIIIllIlIIllIIll = ReflectionUtil.invoke(lllllllllllllIlIlIIIllIlIIllIlII, "getServerChannelInitializer");
        final ChannelInitializer lllllllllllllIlIlIIIllIlIIllIIlI = this.getInitializer();
        lllllllllllllIlIlIIIllIlIIllIIll.getClass().getMethod("set", ChannelInitializer.class).invoke(lllllllllllllIlIlIIIllIlIIllIIll, new VelocityChannelInitializer((ChannelInitializer<?>)lllllllllllllIlIlIIIllIlIIllIIlI, false));
        final Object lllllllllllllIlIlIIIllIlIIllIIIl = ReflectionUtil.invoke(lllllllllllllIlIlIIIllIlIIllIlII, "getBackendChannelInitializer");
        final ChannelInitializer lllllllllllllIlIlIIIllIlIIllIIII = this.getBackendInitializer();
        lllllllllllllIlIlIIIllIlIIllIIIl.getClass().getMethod("set", ChannelInitializer.class).invoke(lllllllllllllIlIlIIIllIlIIllIIIl, new VelocityChannelInitializer((ChannelInitializer<?>)lllllllllllllIlIlIIIllIlIIllIIII, true));
    }
    
    @Override
    public void uninject() {
        Via.getPlatform().getLogger().severe("ViaVersion cannot remove itself from Velocity without a reboot!");
    }
    
    public static int getLowestSupportedProtocolVersion() {
        try {
            if (VelocityViaInjector.getPlayerInfoForwardingMode != null && ((Enum)VelocityViaInjector.getPlayerInfoForwardingMode.invoke(VelocityPlugin.PROXY.getConfiguration(), new Object[0])).name().equals("MODERN")) {
                return ProtocolVersion.v1_13.getVersion();
            }
        }
        catch (IllegalAccessException ex) {}
        catch (InvocationTargetException ex2) {}
        return com.velocitypowered.api.network.ProtocolVersion.MINIMUM_VERSION.getProtocol();
    }
    
    private ChannelInitializer getBackendInitializer() throws Exception {
        final Object lllllllllllllIlIlIIIllIlIIllllll = ReflectionUtil.get(VelocityPlugin.PROXY, "cm", Object.class);
        final Object lllllllllllllIlIlIIIllIlIIlllllI = ReflectionUtil.invoke(lllllllllllllIlIlIIIllIlIIllllll, "getBackendChannelInitializer");
        return (ChannelInitializer)ReflectionUtil.invoke(lllllllllllllIlIlIIIllIlIIlllllI, "get");
    }
    
    @Override
    public String getDecoderName() {
        return "via-decoder";
    }
    
    static {
        try {
            VelocityViaInjector.getPlayerInfoForwardingMode = Class.forName("com.velocitypowered.proxy.config.VelocityConfiguration").getMethod("getPlayerInfoForwardingMode", (Class<?>[])new Class[0]);
        }
        catch (NoSuchMethodException | ClassNotFoundException ex2) {
            final ReflectiveOperationException ex;
            final ReflectiveOperationException lllllllllllllIlIlIIIllIlIIIIlllI = ex;
            lllllllllllllIlIlIIIllIlIIIIlllI.printStackTrace();
        }
    }
    
    private ChannelInitializer getInitializer() throws Exception {
        final Object lllllllllllllIlIlIIIllIlIlIIIllI = ReflectionUtil.get(VelocityPlugin.PROXY, "cm", Object.class);
        final Object lllllllllllllIlIlIIIllIlIlIIIlIl = ReflectionUtil.invoke(lllllllllllllIlIlIIIllIlIlIIIllI, "getServerChannelInitializer");
        return (ChannelInitializer)ReflectionUtil.invoke(lllllllllllllIlIlIIIllIlIlIIIlIl, "get");
    }
    
    @Override
    public JsonObject getDump() {
        final JsonObject lllllllllllllIlIlIIIllIlIIIlIIll = new JsonObject();
        try {
            lllllllllllllIlIlIIIllIlIIIlIIll.addProperty("currentInitializer", this.getInitializer().getClass().getName());
        }
        catch (Exception ex) {}
        return lllllllllllllIlIlIIIllIlIIIlIIll;
    }
    
    @Override
    public IntSortedSet getServerProtocolVersions() throws Exception {
        final int lllllllllllllIlIlIIIllIlIIlIIIIl = getLowestSupportedProtocolVersion();
        final IntSortedSet lllllllllllllIlIlIIIllIlIIlIIIII = new IntLinkedOpenHashSet();
        for (final com.velocitypowered.api.network.ProtocolVersion lllllllllllllIlIlIIIllIlIIlIIIll : com.velocitypowered.api.network.ProtocolVersion.SUPPORTED_VERSIONS) {
            if (lllllllllllllIlIlIIIllIlIIlIIIll.getProtocol() >= lllllllllllllIlIlIIIllIlIIlIIIIl) {
                lllllllllllllIlIlIIIllIlIIlIIIII.add(lllllllllllllIlIlIIIllIlIIlIIIll.getProtocol());
            }
        }
        return lllllllllllllIlIlIIIllIlIIlIIIII;
    }
}
