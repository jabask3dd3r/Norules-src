package net.minecraft.item;

import net.minecraft.world.*;
import net.minecraft.block.material.*;
import net.minecraft.block.properties.*;
import net.minecraft.entity.player.*;
import net.minecraft.advancements.*;
import net.minecraft.stats.*;
import net.minecraft.init.*;
import net.minecraft.util.*;
import net.minecraft.util.math.*;
import net.minecraft.block.state.*;
import net.minecraft.block.*;

public class ItemLilyPad extends ItemColored
{
    @Override
    public ActionResult<ItemStack> onItemRightClick(final World lllllllllllllllllllIIIIIIlIllIII, final EntityPlayer lllllllllllllllllllIIIIIIlIIlllI, final EnumHand lllllllllllllllllllIIIIIIlIIllIl) {
        final ItemStack lllllllllllllllllllIIIIIIlIlIlIl = lllllllllllllllllllIIIIIIlIIlllI.getHeldItem(lllllllllllllllllllIIIIIIlIIllIl);
        final RayTraceResult lllllllllllllllllllIIIIIIlIlIlII = this.rayTrace(lllllllllllllllllllIIIIIIlIllIII, lllllllllllllllllllIIIIIIlIIlllI, true);
        if (lllllllllllllllllllIIIIIIlIlIlII == null) {
            return new ActionResult<ItemStack>(EnumActionResult.PASS, lllllllllllllllllllIIIIIIlIlIlIl);
        }
        if (lllllllllllllllllllIIIIIIlIlIlII.typeOfHit == RayTraceResult.Type.BLOCK) {
            final BlockPos lllllllllllllllllllIIIIIIlIlIIll = lllllllllllllllllllIIIIIIlIlIlII.getBlockPos();
            if (!lllllllllllllllllllIIIIIIlIllIII.isBlockModifiable(lllllllllllllllllllIIIIIIlIIlllI, lllllllllllllllllllIIIIIIlIlIIll) || !lllllllllllllllllllIIIIIIlIIlllI.canPlayerEdit(lllllllllllllllllllIIIIIIlIlIIll.offset(lllllllllllllllllllIIIIIIlIlIlII.sideHit), lllllllllllllllllllIIIIIIlIlIlII.sideHit, lllllllllllllllllllIIIIIIlIlIlIl)) {
                return new ActionResult<ItemStack>(EnumActionResult.FAIL, lllllllllllllllllllIIIIIIlIlIlIl);
            }
            final BlockPos lllllllllllllllllllIIIIIIlIlIIlI = lllllllllllllllllllIIIIIIlIlIIll.up();
            final IBlockState lllllllllllllllllllIIIIIIlIlIIIl = lllllllllllllllllllIIIIIIlIllIII.getBlockState(lllllllllllllllllllIIIIIIlIlIIll);
            if (lllllllllllllllllllIIIIIIlIlIIIl.getMaterial() == Material.WATER && lllllllllllllllllllIIIIIIlIlIIIl.getValue((IProperty<Integer>)BlockLiquid.LEVEL) == 0 && lllllllllllllllllllIIIIIIlIllIII.isAirBlock(lllllllllllllllllllIIIIIIlIlIIlI)) {
                lllllllllllllllllllIIIIIIlIllIII.setBlockState(lllllllllllllllllllIIIIIIlIlIIlI, Blocks.WATERLILY.getDefaultState(), 11);
                if (lllllllllllllllllllIIIIIIlIIlllI instanceof EntityPlayerMP) {
                    CriteriaTriggers.field_193137_x.func_193173_a((EntityPlayerMP)lllllllllllllllllllIIIIIIlIIlllI, lllllllllllllllllllIIIIIIlIlIIlI, lllllllllllllllllllIIIIIIlIlIlIl);
                }
                if (!lllllllllllllllllllIIIIIIlIIlllI.capabilities.isCreativeMode) {
                    lllllllllllllllllllIIIIIIlIlIlIl.func_190918_g(1);
                }
                lllllllllllllllllllIIIIIIlIIlllI.addStat(StatList.getObjectUseStats(this));
                lllllllllllllllllllIIIIIIlIllIII.playSound(lllllllllllllllllllIIIIIIlIIlllI, lllllllllllllllllllIIIIIIlIlIIll, SoundEvents.BLOCK_WATERLILY_PLACE, SoundCategory.BLOCKS, 1.0f, 1.0f);
                return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, lllllllllllllllllllIIIIIIlIlIlIl);
            }
        }
        return new ActionResult<ItemStack>(EnumActionResult.FAIL, lllllllllllllllllllIIIIIIlIlIlIl);
    }
    
    public ItemLilyPad(final Block lllllllllllllllllllIIIIIIllIIIll) {
        super(lllllllllllllllllllIIIIIIllIIIll, false);
    }
}
