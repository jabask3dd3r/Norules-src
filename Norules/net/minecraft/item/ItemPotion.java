package net.minecraft.item;

import net.minecraft.creativetab.*;
import net.minecraft.world.*;
import javax.annotation.*;
import java.util.*;
import net.minecraft.client.util.*;
import net.minecraft.entity.player.*;
import net.minecraft.advancements.*;
import net.minecraft.entity.*;
import net.minecraft.stats.*;
import net.minecraft.util.text.translation.*;
import net.minecraft.util.*;
import net.minecraft.potion.*;
import net.minecraft.init.*;

public class ItemPotion extends Item
{
    public ItemPotion() {
        this.setMaxStackSize(1);
        this.setCreativeTab(CreativeTabs.BREWING);
    }
    
    @Override
    public void addInformation(final ItemStack llllllllllllIllllllIIIlIIlIIIlll, @Nullable final World llllllllllllIllllllIIIlIIlIIlIlI, final List<String> llllllllllllIllllllIIIlIIlIIlIIl, final ITooltipFlag llllllllllllIllllllIIIlIIlIIlIII) {
        PotionUtils.addPotionTooltip(llllllllllllIllllllIIIlIIlIIIlll, llllllllllllIllllllIIIlIIlIIlIIl, 1.0f);
    }
    
    @Override
    public ActionResult<ItemStack> onItemRightClick(final World llllllllllllIllllllIIIlIIlIlIlll, final EntityPlayer llllllllllllIllllllIIIlIIlIlIllI, final EnumHand llllllllllllIllllllIIIlIIlIlIlIl) {
        llllllllllllIllllllIIIlIIlIlIllI.setActiveHand(llllllllllllIllllllIIIlIIlIlIlIl);
        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, llllllllllllIllllllIIIlIIlIlIllI.getHeldItem(llllllllllllIllllllIIIlIIlIlIlIl));
    }
    
    @Override
    public ItemStack onItemUseFinish(final ItemStack llllllllllllIllllllIIIlIIllIlIlI, final World llllllllllllIllllllIIIlIIllIlIIl, final EntityLivingBase llllllllllllIllllllIIIlIIllIIIlI) {
        final EntityPlayer llllllllllllIllllllIIIlIIllIIlll = (llllllllllllIllllllIIIlIIllIIIlI instanceof EntityPlayer) ? ((EntityPlayer)llllllllllllIllllllIIIlIIllIIIlI) : null;
        if (llllllllllllIllllllIIIlIIllIIlll == null || !llllllllllllIllllllIIIlIIllIIlll.capabilities.isCreativeMode) {
            llllllllllllIllllllIIIlIIllIlIlI.func_190918_g(1);
        }
        if (llllllllllllIllllllIIIlIIllIIlll instanceof EntityPlayerMP) {
            CriteriaTriggers.field_193138_y.func_193148_a((EntityPlayerMP)llllllllllllIllllllIIIlIIllIIlll, llllllllllllIllllllIIIlIIllIlIlI);
        }
        if (!llllllllllllIllllllIIIlIIllIlIIl.isRemote) {
            for (final PotionEffect llllllllllllIllllllIIIlIIllIIllI : PotionUtils.getEffectsFromStack(llllllllllllIllllllIIIlIIllIlIlI)) {
                if (llllllllllllIllllllIIIlIIllIIllI.getPotion().isInstant()) {
                    llllllllllllIllllllIIIlIIllIIllI.getPotion().affectEntity(llllllllllllIllllllIIIlIIllIIlll, llllllllllllIllllllIIIlIIllIIlll, llllllllllllIllllllIIIlIIllIIIlI, llllllllllllIllllllIIIlIIllIIllI.getAmplifier(), 1.0);
                }
                else {
                    llllllllllllIllllllIIIlIIllIIIlI.addPotionEffect(new PotionEffect(llllllllllllIllllllIIIlIIllIIllI));
                }
            }
        }
        if (llllllllllllIllllllIIIlIIllIIlll != null) {
            llllllllllllIllllllIIIlIIllIIlll.addStat(StatList.getObjectUseStats(this));
        }
        if (llllllllllllIllllllIIIlIIllIIlll == null || !llllllllllllIllllllIIIlIIllIIlll.capabilities.isCreativeMode) {
            if (llllllllllllIllllllIIIlIIllIlIlI.func_190926_b()) {
                return new ItemStack(Items.GLASS_BOTTLE);
            }
            if (llllllllllllIllllllIIIlIIllIIlll != null) {
                llllllllllllIllllllIIIlIIllIIlll.inventory.addItemStackToInventory(new ItemStack(Items.GLASS_BOTTLE));
            }
        }
        return llllllllllllIllllllIIIlIIllIlIlI;
    }
    
    @Override
    public EnumAction getItemUseAction(final ItemStack llllllllllllIllllllIIIlIIlIllIll) {
        return EnumAction.DRINK;
    }
    
    @Override
    public String getItemStackDisplayName(final ItemStack llllllllllllIllllllIIIlIIlIIllll) {
        return I18n.translateToLocal(PotionUtils.getPotionFromItem(llllllllllllIllllllIIIlIIlIIllll).getNamePrefixed("potion.effect."));
    }
    
    @Override
    public int getMaxItemUseDuration(final ItemStack llllllllllllIllllllIIIlIIlIlllIl) {
        return 32;
    }
    
    @Override
    public void getSubItems(final CreativeTabs llllllllllllIllllllIIIlIIIllIlIl, final NonNullList<ItemStack> llllllllllllIllllllIIIlIIIlllIII) {
        if (this.func_194125_a(llllllllllllIllllllIIIlIIIllIlIl)) {
            for (final PotionType llllllllllllIllllllIIIlIIIllIlll : PotionType.REGISTRY) {
                if (llllllllllllIllllllIIIlIIIllIlll != PotionTypes.EMPTY) {
                    llllllllllllIllllllIIIlIIIlllIII.add(PotionUtils.addPotionToItemStack(new ItemStack(this), llllllllllllIllllllIIIlIIIllIlll));
                }
            }
        }
    }
    
    @Override
    public ItemStack func_190903_i() {
        return PotionUtils.addPotionToItemStack(super.func_190903_i(), PotionTypes.WATER);
    }
    
    @Override
    public boolean hasEffect(final ItemStack llllllllllllIllllllIIIlIIlIIIIII) {
        return super.hasEffect(llllllllllllIllllllIIIlIIlIIIIII) || !PotionUtils.getEffectsFromStack(llllllllllllIllllllIIIlIIlIIIIII).isEmpty();
    }
}
