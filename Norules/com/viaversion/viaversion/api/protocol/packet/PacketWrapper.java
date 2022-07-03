package com.viaversion.viaversion.api.protocol.packet;

import com.viaversion.viaversion.api.connection.*;
import com.viaversion.viaversion.api.protocol.remapper.*;
import com.viaversion.viaversion.api.protocol.*;
import io.netty.buffer.*;
import com.viaversion.viaversion.api.type.*;
import java.util.*;
import io.netty.channel.*;
import com.viaversion.viaversion.api.*;

public interface PacketWrapper
{
    PacketWrapper create(final int p0);
    
    PacketType getPacketType();
    
    void sendToServerRaw() throws Exception;
    
    UserConnection user();
    
    void sendRaw() throws Exception;
    
    PacketWrapper create(final int p0, final PacketHandler p1) throws Exception;
    
    void scheduleSend(final Class<? extends Protocol> p0, final boolean p1) throws Exception;
    
    @Deprecated
    default void setId(final PacketType lllllllllllllIIlIllllllIlIIIIIlI) {
        this.setPacketType(lllllllllllllIIlIllllllIlIIIIIlI);
    }
    
    void writeToBuffer(final ByteBuf p0) throws Exception;
    
     <T> void set(final Type<T> p0, final int p1, final T p2) throws Exception;
    
    PacketWrapper apply(final Direction p0, final State p1, final int p2, final List<Protocol> p3) throws Exception;
    
    int getId();
    
    ChannelFuture sendFuture(final Class<? extends Protocol> p0) throws Exception;
    
    void send(final Class<? extends Protocol> p0, final boolean p1) throws Exception;
    
     <T> T read(final Type<T> p0) throws Exception;
    
    void cancel();
    
     <T> T get(final Type<T> p0, final int p1) throws Exception;
    
    void scheduleSendRaw() throws Exception;
    
    PacketWrapper apply(final Direction p0, final State p1, final int p2, final List<Protocol> p3, final boolean p4) throws Exception;
    
    boolean is(final Type p0, final int p1);
    
    void clearPacket();
    
    default PacketWrapper create(final PacketType lllllllllllllIIlIllllllIlIIlIllI, final PacketHandler lllllllllllllIIlIllllllIlIIlIlIl) throws Exception {
        return this.create(lllllllllllllIIlIllllllIlIIlIllI.getId(), lllllllllllllIIlIllllllIlIIlIlIl);
    }
    
    default void sendToServer(final Class<? extends Protocol> lllllllllllllIIlIllllllIlIIIlllI) throws Exception {
        this.sendToServer(lllllllllllllIIlIllllllIlIIIlllI, true);
    }
    
    void scheduleSendToServerRaw() throws Exception;
    
    default void scheduleSend(final Class<? extends Protocol> lllllllllllllIIlIllllllIlIlIIlll) throws Exception {
        this.scheduleSend(lllllllllllllIIlIllllllIlIlIIlll, true);
    }
    
    void scheduleSendToServer(final Class<? extends Protocol> p0, final boolean p1) throws Exception;
    
    default PacketWrapper create(final PacketType lllllllllllllIIlIllllllIllIIIIIl, final ByteBuf lllllllllllllIIlIllllllIlIllllIl, final UserConnection lllllllllllllIIlIllllllIlIllllll) {
        return Via.getManager().getProtocolManager().createPacketWrapper(lllllllllllllIIlIllllllIllIIIIIl, lllllllllllllIIlIllllllIlIllllIl, lllllllllllllIIlIllllllIlIllllll);
    }
    
    void resetReader();
    
    default void scheduleSendToServer(final Class<? extends Protocol> lllllllllllllIIlIllllllIlIIIIllI) throws Exception {
        this.scheduleSendToServer(lllllllllllllIIlIllllllIlIIIIllI, true);
    }
    
     <T> T passthrough(final Type<T> p0) throws Exception;
    
    @Deprecated
    default PacketWrapper create(final int lllllllllllllIIlIllllllIlIlllIII, final ByteBuf lllllllllllllIIlIllllllIlIllIlll, final UserConnection lllllllllllllIIlIllllllIlIllIllI) {
        return Via.getManager().getProtocolManager().createPacketWrapper(lllllllllllllIIlIllllllIlIlllIII, lllllllllllllIIlIllllllIlIllIlll, lllllllllllllIIlIllllllIlIllIllI);
    }
    
    void setPacketType(final PacketType p0);
    
    boolean isReadable(final Type p0, final int p1);
    
     <T> void write(final Type<T> p0, final T p1);
    
    void sendToServer(final Class<? extends Protocol> p0, final boolean p1) throws Exception;
    
    @Deprecated
    default void send() throws Exception {
        this.sendRaw();
    }
    
    boolean isCancelled();
    
    @Deprecated
    default void sendToServer() throws Exception {
        this.sendToServerRaw();
    }
    
    default PacketWrapper create(final PacketType lllllllllllllIIlIllllllIllIIIllI, final UserConnection lllllllllllllIIlIllllllIllIIIlll) {
        return create(lllllllllllllIIlIllllllIllIIIllI, null, lllllllllllllIIlIllllllIllIIIlll);
    }
    
    void passthroughAll() throws Exception;
    
    default void send(final Class<? extends Protocol> lllllllllllllIIlIllllllIlIlIllIl) throws Exception {
        this.send(lllllllllllllIIlIllllllIlIlIllIl, true);
    }
    
    void clearInputBuffer();
    
    default PacketWrapper create(final PacketType lllllllllllllIIlIllllllIlIlIIIII) {
        return this.create(lllllllllllllIIlIllllllIlIlIIIII.getId());
    }
    
    @Deprecated
    void setId(final int p0);
}
