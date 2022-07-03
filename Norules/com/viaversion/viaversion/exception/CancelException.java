package com.viaversion.viaversion.exception;

import com.viaversion.viaversion.api.*;

public class CancelException extends Exception
{
    public static final /* synthetic */ CancelException CACHED;
    
    public CancelException(final String lllllllllllllIlIIllIIIlllIlIllll, final Throwable lllllllllllllIlIIllIIIlllIllIIll, final boolean lllllllllllllIlIIllIIIlllIlIllIl, final boolean lllllllllllllIlIIllIIIlllIlIllII) {
        super(lllllllllllllIlIIllIIIlllIlIllll, lllllllllllllIlIIllIIIlllIllIIll, lllllllllllllIlIIllIIIlllIlIllIl, lllllllllllllIlIIllIIIlllIlIllII);
    }
    
    public CancelException(final Throwable lllllllllllllIlIIllIIIlllIlllIll) {
        super(lllllllllllllIlIIllIIIlllIlllIll);
    }
    
    public CancelException(final String lllllllllllllIlIIllIIIllllIIlIlI) {
        super(lllllllllllllIlIIllIIIllllIIlIlI);
    }
    
    public static CancelException generate() {
        return Via.getManager().isDebug() ? new CancelException() : CancelException.CACHED;
    }
    
    public CancelException() {
    }
    
    static {
        CACHED = new CancelException() {
            @Override
            public Throwable fillInStackTrace() {
                return this;
            }
        };
    }
    
    public CancelException(final String lllllllllllllIlIIllIIIllllIIIIlI, final Throwable lllllllllllllIlIIllIIIllllIIIlII) {
        super(lllllllllllllIlIIllIIIllllIIIIlI, lllllllllllllIlIIllIIIllllIIIlII);
    }
}
