package com.viaversion.viaversion.bungee.storage;

import com.viaversion.viaversion.api.connection.*;
import java.lang.reflect.*;
import net.md_5.bungee.api.connection.*;
import java.util.*;

public class BungeeStorage implements StorableObject
{
    private static /* synthetic */ Field bossField;
    private /* synthetic */ String currentServer;
    private /* synthetic */ Set<UUID> bossbar;
    private final /* synthetic */ ProxiedPlayer player;
    
    public BungeeStorage(final ProxiedPlayer lllllllllllllIIIlIlIlIIIlllIIllI) {
        this.player = lllllllllllllIIIlIlIlIIIlllIIllI;
        this.currentServer = "";
        if (BungeeStorage.bossField != null) {
            try {
                this.bossbar = (Set<UUID>)BungeeStorage.bossField.get(lllllllllllllIIIlIlIlIIIlllIIllI);
            }
            catch (IllegalAccessException lllllllllllllIIIlIlIlIIIlllIlIII) {
                lllllllllllllIIIlIlIlIIIlllIlIII.printStackTrace();
            }
        }
    }
    
    public ProxiedPlayer getPlayer() {
        return this.player;
    }
    
    public Set<UUID> getBossbar() {
        return this.bossbar;
    }
    
    @Override
    public boolean equals(final Object lllllllllllllIIIlIlIlIIIllIIllll) {
        if (this == lllllllllllllIIIlIlIlIIIllIIllll) {
            return true;
        }
        if (lllllllllllllIIIlIlIlIIIllIIllll == null || this.getClass() != lllllllllllllIIIlIlIlIIIllIIllll.getClass()) {
            return false;
        }
        final BungeeStorage lllllllllllllIIIlIlIlIIIllIIlllI = (BungeeStorage)lllllllllllllIIIlIlIlIIIllIIllll;
        return Objects.equals(this.player, lllllllllllllIIIlIlIlIIIllIIlllI.player) && Objects.equals(this.currentServer, lllllllllllllIIIlIlIlIIIllIIlllI.currentServer) && Objects.equals(this.bossbar, lllllllllllllIIIlIlIlIIIllIIlllI.bossbar);
    }
    
    public void setCurrentServer(final String lllllllllllllIIIlIlIlIIIllIllIIl) {
        this.currentServer = lllllllllllllIIIlIlIlIIIllIllIIl;
    }
    
    @Override
    public int hashCode() {
        int lllllllllllllIIIlIlIlIIIllIIIlll = (this.player != null) ? this.player.hashCode() : 0;
        lllllllllllllIIIlIlIlIIIllIIIlll = 31 * lllllllllllllIIIlIlIlIIIllIIIlll + ((this.currentServer != null) ? this.currentServer.hashCode() : 0);
        lllllllllllllIIIlIlIlIIIllIIIlll = 31 * lllllllllllllIIIlIlIlIIIllIIIlll + ((this.bossbar != null) ? this.bossbar.hashCode() : 0);
        return lllllllllllllIIIlIlIlIIIllIIIlll;
    }
    
    static {
        try {
            final Class<?> lllllllllllllIIIlIlIlIIIllIIIIll = Class.forName("net.md_5.bungee.UserConnection");
            (BungeeStorage.bossField = lllllllllllllIIIlIlIlIIIllIIIIll.getDeclaredField("sentBossBars")).setAccessible(true);
        }
        catch (ClassNotFoundException lllllllllllllIIIlIlIlIIIllIIIIlI) {}
        catch (NoSuchFieldException ex) {}
    }
    
    public String getCurrentServer() {
        return this.currentServer;
    }
}
