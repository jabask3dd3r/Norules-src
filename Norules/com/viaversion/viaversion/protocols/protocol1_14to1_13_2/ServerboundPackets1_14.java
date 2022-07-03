package com.viaversion.viaversion.protocols.protocol1_14to1_13_2;

import com.viaversion.viaversion.api.protocol.packet.*;

public enum ServerboundPackets1_14 implements ServerboundPacketType
{
    KEEP_ALIVE, 
    RENAME_ITEM, 
    VEHICLE_MOVE, 
    PLAYER_POSITION, 
    LOCK_DIFFICULTY, 
    EDIT_BOOK, 
    PLUGIN_MESSAGE, 
    CLICK_WINDOW, 
    QUERY_BLOCK_NBT, 
    PLAYER_POSITION_AND_ROTATION, 
    PLAYER_BLOCK_PLACEMENT, 
    SET_BEACON_EFFECT, 
    WINDOW_CONFIRMATION, 
    UPDATE_JIGSAW_BLOCK, 
    USE_ITEM, 
    CLOSE_WINDOW, 
    CLIENT_SETTINGS, 
    UPDATE_COMMAND_BLOCK_MINECART, 
    TELEPORT_CONFIRM, 
    CHAT_MESSAGE, 
    CLIENT_STATUS, 
    INTERACT_ENTITY, 
    UPDATE_COMMAND_BLOCK, 
    ENTITY_NBT_REQUEST, 
    STEER_VEHICLE, 
    PLAYER_MOVEMENT, 
    HELD_ITEM_CHANGE, 
    CLICK_WINDOW_BUTTON, 
    CRAFT_RECIPE_REQUEST, 
    CREATIVE_INVENTORY_ACTION, 
    RESOURCE_PACK_STATUS, 
    SELECT_TRADE, 
    UPDATE_STRUCTURE_BLOCK, 
    ADVANCEMENT_TAB, 
    RECIPE_BOOK_DATA, 
    PLAYER_ROTATION, 
    PICK_ITEM, 
    ANIMATION, 
    SET_DIFFICULTY, 
    SPECTATE, 
    TAB_COMPLETE, 
    UPDATE_SIGN, 
    STEER_BOAT, 
    PLAYER_DIGGING, 
    ENTITY_ACTION, 
    PLAYER_ABILITIES;
    
    @Override
    public String getName() {
        return this.name();
    }
    
    @Override
    public int getId() {
        return this.ordinal();
    }
}
