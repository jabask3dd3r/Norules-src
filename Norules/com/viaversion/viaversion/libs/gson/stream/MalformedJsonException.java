package com.viaversion.viaversion.libs.gson.stream;

import java.io.*;

public final class MalformedJsonException extends IOException
{
    public MalformedJsonException(final String lllllllllllllIlllIlllIlIlIlIIIlI) {
        super(lllllllllllllIlllIlllIlIlIlIIIlI);
    }
    
    public MalformedJsonException(final String lllllllllllllIlllIlllIlIlIIllIll, final Throwable lllllllllllllIlllIlllIlIlIIllIlI) {
        super(lllllllllllllIlllIlllIlIlIIllIll);
        this.initCause(lllllllllllllIlllIlllIlIlIIllIlI);
    }
    
    public MalformedJsonException(final Throwable lllllllllllllIlllIlllIlIlIIIlIll) {
        this.initCause(lllllllllllllIlllIlllIlIlIIIlIll);
    }
}
