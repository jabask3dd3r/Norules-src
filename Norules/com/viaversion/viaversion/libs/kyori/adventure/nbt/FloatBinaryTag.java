package com.viaversion.viaversion.libs.kyori.adventure.nbt;

import org.jetbrains.annotations.*;

public interface FloatBinaryTag extends NumberBinaryTag
{
    @NotNull
    default FloatBinaryTag of(final float lllllllllllllIllIlIlllllIIlIlIll) {
        return new FloatBinaryTagImpl(lllllllllllllIllIlIlllllIIlIlIll);
    }
    
    @NotNull
    default BinaryTagType<FloatBinaryTag> type() {
        return BinaryTagTypes.FLOAT;
    }
    
    float value();
}
