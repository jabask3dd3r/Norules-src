package com.viaversion.viaversion.protocols.protocol1_9_3to1_9_1_2;

import com.viaversion.viaversion.api.protocol.packet.*;

public enum ServerboundPackets1_9_3 implements ServerboundPacketType
{
    PLAYER_ROTATION, 
    STEER_BOAT, 
    INTERACT_ENTITY, 
    PLAYER_ABILITIES, 
    CLOSE_WINDOW, 
    TAB_COMPLETE, 
    TELEPORT_CONFIRM, 
    HELD_ITEM_CHANGE, 
    ENTITY_ACTION, 
    PLAYER_POSITION_AND_ROTATION, 
    UPDATE_SIGN, 
    CLICK_WINDOW_BUTTON, 
    CLIENT_SETTINGS, 
    PLAYER_MOVEMENT, 
    ANIMATION, 
    PLAYER_BLOCK_PLACEMENT, 
    CLICK_WINDOW, 
    KEEP_ALIVE, 
    USE_ITEM, 
    CREATIVE_INVENTORY_ACTION, 
    PLUGIN_MESSAGE, 
    SPECTATE, 
    RESOURCE_PACK_STATUS, 
    VEHICLE_MOVE, 
    CHAT_MESSAGE, 
    PLAYER_DIGGING, 
    WINDOW_CONFIRMATION, 
    PLAYER_POSITION, 
    STEER_VEHICLE, 
    CLIENT_STATUS;
    
    @Override
    public int getId() {
        return this.ordinal();
    }
    
    @Override
    public String getName() {
        return this.name();
    }
}
