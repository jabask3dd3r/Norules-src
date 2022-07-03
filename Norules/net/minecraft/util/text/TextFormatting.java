package net.minecraft.util.text;

import java.util.regex.*;
import javax.annotation.*;
import com.google.common.collect.*;
import java.util.*;

public enum TextFormatting
{
    RED("RED", 12, "RED", 'c', 12);
    
    private static final /* synthetic */ Map<String, TextFormatting> NAME_MAPPING;
    
    STRIKETHROUGH("STRIKETHROUGH", 18, "STRIKETHROUGH", 'm', true), 
    BLUE("BLUE", 9, "BLUE", '9', 9), 
    GRAY("GRAY", 7, "GRAY", '7', 7), 
    GREEN("GREEN", 10, "GREEN", 'a', 10), 
    DARK_BLUE("DARK_BLUE", 1, "DARK_BLUE", '1', 1), 
    GOLD("GOLD", 6, "GOLD", '6', 6), 
    ITALIC("ITALIC", 20, "ITALIC", 'o', true), 
    BOLD("BOLD", 17, "BOLD", 'l', true), 
    YELLOW("YELLOW", 14, "YELLOW", 'e', 14), 
    DARK_GRAY("DARK_GRAY", 8, "DARK_GRAY", '8', 8), 
    DARK_AQUA("DARK_AQUA", 3, "DARK_AQUA", '3', 3);
    
    private static final /* synthetic */ Pattern FORMATTING_CODE_PATTERN;
    
    UNDERLINE("UNDERLINE", 19, "UNDERLINE", 'n', true), 
    LIGHT_PURPLE("LIGHT_PURPLE", 13, "LIGHT_PURPLE", 'd', 13), 
    DARK_RED("DARK_RED", 4, "DARK_RED", '4', 4), 
    RESET("RESET", 21, "RESET", 'r', -1), 
    AQUA("AQUA", 11, "AQUA", 'b', 11), 
    WHITE("WHITE", 15, "WHITE", 'f', 15), 
    OBFUSCATED("OBFUSCATED", 16, "OBFUSCATED", 'k', true), 
    DARK_PURPLE("DARK_PURPLE", 5, "DARK_PURPLE", '5', 5);
    
    private final /* synthetic */ String controlString;
    
    BLACK("BLACK", 0, "BLACK", '0', 0), 
    DARK_GREEN("DARK_GREEN", 2, "DARK_GREEN", '2', 2);
    
    private final /* synthetic */ boolean fancyStyling;
    private final /* synthetic */ String name;
    private final /* synthetic */ int colorIndex;
    private final /* synthetic */ char formattingCode;
    
    @Nullable
    public static TextFormatting fromColorIndex(final int lIlIlIIIIll) {
        if (lIlIlIIIIll < 0) {
            return TextFormatting.RESET;
        }
        final int lIlIIllllIl;
        final char lIlIIlllllI = (char)((TextFormatting[])(Object)(lIlIIllllIl = (int)(Object)values())).length;
        for (double lIlIIllllll = 0; lIlIIllllll < lIlIIlllllI; ++lIlIIllllll) {
            final TextFormatting lIlIlIIIIlI = lIlIIllllIl[lIlIIllllll];
            if (lIlIlIIIIlI.getColorIndex() == lIlIlIIIIll) {
                return lIlIlIIIIlI;
            }
        }
        return null;
    }
    
    private static String lowercaseAlpha(final String lIllIIlIIIl) {
        return lIllIIlIIIl.toLowerCase(Locale.ROOT).replaceAll("[^a-z]", "");
    }
    
    public int getColorIndex() {
        return this.colorIndex;
    }
    
    private TextFormatting(final String lIlIllIIIll, final int lIlIllIIIlI, final String lIlIllIIIIl, final char lIlIllIIIII, final boolean lIlIllIIllI, final int lIlIlIllllI) {
        this.name = lIlIllIIIIl;
        this.formattingCode = lIlIllIIIII;
        this.fancyStyling = lIlIllIIllI;
        this.colorIndex = lIlIlIllllI;
        this.controlString = String.valueOf(new StringBuilder("§").append(lIlIllIIIII));
    }
    
    private TextFormatting(final String lIllIIIIlIl, final int lIllIIIIlII, final String lIllIIIlIIl, final char lIllIIIlIII, final int lIllIIIIlll) {
        this(lIllIIIIlIl, lIllIIIIlII, lIllIIIlIIl, lIllIIIlIII, false, lIllIIIIlll);
    }
    
    @Nullable
    public static String getTextWithoutFormattingCodes(@Nullable final String lIlIlIIllIl) {
        return (lIlIlIIllIl == null) ? null : TextFormatting.FORMATTING_CODE_PATTERN.matcher(lIlIlIIllIl).replaceAll("");
    }
    
    public boolean isFancyStyling() {
        return this.fancyStyling;
    }
    
    public String getFriendlyName() {
        return this.name().toLowerCase(Locale.ROOT);
    }
    
    static {
        NAME_MAPPING = Maps.newHashMap();
        FORMATTING_CODE_PATTERN = Pattern.compile("(?i)§[0-9A-FK-OR]");
        final double lIllIIlIlII;
        final double lIllIIlIlIl = ((TextFormatting[])(Object)(lIllIIlIlII = (double)(Object)values())).length;
        for (long lIllIIlIllI = 0; lIllIIlIllI < lIllIIlIlIl; ++lIllIIlIllI) {
            final TextFormatting lIllIIllIII = lIllIIlIlII[lIllIIlIllI];
            TextFormatting.NAME_MAPPING.put(lowercaseAlpha(lIllIIllIII.name), lIllIIllIII);
        }
    }
    
    @Nullable
    public static TextFormatting getValueByName(@Nullable final String lIlIlIIlIlI) {
        return (lIlIlIIlIlI == null) ? null : TextFormatting.NAME_MAPPING.get(lowercaseAlpha(lIlIlIIlIlI));
    }
    
    private TextFormatting(final String lIlIlllIlIl, final int lIlIlllIlII, final String lIlIllllIIl, final char lIlIllllIII, final boolean lIlIlllIlll) {
        this(lIlIlllIlIl, lIlIlllIlII, lIlIllllIIl, lIlIllllIII, lIlIlllIlll, -1);
    }
    
    public boolean isColor() {
        return !this.fancyStyling && this != TextFormatting.RESET;
    }
    
    public static Collection<String> getValidValues(final boolean lIlIIllIlIl, final boolean lIlIIllIIII) {
        final List<String> lIlIIllIIll = (List<String>)Lists.newArrayList();
        final char lIlIIlIlIll;
        final float lIlIIlIllII = ((TextFormatting[])(Object)(lIlIIlIlIll = (char)(Object)values())).length;
        for (char lIlIIlIllIl = '\0'; lIlIIlIllIl < lIlIIlIllII; ++lIlIIlIllIl) {
            final TextFormatting lIlIIllIIlI = lIlIIlIlIll[lIlIIlIllIl];
            if ((!lIlIIllIIlI.isColor() || lIlIIllIlIl) && (!lIlIIllIIlI.isFancyStyling() || lIlIIllIIII)) {
                lIlIIllIIll.add(lIlIIllIIlI.getFriendlyName());
            }
        }
        return lIlIIllIIll;
    }
    
    @Override
    public String toString() {
        return this.controlString;
    }
}
