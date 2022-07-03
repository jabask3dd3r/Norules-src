package com.viaversion.viaversion.bukkit.util;

import org.bukkit.entity.*;
import java.lang.reflect.*;

public class ProtocolSupportUtil
{
    private static /* synthetic */ Method protocolVersionMethod;
    private static /* synthetic */ Method getIdMethod;
    
    static {
        ProtocolSupportUtil.protocolVersionMethod = null;
        ProtocolSupportUtil.getIdMethod = null;
        try {
            ProtocolSupportUtil.protocolVersionMethod = Class.forName("protocolsupport.api.ProtocolSupportAPI").getMethod("getProtocolVersion", Player.class);
            ProtocolSupportUtil.getIdMethod = Class.forName("protocolsupport.api.ProtocolVersion").getMethod("getId", (Class<?>[])new Class[0]);
        }
        catch (Exception ex) {}
    }
    
    public static int getProtocolVersion(final Player lllllllllllllIIlIIlIIlIlIIIIIIIl) {
        if (ProtocolSupportUtil.protocolVersionMethod == null) {
            return -1;
        }
        try {
            final Object lllllllllllllIIlIIlIIlIlIIIIIlII = ProtocolSupportUtil.protocolVersionMethod.invoke(null, lllllllllllllIIlIIlIIlIlIIIIIIIl);
            return (int)ProtocolSupportUtil.getIdMethod.invoke(lllllllllllllIIlIIlIIlIlIIIIIlII, new Object[0]);
        }
        catch (IllegalAccessException lllllllllllllIIlIIlIIlIlIIIIIIll) {
            lllllllllllllIIlIIlIIlIlIIIIIIll.printStackTrace();
        }
        catch (InvocationTargetException lllllllllllllIIlIIlIIlIlIIIIIIlI) {
            lllllllllllllIIlIIlIIlIlIIIIIIlI.printStackTrace();
        }
        return -1;
    }
}
