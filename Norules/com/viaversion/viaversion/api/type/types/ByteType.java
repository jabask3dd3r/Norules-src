package com.viaversion.viaversion.api.type.types;

import com.viaversion.viaversion.api.type.*;
import io.netty.buffer.*;

public class ByteType extends Type<Byte> implements TypeConverter<Byte>
{
    public ByteType() {
        super(Byte.class);
    }
    
    @Override
    public Byte read(final ByteBuf llllllllllllllIlIIIllIlIllIIlllI) {
        return llllllllllllllIlIIIllIlIllIIlllI.readByte();
    }
    
    @Override
    public Byte from(final Object llllllllllllllIlIIIllIlIllIIIIll) {
        if (llllllllllllllIlIIIllIlIllIIIIll instanceof Number) {
            return ((Number)llllllllllllllIlIIIllIlIllIIIIll).byteValue();
        }
        if (llllllllllllllIlIIIllIlIllIIIIll instanceof Boolean) {
            return (byte)(((boolean)llllllllllllllIlIIIllIlIllIIIIll) ? 1 : 0);
        }
        return (Byte)llllllllllllllIlIIIllIlIllIIIIll;
    }
    
    @Override
    public void write(final ByteBuf llllllllllllllIlIIIllIlIllIIlIIl, final Byte llllllllllllllIlIIIllIlIllIIIllI) {
        llllllllllllllIlIIIllIlIllIIlIIl.writeByte((int)llllllllllllllIlIIIllIlIllIIIllI);
    }
}
