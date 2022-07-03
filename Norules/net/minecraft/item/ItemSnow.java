package net.minecraft.item;

import net.minecraft.world.*;
import net.minecraft.block.properties.*;
import net.minecraft.util.*;
import net.minecraft.entity.player.*;
import net.minecraft.advancements.*;
import net.minecraft.block.state.*;
import net.minecraft.util.math.*;
import net.minecraft.block.*;

public class ItemSnow extends ItemBlock
{
    @Override
    public int getMetadata(final int lllllllllllllIlIIlIlllllIllIIlIl) {
        return lllllllllllllIlIIlIlllllIllIIlIl;
    }
    
    public ItemSnow(final Block lllllllllllllIlIIlIllllllIlllIIl) {
        super(lllllllllllllIlIIlIllllllIlllIIl);
        this.setMaxDamage(0);
    }
    
    @Override
    public EnumActionResult onItemUse(final EntityPlayer lllllllllllllIlIIlIlllllIlllIlll, final World lllllllllllllIlIIlIllllllIIIIlll, final BlockPos lllllllllllllIlIIlIlllllIlllIlIl, final EnumHand lllllllllllllIlIIlIlllllIlllIlII, final EnumFacing lllllllllllllIlIIlIlllllIlllIIll, final float lllllllllllllIlIIlIllllllIIIIIll, final float lllllllllllllIlIIlIllllllIIIIIlI, final float lllllllllllllIlIIlIllllllIIIIIIl) {
        final ItemStack lllllllllllllIlIIlIllllllIIIIIII = lllllllllllllIlIIlIlllllIlllIlll.getHeldItem(lllllllllllllIlIIlIlllllIlllIlII);
        if (!lllllllllllllIlIIlIllllllIIIIIII.func_190926_b() && lllllllllllllIlIIlIlllllIlllIlll.canPlayerEdit(lllllllllllllIlIIlIlllllIlllIlIl, lllllllllllllIlIIlIlllllIlllIIll, lllllllllllllIlIIlIllllllIIIIIII)) {
            IBlockState lllllllllllllIlIIlIlllllIlllllll = lllllllllllllIlIIlIllllllIIIIlll.getBlockState(lllllllllllllIlIIlIlllllIlllIlIl);
            Block lllllllllllllIlIIlIlllllIllllllI = lllllllllllllIlIIlIlllllIlllllll.getBlock();
            BlockPos lllllllllllllIlIIlIlllllIlllllIl = lllllllllllllIlIIlIlllllIlllIlIl;
            if ((lllllllllllllIlIIlIlllllIlllIIll != EnumFacing.UP || lllllllllllllIlIIlIlllllIllllllI != this.block) && !lllllllllllllIlIIlIlllllIllllllI.isReplaceable(lllllllllllllIlIIlIllllllIIIIlll, lllllllllllllIlIIlIlllllIlllIlIl)) {
                lllllllllllllIlIIlIlllllIlllllIl = lllllllllllllIlIIlIlllllIlllIlIl.offset(lllllllllllllIlIIlIlllllIlllIIll);
                lllllllllllllIlIIlIlllllIlllllll = lllllllllllllIlIIlIllllllIIIIlll.getBlockState(lllllllllllllIlIIlIlllllIlllllIl);
                lllllllllllllIlIIlIlllllIllllllI = lllllllllllllIlIIlIlllllIlllllll.getBlock();
            }
            if (lllllllllllllIlIIlIlllllIllllllI == this.block) {
                final int lllllllllllllIlIIlIlllllIlllllII = lllllllllllllIlIIlIlllllIlllllll.getValue((IProperty<Integer>)BlockSnow.LAYERS);
                if (lllllllllllllIlIIlIlllllIlllllII < 8) {
                    final IBlockState lllllllllllllIlIIlIlllllIllllIll = lllllllllllllIlIIlIlllllIlllllll.withProperty((IProperty<Comparable>)BlockSnow.LAYERS, lllllllllllllIlIIlIlllllIlllllII + 1);
                    final AxisAlignedBB lllllllllllllIlIIlIlllllIllllIlI = lllllllllllllIlIIlIlllllIllllIll.getCollisionBoundingBox(lllllllllllllIlIIlIllllllIIIIlll, lllllllllllllIlIIlIlllllIlllllIl);
                    if (lllllllllllllIlIIlIlllllIllllIlI != Block.NULL_AABB && lllllllllllllIlIIlIllllllIIIIlll.checkNoEntityCollision(lllllllllllllIlIIlIlllllIllllIlI.offset(lllllllllllllIlIIlIlllllIlllllIl)) && lllllllllllllIlIIlIllllllIIIIlll.setBlockState(lllllllllllllIlIIlIlllllIlllllIl, lllllllllllllIlIIlIlllllIllllIll, 10)) {
                        final SoundType lllllllllllllIlIIlIlllllIllllIIl = this.block.getSoundType();
                        lllllllllllllIlIIlIllllllIIIIlll.playSound(lllllllllllllIlIIlIlllllIlllIlll, lllllllllllllIlIIlIlllllIlllllIl, lllllllllllllIlIIlIlllllIllllIIl.getPlaceSound(), SoundCategory.BLOCKS, (lllllllllllllIlIIlIlllllIllllIIl.getVolume() + 1.0f) / 2.0f, lllllllllllllIlIIlIlllllIllllIIl.getPitch() * 0.8f);
                        if (lllllllllllllIlIIlIlllllIlllIlll instanceof EntityPlayerMP) {
                            CriteriaTriggers.field_193137_x.func_193173_a((EntityPlayerMP)lllllllllllllIlIIlIlllllIlllIlll, lllllllllllllIlIIlIlllllIlllIlIl, lllllllllllllIlIIlIllllllIIIIIII);
                        }
                        lllllllllllllIlIIlIllllllIIIIIII.func_190918_g(1);
                        return EnumActionResult.SUCCESS;
                    }
                }
            }
            return super.onItemUse(lllllllllllllIlIIlIlllllIlllIlll, lllllllllllllIlIIlIllllllIIIIlll, lllllllllllllIlIIlIlllllIlllIlIl, lllllllllllllIlIIlIlllllIlllIlII, lllllllllllllIlIIlIlllllIlllIIll, lllllllllllllIlIIlIllllllIIIIIll, lllllllllllllIlIIlIllllllIIIIIlI, lllllllllllllIlIIlIllllllIIIIIIl);
        }
        return EnumActionResult.FAIL;
    }
}
