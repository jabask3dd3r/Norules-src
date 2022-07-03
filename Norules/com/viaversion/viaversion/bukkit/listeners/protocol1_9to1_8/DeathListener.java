package com.viaversion.viaversion.bukkit.listeners.protocol1_9to1_8;

import com.viaversion.viaversion.bukkit.listeners.*;
import org.bukkit.event.entity.*;
import com.viaversion.viaversion.api.*;
import org.bukkit.entity.*;
import org.bukkit.event.*;
import com.viaversion.viaversion.api.connection.*;
import com.viaversion.viaversion.api.protocol.packet.*;
import io.netty.buffer.*;
import com.viaversion.viaversion.api.type.*;
import com.viaversion.viaversion.protocols.protocol1_9to1_8.*;
import com.viaversion.viaversion.api.protocol.*;
import org.bukkit.*;
import org.bukkit.plugin.*;

public class DeathListener extends ViaBukkitListener
{
    @EventHandler(ignoreCancelled = true, priority = EventPriority.MONITOR)
    public void onDeath(final PlayerDeathEvent lllllllllllllIlIlllllIlIIlIIllII) {
        final Player lllllllllllllIlIlllllIlIIlIIlIll = lllllllllllllIlIlllllIlIIlIIllII.getEntity();
        if (this.isOnPipe(lllllllllllllIlIlllllIlIIlIIlIll) && Via.getConfig().isShowNewDeathMessages() && this.checkGamerule(lllllllllllllIlIlllllIlIIlIIlIll.getWorld()) && lllllllllllllIlIlllllIlIIlIIllII.getDeathMessage() != null) {
            this.sendPacket(lllllllllllllIlIlllllIlIIlIIlIll, lllllllllllllIlIlllllIlIIlIIllII.getDeathMessage());
        }
    }
    
    private void sendPacket(final Player lllllllllllllIlIlllllIlIIIlllIIl, final String lllllllllllllIlIlllllIlIIIlllIII) {
        Via.getPlatform().runSync(new Runnable() {
            @Override
            public void run() {
                final UserConnection lllllllllllllIlIllIllllllIllIlII = ViaBukkitListener.this.getUserConnection(lllllllllllllIlIlllllIlIIIlllIIl);
                if (lllllllllllllIlIllIllllllIllIlII != null) {
                    final PacketWrapper lllllllllllllIlIllIllllllIllIllI = PacketWrapper.create(ClientboundPackets1_9.COMBAT_EVENT, null, lllllllllllllIlIllIllllllIllIlII);
                    try {
                        lllllllllllllIlIllIllllllIllIllI.write(Type.VAR_INT, 2);
                        lllllllllllllIlIllIllllllIllIllI.write(Type.VAR_INT, lllllllllllllIlIlllllIlIIIlllIIl.getEntityId());
                        lllllllllllllIlIllIllllllIllIllI.write(Type.INT, lllllllllllllIlIlllllIlIIIlllIIl.getEntityId());
                        Protocol1_9To1_8.FIX_JSON.write(lllllllllllllIlIllIllllllIllIllI, lllllllllllllIlIlllllIlIIIlllIII);
                        lllllllllllllIlIllIllllllIllIllI.scheduleSend(Protocol1_9To1_8.class);
                    }
                    catch (Exception lllllllllllllIlIllIllllllIllIlll) {
                        lllllllllllllIlIllIllllllIllIlll.printStackTrace();
                    }
                }
            }
        });
    }
    
    public boolean checkGamerule(final World lllllllllllllIlIlllllIlIIlIIIIll) {
        try {
            return Boolean.parseBoolean(lllllllllllllIlIlllllIlIIlIIIIll.getGameRuleValue("showDeathMessages"));
        }
        catch (Exception lllllllllllllIlIlllllIlIIlIIIlIl) {
            return false;
        }
    }
    
    public DeathListener(final Plugin lllllllllllllIlIlllllIlIIlIlIIll) {
        super(lllllllllllllIlIlllllIlIIlIlIIll, Protocol1_9To1_8.class);
    }
}
