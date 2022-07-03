package com.viaversion.viaversion.velocity.service;

import com.viaversion.viaversion.velocity.platform.*;
import com.viaversion.viaversion.api.*;
import com.velocitypowered.api.proxy.server.*;
import com.viaversion.viaversion.api.protocol.version.*;
import java.util.concurrent.*;
import java.util.*;
import com.viaversion.viaversion.*;

public class ProtocolDetectorService implements Runnable
{
    private static /* synthetic */ ProtocolDetectorService instance;
    private static final /* synthetic */ Map<String, Integer> detectedProtocolIds;
    
    public static ProtocolDetectorService getInstance() {
        return ProtocolDetectorService.instance;
    }
    
    public ProtocolDetectorService() {
        ProtocolDetectorService.instance = this;
    }
    
    public static void probeServer(final RegisteredServer lllllllllllllllIlIlIIllllIIlllIl) {
        final String lllllllllllllllIlIlIIllllIIlllII = lllllllllllllllIlIlIIllllIIlllIl.getServerInfo().getName();
        final String s;
        Map<String, Integer> lllllllllllllllIlIlIIllllIIlIIll;
        Integer lllllllllllllllIlIlIIllllIIlIIlI;
        lllllllllllllllIlIlIIllllIIlllIl.ping().thenAccept(lllllllllllllllIlIlIIllllIIlIIII -> {
            if (lllllllllllllllIlIlIIllllIIlIIII != null && lllllllllllllllIlIlIIllllIIlIIII.getVersion() != null) {
                ProtocolDetectorService.detectedProtocolIds.put(s, lllllllllllllllIlIlIIllllIIlIIII.getVersion().getProtocol());
                if (((VelocityViaConfig)Via.getConfig()).isVelocityPingSave()) {
                    lllllllllllllllIlIlIIllllIIlIIll = ((VelocityViaConfig)Via.getConfig()).getVelocityServerProtocols();
                    lllllllllllllllIlIlIIllllIIlIIlI = lllllllllllllllIlIlIIllllIIlIIll.get(s);
                    if (lllllllllllllllIlIlIIllllIIlIIlI == null || lllllllllllllllIlIlIIllllIIlIIlI != lllllllllllllllIlIlIIllllIIlIIII.getVersion().getProtocol()) {
                        synchronized (Via.getPlatform().getConfigurationProvider()) {
                            lllllllllllllllIlIlIIllllIIlIIll.put(s, lllllllllllllllIlIlIIllllIIlIIII.getVersion().getProtocol());
                        }
                        Via.getPlatform().getConfigurationProvider().saveConfig();
                    }
                }
            }
        });
    }
    
    public static Integer getProtocolId(final String lllllllllllllllIlIlIIllllIllIIII) {
        final Map<String, Integer> lllllllllllllllIlIlIIllllIlIllll = ((VelocityViaConfig)Via.getConfig()).getVelocityServerProtocols();
        final Integer lllllllllllllllIlIlIIllllIlIlllI = lllllllllllllllIlIlIIllllIlIllll.get(lllllllllllllllIlIlIIllllIllIIII);
        if (lllllllllllllllIlIlIIllllIlIlllI != null) {
            return lllllllllllllllIlIlIIllllIlIlllI;
        }
        final Integer lllllllllllllllIlIlIIllllIlIllIl = ProtocolDetectorService.detectedProtocolIds.get(lllllllllllllllIlIlIIllllIllIIII);
        if (lllllllllllllllIlIlIIllllIlIllIl != null) {
            return lllllllllllllllIlIlIIllllIlIllIl;
        }
        final Integer lllllllllllllllIlIlIIllllIlIllII = lllllllllllllllIlIlIIllllIlIllll.get("default");
        if (lllllllllllllllIlIlIIllllIlIllII != null) {
            return lllllllllllllllIlIlIIllllIlIllII;
        }
        try {
            return ProtocolVersion.getProtocol(Via.getManager().getInjector().getServerProtocolVersion()).getVersion();
        }
        catch (Exception lllllllllllllllIlIlIIllllIllIIIl) {
            lllllllllllllllIlIlIIllllIllIIIl.printStackTrace();
            return ProtocolVersion.v1_8.getVersion();
        }
    }
    
    static {
        detectedProtocolIds = new ConcurrentHashMap<String, Integer>();
    }
    
    public static Map<String, Integer> getDetectedIds() {
        return new HashMap<String, Integer>(ProtocolDetectorService.detectedProtocolIds);
    }
    
    @Override
    public void run() {
        for (final RegisteredServer lllllllllllllllIlIlIIllllIlIIIll : VelocityPlugin.PROXY.getAllServers()) {
            probeServer(lllllllllllllllIlIlIIllllIlIIIll);
        }
    }
}
