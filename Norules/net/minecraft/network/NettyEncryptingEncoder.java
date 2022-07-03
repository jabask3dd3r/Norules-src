package net.minecraft.network;

import io.netty.handler.codec.*;
import io.netty.buffer.*;
import io.netty.channel.*;
import javax.crypto.*;

public class NettyEncryptingEncoder extends MessageToByteEncoder<ByteBuf>
{
    private final /* synthetic */ NettyEncryptionTranslator encryptionCodec;
    
    protected void encode(final ChannelHandlerContext lllllllllllllIlIIIIIllIIIlIllIII, final ByteBuf lllllllllllllIlIIIIIllIIIlIlIlll, final ByteBuf lllllllllllllIlIIIIIllIIIlIlIllI) throws Exception, ShortBufferException {
        this.encryptionCodec.cipher(lllllllllllllIlIIIIIllIIIlIlIlll, lllllllllllllIlIIIIIllIIIlIlIllI);
    }
    
    public NettyEncryptingEncoder(final Cipher lllllllllllllIlIIIIIllIIIlIlllll) {
        this.encryptionCodec = new NettyEncryptionTranslator(lllllllllllllIlIIIIIllIIIlIlllll);
    }
}
