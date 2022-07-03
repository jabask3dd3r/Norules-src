package net.minecraft.network;

import io.netty.handler.codec.*;
import org.apache.logging.log4j.*;
import io.netty.channel.*;
import io.netty.buffer.*;
import io.netty.util.*;
import java.io.*;

public class NettyPacketEncoder extends MessageToByteEncoder<Packet<?>>
{
    private static final /* synthetic */ Logger LOGGER;
    private final /* synthetic */ EnumPacketDirection direction;
    private static final /* synthetic */ Marker RECEIVED_PACKET_MARKER;
    
    static {
        LOGGER = LogManager.getLogger();
        RECEIVED_PACKET_MARKER = MarkerManager.getMarker("PACKET_SENT", NetworkManager.NETWORK_PACKETS_MARKER);
    }
    
    protected void encode(final ChannelHandlerContext llllllllllllllIlIIIlIIIlIlllllll, final Packet<?> llllllllllllllIlIIIlIIIllIIIlIIl, final ByteBuf llllllllllllllIlIIIlIIIlIlllllIl) throws IOException, Exception {
        final EnumConnectionState llllllllllllllIlIIIlIIIllIIIIlll = (EnumConnectionState)llllllllllllllIlIIIlIIIlIlllllll.channel().attr((AttributeKey)NetworkManager.PROTOCOL_ATTRIBUTE_KEY).get();
        if (llllllllllllllIlIIIlIIIllIIIIlll == null) {
            throw new RuntimeException(String.valueOf(new StringBuilder("ConnectionProtocol unknown: ").append(llllllllllllllIlIIIlIIIllIIIlIIl.toString())));
        }
        final Integer llllllllllllllIlIIIlIIIllIIIIlIl = llllllllllllllIlIIIlIIIllIIIIlll.getPacketId(this.direction, llllllllllllllIlIIIlIIIllIIIlIIl);
        if (NettyPacketEncoder.LOGGER.isDebugEnabled()) {
            NettyPacketEncoder.LOGGER.debug(NettyPacketEncoder.RECEIVED_PACKET_MARKER, "OUT: [{}:{}] {}", llllllllllllllIlIIIlIIIlIlllllll.channel().attr((AttributeKey)NetworkManager.PROTOCOL_ATTRIBUTE_KEY).get(), (Object)llllllllllllllIlIIIlIIIllIIIIlIl, (Object)llllllllllllllIlIIIlIIIllIIIlIIl.getClass().getName());
        }
        if (llllllllllllllIlIIIlIIIllIIIIlIl == null) {
            throw new IOException("Can't serialize unregistered packet");
        }
        final PacketBuffer llllllllllllllIlIIIlIIIllIIIIlII = new PacketBuffer(llllllllllllllIlIIIlIIIlIlllllIl);
        llllllllllllllIlIIIlIIIllIIIIlII.writeVarIntToBuffer(llllllllllllllIlIIIlIIIllIIIIlIl);
        try {
            llllllllllllllIlIIIlIIIllIIIlIIl.writePacketData(llllllllllllllIlIIIlIIIllIIIIlII);
        }
        catch (Throwable llllllllllllllIlIIIlIIIllIIIIIlI) {
            NettyPacketEncoder.LOGGER.error((Object)llllllllllllllIlIIIlIIIllIIIIIlI);
        }
    }
    
    public NettyPacketEncoder(final EnumPacketDirection llllllllllllllIlIIIlIIIllIIllIIl) {
        this.direction = llllllllllllllIlIIIlIIIllIIllIIl;
    }
}
