package ViaMCP.minecraft.viamcp1_12.handler;

import io.netty.buffer.*;
import com.viaversion.viaversion.util.*;
import io.netty.channel.*;
import java.lang.reflect.*;
import io.netty.handler.codec.*;

public class CommonTransformer
{
    static {
        HANDLER_ENCODER_NAME = "via-encoder";
        HANDLER_DECODER_NAME = "via-decoder";
    }
    
    public static void decompress(final ChannelHandlerContext lllllllllllllIIlIlIIllIlIlIlllIl, final ByteBuf lllllllllllllIIlIlIIllIlIlIllIII) throws InvocationTargetException {
        final ChannelHandler lllllllllllllIIlIlIIllIlIlIllIll = lllllllllllllIIlIlIIllIlIlIlllIl.pipeline().get("decompress");
        final ByteBuf lllllllllllllIIlIlIIllIlIlIllIlI = (lllllllllllllIIlIlIIllIlIlIllIll instanceof MessageToMessageDecoder) ? PipelineUtil.callDecode((MessageToMessageDecoder)lllllllllllllIIlIlIIllIlIlIllIll, lllllllllllllIIlIlIIllIlIlIlllIl, lllllllllllllIIlIlIIllIlIlIllIII).get(0) : PipelineUtil.callDecode((ByteToMessageDecoder)lllllllllllllIIlIlIIllIlIlIllIll, lllllllllllllIIlIlIIllIlIlIlllIl, lllllllllllllIIlIlIIllIlIlIllIII).get(0);
        try {
            lllllllllllllIIlIlIIllIlIlIllIII.clear().writeBytes(lllllllllllllIIlIlIIllIlIlIllIlI);
        }
        finally {
            lllllllllllllIIlIlIIllIlIlIllIlI.release();
        }
        lllllllllllllIIlIlIIllIlIlIllIlI.release();
    }
    
    public static void compress(final ChannelHandlerContext lllllllllllllIIlIlIIllIlIlIIllIl, final ByteBuf lllllllllllllIIlIlIIllIlIlIIllII) throws Exception {
        final ByteBuf lllllllllllllIIlIlIIllIlIlIIlllI = lllllllllllllIIlIlIIllIlIlIIllIl.alloc().buffer();
        try {
            PipelineUtil.callEncode((MessageToByteEncoder)lllllllllllllIIlIlIIllIlIlIIllIl.pipeline().get("compress"), lllllllllllllIIlIlIIllIlIlIIllIl, lllllllllllllIIlIlIIllIlIlIIllII, lllllllllllllIIlIlIIllIlIlIIlllI);
            lllllllllllllIIlIlIIllIlIlIIllII.clear().writeBytes(lllllllllllllIIlIlIIllIlIlIIlllI);
        }
        finally {
            lllllllllllllIIlIlIIllIlIlIIlllI.release();
        }
        lllllllllllllIIlIlIIllIlIlIIlllI.release();
    }
}
