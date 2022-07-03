package com.viaversion.viaversion.libs.opennbt.conversion.builtin;

import com.viaversion.viaversion.libs.opennbt.conversion.*;
import com.viaversion.viaversion.libs.opennbt.tag.builtin.*;

public class DoubleTagConverter implements TagConverter<DoubleTag, Double>
{
    @Override
    public DoubleTag convert(final Double lllllllllllllIIlIIlIIIIIllIllllI) {
        return new DoubleTag(lllllllllllllIIlIIlIIIIIllIllllI);
    }
    
    @Override
    public Double convert(final DoubleTag lllllllllllllIIlIIlIIIIIlllIIIlI) {
        return lllllllllllllIIlIIlIIIIIlllIIIlI.getValue();
    }
}
