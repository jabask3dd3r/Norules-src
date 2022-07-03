package com.viaversion.viaversion.libs.kyori.adventure.nbt;

import java.util.stream.*;
import com.viaversion.viaversion.libs.kyori.examination.*;
import org.jetbrains.annotations.*;

@Debug.Renderer(text = "String.valueOf(this.value) + \"l\"", hasChildren = "false")
final class LongBinaryTagImpl extends AbstractBinaryTag implements LongBinaryTag
{
    private final /* synthetic */ long value;
    
    @Override
    public float floatValue() {
        return (float)this.value;
    }
    
    @Override
    public short shortValue() {
        return (short)(this.value & 0xFFFFL);
    }
    
    LongBinaryTagImpl(final long lllllllllllllllIllIIlIlIIlIIIIIl) {
        this.value = lllllllllllllllIllIIlIlIIlIIIIIl;
    }
    
    @Override
    public int hashCode() {
        return Long.hashCode(this.value);
    }
    
    @Override
    public long value() {
        return this.value;
    }
    
    @Override
    public long longValue() {
        return this.value;
    }
    
    @Override
    public byte byteValue() {
        return (byte)(this.value & 0xFFL);
    }
    
    @NotNull
    @Override
    public Stream<? extends ExaminableProperty> examinableProperties() {
        return Stream.of(ExaminableProperty.of("value", this.value));
    }
    
    @Override
    public int intValue() {
        return (int)this.value;
    }
    
    @Override
    public boolean equals(@Nullable final Object lllllllllllllllIllIIlIlIIIlIIlII) {
        if (this == lllllllllllllllIllIIlIlIIIlIIlII) {
            return true;
        }
        if (lllllllllllllllIllIIlIlIIIlIIlII == null || this.getClass() != lllllllllllllllIllIIlIlIIIlIIlII.getClass()) {
            return false;
        }
        final LongBinaryTagImpl lllllllllllllllIllIIlIlIIIlIIIIl = (LongBinaryTagImpl)lllllllllllllllIllIIlIlIIIlIIlII;
        return this.value == lllllllllllllllIllIIlIlIIIlIIIIl.value;
    }
    
    @Override
    public double doubleValue() {
        return (double)this.value;
    }
}
