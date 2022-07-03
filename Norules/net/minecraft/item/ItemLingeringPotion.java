package net.minecraft.item;

import net.minecraft.world.*;
import javax.annotation.*;
import java.util.*;
import net.minecraft.client.util.*;
import net.minecraft.potion.*;
import net.minecraft.entity.player.*;
import net.minecraft.init.*;
import net.minecraft.entity.projectile.*;
import net.minecraft.entity.*;
import net.minecraft.stats.*;
import net.minecraft.util.*;
import net.minecraft.util.text.translation.*;

public class ItemLingeringPotion extends ItemPotion
{
    @Override
    public void addInformation(final ItemStack lllllllllllllIlIIlIIIIIIIlllIllI, @Nullable final World lllllllllllllIlIIlIIIIIIIlllIlIl, final List<String> lllllllllllllIlIIlIIIIIIIlllIlII, final ITooltipFlag lllllllllllllIlIIlIIIIIIIlllIIll) {
        PotionUtils.addPotionTooltip(lllllllllllllIlIIlIIIIIIIlllIllI, lllllllllllllIlIIlIIIIIIIlllIlII, 0.25f);
    }
    
    @Override
    public ActionResult<ItemStack> onItemRightClick(final World lllllllllllllIlIIlIIIIIIIllIIIIl, final EntityPlayer lllllllllllllIlIIlIIIIIIIllIIlll, final EnumHand lllllllllllllIlIIlIIIIIIIllIIllI) {
        final ItemStack lllllllllllllIlIIlIIIIIIIllIIlIl = lllllllllllllIlIIlIIIIIIIllIIlll.getHeldItem(lllllllllllllIlIIlIIIIIIIllIIllI);
        final ItemStack lllllllllllllIlIIlIIIIIIIllIIlII = lllllllllllllIlIIlIIIIIIIllIIlll.capabilities.isCreativeMode ? lllllllllllllIlIIlIIIIIIIllIIlIl.copy() : lllllllllllllIlIIlIIIIIIIllIIlIl.splitStack(1);
        lllllllllllllIlIIlIIIIIIIllIIIIl.playSound(null, lllllllllllllIlIIlIIIIIIIllIIlll.posX, lllllllllllllIlIIlIIIIIIIllIIlll.posY, lllllllllllllIlIIlIIIIIIIllIIlll.posZ, SoundEvents.ENTITY_LINGERINGPOTION_THROW, SoundCategory.NEUTRAL, 0.5f, 0.4f / (ItemLingeringPotion.itemRand.nextFloat() * 0.4f + 0.8f));
        if (!lllllllllllllIlIIlIIIIIIIllIIIIl.isRemote) {
            final EntityPotion lllllllllllllIlIIlIIIIIIIllIIIll = new EntityPotion(lllllllllllllIlIIlIIIIIIIllIIIIl, lllllllllllllIlIIlIIIIIIIllIIlll, lllllllllllllIlIIlIIIIIIIllIIlII);
            lllllllllllllIlIIlIIIIIIIllIIIll.setHeadingFromThrower(lllllllllllllIlIIlIIIIIIIllIIlll, lllllllllllllIlIIlIIIIIIIllIIlll.rotationPitch, lllllllllllllIlIIlIIIIIIIllIIlll.rotationYaw, -20.0f, 0.5f, 1.0f);
            lllllllllllllIlIIlIIIIIIIllIIIIl.spawnEntityInWorld(lllllllllllllIlIIlIIIIIIIllIIIll);
        }
        lllllllllllllIlIIlIIIIIIIllIIlll.addStat(StatList.getObjectUseStats(this));
        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, lllllllllllllIlIIlIIIIIIIllIIlIl);
    }
    
    @Override
    public String getItemStackDisplayName(final ItemStack lllllllllllllIlIIlIIIIIIIllllIll) {
        return I18n.translateToLocal(PotionUtils.getPotionFromItem(lllllllllllllIlIIlIIIIIIIllllIll).getNamePrefixed("lingering_potion.effect."));
    }
}
