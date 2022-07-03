package com.viaversion.viabackwards.listener;

import com.viaversion.viaversion.bukkit.listeners.*;
import com.viaversion.viabackwards.*;
import com.viaversion.viabackwards.protocol.protocol1_15_2to1_16.*;
import org.bukkit.plugin.*;
import com.viaversion.viaversion.api.protocol.*;
import org.bukkit.event.player.*;
import org.bukkit.event.block.*;
import org.bukkit.*;
import org.bukkit.block.*;
import org.bukkit.entity.*;
import org.bukkit.event.*;

public class FireExtinguishListener extends ViaBukkitListener
{
    public FireExtinguishListener(final BukkitPlugin lllllllllllllIllIIIlIIIllllIllIl) {
        super((Plugin)lllllllllllllIllIIIlIIIllllIllIl, Protocol1_15_2To1_16.class);
    }
    
    @EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
    public void onFireExtinguish(final PlayerInteractEvent lllllllllllllIllIIIlIIIlllIlllll) {
        if (lllllllllllllIllIIIlIIIlllIlllll.getAction() != Action.LEFT_CLICK_BLOCK) {
            return;
        }
        final Block lllllllllllllIllIIIlIIIllllIIIll = lllllllllllllIllIIIlIIIlllIlllll.getClickedBlock();
        if (lllllllllllllIllIIIlIIIllllIIIll == null) {
            return;
        }
        final Player lllllllllllllIllIIIlIIIllllIIIlI = lllllllllllllIllIIIlIIIlllIlllll.getPlayer();
        if (!this.isOnPipe(lllllllllllllIllIIIlIIIllllIIIlI)) {
            return;
        }
        final Block lllllllllllllIllIIIlIIIllllIIIIl = lllllllllllllIllIIIlIIIllllIIIll.getRelative(lllllllllllllIllIIIlIIIlllIlllll.getBlockFace());
        if (lllllllllllllIllIIIlIIIllllIIIIl.getType() == Material.FIRE) {
            lllllllllllllIllIIIlIIIlllIlllll.setCancelled(true);
            lllllllllllllIllIIIlIIIllllIIIIl.setType(Material.AIR);
        }
    }
}
