package com.viaversion.viaversion.api.protocol;

import com.viaversion.viaversion.api.protocol.remapper.*;
import com.viaversion.viaversion.api.data.*;
import com.viaversion.viaversion.api.platform.providers.*;
import com.viaversion.viaversion.api.rewriter.*;
import com.viaversion.viaversion.api.protocol.packet.*;
import com.viaversion.viaversion.api.connection.*;

public interface Protocol<C1 extends ClientboundPacketType, C2 extends ClientboundPacketType, S1 extends ServerboundPacketType, S2 extends ServerboundPacketType>
{
    void registerServerbound(final State p0, final int p1, final int p2, final PacketRemapper p3, final boolean p4);
    
    boolean hasRegisteredClientbound(final C1 p0);
    
     <T> T get(final Class<T> p0);
    
    boolean hasMappingDataToLoad();
    
    boolean hasRegisteredServerbound(final S2 p0);
    
    default EntityRewriter getEntityRewriter() {
        return null;
    }
    
    void registerServerbound(final S2 p0, final S1 p1, final PacketRemapper p2, final boolean p3);
    
    default MappingData getMappingData() {
        return null;
    }
    
    default void registerServerbound(final S2 llllllllllllIllllllIIIIIIIIIllIl, final S1 llllllllllllIllllllIIIIIIIIIllII) {
        this.registerServerbound(llllllllllllIllllllIIIIIIIIIllIl, llllllllllllIllllllIIIIIIIIIllII, null);
    }
    
    default void register(final ViaProviders llllllllllllIlllllIllllllllllIll) {
    }
    
    default void cancelClientbound(final State llllllllllllIllllllIIIIIIIlIlIII, final int llllllllllllIllllllIIIIIIIlIIlll) {
        this.cancelClientbound(llllllllllllIllllllIIIIIIIlIlIII, llllllllllllIllllllIIIIIIIlIIlll, -1);
    }
    
    default ItemRewriter getItemRewriter() {
        return null;
    }
    
    void loadMappingData();
    
    void cancelServerbound(final State p0, final int p1, final int p2);
    
    default void cancelServerbound(final State llllllllllllIllllllIIIIIIlIIllll, final int llllllllllllIllllllIIIIIIlIIlIll) {
        this.cancelServerbound(llllllllllllIllllllIIIIIIlIIllll, -1, llllllllllllIllllllIIIIIIlIIlIll);
    }
    
    default void registerClientbound(final C1 llllllllllllIllllllIIIIIIIIllIII, final C2 llllllllllllIllllllIIIIIIIIlIIll, final PacketRemapper llllllllllllIllllllIIIIIIIIlIIlI) {
        this.registerClientbound(llllllllllllIllllllIIIIIIIIllIII, llllllllllllIllllllIIIIIIIIlIIll, llllllllllllIllllllIIIIIIIIlIIlI, false);
    }
    
    default void registerClientbound(final C1 llllllllllllIllllllIIIIIIIIlllll, final C2 llllllllllllIllllllIIIIIIIIllllI) {
        this.registerClientbound(llllllllllllIllllllIIIIIIIIlllll, llllllllllllIllllllIIIIIIIIllllI, null);
    }
    
    default void registerServerbound(final S2 llllllllllllIlllllIlllllllllllll, final S1 llllllllllllIllllllIIIIIIIIIIIlI, final PacketRemapper llllllllllllIlllllIlllllllllllIl) {
        this.registerServerbound(llllllllllllIlllllIlllllllllllll, llllllllllllIllllllIIIIIIIIIIIlI, llllllllllllIlllllIlllllllllllIl, false);
    }
    
    void initialize();
    
    void transform(final Direction p0, final State p1, final PacketWrapper p2) throws Exception;
    
    void registerClientbound(final C1 p0, final C2 p1, final PacketRemapper p2, final boolean p3);
    
    default void registerServerbound(final State llllllllllllIllllllIIIIIIlIlIlll, final int llllllllllllIllllllIIIIIIlIlIllI, final int llllllllllllIllllllIIIIIIlIlIlIl, final PacketRemapper llllllllllllIllllllIIIIIIlIllIIl) {
        this.registerServerbound(llllllllllllIllllllIIIIIIlIlIlll, llllllllllllIllllllIIIIIIlIlIllI, llllllllllllIllllllIIIIIIlIlIlIl, llllllllllllIllllllIIIIIIlIllIIl, false);
    }
    
    default void init(final UserConnection llllllllllllIlllllIllllllllllIIl) {
    }
    
    void put(final Object p0);
    
    default void registerClientbound(final State llllllllllllIllllllIIIIIIIllIIll, final int llllllllllllIllllllIIIIIIIllIlll, final int llllllllllllIllllllIIIIIIIllIIIl, final PacketRemapper llllllllllllIllllllIIIIIIIllIlIl) {
        this.registerClientbound(llllllllllllIllllllIIIIIIIllIIll, llllllllllllIllllllIIIIIIIllIlll, llllllllllllIllllllIIIIIIIllIIIl, llllllllllllIllllllIIIIIIIllIlIl, false);
    }
    
    void registerClientbound(final C1 p0, final PacketRemapper p1);
    
    boolean hasRegisteredServerbound(final State p0, final int p1);
    
    void cancelClientbound(final C1 p0);
    
    default void registerServerbound(final State llllllllllllIllllllIIIIIIllIlIIl, final int llllllllllllIllllllIIIIIIllIIlII, final int llllllllllllIllllllIIIIIIllIIlll) {
        this.registerServerbound(llllllllllllIllllllIIIIIIllIlIIl, llllllllllllIllllllIIIIIIllIIlII, llllllllllllIllllllIIIIIIllIIlll, null);
    }
    
    void registerServerbound(final S2 p0, final PacketRemapper p1);
    
    default boolean isBaseProtocol() {
        return false;
    }
    
    void cancelServerbound(final S2 p0);
    
    void cancelClientbound(final State p0, final int p1, final int p2);
    
    default void registerClientbound(final State llllllllllllIllllllIIIIIIlIIIlIl, final int llllllllllllIllllllIIIIIIlIIIlII, final int llllllllllllIllllllIIIIIIIllllll) {
        this.registerClientbound(llllllllllllIllllllIIIIIIlIIIlIl, llllllllllllIllllllIIIIIIlIIIlII, llllllllllllIllllllIIIIIIIllllll, null);
    }
    
    boolean hasRegisteredClientbound(final State p0, final int p1);
    
    void registerClientbound(final State p0, final int p1, final int p2, final PacketRemapper p3, final boolean p4);
}
