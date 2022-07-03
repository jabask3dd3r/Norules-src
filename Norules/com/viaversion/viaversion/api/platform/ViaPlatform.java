package com.viaversion.viaversion.api.platform;

import java.io.*;
import com.viaversion.viaversion.api.command.*;
import com.viaversion.viaversion.api.*;
import java.util.*;
import java.util.logging.*;
import com.viaversion.viaversion.libs.gson.*;
import com.viaversion.viaversion.api.configuration.*;
import com.viaversion.viaversion.api.connection.*;

public interface ViaPlatform<T>
{
    default Collection<UnsupportedSoftware> getUnsupportedSoftwareClasses() {
        return (Collection<UnsupportedSoftware>)Collections.emptyList();
    }
    
    boolean isPluginEnabled();
    
    File getDataFolder();
    
    String getPlatformVersion();
    
    ViaCommandSender[] getOnlinePlayers();
    
    ConfigurationProvider getConfigurationProvider();
    
    ViaAPI<T> getApi();
    
    String getPluginVersion();
    
    String getPlatformName();
    
    boolean kickPlayer(final UUID p0, final String p1);
    
    PlatformTask runSync(final Runnable p0, final long p1);
    
    void sendMessage(final UUID p0, final String p1);
    
    PlatformTask runRepeatingSync(final Runnable p0, final long p1);
    
    boolean isOldClientsAllowed();
    
    Logger getLogger();
    
    PlatformTask runAsync(final Runnable p0);
    
    JsonObject getDump();
    
    default boolean isProxy() {
        return false;
    }
    
    PlatformTask runSync(final Runnable p0);
    
    ViaVersionConfig getConf();
    
    void onReload();
    
    default boolean disconnect(final UserConnection lllllllllllllIllIIlIlIlIIlIIlIll, final String lllllllllllllIllIIlIlIlIIlIIlIlI) {
        if (lllllllllllllIllIIlIlIlIIlIIlIll.isClientSide()) {
            return false;
        }
        final UUID lllllllllllllIllIIlIlIlIIlIIlIIl = lllllllllllllIllIIlIlIlIIlIIlIll.getProtocolInfo().getUuid();
        return lllllllllllllIllIIlIlIlIIlIIlIIl != null && this.kickPlayer(lllllllllllllIllIIlIlIlIIlIIlIIl, lllllllllllllIllIIlIlIlIIlIIlIlI);
    }
}
