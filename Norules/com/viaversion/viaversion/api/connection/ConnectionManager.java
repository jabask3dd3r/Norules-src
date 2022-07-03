package com.viaversion.viaversion.api.connection;

import java.util.*;

public interface ConnectionManager
{
    UUID getConnectedClientId(final UserConnection p0);
    
    void onLoginSuccess(final UserConnection p0);
    
    default boolean isFrontEnd(final UserConnection lllllllllllllllIIIlIlIllIllllIIl) {
        return !lllllllllllllllIIIlIlIllIllllIIl.isClientSide();
    }
    
    Set<UserConnection> getConnections();
    
    Map<UUID, UserConnection> getConnectedClients();
    
    void onDisconnect(final UserConnection p0);
    
    UserConnection getConnectedClient(final UUID p0);
    
    boolean isClientConnected(final UUID p0);
}
