package com.viaversion.viaversion.libs.kyori.adventure.nbt;

import java.util.stream.*;
import com.viaversion.viaversion.libs.kyori.examination.*;
import org.jetbrains.annotations.*;

@Debug.Renderer(text = "\"0x\" + Integer.toString(this.value, 16)", hasChildren = "false")
final class ByteBinaryTagImpl extends AbstractBinaryTag implements ByteBinaryTag
{
    private final /* synthetic */ byte value;
    
    @Override
    public int intValue() {
        return this.value;
    }
    
    @Override
    public long longValue() {
        return this.value;
    }
    
    @Override
    public byte byteValue() {
        return this.value;
    }
    
    @Override
    public boolean equals(@Nullable final Object lllllllllllllIIlIlllIlIlllIlIIll) {
        if (this == lllllllllllllIIlIlllIlIlllIlIIll) {
            return true;
        }
        if (lllllllllllllIIlIlllIlIlllIlIIll == null || this.getClass() != lllllllllllllIIlIlllIlIlllIlIIll.getClass()) {
            return false;
        }
        final ByteBinaryTagImpl lllllllllllllIIlIlllIlIlllIlIIII = (ByteBinaryTagImpl)lllllllllllllIIlIlllIlIlllIlIIll;
        return this.value == lllllllllllllIIlIlllIlIlllIlIIII.value;
    }
    
    @Override
    public short shortValue() {
        return this.value;
    }
    
    ByteBinaryTagImpl(final byte lllllllllllllIIlIlllIlIlllllIIII) {
        this.value = lllllllllllllIIlIlllIlIlllllIIII;
    }
    
    @Override
    public float floatValue() {
        return this.value;
    }
    
    @Override
    public int hashCode() {
        return Byte.hashCode(this.value);
    }
    
    @NotNull
    @Override
    public Stream<? extends ExaminableProperty> examinableProperties() {
        return Stream.of(ExaminableProperty.of("value", this.value));
    }
    
    @Override
    public double doubleValue() {
        return this.value;
    }
    
    @Override
    public byte value() {
        return this.value;
    }
}
