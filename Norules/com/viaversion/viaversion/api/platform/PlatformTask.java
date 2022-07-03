package com.viaversion.viaversion.api.platform;

public interface PlatformTask<T>
{
    void cancel();
    
    T getObject();
}
