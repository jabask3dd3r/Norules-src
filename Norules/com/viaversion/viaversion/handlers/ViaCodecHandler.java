package com.viaversion.viaversion.handlers;

import io.netty.channel.*;
import io.netty.buffer.*;

public interface ViaCodecHandler
{
    void exceptionCaught(final ChannelHandlerContext p0, final Throwable p1) throws Exception;
    
    void transform(final ByteBuf p0) throws Exception;
}
