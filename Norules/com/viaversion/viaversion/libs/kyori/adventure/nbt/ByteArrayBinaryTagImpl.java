package com.viaversion.viaversion.libs.kyori.adventure.nbt;

import java.util.stream.*;
import com.viaversion.viaversion.libs.kyori.examination.*;
import org.jetbrains.annotations.*;
import java.util.*;

@Debug.Renderer(text = "\"byte[\" + this.value.length + \"]\"", childrenArray = "this.value", hasChildren = "this.value.length > 0")
final class ByteArrayBinaryTagImpl extends ArrayBinaryTagImpl implements ByteArrayBinaryTag
{
    final /* synthetic */ byte[] value;
    
    @Override
    public byte[] value() {
        return Arrays.copyOf(this.value, this.value.length);
    }
    
    @Override
    public boolean equals(@Nullable final Object lllllllllllllIlllIlIllIlllIlIlll) {
        if (this == lllllllllllllIlllIlIllIlllIlIlll) {
            return true;
        }
        if (lllllllllllllIlllIlIllIlllIlIlll == null || this.getClass() != lllllllllllllIlllIlIllIlllIlIlll.getClass()) {
            return false;
        }
        final ByteArrayBinaryTagImpl lllllllllllllIlllIlIllIlllIlIlII = (ByteArrayBinaryTagImpl)lllllllllllllIlllIlIllIlllIlIlll;
        return Arrays.equals(this.value, lllllllllllllIlllIlIllIlllIlIlII.value);
    }
    
    @NotNull
    @Override
    public Stream<? extends ExaminableProperty> examinableProperties() {
        return Stream.of(ExaminableProperty.of("value", this.value));
    }
    
    ByteArrayBinaryTagImpl(final byte[] lllllllllllllIlllIlIllIlllllIIII) {
        this.value = Arrays.copyOf(lllllllllllllIlllIlIllIlllllIIII, lllllllllllllIlllIlIllIlllllIIII.length);
    }
    
    @Override
    public byte get(final int lllllllllllllIlllIlIllIllllIIIll) {
        ArrayBinaryTagImpl.checkIndex(lllllllllllllIlllIlIllIllllIIIll, this.value.length);
        return this.value[lllllllllllllIlllIlIllIllllIIIll];
    }
    
    @Override
    public int size() {
        return this.value.length;
    }
    
    @Override
    public int hashCode() {
        return Arrays.hashCode(this.value);
    }
    
    static byte[] value(final ByteArrayBinaryTag lllllllllllllIlllIlIllIlllIlllIl) {
        return (lllllllllllllIlllIlIllIlllIlllIl instanceof ByteArrayBinaryTagImpl) ? ((ByteArrayBinaryTagImpl)lllllllllllllIlllIlIllIlllIlllIl).value : lllllllllllllIlllIlIllIlllIlllIl.value();
    }
    
    @Override
    public Iterator<Byte> iterator() {
        return new Iterator<Byte>() {
            private /* synthetic */ int index;
            
            @Override
            public Byte next() {
                return ByteArrayBinaryTagImpl.this.value[this.index++];
            }
            
            @Override
            public boolean hasNext() {
                return this.index < ByteArrayBinaryTagImpl.this.value.length - 1;
            }
        };
    }
}
