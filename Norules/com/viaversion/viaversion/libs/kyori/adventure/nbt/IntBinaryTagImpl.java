package com.viaversion.viaversion.libs.kyori.adventure.nbt;

import java.util.stream.*;
import com.viaversion.viaversion.libs.kyori.examination.*;
import org.jetbrains.annotations.*;

@Debug.Renderer(text = "String.valueOf(this.value) + \"i\"", hasChildren = "false")
final class IntBinaryTagImpl extends AbstractBinaryTag implements IntBinaryTag
{
    private final /* synthetic */ int value;
    
    @Override
    public boolean equals(@Nullable final Object lllllllllllllllllIIIlIllIllIIllI) {
        if (this == lllllllllllllllllIIIlIllIllIIllI) {
            return true;
        }
        if (lllllllllllllllllIIIlIllIllIIllI == null || this.getClass() != lllllllllllllllllIIIlIllIllIIllI.getClass()) {
            return false;
        }
        final IntBinaryTagImpl lllllllllllllllllIIIlIllIllIIIll = (IntBinaryTagImpl)lllllllllllllllllIIIlIllIllIIllI;
        return this.value == lllllllllllllllllIIIlIllIllIIIll.value;
    }
    
    @Override
    public short shortValue() {
        return (short)(this.value & 0xFFFF);
    }
    
    @Override
    public byte byteValue() {
        return (byte)(this.value & 0xFF);
    }
    
    @Override
    public float floatValue() {
        return (float)this.value;
    }
    
    @Override
    public double doubleValue() {
        return this.value;
    }
    
    @Override
    public int hashCode() {
        return Integer.hashCode(this.value);
    }
    
    IntBinaryTagImpl(final int lllllllllllllllllIIIlIlllIIIIIll) {
        this.value = lllllllllllllllllIIIlIlllIIIIIll;
    }
    
    @Override
    public int value() {
        return this.value;
    }
    
    @Override
    public long longValue() {
        return this.value;
    }
    
    @Override
    public int intValue() {
        return this.value;
    }
    
    @NotNull
    @Override
    public Stream<? extends ExaminableProperty> examinableProperties() {
        return Stream.of(ExaminableProperty.of("value", this.value));
    }
}
