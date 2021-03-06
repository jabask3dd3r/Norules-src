package com.viaversion.viaversion.protocols.protocol1_12_1to1_12;

import com.viaversion.viaversion.api.protocol.packet.*;

public enum ClientboundPackets1_12_1 implements ClientboundPacketType
{
    MAP_DATA, 
    ENTITY_TELEPORT, 
    ATTACH_ENTITY, 
    ENTITY_METADATA, 
    UNLOAD_CHUNK, 
    CHUNK_DATA, 
    RESOURCE_PACK, 
    COLLECT_ITEM, 
    SELECT_ADVANCEMENTS_TAB, 
    TITLE, 
    BLOCK_CHANGE, 
    BLOCK_ENTITY_DATA, 
    SPAWN_PARTICLE, 
    ENTITY_EFFECT, 
    ENTITY_ROTATION, 
    UPDATE_HEALTH, 
    USE_BED, 
    ENTITY_HEAD_LOOK, 
    CHAT_MESSAGE, 
    SET_EXPERIENCE, 
    ENTITY_MOVEMENT, 
    UNLOCK_RECIPES, 
    SPAWN_EXPERIENCE_ORB, 
    ENTITY_VELOCITY, 
    SPAWN_MOB, 
    MULTI_BLOCK_CHANGE, 
    NAMED_SOUND, 
    DISPLAY_SCOREBOARD, 
    SPAWN_ENTITY, 
    ENTITY_PROPERTIES, 
    VEHICLE_MOVE, 
    TEAMS, 
    REMOVE_ENTITY_EFFECT, 
    COOLDOWN, 
    UPDATE_SCORE, 
    ENTITY_ANIMATION, 
    STATISTICS, 
    COMBAT_EVENT, 
    HELD_ITEM_CHANGE, 
    DISCONNECT, 
    ENTITY_EQUIPMENT, 
    SPAWN_PLAYER, 
    ENTITY_POSITION_AND_ROTATION, 
    SERVER_DIFFICULTY, 
    CLOSE_WINDOW, 
    CRAFT_RECIPE_RESPONSE, 
    BOSSBAR, 
    TAB_LIST, 
    SET_PASSENGERS, 
    PLUGIN_MESSAGE, 
    OPEN_SIGN_EDITOR, 
    SPAWN_GLOBAL_ENTITY, 
    PLAYER_ABILITIES, 
    GAME_EVENT, 
    SPAWN_PAINTING, 
    BLOCK_BREAK_ANIMATION, 
    WORLD_BORDER, 
    KEEP_ALIVE, 
    BLOCK_ACTION, 
    WINDOW_CONFIRMATION, 
    SET_SLOT, 
    SCOREBOARD_OBJECTIVE, 
    ENTITY_STATUS, 
    DESTROY_ENTITIES, 
    RESPAWN, 
    PLAYER_POSITION, 
    JOIN_GAME, 
    PLAYER_INFO, 
    SOUND, 
    ENTITY_POSITION, 
    ADVANCEMENTS, 
    TIME_UPDATE, 
    OPEN_WINDOW, 
    TAB_COMPLETE, 
    WINDOW_ITEMS, 
    EFFECT, 
    SPAWN_POSITION, 
    EXPLOSION, 
    WINDOW_PROPERTY, 
    CAMERA;
    
    @Override
    public String getName() {
        return this.name();
    }
    
    @Override
    public int getId() {
        return this.ordinal();
    }
}
