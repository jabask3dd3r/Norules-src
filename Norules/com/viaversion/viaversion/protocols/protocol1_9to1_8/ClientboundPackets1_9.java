package com.viaversion.viaversion.protocols.protocol1_9to1_8;

import com.viaversion.viaversion.api.protocol.packet.*;

public enum ClientboundPackets1_9 implements ClientboundPacketType
{
    SPAWN_MOB, 
    PLUGIN_MESSAGE, 
    SPAWN_GLOBAL_ENTITY, 
    CHAT_MESSAGE, 
    SET_EXPERIENCE, 
    SERVER_DIFFICULTY, 
    UPDATE_HEALTH, 
    SOUND, 
    VEHICLE_MOVE, 
    ENTITY_TELEPORT, 
    RESPAWN, 
    PLAYER_ABILITIES, 
    ENTITY_EFFECT, 
    COLLECT_ITEM, 
    TAB_COMPLETE, 
    ENTITY_HEAD_LOOK, 
    UNLOAD_CHUNK, 
    TIME_UPDATE, 
    ENTITY_STATUS, 
    TEAMS, 
    BLOCK_ACTION, 
    BOSSBAR, 
    SPAWN_ENTITY, 
    CLOSE_WINDOW, 
    SCOREBOARD_OBJECTIVE, 
    DISPLAY_SCOREBOARD, 
    ENTITY_METADATA, 
    GAME_EVENT, 
    PLAYER_INFO, 
    ENTITY_ANIMATION, 
    WINDOW_CONFIRMATION, 
    EFFECT, 
    ENTITY_VELOCITY, 
    BLOCK_ENTITY_DATA, 
    TITLE, 
    SPAWN_EXPERIENCE_ORB, 
    MAP_DATA, 
    BLOCK_CHANGE, 
    RESOURCE_PACK, 
    PLAYER_POSITION, 
    EXPLOSION, 
    COMBAT_EVENT, 
    JOIN_GAME, 
    CAMERA, 
    TAB_LIST, 
    STATISTICS, 
    COOLDOWN, 
    UPDATE_SIGN, 
    HELD_ITEM_CHANGE, 
    ENTITY_ROTATION, 
    REMOVE_ENTITY_EFFECT, 
    UPDATE_SCORE, 
    SPAWN_POSITION, 
    OPEN_WINDOW, 
    SET_PASSENGERS, 
    SPAWN_PAINTING, 
    KEEP_ALIVE, 
    ATTACH_ENTITY, 
    WORLD_BORDER, 
    WINDOW_ITEMS, 
    DISCONNECT, 
    SET_SLOT, 
    CHUNK_DATA, 
    BLOCK_BREAK_ANIMATION, 
    DESTROY_ENTITIES, 
    ENTITY_PROPERTIES, 
    ENTITY_MOVEMENT, 
    NAMED_SOUND, 
    SPAWN_PARTICLE, 
    OPEN_SIGN_EDITOR, 
    WINDOW_PROPERTY, 
    SPAWN_PLAYER, 
    ENTITY_POSITION_AND_ROTATION, 
    ENTITY_POSITION, 
    ENTITY_EQUIPMENT, 
    MULTI_BLOCK_CHANGE, 
    USE_BED;
    
    @Override
    public int getId() {
        return this.ordinal();
    }
    
    @Override
    public String getName() {
        return this.name();
    }
}
