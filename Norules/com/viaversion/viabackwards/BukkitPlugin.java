package com.viaversion.viabackwards;

import org.bukkit.plugin.java.*;
import com.viaversion.viabackwards.api.*;
import com.viaversion.viaversion.api.*;
import com.viaversion.viaversion.*;
import com.viaversion.viaversion.bukkit.platform.*;
import com.viaversion.viaversion.api.protocol.version.*;
import com.viaversion.viabackwards.listener.*;
import org.bukkit.plugin.*;

public class BukkitPlugin extends JavaPlugin implements ViaBackwardsPlatform
{
    private void init() {
        this.init(this.getDataFolder());
        Via.getPlatform().runSync(this::onServerLoaded);
    }
    
    public void onLoad() {
        if (!ViaVersionPlugin.getInstance().isLateBind()) {
            this.init();
        }
    }
    
    private void onServerLoaded() {
        final BukkitViaLoader llllllllllllllllIlIllIlllIIIllll = (BukkitViaLoader)Via.getManager().getLoader();
        final int llllllllllllllllIlIllIlllIIIlllI = Via.getAPI().getServerVersion().highestSupportedVersion();
        if (llllllllllllllllIlIllIlllIIIlllI >= ProtocolVersion.v1_16.getVersion()) {
            llllllllllllllllIlIllIlllIIIllll.storeListener(new FireExtinguishListener(this)).register();
        }
        if (llllllllllllllllIlIllIlllIIIlllI >= ProtocolVersion.v1_14.getVersion()) {
            llllllllllllllllIlIllIlllIIIllll.storeListener(new LecternInteractListener(this)).register();
        }
        if (llllllllllllllllIlIllIlllIIIlllI >= ProtocolVersion.v1_12.getVersion()) {
            llllllllllllllllIlIllIlllIIIllll.storeListener(new FireDamageListener(this)).register();
        }
    }
    
    public void onEnable() {
        if (ViaVersionPlugin.getInstance().isLateBind()) {
            this.init();
        }
    }
    
    public void disable() {
        this.getPluginLoader().disablePlugin((Plugin)this);
    }
}
