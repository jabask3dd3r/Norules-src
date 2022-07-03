package com.viaversion.viaversion.api.type.types;

import com.viaversion.viaversion.api.type.*;
import io.netty.buffer.*;

public class UnsignedShortType extends Type<Integer> implements TypeConverter<Integer>
{
    @Override
    public Integer from(final Object lllllllllllllllIIlllllIIIllllllI) {
        if (lllllllllllllllIIlllllIIIllllllI instanceof Number) {
            return ((Number)lllllllllllllllIIlllllIIIllllllI).intValue();
        }
        if (lllllllllllllllIIlllllIIIllllllI instanceof Boolean) {
            return ((boolean)lllllllllllllllIIlllllIIIllllllI) ? 1 : 0;
        }
        return (Integer)lllllllllllllllIIlllllIIIllllllI;
    }
    
    @Override
    public void write(final ByteBuf lllllllllllllllIIlllllIIlIIIIlIl, final Integer lllllllllllllllIIlllllIIlIIIIIlI) {
        lllllllllllllllIIlllllIIlIIIIlIl.writeShort((int)lllllllllllllllIIlllllIIlIIIIIlI);
    }
    
    public UnsignedShortType() {
        super(Integer.class);
    }
    
    @Override
    public Integer read(final ByteBuf lllllllllllllllIIlllllIIlIIIlIIl) {
        return lllllllllllllllIIlllllIIlIIIlIIl.readUnsignedShort();
    }
}
