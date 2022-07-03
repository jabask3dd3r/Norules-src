package de.gerrygames.viarewind.protocol.protocol1_7_6_10to1_8;

import com.viaversion.viaversion.api.protocol.packet.*;

public enum ServerboundPackets1_7 implements ServerboundPacketType
{
    CLIENT_SETTINGS, 
    PLAYER_DIGGING, 
    PLAYER_ROTATION, 
    HELD_ITEM_CHANGE, 
    INTERACT_ENTITY, 
    ANIMATION, 
    PLAYER_POSITION, 
    CLICK_WINDOW_BUTTON, 
    PLAYER_BLOCK_PLACEMENT, 
    CHAT_MESSAGE, 
    PLUGIN_MESSAGE, 
    PLAYER_MOVEMENT, 
    CREATIVE_INVENTORY_ACTION, 
    TAB_COMPLETE, 
    CLICK_WINDOW, 
    CLOSE_WINDOW, 
    PLAYER_POSITION_AND_ROTATION, 
    CLIENT_STATUS, 
    ENTITY_ACTION, 
    PLAYER_ABILITIES, 
    UPDATE_SIGN, 
    WINDOW_CONFIRMATION, 
    STEER_VEHICLE, 
    KEEP_ALIVE;
    
    @Override
    public int getId() {
        return this.ordinal();
    }
    
    @Override
    public String getName() {
        return this.name();
    }
}
