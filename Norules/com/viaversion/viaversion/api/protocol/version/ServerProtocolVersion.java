package com.viaversion.viaversion.api.protocol.version;

import com.viaversion.viaversion.libs.fastutil.ints.*;

public interface ServerProtocolVersion
{
    IntSortedSet supportedVersions();
    
    default boolean isKnown() {
        return this.lowestSupportedVersion() != -1 && this.highestSupportedVersion() != -1;
    }
    
    int highestSupportedVersion();
    
    int lowestSupportedVersion();
}
