package com.viaversion.viaversion.api;

import com.viaversion.viaversion.api.protocol.version.*;
import com.viaversion.viaversion.api.legacy.*;
import java.util.*;
import io.netty.buffer.*;
import com.viaversion.viaversion.api.connection.*;

public interface ViaAPI<T>
{
    SortedSet<Integer> getFullSupportedVersions();
    
    ServerProtocolVersion getServerVersion();
    
    String getVersion();
    
    SortedSet<Integer> getSupportedVersions();
    
    LegacyViaAPI<T> legacyAPI();
    
    int getPlayerVersion(final T p0);
    
    boolean isInjected(final UUID p0);
    
    void sendRawPacket(final T p0, final ByteBuf p1);
    
    void sendRawPacket(final UUID p0, final ByteBuf p1);
    
    UserConnection getConnection(final UUID p0);
    
    int getPlayerVersion(final UUID p0);
    
    default int apiVersion() {
        return 4;
    }
}
