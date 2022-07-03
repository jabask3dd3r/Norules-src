package com.viaversion.viaversion.libs.kyori.adventure.key;

import com.viaversion.viaversion.libs.kyori.examination.string.*;
import org.jetbrains.annotations.*;
import java.util.stream.*;
import com.viaversion.viaversion.libs.kyori.examination.*;

final class KeyedValueImpl<T> implements Examinable, KeyedValue<T>
{
    private final /* synthetic */ T value;
    private final /* synthetic */ Key key;
    
    @NotNull
    @Override
    public T value() {
        return this.value;
    }
    
    @Override
    public String toString() {
        return this.examine((Examiner<String>)StringExaminer.simpleEscaping());
    }
    
    @Override
    public boolean equals(@Nullable final Object lllllllllllllIllllllllllllIlIlIl) {
        if (this == lllllllllllllIllllllllllllIlIlIl) {
            return true;
        }
        if (lllllllllllllIllllllllllllIlIlIl == null || this.getClass() != lllllllllllllIllllllllllllIlIlIl.getClass()) {
            return false;
        }
        final KeyedValueImpl<?> lllllllllllllIllllllllllllIlIIlI = (KeyedValueImpl<?>)lllllllllllllIllllllllllllIlIlIl;
        return this.key.equals(lllllllllllllIllllllllllllIlIIlI.key) && this.value.equals(lllllllllllllIllllllllllllIlIIlI.value);
    }
    
    @NotNull
    @Override
    public Key key() {
        return this.key;
    }
    
    @NotNull
    @Override
    public Stream<? extends ExaminableProperty> examinableProperties() {
        return Stream.of((ExaminableProperty[])new ExaminableProperty[] { ExaminableProperty.of("key", this.key), ExaminableProperty.of("value", this.value) });
    }
    
    KeyedValueImpl(final Key lllllllllllllIlllllllllllllIIllI, final T lllllllllllllIlllllllllllllIIlIl) {
        this.key = lllllllllllllIlllllllllllllIIllI;
        this.value = lllllllllllllIlllllllllllllIIlIl;
    }
    
    @Override
    public int hashCode() {
        int lllllllllllllIllllllllllllIIlIll = this.key.hashCode();
        lllllllllllllIllllllllllllIIlIll = 31 * lllllllllllllIllllllllllllIIlIll + this.value.hashCode();
        return lllllllllllllIllllllllllllIIlIll;
    }
}
