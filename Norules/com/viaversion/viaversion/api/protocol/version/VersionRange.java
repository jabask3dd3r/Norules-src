package com.viaversion.viaversion.api.protocol.version;

import com.google.common.base.*;

public class VersionRange
{
    private final /* synthetic */ int rangeFrom;
    private final /* synthetic */ int rangeTo;
    private final /* synthetic */ String baseVersion;
    
    public String getBaseVersion() {
        return this.baseVersion;
    }
    
    public int getRangeTo() {
        return this.rangeTo;
    }
    
    public VersionRange(final String lllllllllllllIIIIIllllIlIIlIIIll, final int lllllllllllllIIIIIllllIlIIlIIllI, final int lllllllllllllIIIIIllllIlIIlIIIIl) {
        Preconditions.checkNotNull((Object)lllllllllllllIIIIIllllIlIIlIIIll);
        Preconditions.checkArgument(lllllllllllllIIIIIllllIlIIlIIllI >= 0);
        Preconditions.checkArgument(lllllllllllllIIIIIllllIlIIlIIIIl > lllllllllllllIIIIIllllIlIIlIIllI);
        this.baseVersion = lllllllllllllIIIIIllllIlIIlIIIll;
        this.rangeFrom = lllllllllllllIIIIIllllIlIIlIIllI;
        this.rangeTo = lllllllllllllIIIIIllllIlIIlIIIIl;
    }
    
    public int getRangeFrom() {
        return this.rangeFrom;
    }
}
