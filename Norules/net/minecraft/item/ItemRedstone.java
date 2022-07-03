package net.minecraft.item;

import net.minecraft.creativetab.*;
import net.minecraft.util.math.*;
import net.minecraft.util.*;
import net.minecraft.world.*;
import net.minecraft.entity.*;
import net.minecraft.init.*;
import net.minecraft.entity.player.*;
import net.minecraft.advancements.*;

public class ItemRedstone extends Item
{
    public ItemRedstone() {
        this.setCreativeTab(CreativeTabs.REDSTONE);
    }
    
    @Override
    public EnumActionResult onItemUse(final EntityPlayer lllllllllllllIlllIlllIlllIllllIl, final World lllllllllllllIlllIlllIllllIIIlll, final BlockPos lllllllllllllIlllIlllIlllIlllIll, final EnumHand lllllllllllllIlllIlllIllllIIIlIl, final EnumFacing lllllllllllllIlllIlllIllllIIIlII, final float lllllllllllllIlllIlllIllllIIIIll, final float lllllllllllllIlllIlllIllllIIIIlI, final float lllllllllllllIlllIlllIllllIIIIIl) {
        final boolean lllllllllllllIlllIlllIllllIIIIII = lllllllllllllIlllIlllIllllIIIlll.getBlockState(lllllllllllllIlllIlllIlllIlllIll).getBlock().isReplaceable(lllllllllllllIlllIlllIllllIIIlll, lllllllllllllIlllIlllIlllIlllIll);
        final BlockPos lllllllllllllIlllIlllIlllIllllll = lllllllllllllIlllIlllIllllIIIIII ? lllllllllllllIlllIlllIlllIlllIll : lllllllllllllIlllIlllIlllIlllIll.offset(lllllllllllllIlllIlllIllllIIIlII);
        final ItemStack lllllllllllllIlllIlllIlllIlllllI = lllllllllllllIlllIlllIlllIllllIl.getHeldItem(lllllllllllllIlllIlllIllllIIIlIl);
        if (lllllllllllllIlllIlllIlllIllllIl.canPlayerEdit(lllllllllllllIlllIlllIlllIllllll, lllllllllllllIlllIlllIllllIIIlII, lllllllllllllIlllIlllIlllIlllllI) && lllllllllllllIlllIlllIllllIIIlll.func_190527_a(lllllllllllllIlllIlllIllllIIIlll.getBlockState(lllllllllllllIlllIlllIlllIllllll).getBlock(), lllllllllllllIlllIlllIlllIllllll, false, lllllllllllllIlllIlllIllllIIIlII, null) && Blocks.REDSTONE_WIRE.canPlaceBlockAt(lllllllllllllIlllIlllIllllIIIlll, lllllllllllllIlllIlllIlllIllllll)) {
            lllllllllllllIlllIlllIllllIIIlll.setBlockState(lllllllllllllIlllIlllIlllIllllll, Blocks.REDSTONE_WIRE.getDefaultState());
            if (lllllllllllllIlllIlllIlllIllllIl instanceof EntityPlayerMP) {
                CriteriaTriggers.field_193137_x.func_193173_a((EntityPlayerMP)lllllllllllllIlllIlllIlllIllllIl, lllllllllllllIlllIlllIlllIllllll, lllllllllllllIlllIlllIlllIlllllI);
            }
            lllllllllllllIlllIlllIlllIlllllI.func_190918_g(1);
            return EnumActionResult.SUCCESS;
        }
        return EnumActionResult.FAIL;
    }
}
