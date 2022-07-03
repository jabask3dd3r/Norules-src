package net.minecraft.item;

import net.minecraft.world.*;
import net.minecraft.entity.player.*;
import net.minecraft.init.*;
import net.minecraft.entity.item.*;
import net.minecraft.entity.*;
import net.minecraft.stats.*;
import net.minecraft.util.*;
import net.minecraft.creativetab.*;

public class ItemExpBottle extends Item
{
    @Override
    public boolean hasEffect(final ItemStack lllllllllllllIIlllIlIllIIIIlIllI) {
        return true;
    }
    
    @Override
    public ActionResult<ItemStack> onItemRightClick(final World lllllllllllllIIlllIlIllIIIIIlllI, final EntityPlayer lllllllllllllIIlllIlIllIIIIIIlll, final EnumHand lllllllllllllIIlllIlIllIIIIIIllI) {
        final ItemStack lllllllllllllIIlllIlIllIIIIIlIll = lllllllllllllIIlllIlIllIIIIIIlll.getHeldItem(lllllllllllllIIlllIlIllIIIIIIllI);
        if (!lllllllllllllIIlllIlIllIIIIIIlll.capabilities.isCreativeMode) {
            lllllllllllllIIlllIlIllIIIIIlIll.func_190918_g(1);
        }
        lllllllllllllIIlllIlIllIIIIIlllI.playSound(null, lllllllllllllIIlllIlIllIIIIIIlll.posX, lllllllllllllIIlllIlIllIIIIIIlll.posY, lllllllllllllIIlllIlIllIIIIIIlll.posZ, SoundEvents.ENTITY_EXPERIENCE_BOTTLE_THROW, SoundCategory.NEUTRAL, 0.5f, 0.4f / (ItemExpBottle.itemRand.nextFloat() * 0.4f + 0.8f));
        if (!lllllllllllllIIlllIlIllIIIIIlllI.isRemote) {
            final EntityExpBottle lllllllllllllIIlllIlIllIIIIIlIlI = new EntityExpBottle(lllllllllllllIIlllIlIllIIIIIlllI, lllllllllllllIIlllIlIllIIIIIIlll);
            lllllllllllllIIlllIlIllIIIIIlIlI.setHeadingFromThrower(lllllllllllllIIlllIlIllIIIIIIlll, lllllllllllllIIlllIlIllIIIIIIlll.rotationPitch, lllllllllllllIIlllIlIllIIIIIIlll.rotationYaw, -20.0f, 0.7f, 1.0f);
            lllllllllllllIIlllIlIllIIIIIlllI.spawnEntityInWorld(lllllllllllllIIlllIlIllIIIIIlIlI);
        }
        lllllllllllllIIlllIlIllIIIIIIlll.addStat(StatList.getObjectUseStats(this));
        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, lllllllllllllIIlllIlIllIIIIIlIll);
    }
    
    public ItemExpBottle() {
        this.setCreativeTab(CreativeTabs.MISC);
    }
}
