package com.viaversion.viaversion.libs.opennbt.conversion;

import com.viaversion.viaversion.libs.opennbt.tag.builtin.*;

public interface TagConverter<T extends Tag, V>
{
    T convert(final V p0);
    
    V convert(final T p0);
}
