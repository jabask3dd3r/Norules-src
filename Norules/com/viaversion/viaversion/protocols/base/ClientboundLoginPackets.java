package com.viaversion.viaversion.protocols.base;

import com.viaversion.viaversion.api.protocol.packet.*;

public enum ClientboundLoginPackets implements ClientboundPacketType
{
    HELLO, 
    LOGIN_COMPRESSION, 
    CUSTOM_QUERY, 
    LOGIN_DISCONNECT, 
    GAME_PROFILE;
    
    @Override
    public final int getId() {
        return this.ordinal();
    }
    
    @Override
    public final State state() {
        return State.LOGIN;
    }
    
    @Override
    public final String getName() {
        return this.name();
    }
}
