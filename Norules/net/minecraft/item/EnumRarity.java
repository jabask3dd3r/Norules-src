package net.minecraft.item;

import net.minecraft.util.text.*;

public enum EnumRarity
{
    UNCOMMON("UNCOMMON", 1, TextFormatting.YELLOW, "Uncommon"), 
    COMMON("COMMON", 0, TextFormatting.WHITE, "Common"), 
    EPIC("EPIC", 3, TextFormatting.LIGHT_PURPLE, "Epic");
    
    public final /* synthetic */ String rarityName;
    
    RARE("RARE", 2, TextFormatting.AQUA, "Rare");
    
    public final /* synthetic */ TextFormatting rarityColor;
    
    private EnumRarity(final String lllllllllllllIIIlIIlIllIIIlIlIIl, final int lllllllllllllIIIlIIlIllIIIlIlIII, final TextFormatting lllllllllllllIIIlIIlIllIIIlIllII, final String lllllllllllllIIIlIIlIllIIIlIlIll) {
        this.rarityColor = lllllllllllllIIIlIIlIllIIIlIllII;
        this.rarityName = lllllllllllllIIIlIIlIllIIIlIlIll;
    }
}
