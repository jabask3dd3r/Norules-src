package com.viaversion.viaversion.api.platform;

public interface UnsupportedSoftware
{
    String getReason();
    
    boolean findMatch();
    
    String getName();
}
