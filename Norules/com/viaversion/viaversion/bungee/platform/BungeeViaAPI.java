package com.viaversion.viaversion.bungee.platform;

import com.viaversion.viaversion.*;
import net.md_5.bungee.api.connection.*;
import net.md_5.bungee.api.config.*;
import com.viaversion.viaversion.bungee.service.*;
import io.netty.buffer.*;

public class BungeeViaAPI extends ViaAPIBase<ProxiedPlayer>
{
    @Override
    public int getPlayerVersion(final ProxiedPlayer llIlIIlllIIIll) {
        return this.getPlayerVersion(llIlIIlllIIIll.getUniqueId());
    }
    
    public void probeServer(final ServerInfo llIlIIllIlIllI) {
        ProtocolDetectorService.probeServer(llIlIIllIlIllI);
    }
    
    @Override
    public void sendRawPacket(final ProxiedPlayer llIlIIllIllllI, final ByteBuf llIlIIllIlllIl) throws IllegalArgumentException {
        this.sendRawPacket(llIlIIllIllllI.getUniqueId(), llIlIIllIlllIl);
    }
}
