package com.viaversion.viaversion.api.type.types;

import com.viaversion.viaversion.api.type.*;
import io.netty.buffer.*;

public class ShortType extends Type<Short> implements TypeConverter<Short>
{
    @Deprecated
    @Override
    public Short read(final ByteBuf lllllllllllllIllIllIlIIllIlllIlI) {
        return lllllllllllllIllIllIlIIllIlllIlI.readShort();
    }
    
    @Override
    public Short from(final Object lllllllllllllIllIllIlIIllIllIIII) {
        if (lllllllllllllIllIllIlIIllIllIIII instanceof Number) {
            return ((Number)lllllllllllllIllIllIlIIllIllIIII).shortValue();
        }
        if (lllllllllllllIllIllIlIIllIllIIII instanceof Boolean) {
            return (short)(((boolean)lllllllllllllIllIllIlIIllIllIIII) ? 1 : 0);
        }
        return (Short)lllllllllllllIllIllIlIIllIllIIII;
    }
    
    public short readPrimitive(final ByteBuf lllllllllllllIllIllIlIIlllIIIlIl) {
        return lllllllllllllIllIllIlIIlllIIIlIl.readShort();
    }
    
    @Deprecated
    @Override
    public void write(final ByteBuf lllllllllllllIllIllIlIIllIllIlII, final Short lllllllllllllIllIllIlIIllIllIIll) {
        lllllllllllllIllIllIlIIllIllIlII.writeShort((int)lllllllllllllIllIllIlIIllIllIIll);
    }
    
    public ShortType() {
        super(Short.class);
    }
    
    public void writePrimitive(final ByteBuf lllllllllllllIllIllIlIIlllIIIIIl, final short lllllllllllllIllIllIlIIlllIIIIII) {
        lllllllllllllIllIllIlIIlllIIIIIl.writeShort((int)lllllllllllllIllIllIlIIlllIIIIII);
    }
}
