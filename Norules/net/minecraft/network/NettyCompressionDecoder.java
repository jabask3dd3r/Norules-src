package net.minecraft.network;

import io.netty.channel.*;
import java.util.*;
import io.netty.handler.codec.*;
import io.netty.buffer.*;
import java.util.zip.*;

public class NettyCompressionDecoder extends ByteToMessageDecoder
{
    private /* synthetic */ int threshold;
    private final /* synthetic */ Inflater inflater;
    
    public void setCompressionThreshold(final int lllllllllllllllIIllIIllIlIlIIllI) {
        this.threshold = lllllllllllllllIIllIIllIlIlIIllI;
    }
    
    protected void decode(final ChannelHandlerContext lllllllllllllllIIllIIllIlIllIlll, final ByteBuf lllllllllllllllIIllIIllIlIllIllI, final List<Object> lllllllllllllllIIllIIllIlIlIlllI) throws DataFormatException, Exception {
        if (lllllllllllllllIIllIIllIlIllIllI.readableBytes() != 0) {
            final PacketBuffer lllllllllllllllIIllIIllIlIllIlII = new PacketBuffer(lllllllllllllllIIllIIllIlIllIllI);
            final int lllllllllllllllIIllIIllIlIllIIll = lllllllllllllllIIllIIllIlIllIlII.readVarIntFromBuffer();
            if (lllllllllllllllIIllIIllIlIllIIll == 0) {
                lllllllllllllllIIllIIllIlIlIlllI.add(lllllllllllllllIIllIIllIlIllIlII.readBytes(lllllllllllllllIIllIIllIlIllIlII.readableBytes()));
            }
            else {
                if (lllllllllllllllIIllIIllIlIllIIll < this.threshold) {
                    throw new DecoderException(String.valueOf(new StringBuilder("Badly compressed packet - size of ").append(lllllllllllllllIIllIIllIlIllIIll).append(" is below server threshold of ").append(this.threshold)));
                }
                if (lllllllllllllllIIllIIllIlIllIIll > 2097152) {
                    throw new DecoderException(String.valueOf(new StringBuilder("Badly compressed packet - size of ").append(lllllllllllllllIIllIIllIlIllIIll).append(" is larger than protocol maximum of ").append(2097152)));
                }
                final byte[] lllllllllllllllIIllIIllIlIllIIlI = new byte[lllllllllllllllIIllIIllIlIllIlII.readableBytes()];
                lllllllllllllllIIllIIllIlIllIlII.readBytes(lllllllllllllllIIllIIllIlIllIIlI);
                this.inflater.setInput(lllllllllllllllIIllIIllIlIllIIlI);
                final byte[] lllllllllllllllIIllIIllIlIllIIIl = new byte[lllllllllllllllIIllIIllIlIllIIll];
                this.inflater.inflate(lllllllllllllllIIllIIllIlIllIIIl);
                lllllllllllllllIIllIIllIlIlIlllI.add(Unpooled.wrappedBuffer(lllllllllllllllIIllIIllIlIllIIIl));
                this.inflater.reset();
            }
        }
    }
    
    public NettyCompressionDecoder(final int lllllllllllllllIIllIIllIllIIIIlI) {
        this.threshold = lllllllllllllllIIllIIllIllIIIIlI;
        this.inflater = new Inflater();
    }
}
