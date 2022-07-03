package com.viaversion.viaversion.bukkit.listeners;

import com.viaversion.viaversion.*;
import org.bukkit.event.*;
import org.bukkit.plugin.*;
import org.bukkit.entity.*;
import com.viaversion.viaversion.api.connection.*;
import com.viaversion.viaversion.api.protocol.*;

public class ViaBukkitListener extends ViaListener implements Listener
{
    private final /* synthetic */ Plugin plugin;
    
    protected boolean isOnPipe(final Player lllllllllllllIIlllIIIllllIlIIlII) {
        return this.isOnPipe(lllllllllllllIIlllIIIllllIlIIlII.getUniqueId());
    }
    
    public Plugin getPlugin() {
        return this.plugin;
    }
    
    protected UserConnection getUserConnection(final Player lllllllllllllIIlllIIIllllIlIlIlI) {
        return this.getUserConnection(lllllllllllllIIlllIIIllllIlIlIlI.getUniqueId());
    }
    
    public ViaBukkitListener(final Plugin lllllllllllllIIlllIIIllllIlIllll, final Class<? extends Protocol> lllllllllllllIIlllIIIllllIlIlllI) {
        super(lllllllllllllIIlllIIIllllIlIlllI);
        this.plugin = lllllllllllllIIlllIIIllllIlIllll;
    }
    
    @Override
    public void register() {
        if (this.isRegistered()) {
            return;
        }
        this.plugin.getServer().getPluginManager().registerEvents((Listener)this, this.plugin);
        this.setRegistered(true);
    }
}
