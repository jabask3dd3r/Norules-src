package com.viaversion.viaversion;

import com.viaversion.viaversion.api.protocol.*;
import java.util.*;
import com.viaversion.viaversion.api.connection.*;
import com.viaversion.viaversion.api.*;

public abstract class ViaListener
{
    private final /* synthetic */ Class<? extends Protocol> requiredPipeline;
    private /* synthetic */ boolean registered;
    
    protected ViaListener(final Class<? extends Protocol> llllllllllllllIllIllIllIIIlIllIl) {
        this.requiredPipeline = llllllllllllllIllIllIllIIIlIllIl;
    }
    
    public abstract void register();
    
    protected void setRegistered(final boolean llllllllllllllIllIllIllIIIIlIlII) {
        this.registered = llllllllllllllIllIllIllIIIIlIlII;
    }
    
    protected boolean isRegistered() {
        return this.registered;
    }
    
    protected boolean isOnPipe(final UUID llllllllllllllIllIllIllIIIIlllll) {
        final UserConnection llllllllllllllIllIllIllIIIlIIIIl = this.getUserConnection(llllllllllllllIllIllIllIIIIlllll);
        return llllllllllllllIllIllIllIIIlIIIIl != null && (this.requiredPipeline == null || llllllllllllllIllIllIllIIIlIIIIl.getProtocolInfo().getPipeline().contains(this.requiredPipeline));
    }
    
    protected UserConnection getUserConnection(final UUID llllllllllllllIllIllIllIIIlIIlll) {
        return Via.getManager().getConnectionManager().getConnectedClient(llllllllllllllIllIllIllIIIlIIlll);
    }
    
    protected Class<? extends Protocol> getRequiredPipeline() {
        return this.requiredPipeline;
    }
}
