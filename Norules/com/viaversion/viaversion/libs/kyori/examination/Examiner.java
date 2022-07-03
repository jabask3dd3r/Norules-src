package com.viaversion.viaversion.libs.kyori.examination;

import java.util.stream.*;

public interface Examiner<R>
{
    R examine(final byte[] lllllllllllllIIIlllIIlIllllIIlll);
    
    default R examine(final Examinable lllllllllllllIIIlllIIlIlllllIIlI) {
        return this.examine(lllllllllllllIIIlllIIlIlllllIIlI.examinableName(), lllllllllllllIIIlllIIlIlllllIIlI.examinableProperties());
    }
    
    R examine(final double lllllllllllllIIIlllIIlIllllIIlII);
    
    R examine(final int[] lllllllllllllIIIlllIIlIlllIlllll);
    
    R examine(final char[] lllllllllllllIIIlllIIlIllllIIlIl);
    
    R examine(final float[] lllllllllllllIIIlllIIlIllllIIIIl);
    
    R examine(final int lllllllllllllIIIlllIIlIllllIIIII);
    
    R examine(final byte lllllllllllllIIIlllIIlIllllIlIII);
    
    R examine(final short lllllllllllllIIIlllIIlIlllIlllII);
    
    R examine(final boolean lllllllllllllIIIlllIIlIllllIlIlI);
    
    R examine(final boolean[] lllllllllllllIIIlllIIlIllllIlIIl);
    
    R examine(final short[] lllllllllllllIIIlllIIlIlllIllIll);
    
    R examine(final String lllllllllllllIIIlllIIlIllllIllIl, final Stream<? extends ExaminableProperty> lllllllllllllIIIlllIIlIllllIllII);
    
    R examine(final long[] lllllllllllllIIIlllIIlIlllIlllIl);
    
    R examine(final String lllllllllllllIIIlllIIlIlllIllIlI);
    
    R examine(final long lllllllllllllIIIlllIIlIlllIllllI);
    
    R examine(final char lllllllllllllIIIlllIIlIllllIIllI);
    
    R examine(final double[] lllllllllllllIIIlllIIlIllllIIIll);
    
    R examine(final Object lllllllllllllIIIlllIIlIllllIlIll);
    
    R examine(final float lllllllllllllIIIlllIIlIllllIIIlI);
}
