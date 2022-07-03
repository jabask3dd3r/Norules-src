package com.viaversion.viaversion.sponge.listeners.protocol1_9to1_8;

import com.viaversion.viaversion.sponge.listeners.*;
import com.viaversion.viaversion.*;
import com.viaversion.viaversion.protocols.protocol1_9to1_8.*;
import com.viaversion.viaversion.api.protocol.*;
import org.spongepowered.api.event.block.*;
import org.spongepowered.api.entity.living.player.*;
import org.spongepowered.api.event.filter.cause.*;
import org.spongepowered.api.world.*;
import org.spongepowered.api.block.*;
import org.spongepowered.api.data.*;
import com.viaversion.viaversion.protocols.protocol1_9to1_8.storage.*;
import com.viaversion.viaversion.api.minecraft.*;
import org.spongepowered.api.event.*;

public class BlockListener extends ViaSpongeListener
{
    public BlockListener(final SpongePlugin lllllllllllllIIlIIIIIIlIIIIlIIIl) {
        super(lllllllllllllIIlIIIIIIlIIIIlIIIl, Protocol1_9To1_8.class);
    }
    
    @Listener
    public void placeBlock(final ChangeBlockEvent.Place lllllllllllllIIlIIIIIIlIIIIIlIII, @Root final Player lllllllllllllIIlIIIIIIlIIIIIIlII) {
        if (this.isOnPipe(lllllllllllllIIlIIIIIIlIIIIIIlII.getUniqueId())) {
            final Location lllllllllllllIIlIIIIIIlIIIIIlIll = ((BlockSnapshot)lllllllllllllIIlIIIIIIlIIIIIlIII.getTransactions().get(0).getFinal()).getLocation().get();
            final EntityTracker1_9 lllllllllllllIIlIIIIIIlIIIIIlIlI = this.getUserConnection(lllllllllllllIIlIIIIIIlIIIIIIlII.getUniqueId()).getEntityTracker(Protocol1_9To1_8.class);
            lllllllllllllIIlIIIIIIlIIIIIlIlI.addBlockInteraction(new Position(lllllllllllllIIlIIIIIIlIIIIIlIll.getBlockX(), (short)lllllllllllllIIlIIIIIIlIIIIIlIll.getBlockY(), lllllllllllllIIlIIIIIIlIIIIIlIll.getBlockZ()));
        }
    }
}
