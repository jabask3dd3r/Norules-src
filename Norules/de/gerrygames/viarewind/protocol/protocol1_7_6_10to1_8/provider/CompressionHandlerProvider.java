package de.gerrygames.viarewind.protocol.protocol1_7_6_10to1_8.provider;

import com.viaversion.viaversion.api.platform.providers.*;
import com.viaversion.viaversion.api.connection.*;
import de.gerrygames.viarewind.protocol.protocol1_7_6_10to1_8.storage.*;
import de.gerrygames.viarewind.netty.*;
import com.viaversion.viaversion.api.*;
import io.netty.channel.*;
import com.viaversion.viaversion.api.type.*;
import io.netty.buffer.*;
import java.util.zip.*;
import java.util.*;
import io.netty.handler.codec.*;

public class CompressionHandlerProvider implements Provider
{
    public void handleTransform(final UserConnection llllllllllllllIIlllIIllIIllllIII) {
        final CompressionSendStorage llllllllllllllIIlllIIllIIllllIIl = llllllllllllllIIlllIIllIIllllIII.get(CompressionSendStorage.class);
        if (llllllllllllllIIlllIIllIIllllIIl.isRemoveCompression()) {
            final ChannelPipeline llllllllllllllIIlllIIllIIllllllI = llllllllllllllIIlllIIllIIllllIII.getChannel().pipeline();
            String llllllllllllllIIlllIIllIIlllllIl = null;
            String llllllllllllllIIlllIIllIIlllllII = null;
            if (llllllllllllllIIlllIIllIIllllllI.get("compress") != null) {
                llllllllllllllIIlllIIllIIlllllIl = "compress";
                llllllllllllllIIlllIIllIIlllllII = "decompress";
            }
            else if (llllllllllllllIIlllIIllIIllllllI.get("compression-encoder") != null) {
                llllllllllllllIIlllIIllIIlllllIl = "compression-encoder";
                llllllllllllllIIlllIIllIIlllllII = "compression-decoder";
            }
            if (llllllllllllllIIlllIIllIIlllllIl == null) {
                throw new IllegalStateException("Couldn't remove compression for 1.7!");
            }
            llllllllllllllIIlllIIllIIllllllI.replace(llllllllllllllIIlllIIllIIlllllII, llllllllllllllIIlllIIllIIlllllII, (ChannelHandler)new EmptyChannelHandler());
            llllllllllllllIIlllIIllIIllllllI.replace(llllllllllllllIIlllIIllIIlllllIl, llllllllllllllIIlllIIllIIlllllIl, (ChannelHandler)new ForwardMessageToByteEncoder());
            llllllllllllllIIlllIIllIIllllIIl.setRemoveCompression(false);
        }
    }
    
    protected ChannelHandler getDecoder(final int llllllllllllllIIlllIIllIIllIllIl) {
        return (ChannelHandler)new Decompressor(llllllllllllllIIlllIIllIIllIllIl);
    }
    
    public void handleSetCompression(final UserConnection llllllllllllllIIlllIIllIlIIlIIII, final int llllllllllllllIIlllIIllIlIIIlIIl) {
        final ChannelPipeline llllllllllllllIIlllIIllIlIIIllII = llllllllllllllIIlllIIllIlIIlIIII.getChannel().pipeline();
        if (llllllllllllllIIlllIIllIlIIlIIII.isClientSide()) {
            llllllllllllllIIlllIIllIlIIIllII.addBefore(Via.getManager().getInjector().getEncoderName(), "compress", this.getEncoder(llllllllllllllIIlllIIllIlIIIlIIl));
            llllllllllllllIIlllIIllIlIIIllII.addBefore(Via.getManager().getInjector().getDecoderName(), "decompress", this.getDecoder(llllllllllllllIIlllIIllIlIIIlIIl));
        }
        else {
            final CompressionSendStorage llllllllllllllIIlllIIllIlIIlIIll = llllllllllllllIIlllIIllIlIIlIIII.get(CompressionSendStorage.class);
            llllllllllllllIIlllIIllIlIIlIIll.setRemoveCompression(true);
        }
    }
    
    protected ChannelHandler getEncoder(final int llllllllllllllIIlllIIllIIlllIIIl) {
        return (ChannelHandler)new Compressor(llllllllllllllIIlllIIllIIlllIIIl);
    }
    
    private static class Compressor extends MessageToByteEncoder<ByteBuf>
    {
        private final /* synthetic */ int threshold;
        private final /* synthetic */ Deflater deflater;
        
        public Compressor(final int lIIlllIIIlIllII) {
            this.threshold = lIIlllIIIlIllII;
            this.deflater = new Deflater();
        }
        
        protected void encode(final ChannelHandlerContext lIIlllIIIlIIIll, final ByteBuf lIIlllIIIlIIIlI, final ByteBuf lIIlllIIIlIIIIl) throws Exception {
            final int lIIlllIIIlIIIII = lIIlllIIIlIIIlI.readableBytes();
            if (lIIlllIIIlIIIII < this.threshold) {
                lIIlllIIIlIIIIl.writeByte(0);
                lIIlllIIIlIIIIl.writeBytes(lIIlllIIIlIIIlI);
                return;
            }
            Type.VAR_INT.writePrimitive(lIIlllIIIlIIIIl, lIIlllIIIlIIIII);
            ByteBuf lIIlllIIIIlllll = lIIlllIIIlIIIlI;
            if (!lIIlllIIIlIIIlI.hasArray()) {
                lIIlllIIIIlllll = ByteBufAllocator.DEFAULT.heapBuffer().writeBytes(lIIlllIIIlIIIlI);
            }
            else {
                lIIlllIIIlIIIlI.retain();
            }
            final ByteBuf lIIlllIIIIllllI = ByteBufAllocator.DEFAULT.heapBuffer();
            try {
                this.deflater.setInput(lIIlllIIIIlllll.array(), lIIlllIIIIlllll.arrayOffset() + lIIlllIIIIlllll.readerIndex(), lIIlllIIIIlllll.readableBytes());
                this.deflater.finish();
                while (!this.deflater.finished()) {
                    lIIlllIIIIllllI.ensureWritable(4096);
                    lIIlllIIIIllllI.writerIndex(lIIlllIIIIllllI.writerIndex() + this.deflater.deflate(lIIlllIIIIllllI.array(), lIIlllIIIIllllI.arrayOffset() + lIIlllIIIIllllI.writerIndex(), lIIlllIIIIllllI.writableBytes()));
                }
                lIIlllIIIlIIIIl.writeBytes(lIIlllIIIIllllI);
            }
            finally {
                lIIlllIIIIllllI.release();
                lIIlllIIIIlllll.release();
                this.deflater.reset();
            }
        }
    }
    
    private static class Decompressor extends MessageToMessageDecoder<ByteBuf>
    {
        private final /* synthetic */ int threshold;
        private final /* synthetic */ Inflater inflater;
        
        protected void decode(final ChannelHandlerContext llllllllllllllIIllIlIIllIllIIlII, final ByteBuf llllllllllllllIIllIlIIllIllIIIll, final List<Object> llllllllllllllIIllIlIIllIllIIIlI) throws Exception {
            if (!llllllllllllllIIllIlIIllIllIIIll.isReadable()) {
                return;
            }
            final int llllllllllllllIIllIlIIllIllIIIIl = Type.VAR_INT.readPrimitive(llllllllllllllIIllIlIIllIllIIIll);
            if (llllllllllllllIIllIlIIllIllIIIIl == 0) {
                llllllllllllllIIllIlIIllIllIIIlI.add(llllllllllllllIIllIlIIllIllIIIll.readBytes(llllllllllllllIIllIlIIllIllIIIll.readableBytes()));
                return;
            }
            if (llllllllllllllIIllIlIIllIllIIIIl < this.threshold) {
                throw new DecoderException(String.valueOf(new StringBuilder().append("Badly compressed packet - size of ").append(llllllllllllllIIllIlIIllIllIIIIl).append(" is below server threshold of ").append(this.threshold)));
            }
            if (llllllllllllllIIllIlIIllIllIIIIl > 2097152) {
                throw new DecoderException(String.valueOf(new StringBuilder().append("Badly compressed packet - size of ").append(llllllllllllllIIllIlIIllIllIIIIl).append(" is larger than protocol maximum of ").append(2097152)));
            }
            ByteBuf llllllllllllllIIllIlIIllIllIIIII = llllllllllllllIIllIlIIllIllIIIll;
            if (!llllllllllllllIIllIlIIllIllIIIll.hasArray()) {
                llllllllllllllIIllIlIIllIllIIIII = ByteBufAllocator.DEFAULT.heapBuffer().writeBytes(llllllllllllllIIllIlIIllIllIIIll);
            }
            else {
                llllllllllllllIIllIlIIllIllIIIll.retain();
            }
            final ByteBuf llllllllllllllIIllIlIIllIlIlllll = ByteBufAllocator.DEFAULT.heapBuffer(llllllllllllllIIllIlIIllIllIIIIl, llllllllllllllIIllIlIIllIllIIIIl);
            try {
                this.inflater.setInput(llllllllllllllIIllIlIIllIllIIIII.array(), llllllllllllllIIllIlIIllIllIIIII.arrayOffset() + llllllllllllllIIllIlIIllIllIIIII.readerIndex(), llllllllllllllIIllIlIIllIllIIIII.readableBytes());
                llllllllllllllIIllIlIIllIlIlllll.writerIndex(llllllllllllllIIllIlIIllIlIlllll.writerIndex() + this.inflater.inflate(llllllllllllllIIllIlIIllIlIlllll.array(), llllllllllllllIIllIlIIllIlIlllll.arrayOffset(), llllllllllllllIIllIlIIllIllIIIIl));
                llllllllllllllIIllIlIIllIllIIIlI.add(llllllllllllllIIllIlIIllIlIlllll.retain());
            }
            finally {
                llllllllllllllIIllIlIIllIlIlllll.release();
                llllllllllllllIIllIlIIllIllIIIII.release();
                this.inflater.reset();
            }
        }
        
        public Decompressor(final int llllllllllllllIIllIlIIllIllIllIl) {
            this.threshold = llllllllllllllIIllIlIIllIllIllIl;
            this.inflater = new Inflater();
        }
    }
}
