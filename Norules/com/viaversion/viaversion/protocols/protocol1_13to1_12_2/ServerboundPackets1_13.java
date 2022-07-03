package com.viaversion.viaversion.protocols.protocol1_13to1_12_2;

import com.viaversion.viaversion.api.protocol.packet.*;

public enum ServerboundPackets1_13 implements ServerboundPacketType
{
    RESOURCE_PACK_STATUS, 
    RENAME_ITEM, 
    ADVANCEMENT_TAB, 
    EDIT_BOOK, 
    STEER_VEHICLE, 
    SET_BEACON_EFFECT, 
    INTERACT_ENTITY, 
    HELD_ITEM_CHANGE, 
    UPDATE_COMMAND_BLOCK, 
    PLUGIN_MESSAGE, 
    SELECT_TRADE, 
    STEER_BOAT, 
    CREATIVE_INVENTORY_ACTION, 
    ENTITY_ACTION, 
    CLICK_WINDOW_BUTTON, 
    SPECTATE, 
    PLAYER_POSITION, 
    CHAT_MESSAGE, 
    QUERY_BLOCK_NBT, 
    PLAYER_MOVEMENT, 
    USE_ITEM, 
    CLICK_WINDOW, 
    KEEP_ALIVE, 
    TELEPORT_CONFIRM, 
    CLIENT_STATUS, 
    CLIENT_SETTINGS, 
    ANIMATION, 
    UPDATE_STRUCTURE_BLOCK, 
    VEHICLE_MOVE, 
    CLOSE_WINDOW, 
    UPDATE_COMMAND_BLOCK_MINECART, 
    PICK_ITEM, 
    PLAYER_BLOCK_PLACEMENT, 
    TAB_COMPLETE, 
    WINDOW_CONFIRMATION, 
    PLAYER_POSITION_AND_ROTATION, 
    RECIPE_BOOK_DATA, 
    CRAFT_RECIPE_REQUEST, 
    PLAYER_ROTATION, 
    PLAYER_ABILITIES, 
    UPDATE_SIGN, 
    ENTITY_NBT_REQUEST, 
    PLAYER_DIGGING;
    
    @Override
    public int getId() {
        return this.ordinal();
    }
    
    @Override
    public String getName() {
        return this.name();
    }
}
