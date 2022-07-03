package com.viaversion.viaversion.libs.kyori.adventure.nbt;

import org.jetbrains.annotations.*;

public interface ShortBinaryTag extends NumberBinaryTag
{
    short value();
    
    @NotNull
    default BinaryTagType<ShortBinaryTag> type() {
        return BinaryTagTypes.SHORT;
    }
    
    @NotNull
    default ShortBinaryTag of(final short lllllllllllllIIllIllIIIIllIIlIlI) {
        return new ShortBinaryTagImpl(lllllllllllllIIllIllIIIIllIIlIlI);
    }
}
