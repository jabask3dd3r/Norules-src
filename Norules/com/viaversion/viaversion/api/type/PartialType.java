package com.viaversion.viaversion.api.type;

import io.netty.buffer.*;

public abstract class PartialType<T, X> extends Type<T>
{
    private final /* synthetic */ X param;
    
    public abstract void write(final ByteBuf p0, final X p1, final T p2) throws Exception;
    
    public abstract T read(final ByteBuf p0, final X p1) throws Exception;
    
    @Override
    public final void write(final ByteBuf lIllIIIlllIllIl, final T lIllIIIlllIllII) throws Exception {
        this.write(lIllIIIlllIllIl, this.param, lIllIIIlllIllII);
    }
    
    @Override
    public final T read(final ByteBuf lIllIIIllllIlIl) throws Exception {
        return this.read(lIllIIIllllIlIl, this.param);
    }
    
    protected PartialType(final X lIllIIIllllllIl, final String lIllIIIllllllII, final Class<T> lIllIIIlllllIll) {
        super(lIllIIIllllllII, lIllIIIlllllIll);
        this.param = lIllIIIllllllIl;
    }
    
    protected PartialType(final X lIllIIlIIIIlIll, final Class<T> lIllIIlIIIIIlll) {
        super(lIllIIlIIIIIlll);
        this.param = lIllIIlIIIIlIll;
    }
}
