package com.viaversion.viaversion.sponge.platform;

import com.viaversion.viaversion.configuration.*;
import org.spongepowered.api.plugin.*;
import java.io.*;
import java.net.*;
import org.spongepowered.api.asset.*;
import java.util.*;

public class SpongeViaConfig extends AbstractViaConfig
{
    private final /* synthetic */ PluginContainer pluginContainer;
    private static final /* synthetic */ List<String> UNSUPPORTED;
    
    static {
        UNSUPPORTED = Arrays.asList("anti-xray-patch", "bungee-ping-interval", "bungee-ping-save", "bungee-servers", "velocity-ping-interval", "velocity-ping-save", "velocity-servers", "quick-move-action-fix", "change-1_9-hitbox", "change-1_14-hitbox", "blockconnection-method");
    }
    
    public SpongeViaConfig(final PluginContainer lllllllllllllIIlIIlIlllIlIlIIlIl, final File lllllllllllllIIlIIlIlllIlIlIIIIl) {
        super(new File(lllllllllllllIIlIIlIlllIlIlIIIIl, "config.yml"));
        this.pluginContainer = lllllllllllllIIlIIlIlllIlIlIIlIl;
        this.reloadConfig();
    }
    
    @Override
    public List<String> getUnsupportedOptions() {
        return SpongeViaConfig.UNSUPPORTED;
    }
    
    @Override
    protected void handleConfig(final Map<String, Object> lllllllllllllIIlIIlIlllIlIIllIIl) {
    }
    
    @Override
    public URL getDefaultConfigURL() {
        final Optional<Asset> lllllllllllllIIlIIlIlllIlIIlllIl = (Optional<Asset>)this.pluginContainer.getAsset("config.yml");
        if (!lllllllllllllIIlIIlIlllIlIIlllIl.isPresent()) {
            throw new IllegalArgumentException("Default config is missing from jar");
        }
        return lllllllllllllIIlIIlIlllIlIIlllIl.get().getUrl();
    }
}
