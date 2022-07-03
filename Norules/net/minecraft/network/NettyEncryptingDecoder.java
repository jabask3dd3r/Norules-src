package net.minecraft.network;

import io.netty.handler.codec.*;
import io.netty.buffer.*;
import io.netty.channel.*;
import java.util.*;
import javax.crypto.*;

public class NettyEncryptingDecoder extends MessageToMessageDecoder<ByteBuf>
{
    private final /* synthetic */ NettyEncryptionTranslator decryptionCodec;
    
    public NettyEncryptingDecoder(final Cipher llllllllllllllIIlIIIlllIlIllIIlI) {
        this.decryptionCodec = new NettyEncryptionTranslator(llllllllllllllIIlIIIlllIlIllIIlI);
    }
    
    protected void decode(final ChannelHandlerContext llllllllllllllIIlIIIlllIlIlIIllI, final ByteBuf llllllllllllllIIlIIIlllIlIlIlIIl, final List<Object> llllllllllllllIIlIIIlllIlIlIIlII) throws ShortBufferException, Exception {
        llllllllllllllIIlIIIlllIlIlIIlII.add(this.decryptionCodec.decipher(llllllllllllllIIlIIIlllIlIlIIllI, llllllllllllllIIlIIIlllIlIlIlIIl));
    }
}
