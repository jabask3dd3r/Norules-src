package com.viaversion.viaversion.libs.kyori.adventure.nbt;

import org.jetbrains.annotations.*;

public interface NumberBinaryTag extends BinaryTag
{
    float floatValue();
    
    short shortValue();
    
    long longValue();
    
    @NotNull
    BinaryTagType<? extends NumberBinaryTag> type();
    
    byte byteValue();
    
    double doubleValue();
    
    int intValue();
}
