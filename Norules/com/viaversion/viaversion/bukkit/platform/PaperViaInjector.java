package com.viaversion.viaversion.bukkit.platform;

import io.netty.channel.*;
import com.viaversion.viaversion.bukkit.handlers.*;
import net.kyori.adventure.key.*;
import java.lang.reflect.*;

public final class PaperViaInjector
{
    public static void setPaperChannelInitializeListener() throws ReflectiveOperationException {
        final Class<?> llllllllllllllllIIlIIlIIllIIllIl = Class.forName("io.papermc.paper.network.ChannelInitializeListener");
        final Object llllllllllllllllIIlIIlIIllIIllII = Proxy.newProxyInstance(BukkitViaInjector.class.getClassLoader(), new Class[] { llllllllllllllllIIlIIlIIllIIllIl }, (llllllllllllllllIIlIIlIIlIllIIll, llllllllllllllllIIlIIlIIlIllIlIl, llllllllllllllllIIlIIlIIlIllIlII) -> {
            if (llllllllllllllllIIlIIlIIlIllIlIl.getName().equals("afterInitChannel")) {
                BukkitChannelInitializer.afterChannelInitialize((Channel)llllllllllllllllIIlIIlIIlIllIlII[0]);
                return null;
            }
            else {
                return llllllllllllllllIIlIIlIIlIllIlIl.invoke(llllllllllllllllIIlIIlIIlIllIIll, llllllllllllllllIIlIIlIIlIllIlII);
            }
        });
        final Class<?> llllllllllllllllIIlIIlIIllIIlIll = Class.forName("io.papermc.paper.network.ChannelInitializeListenerHolder");
        final Method llllllllllllllllIIlIIlIIllIIlIlI = llllllllllllllllIIlIIlIIllIIlIll.getDeclaredMethod("addListener", Key.class, llllllllllllllllIIlIIlIIllIIllIl);
        llllllllllllllllIIlIIlIIllIIlIlI.invoke(null, Key.key("viaversion", "injector"), llllllllllllllllIIlIIlIIllIIllII);
    }
    
    static {
        PAPER_INJECTION_METHOD = hasPaperInjectionMethod();
        PAPER_PROTOCOL_METHOD = hasServerProtocolMethod();
    }
    
    private static boolean hasServerProtocolMethod() {
        try {
            Class.forName("org.bukkit.UnsafeValues").getDeclaredMethod("getProtocolVersion", (Class<?>[])new Class[0]);
            return true;
        }
        catch (ReflectiveOperationException llllllllllllllllIIlIIlIIlIlllllI) {
            return false;
        }
    }
    
    private PaperViaInjector() {
    }
    
    public static void removePaperChannelInitializeListener() throws ReflectiveOperationException {
        final Class<?> llllllllllllllllIIlIIlIIllIIIIll = Class.forName("io.papermc.paper.network.ChannelInitializeListenerHolder");
        final Method llllllllllllllllIIlIIlIIllIIIIlI = llllllllllllllllIIlIIlIIllIIIIll.getDeclaredMethod("removeListener", Key.class);
        llllllllllllllllIIlIIlIIllIIIIlI.invoke(null, Key.key("viaversion", "injector"));
    }
    
    private static boolean hasPaperInjectionMethod() {
        try {
            Class.forName("io.papermc.paper.network.ChannelInitializeListener");
            return true;
        }
        catch (ReflectiveOperationException llllllllllllllllIIlIIlIIlIlllIll) {
            return false;
        }
    }
}
