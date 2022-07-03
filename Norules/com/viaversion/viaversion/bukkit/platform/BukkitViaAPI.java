package com.viaversion.viaversion.bukkit.platform;

import org.bukkit.entity.*;
import com.viaversion.viaversion.*;
import java.util.*;
import com.viaversion.viaversion.api.*;
import org.bukkit.*;
import com.viaversion.viaversion.bukkit.util.*;
import com.viaversion.viaversion.api.connection.*;
import io.netty.buffer.*;

public class BukkitViaAPI extends ViaAPIBase<Player>
{
    private final /* synthetic */ ViaVersionPlugin plugin;
    
    @Override
    public int getPlayerVersion(final Player lllllllllllllIllllIlIllIlIlIIlII) {
        return this.getPlayerVersion(lllllllllllllIllllIlIllIlIlIIlII.getUniqueId());
    }
    
    public BukkitViaAPI(final ViaVersionPlugin lllllllllllllIllllIlIllIlIlIlIII) {
        this.plugin = lllllllllllllIllllIlIllIlIlIlIII;
    }
    
    @Override
    public int getPlayerVersion(final UUID lllllllllllllIllllIlIllIlIIllIII) {
        final UserConnection lllllllllllllIllllIlIllIlIIllIlI = Via.getManager().getConnectionManager().getConnectedClient(lllllllllllllIllllIlIllIlIIllIII);
        if (lllllllllllllIllllIlIllIlIIllIlI != null) {
            return lllllllllllllIllllIlIllIlIIllIlI.getProtocolInfo().getProtocolVersion();
        }
        final Player lllllllllllllIllllIlIllIlIIlllIl = Bukkit.getPlayer(lllllllllllllIllllIlIllIlIIllIII);
        if (lllllllllllllIllllIlIllIlIIlllIl != null && this.isProtocolSupport()) {
            return ProtocolSupportUtil.getProtocolVersion(lllllllllllllIllllIlIllIlIIlllIl);
        }
        return -1;
    }
    
    public boolean isCompatSpigotBuild() {
        return this.plugin.isCompatSpigotBuild();
    }
    
    public boolean isProtocolSupport() {
        return this.plugin.isProtocolSupport();
    }
    
    @Override
    public void sendRawPacket(final Player lllllllllllllIllllIlIllIlIIIlllI, final ByteBuf lllllllllllllIllllIlIllIlIIlIIII) throws IllegalArgumentException {
        this.sendRawPacket(lllllllllllllIllllIlIllIlIIIlllI.getUniqueId(), lllllllllllllIllllIlIllIlIIlIIII);
    }
}
