package net.minecraft.network;

import java.net.*;
import java.nio.charset.*;
import net.minecraft.server.*;
import io.netty.buffer.*;
import io.netty.channel.*;
import io.netty.util.concurrent.*;
import org.apache.logging.log4j.*;

public class LegacyPingHandler extends ChannelInboundHandlerAdapter
{
    private final /* synthetic */ NetworkSystem networkSystem;
    private static final /* synthetic */ Logger LOGGER;
    
    public void channelRead(final ChannelHandlerContext lllllllllllllllllIlIIlIIlIIIIIlI, final Object lllllllllllllllllIlIIlIIlIIIIIIl) throws Exception {
        final ByteBuf lllllllllllllllllIlIIlIIlIIIIIII = (ByteBuf)lllllllllllllllllIlIIlIIlIIIIIIl;
        lllllllllllllllllIlIIlIIlIIIIIII.markReaderIndex();
        boolean lllllllllllllllllIlIIlIIIlllllll = true;
        try {
            if (lllllllllllllllllIlIIlIIlIIIIIII.readUnsignedByte() == 254) {
                final InetSocketAddress lllllllllllllllllIlIIlIIIllllllI = (InetSocketAddress)lllllllllllllllllIlIIlIIlIIIIIlI.channel().remoteAddress();
                final MinecraftServer lllllllllllllllllIlIIlIIIlllllIl = this.networkSystem.getServer();
                final int lllllllllllllllllIlIIlIIIlllllII = lllllllllllllllllIlIIlIIlIIIIIII.readableBytes();
                switch (lllllllllllllllllIlIIlIIIlllllII) {
                    case 0: {
                        LegacyPingHandler.LOGGER.debug("Ping: (<1.3.x) from {}:{}", (Object)lllllllllllllllllIlIIlIIIllllllI.getAddress(), (Object)lllllllllllllllllIlIIlIIIllllllI.getPort());
                        final String lllllllllllllllllIlIIlIIIllllIll = String.format("%s§%d§%d", lllllllllllllllllIlIIlIIIlllllIl.getMOTD(), lllllllllllllllllIlIIlIIIlllllIl.getCurrentPlayerCount(), lllllllllllllllllIlIIlIIIlllllIl.getMaxPlayers());
                        this.writeAndFlush(lllllllllllllllllIlIIlIIlIIIIIlI, this.getStringBuffer(lllllllllllllllllIlIIlIIIllllIll));
                        break;
                    }
                    case 1: {
                        if (lllllllllllllllllIlIIlIIlIIIIIII.readUnsignedByte() != 1) {
                            return;
                        }
                        LegacyPingHandler.LOGGER.debug("Ping: (1.4-1.5.x) from {}:{}", (Object)lllllllllllllllllIlIIlIIIllllllI.getAddress(), (Object)lllllllllllllllllIlIIlIIIllllllI.getPort());
                        final String lllllllllllllllllIlIIlIIIllllIlI = String.format("§1\u0000%d\u0000%s\u0000%s\u0000%d\u0000%d", 127, lllllllllllllllllIlIIlIIIlllllIl.getMinecraftVersion(), lllllllllllllllllIlIIlIIIlllllIl.getMOTD(), lllllllllllllllllIlIIlIIIlllllIl.getCurrentPlayerCount(), lllllllllllllllllIlIIlIIIlllllIl.getMaxPlayers());
                        this.writeAndFlush(lllllllllllllllllIlIIlIIlIIIIIlI, this.getStringBuffer(lllllllllllllllllIlIIlIIIllllIlI));
                        break;
                    }
                    default: {
                        boolean lllllllllllllllllIlIIlIIIllllIIl = lllllllllllllllllIlIIlIIlIIIIIII.readUnsignedByte() == 1;
                        lllllllllllllllllIlIIlIIIllllIIl &= (lllllllllllllllllIlIIlIIlIIIIIII.readUnsignedByte() == 250);
                        lllllllllllllllllIlIIlIIIllllIIl &= "MC|PingHost".equals(new String(lllllllllllllllllIlIIlIIlIIIIIII.readBytes(lllllllllllllllllIlIIlIIlIIIIIII.readShort() * 2).array(), StandardCharsets.UTF_16BE));
                        final int lllllllllllllllllIlIIlIIIllllIII = lllllllllllllllllIlIIlIIlIIIIIII.readUnsignedShort();
                        lllllllllllllllllIlIIlIIIllllIIl &= (lllllllllllllllllIlIIlIIlIIIIIII.readUnsignedByte() >= 73);
                        lllllllllllllllllIlIIlIIIllllIIl &= (3 + lllllllllllllllllIlIIlIIlIIIIIII.readBytes(lllllllllllllllllIlIIlIIlIIIIIII.readShort() * 2).array().length + 4 == lllllllllllllllllIlIIlIIIllllIII);
                        lllllllllllllllllIlIIlIIIllllIIl &= (lllllllllllllllllIlIIlIIlIIIIIII.readInt() <= 65535);
                        lllllllllllllllllIlIIlIIIllllIIl &= (lllllllllllllllllIlIIlIIlIIIIIII.readableBytes() == 0);
                        if (!lllllllllllllllllIlIIlIIIllllIIl) {
                            return;
                        }
                        LegacyPingHandler.LOGGER.debug("Ping: (1.6) from {}:{}", (Object)lllllllllllllllllIlIIlIIIllllllI.getAddress(), (Object)lllllllllllllllllIlIIlIIIllllllI.getPort());
                        final String lllllllllllllllllIlIIlIIIlllIlll = String.format("§1\u0000%d\u0000%s\u0000%s\u0000%d\u0000%d", 127, lllllllllllllllllIlIIlIIIlllllIl.getMinecraftVersion(), lllllllllllllllllIlIIlIIIlllllIl.getMOTD(), lllllllllllllllllIlIIlIIIlllllIl.getCurrentPlayerCount(), lllllllllllllllllIlIIlIIIlllllIl.getMaxPlayers());
                        final ByteBuf lllllllllllllllllIlIIlIIIlllIllI = this.getStringBuffer(lllllllllllllllllIlIIlIIIlllIlll);
                        try {
                            this.writeAndFlush(lllllllllllllllllIlIIlIIlIIIIIlI, lllllllllllllllllIlIIlIIIlllIllI);
                        }
                        finally {
                            lllllllllllllllllIlIIlIIIlllIllI.release();
                        }
                        lllllllllllllllllIlIIlIIIlllIllI.release();
                        break;
                    }
                }
                lllllllllllllllllIlIIlIIlIIIIIII.release();
                lllllllllllllllllIlIIlIIIlllllll = false;
                return;
            }
        }
        catch (RuntimeException lllllllllllllllllIlIIlIIIlllIlIl) {
            return;
        }
        finally {
            if (lllllllllllllllllIlIIlIIIlllllll) {
                lllllllllllllllllIlIIlIIlIIIIIII.resetReaderIndex();
                lllllllllllllllllIlIIlIIlIIIIIlI.channel().pipeline().remove("legacy_query");
                lllllllllllllllllIlIIlIIlIIIIIlI.fireChannelRead(lllllllllllllllllIlIIlIIlIIIIIIl);
            }
        }
        if (lllllllllllllllllIlIIlIIIlllllll) {
            lllllllllllllllllIlIIlIIlIIIIIII.resetReaderIndex();
            lllllllllllllllllIlIIlIIlIIIIIlI.channel().pipeline().remove("legacy_query");
            lllllllllllllllllIlIIlIIlIIIIIlI.fireChannelRead(lllllllllllllllllIlIIlIIlIIIIIIl);
        }
    }
    
    private ByteBuf getStringBuffer(final String lllllllllllllllllIlIIlIIIlIlIIIl) {
        final ByteBuf lllllllllllllllllIlIIlIIIlIlIlII = Unpooled.buffer();
        lllllllllllllllllIlIIlIIIlIlIlII.writeByte(255);
        final char[] lllllllllllllllllIlIIlIIIlIlIIll = lllllllllllllllllIlIIlIIIlIlIIIl.toCharArray();
        lllllllllllllllllIlIIlIIIlIlIlII.writeShort(lllllllllllllllllIlIIlIIIlIlIIll.length);
        boolean lllllllllllllllllIlIIlIIIlIIlIll;
        for (char lllllllllllllllllIlIIlIIIlIIllII = (char)((char[])(Object)(lllllllllllllllllIlIIlIIIlIIlIll = (boolean)(Object)lllllllllllllllllIlIIlIIIlIlIIll)).length, lllllllllllllllllIlIIlIIIlIIllIl = '\0'; lllllllllllllllllIlIIlIIIlIIllIl < lllllllllllllllllIlIIlIIIlIIllII; ++lllllllllllllllllIlIIlIIIlIIllIl) {
            final char lllllllllllllllllIlIIlIIIlIlIIlI = lllllllllllllllllIlIIlIIIlIIlIll[lllllllllllllllllIlIIlIIIlIIllIl];
            lllllllllllllllllIlIIlIIIlIlIlII.writeChar((int)lllllllllllllllllIlIIlIIIlIlIIlI);
        }
        return lllllllllllllllllIlIIlIIIlIlIlII;
    }
    
    public LegacyPingHandler(final NetworkSystem lllllllllllllllllIlIIlIIlIIlIllI) {
        this.networkSystem = lllllllllllllllllIlIIlIIlIIlIllI;
    }
    
    private void writeAndFlush(final ChannelHandlerContext lllllllllllllllllIlIIlIIIlIlllll, final ByteBuf lllllllllllllllllIlIIlIIIlIllllI) {
        lllllllllllllllllIlIIlIIIlIlllll.pipeline().firstContext().writeAndFlush((Object)lllllllllllllllllIlIIlIIIlIllllI).addListener((GenericFutureListener)ChannelFutureListener.CLOSE);
    }
    
    static {
        LOGGER = LogManager.getLogger();
    }
}
