package com.viaversion.viaversion.libs.kyori.adventure.nbt;

import com.viaversion.viaversion.libs.kyori.examination.*;
import java.util.stream.*;
import org.jetbrains.annotations.*;
import java.util.*;
import java.util.function.*;

@Debug.Renderer(text = "\"long[\" + this.value.length + \"]\"", childrenArray = "this.value", hasChildren = "this.value.length > 0")
final class LongArrayBinaryTagImpl extends ArrayBinaryTagImpl implements LongArrayBinaryTag
{
    final /* synthetic */ long[] value;
    
    LongArrayBinaryTagImpl(final long[] lllllllllllllllIIllIIIIlllllllll) {
        this.value = Arrays.copyOf(lllllllllllllllIIllIIIIlllllllll, lllllllllllllllIIllIIIIlllllllll.length);
    }
    
    @Override
    public long[] value() {
        return Arrays.copyOf(this.value, this.value.length);
    }
    
    @NotNull
    @Override
    public Stream<? extends ExaminableProperty> examinableProperties() {
        return Stream.of(ExaminableProperty.of("value", this.value));
    }
    
    @Override
    public Spliterator.OfLong spliterator() {
        return Arrays.spliterator(this.value);
    }
    
    @Override
    public long get(final int lllllllllllllllIIllIIIIlllllIIlI) {
        ArrayBinaryTagImpl.checkIndex(lllllllllllllllIIllIIIIlllllIIlI, this.value.length);
        return this.value[lllllllllllllllIIllIIIIlllllIIlI];
    }
    
    @Override
    public int hashCode() {
        return Arrays.hashCode(this.value);
    }
    
    @NotNull
    @Override
    public LongStream stream() {
        return Arrays.stream(this.value);
    }
    
    static long[] value(final LongArrayBinaryTag lllllllllllllllIIllIIIIlllIlIllI) {
        return (lllllllllllllllIIllIIIIlllIlIllI instanceof LongArrayBinaryTagImpl) ? ((LongArrayBinaryTagImpl)lllllllllllllllIIllIIIIlllIlIllI).value : lllllllllllllllIIllIIIIlllIlIllI.value();
    }
    
    @Override
    public PrimitiveIterator.OfLong iterator() {
        return new PrimitiveIterator.OfLong() {
            private /* synthetic */ int index;
            
            @Override
            public boolean hasNext() {
                return this.index < LongArrayBinaryTagImpl.this.value.length - 1;
            }
            
            @Override
            public long nextLong() {
                if (!this.hasNext()) {
                    throw new NoSuchElementException();
                }
                return LongArrayBinaryTagImpl.this.value[this.index++];
            }
        };
    }
    
    @Override
    public boolean equals(@Nullable final Object lllllllllllllllIIllIIIIlllIlIIII) {
        if (this == lllllllllllllllIIllIIIIlllIlIIII) {
            return true;
        }
        if (lllllllllllllllIIllIIIIlllIlIIII == null || this.getClass() != lllllllllllllllIIllIIIIlllIlIIII.getClass()) {
            return false;
        }
        final LongArrayBinaryTagImpl lllllllllllllllIIllIIIIlllIIllIl = (LongArrayBinaryTagImpl)lllllllllllllllIIllIIIIlllIlIIII;
        return Arrays.equals(this.value, lllllllllllllllIIllIIIIlllIIllIl.value);
    }
    
    @Override
    public void forEachLong(@NotNull final LongConsumer lllllllllllllllIIllIIIIllllIIIII) {
        for (int lllllllllllllllIIllIIIIlllIlllll = 0, lllllllllllllllIIllIIIIlllIllllI = this.value.length; lllllllllllllllIIllIIIIlllIlllll < lllllllllllllllIIllIIIIlllIllllI; ++lllllllllllllllIIllIIIIlllIlllll) {
            lllllllllllllllIIllIIIIllllIIIII.accept(this.value[lllllllllllllllIIllIIIIlllIlllll]);
        }
    }
    
    @Override
    public int size() {
        return this.value.length;
    }
}
