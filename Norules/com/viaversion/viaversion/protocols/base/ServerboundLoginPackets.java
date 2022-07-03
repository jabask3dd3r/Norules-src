package com.viaversion.viaversion.protocols.base;

import com.viaversion.viaversion.api.protocol.packet.*;

public enum ServerboundLoginPackets implements ServerboundPacketType
{
    CUSTOM_QUERY, 
    ENCRYPTION_KEY, 
    HELLO;
    
    @Override
    public final String getName() {
        return this.name();
    }
    
    @Override
    public final int getId() {
        return this.ordinal();
    }
    
    @Override
    public final State state() {
        return State.LOGIN;
    }
}
