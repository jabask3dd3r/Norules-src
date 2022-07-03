package com.viaversion.viaversion.sponge.platform;

import com.viaversion.viaversion.*;
import org.spongepowered.api.entity.living.player.*;
import io.netty.buffer.*;

public class SpongeViaAPI extends ViaAPIBase<Player>
{
    @Override
    public void sendRawPacket(final Player lllllllllllllIlIlIIlIlIIIlIIIIll, final ByteBuf lllllllllllllIlIlIIlIlIIIIllllll) throws IllegalArgumentException {
        this.sendRawPacket(lllllllllllllIlIlIIlIlIIIlIIIIll.getUniqueId(), lllllllllllllIlIlIIlIlIIIIllllll);
    }
    
    @Override
    public int getPlayerVersion(final Player lllllllllllllIlIlIIlIlIIIlIIlIII) {
        return this.getPlayerVersion(lllllllllllllIlIlIIlIlIIIlIIlIII.getUniqueId());
    }
}
