package com.viaversion.viaversion.protocols.protocol1_12to1_11_1;

import com.viaversion.viaversion.api.protocol.packet.*;

public enum ServerboundPackets1_12 implements ServerboundPacketType
{
    CLICK_WINDOW_BUTTON, 
    CLOSE_WINDOW, 
    PLAYER_POSITION_AND_ROTATION, 
    TELEPORT_CONFIRM, 
    ADVANCEMENT_TAB, 
    ENTITY_ACTION, 
    CHAT_MESSAGE, 
    CLICK_WINDOW, 
    PLAYER_ROTATION, 
    PLAYER_POSITION, 
    PLAYER_ABILITIES, 
    CREATIVE_INVENTORY_ACTION, 
    PLUGIN_MESSAGE, 
    TAB_COMPLETE, 
    PLAYER_DIGGING, 
    RECIPE_BOOK_DATA, 
    RESOURCE_PACK_STATUS, 
    USE_ITEM, 
    UPDATE_SIGN, 
    HELD_ITEM_CHANGE, 
    ANIMATION, 
    STEER_VEHICLE, 
    PREPARE_CRAFTING_GRID, 
    CLIENT_STATUS, 
    KEEP_ALIVE, 
    SPECTATE, 
    VEHICLE_MOVE, 
    PLAYER_MOVEMENT, 
    CLIENT_SETTINGS, 
    WINDOW_CONFIRMATION, 
    INTERACT_ENTITY, 
    PLAYER_BLOCK_PLACEMENT, 
    STEER_BOAT;
    
    @Override
    public String getName() {
        return this.name();
    }
    
    @Override
    public int getId() {
        return this.ordinal();
    }
}
