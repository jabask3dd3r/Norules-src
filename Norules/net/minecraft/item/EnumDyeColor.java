package net.minecraft.item;

import net.minecraft.util.*;
import net.minecraft.util.text.*;

public enum EnumDyeColor implements IStringSerializable
{
    private final /* synthetic */ TextFormatting chatColor;
    
    RED("RED", 14, 14, 1, "red", "red", 11546150, TextFormatting.DARK_RED);
    
    private final /* synthetic */ int field_193351_w;
    
    LIGHT_BLUE("LIGHT_BLUE", 3, 3, 12, "light_blue", "lightBlue", 3847130, TextFormatting.BLUE);
    
    private final /* synthetic */ float[] field_193352_x;
    
    BROWN("BROWN", 12, 12, 3, "brown", "brown", 8606770, TextFormatting.GOLD), 
    PINK("PINK", 6, 6, 9, "pink", "pink", 15961002, TextFormatting.LIGHT_PURPLE);
    
    private final /* synthetic */ String name;
    
    PURPLE("PURPLE", 10, 10, 5, "purple", "purple", 8991416, TextFormatting.DARK_PURPLE), 
    SILVER("SILVER", 8, 8, 7, "silver", "silver", 10329495, TextFormatting.GRAY), 
    CYAN("CYAN", 9, 9, 6, "cyan", "cyan", 1481884, TextFormatting.DARK_AQUA), 
    BLACK("BLACK", 15, 15, 0, "black", "black", 1908001, TextFormatting.BLACK), 
    LIME("LIME", 5, 5, 10, "lime", "lime", 8439583, TextFormatting.GREEN);
    
    private static final /* synthetic */ EnumDyeColor[] META_LOOKUP;
    
    WHITE("WHITE", 0, 0, 15, "white", "white", 16383998, TextFormatting.WHITE), 
    GREEN("GREEN", 13, 13, 2, "green", "green", 6192150, TextFormatting.DARK_GREEN), 
    MAGENTA("MAGENTA", 2, 2, 13, "magenta", "magenta", 13061821, TextFormatting.AQUA), 
    YELLOW("YELLOW", 4, 4, 11, "yellow", "yellow", 16701501, TextFormatting.YELLOW);
    
    private final /* synthetic */ int meta;
    private final /* synthetic */ String unlocalizedName;
    
    ORANGE("ORANGE", 1, 1, 14, "orange", "orange", 16351261, TextFormatting.GOLD), 
    BLUE("BLUE", 11, 11, 4, "blue", "blue", 3949738, TextFormatting.DARK_BLUE);
    
    private static final /* synthetic */ EnumDyeColor[] DYE_DMG_LOOKUP;
    private final /* synthetic */ int dyeDamage;
    
    GRAY("GRAY", 7, 7, 8, "gray", "gray", 4673362, TextFormatting.DARK_GRAY);
    
    public int getMetadata() {
        return this.meta;
    }
    
    private EnumDyeColor(final String lllllllllllllIIllIIIlIlIlIIIlIII, final int lllllllllllllIIllIIIlIlIlIIIIlll, final int lllllllllllllIIllIIIlIlIlIIIIllI, final int lllllllllllllIIllIIIlIlIlIIIIlIl, final String lllllllllllllIIllIIIlIlIlIIIIlII, final String lllllllllllllIIllIIIlIlIlIIIllll, final int lllllllllllllIIllIIIlIlIlIIIIIlI, final TextFormatting lllllllllllllIIllIIIlIlIlIIIllIl) {
        this.meta = lllllllllllllIIllIIIlIlIlIIIIllI;
        this.dyeDamage = lllllllllllllIIllIIIlIlIlIIIIlIl;
        this.name = lllllllllllllIIllIIIlIlIlIIIIlII;
        this.unlocalizedName = lllllllllllllIIllIIIlIlIlIIIllll;
        this.field_193351_w = lllllllllllllIIllIIIlIlIlIIIIIlI;
        this.chatColor = lllllllllllllIIllIIIlIlIlIIIllIl;
        final int lllllllllllllIIllIIIlIlIlIIIllII = (lllllllllllllIIllIIIlIlIlIIIIIlI & 0xFF0000) >> 16;
        final int lllllllllllllIIllIIIlIlIlIIIlIll = (lllllllllllllIIllIIIlIlIlIIIIIlI & 0xFF00) >> 8;
        final int lllllllllllllIIllIIIlIlIlIIIlIlI = (lllllllllllllIIllIIIlIlIlIIIIIlI & 0xFF) >> 0;
        this.field_193352_x = new float[] { lllllllllllllIIllIIIlIlIlIIIllII / 255.0f, lllllllllllllIIllIIIlIlIlIIIlIll / 255.0f, lllllllllllllIIllIIIlIlIlIIIlIlI / 255.0f };
    }
    
    public static EnumDyeColor byDyeDamage(int lllllllllllllIIllIIIlIlIIllIlIlI) {
        if (lllllllllllllIIllIIIlIlIIllIlIlI < 0 || lllllllllllllIIllIIIlIlIIllIlIlI >= EnumDyeColor.DYE_DMG_LOOKUP.length) {
            lllllllllllllIIllIIIlIlIIllIlIlI = 0;
        }
        return EnumDyeColor.DYE_DMG_LOOKUP[lllllllllllllIIllIIIlIlIIllIlIlI];
    }
    
    public float[] func_193349_f() {
        return this.field_193352_x;
    }
    
    public String getUnlocalizedName() {
        return this.unlocalizedName;
    }
    
    static {
        META_LOOKUP = new EnumDyeColor[values().length];
        DYE_DMG_LOOKUP = new EnumDyeColor[values().length];
        final int lllllllllllllIIllIIIlIlIlIlIIIII;
        final short lllllllllllllIIllIIIlIlIlIlIIIIl = (short)((EnumDyeColor[])(Object)(lllllllllllllIIllIIIlIlIlIlIIIII = (int)(Object)values())).length;
        for (char lllllllllllllIIllIIIlIlIlIlIIIlI = '\0'; lllllllllllllIIllIIIlIlIlIlIIIlI < lllllllllllllIIllIIIlIlIlIlIIIIl; ++lllllllllllllIIllIIIlIlIlIlIIIlI) {
            final EnumDyeColor lllllllllllllIIllIIIlIlIlIlIIlII = lllllllllllllIIllIIIlIlIlIlIIIII[lllllllllllllIIllIIIlIlIlIlIIIlI];
            EnumDyeColor.META_LOOKUP[lllllllllllllIIllIIIlIlIlIlIIlII.getMetadata()] = lllllllllllllIIllIIIlIlIlIlIIlII;
            EnumDyeColor.DYE_DMG_LOOKUP[lllllllllllllIIllIIIlIlIlIlIIlII.getDyeDamage()] = lllllllllllllIIllIIIlIlIlIlIIlII;
        }
    }
    
    public static EnumDyeColor byMetadata(int lllllllllllllIIllIIIlIlIIllIIllI) {
        if (lllllllllllllIIllIIIlIlIIllIIllI < 0 || lllllllllllllIIllIIIlIlIIllIIllI >= EnumDyeColor.META_LOOKUP.length) {
            lllllllllllllIIllIIIlIlIIllIIllI = 0;
        }
        return EnumDyeColor.META_LOOKUP[lllllllllllllIIllIIIlIlIIllIIllI];
    }
    
    public String func_192396_c() {
        return this.name;
    }
    
    public int func_193350_e() {
        return this.field_193351_w;
    }
    
    public int getDyeDamage() {
        return this.dyeDamage;
    }
    
    @Override
    public String toString() {
        return this.unlocalizedName;
    }
    
    @Override
    public String getName() {
        return this.name;
    }
}
