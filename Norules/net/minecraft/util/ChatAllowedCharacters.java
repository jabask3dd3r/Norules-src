package net.minecraft.util;

import io.netty.util.*;

public class ChatAllowedCharacters
{
    public static final /* synthetic */ ResourceLeakDetector.Level NETTY_LEAK_DETECTION;
    
    public static String filterAllowedCharacters(final String lllllllllllllIIlIIIIIIlIIlIlIIll) {
        final StringBuilder lllllllllllllIIlIIIIIIlIIlIlIlIl = new StringBuilder();
        final char lllllllllllllIIlIIIIIIlIIlIIlllI;
        final int lllllllllllllIIlIIIIIIlIIlIIllll = ((char[])(Object)(lllllllllllllIIlIIIIIIlIIlIIlllI = (char)(Object)lllllllllllllIIlIIIIIIlIIlIlIIll.toCharArray())).length;
        for (double lllllllllllllIIlIIIIIIlIIlIlIIII = 0; lllllllllllllIIlIIIIIIlIIlIlIIII < lllllllllllllIIlIIIIIIlIIlIIllll; ++lllllllllllllIIlIIIIIIlIIlIlIIII) {
            final char lllllllllllllIIlIIIIIIlIIlIlIlII = lllllllllllllIIlIIIIIIlIIlIIlllI[lllllllllllllIIlIIIIIIlIIlIlIIII];
            if (isAllowedCharacter(lllllllllllllIIlIIIIIIlIIlIlIlII)) {
                lllllllllllllIIlIIIIIIlIIlIlIlIl.append(lllllllllllllIIlIIIIIIlIIlIlIlII);
            }
        }
        return String.valueOf(lllllllllllllIIlIIIIIIlIIlIlIlIl);
    }
    
    static {
        NETTY_LEAK_DETECTION = ResourceLeakDetector.Level.DISABLED;
        ILLEGAL_STRUCTURE_CHARACTERS = new char[] { '.', '\n', '\r', '\t', '\0', '\f', '`', '?', '*', '\\', '<', '>', '|', '\"' };
        ILLEGAL_FILE_CHARACTERS = new char[] { '/', '\n', '\r', '\t', '\0', '\f', '`', '?', '*', '\\', '<', '>', '|', '\"', ':' };
        ResourceLeakDetector.setLevel(ChatAllowedCharacters.NETTY_LEAK_DETECTION);
    }
    
    public static boolean isAllowedCharacter(final char lllllllllllllIIlIIIIIIlIIlIlllIl) {
        return lllllllllllllIIlIIIIIIlIIlIlllIl != '§' && lllllllllllllIIlIIIIIIlIIlIlllIl >= ' ' && lllllllllllllIIlIIIIIIlIIlIlllIl != '\u007f';
    }
}
