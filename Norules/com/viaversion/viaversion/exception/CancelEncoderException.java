package com.viaversion.viaversion.exception;

import io.netty.handler.codec.*;
import com.viaversion.viaversion.api.*;

public class CancelEncoderException extends EncoderException implements CancelCodecException
{
    public static final /* synthetic */ CancelEncoderException CACHED;
    
    public CancelEncoderException(final String lllllllllllllllIIlIIIIlIlIIllllI) {
        super(lllllllllllllllIIlIIIIlIlIIllllI);
    }
    
    public CancelEncoderException(final Throwable lllllllllllllllIIlIIIIlIlIIllIII) {
        super(lllllllllllllllIIlIIIIlIlIIllIII);
    }
    
    public static CancelEncoderException generate(final Throwable lllllllllllllllIIlIIIIlIlIIlIlII) {
        return Via.getManager().isDebug() ? new CancelEncoderException(lllllllllllllllIIlIIIIlIlIIlIlII) : CancelEncoderException.CACHED;
    }
    
    public CancelEncoderException(final String lllllllllllllllIIlIIIIlIlIlIIIll, final Throwable lllllllllllllllIIlIIIIlIlIlIIlIl) {
        super(lllllllllllllllIIlIIIIlIlIlIIIll, lllllllllllllllIIlIIIIlIlIlIIlIl);
    }
    
    public CancelEncoderException() {
    }
    
    static {
        CACHED = new CancelEncoderException() {
            public Throwable fillInStackTrace() {
                return (Throwable)this;
            }
        };
    }
}
