package com.viaversion.viaversion.libs.kyori.adventure.nbt;

final class EndBinaryTagImpl extends AbstractBinaryTag implements EndBinaryTag
{
    @Override
    public int hashCode() {
        return 0;
    }
    
    @Override
    public boolean equals(final Object lllIlIIIIIII) {
        return this == lllIlIIIIIII;
    }
    
    static {
        INSTANCE = new EndBinaryTagImpl();
    }
}
