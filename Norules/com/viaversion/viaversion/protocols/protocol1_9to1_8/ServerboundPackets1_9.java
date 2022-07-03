package com.viaversion.viaversion.protocols.protocol1_9to1_8;

import com.viaversion.viaversion.api.protocol.packet.*;

public enum ServerboundPackets1_9 implements ServerboundPacketType
{
    USE_ITEM, 
    CLICK_WINDOW, 
    CLICK_WINDOW_BUTTON, 
    CHAT_MESSAGE, 
    CLOSE_WINDOW, 
    KEEP_ALIVE, 
    SPECTATE, 
    PLAYER_BLOCK_PLACEMENT, 
    HELD_ITEM_CHANGE, 
    ANIMATION, 
    PLAYER_ABILITIES, 
    PLAYER_DIGGING, 
    RESOURCE_PACK_STATUS, 
    WINDOW_CONFIRMATION, 
    TAB_COMPLETE, 
    ENTITY_ACTION, 
    PLUGIN_MESSAGE, 
    TELEPORT_CONFIRM, 
    CLIENT_STATUS, 
    CREATIVE_INVENTORY_ACTION, 
    PLAYER_ROTATION, 
    STEER_VEHICLE, 
    CLIENT_SETTINGS, 
    PLAYER_MOVEMENT, 
    UPDATE_SIGN, 
    STEER_BOAT, 
    VEHICLE_MOVE, 
    PLAYER_POSITION, 
    INTERACT_ENTITY, 
    PLAYER_POSITION_AND_ROTATION;
    
    @Override
    public int getId() {
        return this.ordinal();
    }
    
    @Override
    public String getName() {
        return this.name();
    }
}
