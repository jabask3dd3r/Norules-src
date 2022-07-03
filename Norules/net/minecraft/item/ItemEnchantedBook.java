package net.minecraft.item;

import net.minecraft.world.*;
import javax.annotation.*;
import java.util.*;
import net.minecraft.client.util.*;
import net.minecraft.enchantment.*;
import net.minecraft.init.*;
import net.minecraft.nbt.*;
import net.minecraft.creativetab.*;
import net.minecraft.util.*;

public class ItemEnchantedBook extends Item
{
    @Override
    public void addInformation(final ItemStack llllllllllllllIIlIIIIIllIlIlIIlI, @Nullable final World llllllllllllllIIlIIIIIllIlIllIll, final List<String> llllllllllllllIIlIIIIIllIlIlIIII, final ITooltipFlag llllllllllllllIIlIIIIIllIlIIllll) {
        super.addInformation(llllllllllllllIIlIIIIIllIlIlIIlI, llllllllllllllIIlIIIIIllIlIllIll, llllllllllllllIIlIIIIIllIlIlIIII, llllllllllllllIIlIIIIIllIlIIllll);
        final NBTTagList llllllllllllllIIlIIIIIllIlIllIII = getEnchantments(llllllllllllllIIlIIIIIllIlIlIIlI);
        for (int llllllllllllllIIlIIIIIllIlIlIlll = 0; llllllllllllllIIlIIIIIllIlIlIlll < llllllllllllllIIlIIIIIllIlIllIII.tagCount(); ++llllllllllllllIIlIIIIIllIlIlIlll) {
            final NBTTagCompound llllllllllllllIIlIIIIIllIlIlIllI = llllllllllllllIIlIIIIIllIlIllIII.getCompoundTagAt(llllllllllllllIIlIIIIIllIlIlIlll);
            final int llllllllllllllIIlIIIIIllIlIlIlIl = llllllllllllllIIlIIIIIllIlIlIllI.getShort("id");
            final Enchantment llllllllllllllIIlIIIIIllIlIlIlII = Enchantment.getEnchantmentByID(llllllllllllllIIlIIIIIllIlIlIlIl);
            if (llllllllllllllIIlIIIIIllIlIlIlII != null) {
                llllllllllllllIIlIIIIIllIlIlIIII.add(llllllllllllllIIlIIIIIllIlIlIlII.getTranslatedName(llllllllllllllIIlIIIIIllIlIlIllI.getShort("lvl")));
            }
        }
    }
    
    public static NBTTagList getEnchantments(final ItemStack llllllllllllllIIlIIIIIllIllIlIll) {
        final NBTTagCompound llllllllllllllIIlIIIIIllIllIlIlI = llllllllllllllIIlIIIIIllIllIlIll.getTagCompound();
        return (llllllllllllllIIlIIIIIllIllIlIlI != null) ? llllllllllllllIIlIIIIIllIllIlIlI.getTagList("StoredEnchantments", 10) : new NBTTagList();
    }
    
    @Override
    public boolean hasEffect(final ItemStack llllllllllllllIIlIIIIIllIlllIllI) {
        return true;
    }
    
    public static ItemStack getEnchantedItemStack(final EnchantmentData llllllllllllllIIlIIIIIllIIllIIlI) {
        final ItemStack llllllllllllllIIlIIIIIllIIllIIll = new ItemStack(Items.ENCHANTED_BOOK);
        addEnchantment(llllllllllllllIIlIIIIIllIIllIIll, llllllllllllllIIlIIIIIllIIllIIlI);
        return llllllllllllllIIlIIIIIllIIllIIll;
    }
    
    public static void addEnchantment(final ItemStack llllllllllllllIIlIIIIIllIlIIIIll, final EnchantmentData llllllllllllllIIlIIIIIllIIlllIll) {
        final NBTTagList llllllllllllllIIlIIIIIllIlIIIIIl = getEnchantments(llllllllllllllIIlIIIIIllIlIIIIll);
        boolean llllllllllllllIIlIIIIIllIlIIIIII = true;
        for (int llllllllllllllIIlIIIIIllIIllllll = 0; llllllllllllllIIlIIIIIllIIllllll < llllllllllllllIIlIIIIIllIlIIIIIl.tagCount(); ++llllllllllllllIIlIIIIIllIIllllll) {
            final NBTTagCompound llllllllllllllIIlIIIIIllIIlllllI = llllllllllllllIIlIIIIIllIlIIIIIl.getCompoundTagAt(llllllllllllllIIlIIIIIllIIllllll);
            if (Enchantment.getEnchantmentByID(llllllllllllllIIlIIIIIllIIlllllI.getShort("id")) == llllllllllllllIIlIIIIIllIIlllIll.enchantmentobj) {
                if (llllllllllllllIIlIIIIIllIIlllllI.getShort("lvl") < llllllllllllllIIlIIIIIllIIlllIll.enchantmentLevel) {
                    llllllllllllllIIlIIIIIllIIlllllI.setShort("lvl", (short)llllllllllllllIIlIIIIIllIIlllIll.enchantmentLevel);
                }
                llllllllllllllIIlIIIIIllIlIIIIII = false;
                break;
            }
        }
        if (llllllllllllllIIlIIIIIllIlIIIIII) {
            final NBTTagCompound llllllllllllllIIlIIIIIllIIllllIl = new NBTTagCompound();
            llllllllllllllIIlIIIIIllIIllllIl.setShort("id", (short)Enchantment.getEnchantmentID(llllllllllllllIIlIIIIIllIIlllIll.enchantmentobj));
            llllllllllllllIIlIIIIIllIIllllIl.setShort("lvl", (short)llllllllllllllIIlIIIIIllIIlllIll.enchantmentLevel);
            llllllllllllllIIlIIIIIllIlIIIIIl.appendTag(llllllllllllllIIlIIIIIllIIllllIl);
        }
        if (!llllllllllllllIIlIIIIIllIlIIIIll.hasTagCompound()) {
            llllllllllllllIIlIIIIIllIlIIIIll.setTagCompound(new NBTTagCompound());
        }
        llllllllllllllIIlIIIIIllIlIIIIll.getTagCompound().setTag("StoredEnchantments", llllllllllllllIIlIIIIIllIlIIIIIl);
    }
    
    @Override
    public boolean isItemTool(final ItemStack llllllllllllllIIlIIIIIllIlllIlII) {
        return false;
    }
    
    @Override
    public EnumRarity getRarity(final ItemStack llllllllllllllIIlIIIIIllIllIlllI) {
        return getEnchantments(llllllllllllllIIlIIIIIllIllIlllI).hasNoTags() ? super.getRarity(llllllllllllllIIlIIIIIllIllIlllI) : EnumRarity.UNCOMMON;
    }
    
    @Override
    public void getSubItems(final CreativeTabs llllllllllllllIIlIIIIIllIIlIlIlI, final NonNullList<ItemStack> llllllllllllllIIlIIIIIllIIlIlIIl) {
        if (llllllllllllllIIlIIIIIllIIlIlIlI == CreativeTabs.SEARCH) {
            for (final Enchantment llllllllllllllIIlIIIIIllIIlIlIII : Enchantment.REGISTRY) {
                if (llllllllllllllIIlIIIIIllIIlIlIII.type != null) {
                    for (int llllllllllllllIIlIIIIIllIIlIIlll = llllllllllllllIIlIIIIIllIIlIlIII.getMinLevel(); llllllllllllllIIlIIIIIllIIlIIlll <= llllllllllllllIIlIIIIIllIIlIlIII.getMaxLevel(); ++llllllllllllllIIlIIIIIllIIlIIlll) {
                        llllllllllllllIIlIIIIIllIIlIlIIl.add(getEnchantedItemStack(new EnchantmentData(llllllllllllllIIlIIIIIllIIlIlIII, llllllllllllllIIlIIIIIllIIlIIlll)));
                    }
                }
            }
        }
        else if (llllllllllllllIIlIIIIIllIIlIlIlI.getRelevantEnchantmentTypes().length != 0) {
            for (final Enchantment llllllllllllllIIlIIIIIllIIlIIllI : Enchantment.REGISTRY) {
                if (llllllllllllllIIlIIIIIllIIlIlIlI.hasRelevantEnchantmentType(llllllllllllllIIlIIIIIllIIlIIllI.type)) {
                    llllllllllllllIIlIIIIIllIIlIlIIl.add(getEnchantedItemStack(new EnchantmentData(llllllllllllllIIlIIIIIllIIlIIllI, llllllllllllllIIlIIIIIllIIlIIllI.getMaxLevel())));
                }
            }
        }
    }
}
