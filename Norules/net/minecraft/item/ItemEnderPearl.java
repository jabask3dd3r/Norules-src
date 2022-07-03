package net.minecraft.item;

import net.minecraft.world.*;
import net.minecraft.entity.player.*;
import net.minecraft.init.*;
import net.minecraft.entity.item.*;
import net.minecraft.entity.*;
import net.minecraft.stats.*;
import net.minecraft.util.*;
import net.minecraft.creativetab.*;

public class ItemEnderPearl extends Item
{
    @Override
    public ActionResult<ItemStack> onItemRightClick(final World llllllllllllllllIllIlIlIlIIIllIl, final EntityPlayer llllllllllllllllIllIlIlIlIIlIIlI, final EnumHand llllllllllllllllIllIlIlIlIIlIIIl) {
        final ItemStack llllllllllllllllIllIlIlIlIIlIIII = llllllllllllllllIllIlIlIlIIlIIlI.getHeldItem(llllllllllllllllIllIlIlIlIIlIIIl);
        if (!llllllllllllllllIllIlIlIlIIlIIlI.capabilities.isCreativeMode) {
            llllllllllllllllIllIlIlIlIIlIIII.func_190918_g(1);
        }
        llllllllllllllllIllIlIlIlIIIllIl.playSound(null, llllllllllllllllIllIlIlIlIIlIIlI.posX, llllllllllllllllIllIlIlIlIIlIIlI.posY, llllllllllllllllIllIlIlIlIIlIIlI.posZ, SoundEvents.ENTITY_ENDERPEARL_THROW, SoundCategory.NEUTRAL, 0.5f, 0.4f / (ItemEnderPearl.itemRand.nextFloat() * 0.4f + 0.8f));
        llllllllllllllllIllIlIlIlIIlIIlI.getCooldownTracker().setCooldown(this, 20);
        if (!llllllllllllllllIllIlIlIlIIIllIl.isRemote) {
            final EntityEnderPearl llllllllllllllllIllIlIlIlIIIllll = new EntityEnderPearl(llllllllllllllllIllIlIlIlIIIllIl, llllllllllllllllIllIlIlIlIIlIIlI);
            llllllllllllllllIllIlIlIlIIIllll.setHeadingFromThrower(llllllllllllllllIllIlIlIlIIlIIlI, llllllllllllllllIllIlIlIlIIlIIlI.rotationPitch, llllllllllllllllIllIlIlIlIIlIIlI.rotationYaw, 0.0f, 1.5f, 1.0f);
            llllllllllllllllIllIlIlIlIIIllIl.spawnEntityInWorld(llllllllllllllllIllIlIlIlIIIllll);
        }
        llllllllllllllllIllIlIlIlIIlIIlI.addStat(StatList.getObjectUseStats(this));
        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, llllllllllllllllIllIlIlIlIIlIIII);
    }
    
    public ItemEnderPearl() {
        this.maxStackSize = 16;
        this.setCreativeTab(CreativeTabs.MISC);
    }
}
