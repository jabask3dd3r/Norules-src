package com.viaversion.viaversion.libs.kyori.adventure.nbt;

import java.util.stream.*;
import com.viaversion.viaversion.libs.kyori.examination.*;
import org.jetbrains.annotations.*;

@Debug.Renderer(text = "\"\\\"\" + this.value + \"\\\"\"", hasChildren = "false")
final class StringBinaryTagImpl extends AbstractBinaryTag implements StringBinaryTag
{
    private final /* synthetic */ String value;
    
    StringBinaryTagImpl(final String lllllllllllllIllIllIIIlIIllIIllI) {
        this.value = lllllllllllllIllIllIIIlIIllIIllI;
    }
    
    @Override
    public int hashCode() {
        return this.value.hashCode();
    }
    
    @Override
    public boolean equals(@Nullable final Object lllllllllllllIllIllIIIlIIlIllIll) {
        if (this == lllllllllllllIllIllIIIlIIlIllIll) {
            return true;
        }
        if (lllllllllllllIllIllIIIlIIlIllIll == null || this.getClass() != lllllllllllllIllIllIIIlIIlIllIll.getClass()) {
            return false;
        }
        final StringBinaryTagImpl lllllllllllllIllIllIIIlIIlIllIII = (StringBinaryTagImpl)lllllllllllllIllIllIIIlIIlIllIll;
        return this.value.equals(lllllllllllllIllIllIIIlIIlIllIII.value);
    }
    
    @NotNull
    @Override
    public Stream<? extends ExaminableProperty> examinableProperties() {
        return Stream.of(ExaminableProperty.of("value", this.value));
    }
    
    @NotNull
    @Override
    public String value() {
        return this.value;
    }
}
