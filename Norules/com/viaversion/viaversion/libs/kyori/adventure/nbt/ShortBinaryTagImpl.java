package com.viaversion.viaversion.libs.kyori.adventure.nbt;

import java.util.stream.*;
import com.viaversion.viaversion.libs.kyori.examination.*;
import org.jetbrains.annotations.*;

@Debug.Renderer(text = "String.valueOf(this.value) + \"s\"", hasChildren = "false")
final class ShortBinaryTagImpl extends AbstractBinaryTag implements ShortBinaryTag
{
    private final /* synthetic */ short value;
    
    @Override
    public long longValue() {
        return this.value;
    }
    
    @Override
    public byte byteValue() {
        return (byte)(this.value & 0xFF);
    }
    
    @Override
    public int hashCode() {
        return Short.hashCode(this.value);
    }
    
    @Override
    public double doubleValue() {
        return this.value;
    }
    
    @Override
    public boolean equals(@Nullable final Object lllllllllllllIIIllllllIIIlllIIII) {
        if (this == lllllllllllllIIIllllllIIIlllIIII) {
            return true;
        }
        if (lllllllllllllIIIllllllIIIlllIIII == null || this.getClass() != lllllllllllllIIIllllllIIIlllIIII.getClass()) {
            return false;
        }
        final ShortBinaryTagImpl lllllllllllllIIIllllllIIIllIllIl = (ShortBinaryTagImpl)lllllllllllllIIIllllllIIIlllIIII;
        return this.value == lllllllllllllIIIllllllIIIllIllIl.value;
    }
    
    @Override
    public int intValue() {
        return this.value;
    }
    
    @Override
    public short value() {
        return this.value;
    }
    
    @Override
    public float floatValue() {
        return this.value;
    }
    
    ShortBinaryTagImpl(final short lllllllllllllIIIllllllIIlIIIllIl) {
        this.value = lllllllllllllIIIllllllIIlIIIllIl;
    }
    
    @NotNull
    @Override
    public Stream<? extends ExaminableProperty> examinableProperties() {
        return Stream.of(ExaminableProperty.of("value", this.value));
    }
    
    @Override
    public short shortValue() {
        return this.value;
    }
}
