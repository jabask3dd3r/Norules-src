package com.viaversion.viaversion.protocol;

import com.viaversion.viaversion.api.protocol.version.*;
import com.viaversion.viaversion.libs.fastutil.ints.*;

public class ServerProtocolVersionRange implements ServerProtocolVersion
{
    private final /* synthetic */ int highestSupportedVersion;
    private final /* synthetic */ int lowestSupportedVersion;
    private final /* synthetic */ IntSortedSet supportedVersions;
    
    public ServerProtocolVersionRange(final int llllllllllllllllIIIIlIllllIIIIll, final int llllllllllllllllIIIIlIllllIIIllI, final IntSortedSet llllllllllllllllIIIIlIllllIIIIIl) {
        this.lowestSupportedVersion = llllllllllllllllIIIIlIllllIIIIll;
        this.highestSupportedVersion = llllllllllllllllIIIIlIllllIIIllI;
        this.supportedVersions = llllllllllllllllIIIIlIllllIIIIIl;
    }
    
    @Override
    public int highestSupportedVersion() {
        return this.highestSupportedVersion;
    }
    
    @Override
    public int lowestSupportedVersion() {
        return this.lowestSupportedVersion;
    }
    
    @Override
    public IntSortedSet supportedVersions() {
        return this.supportedVersions;
    }
}
