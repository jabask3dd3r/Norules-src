package com.viaversion.viaversion.protocols.protocol1_9to1_8;

import java.util.*;

public enum ArmorType
{
    LEATHER_BOOTS(1, 301, "minecraft:leather_boots"), 
    IRON_CHESTPLATE(6, 307, "minecraft:iron_chestplate"), 
    CHAINMAIL_HELMET(2, 302, "minecraft:chainmail_helmet"), 
    CHAINMAIL_LEGGINGS(4, 304, "minecraft:chainmail_leggings");
    
    private final /* synthetic */ int armorPoints;
    private final /* synthetic */ int id;
    
    IRON_BOOTS(2, 309, "minecraft:iron_boots"), 
    CHAINMAIL_CHESTPLATE(5, 303, "minecraft:chainmail_chestplate"), 
    IRON_HELMET(2, 306, "minecraft:iron_helmet"), 
    GOLD_LEGGINGS(3, 316, "minecraft:gold_leggings"), 
    DIAMOND_HELMET(3, 310, "minecraft:diamond_helmet"), 
    GOLD_CHESTPLATE(5, 315, "minecraft:gold_chestplate"), 
    LEATHER_HELMET(1, 298, "minecraft:leather_helmet");
    
    private static final /* synthetic */ Map<Integer, ArmorType> armor;
    
    NONE(0, 0, "none");
    
    private final /* synthetic */ String type;
    
    DIAMOND_CHESTPLATE(8, 311, "minecraft:diamond_chestplate"), 
    IRON_LEGGINGS(5, 308, "minecraft:iron_leggings"), 
    DIAMOND_LEGGINGS(6, 312, "minecraft:diamond_leggings"), 
    GOLD_BOOTS(1, 317, "minecraft:gold_boots"), 
    CHAINMAIL_BOOTS(1, 305, "minecraft:chainmail_boots"), 
    GOLD_HELMET(2, 314, "minecraft:gold_helmet"), 
    LEATHER_CHESTPLATE(3, 299, "minecraft:leather_chestplate"), 
    DIAMOND_BOOTS(3, 313, "minecraft:diamond_boots"), 
    LEATHER_LEGGINGS(2, 300, "minecraft:leather_leggings");
    
    public int getId() {
        return this.id;
    }
    
    public static ArmorType findById(final int lllllllllllllIlIlIllllIlllIIIIlI) {
        final ArmorType lllllllllllllIlIlIllllIlllIIIlII = ArmorType.armor.get(lllllllllllllIlIlIllllIlllIIIIlI);
        return (lllllllllllllIlIlIllllIlllIIIlII == null) ? ArmorType.NONE : lllllllllllllIlIlIllllIlllIIIlII;
    }
    
    private ArmorType(final int lllllllllllllIlIlIllllIllllIIllI, final int lllllllllllllIlIlIllllIllllIIlII, final String lllllllllllllIlIlIllllIlllIlllII) {
        this.armorPoints = lllllllllllllIlIlIllllIllllIIllI;
        this.id = lllllllllllllIlIlIllllIllllIIlII;
        this.type = lllllllllllllIlIlIllllIlllIlllII;
    }
    
    public int getArmorPoints() {
        return this.armorPoints;
    }
    
    public String getType() {
        return this.type;
    }
    
    public static ArmorType findByType(final String lllllllllllllIlIlIllllIllIllIIlI) {
        final float lllllllllllllIlIlIllllIllIllIIII = (Object)values();
        final byte lllllllllllllIlIlIllllIllIlIllll = (byte)lllllllllllllIlIlIllllIllIllIIII.length;
        for (short lllllllllllllIlIlIllllIllIlIlllI = 0; lllllllllllllIlIlIllllIllIlIlllI < lllllllllllllIlIlIllllIllIlIllll; ++lllllllllllllIlIlIllllIllIlIlllI) {
            final ArmorType lllllllllllllIlIlIllllIllIllIIll = lllllllllllllIlIlIllllIllIllIIII[lllllllllllllIlIlIllllIllIlIlllI];
            if (lllllllllllllIlIlIllllIllIllIIll.getType().equals(lllllllllllllIlIlIllllIllIllIIlI)) {
                return lllllllllllllIlIlIllllIllIllIIll;
            }
        }
        return ArmorType.NONE;
    }
    
    public static boolean isArmor(final String lllllllllllllIlIlIllllIllIIlIIll) {
        final short lllllllllllllIlIlIllllIllIIlIIII = (Object)values();
        final char lllllllllllllIlIlIllllIllIIIllll = (char)lllllllllllllIlIlIllllIllIIlIIII.length;
        for (final ArmorType lllllllllllllIlIlIllllIllIIlIlIl : lllllllllllllIlIlIllllIllIIlIIII) {
            if (lllllllllllllIlIlIllllIllIIlIlIl.getType().equals(lllllllllllllIlIlIllllIllIIlIIll)) {
                return true;
            }
        }
        return false;
    }
    
    static {
        armor = new HashMap<Integer, ArmorType>();
        final boolean lllllllllllllIlIlIllllIlIllIIlII = (Object)values();
        final double lllllllllllllIlIlIllllIlIllIIIll = lllllllllllllIlIlIllllIlIllIIlII.length;
        for (float lllllllllllllIlIlIllllIlIllIIIlI = 0; lllllllllllllIlIlIllllIlIllIIIlI < lllllllllllllIlIlIllllIlIllIIIll; ++lllllllllllllIlIlIllllIlIllIIIlI) {
            final ArmorType lllllllllllllIlIlIllllIlIllIIlIl = lllllllllllllIlIlIllllIlIllIIlII[lllllllllllllIlIlIllllIlIllIIIlI];
            ArmorType.armor.put(lllllllllllllIlIlIllllIlIllIIlIl.getId(), lllllllllllllIlIlIllllIlIllIIlIl);
        }
    }
    
    public static boolean isArmor(final int lllllllllllllIlIlIllllIllIlIlIlI) {
        return ArmorType.armor.containsKey(lllllllllllllIlIlIllllIllIlIlIlI);
    }
}
