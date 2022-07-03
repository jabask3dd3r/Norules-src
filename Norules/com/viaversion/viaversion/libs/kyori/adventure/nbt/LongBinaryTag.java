package com.viaversion.viaversion.libs.kyori.adventure.nbt;

import org.jetbrains.annotations.*;

public interface LongBinaryTag extends NumberBinaryTag
{
    @NotNull
    default BinaryTagType<LongBinaryTag> type() {
        return BinaryTagTypes.LONG;
    }
    
    long value();
    
    @NotNull
    default LongBinaryTag of(final long lllllllllllllIlIllIIIllIllllllll) {
        return new LongBinaryTagImpl(lllllllllllllIlIllIIIllIllllllll);
    }
}
