package com.viaversion.viaversion.api.type.types;

import com.viaversion.viaversion.api.type.*;
import io.netty.buffer.*;
import com.google.common.base.*;

public class VarIntArrayType extends Type<int[]>
{
    public VarIntArrayType() {
        super(int[].class);
    }
    
    @Override
    public int[] read(final ByteBuf lllllllllllllllllIllIIlIllllIIIl) throws Exception {
        final int lllllllllllllllllIllIIlIllllIlII = Type.VAR_INT.readPrimitive(lllllllllllllllllIllIIlIllllIIIl);
        Preconditions.checkArgument(lllllllllllllllllIllIIlIllllIIIl.isReadable(lllllllllllllllllIllIIlIllllIlII));
        final int[] lllllllllllllllllIllIIlIllllIIlI = new int[lllllllllllllllllIllIIlIllllIlII];
        for (int lllllllllllllllllIllIIlIlllllIll = 0; lllllllllllllllllIllIIlIlllllIll < lllllllllllllllllIllIIlIllllIIlI.length; ++lllllllllllllllllIllIIlIlllllIll) {
            lllllllllllllllllIllIIlIllllIIlI[lllllllllllllllllIllIIlIlllllIll] = Type.VAR_INT.readPrimitive(lllllllllllllllllIllIIlIllllIIIl);
        }
        return lllllllllllllllllIllIIlIllllIIlI;
    }
    
    @Override
    public void write(final ByteBuf lllllllllllllllllIllIIlIllIIllIl, final int[] lllllllllllllllllIllIIlIllIIllll) throws Exception {
        Type.VAR_INT.writePrimitive(lllllllllllllllllIllIIlIllIIllIl, lllllllllllllllllIllIIlIllIIllll.length);
        final double lllllllllllllllllIllIIlIllIIlIll = (Object)lllllllllllllllllIllIIlIllIIllll;
        for (String lllllllllllllllllIllIIlIllIIlIlI = (String)lllllllllllllllllIllIIlIllIIlIll.length, lllllllllllllllllIllIIlIllIIlIIl = (String)0; lllllllllllllllllIllIIlIllIIlIIl < lllllllllllllllllIllIIlIllIIlIlI; ++lllllllllllllllllIllIIlIllIIlIIl) {
            final int lllllllllllllllllIllIIlIllIlIlIl = lllllllllllllllllIllIIlIllIIlIll[lllllllllllllllllIllIIlIllIIlIIl];
            Type.VAR_INT.writePrimitive(lllllllllllllllllIllIIlIllIIllIl, lllllllllllllllllIllIIlIllIlIlIl);
        }
    }
}
