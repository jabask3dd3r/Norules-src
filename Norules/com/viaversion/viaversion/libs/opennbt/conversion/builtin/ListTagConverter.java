package com.viaversion.viaversion.libs.opennbt.conversion.builtin;

import java.util.*;
import com.viaversion.viaversion.libs.opennbt.tag.builtin.*;
import com.viaversion.viaversion.libs.opennbt.conversion.*;

public class ListTagConverter implements TagConverter<ListTag, List>
{
    @Override
    public List convert(final ListTag lllllllllllllIllIlIllIIlllIIIllI) {
        final List<Object> lllllllllllllIllIlIllIIlllIIlIII = new ArrayList<Object>();
        final List<? extends Tag> lllllllllllllIllIlIllIIlllIIIlll = lllllllllllllIllIlIllIIlllIIIllI.getValue();
        for (final Tag lllllllllllllIllIlIllIIlllIIlIll : lllllllllllllIllIlIllIIlllIIIlll) {
            lllllllllllllIllIlIllIIlllIIlIII.add(ConverterRegistry.convertToValue(lllllllllllllIllIlIllIIlllIIlIll));
        }
        return lllllllllllllIllIlIllIIlllIIlIII;
    }
    
    @Override
    public ListTag convert(final List lllllllllllllIllIlIllIIllIlllIll) {
        final List<Tag> lllllllllllllIllIlIllIIllIlllIlI = new ArrayList<Tag>();
        for (final Object lllllllllllllIllIlIllIIllIllllIl : lllllllllllllIllIlIllIIllIlllIll) {
            lllllllllllllIllIlIllIIllIlllIlI.add(ConverterRegistry.convertToTag(lllllllllllllIllIlIllIIllIllllIl));
        }
        return new ListTag(lllllllllllllIllIlIllIIllIlllIlI);
    }
}
