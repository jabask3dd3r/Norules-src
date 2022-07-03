package com.viaversion.viaversion.libs.kyori.adventure.nbt;

import org.jetbrains.annotations.*;

public interface IntBinaryTag extends NumberBinaryTag
{
    @NotNull
    default IntBinaryTag of(final int lllllllllllllIIlIIIIIIIllllllllI) {
        return new IntBinaryTagImpl(lllllllllllllIIlIIIIIIIllllllllI);
    }
    
    int value();
    
    @NotNull
    default BinaryTagType<IntBinaryTag> type() {
        return BinaryTagTypes.INT;
    }
}
