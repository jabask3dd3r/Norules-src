package com.viaversion.viaversion.bungee.providers;

import com.viaversion.viaversion.protocols.protocol1_9to1_8.providers.*;
import net.md_5.bungee.api.*;
import java.lang.reflect.*;
import com.viaversion.viaversion.api.connection.*;
import net.md_5.bungee.api.connection.*;

public class BungeeMainHandProvider extends MainHandProvider
{
    private static /* synthetic */ Method setMainHand;
    private static /* synthetic */ Method getSettings;
    
    @Override
    public void setMainHand(final UserConnection lllllllllllllIIIlIlllIIllllllIII, final int lllllllllllllIIIlIlllIIlllllIlll) {
        final ProtocolInfo lllllllllllllIIIlIlllIIllllllIlI = lllllllllllllIIIlIlllIIllllllIII.getProtocolInfo();
        if (lllllllllllllIIIlIlllIIllllllIlI == null || lllllllllllllIIIlIlllIIllllllIlI.getUuid() == null) {
            return;
        }
        final ProxiedPlayer lllllllllllllIIIlIlllIIllllllIIl = ProxyServer.getInstance().getPlayer(lllllllllllllIIIlIlllIIllllllIlI.getUuid());
        if (lllllllllllllIIIlIlllIIllllllIIl == null) {
            return;
        }
        try {
            final Object lllllllllllllIIIlIlllIIlllllllll = BungeeMainHandProvider.getSettings.invoke(lllllllllllllIIIlIlllIIllllllIIl, new Object[0]);
            if (lllllllllllllIIIlIlllIIlllllllll != null) {
                BungeeMainHandProvider.setMainHand.invoke(lllllllllllllIIIlIlllIIlllllllll, lllllllllllllIIIlIlllIIlllllIlll);
            }
        }
        catch (IllegalAccessException | InvocationTargetException ex2) {
            final ReflectiveOperationException ex;
            final ReflectiveOperationException lllllllllllllIIIlIlllIIllllllllI = ex;
            lllllllllllllIIIlIlllIIllllllllI.printStackTrace();
        }
    }
    
    static {
        BungeeMainHandProvider.getSettings = null;
        BungeeMainHandProvider.setMainHand = null;
        try {
            BungeeMainHandProvider.getSettings = Class.forName("net.md_5.bungee.UserConnection").getDeclaredMethod("getSettings", (Class<?>[])new Class[0]);
            BungeeMainHandProvider.setMainHand = Class.forName("net.md_5.bungee.protocol.packet.ClientSettings").getDeclaredMethod("setMainHand", Integer.TYPE);
        }
        catch (Exception ex) {}
    }
}
