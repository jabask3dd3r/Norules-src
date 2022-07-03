package net.minecraft.item;

import net.minecraft.world.*;
import net.minecraft.entity.player.*;
import net.minecraft.util.*;
import net.minecraft.entity.passive.*;
import net.minecraft.entity.*;
import net.minecraft.init.*;
import net.minecraft.stats.*;
import net.minecraft.creativetab.*;

public class ItemCarrotOnAStick extends Item
{
    @Override
    public ActionResult<ItemStack> onItemRightClick(final World lllllllllllllIlIlIIlIlIIllIIlllI, final EntityPlayer lllllllllllllIlIlIIlIlIIllIIIllI, final EnumHand lllllllllllllIlIlIIlIlIIllIIIlIl) {
        final ItemStack lllllllllllllIlIlIIlIlIIllIIlIll = lllllllllllllIlIlIIlIlIIllIIIllI.getHeldItem(lllllllllllllIlIlIIlIlIIllIIIlIl);
        if (lllllllllllllIlIlIIlIlIIllIIlllI.isRemote) {
            return new ActionResult<ItemStack>(EnumActionResult.PASS, lllllllllllllIlIlIIlIlIIllIIlIll);
        }
        if (lllllllllllllIlIlIIlIlIIllIIIllI.isRiding() && lllllllllllllIlIlIIlIlIIllIIIllI.getRidingEntity() instanceof EntityPig) {
            final EntityPig lllllllllllllIlIlIIlIlIIllIIlIlI = (EntityPig)lllllllllllllIlIlIIlIlIIllIIIllI.getRidingEntity();
            if (lllllllllllllIlIlIIlIlIIllIIlIll.getMaxDamage() - lllllllllllllIlIlIIlIlIIllIIlIll.getMetadata() >= 7 && lllllllllllllIlIlIIlIlIIllIIlIlI.boost()) {
                lllllllllllllIlIlIIlIlIIllIIlIll.damageItem(7, lllllllllllllIlIlIIlIlIIllIIIllI);
                if (lllllllllllllIlIlIIlIlIIllIIlIll.func_190926_b()) {
                    final ItemStack lllllllllllllIlIlIIlIlIIllIIlIIl = new ItemStack(Items.FISHING_ROD);
                    lllllllllllllIlIlIIlIlIIllIIlIIl.setTagCompound(lllllllllllllIlIlIIlIlIIllIIlIll.getTagCompound());
                    return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, lllllllllllllIlIlIIlIlIIllIIlIIl);
                }
                return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, lllllllllllllIlIlIIlIlIIllIIlIll);
            }
        }
        lllllllllllllIlIlIIlIlIIllIIIllI.addStat(StatList.getObjectUseStats(this));
        return new ActionResult<ItemStack>(EnumActionResult.PASS, lllllllllllllIlIlIIlIlIIllIIlIll);
    }
    
    @Override
    public boolean shouldRotateAroundWhenRendering() {
        return true;
    }
    
    public ItemCarrotOnAStick() {
        this.setCreativeTab(CreativeTabs.TRANSPORTATION);
        this.setMaxStackSize(1);
        this.setMaxDamage(25);
    }
    
    @Override
    public boolean isFull3D() {
        return true;
    }
}
