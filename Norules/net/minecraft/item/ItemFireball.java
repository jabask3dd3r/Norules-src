package net.minecraft.item;

import net.minecraft.entity.player.*;
import net.minecraft.world.*;
import net.minecraft.util.math.*;
import net.minecraft.block.material.*;
import net.minecraft.util.*;
import net.minecraft.init.*;
import net.minecraft.creativetab.*;

public class ItemFireball extends Item
{
    @Override
    public EnumActionResult onItemUse(final EntityPlayer llllllllllllllIIIIIlIIllIlIIIlll, final World llllllllllllllIIIIIlIIllIlIIIllI, BlockPos llllllllllllllIIIIIlIIllIlIIIlIl, final EnumHand llllllllllllllIIIIIlIIllIlIIIlII, final EnumFacing llllllllllllllIIIIIlIIllIlIIIIll, final float llllllllllllllIIIIIlIIllIlIIlIll, final float llllllllllllllIIIIIlIIllIlIIlIlI, final float llllllllllllllIIIIIlIIllIlIIlIIl) {
        if (llllllllllllllIIIIIlIIllIlIIIllI.isRemote) {
            return EnumActionResult.SUCCESS;
        }
        llllllllllllllIIIIIlIIllIlIIIlIl = llllllllllllllIIIIIlIIllIlIIIlIl.offset(llllllllllllllIIIIIlIIllIlIIIIll);
        final ItemStack llllllllllllllIIIIIlIIllIlIIlIII = llllllllllllllIIIIIlIIllIlIIIlll.getHeldItem(llllllllllllllIIIIIlIIllIlIIIlII);
        if (!llllllllllllllIIIIIlIIllIlIIIlll.canPlayerEdit(llllllllllllllIIIIIlIIllIlIIIlIl, llllllllllllllIIIIIlIIllIlIIIIll, llllllllllllllIIIIIlIIllIlIIlIII)) {
            return EnumActionResult.FAIL;
        }
        if (llllllllllllllIIIIIlIIllIlIIIllI.getBlockState(llllllllllllllIIIIIlIIllIlIIIlIl).getMaterial() == Material.AIR) {
            llllllllllllllIIIIIlIIllIlIIIllI.playSound(null, llllllllllllllIIIIIlIIllIlIIIlIl, SoundEvents.ITEM_FIRECHARGE_USE, SoundCategory.BLOCKS, 1.0f, (ItemFireball.itemRand.nextFloat() - ItemFireball.itemRand.nextFloat()) * 0.2f + 1.0f);
            llllllllllllllIIIIIlIIllIlIIIllI.setBlockState(llllllllllllllIIIIIlIIllIlIIIlIl, Blocks.FIRE.getDefaultState());
        }
        if (!llllllllllllllIIIIIlIIllIlIIIlll.capabilities.isCreativeMode) {
            llllllllllllllIIIIIlIIllIlIIlIII.func_190918_g(1);
        }
        return EnumActionResult.SUCCESS;
    }
    
    public ItemFireball() {
        this.setCreativeTab(CreativeTabs.MISC);
    }
}
