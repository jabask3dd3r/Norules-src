package net.minecraft.item;

import net.minecraft.creativetab.*;
import net.minecraft.world.*;
import net.minecraft.util.math.*;
import net.minecraft.block.material.*;
import net.minecraft.util.*;
import net.minecraft.init.*;
import net.minecraft.entity.player.*;
import net.minecraft.advancements.*;
import net.minecraft.entity.*;

public class ItemFlintAndSteel extends Item
{
    public ItemFlintAndSteel() {
        this.maxStackSize = 1;
        this.setMaxDamage(64);
        this.setCreativeTab(CreativeTabs.TOOLS);
    }
    
    @Override
    public EnumActionResult onItemUse(final EntityPlayer llllllllllllllIIlIllIlIlIIlllIll, final World llllllllllllllIIlIllIlIlIIllIIIl, BlockPos llllllllllllllIIlIllIlIlIIllIIII, final EnumHand llllllllllllllIIlIllIlIlIIlIllll, final EnumFacing llllllllllllllIIlIllIlIlIIlIlllI, final float llllllllllllllIIlIllIlIlIIllIllI, final float llllllllllllllIIlIllIlIlIIllIlIl, final float llllllllllllllIIlIllIlIlIIllIlII) {
        llllllllllllllIIlIllIlIlIIllIIII = llllllllllllllIIlIllIlIlIIllIIII.offset(llllllllllllllIIlIllIlIlIIlIlllI);
        final ItemStack llllllllllllllIIlIllIlIlIIllIIll = llllllllllllllIIlIllIlIlIIlllIll.getHeldItem(llllllllllllllIIlIllIlIlIIlIllll);
        if (!llllllllllllllIIlIllIlIlIIlllIll.canPlayerEdit(llllllllllllllIIlIllIlIlIIllIIII, llllllllllllllIIlIllIlIlIIlIlllI, llllllllllllllIIlIllIlIlIIllIIll)) {
            return EnumActionResult.FAIL;
        }
        if (llllllllllllllIIlIllIlIlIIllIIIl.getBlockState(llllllllllllllIIlIllIlIlIIllIIII).getMaterial() == Material.AIR) {
            llllllllllllllIIlIllIlIlIIllIIIl.playSound(llllllllllllllIIlIllIlIlIIlllIll, llllllllllllllIIlIllIlIlIIllIIII, SoundEvents.ITEM_FLINTANDSTEEL_USE, SoundCategory.BLOCKS, 1.0f, ItemFlintAndSteel.itemRand.nextFloat() * 0.4f + 0.8f);
            llllllllllllllIIlIllIlIlIIllIIIl.setBlockState(llllllllllllllIIlIllIlIlIIllIIII, Blocks.FIRE.getDefaultState(), 11);
        }
        if (llllllllllllllIIlIllIlIlIIlllIll instanceof EntityPlayerMP) {
            CriteriaTriggers.field_193137_x.func_193173_a((EntityPlayerMP)llllllllllllllIIlIllIlIlIIlllIll, llllllllllllllIIlIllIlIlIIllIIII, llllllllllllllIIlIllIlIlIIllIIll);
        }
        llllllllllllllIIlIllIlIlIIllIIll.damageItem(1, llllllllllllllIIlIllIlIlIIlllIll);
        return EnumActionResult.SUCCESS;
    }
}
