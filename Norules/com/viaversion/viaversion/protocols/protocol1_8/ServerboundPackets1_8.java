package com.viaversion.viaversion.protocols.protocol1_8;

import com.viaversion.viaversion.api.protocol.packet.*;

public enum ServerboundPackets1_8 implements ServerboundPacketType
{
    PLUGIN_MESSAGE, 
    PLAYER_DIGGING, 
    HELD_ITEM_CHANGE, 
    CLICK_WINDOW_BUTTON, 
    CLICK_WINDOW, 
    ENTITY_ACTION, 
    CREATIVE_INVENTORY_ACTION, 
    PLAYER_POSITION, 
    PLAYER_BLOCK_PLACEMENT, 
    CLIENT_SETTINGS, 
    PLAYER_ABILITIES, 
    SPECTATE, 
    CLIENT_STATUS, 
    INTERACT_ENTITY, 
    KEEP_ALIVE, 
    STEER_VEHICLE, 
    WINDOW_CONFIRMATION, 
    UPDATE_SIGN, 
    RESOURCE_PACK_STATUS, 
    PLAYER_ROTATION, 
    CLOSE_WINDOW, 
    PLAYER_MOVEMENT, 
    PLAYER_POSITION_AND_ROTATION, 
    TAB_COMPLETE, 
    ANIMATION, 
    CHAT_MESSAGE;
    
    @Override
    public String getName() {
        return this.name();
    }
    
    @Override
    public int getId() {
        return this.ordinal();
    }
}
