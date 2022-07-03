package ViaMCP.minecraft.viamcp1_12.handler;

import io.netty.handler.codec.*;
import io.netty.buffer.*;
import com.viaversion.viaversion.api.connection.*;
import io.netty.channel.*;
import java.util.*;
import java.util.function.*;
import com.viaversion.viaversion.exception.*;
import com.viaversion.viaversion.util.*;
import java.lang.reflect.*;

@ChannelHandler.Sharable
public class VREncodeHandler extends MessageToMessageEncoder<ByteBuf>
{
    private /* synthetic */ boolean handledCompression;
    private final /* synthetic */ UserConnection info;
    
    public VREncodeHandler(final UserConnection llllllllllllllIIIllIllIIlIlIllll) {
        this.info = llllllllllllllIIIllIllIIlIlIllll;
    }
    
    protected void encode(final ChannelHandlerContext llllllllllllllIIIllIllIIlIIllllI, final ByteBuf llllllllllllllIIIllIllIIlIlIIIll, final List<Object> llllllllllllllIIIllIllIIlIIlllII) throws Exception {
        if (!this.info.checkOutgoingPacket()) {
            throw CancelEncoderException.generate(null);
        }
        if (!this.info.shouldTransformPacket()) {
            llllllllllllllIIIllIllIIlIIlllII.add(llllllllllllllIIIllIllIIlIlIIIll.retain());
            return;
        }
        final ByteBuf llllllllllllllIIIllIllIIlIlIIIIl = llllllllllllllIIIllIllIIlIIllllI.alloc().buffer().writeBytes(llllllllllllllIIIllIllIIlIlIIIll);
        try {
            final boolean llllllllllllllIIIllIllIIlIlIIIII = this.handleCompressionOrder(llllllllllllllIIIllIllIIlIIllllI, llllllllllllllIIIllIllIIlIlIIIIl);
            this.info.transformOutgoing(llllllllllllllIIIllIllIIlIlIIIIl, (Function<Throwable, Exception>)CancelEncoderException::generate);
            if (llllllllllllllIIIllIllIIlIlIIIII) {
                CommonTransformer.compress(llllllllllllllIIIllIllIIlIIllllI, llllllllllllllIIIllIllIIlIlIIIIl);
            }
            llllllllllllllIIIllIllIIlIIlllII.add(llllllllllllllIIIllIllIIlIlIIIIl.retain());
        }
        finally {
            llllllllllllllIIIllIllIIlIlIIIIl.release();
        }
        llllllllllllllIIIllIllIIlIlIIIIl.release();
    }
    
    public void exceptionCaught(final ChannelHandlerContext llllllllllllllIIIllIllIIIlllllll, final Throwable llllllllllllllIIIllIllIIlIIIIIIl) throws Exception {
        if (PipelineUtil.containsCause(llllllllllllllIIIllIllIIlIIIIIIl, CancelCodecException.class)) {
            return;
        }
        super.exceptionCaught(llllllllllllllIIIllIllIIIlllllll, llllllllllllllIIIllIllIIlIIIIIIl);
    }
    
    private boolean handleCompressionOrder(final ChannelHandlerContext llllllllllllllIIIllIllIIlIIIlIll, final ByteBuf llllllllllllllIIIllIllIIlIIlIIII) throws InvocationTargetException {
        if (this.handledCompression) {
            return false;
        }
        final int llllllllllllllIIIllIllIIlIIIllll = llllllllllllllIIIllIllIIlIIIlIll.pipeline().names().indexOf("compress");
        if (llllllllllllllIIIllIllIIlIIIllll == -1) {
            return false;
        }
        this.handledCompression = true;
        if (llllllllllllllIIIllIllIIlIIIllll > llllllllllllllIIIllIllIIlIIIlIll.pipeline().names().indexOf("via-encoder")) {
            CommonTransformer.decompress(llllllllllllllIIIllIllIIlIIIlIll, llllllllllllllIIIllIllIIlIIlIIII);
            final ChannelHandler llllllllllllllIIIllIllIIlIIIlllI = llllllllllllllIIIllIllIIlIIIlIll.pipeline().get("via-encoder");
            final ChannelHandler llllllllllllllIIIllIllIIlIIIllIl = llllllllllllllIIIllIllIIlIIIlIll.pipeline().get("via-decoder");
            llllllllllllllIIIllIllIIlIIIlIll.pipeline().remove(llllllllllllllIIIllIllIIlIIIlllI);
            llllllllllllllIIIllIllIIlIIIlIll.pipeline().remove(llllllllllllllIIIllIllIIlIIIllIl);
            llllllllllllllIIIllIllIIlIIIlIll.pipeline().addAfter("compress", "via-encoder", llllllllllllllIIIllIllIIlIIIlllI);
            llllllllllllllIIIllIllIIlIIIlIll.pipeline().addAfter("decompress", "via-decoder", llllllllllllllIIIllIllIIlIIIllIl);
            return true;
        }
        return false;
    }
}
