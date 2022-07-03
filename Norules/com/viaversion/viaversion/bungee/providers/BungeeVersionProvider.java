package com.viaversion.viaversion.bungee.providers;

import com.viaversion.viaversion.protocols.base.*;
import com.viaversion.viaversion.util.*;
import net.md_5.bungee.api.*;
import java.util.*;
import com.google.common.collect.*;
import com.viaversion.viaversion.api.protocol.version.*;
import com.viaversion.viaversion.api.*;
import com.viaversion.viaversion.api.connection.*;

public class BungeeVersionProvider extends BaseVersionProvider
{
    private static /* synthetic */ Class<?> ref;
    
    public static int getLowestSupportedVersion() {
        try {
            final List<Integer> lllllllllllllIlIlIllIlIlllIIIlIl = ReflectionUtil.getStatic(BungeeVersionProvider.ref, "SUPPORTED_VERSION_IDS", (Class<List<Integer>>)List.class);
            return lllllllllllllIlIlIllIlIlllIIIlIl.get(0);
        }
        catch (NoSuchFieldException lllllllllllllIlIlIllIlIlllIIIlII) {
            lllllllllllllIlIlIllIlIlllIIIlII.printStackTrace();
        }
        catch (IllegalAccessException lllllllllllllIlIlIllIlIlllIIIIll) {
            lllllllllllllIlIlIllIlIlllIIIIll.printStackTrace();
        }
        return ProxyServer.getInstance().getProtocolVersion();
    }
    
    @Override
    public int getClosestServerProtocol(final UserConnection lllllllllllllIlIlIllIlIlllIIllIl) throws Exception {
        if (BungeeVersionProvider.ref == null) {
            return super.getClosestServerProtocol(lllllllllllllIlIlIllIlIlllIIllIl);
        }
        final List<Integer> lllllllllllllIlIlIllIlIlllIlIIIl = ReflectionUtil.getStatic(BungeeVersionProvider.ref, "SUPPORTED_VERSION_IDS", (Class<List<Integer>>)List.class);
        final List<Integer> lllllllllllllIlIlIllIlIlllIlIIII = new ArrayList<Integer>(lllllllllllllIlIlIllIlIlllIlIIIl);
        Collections.sort(lllllllllllllIlIlIllIlIlllIlIIII);
        final ProtocolInfo lllllllllllllIlIlIllIlIlllIIllll = lllllllllllllIlIlIllIlIlllIIllIl.getProtocolInfo();
        if (lllllllllllllIlIlIllIlIlllIlIIII.contains(lllllllllllllIlIlIllIlIlllIIllll.getProtocolVersion())) {
            return lllllllllllllIlIlIllIlIlllIIllll.getProtocolVersion();
        }
        if (lllllllllllllIlIlIllIlIlllIIllll.getProtocolVersion() < lllllllllllllIlIlIllIlIlllIlIIII.get(0)) {
            return getLowestSupportedVersion();
        }
        for (final Integer lllllllllllllIlIlIllIlIlllIlIlII : Lists.reverse((List)lllllllllllllIlIlIllIlIlllIlIIII)) {
            if (lllllllllllllIlIlIllIlIlllIIllll.getProtocolVersion() > lllllllllllllIlIlIllIlIlllIlIlII && ProtocolVersion.isRegistered(lllllllllllllIlIlIllIlIlllIlIlII)) {
                return lllllllllllllIlIlIllIlIlllIlIlII;
            }
        }
        Via.getPlatform().getLogger().severe(String.valueOf(new StringBuilder().append("Panic, no protocol id found for ").append(lllllllllllllIlIlIllIlIlllIIllll.getProtocolVersion())));
        return lllllllllllllIlIlIllIlIlllIIllll.getProtocolVersion();
    }
    
    static {
        try {
            BungeeVersionProvider.ref = Class.forName("net.md_5.bungee.protocol.ProtocolConstants");
        }
        catch (Exception lllllllllllllIlIlIllIlIllIllllll) {
            Via.getPlatform().getLogger().severe("Could not detect the ProtocolConstants class");
            lllllllllllllIlIlIllIlIllIllllll.printStackTrace();
        }
    }
}
