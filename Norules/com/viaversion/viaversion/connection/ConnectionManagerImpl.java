package com.viaversion.viaversion.connection;

import com.viaversion.viaversion.api.connection.*;
import io.netty.channel.*;
import com.viaversion.viaversion.api.*;
import io.netty.util.concurrent.*;
import java.util.concurrent.*;
import java.util.*;

public class ConnectionManagerImpl implements ConnectionManager
{
    protected final /* synthetic */ Set<UserConnection> connections;
    protected final /* synthetic */ Map<UUID, UserConnection> clients;
    
    @Override
    public void onLoginSuccess(final UserConnection lllllllllllllIllIlIIlllIIlIlIIll) {
        Objects.requireNonNull(lllllllllllllIllIlIIlllIIlIlIIll, "connection is null!");
        this.connections.add(lllllllllllllIllIlIIlllIIlIlIIll);
        if (this.isFrontEnd(lllllllllllllIllIlIIlllIIlIlIIll)) {
            final UUID lllllllllllllIllIlIIlllIIlIlIlll = lllllllllllllIllIlIIlllIIlIlIIll.getProtocolInfo().getUuid();
            if (this.clients.put(lllllllllllllIllIlIIlllIIlIlIlll, lllllllllllllIllIlIIlllIIlIlIIll) != null) {
                Via.getPlatform().getLogger().warning(String.valueOf(new StringBuilder().append("Duplicate UUID on frontend connection! (").append(lllllllllllllIllIlIIlllIIlIlIlll).append(")")));
            }
        }
        if (lllllllllllllIllIlIIlllIIlIlIIll.getChannel() != null) {
            lllllllllllllIllIlIIlllIIlIlIIll.getChannel().closeFuture().addListener((GenericFutureListener)(lllllllllllllIllIlIIlllIIIlIIllI -> this.onDisconnect(lllllllllllllIllIlIIlllIIlIlIIll)));
        }
    }
    
    public ConnectionManagerImpl() {
        this.clients = new ConcurrentHashMap<UUID, UserConnection>();
        this.connections = Collections.newSetFromMap(new ConcurrentHashMap<UserConnection, Boolean>());
    }
    
    @Override
    public UUID getConnectedClientId(final UserConnection lllllllllllllIllIlIIlllIIIlllIlI) {
        if (lllllllllllllIllIlIIlllIIIlllIlI.getProtocolInfo() == null) {
            return null;
        }
        final UUID lllllllllllllIllIlIIlllIIIlllIIl = lllllllllllllIllIlIIlllIIIlllIlI.getProtocolInfo().getUuid();
        final UserConnection lllllllllllllIllIlIIlllIIIlllIII = this.clients.get(lllllllllllllIllIlIIlllIIIlllIIl);
        if (lllllllllllllIllIlIIlllIIIlllIlI.equals(lllllllllllllIllIlIIlllIIIlllIII)) {
            return lllllllllllllIllIlIIlllIIIlllIIl;
        }
        return null;
    }
    
    @Override
    public void onDisconnect(final UserConnection lllllllllllllIllIlIIlllIIlIIlIlI) {
        Objects.requireNonNull(lllllllllllllIllIlIIlllIIlIIlIlI, "connection is null!");
        this.connections.remove(lllllllllllllIllIlIIlllIIlIIlIlI);
        if (this.isFrontEnd(lllllllllllllIllIlIIlllIIlIIlIlI)) {
            final UUID lllllllllllllIllIlIIlllIIlIIlllI = lllllllllllllIllIlIIlllIIlIIlIlI.getProtocolInfo().getUuid();
            this.clients.remove(lllllllllllllIllIlIIlllIIlIIlllI);
        }
    }
    
    @Override
    public boolean isClientConnected(final UUID lllllllllllllIllIlIIlllIIIlIlIll) {
        return this.clients.containsKey(lllllllllllllIllIlIIlllIIIlIlIll);
    }
    
    @Override
    public UserConnection getConnectedClient(final UUID lllllllllllllIllIlIIlllIIlIIIIII) {
        return this.clients.get(lllllllllllllIllIlIIlllIIlIIIIII);
    }
    
    @Override
    public Set<UserConnection> getConnections() {
        return Collections.unmodifiableSet((Set<? extends UserConnection>)this.connections);
    }
    
    @Override
    public Map<UUID, UserConnection> getConnectedClients() {
        return Collections.unmodifiableMap((Map<? extends UUID, ? extends UserConnection>)this.clients);
    }
}
