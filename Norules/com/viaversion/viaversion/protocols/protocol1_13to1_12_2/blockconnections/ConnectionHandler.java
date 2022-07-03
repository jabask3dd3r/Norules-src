package com.viaversion.viaversion.protocols.protocol1_13to1_12_2.blockconnections;

import com.viaversion.viaversion.api.connection.*;
import com.viaversion.viaversion.api.minecraft.*;
import com.viaversion.viaversion.protocols.protocol1_13to1_12_2.blockconnections.providers.*;
import com.viaversion.viaversion.api.*;

public abstract class ConnectionHandler
{
    public int getBlockData(final UserConnection llllllllllllIlllllIIlIIIIlIlIIlI, final Position llllllllllllIlllllIIlIIIIlIlIIll) {
        return Via.getManager().getProviders().get(BlockConnectionProvider.class).getBlockData(llllllllllllIlllllIIlIIIIlIlIIlI, llllllllllllIlllllIIlIIIIlIlIIll.getX(), llllllllllllIlllllIIlIIIIlIlIIll.getY(), llllllllllllIlllllIIlIIIIlIlIIll.getZ());
    }
    
    public abstract int connect(final UserConnection p0, final Position p1, final int p2);
}
