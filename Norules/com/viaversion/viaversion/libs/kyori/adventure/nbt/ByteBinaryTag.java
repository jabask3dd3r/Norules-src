package com.viaversion.viaversion.libs.kyori.adventure.nbt;

import org.jetbrains.annotations.*;

public interface ByteBinaryTag extends NumberBinaryTag
{
    public static final /* synthetic */ ByteBinaryTag ZERO = new ByteBinaryTagImpl((byte)0);
    public static final /* synthetic */ ByteBinaryTag ONE = new ByteBinaryTagImpl((byte)1);
    
    @NotNull
    default BinaryTagType<ByteBinaryTag> type() {
        return BinaryTagTypes.BYTE;
    }
    
    @NotNull
    default ByteBinaryTag of(final byte llllllllllllllIllllIllIIlIlIIIIl) {
        if (llllllllllllllIllllIllIIlIlIIIIl == 0) {
            return ByteBinaryTag.ZERO;
        }
        if (llllllllllllllIllllIllIIlIlIIIIl == 1) {
            return ByteBinaryTag.ONE;
        }
        return new ByteBinaryTagImpl(llllllllllllllIllllIllIIlIlIIIIl);
    }
    
    byte value();
}
