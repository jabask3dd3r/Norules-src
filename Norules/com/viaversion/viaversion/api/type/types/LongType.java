package com.viaversion.viaversion.api.type.types;

import com.viaversion.viaversion.api.type.*;
import io.netty.buffer.*;

public class LongType extends Type<Long> implements TypeConverter<Long>
{
    @Override
    public Long from(final Object lllllllllllllIlIlIIIIlIlllIIIIlI) {
        if (lllllllllllllIlIlIIIIlIlllIIIIlI instanceof Number) {
            return ((Number)lllllllllllllIlIlIIIIlIlllIIIIlI).longValue();
        }
        if (lllllllllllllIlIlIIIIlIlllIIIIlI instanceof Boolean) {
            return (long)(((boolean)lllllllllllllIlIlIIIIlIlllIIIIlI) ? 1 : 0);
        }
        return (Long)lllllllllllllIlIlIIIIlIlllIIIIlI;
    }
    
    public void writePrimitive(final ByteBuf lllllllllllllIlIlIIIIlIllIllIlll, final long lllllllllllllIlIlIIIIlIllIllIllI) {
        lllllllllllllIlIlIIIIlIllIllIlll.writeLong(lllllllllllllIlIlIIIIlIllIllIllI);
    }
    
    @Deprecated
    @Override
    public void write(final ByteBuf lllllllllllllIlIlIIIIlIlllIIIllI, final Long lllllllllllllIlIlIIIIlIlllIIIlll) {
        lllllllllllllIlIlIIIIlIlllIIIllI.writeLong((long)lllllllllllllIlIlIIIIlIlllIIIlll);
    }
    
    public long readPrimitive(final ByteBuf lllllllllllllIlIlIIIIlIllIlllllI) {
        return lllllllllllllIlIlIIIIlIllIlllllI.readLong();
    }
    
    @Deprecated
    @Override
    public Long read(final ByteBuf lllllllllllllIlIlIIIIlIlllIIllIl) {
        return lllllllllllllIlIlIIIIlIlllIIllIl.readLong();
    }
    
    public LongType() {
        super(Long.class);
    }
}
