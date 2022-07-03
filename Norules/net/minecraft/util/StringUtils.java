package net.minecraft.util;

import java.util.regex.*;
import javax.annotation.*;

public class StringUtils
{
    private static final /* synthetic */ Pattern PATTERN_CONTROL_CODE;
    
    public static String ticksToElapsedTime(final int lllllllllllllIllllIlIIlIIlIllIIl) {
        int lllllllllllllIllllIlIIlIIlIllIII = lllllllllllllIllllIlIIlIIlIllIIl / 20;
        final int lllllllllllllIllllIlIIlIIlIlIlll = lllllllllllllIllllIlIIlIIlIllIII / 60;
        lllllllllllllIllllIlIIlIIlIllIII %= 60;
        return (lllllllllllllIllllIlIIlIIlIllIII < 10) ? String.valueOf(new StringBuilder(String.valueOf(lllllllllllllIllllIlIIlIIlIlIlll)).append(":0").append(lllllllllllllIllllIlIIlIIlIllIII)) : String.valueOf(new StringBuilder(String.valueOf(lllllllllllllIllllIlIIlIIlIlIlll)).append(":").append(lllllllllllllIllllIlIIlIIlIllIII));
    }
    
    public static boolean isDouble(final String lllllllllllllIllllIlIIlIIlIllllI) {
        try {
            Double.parseDouble(lllllllllllllIllllIlIIlIIlIllllI);
            return true;
        }
        catch (Exception lllllllllllllIllllIlIIlIIlIlllll) {
            return false;
        }
    }
    
    public static final Character getOrNull(final CharSequence lllllllllllllIllllIlIIlIIllIIllI, final int lllllllllllllIllllIlIIlIIllIIlIl) {
        return (lllllllllllllIllllIlIIlIIllIIlIl >= 0 && lllllllllllllIllllIlIIlIIllIIlIl <= lllllllllllllIllllIlIIlIIllIIllI.length() - 1) ? Character.valueOf(lllllllllllllIllllIlIIlIIllIIllI.charAt(lllllllllllllIllllIlIIlIIllIIlIl)) : null;
    }
    
    static {
        PATTERN_CONTROL_CODE = Pattern.compile("(?i)\\u00A7[0-9A-FK-OR]");
    }
    
    public static boolean isNullOrEmpty(@Nullable final String lllllllllllllIllllIlIIlIIlIIllll) {
        return org.apache.commons.lang3.StringUtils.isEmpty((CharSequence)lllllllllllllIllllIlIIlIIlIIllll);
    }
    
    public static String stripControlCodes(final String lllllllllllllIllllIlIIlIIlIlIIlI) {
        return StringUtils.PATTERN_CONTROL_CODE.matcher(lllllllllllllIllllIlIIlIIlIlIIlI).replaceAll("");
    }
    
    public static String replaceNull(final String lllllllllllllIllllIlIIlIIllIlIlI) {
        return (lllllllllllllIllllIlIIlIIllIlIlI == null) ? "" : String.valueOf(new StringBuilder(String.valueOf(lllllllllllllIllllIlIIlIIllIlIlI)).append(" "));
    }
}
