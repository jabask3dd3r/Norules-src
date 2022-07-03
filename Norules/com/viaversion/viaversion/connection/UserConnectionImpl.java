package com.viaversion.viaversion.connection;

import java.util.concurrent.atomic.*;
import com.viaversion.viaversion.api.protocol.*;
import com.viaversion.viaversion.api.data.entity.*;
import com.viaversion.viaversion.api.connection.*;
import com.viaversion.viaversion.api.*;
import io.netty.buffer.*;
import java.util.function.*;
import com.google.common.cache.*;
import java.util.concurrent.*;
import com.viaversion.viaversion.api.type.*;
import com.viaversion.viaversion.protocol.packet.*;
import com.viaversion.viaversion.exception.*;
import com.viaversion.viaversion.api.protocol.packet.*;
import java.util.*;
import com.viaversion.viaversion.util.*;
import io.netty.channel.*;

public class UserConnectionImpl implements UserConnection
{
    private final /* synthetic */ Channel channel;
    private static final /* synthetic */ AtomicLong IDS;
    private final /* synthetic */ Map<Class<?>, StorableObject> storedObjects;
    private final /* synthetic */ Set<UUID> passthroughTokens;
    private final /* synthetic */ boolean clientSide;
    private /* synthetic */ boolean active;
    private final /* synthetic */ Map<Class<? extends Protocol>, EntityTracker> entityTrackers;
    private final /* synthetic */ PacketTracker packetTracker;
    private final /* synthetic */ long id;
    private /* synthetic */ boolean pendingDisconnect;
    private final /* synthetic */ ProtocolInfo protocolInfo;
    
    @Override
    public void disconnect(final String lllllllllllllIllIIlIIllIlllIIllI) {
        if (!this.channel.isOpen() || this.pendingDisconnect) {
            return;
        }
        this.pendingDisconnect = true;
        Via.getPlatform().runSync(() -> {
            if (!Via.getPlatform().disconnect(this, ChatColorUtil.translateAlternateColorCodes(lllllllllllllIllIIlIIllIlllIIllI))) {
                this.channel.close();
            }
        });
    }
    
    @Override
    public ChannelFuture sendRawPacketFuture(final ByteBuf lllllllllllllIllIIlIIllIlllIllIl) {
        if (this.clientSide) {
            this.getChannel().pipeline().context(Via.getManager().getInjector().getDecoderName()).fireChannelRead((Object)lllllllllllllIllIIlIIllIlllIllIl);
            return this.getChannel().newSucceededFuture();
        }
        return this.channel.pipeline().context(Via.getManager().getInjector().getEncoderName()).writeAndFlush((Object)lllllllllllllIllIIlIIllIlllIllIl);
    }
    
    @Override
    public void transformClientbound(final ByteBuf lllllllllllllIllIIlIIllIlIlIIIll, final Function<Throwable, Exception> lllllllllllllIllIIlIIllIlIIlllll) throws Exception {
        this.transform(lllllllllllllIllIIlIIllIlIlIIIll, Direction.CLIENTBOUND, lllllllllllllIllIIlIIllIlIIlllll);
    }
    
    @Override
    public UUID generatePassthroughToken() {
        final UUID lllllllllllllIllIIlIIllIIlIlIllI = UUID.randomUUID();
        this.passthroughTokens.add(lllllllllllllIllIIlIIllIIlIlIllI);
        return lllllllllllllIllIIlIIllIIlIlIllI;
    }
    
    @Override
    public boolean isActive() {
        return this.active;
    }
    
    @Override
    public boolean checkServerboundPacket() {
        return !this.pendingDisconnect && (!this.packetTracker.incrementReceived() || !this.packetTracker.exceedsMaxPPS());
    }
    
    public UserConnectionImpl(final Channel lllllllllllllIllIIlIIlllIlIIIIII, final boolean lllllllllllllIllIIlIIlllIIllllll) {
        this.id = UserConnectionImpl.IDS.incrementAndGet();
        this.storedObjects = new ConcurrentHashMap<Class<?>, StorableObject>();
        this.entityTrackers = new HashMap<Class<? extends Protocol>, EntityTracker>();
        this.packetTracker = new PacketTracker(this);
        this.passthroughTokens = Collections.newSetFromMap((Map<UUID, Boolean>)CacheBuilder.newBuilder().expireAfterWrite(10L, TimeUnit.SECONDS).build().asMap());
        this.protocolInfo = new ProtocolInfoImpl(this);
        this.active = true;
        this.channel = lllllllllllllIllIIlIIlllIlIIIIII;
        this.clientSide = lllllllllllllIllIIlIIlllIIllllll;
    }
    
    @Override
    public boolean isClientSide() {
        return this.clientSide;
    }
    
    private void transform(final ByteBuf lllllllllllllIllIIlIIllIlIIIlIll, final Direction lllllllllllllIllIIlIIllIlIIIlIlI, final Function<Throwable, Exception> lllllllllllllIllIIlIIllIlIIIlIIl) throws Exception {
        if (!lllllllllllllIllIIlIIllIlIIIlIll.isReadable()) {
            return;
        }
        final int lllllllllllllIllIIlIIllIlIIIlIII = Type.VAR_INT.readPrimitive(lllllllllllllIllIIlIIllIlIIIlIll);
        if (lllllllllllllIllIIlIIllIlIIIlIII != 1000) {
            final PacketWrapper lllllllllllllIllIIlIIllIlIIIIlll = new PacketWrapperImpl(lllllllllllllIllIIlIIllIlIIIlIII, lllllllllllllIllIIlIIllIlIIIlIll, this);
            try {
                this.protocolInfo.getPipeline().transform(lllllllllllllIllIIlIIllIlIIIlIlI, this.protocolInfo.getState(), lllllllllllllIllIIlIIllIlIIIIlll);
            }
            catch (CancelException lllllllllllllIllIIlIIllIlIIIllIl) {
                throw lllllllllllllIllIIlIIllIlIIIlIIl.apply(lllllllllllllIllIIlIIllIlIIIllIl);
            }
            final ByteBuf lllllllllllllIllIIlIIllIlIIIIllI = lllllllllllllIllIIlIIllIlIIIlIll.alloc().buffer();
            try {
                lllllllllllllIllIIlIIllIlIIIIlll.writeToBuffer(lllllllllllllIllIIlIIllIlIIIIllI);
                lllllllllllllIllIIlIIllIlIIIlIll.clear().writeBytes(lllllllllllllIllIIlIIllIlIIIIllI);
            }
            finally {
                lllllllllllllIllIIlIIllIlIIIIllI.release();
            }
            return;
        }
        if (!this.passthroughTokens.remove(Type.UUID.read(lllllllllllllIllIIlIIllIlIIIlIll))) {
            throw new IllegalArgumentException("Invalid token");
        }
    }
    
    @Override
    public void put(final StorableObject lllllllllllllIllIIlIIlllIIlIIllI) {
        this.storedObjects.put(lllllllllllllIllIIlIIlllIIlIIllI.getClass(), lllllllllllllIllIIlIIlllIIlIIllI);
    }
    
    @Override
    public ProtocolInfo getProtocolInfo() {
        return this.protocolInfo;
    }
    
    @Override
    public void transformServerbound(final ByteBuf lllllllllllllIllIIlIIllIlIIllIlI, final Function<Throwable, Exception> lllllllllllllIllIIlIIllIlIIlIllI) throws Exception {
        this.transform(lllllllllllllIllIIlIIllIlIIllIlI, Direction.SERVERBOUND, lllllllllllllIllIIlIIllIlIIlIllI);
    }
    
    public UserConnectionImpl(final Channel lllllllllllllIllIIlIIlllIIlllIII) {
        this(lllllllllllllIllIIlIIlllIIlllIII, false);
    }
    
    @Override
    public boolean checkClientboundPacket() {
        this.packetTracker.incrementSent();
        return true;
    }
    
    @Override
    public void setPendingDisconnect(final boolean lllllllllllllIllIIlIIllIIllIIIlI) {
        this.pendingDisconnect = lllllllllllllIllIIlIIllIIllIIIlI;
    }
    
    @Override
    public boolean equals(final Object lllllllllllllIllIIlIIllIIlIIllII) {
        if (this == lllllllllllllIllIIlIIllIIlIIllII) {
            return true;
        }
        if (lllllllllllllIllIIlIIllIIlIIllII == null || this.getClass() != lllllllllllllIllIIlIIllIIlIIllII.getClass()) {
            return false;
        }
        final UserConnectionImpl lllllllllllllIllIIlIIllIIlIIlllI = (UserConnectionImpl)lllllllllllllIllIIlIIllIIlIIllII;
        return this.id == lllllllllllllIllIIlIIllIIlIIlllI.id;
    }
    
    @Override
    public void clearStoredObjects() {
        this.storedObjects.clear();
        this.entityTrackers.clear();
    }
    
    @Override
    public void addEntityTracker(final Class<? extends Protocol> lllllllllllllIllIIlIIlllIIIlIIll, final EntityTracker lllllllllllllIllIIlIIlllIIIlIIlI) {
        this.entityTrackers.put(lllllllllllllIllIIlIIlllIIIlIIll, lllllllllllllIllIIlIIlllIIIlIIlI);
    }
    
    @Override
    public Collection<EntityTracker> getEntityTrackers() {
        return this.entityTrackers.values();
    }
    
    @Override
    public Channel getChannel() {
        return this.channel;
    }
    
    @Override
    public <T extends EntityTracker> T getEntityTracker(final Class<? extends Protocol> lllllllllllllIllIIlIIlllIIIllIll) {
        return (T)this.entityTrackers.get(lllllllllllllIllIIlIIlllIIIllIll);
    }
    
    @Override
    public void sendRawPacket(final ByteBuf lllllllllllllIllIIlIIlllIIIIlIIl) {
        this.sendRawPacket(lllllllllllllIllIIlIIlllIIIIlIIl, true);
    }
    
    @Override
    public <T extends StorableObject> T get(final Class<T> lllllllllllllIllIIlIIlllIIllIIII) {
        return (T)this.storedObjects.get(lllllllllllllIllIIlIIlllIIllIIII);
    }
    
    private void sendRawPacketToServerServerSide(final ByteBuf lllllllllllllIllIIlIIllIllIIlIlI, final boolean lllllllllllllIllIIlIIllIllIIIlIl) {
        final ByteBuf lllllllllllllIllIIlIIllIllIIlIII = lllllllllllllIllIIlIIllIllIIlIlI.alloc().buffer();
        try {
            final ChannelHandlerContext lllllllllllllIllIIlIIllIllIIllIl = PipelineUtil.getPreviousContext(Via.getManager().getInjector().getDecoderName(), this.channel.pipeline());
            if (this.shouldTransformPacket()) {
                try {
                    Type.VAR_INT.writePrimitive(lllllllllllllIllIIlIIllIllIIlIII, 1000);
                    Type.UUID.write(lllllllllllllIllIIlIIllIllIIlIII, this.generatePassthroughToken());
                }
                catch (Exception lllllllllllllIllIIlIIllIllIIllll) {
                    throw new RuntimeException(lllllllllllllIllIIlIIllIllIIllll);
                }
            }
            lllllllllllllIllIIlIIllIllIIlIII.writeBytes(lllllllllllllIllIIlIIllIllIIlIlI);
            final ChannelHandlerContext channelHandlerContext;
            final Object o;
            final Runnable lllllllllllllIllIIlIIllIllIIllII = () -> {
                if (channelHandlerContext != null) {
                    channelHandlerContext.fireChannelRead(o);
                }
                else {
                    this.channel.pipeline().fireChannelRead(o);
                }
                return;
            };
            if (lllllllllllllIllIIlIIllIllIIIlIl) {
                lllllllllllllIllIIlIIllIllIIllII.run();
            }
            else {
                try {
                    this.channel.eventLoop().submit(lllllllllllllIllIIlIIllIllIIllII);
                }
                catch (Throwable lllllllllllllIllIIlIIllIllIIlllI) {
                    lllllllllllllIllIIlIIllIllIIlIII.release();
                    throw lllllllllllllIllIIlIIllIllIIlllI;
                }
            }
        }
        finally {
            lllllllllllllIllIIlIIllIllIIlIlI.release();
        }
    }
    
    @Override
    public PacketTracker getPacketTracker() {
        return this.packetTracker;
    }
    
    @Override
    public void sendRawPacketToServer(final ByteBuf lllllllllllllIllIIlIIllIllIllllI) {
        if (this.clientSide) {
            this.sendRawPacketToServerClientSide(lllllllllllllIllIIlIIllIllIllllI, true);
        }
        else {
            this.sendRawPacketToServerServerSide(lllllllllllllIllIIlIIllIllIllllI, true);
        }
    }
    
    @Override
    public boolean isPendingDisconnect() {
        return this.pendingDisconnect;
    }
    
    private void sendRawPacketToServerClientSide(final ByteBuf lllllllllllllIllIIlIIllIlIlllIII, final boolean lllllllllllllIllIIlIIllIlIllIlll) {
        final Runnable lllllllllllllIllIIlIIllIlIllIllI = () -> this.getChannel().pipeline().context(Via.getManager().getInjector().getEncoderName()).writeAndFlush((Object)lllllllllllllIllIIlIIllIlIlllIII);
        if (lllllllllllllIllIIlIIllIlIllIlll) {
            lllllllllllllIllIIlIIllIlIllIllI.run();
        }
        else {
            try {
                this.getChannel().eventLoop().submit(lllllllllllllIllIIlIIllIlIllIllI);
            }
            catch (Throwable lllllllllllllIllIIlIIllIlIlllIlI) {
                lllllllllllllIllIIlIIllIlIlllIlI.printStackTrace();
                lllllllllllllIllIIlIIllIlIlllIII.release();
            }
        }
    }
    
    @Override
    public void scheduleSendRawPacket(final ByteBuf lllllllllllllIllIIlIIlllIIIIIIll) {
        this.sendRawPacket(lllllllllllllIllIIlIIlllIIIIIIll, false);
    }
    
    static {
        IDS = new AtomicLong();
    }
    
    @Override
    public int hashCode() {
        return Long.hashCode(this.id);
    }
    
    @Override
    public boolean shouldApplyBlockProtocol() {
        return !this.clientSide;
    }
    
    @Override
    public void setActive(final boolean lllllllllllllIllIIlIIllIIllIlIll) {
        this.active = lllllllllllllIllIIlIIllIIllIlIll;
    }
    
    @Override
    public Map<Class<?>, StorableObject> getStoredObjects() {
        return this.storedObjects;
    }
    
    @Override
    public boolean has(final Class<? extends StorableObject> lllllllllllllIllIIlIIlllIIlIllII) {
        return this.storedObjects.containsKey(lllllllllllllIllIIlIIlllIIlIllII);
    }
    
    @Override
    public boolean shouldTransformPacket() {
        return this.active;
    }
    
    @Override
    public void scheduleSendRawPacketToServer(final ByteBuf lllllllllllllIllIIlIIllIllIllIlI) {
        if (this.clientSide) {
            this.sendRawPacketToServerClientSide(lllllllllllllIllIIlIIllIllIllIlI, false);
        }
        else {
            this.sendRawPacketToServerServerSide(lllllllllllllIllIIlIIllIllIllIlI, false);
        }
    }
    
    @Override
    public long getId() {
        return this.id;
    }
    
    private void sendRawPacket(final ByteBuf lllllllllllllIllIIlIIllIlllllIlI, final boolean lllllllllllllIllIIlIIllIllllIlIl) {
        Runnable lllllllllllllIllIIlIIllIlllllIII = null;
        if (this.clientSide) {
            final Runnable lllllllllllllIllIIlIIllIllllllIl = () -> this.getChannel().pipeline().context(Via.getManager().getInjector().getDecoderName()).fireChannelRead((Object)lllllllllllllIllIIlIIllIlllllIlI);
        }
        else {
            lllllllllllllIllIIlIIllIlllllIII = (() -> this.channel.pipeline().context(Via.getManager().getInjector().getEncoderName()).writeAndFlush((Object)lllllllllllllIllIIlIIllIlllllIlI));
        }
        if (lllllllllllllIllIIlIIllIllllIlIl) {
            lllllllllllllIllIIlIIllIlllllIII.run();
        }
        else {
            try {
                this.channel.eventLoop().submit(lllllllllllllIllIIlIIllIlllllIII);
            }
            catch (Throwable lllllllllllllIllIIlIIllIllllllII) {
                lllllllllllllIllIIlIIllIlllllIlI.release();
                lllllllllllllIllIIlIIllIllllllII.printStackTrace();
            }
        }
    }
}
