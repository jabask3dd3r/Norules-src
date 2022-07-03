package com.viaversion.viaversion.protocols.protocol1_13to1_12_2.data;

import java.util.*;

public class EntityNameRewriter
{
    private static final /* synthetic */ Map<String, String> entityNames;
    
    private static void reg(final String llllllllllllllIlllIlIIIlIIlIlllI, final String llllllllllllllIlllIlIIIlIIlIllIl) {
        EntityNameRewriter.entityNames.put(String.valueOf(new StringBuilder().append("minecraft:").append(llllllllllllllIlllIlIIIlIIlIlllI)), String.valueOf(new StringBuilder().append("minecraft:").append(llllllllllllllIlllIlIIIlIIlIllIl)));
    }
    
    public static String rewrite(final String llllllllllllllIlllIlIIIlIIlIIllI) {
        String llllllllllllllIlllIlIIIlIIlIIlll = EntityNameRewriter.entityNames.get(llllllllllllllIlllIlIIIlIIlIIllI);
        if (llllllllllllllIlllIlIIIlIIlIIlll != null) {
            return llllllllllllllIlllIlIIIlIIlIIlll;
        }
        llllllllllllllIlllIlIIIlIIlIIlll = EntityNameRewriter.entityNames.get(String.valueOf(new StringBuilder().append("minecraft:").append(llllllllllllllIlllIlIIIlIIlIIllI)));
        if (llllllllllllllIlllIlIIIlIIlIIlll != null) {
            return llllllllllllllIlllIlIIIlIIlIIlll;
        }
        return llllllllllllllIlllIlIIIlIIlIIllI;
    }
    
    static {
        entityNames = new HashMap<String, String>();
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
