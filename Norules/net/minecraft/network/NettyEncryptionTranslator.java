package net.minecraft.network;

import io.netty.channel.*;
import io.netty.buffer.*;
import javax.crypto.*;

public class NettyEncryptionTranslator
{
    private final /* synthetic */ Cipher cipher;
    private /* synthetic */ byte[] outputBuffer;
    private /* synthetic */ byte[] inputBuffer;
    
    protected ByteBuf decipher(final ChannelHandlerContext lllllllllllllIIllIllllIIIIIIlllI, final ByteBuf lllllllllllllIIllIllllIIIIIlIIll) throws ShortBufferException {
        final int lllllllllllllIIllIllllIIIIIlIIlI = lllllllllllllIIllIllllIIIIIlIIll.readableBytes();
        final byte[] lllllllllllllIIllIllllIIIIIlIIIl = this.bufToBytes(lllllllllllllIIllIllllIIIIIlIIll);
        final ByteBuf lllllllllllllIIllIllllIIIIIlIIII = lllllllllllllIIllIllllIIIIIIlllI.alloc().heapBuffer(this.cipher.getOutputSize(lllllllllllllIIllIllllIIIIIlIIlI));
        lllllllllllllIIllIllllIIIIIlIIII.writerIndex(this.cipher.update(lllllllllllllIIllIllllIIIIIlIIIl, 0, lllllllllllllIIllIllllIIIIIlIIlI, lllllllllllllIIllIllllIIIIIlIIII.array(), lllllllllllllIIllIllllIIIIIlIIII.arrayOffset()));
        return lllllllllllllIIllIllllIIIIIlIIII;
    }
    
    protected NettyEncryptionTranslator(final Cipher lllllllllllllIIllIllllIIIIlIIlll) {
        this.inputBuffer = new byte[0];
        this.outputBuffer = new byte[0];
        this.cipher = lllllllllllllIIllIllllIIIIlIIlll;
    }
    
    private byte[] bufToBytes(final ByteBuf lllllllllllllIIllIllllIIIIIlllIl) {
        final int lllllllllllllIIllIllllIIIIIlllll = lllllllllllllIIllIllllIIIIIlllIl.readableBytes();
        if (this.inputBuffer.length < lllllllllllllIIllIllllIIIIIlllll) {
            this.inputBuffer = new byte[lllllllllllllIIllIllllIIIIIlllll];
        }
        lllllllllllllIIllIllllIIIIIlllIl.readBytes(this.inputBuffer, 0, lllllllllllllIIllIllllIIIIIlllll);
        return this.inputBuffer;
    }
    
    protected void cipher(final ByteBuf lllllllllllllIIllIlllIllllllllII, final ByteBuf lllllllllllllIIllIlllIlllllllIll) throws ShortBufferException {
        final int lllllllllllllIIllIllllIIIIIIIIII = lllllllllllllIIllIlllIllllllllII.readableBytes();
        final byte[] lllllllllllllIIllIlllIllllllllll = this.bufToBytes(lllllllllllllIIllIlllIllllllllII);
        final int lllllllllllllIIllIlllIlllllllllI = this.cipher.getOutputSize(lllllllllllllIIllIllllIIIIIIIIII);
        if (this.outputBuffer.length < lllllllllllllIIllIlllIlllllllllI) {
            this.outputBuffer = new byte[lllllllllllllIIllIlllIlllllllllI];
        }
        lllllllllllllIIllIlllIlllllllIll.writeBytes(this.outputBuffer, 0, this.cipher.update(lllllllllllllIIllIlllIllllllllll, 0, lllllllllllllIIllIllllIIIIIIIIII, this.outputBuffer));
    }
}
