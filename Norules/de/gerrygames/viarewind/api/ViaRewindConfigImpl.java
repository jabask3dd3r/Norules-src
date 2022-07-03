package de.gerrygames.viarewind.api;

import com.viaversion.viaversion.util.*;
import java.net.*;
import java.io.*;
import java.util.*;

public class ViaRewindConfigImpl extends Config implements ViaRewindConfig
{
    @Override
    public URL getDefaultConfigURL() {
        return this.getClass().getClassLoader().getResource("assets/viarewind/config.yml");
    }
    
    @Override
    public boolean isReplaceParticles() {
        return this.getBoolean("replace-particles", false);
    }
    
    @Override
    public CooldownIndicator getCooldownIndicator() {
        return CooldownIndicator.valueOf(this.getString("cooldown-indicator", "TITLE").toUpperCase());
    }
    
    public ViaRewindConfigImpl(final File lllllllllllllIlllIlIIIIlIIlIlllI) {
        super(lllllllllllllIlllIlIIIIlIIlIlllI);
        this.reloadConfig();
    }
    
    @Override
    protected void handleConfig(final Map<String, Object> lllllllllllllIlllIlIIIIlIIIllllI) {
    }
    
    @Override
    public List<String> getUnsupportedOptions() {
        return Collections.emptyList();
    }
    
    @Override
    public boolean isReplaceAdventureMode() {
        return this.getBoolean("replace-adventure", false);
    }
}
