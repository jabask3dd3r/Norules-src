package com.viaversion.viaversion.api.protocol;

import io.netty.buffer.*;
import com.viaversion.viaversion.api.connection.*;
import java.util.concurrent.*;
import com.viaversion.viaversion.api.protocol.packet.*;
import java.util.*;
import com.google.common.collect.*;
import com.viaversion.viaversion.api.protocol.version.*;

public interface ProtocolManager
{
    @Deprecated
    PacketWrapper createPacketWrapper(final int p0, final ByteBuf p1, final UserConnection p2);
    
    void registerProtocol(final Protocol p0, final ProtocolVersion p1, final ProtocolVersion p2);
    
    CompletableFuture<Void> getMappingLoaderFuture(final Class<? extends Protocol> p0);
    
    Protocol getProtocol(final int p0, final int p1);
    
    boolean onlyCheckLoweringPathEntries();
    
    void addMappingLoaderFuture(final Class<? extends Protocol> p0, final Class<? extends Protocol> p1, final Runnable p2);
    
     <T extends Protocol> T getProtocol(final Class<T> p0);
    
    List<ProtocolPathEntry> getProtocolPath(final int p0, final int p1);
    
    void registerProtocol(final Protocol p0, final List<Integer> p1, final int p2);
    
    void setOnlyCheckLoweringPathEntries(final boolean p0);
    
    int getMaxProtocolPathSize();
    
    PacketWrapper createPacketWrapper(final PacketType p0, final ByteBuf p1, final UserConnection p2);
    
    void addMappingLoaderFuture(final Class<? extends Protocol> p0, final Runnable p1);
    
    void completeMappingDataLoading(final Class<? extends Protocol> p0) throws Exception;
    
    default boolean isBaseProtocol(final Protocol lllllllllllllIIIIIIlIlIlIlllIlII) {
        return lllllllllllllIIIIIIlIlIlIlllIlII.isBaseProtocol();
    }
    
    Protocol getBaseProtocol(final int p0);
    
    void setMaxProtocolPathSize(final int p0);
    
     <C extends ClientboundPacketType, S extends ServerboundPacketType> VersionedPacketTransformer<C, S> createPacketTransformer(final ProtocolVersion p0, final Class<C> p1, final Class<S> p2);
    
    boolean isWorkingPipe();
    
    boolean checkForMappingCompletion();
    
    SortedSet<Integer> getSupportedVersions();
    
    void registerBaseProtocol(final Protocol p0, final Range<Integer> p1);
    
    ServerProtocolVersion getServerProtocolVersion();
    
    default Protocol getProtocol(final ProtocolVersion lllllllllllllIIIIIIlIlIlIlllllII, final ProtocolVersion lllllllllllllIIIIIIlIlIlIllllIll) {
        return this.getProtocol(lllllllllllllIIIIIIlIlIlIlllllII.getVersion(), lllllllllllllIIIIIIlIlIlIllllIll.getVersion());
    }
    
    Protocol getBaseProtocol();
}
