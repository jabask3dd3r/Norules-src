package com.viaversion.viaversion.velocity.platform;

import com.viaversion.viaversion.*;
import com.velocitypowered.api.proxy.*;
import io.netty.buffer.*;

public class VelocityViaAPI extends ViaAPIBase<Player>
{
    @Override
    public void sendRawPacket(final Player lllllllllllllIlIlllllIlIIllIIlII, final ByteBuf lllllllllllllIlIlllllIlIIllIIllI) throws IllegalArgumentException {
        this.sendRawPacket(lllllllllllllIlIlllllIlIIllIIlII.getUniqueId(), lllllllllllllIlIlllllIlIIllIIllI);
    }
    
    @Override
    public int getPlayerVersion(final Player lllllllllllllIlIlllllIlIIllIlllI) {
        return this.getPlayerVersion(lllllllllllllIlIlllllIlIIllIlllI.getUniqueId());
    }
}
