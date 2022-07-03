package net.minecraft.item;

import net.minecraft.util.math.*;
import net.minecraft.init.*;
import net.minecraft.block.properties.*;
import net.minecraft.world.*;
import net.minecraft.entity.*;
import net.minecraft.entity.player.*;
import net.minecraft.advancements.*;
import net.minecraft.util.*;
import net.minecraft.block.state.*;
import net.minecraft.block.*;

public class ItemBlockSpecial extends Item
{
    private final /* synthetic */ Block block;
    
    @Override
    public EnumActionResult onItemUse(final EntityPlayer lllllllllllllIlIIIlIllIlIIIIIIll, final World lllllllllllllIlIIIlIllIlIIIIIIlI, BlockPos lllllllllllllIlIIIlIllIlIIIIIIIl, final EnumHand lllllllllllllIlIIIlIllIlIIIIIIII, EnumFacing lllllllllllllIlIIIlIllIIllllllll, final float lllllllllllllIlIIIlIllIlIIIIllII, final float lllllllllllllIlIIIlIllIIllllllIl, final float lllllllllllllIlIIIlIllIIllllllII) {
        final IBlockState lllllllllllllIlIIIlIllIlIIIIlIIl = lllllllllllllIlIIIlIllIlIIIIIIlI.getBlockState(lllllllllllllIlIIIlIllIlIIIIIIIl);
        final Block lllllllllllllIlIIIlIllIlIIIIlIII = lllllllllllllIlIIIlIllIlIIIIlIIl.getBlock();
        if (lllllllllllllIlIIIlIllIlIIIIlIII == Blocks.SNOW_LAYER && lllllllllllllIlIIIlIllIlIIIIlIIl.getValue((IProperty<Integer>)BlockSnow.LAYERS) < 1) {
            lllllllllllllIlIIIlIllIIllllllll = EnumFacing.UP;
        }
        else if (!lllllllllllllIlIIIlIllIlIIIIlIII.isReplaceable(lllllllllllllIlIIIlIllIlIIIIIIlI, lllllllllllllIlIIIlIllIlIIIIIIIl)) {
            lllllllllllllIlIIIlIllIlIIIIIIIl = lllllllllllllIlIIIlIllIlIIIIIIIl.offset((EnumFacing)lllllllllllllIlIIIlIllIIllllllll);
        }
        final ItemStack lllllllllllllIlIIIlIllIlIIIIIlll = lllllllllllllIlIIIlIllIlIIIIIIll.getHeldItem(lllllllllllllIlIIIlIllIlIIIIIIII);
        if (lllllllllllllIlIIIlIllIlIIIIIlll.func_190926_b() || !lllllllllllllIlIIIlIllIlIIIIIIll.canPlayerEdit(lllllllllllllIlIIIlIllIlIIIIIIIl, (EnumFacing)lllllllllllllIlIIIlIllIIllllllll, lllllllllllllIlIIIlIllIlIIIIIlll) || !lllllllllllllIlIIIlIllIlIIIIIIlI.func_190527_a(this.block, lllllllllllllIlIIIlIllIlIIIIIIIl, false, (EnumFacing)lllllllllllllIlIIIlIllIIllllllll, null)) {
            return EnumActionResult.FAIL;
        }
        IBlockState lllllllllllllIlIIIlIllIlIIIIIllI = this.block.onBlockPlaced(lllllllllllllIlIIIlIllIlIIIIIIlI, lllllllllllllIlIIIlIllIlIIIIIIIl, (EnumFacing)lllllllllllllIlIIIlIllIIllllllll, lllllllllllllIlIIIlIllIlIIIIllII, lllllllllllllIlIIIlIllIIllllllIl, lllllllllllllIlIIIlIllIIllllllII, 0, lllllllllllllIlIIIlIllIlIIIIIIll);
        if (!lllllllllllllIlIIIlIllIlIIIIIIlI.setBlockState(lllllllllllllIlIIIlIllIlIIIIIIIl, lllllllllllllIlIIIlIllIlIIIIIllI, 11)) {
            return EnumActionResult.FAIL;
        }
        lllllllllllllIlIIIlIllIlIIIIIllI = lllllllllllllIlIIIlIllIlIIIIIIlI.getBlockState(lllllllllllllIlIIIlIllIlIIIIIIIl);
        if (lllllllllllllIlIIIlIllIlIIIIIllI.getBlock() == this.block) {
            ItemBlock.setTileEntityNBT(lllllllllllllIlIIIlIllIlIIIIIIlI, lllllllllllllIlIIIlIllIlIIIIIIll, lllllllllllllIlIIIlIllIlIIIIIIIl, lllllllllllllIlIIIlIllIlIIIIIlll);
            lllllllllllllIlIIIlIllIlIIIIIllI.getBlock().onBlockPlacedBy(lllllllllllllIlIIIlIllIlIIIIIIlI, lllllllllllllIlIIIlIllIlIIIIIIIl, lllllllllllllIlIIIlIllIlIIIIIllI, lllllllllllllIlIIIlIllIlIIIIIIll, lllllllllllllIlIIIlIllIlIIIIIlll);
            if (lllllllllllllIlIIIlIllIlIIIIIIll instanceof EntityPlayerMP) {
                CriteriaTriggers.field_193137_x.func_193173_a((EntityPlayerMP)lllllllllllllIlIIIlIllIlIIIIIIll, lllllllllllllIlIIIlIllIlIIIIIIIl, lllllllllllllIlIIIlIllIlIIIIIlll);
            }
        }
        final SoundType lllllllllllllIlIIIlIllIlIIIIIlIl = this.block.getSoundType();
        lllllllllllllIlIIIlIllIlIIIIIIlI.playSound(lllllllllllllIlIIIlIllIlIIIIIIll, lllllllllllllIlIIIlIllIlIIIIIIIl, lllllllllllllIlIIIlIllIlIIIIIlIl.getPlaceSound(), SoundCategory.BLOCKS, (lllllllllllllIlIIIlIllIlIIIIIlIl.getVolume() + 1.0f) / 2.0f, lllllllllllllIlIIIlIllIlIIIIIlIl.getPitch() * 0.8f);
        lllllllllllllIlIIIlIllIlIIIIIlll.func_190918_g(1);
        return EnumActionResult.SUCCESS;
    }
    
    public ItemBlockSpecial(final Block lllllllllllllIlIIIlIllIlIIlIIIll) {
        this.block = lllllllllllllIlIIIlIllIlIIlIIIll;
    }
}
