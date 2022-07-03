package com.viaversion.viaversion.api.type.types.minecraft;

import com.viaversion.viaversion.api.type.*;
import io.netty.buffer.*;

public class OptionalVarIntType extends Type<Integer>
{
    @Override
    public void write(final ByteBuf lllllllllllllllIllllllIllIIlllII, final Integer lllllllllllllllIllllllIllIIlllIl) throws Exception {
        if (lllllllllllllllIllllllIllIIlllIl == null) {
            Type.VAR_INT.writePrimitive(lllllllllllllllIllllllIllIIlllII, 0);
        }
        else {
            Type.VAR_INT.writePrimitive(lllllllllllllllIllllllIllIIlllII, lllllllllllllllIllllllIllIIlllIl + 1);
        }
    }
    
    @Override
    public Integer read(final ByteBuf lllllllllllllllIllllllIllIlIIlIl) throws Exception {
        final int lllllllllllllllIllllllIllIlIIlII = Type.VAR_INT.readPrimitive(lllllllllllllllIllllllIllIlIIlIl);
        if (lllllllllllllllIllllllIllIlIIlII == 0) {
            return null;
        }
        return lllllllllllllllIllllllIllIlIIlII - 1;
    }
    
    public OptionalVarIntType() {
        super(Integer.class);
    }
}
