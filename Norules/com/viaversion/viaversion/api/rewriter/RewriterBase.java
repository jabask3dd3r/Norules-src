package com.viaversion.viaversion.api.rewriter;

import com.viaversion.viaversion.api.protocol.*;

public abstract class RewriterBase<T extends Protocol> implements Rewriter<T>
{
    protected final /* synthetic */ T protocol;
    
    protected void registerRewrites() {
    }
    
    @Override
    public final void register() {
        this.registerPackets();
        this.registerRewrites();
    }
    
    @Override
    public T protocol() {
        return this.protocol;
    }
    
    protected void registerPackets() {
    }
    
    protected RewriterBase(final T lIllIIIIllIllI) {
        this.protocol = lIllIIIIllIllI;
    }
}
