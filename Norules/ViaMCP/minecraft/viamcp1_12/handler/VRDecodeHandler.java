package ViaMCP.minecraft.viamcp1_12.handler;

import io.netty.handler.codec.*;
import io.netty.buffer.*;
import com.viaversion.viaversion.api.connection.*;
import io.netty.channel.*;
import java.util.*;
import java.util.function.*;
import java.lang.reflect.*;
import com.viaversion.viaversion.exception.*;
import com.viaversion.viaversion.util.*;

@ChannelHandler.Sharable
public class VRDecodeHandler extends MessageToMessageDecoder<ByteBuf>
{
    private /* synthetic */ boolean handledCompression;
    private /* synthetic */ boolean skipDoubleTransform;
    private final /* synthetic */ UserConnection info;
    
    protected void decode(final ChannelHandlerContext llllllllllllllIllllIIlIlIlllIlII, final ByteBuf llllllllllllllIllllIIlIlIlllIIll, final List<Object> llllllllllllllIllllIIlIlIlllIIlI) throws Exception {
        if (this.skipDoubleTransform) {
            this.skipDoubleTransform = false;
            llllllllllllllIllllIIlIlIlllIIlI.add(llllllllllllllIllllIIlIlIlllIIll.retain());
            return;
        }
        if (!this.info.checkIncomingPacket()) {
            throw CancelDecoderException.generate(null);
        }
        if (!this.info.shouldTransformPacket()) {
            llllllllllllllIllllIIlIlIlllIIlI.add(llllllllllllllIllllIIlIlIlllIIll.retain());
            return;
        }
        final ByteBuf llllllllllllllIllllIIlIlIlllIlll = llllllllllllllIllllIIlIlIlllIlII.alloc().buffer().writeBytes(llllllllllllllIllllIIlIlIlllIIll);
        try {
            final boolean llllllllllllllIllllIIlIlIlllIllI = this.handleCompressionOrder(llllllllllllllIllllIIlIlIlllIlII, llllllllllllllIllllIIlIlIlllIlll);
            this.info.transformIncoming(llllllllllllllIllllIIlIlIlllIlll, (Function<Throwable, Exception>)CancelDecoderException::generate);
            if (llllllllllllllIllllIIlIlIlllIllI) {
                CommonTransformer.compress(llllllllllllllIllllIIlIlIlllIlII, llllllllllllllIllllIIlIlIlllIlll);
                this.skipDoubleTransform = true;
            }
            llllllllllllllIllllIIlIlIlllIIlI.add(llllllllllllllIllllIIlIlIlllIlll.retain());
        }
        finally {
            llllllllllllllIllllIIlIlIlllIlll.release();
        }
        llllllllllllllIllllIIlIlIlllIlll.release();
    }
    
    private boolean handleCompressionOrder(final ChannelHandlerContext llllllllllllllIllllIIlIlIllIIIIl, final ByteBuf llllllllllllllIllllIIlIlIllIIIII) throws InvocationTargetException {
        if (this.handledCompression) {
            return false;
        }
        final int llllllllllllllIllllIIlIlIllIIlIl = llllllllllllllIllllIIlIlIllIIIIl.pipeline().names().indexOf("decompress");
        if (llllllllllllllIllllIIlIlIllIIlIl == -1) {
            return false;
        }
        this.handledCompression = true;
        if (llllllllllllllIllllIIlIlIllIIlIl > llllllllllllllIllllIIlIlIllIIIIl.pipeline().names().indexOf("via-decoder")) {
            CommonTransformer.decompress(llllllllllllllIllllIIlIlIllIIIIl, llllllllllllllIllllIIlIlIllIIIII);
            final ChannelHandler llllllllllllllIllllIIlIlIllIIlII = llllllllllllllIllllIIlIlIllIIIIl.pipeline().get("via-encoder");
            final ChannelHandler llllllllllllllIllllIIlIlIllIIIll = llllllllllllllIllllIIlIlIllIIIIl.pipeline().get("via-decoder");
            llllllllllllllIllllIIlIlIllIIIIl.pipeline().remove(llllllllllllllIllllIIlIlIllIIlII);
            llllllllllllllIllllIIlIlIllIIIIl.pipeline().remove(llllllllllllllIllllIIlIlIllIIIll);
            llllllllllllllIllllIIlIlIllIIIIl.pipeline().addAfter("compress", "via-encoder", llllllllllllllIllllIIlIlIllIIlII);
            llllllllllllllIllllIIlIlIllIIIIl.pipeline().addAfter("decompress", "via-decoder", llllllllllllllIllllIIlIlIllIIIll);
            return true;
        }
        return false;
    }
    
    public void exceptionCaught(final ChannelHandlerContext llllllllllllllIllllIIlIlIlIllIII, final Throwable llllllllllllllIllllIIlIlIlIlIlll) throws Exception {
        if (PipelineUtil.containsCause(llllllllllllllIllllIIlIlIlIlIlll, CancelCodecException.class)) {
            return;
        }
        super.exceptionCaught(llllllllllllllIllllIIlIlIlIllIII, llllllllllllllIllllIIlIlIlIlIlll);
    }
    
    public UserConnection getInfo() {
        return this.info;
    }
    
    public VRDecodeHandler(final UserConnection llllllllllllllIllllIIlIllIIIIllI) {
        this.info = llllllllllllllIllllIIlIllIIIIllI;
    }
}
