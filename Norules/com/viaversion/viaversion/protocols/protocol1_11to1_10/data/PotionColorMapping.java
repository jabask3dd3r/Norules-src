package com.viaversion.viaversion.protocols.protocol1_11to1_10.data;

import com.viaversion.viaversion.util.*;
import com.viaversion.viaversion.libs.fastutil.ints.*;

public class PotionColorMapping
{
    private static final /* synthetic */ Int2ObjectMap<Pair<Integer, Boolean>> POTIONS;
    
    private static void addRewrite(final int llllllllllllllIIIIIIlIIIIIIllllI, final int llllllllllllllIIIIIIlIIIIIIllIlI, final boolean llllllllllllllIIIIIIlIIIIIIllIIl) {
        PotionColorMapping.POTIONS.put(llllllllllllllIIIIIIlIIIIIIllllI, new Pair<Integer, Boolean>(llllllllllllllIIIIIIlIIIIIIllIlI, llllllllllllllIIIIIIlIIIIIIllIIl));
    }
    
    static {
        POTIONS = new Int2ObjectOpenHashMap<Pair<Integer, Boolean>>(37, 1.0f);
        addRewrite(0, 3694022, false);
        addRewrite(1, 3694022, false);
        addRewrite(2, 3694022, false);
        addRewrite(3, 3694022, false);
        addRewrite(4, 3694022, false);
        addRewrite(5, 2039713, false);
        addRewrite(6, 2039713, false);
        addRewrite(7, 8356754, false);
        addRewrite(8, 8356754, false);
        addRewrite(9, 2293580, false);
        addRewrite(10, 2293580, false);
        addRewrite(11, 2293580, false);
        addRewrite(12, 14981690, false);
        addRewrite(13, 14981690, false);
        addRewrite(14, 8171462, false);
        addRewrite(15, 8171462, false);
        addRewrite(16, 8171462, false);
        addRewrite(17, 5926017, false);
        addRewrite(18, 5926017, false);
        addRewrite(19, 3035801, false);
        addRewrite(20, 3035801, false);
        addRewrite(21, 16262179, true);
        addRewrite(22, 16262179, true);
        addRewrite(23, 4393481, true);
        addRewrite(24, 4393481, true);
        addRewrite(25, 5149489, false);
        addRewrite(26, 5149489, false);
        addRewrite(27, 5149489, false);
        addRewrite(28, 13458603, false);
        addRewrite(29, 13458603, false);
        addRewrite(30, 13458603, false);
        addRewrite(31, 9643043, false);
        addRewrite(32, 9643043, false);
        addRewrite(33, 9643043, false);
        addRewrite(34, 4738376, false);
        addRewrite(35, 4738376, false);
        addRewrite(36, 3381504, false);
    }
    
    public static Pair<Integer, Boolean> getNewData(final int llllllllllllllIIIIIIlIIIIIlIIIll) {
        return PotionColorMapping.POTIONS.get(llllllllllllllIIIIIIlIIIIIlIIIll);
    }
}
