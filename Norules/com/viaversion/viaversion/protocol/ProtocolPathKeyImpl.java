package com.viaversion.viaversion.protocol;

import com.viaversion.viaversion.api.protocol.*;

public class ProtocolPathKeyImpl implements ProtocolPathKey
{
    private final /* synthetic */ int serverProtocolVersion;
    private final /* synthetic */ int clientProtocolVersion;
    
    public ProtocolPathKeyImpl(final int lllllllllllllIIIIlIlIIIIlIIIIlII, final int lllllllllllllIIIIlIlIIIIlIIIIIll) {
        this.clientProtocolVersion = lllllllllllllIIIIlIlIIIIlIIIIlII;
        this.serverProtocolVersion = lllllllllllllIIIIlIlIIIIlIIIIIll;
    }
    
    @Override
    public int hashCode() {
        int lllllllllllllIIIIlIlIIIIIlllIIII = this.clientProtocolVersion;
        lllllllllllllIIIIlIlIIIIIlllIIII = 31 * lllllllllllllIIIIlIlIIIIIlllIIII + this.serverProtocolVersion;
        return lllllllllllllIIIIlIlIIIIIlllIIII;
    }
    
    @Override
    public boolean equals(final Object lllllllllllllIIIIlIlIIIIIlllIlIl) {
        if (this == lllllllllllllIIIIlIlIIIIIlllIlIl) {
            return true;
        }
        if (lllllllllllllIIIIlIlIIIIIlllIlIl == null || this.getClass() != lllllllllllllIIIIlIlIIIIIlllIlIl.getClass()) {
            return false;
        }
        final ProtocolPathKeyImpl lllllllllllllIIIIlIlIIIIIlllIlll = (ProtocolPathKeyImpl)lllllllllllllIIIIlIlIIIIIlllIlIl;
        return this.clientProtocolVersion == lllllllllllllIIIIlIlIIIIIlllIlll.clientProtocolVersion && this.serverProtocolVersion == lllllllllllllIIIIlIlIIIIIlllIlll.serverProtocolVersion;
    }
    
    @Override
    public int getServerProtocolVersion() {
        return this.serverProtocolVersion;
    }
    
    @Override
    public int getClientProtocolVersion() {
        return this.clientProtocolVersion;
    }
}
