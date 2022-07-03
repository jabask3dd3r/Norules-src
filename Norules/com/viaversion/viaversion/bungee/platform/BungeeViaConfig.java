package com.viaversion.viaversion.bungee.platform;

import com.viaversion.viaversion.configuration.*;
import java.net.*;
import com.viaversion.viaversion.api.protocol.version.*;
import com.viaversion.viaversion.bungee.providers.*;
import java.util.*;
import java.io.*;

public class BungeeViaConfig extends AbstractViaConfig
{
    private /* synthetic */ Map<String, Integer> bungeeServerProtocols;
    private static final /* synthetic */ List<String> UNSUPPORTED;
    private /* synthetic */ int bungeePingInterval;
    private /* synthetic */ boolean bungeePingSave;
    
    @Override
    public URL getDefaultConfigURL() {
        return BungeeViaConfig.class.getClassLoader().getResource("assets/viaversion/config.yml");
    }
    
    @Override
    public List<String> getUnsupportedOptions() {
        return BungeeViaConfig.UNSUPPORTED;
    }
    
    public boolean isBungeePingSave() {
        return this.bungeePingSave;
    }
    
    @Override
    protected void handleConfig(final Map<String, Object> llllllllllllllIllIIllllIIlIIllll) {
        Map<String, Object> llllllllllllllIllIIllllIIlIlIIII = null;
        if (!(llllllllllllllIllIIllllIIlIIllll.get("bungee-servers") instanceof Map)) {
            final Map<String, Object> llllllllllllllIllIIllllIIlIlIlIl = new HashMap<String, Object>();
        }
        else {
            llllllllllllllIllIIllllIIlIlIIII = llllllllllllllIllIIllllIIlIIllll.get("bungee-servers");
        }
        for (final Map.Entry<String, Object> llllllllllllllIllIIllllIIlIlIIll : new HashSet(llllllllllllllIllIIllllIIlIlIIII.entrySet())) {
            if (!(llllllllllllllIllIIllllIIlIlIIll.getValue() instanceof Integer)) {
                if (llllllllllllllIllIIllllIIlIlIIll.getValue() instanceof String) {
                    final ProtocolVersion llllllllllllllIllIIllllIIlIlIlII = ProtocolVersion.getClosest(llllllllllllllIllIIllllIIlIlIIll.getValue());
                    if (llllllllllllllIllIIllllIIlIlIlII != null) {
                        llllllllllllllIllIIllllIIlIlIIII.put(llllllllllllllIllIIllllIIlIlIIll.getKey(), llllllllllllllIllIIllllIIlIlIlII.getVersion());
                    }
                    else {
                        llllllllllllllIllIIllllIIlIlIIII.remove(llllllllllllllIllIIllllIIlIlIIll.getKey());
                    }
                }
                else {
                    llllllllllllllIllIIllllIIlIlIIII.remove(llllllllllllllIllIIllllIIlIlIIll.getKey());
                }
            }
        }
        if (!llllllllllllllIllIIllllIIlIlIIII.containsKey("default")) {
            llllllllllllllIllIIllllIIlIlIIII.put("default", BungeeVersionProvider.getLowestSupportedVersion());
        }
        llllllllllllllIllIIllllIIlIIllll.put("bungee-servers", llllllllllllllIllIIllllIIlIlIIII);
    }
    
    @Override
    public boolean isNMSPlayerTicking() {
        return false;
    }
    
    static {
        UNSUPPORTED = Arrays.asList("nms-player-ticking", "item-cache", "anti-xray-patch", "quick-move-action-fix", "velocity-ping-interval", "velocity-ping-save", "velocity-servers", "blockconnection-method", "change-1_9-hitbox", "change-1_14-hitbox");
    }
    
    public int getBungeePingInterval() {
        return this.bungeePingInterval;
    }
    
    public Map<String, Integer> getBungeeServerProtocols() {
        return this.bungeeServerProtocols;
    }
    
    @Override
    protected void loadFields() {
        super.loadFields();
        this.bungeePingInterval = this.getInt("bungee-ping-interval", 60);
        this.bungeePingSave = this.getBoolean("bungee-ping-save", true);
        this.bungeeServerProtocols = this.get("bungee-servers", (Class<HashMap<String, Integer>>)Map.class, new HashMap<String, Integer>());
    }
    
    @Override
    public boolean isItemCache() {
        return false;
    }
    
    public BungeeViaConfig(final File llllllllllllllIllIIllllIIllIIIIl) {
        super(new File(llllllllllllllIllIIllllIIllIIIIl, "config.yml"));
        this.reloadConfig();
    }
}
