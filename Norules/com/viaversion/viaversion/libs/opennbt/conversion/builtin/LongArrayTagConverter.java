package com.viaversion.viaversion.libs.opennbt.conversion.builtin;

import com.viaversion.viaversion.libs.opennbt.conversion.*;
import com.viaversion.viaversion.libs.opennbt.tag.builtin.*;

public class LongArrayTagConverter implements TagConverter<LongArrayTag, long[]>
{
    @Override
    public LongArrayTag convert(final long[] lllllllllllllIlIlIIllIlIIllIIIIl) {
        return new LongArrayTag(lllllllllllllIlIlIIllIlIIllIIIIl);
    }
    
    @Override
    public long[] convert(final LongArrayTag lllllllllllllIlIlIIllIlIIllIIlII) {
        return lllllllllllllIlIlIIllIlIIllIIlII.getValue();
    }
}
