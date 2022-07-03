package com.viaversion.viaversion.libs.kyori.adventure.nbt;

abstract class ArrayBinaryTagImpl extends AbstractBinaryTag implements ArrayBinaryTag
{
    static void checkIndex(final int llIlIIlIIIIIlll, final int llIlIIlIIIIIllI) {
        if (llIlIIlIIIIIlll < 0 || llIlIIlIIIIIlll >= llIlIIlIIIIIllI) {
            throw new IndexOutOfBoundsException(String.valueOf(new StringBuilder().append("Index out of bounds: ").append(llIlIIlIIIIIlll)));
        }
    }
}
