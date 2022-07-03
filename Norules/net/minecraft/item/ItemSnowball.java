package net.minecraft.item;

import net.minecraft.creativetab.*;
import net.minecraft.world.*;
import net.minecraft.entity.player.*;
import net.minecraft.init.*;
import net.minecraft.entity.projectile.*;
import net.minecraft.entity.*;
import net.minecraft.stats.*;
import net.minecraft.util.*;

public class ItemSnowball extends Item
{
    public ItemSnowball() {
        this.maxStackSize = 16;
        this.setCreativeTab(CreativeTabs.MISC);
    }
    
    @Override
    public ActionResult<ItemStack> onItemRightClick(final World llllllllllllllIIIIlIlIllIllIIIII, final EntityPlayer llllllllllllllIIIIlIlIllIllIIlIl, final EnumHand llllllllllllllIIIIlIlIllIlIllllI) {
        final ItemStack llllllllllllllIIIIlIlIllIllIIIll = llllllllllllllIIIIlIlIllIllIIlIl.getHeldItem(llllllllllllllIIIIlIlIllIlIllllI);
        if (!llllllllllllllIIIIlIlIllIllIIlIl.capabilities.isCreativeMode) {
            llllllllllllllIIIIlIlIllIllIIIll.func_190918_g(1);
        }
        llllllllllllllIIIIlIlIllIllIIIII.playSound(null, llllllllllllllIIIIlIlIllIllIIlIl.posX, llllllllllllllIIIIlIlIllIllIIlIl.posY, llllllllllllllIIIIlIlIllIllIIlIl.posZ, SoundEvents.ENTITY_SNOWBALL_THROW, SoundCategory.NEUTRAL, 0.5f, 0.4f / (ItemSnowball.itemRand.nextFloat() * 0.4f + 0.8f));
        if (!llllllllllllllIIIIlIlIllIllIIIII.isRemote) {
            final EntitySnowball llllllllllllllIIIIlIlIllIllIIIlI = new EntitySnowball(llllllllllllllIIIIlIlIllIllIIIII, llllllllllllllIIIIlIlIllIllIIlIl);
            llllllllllllllIIIIlIlIllIllIIIlI.setHeadingFromThrower(llllllllllllllIIIIlIlIllIllIIlIl, llllllllllllllIIIIlIlIllIllIIlIl.rotationPitch, llllllllllllllIIIIlIlIllIllIIlIl.rotationYaw, 0.0f, 1.5f, 1.0f);
            llllllllllllllIIIIlIlIllIllIIIII.spawnEntityInWorld(llllllllllllllIIIIlIlIllIllIIIlI);
        }
        llllllllllllllIIIIlIlIllIllIIlIl.addStat(StatList.getObjectUseStats(this));
        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, llllllllllllllIIIIlIlIllIllIIIll);
    }
}
