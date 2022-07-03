package com.viaversion.viaversion.libs.kyori.adventure.nbt;

import org.jetbrains.annotations.*;

public interface StringBinaryTag extends BinaryTag
{
    @NotNull
    String value();
    
    @NotNull
    default BinaryTagType<StringBinaryTag> type() {
        return BinaryTagTypes.STRING;
    }
    
    @NotNull
    default StringBinaryTag of(@NotNull final String llllllllllllllIIlIIllllIlIllllII) {
        return new StringBinaryTagImpl(llllllllllllllIIlIIllllIlIllllII);
    }
}
