package net.minecraft.enchantment;

import net.minecraft.inventory.*;
import net.minecraft.block.*;
import net.minecraft.item.*;

public enum EnumEnchantmentType
{
    ARMOR_CHEST(4) {
        @Override
        public boolean canEnchantItem(final Item lllllllllllllllIlIIlIIIIIlllIIlI) {
            return lllllllllllllllIlIIlIIIIIlllIIlI instanceof ItemArmor && ((ItemArmor)lllllllllllllllIlIIlIIIIIlllIIlI).armorType == EntityEquipmentSlot.CHEST;
        }
    }, 
    DIGGER(7) {
        @Override
        public boolean canEnchantItem(final Item llllllllllllllIIllIIlIlIlIlIlIlI) {
            return llllllllllllllIIllIIlIlIlIlIlIlI instanceof ItemTool;
        }
    }, 
    ARMOR_HEAD(5) {
        @Override
        public boolean canEnchantItem(final Item lllllllllllllIIIlIIllIIlIllIIIIl) {
            return lllllllllllllIIIlIIllIIlIllIIIIl instanceof ItemArmor && ((ItemArmor)lllllllllllllIIIlIIllIIlIllIIIIl).armorType == EntityEquipmentSlot.HEAD;
        }
    }, 
    ARMOR(1) {
        @Override
        public boolean canEnchantItem(final Item lllllllllllllIIlllIllIIIIIIlIlll) {
            return lllllllllllllIIlllIllIIIIIIlIlll instanceof ItemArmor;
        }
    }, 
    ARMOR_LEGS(3) {
        @Override
        public boolean canEnchantItem(final Item llllllllllllllIIIIlllllIIIIIIIIl) {
            return llllllllllllllIIIIlllllIIIIIIIIl instanceof ItemArmor && ((ItemArmor)llllllllllllllIIIIlllllIIIIIIIIl).armorType == EntityEquipmentSlot.LEGS;
        }
    }, 
    ARMOR_FEET(2) {
        @Override
        public boolean canEnchantItem(final Item lllllllllllllllIllIllIlllIIllIlI) {
            return lllllllllllllllIllIllIlllIIllIlI instanceof ItemArmor && ((ItemArmor)lllllllllllllllIllIllIlllIIllIlI).armorType == EntityEquipmentSlot.FEET;
        }
    }, 
    WEAPON(6) {
        @Override
        public boolean canEnchantItem(final Item llllllllllllllIllllIIIlIlllllIll) {
            return llllllllllllllIllllIIIlIlllllIll instanceof ItemSword;
        }
    }, 
    WEARABLE(11) {
        @Override
        public boolean canEnchantItem(final Item lllllllllllllIIlIIIIIIIllIIlIIII) {
            final boolean lllllllllllllIIlIIIIIIIllIIlIIIl = lllllllllllllIIlIIIIIIIllIIlIIII instanceof ItemBlock && ((ItemBlock)lllllllllllllIIlIIIIIIIllIIlIIII).getBlock() instanceof BlockPumpkin;
            return lllllllllllllIIlIIIIIIIllIIlIIII instanceof ItemArmor || lllllllllllllIIlIIIIIIIllIIlIIII instanceof ItemElytra || lllllllllllllIIlIIIIIIIllIIlIIII instanceof ItemSkull || lllllllllllllIIlIIIIIIIllIIlIIIl;
        }
    }, 
    BREAKABLE(9) {
        @Override
        public boolean canEnchantItem(final Item llllllllllllllllIllllIlIlIIIlllI) {
            return llllllllllllllllIllllIlIlIIIlllI.isDamageable();
        }
    }, 
    FISHING_ROD(8) {
        @Override
        public boolean canEnchantItem(final Item lllllllllllllIlIIIIlIllIIllIIIIl) {
            return lllllllllllllIlIIIIlIllIIllIIIIl instanceof ItemFishingRod;
        }
    }, 
    BOW(10) {
        @Override
        public boolean canEnchantItem(final Item llllllllllllllIlIlllllIllllIlIlI) {
            return llllllllllllllIlIlllllIllllIlIlI instanceof ItemBow;
        }
    }, 
    ALL(0) {
        @Override
        public boolean canEnchantItem(final Item lllllllllllllIlIIllIlIIllllIIIll) {
            final byte lllllllllllllIlIIllIlIIlllIlllIl;
            final float lllllllllllllIlIIllIlIIlllIllllI = ((EnumEnchantmentType[])(Object)(lllllllllllllIlIIllIlIIlllIlllIl = (byte)(Object)EnumEnchantmentType.values())).length;
            for (String lllllllllllllIlIIllIlIIlllIlllll = (String)0; lllllllllllllIlIIllIlIIlllIlllll < lllllllllllllIlIIllIlIIlllIllllI; ++lllllllllllllIlIIllIlIIlllIlllll) {
                final EnumEnchantmentType lllllllllllllIlIIllIlIIllllIIIlI = lllllllllllllIlIIllIlIIlllIlllIl[lllllllllllllIlIIllIlIIlllIlllll];
                if (lllllllllllllIlIIllIlIIllllIIIlI != EnumEnchantmentType.ALL && lllllllllllllIlIIllIlIIllllIIIlI.canEnchantItem(lllllllllllllIlIIllIlIIllllIIIll)) {
                    return true;
                }
            }
            return false;
        }
    };
    
    public abstract boolean canEnchantItem(final Item p0);
    
    private EnumEnchantmentType(final String llllllllllllllIIlIIllIIlllIIIIll, final int llllllllllllllIIlIIllIIlllIIIIlI) {
    }
}
