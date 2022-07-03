package com.viaversion.viaversion;

import com.viaversion.viaversion.legacy.*;
import com.viaversion.viaversion.api.connection.*;
import com.viaversion.viaversion.api.*;
import io.netty.buffer.*;
import com.viaversion.viaversion.api.legacy.*;
import java.util.*;
import com.viaversion.viaversion.api.protocol.version.*;

public abstract class ViaAPIBase<T> implements ViaAPI<T>
{
    private final /* synthetic */ LegacyAPI<T> legacy;
    
    @Override
    public UserConnection getConnection(final UUID lllllllllllllIIlIIIlIlIIIIlIlllI) {
        return Via.getManager().getConnectionManager().getConnectedClient(lllllllllllllIIlIIIlIlIIIIlIlllI);
    }
    
    @Override
    public void sendRawPacket(final UUID lllllllllllllIIlIIIlIlIIIIlIlIII, final ByteBuf lllllllllllllIIlIIIlIlIIIIlIIlll) throws IllegalArgumentException {
        if (!this.isInjected(lllllllllllllIIlIIIlIlIIIIlIlIII)) {
            throw new IllegalArgumentException("This player is not controlled by ViaVersion!");
        }
        final UserConnection lllllllllllllIIlIIIlIlIIIIlIIllI = Via.getManager().getConnectionManager().getConnectedClient(lllllllllllllIIlIIIlIlIIIIlIlIII);
        lllllllllllllIIlIIIlIlIIIIlIIllI.scheduleSendRawPacket(lllllllllllllIIlIIIlIlIIIIlIIlll);
    }
    
    @Override
    public LegacyViaAPI<T> legacyAPI() {
        return this.legacy;
    }
    
    @Override
    public String getVersion() {
        return Via.getPlatform().getPluginVersion();
    }
    
    @Override
    public int getPlayerVersion(final UUID lllllllllllllIIlIIIlIlIIIIlllIII) {
        final UserConnection lllllllllllllIIlIIIlIlIIIIlllIIl = Via.getManager().getConnectionManager().getConnectedClient(lllllllllllllIIlIIIlIlIIIIlllIII);
        return (lllllllllllllIIlIIIlIlIIIIlllIIl != null) ? lllllllllllllIIlIIIlIlIIIIlllIIl.getProtocolInfo().getProtocolVersion() : -1;
    }
    
    @Override
    public SortedSet<Integer> getFullSupportedVersions() {
        return Via.getManager().getProtocolManager().getSupportedVersions();
    }
    
    @Override
    public SortedSet<Integer> getSupportedVersions() {
        final SortedSet<Integer> lllllllllllllIIlIIIlIlIIIIIlllll = new TreeSet<Integer>(Via.getManager().getProtocolManager().getSupportedVersions());
        lllllllllllllIIlIIIlIlIIIIIlllll.removeAll(Via.getPlatform().getConf().getBlockedProtocols());
        return lllllllllllllIIlIIIlIlIIIIIlllll;
    }
    
    public ViaAPIBase() {
        this.legacy = new LegacyAPI<T>();
    }
    
    @Override
    public ServerProtocolVersion getServerVersion() {
        return Via.getManager().getProtocolManager().getServerProtocolVersion();
    }
    
    @Override
    public boolean isInjected(final UUID lllllllllllllIIlIIIlIlIIIIllIIll) {
        return Via.getManager().getConnectionManager().isClientConnected(lllllllllllllIIlIIIlIlIIIIllIIll);
    }
}
