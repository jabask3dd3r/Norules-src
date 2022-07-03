package com.viaversion.viaversion.libs.opennbt.conversion.builtin;

import com.viaversion.viaversion.libs.opennbt.conversion.*;
import com.viaversion.viaversion.libs.opennbt.tag.builtin.*;

public class LongTagConverter implements TagConverter<LongTag, Long>
{
    @Override
    public LongTag convert(final Long lllllllllllllIlIIlIIIlIlIIIIllIl) {
        return new LongTag(lllllllllllllIlIIlIIIlIlIIIIllIl);
    }
    
    @Override
    public Long convert(final LongTag lllllllllllllIlIIlIIIlIlIIIlIlII) {
        return lllllllllllllIlIIlIIIlIlIIIlIlII.getValue();
    }
}
