package com.viaversion.viaversion.protocols.protocol1_17to1_16_4;

import com.viaversion.viaversion.api.protocol.packet.*;

public enum ServerboundPackets1_17 implements ServerboundPacketType
{
    GENERATE_JIGSAW, 
    CHAT_MESSAGE, 
    PLAYER_ABILITIES, 
    PLAYER_POSITION, 
    CLIENT_SETTINGS, 
    CLIENT_STATUS, 
    PLUGIN_MESSAGE, 
    PLAYER_MOVEMENT, 
    RECIPE_BOOK_DATA, 
    SEEN_RECIPE, 
    LOCK_DIFFICULTY, 
    PONG, 
    ANIMATION, 
    CLOSE_WINDOW, 
    PICK_ITEM, 
    ENTITY_ACTION, 
    SPECTATE, 
    USE_ITEM, 
    CRAFT_RECIPE_REQUEST, 
    PLAYER_BLOCK_PLACEMENT, 
    CREATIVE_INVENTORY_ACTION, 
    PLAYER_DIGGING, 
    INTERACT_ENTITY, 
    ENTITY_NBT_REQUEST, 
    PLAYER_POSITION_AND_ROTATION, 
    STEER_VEHICLE, 
    UPDATE_STRUCTURE_BLOCK, 
    RENAME_ITEM, 
    SELECT_TRADE, 
    VEHICLE_MOVE, 
    UPDATE_JIGSAW_BLOCK, 
    SET_DIFFICULTY, 
    PLAYER_ROTATION, 
    CLICK_WINDOW_BUTTON, 
    QUERY_BLOCK_NBT, 
    CLICK_WINDOW, 
    UPDATE_COMMAND_BLOCK, 
    KEEP_ALIVE, 
    TELEPORT_CONFIRM, 
    HELD_ITEM_CHANGE, 
    UPDATE_COMMAND_BLOCK_MINECART, 
    SET_BEACON_EFFECT, 
    ADVANCEMENT_TAB, 
    UPDATE_SIGN, 
    RESOURCE_PACK_STATUS, 
    STEER_BOAT, 
    EDIT_BOOK, 
    TAB_COMPLETE;
    
    @Override
    public String getName() {
        return this.name();
    }
    
    @Override
    public int getId() {
        return this.ordinal();
    }
}
