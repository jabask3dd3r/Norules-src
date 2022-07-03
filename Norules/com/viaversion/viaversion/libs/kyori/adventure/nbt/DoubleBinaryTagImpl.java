package com.viaversion.viaversion.libs.kyori.adventure.nbt;

import java.util.stream.*;
import com.viaversion.viaversion.libs.kyori.examination.*;
import org.jetbrains.annotations.*;

@Debug.Renderer(text = "String.valueOf(this.value) + \"d\"", hasChildren = "false")
final class DoubleBinaryTagImpl extends AbstractBinaryTag implements DoubleBinaryTag
{
    private final /* synthetic */ double value;
    
    @Override
    public long longValue() {
        return (long)Math.floor(this.value);
    }
    
    @Override
    public boolean equals(@Nullable final Object llllllllllllllIlllIlIIIlIllIllll) {
        if (this == llllllllllllllIlllIlIIIlIllIllll) {
            return true;
        }
        if (llllllllllllllIlllIlIIIlIllIllll == null || this.getClass() != llllllllllllllIlllIlIIIlIllIllll.getClass()) {
            return false;
        }
        final DoubleBinaryTagImpl llllllllllllllIlllIlIIIlIllIllII = (DoubleBinaryTagImpl)llllllllllllllIlllIlIIIlIllIllll;
        return Double.doubleToLongBits(this.value) == Double.doubleToLongBits(llllllllllllllIlllIlIIIlIllIllII.value);
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
    public int intValue() {
        return ShadyPines.floor(this.value);
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
        return Double.hashCode(this.value);
    }
    
    DoubleBinaryTagImpl(final double llllllllllllllIlllIlIIIllIIIllII) {
        this.value = llllllllllllllIlllIlIIIllIIIllII;
    }
    
    @NotNull
    @Override
    public Stream<? extends ExaminableProperty> examinableProperties() {
        return Stream.of(ExaminableProperty.of("value", this.value));
    }
    
    @Override
    public double value() {
        return this.value;
    }
}
