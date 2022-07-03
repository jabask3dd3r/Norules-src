package com.viaversion.viaversion.api.protocol.packet;

public interface PacketType
{
    Direction direction();
    
    default State state() {
        return State.PLAY;
    }
    
    String getName();
    
    int getId();
}
