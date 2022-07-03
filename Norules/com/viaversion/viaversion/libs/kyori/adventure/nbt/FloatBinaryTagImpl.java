package com.viaversion.viaversion.libs.kyori.adventure.nbt;

import java.util.stream.*;
import com.viaversion.viaversion.libs.kyori.examination.*;
import org.jetbrains.annotations.*;

@Debug.Renderer(text = "String.valueOf(this.value) + \"f\"", hasChildren = "false")
final class FloatBinaryTagImpl extends AbstractBinaryTag implements FloatBinaryTag
{
    private final /* synthetic */ float value;
    
    @Override
    public boolean equals(@Nullable final Object llllllllllllllllllIIIIIIIllIIllI) {
        if (this == llllllllllllllllllIIIIIIIllIIllI) {
            return true;
        }
        if (llllllllllllllllllIIIIIIIllIIllI == null || this.getClass() != llllllllllllllllllIIIIIIIllIIllI.getClass()) {
            return false;
        }
        final FloatBinaryTagImpl llllllllllllllllllIIIIIIIllIIIll = (FloatBinaryTagImpl)llllllllllllllllllIIIIIIIllIIllI;
        return Float.floatToIntBits(this.value) == Float.floatToIntBits(llllllllllllllllllIIIIIIIllIIIll.value);
    }
    
    @Override
    public long longValue() {
        return (long)this.value;
    }
    
    @Override
    public int hashCode() {
        return Float.hashCode(this.value);
    }
    
    @Override
    public float value() {
        return this.value;
    }
    
    FloatBinaryTagImpl(final float llllllllllllllllllIIIIIIlIIIIIll) {
        this.value = llllllllllllllllllIIIIIIlIIIIIll;
    }
    
    @Override
    public double doubleValue() {
        return this.value;
    }
    
    @Override
    public short shortValue() {
        return (short)(ShadyPines.floor(this.value) & 0xFFFF);
    }
    
    @Override
    public byte byteValue() {
        return (byte)(ShadyPines.floor(this.value) & 0xFF);
    }
    
    @Override
    public float floatValue() {
        return this.value;
    }
    
    @Override
    public int intValue() {
        return ShadyPines.floor(this.value);
    }
    
    @NotNull
    @Override
    public Stream<? extends ExaminableProperty> examinableProperties() {
        return Stream.of(ExaminableProperty.of("value", this.value));
    }
}
