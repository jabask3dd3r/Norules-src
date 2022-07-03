package de.gerrygames.viarewind.protocol.protocol1_7_6_10to1_8;

import com.viaversion.viaversion.api.protocol.packet.*;

public enum ClientboundPackets1_7 implements ClientboundPacketType
{
    PLUGIN_MESSAGE, 
    TEAMS, 
    BLOCK_BREAK_ANIMATION, 
    MAP_BULK_CHUNK, 
    ENTITY_MOVEMENT, 
    PLAYER_INFO, 
    RESPAWN, 
    BLOCK_ACTION, 
    UPDATE_SCORE, 
    ENTITY_HEAD_LOOK, 
    DESTROY_ENTITIES, 
    COLLECT_ITEM, 
    SPAWN_PAINTING, 
    SCOREBOARD_OBJECTIVE, 
    JOIN_GAME, 
    ENTITY_ANIMATION, 
    SPAWN_PARTICLE, 
    PLAYER_ABILITIES, 
    BLOCK_CHANGE, 
    ENTITY_STATUS, 
    ENTITY_EQUIPMENT, 
    ENTITY_POSITION_AND_ROTATION, 
    MAP_DATA, 
    REMOVE_ENTITY_EFFECT, 
    CHAT_MESSAGE, 
    ENTITY_ROTATION, 
    DISCONNECT, 
    CHUNK_DATA, 
    SET_SLOT, 
    BLOCK_ENTITY_DATA, 
    DISPLAY_SCOREBOARD, 
    PLAYER_POSITION, 
    SPAWN_POSITION, 
    SPAWN_EXPERIENCE_ORB, 
    WINDOW_PROPERTY, 
    EXPLOSION, 
    SET_EXPERIENCE, 
    GAME_EVENT, 
    MULTI_BLOCK_CHANGE, 
    ENTITY_PROPERTIES, 
    SPAWN_ENTITY, 
    ATTACH_ENTITY, 
    ENTITY_EFFECT, 
    STATISTICS, 
    UPDATE_HEALTH, 
    TAB_COMPLETE, 
    NAMED_SOUND, 
    UPDATE_SIGN, 
    ENTITY_VELOCITY, 
    SPAWN_MOB, 
    TIME_UPDATE, 
    HELD_ITEM_CHANGE, 
    EFFECT, 
    WINDOW_ITEMS, 
    KEEP_ALIVE, 
    ENTITY_POSITION, 
    WINDOW_CONFIRMATION, 
    SPAWN_GLOBAL_ENTITY, 
    OPEN_WINDOW, 
    ENTITY_METADATA, 
    USE_BED, 
    SPAWN_PLAYER, 
    ENTITY_TELEPORT, 
    CLOSE_WINDOW, 
    OPEN_SIGN_EDITOR;
    
    @Override
    public String getName() {
        return this.name();
    }
    
    @Override
    public int getId() {
        return this.ordinal();
    }
}
