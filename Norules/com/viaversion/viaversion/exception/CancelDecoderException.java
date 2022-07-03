package com.viaversion.viaversion.exception;

import io.netty.handler.codec.*;
import com.viaversion.viaversion.api.*;

public class CancelDecoderException extends DecoderException implements CancelCodecException
{
    public static final /* synthetic */ CancelDecoderException CACHED;
    
    public CancelDecoderException() {
    }
    
    static {
        CACHED = new CancelDecoderException() {
            public Throwable fillInStackTrace() {
                return (Throwable)this;
            }
        };
    }
    
    public static CancelDecoderException generate(final Throwable lllllllllllllIIlIIllIllllIIllIll) {
        return Via.getManager().isDebug() ? new CancelDecoderException(lllllllllllllIIlIIllIllllIIllIll) : CancelDecoderException.CACHED;
    }
    
    public CancelDecoderException(final Throwable lllllllllllllIIlIIllIllllIlIIIII) {
        super(lllllllllllllIIlIIllIllllIlIIIII);
    }
    
    public CancelDecoderException(final String lllllllllllllIIlIIllIllllIlIIlII) {
        super(lllllllllllllIIlIIllIllllIlIIlII);
    }
    
    public CancelDecoderException(final String lllllllllllllIIlIIllIllllIlIlIll, final Throwable lllllllllllllIIlIIllIllllIlIllIl) {
        super(lllllllllllllIIlIIllIllllIlIlIll, lllllllllllllIIlIIllIllllIlIllIl);
    }
}
