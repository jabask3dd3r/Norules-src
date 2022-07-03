package com.viaversion.viaversion.libs.fastutil;

public interface Size64
{
    @Deprecated
    default int size() {
        return (int)Math.min(2147483647L, this.size64());
    }
    
    long size64();
}
