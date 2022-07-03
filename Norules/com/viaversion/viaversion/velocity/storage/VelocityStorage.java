package com.viaversion.viaversion.velocity.storage;

import com.viaversion.viaversion.api.connection.*;
import com.velocitypowered.api.proxy.*;
import java.util.*;
import com.viaversion.viaversion.util.*;
import java.lang.reflect.*;

public class VelocityStorage implements StorableObject
{
    private static /* synthetic */ Method getMinecraftConnection;
    private static /* synthetic */ Class<?> clientPlaySessionHandler;
    private static /* synthetic */ Method getServerBossBars;
    private final /* synthetic */ Player player;
    private /* synthetic */ String currentServer;
    private /* synthetic */ List<UUID> cachedBossbar;
    
    public VelocityStorage(final Player lllllllllllllllIIIIllIlIlIIlllIl) {
        this.player = lllllllllllllllIIIIllIlIlIIlllIl;
        this.currentServer = "";
    }
    
    public void setCurrentServer(final String lllllllllllllllIIIIllIlIlIIIIlll) {
        this.currentServer = lllllllllllllllIIIIllIlIlIIIIlll;
    }
    
    public List<UUID> getCachedBossbar() {
        return this.cachedBossbar;
    }
    
    @Override
    public boolean equals(final Object lllllllllllllllIIIIllIlIIllllIlI) {
        if (this == lllllllllllllllIIIIllIlIIllllIlI) {
            return true;
        }
        if (lllllllllllllllIIIIllIlIIllllIlI == null || this.getClass() != lllllllllllllllIIIIllIlIIllllIlI.getClass()) {
            return false;
        }
        final VelocityStorage lllllllllllllllIIIIllIlIIlllllII = (VelocityStorage)lllllllllllllllIIIIllIlIIllllIlI;
        return Objects.equals(this.player, lllllllllllllllIIIIllIlIIlllllII.player) && Objects.equals(this.currentServer, lllllllllllllllIIIIllIlIIlllllII.currentServer) && Objects.equals(this.cachedBossbar, lllllllllllllllIIIIllIlIIlllllII.cachedBossbar);
    }
    
    static {
        try {
            VelocityStorage.clientPlaySessionHandler = Class.forName("com.velocitypowered.proxy.connection.client.ClientPlaySessionHandler");
            VelocityStorage.getServerBossBars = VelocityStorage.clientPlaySessionHandler.getDeclaredMethod("getServerBossBars", (Class<?>[])new Class[0]);
            VelocityStorage.getMinecraftConnection = Class.forName("com.velocitypowered.proxy.connection.client.ConnectedPlayer").getDeclaredMethod("getMinecraftConnection", (Class<?>[])new Class[0]);
        }
        catch (NoSuchMethodException | ClassNotFoundException ex2) {
            final ReflectiveOperationException ex;
            final ReflectiveOperationException lllllllllllllllIIIIllIlIIlllIIIl = ex;
            lllllllllllllllIIIIllIlIIlllIIIl.printStackTrace();
        }
    }
    
    @Override
    public int hashCode() {
        int lllllllllllllllIIIIllIlIIlllIlIl = (this.player != null) ? this.player.hashCode() : 0;
        lllllllllllllllIIIIllIlIIlllIlIl = 31 * lllllllllllllllIIIIllIlIIlllIlIl + ((this.currentServer != null) ? this.currentServer.hashCode() : 0);
        lllllllllllllllIIIIllIlIIlllIlIl = 31 * lllllllllllllllIIIIllIlIIlllIlIl + ((this.cachedBossbar != null) ? this.cachedBossbar.hashCode() : 0);
        return lllllllllllllllIIIIllIlIIlllIlIl;
    }
    
    public List<UUID> getBossbar() {
        if (this.cachedBossbar == null) {
            if (VelocityStorage.clientPlaySessionHandler == null) {
                return null;
            }
            if (VelocityStorage.getServerBossBars == null) {
                return null;
            }
            if (VelocityStorage.getMinecraftConnection == null) {
                return null;
            }
            try {
                final Object lllllllllllllllIIIIllIlIlIIlIlll = VelocityStorage.getMinecraftConnection.invoke(this.player, new Object[0]);
                final Object lllllllllllllllIIIIllIlIlIIlIllI = ReflectionUtil.invoke(lllllllllllllllIIIIllIlIlIIlIlll, "getSessionHandler");
                if (VelocityStorage.clientPlaySessionHandler.isInstance(lllllllllllllllIIIIllIlIlIIlIllI)) {
                    this.cachedBossbar = (List<UUID>)VelocityStorage.getServerBossBars.invoke(lllllllllllllllIIIIllIlIlIIlIllI, new Object[0]);
                }
            }
            catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException ex2) {
                final ReflectiveOperationException ex;
                final ReflectiveOperationException lllllllllllllllIIIIllIlIlIIlIlIl = ex;
                lllllllllllllllIIIIllIlIlIIlIlIl.printStackTrace();
            }
        }
        return this.cachedBossbar;
    }
    
    public String getCurrentServer() {
        return this.currentServer;
    }
    
    public Player getPlayer() {
        return this.player;
    }
}
