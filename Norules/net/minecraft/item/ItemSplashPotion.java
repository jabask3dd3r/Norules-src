package net.minecraft.item;

import net.minecraft.world.*;
import net.minecraft.entity.player.*;
import net.minecraft.init.*;
import net.minecraft.entity.projectile.*;
import net.minecraft.entity.*;
import net.minecraft.stats.*;
import net.minecraft.util.*;
import net.minecraft.potion.*;
import net.minecraft.util.text.translation.*;

public class ItemSplashPotion extends ItemPotion
{
    @Override
    public ActionResult<ItemStack> onItemRightClick(final World lllllllllllllIIIlllIIlIIIlllIlIl, final EntityPlayer lllllllllllllIIIlllIIlIIIllllIll, final EnumHand lllllllllllllIIIlllIIlIIIllllIlI) {
        final ItemStack lllllllllllllIIIlllIIlIIIllllIIl = lllllllllllllIIIlllIIlIIIllllIll.getHeldItem(lllllllllllllIIIlllIIlIIIllllIlI);
        final ItemStack lllllllllllllIIIlllIIlIIIllllIII = lllllllllllllIIIlllIIlIIIllllIll.capabilities.isCreativeMode ? lllllllllllllIIIlllIIlIIIllllIIl.copy() : lllllllllllllIIIlllIIlIIIllllIIl.splitStack(1);
        lllllllllllllIIIlllIIlIIIlllIlIl.playSound(null, lllllllllllllIIIlllIIlIIIllllIll.posX, lllllllllllllIIIlllIIlIIIllllIll.posY, lllllllllllllIIIlllIIlIIIllllIll.posZ, SoundEvents.ENTITY_SPLASH_POTION_THROW, SoundCategory.PLAYERS, 0.5f, 0.4f / (ItemSplashPotion.itemRand.nextFloat() * 0.4f + 0.8f));
        if (!lllllllllllllIIIlllIIlIIIlllIlIl.isRemote) {
            final EntityPotion lllllllllllllIIIlllIIlIIIlllIlll = new EntityPotion(lllllllllllllIIIlllIIlIIIlllIlIl, lllllllllllllIIIlllIIlIIIllllIll, lllllllllllllIIIlllIIlIIIllllIII);
            lllllllllllllIIIlllIIlIIIlllIlll.setHeadingFromThrower(lllllllllllllIIIlllIIlIIIllllIll, lllllllllllllIIIlllIIlIIIllllIll.rotationPitch, lllllllllllllIIIlllIIlIIIllllIll.rotationYaw, -20.0f, 0.5f, 1.0f);
            lllllllllllllIIIlllIIlIIIlllIlIl.spawnEntityInWorld(lllllllllllllIIIlllIIlIIIlllIlll);
        }
        lllllllllllllIIIlllIIlIIIllllIll.addStat(StatList.getObjectUseStats(this));
        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, lllllllllllllIIIlllIIlIIIllllIIl);
    }
    
    @Override
    public String getItemStackDisplayName(final ItemStack lllllllllllllIIIlllIIlIIlIIIIllI) {
        return I18n.translateToLocal(PotionUtils.getPotionFromItem(lllllllllllllIIIlllIIlIIlIIIIllI).getNamePrefixed("splash_potion.effect."));
    }
}
