package com.viaversion.viaversion.protocols.protocol1_16to1_15_2;

import com.viaversion.viaversion.api.protocol.packet.*;

public enum ServerboundPackets1_16 implements ServerboundPacketType
{
    HELD_ITEM_CHANGE, 
    UPDATE_STRUCTURE_BLOCK, 
    UPDATE_SIGN, 
    SPECTATE, 
    TELEPORT_CONFIRM, 
    TAB_COMPLETE, 
    RENAME_ITEM, 
    GENERATE_JIGSAW, 
    PLAYER_BLOCK_PLACEMENT, 
    QUERY_BLOCK_NBT, 
    SELECT_TRADE, 
    LOCK_DIFFICULTY, 
    STEER_BOAT, 
    PLAYER_ABILITIES, 
    PLAYER_ROTATION, 
    WINDOW_CONFIRMATION, 
    CREATIVE_INVENTORY_ACTION, 
    RECIPE_BOOK_DATA, 
    RESOURCE_PACK_STATUS, 
    PLUGIN_MESSAGE, 
    KEEP_ALIVE, 
    CLOSE_WINDOW, 
    PLAYER_MOVEMENT, 
    CLICK_WINDOW, 
    EDIT_BOOK, 
    SET_DIFFICULTY, 
    CHAT_MESSAGE, 
    STEER_VEHICLE, 
    ANIMATION, 
    SET_BEACON_EFFECT, 
    INTERACT_ENTITY, 
    UPDATE_COMMAND_BLOCK, 
    VEHICLE_MOVE, 
    PLAYER_POSITION_AND_ROTATION, 
    UPDATE_COMMAND_BLOCK_MINECART, 
    USE_ITEM, 
    PLAYER_POSITION, 
    CLIENT_STATUS, 
    ENTITY_ACTION, 
    ENTITY_NBT_REQUEST, 
    PICK_ITEM, 
    CLICK_WINDOW_BUTTON, 
    ADVANCEMENT_TAB, 
    UPDATE_JIGSAW_BLOCK, 
    CRAFT_RECIPE_REQUEST, 
    CLIENT_SETTINGS, 
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
