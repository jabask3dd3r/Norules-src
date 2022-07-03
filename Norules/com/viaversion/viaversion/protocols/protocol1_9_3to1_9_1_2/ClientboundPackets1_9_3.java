package com.viaversion.viaversion.protocols.protocol1_9_3to1_9_1_2;

import com.viaversion.viaversion.api.protocol.packet.*;

public enum ClientboundPackets1_9_3 implements ClientboundPacketType
{
    ENTITY_ANIMATION, 
    UPDATE_SCORE, 
    ENTITY_STATUS, 
    BLOCK_ENTITY_DATA, 
    USE_BED, 
    ENTITY_POSITION, 
    ENTITY_METADATA, 
    GAME_EVENT, 
    SPAWN_MOB, 
    SCOREBOARD_OBJECTIVE, 
    SOUND, 
    KEEP_ALIVE, 
    SPAWN_ENTITY, 
    OPEN_WINDOW, 
    UNLOAD_CHUNK, 
    BLOCK_ACTION, 
    SET_EXPERIENCE, 
    UPDATE_HEALTH, 
    JOIN_GAME, 
    RESOURCE_PACK, 
    OPEN_SIGN_EDITOR, 
    TIME_UPDATE, 
    PLAYER_POSITION, 
    PLUGIN_MESSAGE, 
    SPAWN_POSITION, 
    STATISTICS, 
    EFFECT, 
    TAB_COMPLETE, 
    SET_SLOT, 
    SPAWN_PARTICLE, 
    COOLDOWN, 
    SET_PASSENGERS, 
    EXPLOSION, 
    WINDOW_PROPERTY, 
    ENTITY_ROTATION, 
    ENTITY_MOVEMENT, 
    TAB_LIST, 
    MULTI_BLOCK_CHANGE, 
    NAMED_SOUND, 
    COMBAT_EVENT, 
    BLOCK_CHANGE, 
    TEAMS, 
    ENTITY_PROPERTIES, 
    CAMERA, 
    ENTITY_POSITION_AND_ROTATION, 
    DISCONNECT, 
    REMOVE_ENTITY_EFFECT, 
    ENTITY_EFFECT, 
    SPAWN_EXPERIENCE_ORB, 
    COLLECT_ITEM, 
    PLAYER_ABILITIES, 
    RESPAWN, 
    ENTITY_EQUIPMENT, 
    SPAWN_PAINTING, 
    ENTITY_VELOCITY, 
    ENTITY_TELEPORT, 
    CLOSE_WINDOW, 
    DESTROY_ENTITIES, 
    TITLE, 
    ENTITY_HEAD_LOOK, 
    SPAWN_PLAYER, 
    WINDOW_ITEMS, 
    BLOCK_BREAK_ANIMATION, 
    SPAWN_GLOBAL_ENTITY, 
    DISPLAY_SCOREBOARD, 
    CHAT_MESSAGE, 
    MAP_DATA, 
    WORLD_BORDER, 
    BOSSBAR, 
    PLAYER_INFO, 
    ATTACH_ENTITY, 
    HELD_ITEM_CHANGE, 
    WINDOW_CONFIRMATION, 
    VEHICLE_MOVE, 
    SERVER_DIFFICULTY, 
    CHUNK_DATA;
    
    @Override
    public String getName() {
        return this.name();
    }
    
    @Override
    public int getId() {
        return this.ordinal();
    }
}
