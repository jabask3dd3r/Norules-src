package net.minecraft.network;

import io.netty.util.*;
import java.util.*;
import java.util.concurrent.locks.*;
import io.netty.channel.nio.*;
import org.apache.logging.log4j.*;
import com.google.common.util.concurrent.*;
import io.netty.channel.local.*;
import net.minecraft.util.text.*;
import io.netty.util.concurrent.*;
import javax.annotation.*;
import com.google.common.collect.*;
import io.netty.bootstrap.*;
import ViaMCP.minecraft.viamcp1_12.utils.*;
import org.apache.commons.lang3.*;
import javax.crypto.*;
import net.minecraft.util.*;
import java.security.*;
import java.net.*;
import io.netty.channel.epoll.*;
import io.netty.channel.socket.nio.*;
import io.netty.channel.*;
import io.netty.handler.timeout.*;
import io.netty.channel.socket.*;
import ViaMCP.minecraft.viamcp1_12.*;
import com.viaversion.viaversion.connection.*;
import com.viaversion.viaversion.protocol.*;
import ViaMCP.minecraft.viamcp1_12.handler.*;
import com.viaversion.viaversion.api.connection.*;
import me.nrules.event.events.*;

public class NetworkManager extends SimpleChannelInboundHandler<Packet<?>>
{
    private /* synthetic */ boolean isEncrypted;
    public static final /* synthetic */ LazyLoadBase<EpollEventLoopGroup> CLIENT_EPOLL_EVENTLOOP;
    private /* synthetic */ Channel channel;
    public static final /* synthetic */ AttributeKey<EnumConnectionState> PROTOCOL_ATTRIBUTE_KEY;
    private final /* synthetic */ Queue<InboundHandlerTuplePacketListener> outboundPacketsQueue;
    private /* synthetic */ INetHandler packetListener;
    private final /* synthetic */ ReentrantReadWriteLock readWriteLock;
    private static final /* synthetic */ Logger LOGGER;
    private /* synthetic */ SocketAddress socketAddress;
    public static final /* synthetic */ LazyLoadBase<LocalEventLoopGroup> CLIENT_LOCAL_EVENTLOOP;
    private /* synthetic */ boolean disconnected;
    private /* synthetic */ ITextComponent terminationReason;
    private final /* synthetic */ EnumPacketDirection direction;
    public static final /* synthetic */ LazyLoadBase<NioEventLoopGroup> CLIENT_NIO_EVENTLOOP;
    public static final /* synthetic */ Marker NETWORK_MARKER;
    
    public boolean hasNoChannel() {
        return this.channel == null;
    }
    
    static {
        LOGGER = LogManager.getLogger();
        NETWORK_MARKER = MarkerManager.getMarker("NETWORK");
        NETWORK_PACKETS_MARKER = MarkerManager.getMarker("NETWORK_PACKETS", NetworkManager.NETWORK_MARKER);
        PROTOCOL_ATTRIBUTE_KEY = AttributeKey.valueOf("protocol");
        CLIENT_NIO_EVENTLOOP = new LazyLoadBase<NioEventLoopGroup>() {
            @Override
            protected NioEventLoopGroup load() {
                return new NioEventLoopGroup(0, new ThreadFactoryBuilder().setNameFormat("Netty Client IO #%d").setDaemon(true).build());
            }
        };
        CLIENT_EPOLL_EVENTLOOP = new LazyLoadBase<EpollEventLoopGroup>() {
            @Override
            protected EpollEventLoopGroup load() {
                return new EpollEventLoopGroup(0, new ThreadFactoryBuilder().setNameFormat("Netty Epoll Client IO #%d").setDaemon(true).build());
            }
        };
        CLIENT_LOCAL_EVENTLOOP = new LazyLoadBase<LocalEventLoopGroup>() {
            @Override
            protected LocalEventLoopGroup load() {
                return new LocalEventLoopGroup(0, new ThreadFactoryBuilder().setNameFormat("Netty Local Client IO #%d").setDaemon(true).build());
            }
        };
    }
    
    public boolean isLocalChannel() {
        return this.channel instanceof LocalChannel || this.channel instanceof LocalServerChannel;
    }
    
    public void processReceivedPackets() {
        this.flushOutboundQueue();
        if (this.packetListener instanceof ITickable) {
            ((ITickable)this.packetListener).update();
        }
        if (this.channel != null) {
            this.channel.flush();
        }
    }
    
    public boolean isEncrypted() {
        return this.isEncrypted;
    }
    
    public void exceptionCaught(final ChannelHandlerContext llllllllllllllIIIIllllIIIllIlIlI, final Throwable llllllllllllllIIIIllllIIIllIIlIl) throws Exception {
        TextComponentTranslation llllllllllllllIIIIllllIIIllIIlll = null;
        if (llllllllllllllIIIIllllIIIllIIlIl instanceof TimeoutException) {
            final TextComponentTranslation llllllllllllllIIIIllllIIIllIlIII = new TextComponentTranslation("disconnect.timeout", new Object[0]);
        }
        else {
            llllllllllllllIIIIllllIIIllIIlll = new TextComponentTranslation("disconnect.genericReason", new Object[] { String.valueOf(new StringBuilder("Internal Exception: ").append(llllllllllllllIIIIllllIIIllIIlIl)) });
        }
        NetworkManager.LOGGER.debug(llllllllllllllIIIIllllIIIllIIlll.getUnformattedText(), llllllllllllllIIIIllllIIIllIIlIl);
        this.closeChannel(llllllllllllllIIIIllllIIIllIIlll);
    }
    
    private void dispatchPacket(final Packet<?> llllllllllllllIIIIllllIIIIllIIll, @Nullable final GenericFutureListener<? extends Future<? super Void>>[] llllllllllllllIIIIllllIIIIllIIlI) {
        final EnumConnectionState llllllllllllllIIIIllllIIIIllIIIl = EnumConnectionState.getFromPacket(llllllllllllllIIIIllllIIIIllIIll);
        final EnumConnectionState llllllllllllllIIIIllllIIIIllIIII = (EnumConnectionState)this.channel.attr((AttributeKey)NetworkManager.PROTOCOL_ATTRIBUTE_KEY).get();
        if (llllllllllllllIIIIllllIIIIllIIII != llllllllllllllIIIIllllIIIIllIIIl) {
            NetworkManager.LOGGER.debug("Disabled auto read");
            this.channel.config().setAutoRead(false);
        }
        if (this.channel.eventLoop().inEventLoop()) {
            if (llllllllllllllIIIIllllIIIIllIIIl != llllllllllllllIIIIllllIIIIllIIII) {
                this.setConnectionState(llllllllllllllIIIIllllIIIIllIIIl);
            }
            final ChannelFuture llllllllllllllIIIIllllIIIIlIllll = this.channel.writeAndFlush((Object)llllllllllllllIIIIllllIIIIllIIll);
            if (llllllllllllllIIIIllllIIIIllIIlI != null) {
                llllllllllllllIIIIllllIIIIlIllll.addListeners((GenericFutureListener[])llllllllllllllIIIIllllIIIIllIIlI);
            }
            llllllllllllllIIIIllllIIIIlIllll.addListener((GenericFutureListener)ChannelFutureListener.FIRE_EXCEPTION_ON_FAILURE);
        }
        else {
            this.channel.eventLoop().execute((Runnable)new Runnable() {
                @Override
                public void run() {
                    if (llllllllllllllIIIIllllIIIIllIIIl != llllllllllllllIIIIllllIIIIllIIII) {
                        NetworkManager.this.setConnectionState(llllllllllllllIIIIllllIIIIllIIIl);
                    }
                    final ChannelFuture lllllllllllllIlllIlIlIIIIllllIIl = NetworkManager.this.channel.writeAndFlush((Object)llllllllllllllIIIIllllIIIIllIIll);
                    if (llllllllllllllIIIIllllIIIIllIIlI != null) {
                        lllllllllllllIlllIlIlIIIIllllIIl.addListeners(llllllllllllllIIIIllllIIIIllIIlI);
                    }
                    lllllllllllllIlllIlIlIIIIllllIIl.addListener((GenericFutureListener)ChannelFutureListener.FIRE_EXCEPTION_ON_FAILURE);
                }
            });
        }
    }
    
    public SocketAddress getRemoteAddress() {
        return this.socketAddress;
    }
    
    public void setConnectionState(final EnumConnectionState llllllllllllllIIIIllllIIIlllIIll) {
        this.channel.attr((AttributeKey)NetworkManager.PROTOCOL_ATTRIBUTE_KEY).set((Object)llllllllllllllIIIIllllIIIlllIIll);
        this.channel.config().setAutoRead(true);
        NetworkManager.LOGGER.debug("Enabled auto read");
    }
    
    public void setNetHandler(final INetHandler llllllllllllllIIIIllllIIIlIlIlII) {
        Validate.notNull((Object)llllllllllllllIIIIllllIIIlIlIlII, "packetListener", new Object[0]);
        NetworkManager.LOGGER.debug("Set listener of {} to {}", (Object)this, (Object)llllllllllllllIIIIllllIIIlIlIlII);
        this.packetListener = llllllllllllllIIIIllllIIIlIlIlII;
    }
    
    public void channelInactive(final ChannelHandlerContext llllllllllllllIIIIllllIIIlllIIII) throws Exception {
        this.closeChannel(new TextComponentTranslation("disconnect.endOfStream", new Object[0]));
    }
    
    public NetworkManager(final EnumPacketDirection llllllllllllllIIIIllllIIlIIIIIlI) {
        this.outboundPacketsQueue = (Queue<InboundHandlerTuplePacketListener>)Queues.newConcurrentLinkedQueue();
        this.readWriteLock = new ReentrantReadWriteLock();
        this.direction = llllllllllllllIIIIllllIIlIIIIIlI;
    }
    
    public void sendPacket(final Packet<?> llllllllllllllIIIIllllIIIlIIlllI) {
        final EventSendPacket llllllllllllllIIIIllllIIIlIIllIl = new EventSendPacket(llllllllllllllIIIIllllIIIlIIlllI);
        llllllllllllllIIIIllllIIIlIIllIl.call();
        if (llllllllllllllIIIIllllIIIlIIllIl.isCancelled()) {
            return;
        }
        if (this.isChannelOpen()) {
            this.flushOutboundQueue();
            this.dispatchPacket(llllllllllllllIIIIllllIIIlIIlllI, null);
        }
        else {
            this.readWriteLock.writeLock().lock();
            try {
                this.outboundPacketsQueue.add(new InboundHandlerTuplePacketListener(llllllllllllllIIIIllllIIIlIIlllI, (GenericFutureListener<? extends Future<? super Void>>[])new GenericFutureListener[0]));
            }
            finally {
                this.readWriteLock.writeLock().unlock();
            }
            this.readWriteLock.writeLock().unlock();
        }
    }
    
    public static NetworkManager provideLocalClient(final SocketAddress llllllllllllllIIIIlllIlllllllIll) {
        final NetworkManager llllllllllllllIIIIlllIlllllllIlI = new NetworkManager(EnumPacketDirection.CLIENTBOUND);
        ((Bootstrap)((Bootstrap)((Bootstrap)new Bootstrap().group((EventLoopGroup)NetworkManager.CLIENT_LOCAL_EVENTLOOP.getValue())).handler((ChannelHandler)new ChannelInitializer<Channel>() {
            protected void initChannel(final Channel lllllllllllllIIlIIlIIlIlllIlllII) throws Exception {
                lllllllllllllIIlIIlIIlIlllIlllII.pipeline().addLast("packet_handler", (ChannelHandler)llllllllllllllIIIIlllIlllllllIlI);
            }
        })).channel((Class)LocalChannel.class)).connect(llllllllllllllIIIIlllIlllllllIll).syncUninterruptibly();
        return llllllllllllllIIIIlllIlllllllIlI;
    }
    
    public ITextComponent getExitMessage() {
        return this.terminationReason;
    }
    
    public void setCompressionThreshold(final int llllllllllllllIIIIlllIllllIllIlI) {
        if (llllllllllllllIIIIlllIllllIllIlI >= 0) {
            if (this.channel.pipeline().get("decompress") instanceof NettyCompressionDecoder) {
                ((NettyCompressionDecoder)this.channel.pipeline().get("decompress")).setCompressionThreshold(llllllllllllllIIIIlllIllllIllIlI);
            }
            else {
                NettyUtil.decodeEncodePlacement(this.channel.pipeline(), "decoder", "decompress", (ChannelHandler)new NettyCompressionDecoder(llllllllllllllIIIIlllIllllIllIlI));
            }
            if (this.channel.pipeline().get("compress") instanceof NettyCompressionEncoder) {
                ((NettyCompressionEncoder)this.channel.pipeline().get("compress")).setCompressionThreshold(llllllllllllllIIIIlllIllllIllIlI);
            }
            else {
                NettyUtil.decodeEncodePlacement(this.channel.pipeline(), "encoder", "compress", (ChannelHandler)new NettyCompressionEncoder(llllllllllllllIIIIlllIllllIllIlI));
            }
        }
        else {
            if (this.channel.pipeline().get("decompress") instanceof NettyCompressionDecoder) {
                this.channel.pipeline().remove("decompress");
            }
            if (this.channel.pipeline().get("compress") instanceof NettyCompressionEncoder) {
                this.channel.pipeline().remove("compress");
            }
        }
    }
    
    public boolean isChannelOpen() {
        return this.channel != null && this.channel.isOpen();
    }
    
    public void sendPacket(final Packet<?> llllllllllllllIIIIllllIIIlIIIIlI, final GenericFutureListener<? extends Future<? super Void>> llllllllllllllIIIIllllIIIlIIIIIl, final GenericFutureListener<? extends Future<? super Void>>... llllllllllllllIIIIllllIIIlIIIIII) {
        if (this.isChannelOpen()) {
            this.flushOutboundQueue();
            this.dispatchPacket(llllllllllllllIIIIllllIIIlIIIIlI, (GenericFutureListener<? extends Future<? super Void>>[])ArrayUtils.add((Object[])llllllllllllllIIIIllllIIIlIIIIII, 0, (Object)llllllllllllllIIIIllllIIIlIIIIIl));
        }
        else {
            this.readWriteLock.writeLock().lock();
            try {
                this.outboundPacketsQueue.add(new InboundHandlerTuplePacketListener(llllllllllllllIIIIllllIIIlIIIIlI, (GenericFutureListener<? extends Future<? super Void>>[])ArrayUtils.add((Object[])llllllllllllllIIIIllllIIIlIIIIII, 0, (Object)llllllllllllllIIIIllllIIIlIIIIIl)));
            }
            finally {
                this.readWriteLock.writeLock().unlock();
            }
            this.readWriteLock.writeLock().unlock();
        }
    }
    
    private void flushOutboundQueue() {
        if (this.channel != null && this.channel.isOpen()) {
            this.readWriteLock.readLock().lock();
            try {
                while (!this.outboundPacketsQueue.isEmpty()) {
                    final InboundHandlerTuplePacketListener llllllllllllllIIIIllllIIIIlIIlII = this.outboundPacketsQueue.poll();
                    this.dispatchPacket(llllllllllllllIIIIllllIIIIlIIlII.packet, llllllllllllllIIIIllllIIIIlIIlII.futureListeners);
                }
            }
            finally {
                this.readWriteLock.readLock().unlock();
            }
            this.readWriteLock.readLock().unlock();
        }
    }
    
    public void channelActive(final ChannelHandlerContext llllllllllllllIIIIllllIIIlllllIl) throws Exception {
        super.channelActive(llllllllllllllIIIIllllIIIlllllIl);
        this.channel = llllllllllllllIIIIllllIIIlllllIl.channel();
        this.socketAddress = this.channel.remoteAddress();
        try {
            this.setConnectionState(EnumConnectionState.HANDSHAKING);
        }
        catch (Throwable llllllllllllllIIIIllllIIIlllllII) {
            NetworkManager.LOGGER.fatal((Object)llllllllllllllIIIIllllIIIlllllII);
        }
    }
    
    public INetHandler getNetHandler() {
        return this.packetListener;
    }
    
    public void enableEncryption(final SecretKey llllllllllllllIIIIlllIllllllIlII) {
        this.isEncrypted = true;
        this.channel.pipeline().addBefore("splitter", "decrypt", (ChannelHandler)new NettyEncryptingDecoder(CryptManager.createNetCipherInstance(2, llllllllllllllIIIIlllIllllllIlII)));
        this.channel.pipeline().addBefore("prepender", "encrypt", (ChannelHandler)new NettyEncryptingEncoder(CryptManager.createNetCipherInstance(1, llllllllllllllIIIIlllIllllllIlII)));
    }
    
    public void closeChannel(final ITextComponent llllllllllllllIIIIllllIIIIIlIlll) {
        if (this.channel.isOpen()) {
            this.channel.close().awaitUninterruptibly();
            this.terminationReason = llllllllllllllIIIIllllIIIIIlIlll;
        }
    }
    
    public void disableAutoRead() {
        this.channel.config().setAutoRead(false);
    }
    
    public static NetworkManager createNetworkManagerAndConnect(final InetAddress llllllllllllllIIIIllllIIIIIIIIll, final int llllllllllllllIIIIllllIIIIIIIIlI, final boolean llllllllllllllIIIIllllIIIIIIIIIl) {
        final NetworkManager llllllllllllllIIIIllllIIIIIIlIII = new NetworkManager(EnumPacketDirection.CLIENTBOUND);
        Class<? extends SocketChannel> llllllllllllllIIIIllllIIIIIIIllI = null;
        LazyLoadBase<? extends EventLoopGroup> llllllllllllllIIIIllllIIIIIIIlII = null;
        if (Epoll.isAvailable() && llllllllllllllIIIIllllIIIIIIIIIl) {
            final Class<? extends SocketChannel> llllllllllllllIIIIllllIIIIIIIlll = (Class<? extends SocketChannel>)EpollSocketChannel.class;
            final LazyLoadBase<? extends EventLoopGroup> llllllllllllllIIIIllllIIIIIIIlIl = (LazyLoadBase<? extends EventLoopGroup>)NetworkManager.CLIENT_EPOLL_EVENTLOOP;
        }
        else {
            llllllllllllllIIIIllllIIIIIIIllI = (Class<? extends SocketChannel>)NioSocketChannel.class;
            llllllllllllllIIIIllllIIIIIIIlII = (LazyLoadBase<? extends EventLoopGroup>)NetworkManager.CLIENT_NIO_EVENTLOOP;
        }
        ((Bootstrap)((Bootstrap)((Bootstrap)new Bootstrap().group((EventLoopGroup)llllllllllllllIIIIllllIIIIIIIlII.getValue())).handler((ChannelHandler)new ChannelInitializer<Channel>() {
            protected void initChannel(final Channel lllllllllllllIlIlIIIlllIIIlllIII) throws Exception {
                try {
                    lllllllllllllIlIlIIIlllIIIlllIII.config().setOption(ChannelOption.TCP_NODELAY, (Object)true);
                }
                catch (ChannelException ex) {}
                lllllllllllllIlIlIIIlllIIIlllIII.pipeline().addLast("timeout", (ChannelHandler)new ReadTimeoutHandler(30)).addLast("splitter", (ChannelHandler)new NettyVarint21FrameDecoder()).addLast("decoder", (ChannelHandler)new NettyPacketDecoder(EnumPacketDirection.CLIENTBOUND)).addLast("prepender", (ChannelHandler)new NettyVarint21FrameEncoder()).addLast("encoder", (ChannelHandler)new NettyPacketEncoder(EnumPacketDirection.SERVERBOUND)).addLast("packet_handler", (ChannelHandler)llllllllllllllIIIIllllIIIIIIlIII);
                if (lllllllllllllIlIlIIIlllIIIlllIII instanceof SocketChannel && ViaMCP.getInstance().getVersion() != 340) {
                    final UserConnection lllllllllllllIlIlIIIlllIIIlllIlI = new UserConnectionImpl(lllllllllllllIlIlIIIlllIIIlllIII, true);
                    new ProtocolPipelineImpl(lllllllllllllIlIlIIIlllIIIlllIlI);
                    lllllllllllllIlIlIIIlllIIIlllIII.pipeline().addBefore("encoder", "via-encoder", (ChannelHandler)new VREncodeHandler(lllllllllllllIlIlIIIlllIIIlllIlI)).addBefore("decoder", "via-decoder", (ChannelHandler)new VRDecodeHandler(lllllllllllllIlIlIIIlllIIIlllIlI));
                }
            }
        })).channel((Class)llllllllllllllIIIIllllIIIIIIIllI)).connect(llllllllllllllIIIIllllIIIIIIIIll, llllllllllllllIIIIllllIIIIIIIIlI).syncUninterruptibly();
        return llllllllllllllIIIIllllIIIIIIlIII;
    }
    
    protected void channelRead0(final ChannelHandlerContext llllllllllllllIIIIllllIIIlIlllll, final Packet<?> llllllllllllllIIIIllllIIIlIllllI) throws Exception {
        if (this.channel.isOpen()) {
            try {
                final EventReceivePacket llllllllllllllIIIIllllIIIlIlllIl = new EventReceivePacket(llllllllllllllIIIIllllIIIlIllllI);
                llllllllllllllIIIIllllIIIlIlllIl.call();
                if (llllllllllllllIIIIllllIIIlIlllIl.isCancelled()) {
                    return;
                }
                llllllllllllllIIIIllllIIIlIllllI.processPacket(this.packetListener);
            }
            catch (ThreadQuickExitException ex) {}
        }
    }
    
    public void checkDisconnected() {
        if (this.channel != null && !this.channel.isOpen()) {
            if (this.disconnected) {
                NetworkManager.LOGGER.warn("handleDisconnection() called twice");
            }
            else {
                this.disconnected = true;
                if (this.getExitMessage() != null) {
                    this.getNetHandler().onDisconnect(this.getExitMessage());
                }
                else if (this.getNetHandler() != null) {
                    this.getNetHandler().onDisconnect(new TextComponentTranslation("multiplayer.disconnect.generic", new Object[0]));
                }
            }
        }
    }
    
    static class InboundHandlerTuplePacketListener
    {
        private final /* synthetic */ Packet<?> packet;
        private final /* synthetic */ GenericFutureListener<? extends Future<? super Void>>[] futureListeners;
        
        public InboundHandlerTuplePacketListener(final Packet<?> llllllllllllllIlIllIllIIlllIIlII, final GenericFutureListener<? extends Future<? super Void>>... llllllllllllllIlIllIllIIlllIIIII) {
            this.packet = llllllllllllllIlIllIllIIlllIIlII;
            this.futureListeners = llllllllllllllIlIllIllIIlllIIIII;
        }
    }
}
