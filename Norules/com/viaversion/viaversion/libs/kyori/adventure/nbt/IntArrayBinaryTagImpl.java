package com.viaversion.viaversion.libs.kyori.adventure.nbt;

import java.util.function.*;
import org.jetbrains.annotations.*;
import com.viaversion.viaversion.libs.kyori.examination.*;
import java.util.stream.*;
import java.util.*;

@Debug.Renderer(text = "\"int[\" + this.value.length + \"]\"", childrenArray = "this.value", hasChildren = "this.value.length > 0")
final class IntArrayBinaryTagImpl extends ArrayBinaryTagImpl implements IntArrayBinaryTag
{
    final /* synthetic */ int[] value;
    
    @Override
    public int[] value() {
        return Arrays.copyOf(this.value, this.value.length);
    }
    
    @Override
    public boolean equals(@Nullable final Object lllllllllllllIIIIlIllIllIlIIIlll) {
        if (this == lllllllllllllIIIIlIllIllIlIIIlll) {
            return true;
        }
        if (lllllllllllllIIIIlIllIllIlIIIlll == null || this.getClass() != lllllllllllllIIIIlIllIllIlIIIlll.getClass()) {
            return false;
        }
        final IntArrayBinaryTagImpl lllllllllllllIIIIlIllIllIlIIIlII = (IntArrayBinaryTagImpl)lllllllllllllIIIIlIllIllIlIIIlll;
        return Arrays.equals(this.value, lllllllllllllIIIIlIllIllIlIIIlII.value);
    }
    
    @Override
    public Spliterator.OfInt spliterator() {
        return Arrays.spliterator(this.value);
    }
    
    IntArrayBinaryTagImpl(final int... lllllllllllllIIIIlIllIllIlllIllI) {
        this.value = Arrays.copyOf(lllllllllllllIIIIlIllIllIlllIllI, lllllllllllllIIIIlIllIllIlllIllI.length);
    }
    
    @Override
    public void forEachInt(@NotNull final IntConsumer lllllllllllllIIIIlIllIllIlIlIlll) {
        for (int lllllllllllllIIIIlIllIllIlIlIllI = 0, lllllllllllllIIIIlIllIllIlIlIlIl = this.value.length; lllllllllllllIIIIlIllIllIlIlIllI < lllllllllllllIIIIlIllIllIlIlIlIl; ++lllllllllllllIIIIlIllIllIlIlIllI) {
            lllllllllllllIIIIlIllIllIlIlIlll.accept(this.value[lllllllllllllIIIIlIllIllIlIlIllI]);
        }
    }
    
    @Override
    public int hashCode() {
        return Arrays.hashCode(this.value);
    }
    
    @NotNull
    @Override
    public Stream<? extends ExaminableProperty> examinableProperties() {
        return Stream.of(ExaminableProperty.of("value", this.value));
    }
    
    static int[] value(final IntArrayBinaryTag lllllllllllllIIIIlIllIllIlIIllIl) {
        return (lllllllllllllIIIIlIllIllIlIIllIl instanceof IntArrayBinaryTagImpl) ? ((IntArrayBinaryTagImpl)lllllllllllllIIIIlIllIllIlIIllIl).value : lllllllllllllIIIIlIllIllIlIIllIl.value();
    }
    
    @Override
    public int size() {
        return this.value.length;
    }
    
    @Override
    public int get(final int lllllllllllllIIIIlIllIllIllIlIIl) {
        ArrayBinaryTagImpl.checkIndex(lllllllllllllIIIIlIllIllIllIlIIl, this.value.length);
        return this.value[lllllllllllllIIIIlIllIllIllIlIIl];
    }
    
    @NotNull
    @Override
    public IntStream stream() {
        return Arrays.stream(this.value);
    }
    
    @Override
    public PrimitiveIterator.OfInt iterator() {
        return new PrimitiveIterator.OfInt() {
            private /* synthetic */ int index;
            
            @Override
            public int nextInt() {
                if (!this.hasNext()) {
                    throw new NoSuchElementException();
                }
                return IntArrayBinaryTagImpl.this.value[this.index++];
            }
            
            @Override
            public boolean hasNext() {
                return this.index < IntArrayBinaryTagImpl.this.value.length - 1;
            }
        };
    }
}
