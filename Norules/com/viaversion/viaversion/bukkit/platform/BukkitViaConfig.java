package com.viaversion.viaversion.bukkit.platform;

import com.viaversion.viaversion.configuration.*;
import java.net.*;
import org.bukkit.plugin.*;
import com.viaversion.viaversion.api.*;
import java.io.*;
import java.util.*;

public class BukkitViaConfig extends AbstractViaConfig
{
    private /* synthetic */ boolean antiXRay;
    private static final /* synthetic */ List<String> UNSUPPORTED;
    private /* synthetic */ boolean hitboxFix1_9;
    private /* synthetic */ boolean hitboxFix1_14;
    private /* synthetic */ String blockConnectionMethod;
    private /* synthetic */ boolean quickMoveActionFix;
    
    static {
        UNSUPPORTED = Arrays.asList("bungee-ping-interval", "bungee-ping-save", "bungee-servers", "velocity-ping-interval", "velocity-ping-save", "velocity-servers");
    }
    
    @Override
    public boolean is1_9HitboxFix() {
        return this.hitboxFix1_9;
    }
    
    @Override
    protected void loadFields() {
        super.loadFields();
        this.antiXRay = this.getBoolean("anti-xray-patch", true);
        this.quickMoveActionFix = this.getBoolean("quick-move-action-fix", false);
        this.hitboxFix1_9 = this.getBoolean("change-1_9-hitbox", false);
        this.hitboxFix1_14 = this.getBoolean("change-1_14-hitbox", false);
        this.blockConnectionMethod = this.getString("blockconnection-method", "packet");
    }
    
    @Override
    public boolean is1_12QuickMoveActionFix() {
        return this.quickMoveActionFix;
    }
    
    @Override
    public URL getDefaultConfigURL() {
        return BukkitViaConfig.class.getClassLoader().getResource("assets/viaversion/config.yml");
    }
    
    @Override
    public String getBlockConnectionMethod() {
        return this.blockConnectionMethod;
    }
    
    @Override
    public List<String> getUnsupportedOptions() {
        return BukkitViaConfig.UNSUPPORTED;
    }
    
    public BukkitViaConfig() {
        super(new File(((Plugin)Via.getPlatform()).getDataFolder(), "config.yml"));
        this.reloadConfig();
    }
    
    @Override
    public boolean isAntiXRay() {
        return this.antiXRay;
    }
    
    @Override
    public boolean is1_14HitboxFix() {
        return this.hitboxFix1_14;
    }
    
    @Override
    protected void handleConfig(final Map<String, Object> lllllllllllllIIIlIIIIIIIlIIllIll) {
    }
}
