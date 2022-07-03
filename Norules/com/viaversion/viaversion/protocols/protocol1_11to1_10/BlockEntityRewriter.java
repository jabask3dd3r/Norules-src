package com.viaversion.viaversion.protocols.protocol1_11to1_10;

import com.google.common.collect.*;

public class BlockEntityRewriter
{
    private static /* synthetic */ BiMap<String, String> oldToNewNames;
    
    public static String toNewIdentifier(final String llllllllllllllIIIllIIIlIlIlIllll) {
        final String llllllllllllllIIIllIIIlIlIllIIII = (String)BlockEntityRewriter.oldToNewNames.get((Object)llllllllllllllIIIllIIIlIlIlIllll);
        if (llllllllllllllIIIllIIIlIlIllIIII != null) {
            return llllllllllllllIIIllIIIlIlIllIIII;
        }
        return llllllllllllllIIIllIIIlIlIlIllll;
    }
    
    static {
        BlockEntityRewriter.oldToNewNames = (BiMap<String, String>)HashBiMap.create();
        rewrite("Furnace", "furnace");
        rewrite("Chest", "chest");
        rewrite("EnderChest", "ender_chest");
        rewrite("RecordPlayer", "jukebox");
        rewrite("Trap", "dispenser");
        rewrite("Dropper", "dropper");
        rewrite("Sign", "sign");
        rewrite("MobSpawner", "mob_spawner");
        rewrite("Music", "noteblock");
        rewrite("Piston", "piston");
        rewrite("Cauldron", "brewing_stand");
        rewrite("EnchantTable", "enchanting_table");
        rewrite("Airportal", "end_portal");
        rewrite("Beacon", "beacon");
        rewrite("Skull", "skull");
        rewrite("DLDetector", "daylight_detector");
        rewrite("Hopper", "hopper");
        rewrite("Comparator", "comparator");
        rewrite("FlowerPot", "flower_pot");
        rewrite("Banner", "banner");
        rewrite("Structure", "structure_block");
        rewrite("EndGateway", "end_gateway");
        rewrite("Control", "command_block");
    }
    
    private static void rewrite(final String llllllllllllllIIIllIIIlIlIlllIII, final String llllllllllllllIIIllIIIlIlIlllIIl) {
        BlockEntityRewriter.oldToNewNames.put((Object)llllllllllllllIIIllIIIlIlIlllIII, (Object)String.valueOf(new StringBuilder().append("minecraft:").append(llllllllllllllIIIllIIIlIlIlllIIl)));
    }
    
    public static BiMap<String, String> inverse() {
        return (BiMap<String, String>)BlockEntityRewriter.oldToNewNames.inverse();
    }
}
