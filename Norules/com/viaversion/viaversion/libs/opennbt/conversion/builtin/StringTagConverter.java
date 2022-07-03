package com.viaversion.viaversion.libs.opennbt.conversion.builtin;

import com.viaversion.viaversion.libs.opennbt.conversion.*;
import com.viaversion.viaversion.libs.opennbt.tag.builtin.*;

public class StringTagConverter implements TagConverter<StringTag, String>
{
    @Override
    public StringTag convert(final String llIlllIlIII) {
        return new StringTag(llIlllIlIII);
    }
    
    @Override
    public String convert(final StringTag llIlllIllII) {
        return llIlllIllII.getValue();
    }
}
