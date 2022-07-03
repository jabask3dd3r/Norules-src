package com.viaversion.viaversion.libs.opennbt.conversion.builtin;

import java.util.*;
import com.viaversion.viaversion.libs.opennbt.tag.builtin.*;
import com.viaversion.viaversion.libs.opennbt.conversion.*;

public class CompoundTagConverter implements TagConverter<CompoundTag, Map>
{
    @Override
    public CompoundTag convert(final Map lllllllllllllIllllllIlllIIIIlIll) {
        final Map<String, Tag> lllllllllllllIllllllIlllIIIIlIlI = new HashMap<String, Tag>();
        for (final Object lllllllllllllIllllllIlllIIIIllIl : lllllllllllllIllllllIlllIIIIlIll.keySet()) {
            final String lllllllllllllIllllllIlllIIIIlllI = (String)lllllllllllllIllllllIlllIIIIllIl;
            lllllllllllllIllllllIlllIIIIlIlI.put(lllllllllllllIllllllIlllIIIIlllI, ConverterRegistry.convertToTag(lllllllllllllIllllllIlllIIIIlIll.get(lllllllllllllIllllllIlllIIIIlllI)));
        }
        return new CompoundTag(lllllllllllllIllllllIlllIIIIlIlI);
    }
    
    @Override
    public Map convert(final CompoundTag lllllllllllllIllllllIlllIIIllIll) {
        final Map<String, Object> lllllllllllllIllllllIlllIIIllIlI = new HashMap<String, Object>();
        final Map<String, Tag> lllllllllllllIllllllIlllIIIllIIl = lllllllllllllIllllllIlllIIIllIll.getValue();
        for (final Map.Entry<String, Tag> lllllllllllllIllllllIlllIIIlllIl : lllllllllllllIllllllIlllIIIllIIl.entrySet()) {
            lllllllllllllIllllllIlllIIIllIlI.put(lllllllllllllIllllllIlllIIIlllIl.getKey(), ConverterRegistry.convertToValue(lllllllllllllIllllllIlllIIIlllIl.getValue()));
        }
        return lllllllllllllIllllllIlllIIIllIlI;
    }
}
