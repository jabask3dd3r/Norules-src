package net.minecraft.item;

import net.minecraft.world.*;
import net.minecraft.entity.player.*;
import net.minecraft.init.*;
import net.minecraft.entity.projectile.*;
import net.minecraft.entity.*;
import net.minecraft.stats.*;
import net.minecraft.util.*;
import net.minecraft.creativetab.*;

public class ItemEgg extends Item
{
    @Override
    public ActionResult<ItemStack> onItemRightClick(final World lllllllllllllIIIIllIlIIlIlIIIIll, final EntityPlayer lllllllllllllIIIIllIlIIlIlIIlIII, final EnumHand lllllllllllllIIIIllIlIIlIlIIIlll) {
        final ItemStack lllllllllllllIIIIllIlIIlIlIIIllI = lllllllllllllIIIIllIlIIlIlIIlIII.getHeldItem(lllllllllllllIIIIllIlIIlIlIIIlll);
        if (!lllllllllllllIIIIllIlIIlIlIIlIII.capabilities.isCreativeMode) {
            lllllllllllllIIIIllIlIIlIlIIIllI.func_190918_g(1);
        }
        lllllllllllllIIIIllIlIIlIlIIIIll.playSound(null, lllllllllllllIIIIllIlIIlIlIIlIII.posX, lllllllllllllIIIIllIlIIlIlIIlIII.posY, lllllllllllllIIIIllIlIIlIlIIlIII.posZ, SoundEvents.ENTITY_EGG_THROW, SoundCategory.PLAYERS, 0.5f, 0.4f / (ItemEgg.itemRand.nextFloat() * 0.4f + 0.8f));
        if (!lllllllllllllIIIIllIlIIlIlIIIIll.isRemote) {
            final EntityEgg lllllllllllllIIIIllIlIIlIlIIIlIl = new EntityEgg(lllllllllllllIIIIllIlIIlIlIIIIll, lllllllllllllIIIIllIlIIlIlIIlIII);
            lllllllllllllIIIIllIlIIlIlIIIlIl.setHeadingFromThrower(lllllllllllllIIIIllIlIIlIlIIlIII, lllllllllllllIIIIllIlIIlIlIIlIII.rotationPitch, lllllllllllllIIIIllIlIIlIlIIlIII.rotationYaw, 0.0f, 1.5f, 1.0f);
            lllllllllllllIIIIllIlIIlIlIIIIll.spawnEntityInWorld(lllllllllllllIIIIllIlIIlIlIIIlIl);
        }
        lllllllllllllIIIIllIlIIlIlIIlIII.addStat(StatList.getObjectUseStats(this));
        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, lllllllllllllIIIIllIlIIlIlIIIllI);
    }
    
    public ItemEgg() {
        this.maxStackSize = 16;
        this.setCreativeTab(CreativeTabs.MATERIALS);
    }
}
