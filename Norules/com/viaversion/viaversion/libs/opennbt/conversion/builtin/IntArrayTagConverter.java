package com.viaversion.viaversion.libs.opennbt.conversion.builtin;

import com.viaversion.viaversion.libs.opennbt.conversion.*;
import com.viaversion.viaversion.libs.opennbt.tag.builtin.*;

public class IntArrayTagConverter implements TagConverter<IntArrayTag, int[]>
{
    @Override
    public int[] convert(final IntArrayTag llllllllllllllllIIllllIIIIlIllIl) {
        return llllllllllllllllIIllllIIIIlIllIl.getValue();
    }
    
    @Override
    public IntArrayTag convert(final int[] llllllllllllllllIIllllIIIIlIlIlI) {
        return new IntArrayTag(llllllllllllllllIIllllIIIIlIlIlI);
    }
}
