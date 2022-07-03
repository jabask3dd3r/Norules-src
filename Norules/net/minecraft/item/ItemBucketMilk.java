package net.minecraft.item;

import net.minecraft.world.*;
import net.minecraft.util.*;
import net.minecraft.creativetab.*;
import net.minecraft.entity.*;
import net.minecraft.entity.player.*;
import net.minecraft.advancements.*;
import net.minecraft.stats.*;
import net.minecraft.init.*;

public class ItemBucketMilk extends Item
{
    @Override
    public ActionResult<ItemStack> onItemRightClick(final World lllllllllllllIIIIlIIIIIIIllllIIl, final EntityPlayer lllllllllllllIIIIlIIIIIIIlllIllI, final EnumHand lllllllllllllIIIIlIIIIIIIlllIlIl) {
        lllllllllllllIIIIlIIIIIIIlllIllI.setActiveHand(lllllllllllllIIIIlIIIIIIIlllIlIl);
        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, lllllllllllllIIIIlIIIIIIIlllIllI.getHeldItem(lllllllllllllIIIIlIIIIIIIlllIlIl));
    }
    
    public ItemBucketMilk() {
        this.setMaxStackSize(1);
        this.setCreativeTab(CreativeTabs.MISC);
    }
    
    @Override
    public EnumAction getItemUseAction(final ItemStack lllllllllllllIIIIlIIIIIIIlllllIl) {
        return EnumAction.DRINK;
    }
    
    @Override
    public ItemStack onItemUseFinish(final ItemStack lllllllllllllIIIIlIIIIIIlIIIlIIl, final World lllllllllllllIIIIlIIIIIIlIIIIIll, final EntityLivingBase lllllllllllllIIIIlIIIIIIlIIIIlll) {
        if (lllllllllllllIIIIlIIIIIIlIIIIlll instanceof EntityPlayerMP) {
            final EntityPlayerMP lllllllllllllIIIIlIIIIIIlIIIIllI = (EntityPlayerMP)lllllllllllllIIIIlIIIIIIlIIIIlll;
            CriteriaTriggers.field_193138_y.func_193148_a(lllllllllllllIIIIlIIIIIIlIIIIllI, lllllllllllllIIIIlIIIIIIlIIIlIIl);
            lllllllllllllIIIIlIIIIIIlIIIIllI.addStat(StatList.getObjectUseStats(this));
        }
        if (lllllllllllllIIIIlIIIIIIlIIIIlll instanceof EntityPlayer && !((EntityPlayer)lllllllllllllIIIIlIIIIIIlIIIIlll).capabilities.isCreativeMode) {
            lllllllllllllIIIIlIIIIIIlIIIlIIl.func_190918_g(1);
        }
        if (!lllllllllllllIIIIlIIIIIIlIIIIIll.isRemote) {
            lllllllllllllIIIIlIIIIIIlIIIIlll.clearActivePotions();
        }
        return lllllllllllllIIIIlIIIIIIlIIIlIIl.func_190926_b() ? new ItemStack(Items.BUCKET) : lllllllllllllIIIIlIIIIIIlIIIlIIl;
    }
    
    @Override
    public int getMaxItemUseDuration(final ItemStack lllllllllllllIIIIlIIIIIIIlllllll) {
        return 32;
    }
}
