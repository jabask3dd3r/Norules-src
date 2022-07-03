package com.viaversion.viaversion.api.type.types;

import com.viaversion.viaversion.api.type.*;
import io.netty.buffer.*;

public class IntType extends Type<Integer> implements TypeConverter<Integer>
{
    @Override
    public Integer from(final Object lllllllllllllllIlIlIIlIIllllIllI) {
        if (lllllllllllllllIlIlIIlIIllllIllI instanceof Number) {
            return ((Number)lllllllllllllllIlIlIIlIIllllIllI).intValue();
        }
        if (lllllllllllllllIlIlIIlIIllllIllI instanceof Boolean) {
            return ((boolean)lllllllllllllllIlIlIIlIIllllIllI) ? 1 : 0;
        }
        return (Integer)lllllllllllllllIlIlIIlIIllllIllI;
    }
    
    @Override
    public void write(final ByteBuf lllllllllllllllIlIlIIlIIlllllIll, final Integer lllllllllllllllIlIlIIlIIllllllII) {
        lllllllllllllllIlIlIIlIIlllllIll.writeInt((int)lllllllllllllllIlIlIIlIIllllllII);
    }
    
    @Override
    public Integer read(final ByteBuf lllllllllllllllIlIlIIlIlIIIIIIIl) {
        return lllllllllllllllIlIlIIlIlIIIIIIIl.readInt();
    }
    
    public IntType() {
        super(Integer.class);
    }
}
