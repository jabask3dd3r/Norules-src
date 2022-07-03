package com.viaversion.viaversion.util;

import java.util.*;
import java.lang.reflect.*;
import io.netty.buffer.*;
import io.netty.handler.codec.*;
import io.netty.channel.*;

public class PipelineUtil
{
    private static /* synthetic */ Method DECODE_METHOD;
    private static /* synthetic */ Method MTM_DECODE;
    private static /* synthetic */ Method ENCODE_METHOD;
    
    public static List<Object> callDecode(final ByteToMessageDecoder lllllllllllllIIlllIlIlIlIlIlIlll, final ChannelHandlerContext lllllllllllllIIlllIlIlIlIlIlIllI, final Object lllllllllllllIIlllIlIlIlIlIlIlIl) throws InvocationTargetException {
        final List<Object> lllllllllllllIIlllIlIlIlIlIllIII = new ArrayList<Object>();
        try {
            PipelineUtil.DECODE_METHOD.invoke(lllllllllllllIIlllIlIlIlIlIlIlll, lllllllllllllIIlllIlIlIlIlIlIllI, lllllllllllllIIlllIlIlIlIlIlIlIl, lllllllllllllIIlllIlIlIlIlIllIII);
        }
        catch (IllegalAccessException lllllllllllllIIlllIlIlIlIlIlllII) {
            lllllllllllllIIlllIlIlIlIlIlllII.printStackTrace();
        }
        return lllllllllllllIIlllIlIlIlIlIllIII;
    }
    
    public static void callEncode(final MessageToByteEncoder lllllllllllllIIlllIlIlIlIlIIllII, final ChannelHandlerContext lllllllllllllIIlllIlIlIlIlIIIlll, final Object lllllllllllllIIlllIlIlIlIlIIIllI, final ByteBuf lllllllllllllIIlllIlIlIlIlIIIlIl) throws InvocationTargetException {
        try {
            PipelineUtil.ENCODE_METHOD.invoke(lllllllllllllIIlllIlIlIlIlIIllII, lllllllllllllIIlllIlIlIlIlIIIlll, lllllllllllllIIlllIlIlIlIlIIIllI, lllllllllllllIIlllIlIlIlIlIIIlIl);
        }
        catch (IllegalAccessException lllllllllllllIIlllIlIlIlIlIIllIl) {
            lllllllllllllIIlllIlIlIlIlIIllIl.printStackTrace();
        }
    }
    
    static {
        try {
            (PipelineUtil.DECODE_METHOD = ByteToMessageDecoder.class.getDeclaredMethod("decode", ChannelHandlerContext.class, ByteBuf.class, List.class)).setAccessible(true);
        }
        catch (NoSuchMethodException lllllllllllllIIlllIlIlIlIIIlIIIl) {
            lllllllllllllIIlllIlIlIlIIIlIIIl.printStackTrace();
        }
        try {
            (PipelineUtil.ENCODE_METHOD = MessageToByteEncoder.class.getDeclaredMethod("encode", ChannelHandlerContext.class, Object.class, ByteBuf.class)).setAccessible(true);
        }
        catch (NoSuchMethodException lllllllllllllIIlllIlIlIlIIIlIIII) {
            lllllllllllllIIlllIlIlIlIIIlIIII.printStackTrace();
        }
        try {
            (PipelineUtil.MTM_DECODE = MessageToMessageDecoder.class.getDeclaredMethod("decode", ChannelHandlerContext.class, Object.class, List.class)).setAccessible(true);
        }
        catch (NoSuchMethodException lllllllllllllIIlllIlIlIlIIIIllll) {
            lllllllllllllIIlllIlIlIlIIIIllll.printStackTrace();
        }
    }
    
    public static ChannelHandlerContext getContextBefore(final String lllllllllllllIIlllIlIlIlIIlIlIII, final ChannelPipeline lllllllllllllIIlllIlIlIlIIlIIlII) {
        boolean lllllllllllllIIlllIlIlIlIIlIIllI = false;
        for (final String lllllllllllllIIlllIlIlIlIIlIlIIl : lllllllllllllIIlllIlIlIlIIlIIlII.names()) {
            if (lllllllllllllIIlllIlIlIlIIlIIllI) {
                return lllllllllllllIIlllIlIlIlIIlIIlII.context(lllllllllllllIIlllIlIlIlIIlIIlII.get(lllllllllllllIIlllIlIlIlIIlIlIIl));
            }
            if (!lllllllllllllIIlllIlIlIlIIlIlIIl.equalsIgnoreCase(lllllllllllllIIlllIlIlIlIIlIlIII)) {
                continue;
            }
            lllllllllllllIIlllIlIlIlIIlIIllI = true;
        }
        return null;
    }
    
    public static boolean containsCause(Throwable lllllllllllllIIlllIlIlIlIIllIIII, final Class<?> lllllllllllllIIlllIlIlIlIIlIllll) {
        while (lllllllllllllIIlllIlIlIlIIllIIII != null) {
            if (lllllllllllllIIlllIlIlIlIIlIllll.isAssignableFrom(lllllllllllllIIlllIlIlIlIIllIIII.getClass())) {
                return true;
            }
            lllllllllllllIIlllIlIlIlIIllIIII = lllllllllllllIIlllIlIlIlIIllIIII.getCause();
        }
        return false;
    }
    
    public static ChannelHandlerContext getPreviousContext(final String lllllllllllllIIlllIlIlIlIIIlIlll, final ChannelPipeline lllllllllllllIIlllIlIlIlIIIlIllI) {
        String lllllllllllllIIlllIlIlIlIIIllIII = null;
        for (final String lllllllllllllIIlllIlIlIlIIIllIll : lllllllllllllIIlllIlIlIlIIIlIllI.toMap().keySet()) {
            if (lllllllllllllIIlllIlIlIlIIIllIll.equals(lllllllllllllIIlllIlIlIlIIIlIlll)) {
                return lllllllllllllIIlllIlIlIlIIIlIllI.context(lllllllllllllIIlllIlIlIlIIIllIII);
            }
            lllllllllllllIIlllIlIlIlIIIllIII = lllllllllllllIIlllIlIlIlIIIllIll;
        }
        return null;
    }
    
    public static List<Object> callDecode(final MessageToMessageDecoder lllllllllllllIIlllIlIlIlIIlllIIl, final ChannelHandlerContext lllllllllllllIIlllIlIlIlIIlllIII, final Object lllllllllllllIIlllIlIlIlIIlllIll) throws InvocationTargetException {
        final List<Object> lllllllllllllIIlllIlIlIlIIlllIlI = new ArrayList<Object>();
        try {
            PipelineUtil.MTM_DECODE.invoke(lllllllllllllIIlllIlIlIlIIlllIIl, lllllllllllllIIlllIlIlIlIIlllIII, lllllllllllllIIlllIlIlIlIIlllIll, lllllllllllllIIlllIlIlIlIIlllIlI);
        }
        catch (IllegalAccessException lllllllllllllIIlllIlIlIlIIlllllI) {
            lllllllllllllIIlllIlIlIlIIlllllI.printStackTrace();
        }
        return lllllllllllllIIlllIlIlIlIIlllIlI;
    }
}
