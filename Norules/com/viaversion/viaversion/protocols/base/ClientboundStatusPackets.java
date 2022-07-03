package com.viaversion.viaversion.protocols.base;

import com.viaversion.viaversion.api.protocol.packet.*;

public enum ClientboundStatusPackets implements ClientboundPacketType
{
    PONG_RESPONSE, 
    STATUS_RESPONSE;
    
    @Override
    public final int getId() {
        return this.ordinal();
    }
    
    @Override
    public final String getName() {
        return this.name();
    }
    
    @Override
    public final State state() {
        return State.STATUS;
    }
}
