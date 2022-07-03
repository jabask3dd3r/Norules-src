package com.viaversion.viaversion.libs.kyori.adventure.nbt;

import java.util.function.*;
import org.jetbrains.annotations.*;
import java.util.*;
import java.util.stream.*;

public interface LongArrayBinaryTag extends ArrayBinaryTag, Iterable<Long>
{
    PrimitiveIterator.OfLong iterator();
    
    void forEachLong(@NotNull final LongConsumer lllllllllllllIlllIlllIIlllllIIlI);
    
    int size();
    
    @NotNull
    default BinaryTagType<LongArrayBinaryTag> type() {
        return BinaryTagTypes.LONG_ARRAY;
    }
    
    long get(final int lllllllllllllIlllIlllIIlllllIIll);
    
    @NotNull
    default LongArrayBinaryTag of(final long... lllllllllllllIlllIlllIIlllllIlll) {
        return new LongArrayBinaryTagImpl(lllllllllllllIlllIlllIIlllllIlll);
    }
    
    long[] value();
    
    @NotNull
    LongStream stream();
    
    Spliterator.OfLong spliterator();
}
