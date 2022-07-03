package com.viaversion.viaversion.bukkit.listeners.protocol1_9to1_8;

import com.viaversion.viaversion.bukkit.listeners.*;
import org.bukkit.plugin.*;
import com.viaversion.viaversion.protocols.protocol1_9to1_8.*;
import com.viaversion.viaversion.api.protocol.*;
import org.bukkit.event.block.*;
import org.bukkit.*;
import org.bukkit.block.*;
import org.bukkit.event.*;

public class PaperPatch extends ViaBukkitListener
{
    public PaperPatch(final Plugin lllllllllllllllIllIIIIIIlIIlIlll) {
        super(lllllllllllllllIllIIIIIIlIIlIlll, Protocol1_9To1_8.class);
    }
    
    private boolean isPlacable(final Material lllllllllllllllIllIIIIIIIlllIlIl) {
        if (!lllllllllllllllIllIIIIIIIlllIlIl.isSolid()) {
            return true;
        }
        switch (lllllllllllllllIllIIIIIIIlllIlIl.getId()) {
            case 63:
            case 68:
            case 176:
            case 177: {
                return true;
            }
            default: {
                return false;
            }
        }
    }
    
    @EventHandler(ignoreCancelled = true, priority = EventPriority.HIGHEST)
    public void onPlace(final BlockPlaceEvent lllllllllllllllIllIIIIIIlIIIlIIl) {
        if (this.isOnPipe(lllllllllllllllIllIIIIIIlIIIlIIl.getPlayer())) {
            final Material lllllllllllllllIllIIIIIIlIIIllIl = lllllllllllllllIllIIIIIIlIIIlIIl.getBlockPlaced().getType();
            if (this.isPlacable(lllllllllllllllIllIIIIIIlIIIllIl)) {
                return;
            }
            final Location lllllllllllllllIllIIIIIIlIIIllII = lllllllllllllllIllIIIIIIlIIIlIIl.getPlayer().getLocation();
            final Block lllllllllllllllIllIIIIIIlIIIlIll = lllllllllllllllIllIIIIIIlIIIllII.getBlock();
            if (lllllllllllllllIllIIIIIIlIIIlIll.equals(lllllllllllllllIllIIIIIIlIIIlIIl.getBlock())) {
                lllllllllllllllIllIIIIIIlIIIlIIl.setCancelled(true);
            }
            else if (lllllllllllllllIllIIIIIIlIIIlIll.getRelative(BlockFace.UP).equals(lllllllllllllllIllIIIIIIlIIIlIIl.getBlock())) {
                lllllllllllllllIllIIIIIIlIIIlIIl.setCancelled(true);
            }
            else {
                final Location lllllllllllllllIllIIIIIIlIIIlllI = lllllllllllllllIllIIIIIIlIIIllII.clone().subtract(lllllllllllllllIllIIIIIIlIIIlIIl.getBlock().getLocation().add(0.5, 0.0, 0.5));
                if (Math.abs(lllllllllllllllIllIIIIIIlIIIlllI.getX()) <= 0.8 && Math.abs(lllllllllllllllIllIIIIIIlIIIlllI.getZ()) <= 0.8) {
                    if (lllllllllllllllIllIIIIIIlIIIlllI.getY() <= 0.1 && lllllllllllllllIllIIIIIIlIIIlllI.getY() >= -0.1) {
                        lllllllllllllllIllIIIIIIlIIIlIIl.setCancelled(true);
                        return;
                    }
                    final BlockFace lllllllllllllllIllIIIIIIlIIIllll = lllllllllllllllIllIIIIIIlIIIlIIl.getBlockAgainst().getFace(lllllllllllllllIllIIIIIIlIIIlIIl.getBlock());
                    if (lllllllllllllllIllIIIIIIlIIIllll == BlockFace.UP && lllllllllllllllIllIIIIIIlIIIlllI.getY() < 1.0 && lllllllllllllllIllIIIIIIlIIIlllI.getY() >= 0.0) {
                        lllllllllllllllIllIIIIIIlIIIlIIl.setCancelled(true);
                    }
                }
            }
        }
    }
}
