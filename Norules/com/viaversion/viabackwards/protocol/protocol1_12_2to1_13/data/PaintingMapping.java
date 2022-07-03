package com.viaversion.viabackwards.protocol.protocol1_12_2to1_13.data;

import com.viaversion.viaversion.libs.fastutil.ints.*;

public class PaintingMapping
{
    private static final /* synthetic */ Int2ObjectMap<String> PAINTINGS;
    
    public static String getStringId(final int lllllllllllllIIllIlIlIlIlIlIlIIl) {
        return PaintingMapping.PAINTINGS.getOrDefault(lllllllllllllIIllIlIlIlIlIlIlIIl, "kebab");
    }
    
    public static void init() {
        add("Kebab");
        add("Aztec");
        add("Alban");
        add("Aztec2");
        add("Bomb");
        add("Plant");
        add("Wasteland");
        add("Pool");
        add("Courbet");
        add("Sea");
        add("Sunset");
        add("Creebet");
        add("Wanderer");
        add("Graham");
        add("Match");
        add("Bust");
        add("Stage");
        add("Void");
        add("SkullAndRoses");
        add("Wither");
        add("Fighters");
        add("Pointer");
        add("Pigscene");
        add("BurningSkull");
        add("Skeleton");
        add("DonkeyKong");
    }
    
    static {
        PAINTINGS = new Int2ObjectOpenHashMap<String>(26, 1.0f);
    }
    
    private static void add(final String lllllllllllllIIllIlIlIlIlIlIllIl) {
        PaintingMapping.PAINTINGS.put(PaintingMapping.PAINTINGS.size(), lllllllllllllIIllIlIlIlIlIlIllIl);
    }
}
