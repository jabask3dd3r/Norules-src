package com.viaversion.viaversion.protocols.protocol1_9to1_8.sounds;

import com.viaversion.viaversion.libs.fastutil.ints.*;

public class Effect
{
    private static final /* synthetic */ Int2IntMap EFFECTS;
    
    public static boolean contains(final int lllllllllllllIIllllIIIIIlIlIIlll) {
        return Effect.EFFECTS.containsKey(lllllllllllllIIllllIIIIIlIlIIlll);
    }
    
    public static int getNewId(final int lllllllllllllIIllllIIIIIlIlIlIlI) {
        return Effect.EFFECTS.getOrDefault(lllllllllllllIIllllIIIIIlIlIlIlI, lllllllllllllIIllllIIIIIlIlIlIlI);
    }
    
    private static void addRewrite(final int lllllllllllllIIllllIIIIIlIlIIIIl, final int lllllllllllllIIllllIIIIIlIlIIIlI) {
        Effect.EFFECTS.put(lllllllllllllIIllllIIIIIlIlIIIIl, lllllllllllllIIllllIIIIIlIlIIIlI);
    }
    
    static {
        EFFECTS = new Int2IntOpenHashMap(19, 1.0f);
        addRewrite(1005, 1010);
        addRewrite(1003, 1005);
        addRewrite(1006, 1011);
        addRewrite(1004, 1009);
        addRewrite(1007, 1015);
        addRewrite(1008, 1016);
        addRewrite(1009, 1016);
        addRewrite(1010, 1019);
        addRewrite(1011, 1020);
        addRewrite(1012, 1021);
        addRewrite(1014, 1024);
        addRewrite(1015, 1025);
        addRewrite(1016, 1026);
        addRewrite(1017, 1027);
        addRewrite(1020, 1029);
        addRewrite(1021, 1030);
        addRewrite(1022, 1031);
        addRewrite(1013, 1023);
        addRewrite(1018, 1028);
    }
}
