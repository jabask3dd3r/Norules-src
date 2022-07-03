package com.viaversion.viaversion.util;

import java.util.regex.*;
import com.viaversion.viaversion.libs.fastutil.ints.*;

public class ChatColorUtil
{
    public static final /* synthetic */ Pattern STRIP_COLOR_PATTERN;
    private static final /* synthetic */ Int2IntMap COLOR_ORDINALS;
    private static /* synthetic */ int ordinalCounter;
    
    private static void addColorOrdinal(final int lllllllllllllIIIIIIIIIlllIllIlII) {
        ChatColorUtil.COLOR_ORDINALS.put(lllllllllllllIIIIIIIIIlllIllIlII, ChatColorUtil.ordinalCounter++);
    }
    
    public static int getColorOrdinal(final char lllllllllllllIIIIIIIIIllllIIlIll) {
        return ChatColorUtil.COLOR_ORDINALS.getOrDefault(lllllllllllllIIIIIIIIIllllIIlIll, -1);
    }
    
    private static void addColorOrdinal(final int lllllllllllllIIIIIIIIIlllIlllIlI, final int lllllllllllllIIIIIIIIIlllIllIlll) {
        for (int lllllllllllllIIIIIIIIIlllIlllIll = lllllllllllllIIIIIIIIIlllIlllIlI; lllllllllllllIIIIIIIIIlllIlllIll <= lllllllllllllIIIIIIIIIlllIllIlll; ++lllllllllllllIIIIIIIIIlllIlllIll) {
            addColorOrdinal(lllllllllllllIIIIIIIIIlllIlllIll);
        }
    }
    
    public static String stripColor(final String lllllllllllllIIIIIIIIIlllIllllll) {
        return ChatColorUtil.STRIP_COLOR_PATTERN.matcher(lllllllllllllIIIIIIIIIlllIllllll).replaceAll("");
    }
    
    public static boolean isColorCode(final char lllllllllllllIIIIIIIIIllllIIllll) {
        return ChatColorUtil.COLOR_ORDINALS.containsKey(lllllllllllllIIIIIIIIIllllIIllll);
    }
    
    static {
        ALL_CODES = "0123456789AaBbCcDdEeFfKkLlMmNnOoRrXx";
        COLOR_CHAR = '§';
        STRIP_COLOR_PATTERN = Pattern.compile("(?i)§[0-9A-FK-ORX]");
        COLOR_ORDINALS = new Int2IntOpenHashMap();
        addColorOrdinal(48, 57);
        addColorOrdinal(97, 102);
        addColorOrdinal(107, 111);
        addColorOrdinal(114);
    }
    
    public static String translateAlternateColorCodes(final String lllllllllllllIIIIIIIIIllllIIIllI) {
        final char[] lllllllllllllIIIIIIIIIllllIIIlIl = lllllllllllllIIIIIIIIIllllIIIllI.toCharArray();
        for (int lllllllllllllIIIIIIIIIllllIIIlll = 0; lllllllllllllIIIIIIIIIllllIIIlll < lllllllllllllIIIIIIIIIllllIIIlIl.length - 1; ++lllllllllllllIIIIIIIIIllllIIIlll) {
            if (lllllllllllllIIIIIIIIIllllIIIlIl[lllllllllllllIIIIIIIIIllllIIIlll] == '&' && "0123456789AaBbCcDdEeFfKkLlMmNnOoRrXx".indexOf(lllllllllllllIIIIIIIIIllllIIIlIl[lllllllllllllIIIIIIIIIllllIIIlll + 1]) > -1) {
                lllllllllllllIIIIIIIIIllllIIIlIl[lllllllllllllIIIIIIIIIllllIIIlll] = '§';
                lllllllllllllIIIIIIIIIllllIIIlIl[lllllllllllllIIIIIIIIIllllIIIlll + 1] = Character.toLowerCase(lllllllllllllIIIIIIIIIllllIIIlIl[lllllllllllllIIIIIIIIIllllIIIlll + 1]);
            }
        }
        return new String(lllllllllllllIIIIIIIIIllllIIIlIl);
    }
}
