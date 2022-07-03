package com.viaversion.viaversion.libs.opennbt.conversion.builtin;

import com.viaversion.viaversion.libs.opennbt.conversion.*;
import com.viaversion.viaversion.libs.opennbt.tag.builtin.*;

public class IntTagConverter implements TagConverter<IntTag, Integer>
{
    @Override
    public IntTag convert(final Integer lllllllllllllIIIlIlIIlllIIllIIII) {
        return new IntTag(lllllllllllllIIIlIlIIlllIIllIIII);
    }
    
    @Override
    public Integer convert(final IntTag lllllllllllllIIIlIlIIlllIIllIIll) {
        return lllllllllllllIIIlIlIIlllIIllIIll.getValue();
    }
}
