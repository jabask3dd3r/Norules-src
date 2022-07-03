package net.minecraft.client.network;

import com.google.common.base.*;
import net.minecraft.client.multiplayer.*;
import io.netty.bootstrap.*;
import io.netty.buffer.*;
import io.netty.channel.*;
import io.netty.util.concurrent.*;
import java.nio.charset.*;
import net.minecraft.util.math.*;
import io.netty.channel.socket.nio.*;
import net.minecraft.client.resources.*;
import net.minecraft.network.status.*;
import net.minecraft.client.*;
import net.minecraft.network.status.server.*;
import net.minecraft.util.text.*;
import org.apache.commons.lang3.*;
import com.mojang.authlib.*;
import net.minecraft.network.*;
import net.minecraft.network.handshake.client.*;
import net.minecraft.network.status.client.*;
import java.net.*;
import com.google.common.collect.*;
import java.util.*;
import org.apache.logging.log4j.*;

public class ServerPinger
{
    private static final /* synthetic */ Logger LOGGER;
    private final /* synthetic */ List<NetworkManager> pingDestinations;
    private static final /* synthetic */ Splitter PING_RESPONSE_SPLITTER;
    
    private void tryCompatibilityPing(final ServerData lllllllllllllIIlllIllllIlIIIIlll) {
        final ServerAddress lllllllllllllIIlllIllllIlIIIIllI = ServerAddress.fromString(lllllllllllllIIlllIllllIlIIIIlll.serverIP);
        ((Bootstrap)((Bootstrap)((Bootstrap)new Bootstrap().group((EventLoopGroup)NetworkManager.CLIENT_NIO_EVENTLOOP.getValue())).handler((ChannelHandler)new ChannelInitializer<Channel>() {
            protected void initChannel(final Channel llIlIlIIlIllIll) throws Exception {
                try {
                    llIlIlIIlIllIll.config().setOption(ChannelOption.TCP_NODELAY, (Object)true);
                }
                catch (ChannelException ex) {}
                llIlIlIIlIllIll.pipeline().addLast(new ChannelHandler[] { (ChannelHandler)new SimpleChannelInboundHandler<ByteBuf>() {
                        public void channelActive(final ChannelHandlerContext lllllllllllllllIlllllIllIIlIlIlI) throws Exception {
                            super.channelActive(lllllllllllllllIlllllIllIIlIlIlI);
                            final ByteBuf lllllllllllllllIlllllIllIIlIlIIl = Unpooled.buffer();
                            try {
                                lllllllllllllllIlllllIllIIlIlIIl.writeByte(254);
                                lllllllllllllllIlllllIllIIlIlIIl.writeByte(1);
                                lllllllllllllllIlllllIllIIlIlIIl.writeByte(250);
                                char[] lllllllllllllllIlllllIllIIlIlIII = "MC|PingHost".toCharArray();
                                lllllllllllllllIlllllIllIIlIlIIl.writeShort(lllllllllllllllIlllllIllIIlIlIII.length);
                                String lllllllllllllllIlllllIllIIIllllI;
                                Exception lllllllllllllllIlllllIllIIIlllll = (Exception)((char[])(Object)(lllllllllllllllIlllllIllIIIllllI = (String)(Object)lllllllllllllllIlllllIllIIlIlIII)).length;
                                for (byte lllllllllllllllIlllllIllIIlIIIII = 0; lllllllllllllllIlllllIllIIlIIIII < lllllllllllllllIlllllIllIIIlllll; ++lllllllllllllllIlllllIllIIlIIIII) {
                                    final char lllllllllllllllIlllllIllIIlIIlll = lllllllllllllllIlllllIllIIIllllI[lllllllllllllllIlllllIllIIlIIIII];
                                    lllllllllllllllIlllllIllIIlIlIIl.writeChar((int)lllllllllllllllIlllllIllIIlIIlll);
                                }
                                lllllllllllllllIlllllIllIIlIlIIl.writeShort(7 + 2 * lllllllllllllIIlllIllllIlIIIIllI.getIP().length());
                                lllllllllllllllIlllllIllIIlIlIIl.writeByte(127);
                                lllllllllllllllIlllllIllIIlIlIII = lllllllllllllIIlllIllllIlIIIIllI.getIP().toCharArray();
                                lllllllllllllllIlllllIllIIlIlIIl.writeShort(lllllllllllllllIlllllIllIIlIlIII.length);
                                lllllllllllllllIlllllIllIIIlllll = (Exception)((char[])(Object)(lllllllllllllllIlllllIllIIIllllI = (String)(Object)lllllllllllllllIlllllIllIIlIlIII)).length;
                                for (byte lllllllllllllllIlllllIllIIlIIIII = 0; lllllllllllllllIlllllIllIIlIIIII < lllllllllllllllIlllllIllIIIlllll; ++lllllllllllllllIlllllIllIIlIIIII) {
                                    final char lllllllllllllllIlllllIllIIlIIllI = lllllllllllllllIlllllIllIIIllllI[lllllllllllllllIlllllIllIIlIIIII];
                                    lllllllllllllllIlllllIllIIlIlIIl.writeChar((int)lllllllllllllllIlllllIllIIlIIllI);
                                }
                                lllllllllllllllIlllllIllIIlIlIIl.writeInt(lllllllllllllIIlllIllllIlIIIIllI.getPort());
                                lllllllllllllllIlllllIllIIlIlIlI.channel().writeAndFlush((Object)lllllllllllllllIlllllIllIIlIlIIl).addListener((GenericFutureListener)ChannelFutureListener.CLOSE_ON_FAILURE);
                            }
                            finally {
                                lllllllllllllllIlllllIllIIlIlIIl.release();
                            }
                            lllllllllllllllIlllllIllIIlIlIIl.release();
                        }
                        
                        protected void channelRead0(final ChannelHandlerContext lllllllllllllllIlllllIllIIIlIIII, final ByteBuf lllllllllllllllIlllllIllIIIIIlII) throws Exception {
                            final short lllllllllllllllIlllllIllIIIIlllI = lllllllllllllllIlllllIllIIIIIlII.readUnsignedByte();
                            if (lllllllllllllllIlllllIllIIIIlllI == 255) {
                                final String lllllllllllllllIlllllIllIIIIllIl = new String(lllllllllllllllIlllllIllIIIIIlII.readBytes(lllllllllllllllIlllllIllIIIIIlII.readShort() * 2).array(), StandardCharsets.UTF_16BE);
                                final String[] lllllllllllllllIlllllIllIIIIllII = (String[])Iterables.toArray(ServerPinger.PING_RESPONSE_SPLITTER.split((CharSequence)lllllllllllllllIlllllIllIIIIllIl), (Class)String.class);
                                if ("§1".equals(lllllllllllllllIlllllIllIIIIllII[0])) {
                                    final int lllllllllllllllIlllllIllIIIIlIll = MathHelper.getInt(lllllllllllllllIlllllIllIIIIllII[1], 0);
                                    final String lllllllllllllllIlllllIllIIIIlIlI = lllllllllllllllIlllllIllIIIIllII[2];
                                    final String lllllllllllllllIlllllIllIIIIlIIl = lllllllllllllllIlllllIllIIIIllII[3];
                                    final int lllllllllllllllIlllllIllIIIIlIII = MathHelper.getInt(lllllllllllllllIlllllIllIIIIllII[4], -1);
                                    final int lllllllllllllllIlllllIllIIIIIlll = MathHelper.getInt(lllllllllllllllIlllllIllIIIIllII[5], -1);
                                    lllllllllllllIIlllIllllIlIIIIlll.version = -1;
                                    lllllllllllllIIlllIllllIlIIIIlll.gameVersion = lllllllllllllllIlllllIllIIIIlIlI;
                                    lllllllllllllIIlllIllllIlIIIIlll.serverMOTD = lllllllllllllllIlllllIllIIIIlIIl;
                                    lllllllllllllIIlllIllllIlIIIIlll.populationInfo = String.valueOf(new StringBuilder().append(TextFormatting.GRAY).append(lllllllllllllllIlllllIllIIIIlIII).append(TextFormatting.DARK_GRAY).append("/").append(TextFormatting.GRAY).append(lllllllllllllllIlllllIllIIIIIlll));
                                }
                            }
                            lllllllllllllllIlllllIllIIIlIIII.close();
                        }
                        
                        public void exceptionCaught(final ChannelHandlerContext lllllllllllllllIlllllIlIlllllIIl, final Throwable lllllllllllllllIlllllIlIlllllIII) throws Exception {
                            lllllllllllllllIlllllIlIlllllIIl.close();
                        }
                    } });
            }
        })).channel((Class)NioSocketChannel.class)).connect(lllllllllllllIIlllIllllIlIIIIllI.getIP(), lllllllllllllIIlllIllllIlIIIIllI.getPort());
    }
    
    public void pingPendingNetworks() {
        synchronized (this.pingDestinations) {
            final Iterator<NetworkManager> lllllllllllllIIlllIllllIIlllllIl = this.pingDestinations.iterator();
            while (lllllllllllllIIlllIllllIIlllllIl.hasNext()) {
                final NetworkManager lllllllllllllIIlllIllllIIlllllII = lllllllllllllIIlllIllllIIlllllIl.next();
                if (lllllllllllllIIlllIllllIIlllllII.isChannelOpen()) {
                    lllllllllllllIIlllIllllIIlllllII.processReceivedPackets();
                }
                else {
                    lllllllllllllIIlllIllllIIlllllIl.remove();
                    lllllllllllllIIlllIllllIIlllllII.checkDisconnected();
                }
            }
        }
        // monitorexit(this.pingDestinations)
    }
    
    public void ping(final ServerData lllllllllllllIIlllIllllIlIIlIlII) throws UnknownHostException {
        final ServerAddress lllllllllllllIIlllIllllIlIIlIIll = ServerAddress.fromString(lllllllllllllIIlllIllllIlIIlIlII.serverIP);
        final NetworkManager lllllllllllllIIlllIllllIlIIlIIlI = NetworkManager.createNetworkManagerAndConnect(InetAddress.getByName(lllllllllllllIIlllIllllIlIIlIIll.getIP()), lllllllllllllIIlllIllllIlIIlIIll.getPort(), false);
        this.pingDestinations.add(lllllllllllllIIlllIllllIlIIlIIlI);
        lllllllllllllIIlllIllllIlIIlIlII.serverMOTD = I18n.format("multiplayer.status.pinging", new Object[0]);
        lllllllllllllIIlllIllllIlIIlIlII.pingToServer = -1L;
        lllllllllllllIIlllIllllIlIIlIlII.playerList = null;
        lllllllllllllIIlllIllllIlIIlIIlI.setNetHandler(new INetHandlerStatusClient() {
            private /* synthetic */ boolean receivedStatus;
            private /* synthetic */ boolean successful;
            private /* synthetic */ long pingSentAt;
            
            @Override
            public void onDisconnect(final ITextComponent lllllllllllllIIIIllllllIlIlIIIIl) {
                if (!this.successful) {
                    ServerPinger.LOGGER.error("Can't ping {}: {}", (Object)lllllllllllllIIlllIllllIlIIlIlII.serverIP, (Object)lllllllllllllIIIIllllllIlIlIIIIl.getUnformattedText());
                    lllllllllllllIIlllIllllIlIIlIlII.serverMOTD = String.valueOf(new StringBuilder().append(TextFormatting.DARK_RED).append(I18n.format("multiplayer.status.cannot_connect", new Object[0])));
                    lllllllllllllIIlllIllllIlIIlIlII.populationInfo = "";
                    ServerPinger.this.tryCompatibilityPing(lllllllllllllIIlllIllllIlIIlIlII);
                }
            }
            
            @Override
            public void handlePong(final SPacketPong lllllllllllllIIIIllllllIlIlIllII) {
                final long lllllllllllllIIIIllllllIlIlIlIll = this.pingSentAt;
                final long lllllllllllllIIIIllllllIlIlIlIlI = Minecraft.getSystemTime();
                lllllllllllllIIlllIllllIlIIlIlII.pingToServer = lllllllllllllIIIIllllllIlIlIlIlI - lllllllllllllIIIIllllllIlIlIlIll;
                lllllllllllllIIlllIllllIlIIlIIlI.closeChannel(new TextComponentString("Finished"));
            }
            
            @Override
            public void handleServerInfo(final SPacketServerInfo lllllllllllllIIIIllllllIlIllllIl) {
                if (this.receivedStatus) {
                    lllllllllllllIIlllIllllIlIIlIIlI.closeChannel(new TextComponentTranslation("multiplayer.status.unrequested", new Object[0]));
                }
                else {
                    this.receivedStatus = true;
                    final ServerStatusResponse lllllllllllllIIIIllllllIlIllllII = lllllllllllllIIIIllllllIlIllllIl.getResponse();
                    if (lllllllllllllIIIIllllllIlIllllII.getServerDescription() != null) {
                        lllllllllllllIIlllIllllIlIIlIlII.serverMOTD = lllllllllllllIIIIllllllIlIllllII.getServerDescription().getFormattedText();
                    }
                    else {
                        lllllllllllllIIlllIllllIlIIlIlII.serverMOTD = "";
                    }
                    if (lllllllllllllIIIIllllllIlIllllII.getVersion() != null) {
                        lllllllllllllIIlllIllllIlIIlIlII.gameVersion = lllllllllllllIIIIllllllIlIllllII.getVersion().getName();
                        lllllllllllllIIlllIllllIlIIlIlII.version = lllllllllllllIIIIllllllIlIllllII.getVersion().getProtocol();
                    }
                    else {
                        lllllllllllllIIlllIllllIlIIlIlII.gameVersion = I18n.format("multiplayer.status.old", new Object[0]);
                        lllllllllllllIIlllIllllIlIIlIlII.version = 0;
                    }
                    if (lllllllllllllIIIIllllllIlIllllII.getPlayers() != null) {
                        lllllllllllllIIlllIllllIlIIlIlII.populationInfo = String.valueOf(new StringBuilder().append(TextFormatting.GRAY).append(lllllllllllllIIIIllllllIlIllllII.getPlayers().getOnlinePlayerCount()).append(TextFormatting.DARK_GRAY).append("/").append(TextFormatting.GRAY).append(lllllllllllllIIIIllllllIlIllllII.getPlayers().getMaxPlayers()));
                        if (ArrayUtils.isNotEmpty((Object[])lllllllllllllIIIIllllllIlIllllII.getPlayers().getPlayers())) {
                            final StringBuilder lllllllllllllIIIIllllllIlIlllIll = new StringBuilder();
                            final byte lllllllllllllIIIIllllllIlIllIIIl;
                            final char lllllllllllllIIIIllllllIlIllIIlI = (char)((GameProfile[])(Object)(lllllllllllllIIIIllllllIlIllIIIl = (byte)(Object)lllllllllllllIIIIllllllIlIllllII.getPlayers().getPlayers())).length;
                            for (byte lllllllllllllIIIIllllllIlIllIIll = 0; lllllllllllllIIIIllllllIlIllIIll < lllllllllllllIIIIllllllIlIllIIlI; ++lllllllllllllIIIIllllllIlIllIIll) {
                                final GameProfile lllllllllllllIIIIllllllIlIlllIlI = lllllllllllllIIIIllllllIlIllIIIl[lllllllllllllIIIIllllllIlIllIIll];
                                if (lllllllllllllIIIIllllllIlIlllIll.length() > 0) {
                                    lllllllllllllIIIIllllllIlIlllIll.append("\n");
                                }
                                lllllllllllllIIIIllllllIlIlllIll.append(lllllllllllllIIIIllllllIlIlllIlI.getName());
                            }
                            if (lllllllllllllIIIIllllllIlIllllII.getPlayers().getPlayers().length < lllllllllllllIIIIllllllIlIllllII.getPlayers().getOnlinePlayerCount()) {
                                if (lllllllllllllIIIIllllllIlIlllIll.length() > 0) {
                                    lllllllllllllIIIIllllllIlIlllIll.append("\n");
                                }
                                lllllllllllllIIIIllllllIlIlllIll.append(I18n.format("multiplayer.status.and_more", lllllllllllllIIIIllllllIlIllllII.getPlayers().getOnlinePlayerCount() - lllllllllllllIIIIllllllIlIllllII.getPlayers().getPlayers().length));
                            }
                            lllllllllllllIIlllIllllIlIIlIlII.playerList = String.valueOf(lllllllllllllIIIIllllllIlIlllIll);
                        }
                    }
                    else {
                        lllllllllllllIIlllIllllIlIIlIlII.populationInfo = String.valueOf(new StringBuilder().append(TextFormatting.DARK_GRAY).append(I18n.format("multiplayer.status.unknown", new Object[0])));
                    }
                    if (lllllllllllllIIIIllllllIlIllllII.getFavicon() != null) {
                        final String lllllllllllllIIIIllllllIlIlllIIl = lllllllllllllIIIIllllllIlIllllII.getFavicon();
                        if (lllllllllllllIIIIllllllIlIlllIIl.startsWith("data:image/png;base64,")) {
                            lllllllllllllIIlllIllllIlIIlIlII.setBase64EncodedIconData(lllllllllllllIIIIllllllIlIlllIIl.substring("data:image/png;base64,".length()));
                        }
                        else {
                            ServerPinger.LOGGER.error("Invalid server icon (unknown format)");
                        }
                    }
                    else {
                        lllllllllllllIIlllIllllIlIIlIlII.setBase64EncodedIconData(null);
                    }
                    this.pingSentAt = Minecraft.getSystemTime();
                    lllllllllllllIIlllIllllIlIIlIIlI.sendPacket(new CPacketPing(this.pingSentAt));
                    this.successful = true;
                }
            }
        });
        try {
            lllllllllllllIIlllIllllIlIIlIIlI.sendPacket(new C00Handshake(lllllllllllllIIlllIllllIlIIlIIll.getIP(), lllllllllllllIIlllIllllIlIIlIIll.getPort(), EnumConnectionState.STATUS));
            lllllllllllllIIlllIllllIlIIlIIlI.sendPacket(new CPacketServerQuery());
        }
        catch (Throwable lllllllllllllIIlllIllllIlIIlIIIl) {
            ServerPinger.LOGGER.error((Object)lllllllllllllIIlllIllllIlIIlIIIl);
        }
    }
    
    public ServerPinger() {
        this.pingDestinations = Collections.synchronizedList((List<NetworkManager>)Lists.newArrayList());
    }
    
    public void clearPendingNetworks() {
        synchronized (this.pingDestinations) {
            final Iterator<NetworkManager> lllllllllllllIIlllIllllIIlllIIlI = this.pingDestinations.iterator();
            while (lllllllllllllIIlllIllllIIlllIIlI.hasNext()) {
                final NetworkManager lllllllllllllIIlllIllllIIlllIIIl = lllllllllllllIIlllIllllIIlllIIlI.next();
                if (lllllllllllllIIlllIllllIIlllIIIl.isChannelOpen()) {
                    lllllllllllllIIlllIllllIIlllIIlI.remove();
                    lllllllllllllIIlllIllllIIlllIIIl.closeChannel(new TextComponentTranslation("multiplayer.status.cancelled", new Object[0]));
                }
            }
        }
        // monitorexit(this.pingDestinations)
    }
    
    static {
        PING_RESPONSE_SPLITTER = Splitter.on('\0').limit(6);
        LOGGER = LogManager.getLogger();
    }
}
