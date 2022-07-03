package com.viaversion.viaversion.api.platform;

import com.viaversion.viaversion.libs.gson.*;
import com.viaversion.viaversion.libs.fastutil.ints.*;

public interface ViaInjector
{
    default boolean lateProtocolVersionSetting() {
        return false;
    }
    
    void inject() throws Exception;
    
    void uninject() throws Exception;
    
    String getDecoderName();
    
    JsonObject getDump();
    
    int getServerProtocolVersion() throws Exception;
    
    default IntSortedSet getServerProtocolVersions() throws Exception {
        return IntSortedSets.singleton(this.getServerProtocolVersion());
    }
    
    String getEncoderName();
}
