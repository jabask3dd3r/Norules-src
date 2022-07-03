package com.viaversion.viaversion.libs.opennbt.conversion.builtin;

import com.viaversion.viaversion.libs.opennbt.conversion.*;
import com.viaversion.viaversion.libs.opennbt.tag.builtin.*;

public class ShortTagConverter implements TagConverter<ShortTag, Short>
{
    @Override
    public ShortTag convert(final Short lllllllllllllllIlIIIIIIIIIIlIlII) {
        return new ShortTag(lllllllllllllllIlIIIIIIIIIIlIlII);
    }
    
    @Override
    public Short convert(final ShortTag lllllllllllllllIlIIIIIIIIIIllIII) {
        return lllllllllllllllIlIIIIIIIIIIllIII.getValue();
    }
}
