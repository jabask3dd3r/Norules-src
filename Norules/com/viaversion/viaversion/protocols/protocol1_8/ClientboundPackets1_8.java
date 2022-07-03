package com.viaversion.viaversion.protocols.protocol1_8;

import com.viaversion.viaversion.api.protocol.packet.*;

public enum ClientboundPackets1_8 implements ClientboundPacketType
{
    CHUNK_DATA, 
    ENTITY_TELEPORT, 
    CHAT_MESSAGE, 
    ENTITY_METADATA, 
    GAME_EVENT, 
    TITLE, 
    WINDOW_PROPERTY, 
    SET_COMPRESSION, 
    TEAMS, 
    DESTROY_ENTITIES, 
    ENTITY_ANIMATION, 
    ENTITY_EFFECT, 
    MAP_BULK_CHUNK, 
    SPAWN_PARTICLE, 
    ENTITY_VELOCITY, 
    SET_SLOT, 
    UPDATE_SCORE, 
    SPAWN_PLAYER, 
    MULTI_BLOCK_CHANGE, 
    REMOVE_ENTITY_EFFECT, 
    NAMED_SOUND, 
    TAB_COMPLETE, 
    TIME_UPDATE, 
    SPAWN_MOB, 
    WINDOW_CONFIRMATION, 
    TAB_LIST, 
    WINDOW_ITEMS, 
    SPAWN_GLOBAL_ENTITY, 
    EFFECT, 
    WORLD_BORDER, 
    BLOCK_CHANGE, 
    UPDATE_HEALTH, 
    BLOCK_ENTITY_DATA, 
    CAMERA, 
    DISCONNECT, 
    ENTITY_MOVEMENT, 
    BLOCK_BREAK_ANIMATION, 
    HELD_ITEM_CHANGE, 
    ENTITY_ROTATION, 
    KEEP_ALIVE, 
    ENTITY_POSITION_AND_ROTATION, 
    JOIN_GAME, 
    PLAYER_INFO, 
    CLOSE_WINDOW, 
    SET_EXPERIENCE, 
    ENTITY_POSITION, 
    OPEN_SIGN_EDITOR, 
    ENTITY_STATUS, 
    MAP_DATA, 
    SCOREBOARD_OBJECTIVE, 
    DISPLAY_SCOREBOARD, 
    UPDATE_ENTITY_NBT, 
    EXPLOSION, 
    PLAYER_ABILITIES, 
    SPAWN_ENTITY, 
    ATTACH_ENTITY, 
    RESOURCE_PACK, 
    STATISTICS, 
    RESPAWN, 
    ENTITY_PROPERTIES, 
    BLOCK_ACTION, 
    PLAYER_POSITION, 
    SPAWN_PAINTING, 
    ENTITY_HEAD_LOOK, 
    ENTITY_EQUIPMENT, 
    USE_BED, 
    SERVER_DIFFICULTY, 
    COLLECT_ITEM, 
    SPAWN_POSITION, 
    OPEN_WINDOW, 
    UPDATE_SIGN, 
    SPAWN_EXPERIENCE_ORB, 
    PLUGIN_MESSAGE, 
    COMBAT_EVENT;
    
    @Override
    public String getName() {
        return this.name();
    }
    
    @Override
    public int getId() {
        return this.ordinal();
    }
}
