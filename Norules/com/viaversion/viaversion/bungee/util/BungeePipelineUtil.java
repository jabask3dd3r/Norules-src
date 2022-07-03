package com.viaversion.viaversion.bungee.util;

import io.netty.channel.*;
import io.netty.buffer.*;
import java.lang.reflect.*;
import io.netty.handler.codec.*;
import java.util.*;

public class BungeePipelineUtil
{
    private static /* synthetic */ Method DECODE_METHOD;
    private static /* synthetic */ Method ENCODE_METHOD;
    
    public static ByteBuf compress(final ChannelHandlerContext lllllllllllllIIIIIIIIIIllIIIIlll, final ByteBuf lllllllllllllIIIIIIIIIIllIIIIllI) {
        try {
            return callEncode((MessageToByteEncoder)lllllllllllllIIIIIIIIIIllIIIIlll.pipeline().get("compress"), lllllllllllllIIIIIIIIIIllIIIIlll.pipeline().context("compress"), lllllllllllllIIIIIIIIIIllIIIIllI);
        }
        catch (InvocationTargetException lllllllllllllIIIIIIIIIIllIIIlIlI) {
            lllllllllllllIIIIIIIIIIllIIIlIlI.printStackTrace();
            return lllllllllllllIIIIIIIIIIllIIIIlll.alloc().buffer();
        }
    }
    
    static {
        try {
            (BungeePipelineUtil.DECODE_METHOD = MessageToMessageDecoder.class.getDeclaredMethod("decode", ChannelHandlerContext.class, Object.class, List.class)).setAccessible(true);
        }
        catch (NoSuchMethodException lllllllllllllIIIIIIIIIIllIIIIIll) {
            lllllllllllllIIIIIIIIIIllIIIIIll.printStackTrace();
        }
        try {
            (BungeePipelineUtil.ENCODE_METHOD = MessageToByteEncoder.class.getDeclaredMethod("encode", ChannelHandlerContext.class, Object.class, ByteBuf.class)).setAccessible(true);
        }
        catch (NoSuchMethodException lllllllllllllIIIIIIIIIIllIIIIIlI) {
            lllllllllllllIIIIIIIIIIllIIIIIlI.printStackTrace();
        }
    }
    
    public static ByteBuf decompress(final ChannelHandlerContext lllllllllllllIIIIIIIIIIllIIlIIII, final ByteBuf lllllllllllllIIIIIIIIIIllIIlIIIl) {
        try {
            return callDecode((MessageToMessageDecoder)lllllllllllllIIIIIIIIIIllIIlIIII.pipeline().get("decompress"), lllllllllllllIIIIIIIIIIllIIlIIII.pipeline().context("decompress"), lllllllllllllIIIIIIIIIIllIIlIIIl).get(0);
        }
        catch (InvocationTargetException lllllllllllllIIIIIIIIIIllIIlIIll) {
            lllllllllllllIIIIIIIIIIllIIlIIll.printStackTrace();
            return lllllllllllllIIIIIIIIIIllIIlIIII.alloc().buffer();
        }
    }
    
    public static List<Object> callDecode(final MessageToMessageDecoder lllllllllllllIIIIIIIIIIllIlIlllI, final ChannelHandlerContext lllllllllllllIIIIIIIIIIllIlIlIIl, final ByteBuf lllllllllllllIIIIIIIIIIllIlIlIII) throws InvocationTargetException {
        final List<Object> lllllllllllllIIIIIIIIIIllIlIlIll = new ArrayList<Object>();
        try {
            BungeePipelineUtil.DECODE_METHOD.invoke(lllllllllllllIIIIIIIIIIllIlIlllI, lllllllllllllIIIIIIIIIIllIlIlIIl, lllllllllllllIIIIIIIIIIllIlIlIII, lllllllllllllIIIIIIIIIIllIlIlIll);
        }
        catch (IllegalAccessException lllllllllllllIIIIIIIIIIllIlIllll) {
            lllllllllllllIIIIIIIIIIllIlIllll.printStackTrace();
        }
        return lllllllllllllIIIIIIIIIIllIlIlIll;
    }
    
    public static ByteBuf callEncode(final MessageToByteEncoder lllllllllllllIIIIIIIIIIllIIllIll, final ChannelHandlerContext lllllllllllllIIIIIIIIIIllIIllllI, final ByteBuf lllllllllllllIIIIIIIIIIllIIllIIl) throws InvocationTargetException {
        final ByteBuf lllllllllllllIIIIIIIIIIllIIlllII = lllllllllllllIIIIIIIIIIllIIllllI.alloc().buffer();
        try {
            BungeePipelineUtil.ENCODE_METHOD.invoke(lllllllllllllIIIIIIIIIIllIIllIll, lllllllllllllIIIIIIIIIIllIIllllI, lllllllllllllIIIIIIIIIIllIIllIIl, lllllllllllllIIIIIIIIIIllIIlllII);
        }
        catch (IllegalAccessException lllllllllllllIIIIIIIIIIllIlIIIII) {
            lllllllllllllIIIIIIIIIIllIlIIIII.printStackTrace();
        }
        return lllllllllllllIIIIIIIIIIllIIlllII;
    }
}
