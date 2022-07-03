package com.viaversion.viaversion.protocols.protocol1_12_1to1_12;

import com.viaversion.viaversion.api.protocol.packet.*;

public enum ServerboundPackets1_12_1 implements ServerboundPacketType
{
    KEEP_ALIVE, 
    PLAYER_ABILITIES, 
    CLICK_WINDOW, 
    WINDOW_CONFIRMATION, 
    CRAFT_RECIPE_REQUEST, 
    RESOURCE_PACK_STATUS, 
    TELEPORT_CONFIRM, 
    STEER_VEHICLE, 
    HELD_ITEM_CHANGE, 
    CLOSE_WINDOW, 
    PLAYER_MOVEMENT, 
    CREATIVE_INVENTORY_ACTION, 
    PLUGIN_MESSAGE, 
    RECIPE_BOOK_DATA, 
    STEER_BOAT, 
    ANIMATION, 
    PLAYER_ROTATION, 
    CLIENT_STATUS, 
    TAB_COMPLETE, 
    SPECTATE, 
    UPDATE_SIGN, 
    USE_ITEM, 
    VEHICLE_MOVE, 
    PLAYER_BLOCK_PLACEMENT, 
    PLAYER_DIGGING, 
    CHAT_MESSAGE, 
    CLIENT_SETTINGS, 
    INTERACT_ENTITY, 
    PLAYER_POSITION, 
    ENTITY_ACTION, 
    PLAYER_POSITION_AND_ROTATION, 
    CLICK_WINDOW_BUTTON, 
    ADVANCEMENT_TAB;
    
    @Override
    public String getName() {
        return this.name();
    }
    
    @Override
    public int getId() {
        return this.ordinal();
    }
}
