package com.viaversion.viaversion.velocity.platform;

import com.viaversion.viaversion.configuration.*;
import java.net.*;
import java.io.*;
import com.viaversion.viaversion.api.protocol.version.*;
import java.util.*;

public class VelocityViaConfig extends AbstractViaConfig
{
    private /* synthetic */ boolean velocityPingSave;
    private /* synthetic */ Map<String, Integer> velocityServerProtocols;
    private /* synthetic */ int velocityPingInterval;
    private static final /* synthetic */ List<String> UNSUPPORTED;
    
    @Override
    public boolean isNMSPlayerTicking() {
        return false;
    }
    
    public int getVelocityPingInterval() {
        return this.velocityPingInterval;
    }
    
    @Override
    public URL getDefaultConfigURL() {
        return this.getClass().getClassLoader().getResource("assets/viaversion/config.yml");
    }
    
    @Override
    protected void loadFields() {
        super.loadFields();
        this.velocityPingInterval = this.getInt("velocity-ping-interval", 60);
        this.velocityPingSave = this.getBoolean("velocity-ping-save", true);
        this.velocityServerProtocols = this.get("velocity-servers", (Class<HashMap<String, Integer>>)Map.class, new HashMap<String, Integer>());
    }
    
    @Override
    public boolean isItemCache() {
        return false;
    }
    
    public VelocityViaConfig(final File lllllllllllllIIIllIlllIIIlllllll) {
        super(new File(lllllllllllllIIIllIlllIIIlllllll, "config.yml"));
        this.reloadConfig();
    }
    
    public Map<String, Integer> getVelocityServerProtocols() {
        return this.velocityServerProtocols;
    }
    
    public boolean isVelocityPingSave() {
        return this.velocityPingSave;
    }
    
    @Override
    protected void handleConfig(final Map<String, Object> lllllllllllllIIIllIlllIIIllIlllI) {
        Map<String, Object> lllllllllllllIIIllIlllIIIllIllIl = null;
        if (!(lllllllllllllIIIllIlllIIIllIlllI.get("velocity-servers") instanceof Map)) {
            final Map<String, Object> lllllllllllllIIIllIlllIIIlllIIll = new HashMap<String, Object>();
        }
        else {
            lllllllllllllIIIllIlllIIIllIllIl = lllllllllllllIIIllIlllIIIllIlllI.get("velocity-servers");
        }
        for (final Map.Entry<String, Object> lllllllllllllIIIllIlllIIIlllIIIl : new HashSet<Map.Entry<String, Object>>(lllllllllllllIIIllIlllIIIllIllIl.entrySet())) {
            if (!(lllllllllllllIIIllIlllIIIlllIIIl.getValue() instanceof Integer)) {
                if (lllllllllllllIIIllIlllIIIlllIIIl.getValue() instanceof String) {
                    final ProtocolVersion lllllllllllllIIIllIlllIIIlllIIlI = ProtocolVersion.getClosest(lllllllllllllIIIllIlllIIIlllIIIl.getValue());
                    if (lllllllllllllIIIllIlllIIIlllIIlI != null) {
                        lllllllllllllIIIllIlllIIIllIllIl.put(lllllllllllllIIIllIlllIIIlllIIIl.getKey(), lllllllllllllIIIllIlllIIIlllIIlI.getVersion());
                    }
                    else {
                        lllllllllllllIIIllIlllIIIllIllIl.remove(lllllllllllllIIIllIlllIIIlllIIIl.getKey());
                    }
                }
                else {
                    lllllllllllllIIIllIlllIIIllIllIl.remove(lllllllllllllIIIllIlllIIIlllIIIl.getKey());
                }
            }
        }
        if (!lllllllllllllIIIllIlllIIIllIllIl.containsKey("default")) {
            try {
                lllllllllllllIIIllIlllIIIllIllIl.put("default", VelocityViaInjector.getLowestSupportedProtocolVersion());
            }
            catch (Exception lllllllllllllIIIllIlllIIIlllIIII) {
                lllllllllllllIIIllIlllIIIlllIIII.printStackTrace();
            }
        }
        lllllllllllllIIIllIlllIIIllIlllI.put("velocity-servers", lllllllllllllIIIllIlllIIIllIllIl);
    }
    
    static {
        UNSUPPORTED = Arrays.asList("nms-player-ticking", "item-cache", "anti-xray-patch", "quick-move-action-fix", "bungee-ping-interval", "bungee-ping-save", "bungee-servers", "blockconnection-method", "change-1_9-hitbox", "change-1_14-hitbox");
    }
    
    @Override
    public List<String> getUnsupportedOptions() {
        return VelocityViaConfig.UNSUPPORTED;
    }
}
