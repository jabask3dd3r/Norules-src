package net.minecraft.item;

import net.minecraft.world.*;
import net.minecraft.entity.player.*;
import net.minecraft.init.*;
import net.minecraft.potion.*;
import net.minecraft.creativetab.*;
import net.minecraft.util.*;

public class ItemAppleGold extends ItemFood
{
    @Override
    protected void onFoodEaten(final ItemStack llllllllllllllIIlllIIIlIIIlllIII, final World llllllllllllllIIlllIIIlIIIllIlll, final EntityPlayer llllllllllllllIIlllIIIlIIIllIllI) {
        if (!llllllllllllllIIlllIIIlIIIllIlll.isRemote) {
            if (llllllllllllllIIlllIIIlIIIlllIII.getMetadata() > 0) {
                llllllllllllllIIlllIIIlIIIllIllI.addPotionEffect(new PotionEffect(MobEffects.REGENERATION, 400, 1));
                llllllllllllllIIlllIIIlIIIllIllI.addPotionEffect(new PotionEffect(MobEffects.RESISTANCE, 6000, 0));
                llllllllllllllIIlllIIIlIIIllIllI.addPotionEffect(new PotionEffect(MobEffects.FIRE_RESISTANCE, 6000, 0));
                llllllllllllllIIlllIIIlIIIllIllI.addPotionEffect(new PotionEffect(MobEffects.ABSORPTION, 2400, 3));
            }
            else {
                llllllllllllllIIlllIIIlIIIllIllI.addPotionEffect(new PotionEffect(MobEffects.REGENERATION, 100, 1));
                llllllllllllllIIlllIIIlIIIllIllI.addPotionEffect(new PotionEffect(MobEffects.ABSORPTION, 2400, 0));
            }
        }
    }
    
    @Override
    public boolean hasEffect(final ItemStack llllllllllllllIIlllIIIlIIlIIIIll) {
        return super.hasEffect(llllllllllllllIIlllIIIlIIlIIIIll) || llllllllllllllIIlllIIIlIIlIIIIll.getMetadata() > 0;
    }
    
    @Override
    public EnumRarity getRarity(final ItemStack llllllllllllllIIlllIIIlIIIllllIl) {
        return (llllllllllllllIIlllIIIlIIIllllIl.getMetadata() == 0) ? EnumRarity.RARE : EnumRarity.EPIC;
    }
    
    public ItemAppleGold(final int llllllllllllllIIlllIIIlIIlIIlIIl, final float llllllllllllllIIlllIIIlIIlIIlIII, final boolean llllllllllllllIIlllIIIlIIlIIIlll) {
        super(llllllllllllllIIlllIIIlIIlIIlIIl, llllllllllllllIIlllIIIlIIlIIlIII, llllllllllllllIIlllIIIlIIlIIIlll);
        this.setHasSubtypes(true);
    }
    
    @Override
    public void getSubItems(final CreativeTabs llllllllllllllIIlllIIIlIIIlIlIll, final NonNullList<ItemStack> llllllllllllllIIlllIIIlIIIlIllIl) {
        if (this.func_194125_a(llllllllllllllIIlllIIIlIIIlIlIll)) {
            llllllllllllllIIlllIIIlIIIlIllIl.add(new ItemStack(this));
            llllllllllllllIIlllIIIlIIIlIllIl.add(new ItemStack(this, 1, 1));
        }
    }
}
