package com.viaversion.viaversion.protocol;

import com.viaversion.viaversion.api.protocol.*;

public class ProtocolPathEntryImpl implements ProtocolPathEntry
{
    private final /* synthetic */ int outputProtocolVersion;
    private final /* synthetic */ Protocol protocol;
    
    @Override
    public Protocol getProtocol() {
        return this.protocol;
    }
    
    @Override
    public boolean equals(final Object llllllllllllllIlIllIlIIIllllIlII) {
        if (this == llllllllllllllIlIllIlIIIllllIlII) {
            return true;
        }
        if (llllllllllllllIlIllIlIIIllllIlII == null || this.getClass() != llllllllllllllIlIllIlIIIllllIlII.getClass()) {
            return false;
        }
        final ProtocolPathEntryImpl llllllllllllllIlIllIlIIIllllIIll = (ProtocolPathEntryImpl)llllllllllllllIlIllIlIIIllllIlII;
        return this.outputProtocolVersion == llllllllllllllIlIllIlIIIllllIIll.outputProtocolVersion && this.protocol.equals(llllllllllllllIlIllIlIIIllllIIll.protocol);
    }
    
    @Override
    public int getOutputProtocolVersion() {
        return this.outputProtocolVersion;
    }
    
    @Override
    public int hashCode() {
        int llllllllllllllIlIllIlIIIlllIllII = this.outputProtocolVersion;
        llllllllllllllIlIllIlIIIlllIllII = 31 * llllllllllllllIlIllIlIIIlllIllII + this.protocol.hashCode();
        return llllllllllllllIlIllIlIIIlllIllII;
    }
    
    public ProtocolPathEntryImpl(final int llllllllllllllIlIllIlIIlIIIIIIII, final Protocol llllllllllllllIlIllIlIIIllllllll) {
        this.outputProtocolVersion = llllllllllllllIlIllIlIIlIIIIIIII;
        this.protocol = llllllllllllllIlIllIlIIIllllllll;
    }
}
