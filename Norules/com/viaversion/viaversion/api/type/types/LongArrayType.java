package com.viaversion.viaversion.api.type.types;

import com.viaversion.viaversion.api.type.*;
import io.netty.buffer.*;

public class LongArrayType extends Type<long[]>
{
    @Override
    public void write(final ByteBuf llllllllllllIllllllIlIlllllIlIII, final long[] llllllllllllIllllllIlIlllllIIlll) throws Exception {
        Type.VAR_INT.writePrimitive(llllllllllllIllllllIlIlllllIlIII, llllllllllllIllllllIlIlllllIIlll.length);
        final short llllllllllllIllllllIlIlllllIIllI = (Object)llllllllllllIllllllIlIlllllIIlll;
        final short llllllllllllIllllllIlIlllllIIlIl = (short)llllllllllllIllllllIlIlllllIIllI.length;
        for (double llllllllllllIllllllIlIlllllIIlII = 0; llllllllllllIllllllIlIlllllIIlII < llllllllllllIllllllIlIlllllIIlIl; ++llllllllllllIllllllIlIlllllIIlII) {
            final long llllllllllllIllllllIlIlllllIllII = llllllllllllIllllllIlIlllllIIllI[llllllllllllIllllllIlIlllllIIlII];
            Type.LONG.writePrimitive(llllllllllllIllllllIlIlllllIlIII, llllllllllllIllllllIlIlllllIllII);
        }
    }
    
    public LongArrayType() {
        super(long[].class);
    }
    
    @Override
    public long[] read(final ByteBuf llllllllllllIllllllIlIllllllIllI) throws Exception {
        final int llllllllllllIllllllIlIlllllllIII = Type.VAR_INT.readPrimitive(llllllllllllIllllllIlIllllllIllI);
        final long[] llllllllllllIllllllIlIllllllIlll = new long[llllllllllllIllllllIlIlllllllIII];
        for (int llllllllllllIllllllIlIlllllllIll = 0; llllllllllllIllllllIlIlllllllIll < llllllllllllIllllllIlIllllllIlll.length; ++llllllllllllIllllllIlIlllllllIll) {
            llllllllllllIllllllIlIllllllIlll[llllllllllllIllllllIlIlllllllIll] = Type.LONG.readPrimitive(llllllllllllIllllllIlIllllllIllI);
        }
        return llllllllllllIllllllIlIllllllIlll;
    }
}
