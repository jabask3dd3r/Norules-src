package com.viaversion.viaversion.libs.kyori.adventure.nbt;

import org.jetbrains.annotations.*;

public interface DoubleBinaryTag extends NumberBinaryTag
{
    double value();
    
    @NotNull
    default BinaryTagType<DoubleBinaryTag> type() {
        return BinaryTagTypes.DOUBLE;
    }
    
    @NotNull
    default DoubleBinaryTag of(final double lllllllllllllllIIIIIlIlIIlllllII) {
        return new DoubleBinaryTagImpl(lllllllllllllllIIIIIlIlIIlllllII);
    }
}
