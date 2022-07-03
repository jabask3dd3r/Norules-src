package net.minecraft.network;

import io.netty.handler.codec.*;
import org.apache.logging.log4j.*;
import io.netty.channel.*;
import io.netty.buffer.*;
import java.util.*;
import io.netty.util.*;
import java.io.*;

public class NettyPacketDecoder extends ByteToMessageDecoder
{
    private static final /* synthetic */ Logger LOGGER;
    private final /* synthetic */ EnumPacketDirection direction;
    private static final /* synthetic */ Marker RECEIVED_PACKET_MARKER;
    
    static {
        LOGGER = LogManager.getLogger();
        RECEIVED_PACKET_MARKER = MarkerManager.getMarker("PACKET_RECEIVED", NetworkManager.NETWORK_PACKETS_MARKER);
    }
    
    public NettyPacketDecoder(final EnumPacketDirection lllllllllllllllIlIIIllllIIIIlIll) {
        this.direction = lllllllllllllllIlIIIllllIIIIlIll;
    }
    
    protected void decode(final ChannelHandlerContext lllllllllllllllIlIIIlllIllllllIl, final ByteBuf lllllllllllllllIlIIIlllIllllIlII, final List<Object> lllllllllllllllIlIIIlllIlllllIlI) throws InstantiationException, IOException, IllegalAccessException, Exception {
        if (lllllllllllllllIlIIIlllIllllIlII.readableBytes() != 0) {
            final PacketBuffer lllllllllllllllIlIIIlllIlllllIIl = new PacketBuffer(lllllllllllllllIlIIIlllIllllIlII);
            final int lllllllllllllllIlIIIlllIlllllIII = lllllllllllllllIlIIIlllIlllllIIl.readVarIntFromBuffer();
            final Packet<?> lllllllllllllllIlIIIlllIllllIlll = ((EnumConnectionState)lllllllllllllllIlIIIlllIllllllIl.channel().attr((AttributeKey)NetworkManager.PROTOCOL_ATTRIBUTE_KEY).get()).getPacket(this.direction, lllllllllllllllIlIIIlllIlllllIII);
            if (lllllllllllllllIlIIIlllIllllIlll == null) {
                throw new IOException(String.valueOf(new StringBuilder("Bad packet id ").append(lllllllllllllllIlIIIlllIlllllIII)));
            }
            lllllllllllllllIlIIIlllIllllIlll.readPacketData(lllllllllllllllIlIIIlllIlllllIIl);
            if (lllllllllllllllIlIIIlllIlllllIIl.readableBytes() > 0) {
                throw new IOException(String.valueOf(new StringBuilder("Packet ").append(((EnumConnectionState)lllllllllllllllIlIIIlllIllllllIl.channel().attr((AttributeKey)NetworkManager.PROTOCOL_ATTRIBUTE_KEY).get()).getId()).append("/").append(lllllllllllllllIlIIIlllIlllllIII).append(" (").append(lllllllllllllllIlIIIlllIllllIlll.getClass().getSimpleName()).append(") was larger than I expected, found ").append(lllllllllllllllIlIIIlllIlllllIIl.readableBytes()).append(" bytes extra whilst reading packet ").append(lllllllllllllllIlIIIlllIlllllIII)));
            }
            lllllllllllllllIlIIIlllIlllllIlI.add(lllllllllllllllIlIIIlllIllllIlll);
            if (NettyPacketDecoder.LOGGER.isDebugEnabled()) {
                NettyPacketDecoder.LOGGER.debug(NettyPacketDecoder.RECEIVED_PACKET_MARKER, " IN: [{}:{}] {}", lllllllllllllllIlIIIlllIllllllIl.channel().attr((AttributeKey)NetworkManager.PROTOCOL_ATTRIBUTE_KEY).get(), (Object)lllllllllllllllIlIIIlllIlllllIII, (Object)lllllllllllllllIlIIIlllIllllIlll.getClass().getName());
            }
        }
    }
}
