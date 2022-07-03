package net.minecraft.network;

import io.netty.handler.codec.*;
import io.netty.buffer.*;
import java.util.zip.*;
import io.netty.channel.*;

public class NettyCompressionEncoder extends MessageToByteEncoder<ByteBuf>
{
    private /* synthetic */ int threshold;
    private final /* synthetic */ Deflater deflater;
    private final /* synthetic */ byte[] buffer;
    
    protected void encode(final ChannelHandlerContext lllllllllllllIIIlIIlIIlllIIlllIl, final ByteBuf lllllllllllllIIIlIIlIIlllIIlllII, final ByteBuf lllllllllllllIIIlIIlIIlllIIllIll) throws Exception {
        final int lllllllllllllIIIlIIlIIlllIIllIlI = lllllllllllllIIIlIIlIIlllIIlllII.readableBytes();
        final PacketBuffer lllllllllllllIIIlIIlIIlllIIllIIl = new PacketBuffer(lllllllllllllIIIlIIlIIlllIIllIll);
        if (lllllllllllllIIIlIIlIIlllIIllIlI < this.threshold) {
            lllllllllllllIIIlIIlIIlllIIllIIl.writeVarIntToBuffer(0);
            lllllllllllllIIIlIIlIIlllIIllIIl.writeBytes(lllllllllllllIIIlIIlIIlllIIlllII);
        }
        else {
            final byte[] lllllllllllllIIIlIIlIIlllIIllIII = new byte[lllllllllllllIIIlIIlIIlllIIllIlI];
            lllllllllllllIIIlIIlIIlllIIlllII.readBytes(lllllllllllllIIIlIIlIIlllIIllIII);
            lllllllllllllIIIlIIlIIlllIIllIIl.writeVarIntToBuffer(lllllllllllllIIIlIIlIIlllIIllIII.length);
            this.deflater.setInput(lllllllllllllIIIlIIlIIlllIIllIII, 0, lllllllllllllIIIlIIlIIlllIIllIlI);
            this.deflater.finish();
            while (!this.deflater.finished()) {
                final int lllllllllllllIIIlIIlIIlllIIlIlll = this.deflater.deflate(this.buffer);
                lllllllllllllIIIlIIlIIlllIIllIIl.writeBytes(this.buffer, 0, lllllllllllllIIIlIIlIIlllIIlIlll);
            }
            this.deflater.reset();
        }
    }
    
    public NettyCompressionEncoder(final int lllllllllllllIIIlIIlIIlllIlIlIII) {
        this.buffer = new byte[8192];
        this.threshold = lllllllllllllIIIlIIlIIlllIlIlIII;
        this.deflater = new Deflater();
    }
    
    public void setCompressionThreshold(final int lllllllllllllIIIlIIlIIlllIIIlIlI) {
        this.threshold = lllllllllllllIIIlIIlIIlllIIIlIlI;
    }
}
