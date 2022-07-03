package com.viaversion.viaversion.api.type.types;

import com.viaversion.viaversion.api.type.*;
import io.netty.buffer.*;

public class UnsignedByteType extends Type<Short> implements TypeConverter<Short>
{
    @Override
    public Short read(final ByteBuf lllllllllllllIIIlIlIIlIIIIIIlIll) {
        return lllllllllllllIIIlIlIIlIIIIIIlIll.readUnsignedByte();
    }
    
    public UnsignedByteType() {
        super("Unsigned Byte", Short.class);
    }
    
    @Override
    public Short from(final Object lllllllllllllIIIlIlIIlIIIIIIIIII) {
        if (lllllllllllllIIIlIlIIlIIIIIIIIII instanceof Number) {
            return ((Number)lllllllllllllIIIlIlIIlIIIIIIIIII).shortValue();
        }
        if (lllllllllllllIIIlIlIIlIIIIIIIIII instanceof Boolean) {
            return (short)(((boolean)lllllllllllllIIIlIlIIlIIIIIIIIII) ? 1 : 0);
        }
        return (Short)lllllllllllllIIIlIlIIlIIIIIIIIII;
    }
    
    @Override
    public void write(final ByteBuf lllllllllllllIIIlIlIIlIIIIIIIlll, final Short lllllllllllllIIIlIlIIlIIIIIIIlII) {
        lllllllllllllIIIlIlIIlIIIIIIIlll.writeByte((int)lllllllllllllIIIlIlIIlIIIIIIIlII);
    }
}
