package com.viaversion.viaversion.bukkit.util;

import org.bukkit.*;

public class NMSUtil
{
    private static final /* synthetic */ String NMS;
    private static final /* synthetic */ String BASE;
    private static final /* synthetic */ boolean DEBUG_PROPERTY;
    
    private static boolean loadDebugProperty() {
        try {
            final Class<?> lllllllllllllIIlllIlIllIllIIIlll = nms("MinecraftServer", "net.minecraft.server.MinecraftServer");
            final Object lllllllllllllIIlllIlIllIllIIIllI = lllllllllllllIIlllIlIllIllIIIlll.getDeclaredMethod("getServer", (Class<?>[])new Class[0]).invoke(null, new Object[0]);
            return (boolean)lllllllllllllIIlllIlIllIllIIIlll.getMethod("isDebugging", (Class<?>[])new Class[0]).invoke(lllllllllllllIIlllIlIllIllIIIllI, new Object[0]);
        }
        catch (ReflectiveOperationException lllllllllllllIIlllIlIllIllIIIlIl) {
            return false;
        }
    }
    
    public static Class<?> nms(final String lllllllllllllIIlllIlIllIllIIIIII) throws ClassNotFoundException {
        return Class.forName(String.valueOf(new StringBuilder().append(NMSUtil.NMS).append(".").append(lllllllllllllIIlllIlIllIllIIIIII)));
    }
    
    public static Class<?> nms(final String lllllllllllllIIlllIlIllIlIlllIIl, final String lllllllllllllIIlllIlIllIlIlllIII) throws ClassNotFoundException {
        try {
            return Class.forName(String.valueOf(new StringBuilder().append(NMSUtil.NMS).append(".").append(lllllllllllllIIlllIlIllIlIlllIIl)));
        }
        catch (ClassNotFoundException lllllllllllllIIlllIlIllIlIllllII) {
            return Class.forName(lllllllllllllIIlllIlIllIlIlllIII);
        }
    }
    
    public static String getVersion() {
        return NMSUtil.BASE.substring(NMSUtil.BASE.lastIndexOf(46) + 1);
    }
    
    static {
        BASE = Bukkit.getServer().getClass().getPackage().getName();
        NMS = NMSUtil.BASE.replace("org.bukkit.craftbukkit", "net.minecraft.server");
        DEBUG_PROPERTY = loadDebugProperty();
    }
    
    public static Class<?> obc(final String lllllllllllllIIlllIlIllIlIllIlII) throws ClassNotFoundException {
        return Class.forName(String.valueOf(new StringBuilder().append(NMSUtil.BASE).append(".").append(lllllllllllllIIlllIlIllIlIllIlII)));
    }
    
    public static boolean isDebugPropertySet() {
        return NMSUtil.DEBUG_PROPERTY;
    }
}
