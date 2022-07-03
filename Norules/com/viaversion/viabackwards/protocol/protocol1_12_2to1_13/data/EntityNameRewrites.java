package com.viaversion.viabackwards.protocol.protocol1_12_2to1_13.data;

import java.util.*;

public class EntityNameRewrites
{
    private static final /* synthetic */ Map<String, String> ENTITY_NAMES;
    
    private static void reg(final String llIIlIlIllIIII, final String llIIlIlIlIllll) {
        EntityNameRewrites.ENTITY_NAMES.put(String.valueOf(new StringBuilder().append("minecraft:").append(llIIlIlIlIllll)), String.valueOf(new StringBuilder().append("minecraft:").append(llIIlIlIllIIII)));
    }
    
    public static String rewrite(final String llIIlIlIlIlIII) {
        String llIIlIlIlIlIIl = EntityNameRewrites.ENTITY_NAMES.get(llIIlIlIlIlIII);
        if (llIIlIlIlIlIIl != null) {
            return llIIlIlIlIlIIl;
        }
        llIIlIlIlIlIIl = EntityNameRewrites.ENTITY_NAMES.get(String.valueOf(new StringBuilder().append("minecraft:").append(llIIlIlIlIlIII)));
        if (llIIlIlIlIlIIl != null) {
            return llIIlIlIlIlIIl;
        }
        return llIIlIlIlIlIII;
    }
    
    static {
        ENTITY_NAMES = new HashMap<String, String>();
        reg("commandblock_minecart", "command_block_minecart");
        reg("ender_crystal", "end_crystal");
        reg("evocation_fangs", "evoker_fangs");
        reg("evocation_illager", "evoker");
        reg("eye_of_ender_signal", "eye_of_ender");
        reg("fireworks_rocket", "firework_rocket");
        reg("illusion_illager", "illusioner");
        reg("snowman", "snow_golem");
        reg("villager_golem", "iron_golem");
        reg("vindication_illager", "vindicator");
        reg("xp_bottle", "experience_bottle");
        reg("xp_orb", "experience_orb");
    }
}
