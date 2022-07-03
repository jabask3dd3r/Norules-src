package net.minecraft.item;

import net.minecraft.block.properties.*;
import net.minecraft.world.*;
import net.minecraft.block.state.*;
import net.minecraft.util.math.*;
import net.minecraft.block.*;
import net.minecraft.util.*;
import net.minecraft.entity.player.*;
import net.minecraft.advancements.*;

public class ItemSlab extends ItemBlock
{
    private final /* synthetic */ BlockSlab singleSlab;
    private final /* synthetic */ BlockSlab doubleSlab;
    
    private boolean tryPlace(final EntityPlayer lllllllllllllIllIIIlIIIlIlIIlIlI, final ItemStack lllllllllllllIllIIIlIIIlIlIlIlII, final World lllllllllllllIllIIIlIIIlIlIIlIII, final BlockPos lllllllllllllIllIIIlIIIlIlIIIlll, final Object lllllllllllllIllIIIlIIIlIlIIIllI) {
        final IBlockState lllllllllllllIllIIIlIIIlIlIlIIII = lllllllllllllIllIIIlIIIlIlIIlIII.getBlockState(lllllllllllllIllIIIlIIIlIlIIIlll);
        if (lllllllllllllIllIIIlIIIlIlIlIIII.getBlock() == this.singleSlab) {
            final Comparable<?> lllllllllllllIllIIIlIIIlIlIIllll = lllllllllllllIllIIIlIIIlIlIlIIII.getValue(this.singleSlab.getVariantProperty());
            if (lllllllllllllIllIIIlIIIlIlIIllll == lllllllllllllIllIIIlIIIlIlIIIllI) {
                final IBlockState lllllllllllllIllIIIlIIIlIlIIlllI = this.makeState(this.singleSlab.getVariantProperty(), lllllllllllllIllIIIlIIIlIlIIllll);
                final AxisAlignedBB lllllllllllllIllIIIlIIIlIlIIllIl = lllllllllllllIllIIIlIIIlIlIIlllI.getCollisionBoundingBox(lllllllllllllIllIIIlIIIlIlIIlIII, lllllllllllllIllIIIlIIIlIlIIIlll);
                if (lllllllllllllIllIIIlIIIlIlIIllIl != Block.NULL_AABB && lllllllllllllIllIIIlIIIlIlIIlIII.checkNoEntityCollision(lllllllllllllIllIIIlIIIlIlIIllIl.offset(lllllllllllllIllIIIlIIIlIlIIIlll)) && lllllllllllllIllIIIlIIIlIlIIlIII.setBlockState(lllllllllllllIllIIIlIIIlIlIIIlll, lllllllllllllIllIIIlIIIlIlIIlllI, 11)) {
                    final SoundType lllllllllllllIllIIIlIIIlIlIIllII = this.doubleSlab.getSoundType();
                    lllllllllllllIllIIIlIIIlIlIIlIII.playSound(lllllllllllllIllIIIlIIIlIlIIlIlI, lllllllllllllIllIIIlIIIlIlIIIlll, lllllllllllllIllIIIlIIIlIlIIllII.getPlaceSound(), SoundCategory.BLOCKS, (lllllllllllllIllIIIlIIIlIlIIllII.getVolume() + 1.0f) / 2.0f, lllllllllllllIllIIIlIIIlIlIIllII.getPitch() * 0.8f);
                    lllllllllllllIllIIIlIIIlIlIlIlII.func_190918_g(1);
                }
                return true;
            }
        }
        return false;
    }
    
    @Override
    public int getMetadata(final int lllllllllllllIllIIIlIIIlllIIIIII) {
        return lllllllllllllIllIIIlIIIlllIIIIII;
    }
    
    protected <T extends Comparable<T>> IBlockState makeState(final IProperty<T> lllllllllllllIllIIIlIIIlIIllllII, final Comparable<?> lllllllllllllIllIIIlIIIlIIlllIll) {
        return this.doubleSlab.getDefaultState().withProperty(lllllllllllllIllIIIlIIIlIIllllII, lllllllllllllIllIIIlIIIlIIlllIll);
    }
    
    @Override
    public EnumActionResult onItemUse(final EntityPlayer lllllllllllllIllIIIlIIIllIIlIlII, final World lllllllllllllIllIIIlIIIllIlIIlIl, final BlockPos lllllllllllllIllIIIlIIIllIlIIlII, final EnumHand lllllllllllllIllIIIlIIIllIlIIIll, final EnumFacing lllllllllllllIllIIIlIIIllIlIIIlI, final float lllllllllllllIllIIIlIIIllIlIIIIl, final float lllllllllllllIllIIIlIIIllIlIIIII, final float lllllllllllllIllIIIlIIIllIIlllll) {
        final ItemStack lllllllllllllIllIIIlIIIllIIllllI = lllllllllllllIllIIIlIIIllIIlIlII.getHeldItem(lllllllllllllIllIIIlIIIllIlIIIll);
        if (!lllllllllllllIllIIIlIIIllIIllllI.func_190926_b() && lllllllllllllIllIIIlIIIllIIlIlII.canPlayerEdit(lllllllllllllIllIIIlIIIllIlIIlII.offset(lllllllllllllIllIIIlIIIllIlIIIlI), lllllllllllllIllIIIlIIIllIlIIIlI, lllllllllllllIllIIIlIIIllIIllllI)) {
            final Comparable<?> lllllllllllllIllIIIlIIIllIIlllIl = this.singleSlab.getTypeForItem(lllllllllllllIllIIIlIIIllIIllllI);
            final IBlockState lllllllllllllIllIIIlIIIllIIlllII = lllllllllllllIllIIIlIIIllIlIIlIl.getBlockState(lllllllllllllIllIIIlIIIllIlIIlII);
            if (lllllllllllllIllIIIlIIIllIIlllII.getBlock() == this.singleSlab) {
                final IProperty<?> lllllllllllllIllIIIlIIIllIIllIll = this.singleSlab.getVariantProperty();
                final Comparable<?> lllllllllllllIllIIIlIIIllIIllIlI = lllllllllllllIllIIIlIIIllIIlllII.getValue(lllllllllllllIllIIIlIIIllIIllIll);
                final BlockSlab.EnumBlockHalf lllllllllllllIllIIIlIIIllIIllIIl = lllllllllllllIllIIIlIIIllIIlllII.getValue(BlockSlab.HALF);
                if (((lllllllllllllIllIIIlIIIllIlIIIlI == EnumFacing.UP && lllllllllllllIllIIIlIIIllIIllIIl == BlockSlab.EnumBlockHalf.BOTTOM) || (lllllllllllllIllIIIlIIIllIlIIIlI == EnumFacing.DOWN && lllllllllllllIllIIIlIIIllIIllIIl == BlockSlab.EnumBlockHalf.TOP)) && lllllllllllllIllIIIlIIIllIIllIlI == lllllllllllllIllIIIlIIIllIIlllIl) {
                    final IBlockState lllllllllllllIllIIIlIIIllIIllIII = this.makeState(lllllllllllllIllIIIlIIIllIIllIll, lllllllllllllIllIIIlIIIllIIllIlI);
                    final AxisAlignedBB lllllllllllllIllIIIlIIIllIIlIlll = lllllllllllllIllIIIlIIIllIIllIII.getCollisionBoundingBox(lllllllllllllIllIIIlIIIllIlIIlIl, lllllllllllllIllIIIlIIIllIlIIlII);
                    if (lllllllllllllIllIIIlIIIllIIlIlll != Block.NULL_AABB && lllllllllllllIllIIIlIIIllIlIIlIl.checkNoEntityCollision(lllllllllllllIllIIIlIIIllIIlIlll.offset(lllllllllllllIllIIIlIIIllIlIIlII)) && lllllllllllllIllIIIlIIIllIlIIlIl.setBlockState(lllllllllllllIllIIIlIIIllIlIIlII, lllllllllllllIllIIIlIIIllIIllIII, 11)) {
                        final SoundType lllllllllllllIllIIIlIIIllIIlIllI = this.doubleSlab.getSoundType();
                        lllllllllllllIllIIIlIIIllIlIIlIl.playSound(lllllllllllllIllIIIlIIIllIIlIlII, lllllllllllllIllIIIlIIIllIlIIlII, lllllllllllllIllIIIlIIIllIIlIllI.getPlaceSound(), SoundCategory.BLOCKS, (lllllllllllllIllIIIlIIIllIIlIllI.getVolume() + 1.0f) / 2.0f, lllllllllllllIllIIIlIIIllIIlIllI.getPitch() * 0.8f);
                        lllllllllllllIllIIIlIIIllIIllllI.func_190918_g(1);
                        if (lllllllllllllIllIIIlIIIllIIlIlII instanceof EntityPlayerMP) {
                            CriteriaTriggers.field_193137_x.func_193173_a((EntityPlayerMP)lllllllllllllIllIIIlIIIllIIlIlII, lllllllllllllIllIIIlIIIllIlIIlII, lllllllllllllIllIIIlIIIllIIllllI);
                        }
                    }
                    return EnumActionResult.SUCCESS;
                }
            }
            return this.tryPlace(lllllllllllllIllIIIlIIIllIIlIlII, lllllllllllllIllIIIlIIIllIIllllI, lllllllllllllIllIIIlIIIllIlIIlIl, lllllllllllllIllIIIlIIIllIlIIlII.offset(lllllllllllllIllIIIlIIIllIlIIIlI), lllllllllllllIllIIIlIIIllIIlllIl) ? EnumActionResult.SUCCESS : super.onItemUse(lllllllllllllIllIIIlIIIllIIlIlII, lllllllllllllIllIIIlIIIllIlIIlIl, lllllllllllllIllIIIlIIIllIlIIlII, lllllllllllllIllIIIlIIIllIlIIIll, lllllllllllllIllIIIlIIIllIlIIIlI, lllllllllllllIllIIIlIIIllIlIIIIl, lllllllllllllIllIIIlIIIllIlIIIII, lllllllllllllIllIIIlIIIllIIlllll);
        }
        return EnumActionResult.FAIL;
    }
    
    public ItemSlab(final Block lllllllllllllIllIIIlIIIlllIIlIlI, final BlockSlab lllllllllllllIllIIIlIIIlllIIIlIl, final BlockSlab lllllllllllllIllIIIlIIIlllIIIlII) {
        super(lllllllllllllIllIIIlIIIlllIIlIlI);
        this.singleSlab = lllllllllllllIllIIIlIIIlllIIIlIl;
        this.doubleSlab = lllllllllllllIllIIIlIIIlllIIIlII;
        this.setMaxDamage(0);
        this.setHasSubtypes(true);
    }
    
    @Override
    public boolean canPlaceBlockOnSide(final World lllllllllllllIllIIIlIIIlIlllIlll, BlockPos lllllllllllllIllIIIlIIIlIlllIllI, final EnumFacing lllllllllllllIllIIIlIIIlIlllIlIl, final EntityPlayer lllllllllllllIllIIIlIIIlIlllIlII, final ItemStack lllllllllllllIllIIIlIIIlIlllIIll) {
        final BlockPos lllllllllllllIllIIIlIIIlIlllIIlI = lllllllllllllIllIIIlIIIlIlllIllI;
        final IProperty<?> lllllllllllllIllIIIlIIIlIlllIIIl = this.singleSlab.getVariantProperty();
        final Comparable<?> lllllllllllllIllIIIlIIIlIlllIIII = this.singleSlab.getTypeForItem(lllllllllllllIllIIIlIIIlIlllIIll);
        final IBlockState lllllllllllllIllIIIlIIIlIllIllll = lllllllllllllIllIIIlIIIlIlllIlll.getBlockState(lllllllllllllIllIIIlIIIlIlllIllI);
        if (lllllllllllllIllIIIlIIIlIllIllll.getBlock() == this.singleSlab) {
            final boolean lllllllllllllIllIIIlIIIlIllIlllI = lllllllllllllIllIIIlIIIlIllIllll.getValue(BlockSlab.HALF) == BlockSlab.EnumBlockHalf.TOP;
            if (((lllllllllllllIllIIIlIIIlIlllIlIl == EnumFacing.UP && !lllllllllllllIllIIIlIIIlIllIlllI) || (lllllllllllllIllIIIlIIIlIlllIlIl == EnumFacing.DOWN && lllllllllllllIllIIIlIIIlIllIlllI)) && lllllllllllllIllIIIlIIIlIlllIIII == lllllllllllllIllIIIlIIIlIllIllll.getValue(lllllllllllllIllIIIlIIIlIlllIIIl)) {
                return true;
            }
        }
        lllllllllllllIllIIIlIIIlIlllIllI = lllllllllllllIllIIIlIIIlIlllIllI.offset(lllllllllllllIllIIIlIIIlIlllIlIl);
        final IBlockState lllllllllllllIllIIIlIIIlIllIllIl = lllllllllllllIllIIIlIIIlIlllIlll.getBlockState(lllllllllllllIllIIIlIIIlIlllIllI);
        return (lllllllllllllIllIIIlIIIlIllIllIl.getBlock() == this.singleSlab && lllllllllllllIllIIIlIIIlIlllIIII == lllllllllllllIllIIIlIIIlIllIllIl.getValue(lllllllllllllIllIIIlIIIlIlllIIIl)) || super.canPlaceBlockOnSide(lllllllllllllIllIIIlIIIlIlllIlll, lllllllllllllIllIIIlIIIlIlllIIlI, lllllllllllllIllIIIlIIIlIlllIlIl, lllllllllllllIllIIIlIIIlIlllIlII, lllllllllllllIllIIIlIIIlIlllIIll);
    }
    
    @Override
    public String getUnlocalizedName(final ItemStack lllllllllllllIllIIIlIIIllIllllII) {
        return this.singleSlab.getUnlocalizedName(lllllllllllllIllIIIlIIIllIllllII.getMetadata());
    }
}
