package com.viaversion.viaversion.libs.kyori.adventure.nbt;

import org.jetbrains.annotations.*;
import java.util.function.*;
import java.util.stream.*;
import java.util.*;

public interface IntArrayBinaryTag extends ArrayBinaryTag, Iterable<Integer>
{
    @NotNull
    default BinaryTagType<IntArrayBinaryTag> type() {
        return BinaryTagTypes.INT_ARRAY;
    }
    
    Spliterator.OfInt spliterator();
    
    void forEachInt(@NotNull final IntConsumer llllllllllllllllIlIlIlllllIlIIIl);
    
    PrimitiveIterator.OfInt iterator();
    
    int get(final int llllllllllllllllIlIlIlllllIlIIlI);
    
    int[] value();
    
    @NotNull
    IntStream stream();
    
    @NotNull
    default IntArrayBinaryTag of(final int... llllllllllllllllIlIlIlllllIllIll) {
        return new IntArrayBinaryTagImpl(llllllllllllllllIlIlIlllllIllIll);
    }
    
    int size();
}
