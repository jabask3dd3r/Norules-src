package com.viaversion.viaversion.bungee.service;

import com.viaversion.viaversion.*;
import java.util.*;
import net.md_5.bungee.api.config.*;
import net.md_5.bungee.api.*;
import com.viaversion.viaversion.bungee.platform.*;
import com.viaversion.viaversion.api.*;
import com.viaversion.viaversion.bungee.providers.*;
import java.util.concurrent.*;

public class ProtocolDetectorService implements Runnable
{
    private static /* synthetic */ ProtocolDetectorService instance;
    private static final /* synthetic */ Map<String, Integer> detectedProtocolIds;
    private final /* synthetic */ BungeePlugin plugin;
    
    public static Map<String, Integer> getDetectedIds() {
        return new HashMap<String, Integer>(ProtocolDetectorService.detectedProtocolIds);
    }
    
    public static void probeServer(final ServerInfo llllllllllllllIIIIIIlIIIlllIlllI) {
        final String llllllllllllllIIIIIIlIIIlllIllIl = llllllllllllllIIIIIIlIIIlllIlllI.getName();
        llllllllllllllIIIIIIlIIIlllIlllI.ping((Callback)new Callback<ServerPing>() {
            public void done(final ServerPing lllllllllllllIlIllllIIlIIlIlIIlI, final Throwable lllllllllllllIlIllllIIlIIlIlIlII) {
                if (lllllllllllllIlIllllIIlIIlIlIlII == null && lllllllllllllIlIllllIIlIIlIlIIlI != null && lllllllllllllIlIllllIIlIIlIlIIlI.getVersion() != null && lllllllllllllIlIllllIIlIIlIlIIlI.getVersion().getProtocol() > 0) {
                    ProtocolDetectorService.detectedProtocolIds.put(llllllllllllllIIIIIIlIIIlllIllIl, lllllllllllllIlIllllIIlIIlIlIIlI.getVersion().getProtocol());
                    if (((BungeeViaConfig)Via.getConfig()).isBungeePingSave()) {
                        final Map<String, Integer> lllllllllllllIlIllllIIlIIlIllIII = ((BungeeViaConfig)Via.getConfig()).getBungeeServerProtocols();
                        final Integer lllllllllllllIlIllllIIlIIlIlIlll = lllllllllllllIlIllllIIlIIlIllIII.get(llllllllllllllIIIIIIlIIIlllIllIl);
                        if (lllllllllllllIlIllllIIlIIlIlIlll != null && lllllllllllllIlIllllIIlIIlIlIlll == lllllllllllllIlIllllIIlIIlIlIIlI.getVersion().getProtocol()) {
                            return;
                        }
                        synchronized (Via.getPlatform().getConfigurationProvider()) {
                            lllllllllllllIlIllllIIlIIlIllIII.put(llllllllllllllIIIIIIlIIIlllIllIl, lllllllllllllIlIllllIIlIIlIlIIlI.getVersion().getProtocol());
                        }
                        Via.getPlatform().getConfigurationProvider().saveConfig();
                    }
                }
            }
        });
    }
    
    public static Integer getProtocolId(final String llllllllllllllIIIIIIlIIlIIIIIIlI) {
        final Map<String, Integer> llllllllllllllIIIIIIlIIlIIIIIIIl = ((BungeeViaConfig)Via.getConfig()).getBungeeServerProtocols();
        final Integer llllllllllllllIIIIIIlIIlIIIIIIII = llllllllllllllIIIIIIlIIlIIIIIIIl.get(llllllllllllllIIIIIIlIIlIIIIIIlI);
        if (llllllllllllllIIIIIIlIIlIIIIIIII != null) {
            return llllllllllllllIIIIIIlIIlIIIIIIII;
        }
        final Integer llllllllllllllIIIIIIlIIIllllllll = ProtocolDetectorService.detectedProtocolIds.get(llllllllllllllIIIIIIlIIlIIIIIIlI);
        if (llllllllllllllIIIIIIlIIIllllllll != null) {
            return llllllllllllllIIIIIIlIIIllllllll;
        }
        final Integer llllllllllllllIIIIIIlIIIlllllllI = llllllllllllllIIIIIIlIIlIIIIIIIl.get("default");
        if (llllllllllllllIIIIIIlIIIlllllllI != null) {
            return llllllllllllllIIIIIIlIIIlllllllI;
        }
        return BungeeVersionProvider.getLowestSupportedVersion();
    }
    
    @Override
    public void run() {
        for (final Map.Entry<String, ServerInfo> llllllllllllllIIIIIIlIIIllllIlIl : this.plugin.getProxy().getServers().entrySet()) {
            probeServer(llllllllllllllIIIIIIlIIIllllIlIl.getValue());
        }
    }
    
    public static ProtocolDetectorService getInstance() {
        return ProtocolDetectorService.instance;
    }
    
    static {
        detectedProtocolIds = new ConcurrentHashMap<String, Integer>();
    }
    
    public BungeePlugin getPlugin() {
        return this.plugin;
    }
    
    public ProtocolDetectorService(final BungeePlugin llllllllllllllIIIIIIlIIlIIIIlIlI) {
        this.plugin = llllllllllllllIIIIIIlIIlIIIIlIlI;
        ProtocolDetectorService.instance = this;
    }
}
