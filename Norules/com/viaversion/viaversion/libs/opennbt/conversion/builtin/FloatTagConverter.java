package com.viaversion.viaversion.libs.opennbt.conversion.builtin;

import com.viaversion.viaversion.libs.opennbt.conversion.*;
import com.viaversion.viaversion.libs.opennbt.tag.builtin.*;

public class FloatTagConverter implements TagConverter<FloatTag, Float>
{
    @Override
    public Float convert(final FloatTag llllllllllllllIllIIllIIIIllIIIll) {
        return llllllllllllllIllIIllIIIIllIIIll.getValue();
    }
    
    @Override
    public FloatTag convert(final Float llllllllllllllIllIIllIIIIlIlllll) {
        return new FloatTag(llllllllllllllIllIIllIIIIlIlllll);
    }
}
