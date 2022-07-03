package com.viaversion.viabackwards;

import com.viaversion.viaversion.util.*;
import java.net.*;
import java.io.*;
import java.util.*;

public class ViaBackwardsConfig extends Config implements com.viaversion.viabackwards.api.ViaBackwardsConfig
{
    private /* synthetic */ boolean handlePingsAsInvAcknowledgements;
    private /* synthetic */ boolean alwaysShowOriginalMobName;
    private /* synthetic */ boolean addTeamColorToPrefix;
    private /* synthetic */ boolean addCustomEnchantsToLore;
    private /* synthetic */ boolean fix1_13FacePlayer;
    
    @Override
    public URL getDefaultConfigURL() {
        return this.getClass().getClassLoader().getResource("assets/viabackwards/config.yml");
    }
    
    public ViaBackwardsConfig(final File llIllIlIlll) {
        super(llIllIlIlll);
    }
    
    @Override
    public boolean addCustomEnchantsToLore() {
        return this.addCustomEnchantsToLore;
    }
    
    @Override
    public boolean handlePingsAsInvAcknowledgements() {
        return this.handlePingsAsInvAcknowledgements || Boolean.getBoolean("com.viaversion.handlePingsAsInvAcknowledgements");
    }
    
    @Override
    public boolean alwaysShowOriginalMobName() {
        return this.alwaysShowOriginalMobName;
    }
    
    @Override
    public void reloadConfig() {
        super.reloadConfig();
        this.loadFields();
    }
    
    @Override
    public boolean addTeamColorTo1_13Prefix() {
        return this.addTeamColorToPrefix;
    }
    
    @Override
    public boolean isFix1_13FacePlayer() {
        return this.fix1_13FacePlayer;
    }
    
    private void loadFields() {
        this.addCustomEnchantsToLore = this.getBoolean("add-custom-enchants-into-lore", true);
        this.addTeamColorToPrefix = this.getBoolean("add-teamcolor-to-prefix", true);
        this.fix1_13FacePlayer = this.getBoolean("fix-1_13-face-player", false);
        this.alwaysShowOriginalMobName = this.getBoolean("always-show-original-mob-name", true);
        this.handlePingsAsInvAcknowledgements = this.getBoolean("handle-pings-as-inv-acknowledgements", false);
    }
    
    @Override
    public List<String> getUnsupportedOptions() {
        return Collections.emptyList();
    }
    
    @Override
    protected void handleConfig(final Map<String, Object> llIlIllllIl) {
    }
}
