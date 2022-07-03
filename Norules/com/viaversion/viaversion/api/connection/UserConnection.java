package com.viaversion.viaversion.api.connection;

import io.netty.buffer.*;
import java.util.function.*;
import com.viaversion.viaversion.api.data.entity.*;
import com.viaversion.viaversion.api.protocol.packet.*;
import io.netty.channel.*;
import com.viaversion.viaversion.api.protocol.*;
import java.util.*;

public interface UserConnection
{
    void clearStoredObjects();
    
    void transformServerbound(final ByteBuf p0, final Function<Throwable, Exception> p1) throws Exception;
    
    default void transformOutgoing(final ByteBuf lllllllllllllIIIlIIlllIIIIllllII, final Function<Throwable, Exception> lllllllllllllIIIlIIlllIIIIlllIII) throws Exception {
        if (this.isClientSide()) {
            this.transformServerbound(lllllllllllllIIIlIIlllIIIIllllII, lllllllllllllIIIlIIlllIIIIlllIII);
        }
        else {
            this.transformClientbound(lllllllllllllIIIlIIlllIIIIllllII, lllllllllllllIIIlIIlllIIIIlllIII);
        }
    }
    
    Collection<EntityTracker> getEntityTrackers();
    
    boolean isActive();
    
    boolean has(final Class<? extends StorableObject> p0);
    
    void transformClientbound(final ByteBuf p0, final Function<Throwable, Exception> p1) throws Exception;
    
    boolean checkServerboundPacket();
    
    PacketTracker getPacketTracker();
    
    void setActive(final boolean p0);
    
    ChannelFuture sendRawPacketFuture(final ByteBuf p0);
    
    Channel getChannel();
    
    void setPendingDisconnect(final boolean p0);
    
    void scheduleSendRawPacket(final ByteBuf p0);
    
    default boolean checkIncomingPacket() {
        return this.isClientSide() ? this.checkClientboundPacket() : this.checkServerboundPacket();
    }
    
    void put(final StorableObject p0);
    
    void addEntityTracker(final Class<? extends Protocol> p0, final EntityTracker p1);
    
    void scheduleSendRawPacketToServer(final ByteBuf p0);
    
    void disconnect(final String p0);
    
    boolean isClientSide();
    
     <T extends StorableObject> T get(final Class<T> p0);
    
    boolean checkClientboundPacket();
    
    long getId();
    
    default void transformIncoming(final ByteBuf lllllllllllllIIIlIIlllIIIIllIIll, final Function<Throwable, Exception> lllllllllllllIIIlIIlllIIIIlIllll) throws Exception {
        if (this.isClientSide()) {
            this.transformClientbound(lllllllllllllIIIlIIlllIIIIllIIll, lllllllllllllIIIlIIlllIIIIlIllll);
        }
        else {
            this.transformServerbound(lllllllllllllIIIlIIlllIIIIllIIll, lllllllllllllIIIlIIlllIIIIlIllll);
        }
    }
    
    boolean isPendingDisconnect();
    
    boolean shouldApplyBlockProtocol();
    
     <T extends EntityTracker> T getEntityTracker(final Class<? extends Protocol> p0);
    
    UUID generatePassthroughToken();
    
    default boolean checkOutgoingPacket() {
        return this.isClientSide() ? this.checkServerboundPacket() : this.checkClientboundPacket();
    }
    
    ProtocolInfo getProtocolInfo();
    
    boolean shouldTransformPacket();
    
    void sendRawPacketToServer(final ByteBuf p0);
    
    void sendRawPacket(final ByteBuf p0);
    
    Map<Class<?>, StorableObject> getStoredObjects();
}
