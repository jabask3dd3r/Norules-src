package com.viaversion.viaversion.sponge.listeners.protocol1_9to1_8;

import com.viaversion.viaversion.sponge.listeners.*;
import com.viaversion.viaversion.*;
import com.viaversion.viaversion.api.protocol.*;
import org.spongepowered.api.entity.living.player.*;
import com.viaversion.viaversion.api.*;
import com.viaversion.viaversion.protocols.protocol1_9to1_8.*;
import com.viaversion.viaversion.api.protocol.packet.*;
import io.netty.buffer.*;
import com.viaversion.viaversion.api.type.*;
import org.spongepowered.api.world.*;
import org.spongepowered.api.event.entity.*;
import org.spongepowered.api.event.*;
import java.util.*;
import com.viaversion.viaversion.api.connection.*;

public class DeathListener extends ViaSpongeListener
{
    public DeathListener(final SpongePlugin lllllllllllllIllIlIIlIllIIIIlIIl) {
        super(lllllllllllllIllIlIIlIllIIIIlIIl, Protocol1_9To1_8.class);
    }
    
    private void sendPacket(final Player lllllllllllllIllIlIIlIlIlllIllII, final String lllllllllllllIllIlIIlIlIlllIlllI) {
        Via.getPlatform().runSync(new Runnable() {
            @Override
            public void run() {
                final PacketWrapper lllllllllllllIlIlIlIlIIllIlIIlll = PacketWrapper.create(ClientboundPackets1_9.COMBAT_EVENT, null, ViaListener.this.getUserConnection(lllllllllllllIllIlIIlIlIlllIllII.getUniqueId()));
                try {
                    final int lllllllllllllIlIlIlIlIIllIlIlIlI = ViaSpongeListener.this.getEntityId(lllllllllllllIllIlIIlIlIlllIllII);
                    lllllllllllllIlIlIlIlIIllIlIIlll.write(Type.VAR_INT, 2);
                    lllllllllllllIlIlIlIlIIllIlIIlll.write(Type.VAR_INT, lllllllllllllIlIlIlIlIIllIlIlIlI);
                    lllllllllllllIlIlIlIlIIllIlIIlll.write(Type.INT, lllllllllllllIlIlIlIlIIllIlIlIlI);
                    Protocol1_9To1_8.FIX_JSON.write(lllllllllllllIlIlIlIlIIllIlIIlll, lllllllllllllIllIlIIlIlIlllIlllI);
                    lllllllllllllIlIlIlIlIIllIlIIlll.scheduleSend(Protocol1_9To1_8.class);
                }
                catch (Exception lllllllllllllIlIlIlIlIIllIlIlIIl) {
                    lllllllllllllIlIlIlIlIIllIlIlIIl.printStackTrace();
                }
            }
        });
    }
    
    public boolean checkGamerule(final World lllllllllllllIllIlIIlIlIlllllIII) {
        final Optional<String> lllllllllllllIllIlIIlIlIllllIlll = (Optional<String>)lllllllllllllIllIlIIlIlIlllllIII.getGameRule("showDeathMessages");
        if (lllllllllllllIllIlIIlIlIllllIlll.isPresent()) {
            try {
                return Boolean.parseBoolean(lllllllllllllIllIlIIlIlIllllIlll.get());
            }
            catch (Exception lllllllllllllIllIlIIlIlIlllllIlI) {
                return false;
            }
        }
        return false;
    }
    
    @Listener(order = Order.LAST)
    public void onDeath(final DestructEntityEvent.Death lllllllllllllIllIlIIlIlIllllllll) {
        if (!(lllllllllllllIllIlIIlIlIllllllll.getTargetEntity() instanceof Player)) {
            return;
        }
        final Player lllllllllllllIllIlIIlIllIIIIIIIl = (Player)lllllllllllllIllIlIIlIlIllllllll.getTargetEntity();
        if (this.isOnPipe(lllllllllllllIllIlIIlIllIIIIIIIl.getUniqueId()) && Via.getConfig().isShowNewDeathMessages() && this.checkGamerule(lllllllllllllIllIlIIlIllIIIIIIIl.getWorld())) {
            this.sendPacket(lllllllllllllIllIlIIlIllIIIIIIIl, lllllllllllllIllIlIIlIlIllllllll.getMessage().toPlain());
        }
    }
}
