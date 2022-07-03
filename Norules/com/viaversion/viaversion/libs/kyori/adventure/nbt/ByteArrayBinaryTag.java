package com.viaversion.viaversion.libs.kyori.adventure.nbt;

import org.jetbrains.annotations.*;

public interface ByteArrayBinaryTag extends ArrayBinaryTag, Iterable<Byte>
{
    @NotNull
    default ByteArrayBinaryTag of(final byte... lllllllllllllIlllIlIlIllIlIlIllI) {
        return new ByteArrayBinaryTagImpl(lllllllllllllIlllIlIlIllIlIlIllI);
    }
    
    byte[] value();
    
    byte get(final int lllllllllllllIlllIlIlIllIlIlIIlI);
    
    int size();
    
    @NotNull
    default BinaryTagType<ByteArrayBinaryTag> type() {
        return BinaryTagTypes.BYTE_ARRAY;
    }
}
