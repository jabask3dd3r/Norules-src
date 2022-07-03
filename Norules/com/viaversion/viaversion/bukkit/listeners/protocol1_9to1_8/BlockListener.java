package com.viaversion.viaversion.bukkit.listeners.protocol1_9to1_8;

import com.viaversion.viaversion.bukkit.listeners.*;
import org.bukkit.plugin.*;
import com.viaversion.viaversion.protocols.protocol1_9to1_8.*;
import com.viaversion.viaversion.api.protocol.*;
import org.bukkit.event.block.*;
import com.viaversion.viaversion.protocols.protocol1_9to1_8.storage.*;
import com.viaversion.viaversion.api.minecraft.*;
import org.bukkit.block.*;
import org.bukkit.event.*;

public class BlockListener extends ViaBukkitListener
{
    public BlockListener(final Plugin lllllllllllllIIIIIllIIIIlIIlIIIl) {
        super(lllllllllllllIIIIIllIIIIlIIlIIIl, Protocol1_9To1_8.class);
    }
    
    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void placeBlock(final BlockPlaceEvent lllllllllllllIIIIIllIIIIlIIIIlIl) {
        if (this.isOnPipe(lllllllllllllIIIIIllIIIIlIIIIlIl.getPlayer())) {
            final Block lllllllllllllIIIIIllIIIIlIIIlIlI = lllllllllllllIIIIIllIIIIlIIIIlIl.getBlockPlaced();
            final EntityTracker1_9 lllllllllllllIIIIIllIIIIlIIIlIIl = this.getUserConnection(lllllllllllllIIIIIllIIIIlIIIIlIl.getPlayer()).getEntityTracker(Protocol1_9To1_8.class);
            lllllllllllllIIIIIllIIIIlIIIlIIl.addBlockInteraction(new Position(lllllllllllllIIIIIllIIIIlIIIlIlI.getX(), (short)lllllllllllllIIIIIllIIIIlIIIlIlI.getY(), lllllllllllllIIIIIllIIIIlIIIlIlI.getZ()));
        }
    }
}
