package com.viaversion.viabackwards.api;

import com.viaversion.viaversion.api.protocol.packet.*;
import com.viaversion.viabackwards.api.rewriters.*;
import com.viaversion.viaversion.api.protocol.*;
import com.viaversion.viaversion.api.*;
import com.viaversion.viabackwards.api.data.*;
import com.viaversion.viaversion.api.data.*;

public abstract class BackwardsProtocol<C1 extends ClientboundPacketType, C2 extends ClientboundPacketType, S1 extends ServerboundPacketType, S2 extends ServerboundPacketType> extends AbstractProtocol<C1, C2, S1, S2>
{
    public TranslatableRewriter getTranslatableRewriter() {
        return null;
    }
    
    @Override
    public boolean hasMappingDataToLoad() {
        return false;
    }
    
    protected void executeAsyncAfterLoaded(final Class<? extends Protocol> llllllllllllllllllIIIlIlIllIllIl, final Runnable llllllllllllllllllIIIlIlIllIllII) {
        Via.getManager().getProtocolManager().addMappingLoaderFuture(this.getClass(), llllllllllllllllllIIIlIlIllIllIl, llllllllllllllllllIIIlIlIllIllII);
    }
    
    @Override
    public BackwardsMappings getMappingData() {
        return null;
    }
    
    protected BackwardsProtocol(final Class<C1> llllllllllllllllllIIIlIlIlllllIl, final Class<C2> llllllllllllllllllIIIlIlIlllIlll, final Class<S1> llllllllllllllllllIIIlIlIllllIll, final Class<S2> llllllllllllllllllIIIlIlIllllIlI) {
        super(llllllllllllllllllIIIlIlIlllllIl, llllllllllllllllllIIIlIlIlllIlll, llllllllllllllllllIIIlIlIllllIll, llllllllllllllllllIIIlIlIllllIlI);
    }
    
    protected BackwardsProtocol() {
    }
}
