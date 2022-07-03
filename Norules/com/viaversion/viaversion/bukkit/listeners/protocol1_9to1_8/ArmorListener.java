package com.viaversion.viaversion.bukkit.listeners.protocol1_9to1_8;

import com.viaversion.viaversion.bukkit.listeners.*;
import java.util.*;
import org.bukkit.event.*;
import org.bukkit.event.inventory.*;
import org.bukkit.entity.*;
import com.viaversion.viaversion.api.protocol.packet.*;
import io.netty.buffer.*;
import com.viaversion.viaversion.api.type.*;
import com.viaversion.viaversion.protocols.protocol1_9to1_8.*;
import com.viaversion.viaversion.api.protocol.*;
import org.bukkit.inventory.*;
import org.bukkit.plugin.*;
import org.bukkit.event.player.*;
import org.bukkit.event.block.*;
import org.bukkit.*;
import com.viaversion.viaversion.api.*;

public class ArmorListener extends ViaBukkitListener
{
    private static final /* synthetic */ UUID ARMOR_ATTRIBUTE;
    
    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void onRespawn(final PlayerRespawnEvent lllllllllllllllIIlllIllIIlIllIlI) {
        this.sendDelayedArmorUpdate(lllllllllllllllIIlllIllIIlIllIlI.getPlayer());
    }
    
    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void onInventoryClick(final InventoryClickEvent lllllllllllllllIIlllIllIIlllIlIl) {
        final HumanEntity lllllllllllllllIIlllIllIIlllIlll = lllllllllllllllIIlllIllIIlllIlIl.getWhoClicked();
        if (lllllllllllllllIIlllIllIIlllIlll instanceof Player && lllllllllllllllIIlllIllIIlllIlIl.getInventory() instanceof CraftingInventory) {
            final Player lllllllllllllllIIlllIllIIllllIlI = (Player)lllllllllllllllIIlllIllIIlllIlll;
            if (lllllllllllllllIIlllIllIIlllIlIl.getCurrentItem() != null && ArmorType.isArmor(lllllllllllllllIIlllIllIIlllIlIl.getCurrentItem().getTypeId())) {
                this.sendDelayedArmorUpdate(lllllllllllllllIIlllIllIIllllIlI);
                return;
            }
            if (lllllllllllllllIIlllIllIIlllIlIl.getRawSlot() >= 5 && lllllllllllllllIIlllIllIIlllIlIl.getRawSlot() <= 8) {
                this.sendDelayedArmorUpdate(lllllllllllllllIIlllIllIIllllIlI);
            }
        }
    }
    
    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void onItemBreak(final PlayerItemBreakEvent lllllllllllllllIIlllIllIIllIIlII) {
        this.sendDelayedArmorUpdate(lllllllllllllllIIlllIllIIllIIlII.getPlayer());
    }
    
    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void onJoin(final PlayerJoinEvent lllllllllllllllIIlllIllIIllIIIII) {
        this.sendDelayedArmorUpdate(lllllllllllllllIIlllIllIIllIIIII.getPlayer());
    }
    
    static {
        ARMOR_ATTRIBUTE = UUID.fromString("2AD3F246-FEE1-4E67-B886-69FD380BB150");
    }
    
    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void onWorldChange(final PlayerChangedWorldEvent lllllllllllllllIIlllIllIIlIlIIlI) {
        this.sendArmorUpdate(lllllllllllllllIIlllIllIIlIlIIlI.getPlayer());
    }
    
    public void sendArmorUpdate(final Player lllllllllllllllIIlllIllIlIIIIlII) {
        if (!this.isOnPipe(lllllllllllllllIIlllIllIlIIIIlII)) {
            return;
        }
        int lllllllllllllllIIlllIllIlIIIIlll = 0;
        final ItemStack[] armorContents = lllllllllllllllIIlllIllIlIIIIlII.getInventory().getArmorContents();
        final int length = armorContents.length;
        for (long lllllllllllllllIIlllIllIlIIIIIII = 0; lllllllllllllllIIlllIllIlIIIIIII < length; ++lllllllllllllllIIlllIllIlIIIIIII) {
            final ItemStack lllllllllllllllIIlllIllIlIIIlIll = armorContents[lllllllllllllllIIlllIllIlIIIIIII];
            lllllllllllllllIIlllIllIlIIIIlll += ArmorType.findById(lllllllllllllllIIlllIllIlIIIlIll.getTypeId()).getArmorPoints();
        }
        final PacketWrapper lllllllllllllllIIlllIllIlIIIIllI = PacketWrapper.create(ClientboundPackets1_9.ENTITY_PROPERTIES, null, this.getUserConnection(lllllllllllllllIIlllIllIlIIIIlII));
        try {
            lllllllllllllllIIlllIllIlIIIIllI.write(Type.VAR_INT, lllllllllllllllIIlllIllIlIIIIlII.getEntityId());
            lllllllllllllllIIlllIllIlIIIIllI.write(Type.INT, 1);
            lllllllllllllllIIlllIllIlIIIIllI.write(Type.STRING, "generic.armor");
            lllllllllllllllIIlllIllIlIIIIllI.write(Type.DOUBLE, 0.0);
            lllllllllllllllIIlllIllIlIIIIllI.write(Type.VAR_INT, 1);
            lllllllllllllllIIlllIllIlIIIIllI.write(Type.UUID, ArmorListener.ARMOR_ATTRIBUTE);
            lllllllllllllllIIlllIllIlIIIIllI.write(Type.DOUBLE, (double)lllllllllllllllIIlllIllIlIIIIlll);
            lllllllllllllllIIlllIllIlIIIIllI.write(Type.BYTE, (Byte)0);
            lllllllllllllllIIlllIllIlIIIIllI.scheduleSend(Protocol1_9To1_8.class);
        }
        catch (Exception lllllllllllllllIIlllIllIlIIIlIlI) {
            lllllllllllllllIIlllIllIlIIIlIlI.printStackTrace();
        }
    }
    
    public ArmorListener(final Plugin lllllllllllllllIIlllIllIlIIlIlIl) {
        super(lllllllllllllllIIlllIllIlIIlIlIl, Protocol1_9To1_8.class);
    }
    
    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void onInteract(final PlayerInteractEvent lllllllllllllllIIlllIllIIllIlIll) {
        if (lllllllllllllllIIlllIllIIllIlIll.getItem() != null && (lllllllllllllllIIlllIllIIllIlIll.getAction() == Action.RIGHT_CLICK_AIR || lllllllllllllllIIlllIllIIllIlIll.getAction() == Action.RIGHT_CLICK_BLOCK)) {
            final Player lllllllllllllllIIlllIllIIllIllll = lllllllllllllllIIlllIllIIllIlIll.getPlayer();
            Bukkit.getScheduler().scheduleSyncDelayedTask(this.getPlugin(), () -> this.sendArmorUpdate(lllllllllllllllIIlllIllIIllIllll), 3L);
        }
    }
    
    public void sendDelayedArmorUpdate(final Player lllllllllllllllIIlllIllIIlIIllII) {
        if (!this.isOnPipe(lllllllllllllllIIlllIllIIlIIllII)) {
            return;
        }
        Via.getPlatform().runSync(() -> this.sendArmorUpdate(lllllllllllllllIIlllIllIIlIIllII));
    }
}
