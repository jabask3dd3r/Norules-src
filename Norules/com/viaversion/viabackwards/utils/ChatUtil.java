package com.viaversion.viabackwards.utils;

import java.util.regex.*;

public class ChatUtil
{
    private static final /* synthetic */ Pattern UNUSED_COLOR_PATTERN_PREFIX;
    private static final /* synthetic */ Pattern UNUSED_COLOR_PATTERN;
    
    public static String removeUnusedColor(final String llllllllllllllIlIIlllIIlIIllIlll, final char llllllllllllllIlIIlllIIlIIllIllI) {
        return removeUnusedColor(llllllllllllllIlIIlllIIlIIllIlll, llllllllllllllIlIIlllIIlIIllIllI, false);
    }
    
    public static String removeUnusedColor(String llllllllllllllIlIIlllIIlIIlIlIll, final char llllllllllllllIlIIlllIIlIIlIlIlI, final boolean llllllllllllllIlIIlllIIlIIlIlIIl) {
        if (llllllllllllllIlIIlllIIlIIlIlIll == null) {
            return null;
        }
        final Pattern llllllllllllllIlIIlllIIlIIlIlIII = llllllllllllllIlIIlllIIlIIlIlIIl ? ChatUtil.UNUSED_COLOR_PATTERN_PREFIX : ChatUtil.UNUSED_COLOR_PATTERN;
        llllllllllllllIlIIlllIIlIIlIlIll = llllllllllllllIlIIlllIIlIIlIlIII.matcher(llllllllllllllIlIIlllIIlIIlIlIll).replaceAll("$1$2");
        final StringBuilder llllllllllllllIlIIlllIIlIIlIIlll = new StringBuilder();
        char llllllllllllllIlIIlllIIlIIlIIllI = llllllllllllllIlIIlllIIlIIlIlIlI;
        for (int llllllllllllllIlIIlllIIlIIlIllII = 0; llllllllllllllIlIIlllIIlIIlIllII < llllllllllllllIlIIlllIIlIIlIlIll.length(); ++llllllllllllllIlIIlllIIlIIlIllII) {
            char llllllllllllllIlIIlllIIlIIlIllIl = llllllllllllllIlIIlllIIlIIlIlIll.charAt(llllllllllllllIlIIlllIIlIIlIllII);
            if (llllllllllllllIlIIlllIIlIIlIllIl != '§' || llllllllllllllIlIIlllIIlIIlIllII == llllllllllllllIlIIlllIIlIIlIlIll.length() - 1) {
                llllllllllllllIlIIlllIIlIIlIIlll.append(llllllllllllllIlIIlllIIlIIlIllIl);
            }
            else {
                llllllllllllllIlIIlllIIlIIlIllIl = llllllllllllllIlIIlllIIlIIlIlIll.charAt(++llllllllllllllIlIIlllIIlIIlIllII);
                if (llllllllllllllIlIIlllIIlIIlIllIl != llllllllllllllIlIIlllIIlIIlIIllI) {
                    llllllllllllllIlIIlllIIlIIlIIlll.append('§').append(llllllllllllllIlIIlllIIlIIlIllIl);
                    llllllllllllllIlIIlllIIlIIlIIllI = llllllllllllllIlIIlllIIlIIlIllIl;
                }
            }
        }
        return String.valueOf(llllllllllllllIlIIlllIIlIIlIIlll);
    }
    
    static {
        UNUSED_COLOR_PATTERN = Pattern.compile("(?>(?>§[0-fk-or])*(§r|\\Z))|(?>(?>§[0-f])*(§[0-f]))");
        UNUSED_COLOR_PATTERN_PREFIX = Pattern.compile("(?>(?>§[0-fk-or])*(§r))|(?>(?>§[0-f])*(§[0-f]))");
    }
}
