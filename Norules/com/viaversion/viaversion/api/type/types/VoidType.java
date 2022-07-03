package com.viaversion.viaversion.api.type.types;

import com.viaversion.viaversion.api.type.*;
import io.netty.buffer.*;

public class VoidType extends Type<Void> implements TypeConverter<Void>
{
    @Override
    public Void from(final Object lllllllllllllIIIlIllIllIIIIIlIlI) {
        return null;
    }
    
    @Override
    public void write(final ByteBuf lllllllllllllIIIlIllIllIIIIIllIl, final Void lllllllllllllIIIlIllIllIIIIIllII) {
    }
    
    @Override
    public Void read(final ByteBuf lllllllllllllIIIlIllIllIIIIIllll) {
        return null;
    }
    
    public VoidType() {
        super(Void.class);
    }
}
