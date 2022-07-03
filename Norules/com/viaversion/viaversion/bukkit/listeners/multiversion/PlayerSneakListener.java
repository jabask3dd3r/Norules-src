package com.viaversion.viaversion.bukkit.listeners.multiversion;

import com.viaversion.viaversion.bukkit.listeners.*;
import org.bukkit.event.*;
import java.lang.reflect.*;
import org.bukkit.event.entity.*;
import org.bukkit.entity.*;
import com.viaversion.viaversion.*;
import org.bukkit.plugin.*;
import com.viaversion.viaversion.api.protocol.*;
import com.viaversion.viaversion.api.*;
import com.viaversion.viaversion.api.protocol.version.*;
import java.util.*;
import org.bukkit.event.player.*;
import com.viaversion.viaversion.api.connection.*;

public class PlayerSneakListener extends ViaBukkitListener
{
    private /* synthetic */ Method setSize;
    private final /* synthetic */ Method getHandle;
    private /* synthetic */ boolean useCache;
    private final /* synthetic */ boolean is1_9Fix;
    private final /* synthetic */ boolean is1_14Fix;
    private /* synthetic */ Map<Player, Boolean> sneaking;
    private /* synthetic */ Set<UUID> sneakingUuids;
    
    @EventHandler
    public void playerQuit(final PlayerQuitEvent lllllllllllllIllllIIlIllIIIIIlIl) {
        if (this.sneaking != null) {
            this.sneaking.remove(lllllllllllllIllllIIlIllIIIIIlIl.getPlayer());
        }
        if (this.sneakingUuids != null) {
            this.sneakingUuids.remove(lllllllllllllIllllIIlIllIIIIIlIl.getPlayer().getUniqueId());
        }
    }
    
    private void setHeight(final Player lllllllllllllIllllIIlIlIllllllII, final float lllllllllllllIllllIIlIlIlllllIll) {
        try {
            this.setSize.invoke(this.getHandle.invoke(lllllllllllllIllllIIlIlIllllllII, new Object[0]), 0.6f, lllllllllllllIllllIIlIlIlllllIll);
        }
        catch (IllegalAccessException | InvocationTargetException ex2) {
            final ReflectiveOperationException ex;
            final ReflectiveOperationException lllllllllllllIllllIIlIlIlllllllI = ex;
            lllllllllllllIllllIIlIlIlllllllI.printStackTrace();
        }
    }
    
    @EventHandler(ignoreCancelled = true)
    public void playerDamage(final EntityDamageEvent lllllllllllllIllllIIlIllIIIIlIll) {
        if (!this.is1_14Fix) {
            return;
        }
        if (lllllllllllllIllllIIlIllIIIIlIll.getCause() != EntityDamageEvent.DamageCause.SUFFOCATION) {
            return;
        }
        if (lllllllllllllIllllIIlIllIIIIlIll.getEntityType() != EntityType.PLAYER) {
            return;
        }
        final Player lllllllllllllIllllIIlIllIIIIlllI = (Player)lllllllllllllIllllIIlIllIIIIlIll.getEntity();
        if (!this.sneakingUuids.contains(lllllllllllllIllllIIlIllIIIIlllI.getUniqueId())) {
            return;
        }
        double lllllllllllllIllllIIlIllIIIIllIl = lllllllllllllIllllIIlIllIIIIlllI.getEyeLocation().getY() + 0.045;
        lllllllllllllIllllIIlIllIIIIllIl -= (int)lllllllllllllIllllIIlIllIIIIllIl;
        if (lllllllllllllIllllIIlIllIIIIllIl < 0.09) {
            lllllllllllllIllllIIlIllIIIIlIll.setCancelled(true);
        }
    }
    
    public PlayerSneakListener(final ViaVersionPlugin lllllllllllllIllllIIlIllIIllIIlI, final boolean lllllllllllllIllllIIlIllIIlIlIll, final boolean lllllllllllllIllllIIlIllIIlIlIlI) throws ReflectiveOperationException {
        super((Plugin)lllllllllllllIllllIIlIllIIllIIlI, null);
        this.is1_9Fix = lllllllllllllIllllIIlIllIIlIlIll;
        this.is1_14Fix = lllllllllllllIllllIIlIllIIlIlIlI;
        final String lllllllllllllIllllIIlIllIIlIllll = lllllllllllllIllllIIlIllIIllIIlI.getServer().getClass().getPackage().getName();
        this.getHandle = Class.forName(String.valueOf(new StringBuilder().append(lllllllllllllIllllIIlIllIIlIllll).append(".entity.CraftPlayer"))).getMethod("getHandle", (Class<?>[])new Class[0]);
        final Class<?> lllllllllllllIllllIIlIllIIlIlllI = Class.forName(String.valueOf(new StringBuilder().append(lllllllllllllIllllIIlIllIIlIllll.replace("org.bukkit.craftbukkit", "net.minecraft.server")).append(".EntityPlayer")));
        try {
            this.setSize = lllllllllllllIllllIIlIllIIlIlllI.getMethod("setSize", Float.TYPE, Float.TYPE);
        }
        catch (NoSuchMethodException lllllllllllllIllllIIlIllIIllIlII) {
            this.setSize = lllllllllllllIllllIIlIllIIlIlllI.getMethod("a", Float.TYPE, Float.TYPE);
        }
        if (Via.getAPI().getServerVersion().lowestSupportedVersion() >= ProtocolVersion.v1_9.getVersion()) {
            this.sneaking = new WeakHashMap<Player, Boolean>();
            this.useCache = true;
            lllllllllllllIllllIIlIllIIllIIlI.getServer().getScheduler().runTaskTimer((Plugin)lllllllllllllIllllIIlIllIIllIIlI, (Runnable)new Runnable() {
                @Override
                public void run() {
                    for (final Map.Entry<Player, Boolean> lllllllllllllllllIIIIIIIIlIlIlIl : PlayerSneakListener.this.sneaking.entrySet()) {
                        PlayerSneakListener.this.setHeight(lllllllllllllllllIIIIIIIIlIlIlIl.getKey(), ((boolean)lllllllllllllllllIIIIIIIIlIlIlIl.getValue()) ? 1.5f : 1.6f);
                    }
                }
            }, 1L, 1L);
        }
        if (lllllllllllllIllllIIlIllIIlIlIlI) {
            this.sneakingUuids = new HashSet<UUID>();
        }
    }
    
    @EventHandler(ignoreCancelled = true)
    public void playerToggleSneak(final PlayerToggleSneakEvent lllllllllllllIllllIIlIllIIIllIIl) {
        final Player lllllllllllllIllllIIlIllIIIllllI = lllllllllllllIllllIIlIllIIIllIIl.getPlayer();
        final UserConnection lllllllllllllIllllIIlIllIIIlllIl = this.getUserConnection(lllllllllllllIllllIIlIllIIIllllI);
        if (lllllllllllllIllllIIlIllIIIlllIl == null) {
            return;
        }
        final ProtocolInfo lllllllllllllIllllIIlIllIIIlllII = lllllllllllllIllllIIlIllIIIlllIl.getProtocolInfo();
        if (lllllllllllllIllllIIlIllIIIlllII == null) {
            return;
        }
        final int lllllllllllllIllllIIlIllIIIllIll = lllllllllllllIllllIIlIllIIIlllII.getProtocolVersion();
        if (this.is1_14Fix && lllllllllllllIllllIIlIllIIIllIll >= ProtocolVersion.v1_14.getVersion()) {
            this.setHeight(lllllllllllllIllllIIlIllIIIllllI, lllllllllllllIllllIIlIllIIIllIIl.isSneaking() ? 1.5f : 1.8f);
            if (lllllllllllllIllllIIlIllIIIllIIl.isSneaking()) {
                this.sneakingUuids.add(lllllllllllllIllllIIlIllIIIllllI.getUniqueId());
            }
            else {
                this.sneakingUuids.remove(lllllllllllllIllllIIlIllIIIllllI.getUniqueId());
            }
            if (!this.useCache) {
                return;
            }
            if (lllllllllllllIllllIIlIllIIIllIIl.isSneaking()) {
                this.sneaking.put(lllllllllllllIllllIIlIllIIIllllI, true);
            }
            else {
                this.sneaking.remove(lllllllllllllIllllIIlIllIIIllllI);
            }
        }
        else if (this.is1_9Fix && lllllllllllllIllllIIlIllIIIllIll >= ProtocolVersion.v1_9.getVersion()) {
            this.setHeight(lllllllllllllIllllIIlIllIIIllllI, lllllllllllllIllllIIlIllIIIllIIl.isSneaking() ? 1.6f : 1.8f);
            if (!this.useCache) {
                return;
            }
            if (lllllllllllllIllllIIlIllIIIllIIl.isSneaking()) {
                this.sneaking.put(lllllllllllllIllllIIlIllIIIllllI, false);
            }
            else {
                this.sneaking.remove(lllllllllllllIllllIIlIllIIIllllI);
            }
        }
    }
}
