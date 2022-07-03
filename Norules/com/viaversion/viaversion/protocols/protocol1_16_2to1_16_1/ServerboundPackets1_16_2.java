package com.viaversion.viaversion.protocols.protocol1_16_2to1_16_1;

import com.viaversion.viaversion.api.protocol.packet.*;

public enum ServerboundPackets1_16_2 implements ServerboundPacketType
{
    CLICK_WINDOW, 
    STEER_BOAT, 
    ANIMATION, 
    CLIENT_STATUS, 
    CLOSE_WINDOW, 
    VEHICLE_MOVE, 
    PLAYER_POSITION_AND_ROTATION, 
    UPDATE_SIGN, 
    RENAME_ITEM, 
    PLAYER_ABILITIES, 
    TAB_COMPLETE, 
    USE_ITEM, 
    CRAFT_RECIPE_REQUEST, 
    LOCK_DIFFICULTY, 
    SET_DIFFICULTY, 
    RECIPE_BOOK_DATA, 
    TELEPORT_CONFIRM, 
    CLICK_WINDOW_BUTTON, 
    PICK_ITEM, 
    PLAYER_DIGGING, 
    INTERACT_ENTITY, 
    UPDATE_JIGSAW_BLOCK, 
    UPDATE_COMMAND_BLOCK_MINECART, 
    PLAYER_MOVEMENT, 
    WINDOW_CONFIRMATION, 
    EDIT_BOOK, 
    CHAT_MESSAGE, 
    PLAYER_ROTATION, 
    ENTITY_ACTION, 
    PLAYER_POSITION, 
    ENTITY_NBT_REQUEST, 
    UPDATE_STRUCTURE_BLOCK, 
    CREATIVE_INVENTORY_ACTION, 
    UPDATE_COMMAND_BLOCK, 
    KEEP_ALIVE, 
    SPECTATE, 
    SEEN_RECIPE, 
    RESOURCE_PACK_STATUS, 
    SET_BEACON_EFFECT, 
    CLIENT_SETTINGS, 
    ADVANCEMENT_TAB, 
    GENERATE_JIGSAW, 
    HELD_ITEM_CHANGE, 
    SELECT_TRADE, 
    QUERY_BLOCK_NBT, 
    PLUGIN_MESSAGE, 
    STEER_VEHICLE, 
    PLAYER_BLOCK_PLACEMENT;
    
    @Override
    public String getName() {
        return this.name();
    }
    
    @Override
    public int getId() {
        return this.ordinal();
    }
}
