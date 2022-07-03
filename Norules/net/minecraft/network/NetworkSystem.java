package net.minecraft.network;

import io.netty.channel.local.*;
import io.netty.channel.nio.*;
import net.minecraft.server.*;
import io.netty.channel.epoll.*;
import io.netty.channel.socket.nio.*;
import io.netty.bootstrap.*;
import io.netty.handler.timeout.*;
import net.minecraft.server.network.*;
import io.netty.channel.*;
import io.netty.channel.socket.*;
import java.io.*;
import java.net.*;
import net.minecraft.util.*;
import net.minecraft.network.play.server.*;
import net.minecraft.util.text.*;
import io.netty.util.concurrent.*;
import net.minecraft.crash.*;
import org.apache.logging.log4j.*;
import com.google.common.util.concurrent.*;
import com.google.common.collect.*;
import java.util.*;

public class NetworkSystem
{
    private static final /* synthetic */ Logger LOGGER;
    public volatile /* synthetic */ boolean isAlive;
    public static final /* synthetic */ LazyLoadBase<EpollEventLoopGroup> SERVER_EPOLL_EVENTLOOP;
    private final /* synthetic */ List<ChannelFuture> endpoints;
    public static final /* synthetic */ LazyLoadBase<NioEventLoopGroup> SERVER_NIO_EVENTLOOP;
    private final /* synthetic */ MinecraftServer mcServer;
    private final /* synthetic */ List<NetworkManager> networkManagers;
    
    public void addLanEndpoint(final InetAddress lllllllllllllIlllllIIIIIIlIIlIIl, final int lllllllllllllIlllllIIIIIIlIIllll) throws IOException {
        synchronized (this.endpoints) {
            Class<? extends ServerSocketChannel> lllllllllllllIlllllIIIIIIlIIllIl = null;
            LazyLoadBase<? extends EventLoopGroup> lllllllllllllIlllllIIIIIIlIIlIll = null;
            if (Epoll.isAvailable() && this.mcServer.shouldUseNativeTransport()) {
                final Class<? extends ServerSocketChannel> lllllllllllllIlllllIIIIIIlIIlllI = (Class<? extends ServerSocketChannel>)EpollServerSocketChannel.class;
                final LazyLoadBase<? extends EventLoopGroup> lllllllllllllIlllllIIIIIIlIIllII = (LazyLoadBase<? extends EventLoopGroup>)NetworkSystem.SERVER_EPOLL_EVENTLOOP;
                NetworkSystem.LOGGER.info("Using epoll channel type");
            }
            else {
                lllllllllllllIlllllIIIIIIlIIllIl = (Class<? extends ServerSocketChannel>)NioServerSocketChannel.class;
                lllllllllllllIlllllIIIIIIlIIlIll = (LazyLoadBase<? extends EventLoopGroup>)NetworkSystem.SERVER_NIO_EVENTLOOP;
                NetworkSystem.LOGGER.info("Using default channel type");
            }
            this.endpoints.add(((ServerBootstrap)((ServerBootstrap)new ServerBootstrap().channel((Class)lllllllllllllIlllllIIIIIIlIIllIl)).childHandler((ChannelHandler)new ChannelInitializer<Channel>() {
                protected void initChannel(final Channel lllllllllllllIlIIlIIlIIlIIllllII) throws Exception {
                    try {
                        lllllllllllllIlIIlIIlIIlIIllllII.config().setOption(ChannelOption.TCP_NODELAY, (Object)true);
                    }
                    catch (ChannelException ex) {}
                    lllllllllllllIlIIlIIlIIlIIllllII.pipeline().addLast("timeout", (ChannelHandler)new ReadTimeoutHandler(30)).addLast("legacy_query", (ChannelHandler)new LegacyPingHandler(NetworkSystem.this)).addLast("splitter", (ChannelHandler)new NettyVarint21FrameDecoder()).addLast("decoder", (ChannelHandler)new NettyPacketDecoder(EnumPacketDirection.SERVERBOUND)).addLast("prepender", (ChannelHandler)new NettyVarint21FrameEncoder()).addLast("encoder", (ChannelHandler)new NettyPacketEncoder(EnumPacketDirection.CLIENTBOUND));
                    final NetworkManager lllllllllllllIlIIlIIlIIlIIlllIll = new NetworkManager(EnumPacketDirection.SERVERBOUND);
                    NetworkSystem.this.networkManagers.add(lllllllllllllIlIIlIIlIIlIIlllIll);
                    lllllllllllllIlIIlIIlIIlIIllllII.pipeline().addLast("packet_handler", (ChannelHandler)lllllllllllllIlIIlIIlIIlIIlllIll);
                    lllllllllllllIlIIlIIlIIlIIlllIll.setNetHandler(new NetHandlerHandshakeTCP(NetworkSystem.this.mcServer, lllllllllllllIlIIlIIlIIlIIlllIll));
                }
            }).group((EventLoopGroup)lllllllllllllIlllllIIIIIIlIIlIll.getValue()).localAddress(lllllllllllllIlllllIIIIIIlIIlIIl, lllllllllllllIlllllIIIIIIlIIllll)).bind().syncUninterruptibly());
        }
        // monitorexit(this.endpoints)
    }
    
    public SocketAddress addLocalEndpoint() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        net/minecraft/network/NetworkSystem.endpoints:Ljava/util/List;
        //     4: dup            
        //     5: astore_2        /* lllllllllllllIlllllIIIIIIIllllII */
        //     6: monitorenter   
        //     7: new             Lio/netty/bootstrap/ServerBootstrap;
        //    10: dup            
        //    11: invokespecial   io/netty/bootstrap/ServerBootstrap.<init>:()V
        //    14: ldc             Lio/netty/channel/local/LocalServerChannel;.class
        //    16: invokevirtual   io/netty/bootstrap/ServerBootstrap.channel:(Ljava/lang/Class;)Lio/netty/bootstrap/AbstractBootstrap;
        //    19: checkcast       Lio/netty/bootstrap/ServerBootstrap;
        //    22: new             Lnet/minecraft/network/NetworkSystem$5;
        //    25: dup            
        //    26: aload_0         /* lllllllllllllIlllllIIIIIIlIIIIIl */
        //    27: invokespecial   net/minecraft/network/NetworkSystem$5.<init>:(Lnet/minecraft/network/NetworkSystem;)V
        //    30: invokevirtual   io/netty/bootstrap/ServerBootstrap.childHandler:(Lio/netty/channel/ChannelHandler;)Lio/netty/bootstrap/ServerBootstrap;
        //    33: getstatic       net/minecraft/network/NetworkSystem.SERVER_NIO_EVENTLOOP:Lnet/minecraft/util/LazyLoadBase;
        //    36: invokevirtual   net/minecraft/util/LazyLoadBase.getValue:()Ljava/lang/Object;
        //    39: checkcast       Lio/netty/channel/EventLoopGroup;
        //    42: invokevirtual   io/netty/bootstrap/ServerBootstrap.group:(Lio/netty/channel/EventLoopGroup;)Lio/netty/bootstrap/ServerBootstrap;
        //    45: getstatic       io/netty/channel/local/LocalAddress.ANY:Lio/netty/channel/local/LocalAddress;
        //    48: invokevirtual   io/netty/bootstrap/ServerBootstrap.localAddress:(Ljava/net/SocketAddress;)Lio/netty/bootstrap/AbstractBootstrap;
        //    51: checkcast       Lio/netty/bootstrap/ServerBootstrap;
        //    54: invokevirtual   io/netty/bootstrap/ServerBootstrap.bind:()Lio/netty/channel/ChannelFuture;
        //    57: invokeinterface io/netty/channel/ChannelFuture.syncUninterruptibly:()Lio/netty/channel/ChannelFuture;
        //    62: astore_1        /* lllllllllllllIlllllIIIIIIlIIIIII */
        //    63: aload_0         /* lllllllllllllIlllllIIIIIIlIIIIIl */
        //    64: getfield        net/minecraft/network/NetworkSystem.endpoints:Ljava/util/List;
        //    67: aload_1         /* lllllllllllllIlllllIIIIIIlIIIIII */
        //    68: invokeinterface java/util/List.add:(Ljava/lang/Object;)Z
        //    73: pop            
        //    74: aload_2         /* lllllllllllllIlllllIIIIIIIllllII */
        //    75: monitorexit    
        //    76: goto            82
        //    79: aload_2         /* lllllllllllllIlllllIIIIIIIllllII */
        //    80: monitorexit    
        //    81: athrow         
        //    82: aload_1         /* lllllllllllllIlllllIIIIIIIllllll */
        //    83: invokeinterface io/netty/channel/ChannelFuture.channel:()Lio/netty/channel/Channel;
        //    88: invokeinterface io/netty/channel/Channel.localAddress:()Ljava/net/SocketAddress;
        //    93: areturn        
        //    StackMapTable: 00 02 FF 00 4F 00 03 07 00 02 00 07 00 77 00 01 07 00 97 FF 00 02 00 03 07 00 02 07 00 72 07 00 77 00 00
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type
        //  -----  -----  -----  -----  ----
        //  7      76     79     82     Any
        //  79     81     79     82     Any
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public MinecraftServer getServer() {
        return this.mcServer;
    }
    
    public void networkTick() {
        synchronized (this.networkManagers) {
            final Iterator<NetworkManager> lllllllllllllIlllllIIIIIIIlIlIII = this.networkManagers.iterator();
            while (lllllllllllllIlllllIIIIIIIlIlIII.hasNext()) {
                final NetworkManager lllllllllllllIlllllIIIIIIIlIIlll = lllllllllllllIlllllIIIIIIIlIlIII.next();
                if (!lllllllllllllIlllllIIIIIIIlIIlll.hasNoChannel()) {
                    if (lllllllllllllIlllllIIIIIIIlIIlll.isChannelOpen()) {
                        try {
                            lllllllllllllIlllllIIIIIIIlIIlll.processReceivedPackets();
                        }
                        catch (Exception lllllllllllllIlllllIIIIIIIlIIllI) {
                            if (lllllllllllllIlllllIIIIIIIlIIlll.isLocalChannel()) {
                                final CrashReport lllllllllllllIlllllIIIIIIIlIIlIl = CrashReport.makeCrashReport(lllllllllllllIlllllIIIIIIIlIIllI, "Ticking memory connection");
                                final CrashReportCategory lllllllllllllIlllllIIIIIIIlIIlII = lllllllllllllIlllllIIIIIIIlIIlIl.makeCategory("Ticking connection");
                                lllllllllllllIlllllIIIIIIIlIIlII.setDetail("Connection", new ICrashReportDetail<String>() {
                                    @Override
                                    public String call() throws Exception {
                                        return lllllllllllllIlllllIIIIIIIlIIlll.toString();
                                    }
                                });
                                throw new ReportedException(lllllllllllllIlllllIIIIIIIlIIlIl);
                            }
                            NetworkSystem.LOGGER.warn("Failed to handle packet for {}", (Object)lllllllllllllIlllllIIIIIIIlIIlll.getRemoteAddress(), (Object)lllllllllllllIlllllIIIIIIIlIIllI);
                            final TextComponentString lllllllllllllIlllllIIIIIIIlIIIll = new TextComponentString("Internal server error");
                            lllllllllllllIlllllIIIIIIIlIIlll.sendPacket(new SPacketDisconnect(lllllllllllllIlllllIIIIIIIlIIIll), (GenericFutureListener<? extends Future<? super Void>>)new GenericFutureListener<Future<? super Void>>() {
                                public void operationComplete(final Future<? super Void> lllllllllllllIIlIlIlllIIllIlllII) throws Exception {
                                    lllllllllllllIlllllIIIIIIIlIIlll.closeChannel(lllllllllllllIlllllIIIIIIIlIIIll);
                                }
                            }, (GenericFutureListener<? extends Future<? super Void>>[])new GenericFutureListener[0]);
                            lllllllllllllIlllllIIIIIIIlIIlll.disableAutoRead();
                        }
                    }
                    else {
                        lllllllllllllIlllllIIIIIIIlIlIII.remove();
                        lllllllllllllIlllllIIIIIIIlIIlll.checkDisconnected();
                    }
                }
            }
        }
        // monitorexit(this.networkManagers)
    }
    
    static {
        LOGGER = LogManager.getLogger();
        SERVER_NIO_EVENTLOOP = new LazyLoadBase<NioEventLoopGroup>() {
            @Override
            protected NioEventLoopGroup load() {
                return new NioEventLoopGroup(0, new ThreadFactoryBuilder().setNameFormat("Netty Server IO #%d").setDaemon(true).build());
            }
        };
        SERVER_EPOLL_EVENTLOOP = new LazyLoadBase<EpollEventLoopGroup>() {
            @Override
            protected EpollEventLoopGroup load() {
                return new EpollEventLoopGroup(0, new ThreadFactoryBuilder().setNameFormat("Netty Epoll Server IO #%d").setDaemon(true).build());
            }
        };
        SERVER_LOCAL_EVENTLOOP = new LazyLoadBase<LocalEventLoopGroup>() {
            @Override
            protected LocalEventLoopGroup load() {
                return new LocalEventLoopGroup(0, new ThreadFactoryBuilder().setNameFormat("Netty Local Server IO #%d").setDaemon(true).build());
            }
        };
    }
    
    public void terminateEndpoints() {
        this.isAlive = false;
        for (final ChannelFuture lllllllllllllIlllllIIIIIIIllIllI : this.endpoints) {
            try {
                lllllllllllllIlllllIIIIIIIllIllI.channel().close().sync();
            }
            catch (InterruptedException lllllllllllllIlllllIIIIIIIllIlIl) {
                NetworkSystem.LOGGER.error("Interrupted whilst closing channel");
            }
        }
    }
    
    public NetworkSystem(final MinecraftServer lllllllllllllIlllllIIIIIIlIllIlI) {
        this.endpoints = Collections.synchronizedList((List<ChannelFuture>)Lists.newArrayList());
        this.networkManagers = Collections.synchronizedList((List<NetworkManager>)Lists.newArrayList());
        this.mcServer = lllllllllllllIlllllIIIIIIlIllIlI;
        this.isAlive = true;
    }
}
