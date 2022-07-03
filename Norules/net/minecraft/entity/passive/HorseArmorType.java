package net.minecraft.entity.passive;

import javax.annotation.*;
import net.minecraft.init.*;
import net.minecraft.item.*;

public enum HorseArmorType
{
    IRON("IRON", 1, 5, "iron", "meo"), 
    GOLD("GOLD", 2, 7, "gold", "goo");
    
    private final /* synthetic */ int protection;
    
    DIAMOND("DIAMOND", 3, 11, "diamond", "dio");
    
    private final /* synthetic */ String textureName;
    
    NONE("NONE", 0, 0);
    
    private final /* synthetic */ String hash;
    
    public int getOrdinal() {
        return this.ordinal();
    }
    
    @Nullable
    public String getTextureName() {
        return this.textureName;
    }
    
    public static HorseArmorType getByItem(final Item lllllllllllllllIIllllIlIlIllIlII) {
        if (lllllllllllllllIIllllIlIlIllIlII == Items.IRON_HORSE_ARMOR) {
            return HorseArmorType.IRON;
        }
        if (lllllllllllllllIIllllIlIlIllIlII == Items.GOLDEN_HORSE_ARMOR) {
            return HorseArmorType.GOLD;
        }
        return (lllllllllllllllIIllllIlIlIllIlII == Items.DIAMOND_HORSE_ARMOR) ? HorseArmorType.DIAMOND : HorseArmorType.NONE;
    }
    
    private HorseArmorType(final String lllllllllllllllIIllllIlIllIllIlI, final int lllllllllllllllIIllllIlIllIllIIl, final int lllllllllllllllIIllllIlIllIllIII) {
        this.protection = lllllllllllllllIIllllIlIllIllIII;
        this.textureName = null;
        this.hash = "";
    }
    
    public static boolean isHorseArmor(final Item lllllllllllllllIIllllIlIlIllIIIl) {
        return getByItem(lllllllllllllllIIllllIlIlIllIIIl) != HorseArmorType.NONE;
    }
    
    public int getProtection() {
        return this.protection;
    }
    
    public static HorseArmorType getByOrdinal(final int lllllllllllllllIIllllIlIlIlllIIl) {
        return values()[lllllllllllllllIIllllIlIlIlllIIl];
    }
    
    public static HorseArmorType getByItemStack(final ItemStack lllllllllllllllIIllllIlIlIllIllI) {
        return lllllllllllllllIIllllIlIlIllIllI.func_190926_b() ? HorseArmorType.NONE : getByItem(lllllllllllllllIIllllIlIlIllIllI.getItem());
    }
    
    public String getHash() {
        return this.hash;
    }
    
    private HorseArmorType(final String lllllllllllllllIIllllIlIllIIllII, final int lllllllllllllllIIllllIlIllIIlIll, final int lllllllllllllllIIllllIlIllIlIIII, final String lllllllllllllllIIllllIlIllIIllll, final String lllllllllllllllIIllllIlIllIIlIII) {
        this.protection = lllllllllllllllIIllllIlIllIlIIII;
        this.textureName = String.valueOf(new StringBuilder("textures/entity/horse/armor/horse_armor_").append(lllllllllllllllIIllllIlIllIIllll).append(".png"));
        this.hash = lllllllllllllllIIllllIlIllIIlIII;
    }
}
