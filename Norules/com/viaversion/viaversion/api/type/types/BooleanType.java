package com.viaversion.viaversion.api.type.types;

import com.viaversion.viaversion.api.type.*;
import io.netty.buffer.*;

public class BooleanType extends Type<Boolean> implements TypeConverter<Boolean>
{
    @Override
    public Boolean from(final Object lllllllllllllIllIIIllIllllIIIIII) {
        if (lllllllllllllIllIIIllIllllIIIIII instanceof Number) {
            return ((Number)lllllllllllllIllIIIllIllllIIIIII).intValue() == 1;
        }
        return (Boolean)lllllllllllllIllIIIllIllllIIIIII;
    }
    
    @Override
    public void write(final ByteBuf lllllllllllllIllIIIllIllllIIIlll, final Boolean lllllllllllllIllIIIllIllllIIIlII) {
        lllllllllllllIllIIIllIllllIIIlll.writeBoolean((boolean)lllllllllllllIllIIIllIllllIIIlII);
    }
    
    @Override
    public Boolean read(final ByteBuf lllllllllllllIllIIIllIllllIIllII) {
        return lllllllllllllIllIIIllIllllIIllII.readBoolean();
    }
    
    public BooleanType() {
        super(Boolean.class);
    }
}
