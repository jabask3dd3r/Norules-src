package net.minecraft.item;

import net.minecraft.world.*;
import net.minecraft.util.math.*;
import net.minecraft.init.*;
import net.minecraft.block.properties.*;
import net.minecraft.entity.player.*;
import net.minecraft.advancements.*;
import net.minecraft.block.state.*;
import net.minecraft.block.*;
import net.minecraft.tileentity.*;
import net.minecraft.creativetab.*;
import net.minecraft.util.*;

public class ItemBed extends Item
{
    @Override
    public EnumActionResult onItemUse(final EntityPlayer lllllllllllllIIIllIIlIIllIIlIIlI, final World lllllllllllllIIIllIIlIIlIllllIlI, BlockPos lllllllllllllIIIllIIlIIlIllllIIl, final EnumHand lllllllllllllIIIllIIlIIllIIIllll, final EnumFacing lllllllllllllIIIllIIlIIlIlllIlll, final float lllllllllllllIIIllIIlIIllIIIllIl, final float lllllllllllllIIIllIIlIIllIIIllII, final float lllllllllllllIIIllIIlIIllIIIlIll) {
        if (lllllllllllllIIIllIIlIIlIllllIlI.isRemote) {
            return EnumActionResult.SUCCESS;
        }
        if (lllllllllllllIIIllIIlIIlIlllIlll != EnumFacing.UP) {
            return EnumActionResult.FAIL;
        }
        final IBlockState lllllllllllllIIIllIIlIIllIIIlIlI = lllllllllllllIIIllIIlIIlIllllIlI.getBlockState((BlockPos)lllllllllllllIIIllIIlIIlIllllIIl);
        final Block lllllllllllllIIIllIIlIIllIIIlIIl = lllllllllllllIIIllIIlIIllIIIlIlI.getBlock();
        final boolean lllllllllllllIIIllIIlIIllIIIlIII = lllllllllllllIIIllIIlIIllIIIlIIl.isReplaceable(lllllllllllllIIIllIIlIIlIllllIlI, (BlockPos)lllllllllllllIIIllIIlIIlIllllIIl);
        if (!lllllllllllllIIIllIIlIIllIIIlIII) {
            lllllllllllllIIIllIIlIIlIllllIIl = ((BlockPos)lllllllllllllIIIllIIlIIlIllllIIl).up();
        }
        final int lllllllllllllIIIllIIlIIllIIIIlll = MathHelper.floor(lllllllllllllIIIllIIlIIllIIlIIlI.rotationYaw * 4.0f / 360.0f + 0.5) & 0x3;
        final EnumFacing lllllllllllllIIIllIIlIIllIIIIllI = EnumFacing.getHorizontal(lllllllllllllIIIllIIlIIllIIIIlll);
        final BlockPos lllllllllllllIIIllIIlIIllIIIIlIl = ((BlockPos)lllllllllllllIIIllIIlIIlIllllIIl).offset(lllllllllllllIIIllIIlIIllIIIIllI);
        final ItemStack lllllllllllllIIIllIIlIIllIIIIlII = lllllllllllllIIIllIIlIIllIIlIIlI.getHeldItem(lllllllllllllIIIllIIlIIllIIIllll);
        if (!lllllllllllllIIIllIIlIIllIIlIIlI.canPlayerEdit((BlockPos)lllllllllllllIIIllIIlIIlIllllIIl, lllllllllllllIIIllIIlIIlIlllIlll, lllllllllllllIIIllIIlIIllIIIIlII) || !lllllllllllllIIIllIIlIIllIIlIIlI.canPlayerEdit(lllllllllllllIIIllIIlIIllIIIIlIl, lllllllllllllIIIllIIlIIlIlllIlll, lllllllllllllIIIllIIlIIllIIIIlII)) {
            return EnumActionResult.FAIL;
        }
        final IBlockState lllllllllllllIIIllIIlIIllIIIIIll = lllllllllllllIIIllIIlIIlIllllIlI.getBlockState(lllllllllllllIIIllIIlIIllIIIIlIl);
        final boolean lllllllllllllIIIllIIlIIllIIIIIlI = lllllllllllllIIIllIIlIIllIIIIIll.getBlock().isReplaceable(lllllllllllllIIIllIIlIIlIllllIlI, lllllllllllllIIIllIIlIIllIIIIlIl);
        final boolean lllllllllllllIIIllIIlIIllIIIIIIl = lllllllllllllIIIllIIlIIllIIIlIII || lllllllllllllIIIllIIlIIlIllllIlI.isAirBlock((BlockPos)lllllllllllllIIIllIIlIIlIllllIIl);
        final boolean lllllllllllllIIIllIIlIIllIIIIIII = lllllllllllllIIIllIIlIIllIIIIIlI || lllllllllllllIIIllIIlIIlIllllIlI.isAirBlock(lllllllllllllIIIllIIlIIllIIIIlIl);
        if (lllllllllllllIIIllIIlIIllIIIIIIl && lllllllllllllIIIllIIlIIllIIIIIII && lllllllllllllIIIllIIlIIlIllllIlI.getBlockState(((BlockPos)lllllllllllllIIIllIIlIIlIllllIIl).down()).isFullyOpaque() && lllllllllllllIIIllIIlIIlIllllIlI.getBlockState(lllllllllllllIIIllIIlIIllIIIIlIl.down()).isFullyOpaque()) {
            final IBlockState lllllllllllllIIIllIIlIIlIlllllll = Blocks.BED.getDefaultState().withProperty((IProperty<Comparable>)BlockBed.OCCUPIED, false).withProperty((IProperty<Comparable>)BlockBed.FACING, lllllllllllllIIIllIIlIIllIIIIllI).withProperty(BlockBed.PART, BlockBed.EnumPartType.FOOT);
            lllllllllllllIIIllIIlIIlIllllIlI.setBlockState((BlockPos)lllllllllllllIIIllIIlIIlIllllIIl, lllllllllllllIIIllIIlIIlIlllllll, 10);
            lllllllllllllIIIllIIlIIlIllllIlI.setBlockState(lllllllllllllIIIllIIlIIllIIIIlIl, lllllllllllllIIIllIIlIIlIlllllll.withProperty(BlockBed.PART, BlockBed.EnumPartType.HEAD), 10);
            final SoundType lllllllllllllIIIllIIlIIlIllllllI = lllllllllllllIIIllIIlIIlIlllllll.getBlock().getSoundType();
            lllllllllllllIIIllIIlIIlIllllIlI.playSound(null, (BlockPos)lllllllllllllIIIllIIlIIlIllllIIl, lllllllllllllIIIllIIlIIlIllllllI.getPlaceSound(), SoundCategory.BLOCKS, (lllllllllllllIIIllIIlIIlIllllllI.getVolume() + 1.0f) / 2.0f, lllllllllllllIIIllIIlIIlIllllllI.getPitch() * 0.8f);
            final TileEntity lllllllllllllIIIllIIlIIlIlllllIl = lllllllllllllIIIllIIlIIlIllllIlI.getTileEntity(lllllllllllllIIIllIIlIIllIIIIlIl);
            if (lllllllllllllIIIllIIlIIlIlllllIl instanceof TileEntityBed) {
                ((TileEntityBed)lllllllllllllIIIllIIlIIlIlllllIl).func_193051_a(lllllllllllllIIIllIIlIIllIIIIlII);
            }
            final TileEntity lllllllllllllIIIllIIlIIlIlllllII = lllllllllllllIIIllIIlIIlIllllIlI.getTileEntity((BlockPos)lllllllllllllIIIllIIlIIlIllllIIl);
            if (lllllllllllllIIIllIIlIIlIlllllII instanceof TileEntityBed) {
                ((TileEntityBed)lllllllllllllIIIllIIlIIlIlllllII).func_193051_a(lllllllllllllIIIllIIlIIllIIIIlII);
            }
            lllllllllllllIIIllIIlIIlIllllIlI.notifyNeighborsRespectDebug((BlockPos)lllllllllllllIIIllIIlIIlIllllIIl, lllllllllllllIIIllIIlIIllIIIlIIl, false);
            lllllllllllllIIIllIIlIIlIllllIlI.notifyNeighborsRespectDebug(lllllllllllllIIIllIIlIIllIIIIlIl, lllllllllllllIIIllIIlIIllIIIIIll.getBlock(), false);
            if (lllllllllllllIIIllIIlIIllIIlIIlI instanceof EntityPlayerMP) {
                CriteriaTriggers.field_193137_x.func_193173_a((EntityPlayerMP)lllllllllllllIIIllIIlIIllIIlIIlI, (BlockPos)lllllllllllllIIIllIIlIIlIllllIIl, lllllllllllllIIIllIIlIIllIIIIlII);
            }
            lllllllllllllIIIllIIlIIllIIIIlII.func_190918_g(1);
            return EnumActionResult.SUCCESS;
        }
        return EnumActionResult.FAIL;
    }
    
    @Override
    public String getUnlocalizedName(final ItemStack lllllllllllllIIIllIIlIIlIllIIIlI) {
        return String.valueOf(new StringBuilder(String.valueOf(super.getUnlocalizedName())).append(".").append(EnumDyeColor.byMetadata(lllllllllllllIIIllIIlIIlIllIIIlI.getMetadata()).getUnlocalizedName()));
    }
    
    @Override
    public void getSubItems(final CreativeTabs lllllllllllllIIIllIIlIIlIlIlllII, final NonNullList<ItemStack> lllllllllllllIIIllIIlIIlIlIlIlll) {
        if (this.func_194125_a(lllllllllllllIIIllIIlIIlIlIlllII)) {
            for (int lllllllllllllIIIllIIlIIlIlIllIlI = 0; lllllllllllllIIIllIIlIIlIlIllIlI < 16; ++lllllllllllllIIIllIIlIIlIlIllIlI) {
                lllllllllllllIIIllIIlIIlIlIlIlll.add(new ItemStack(this, 1, lllllllllllllIIIllIIlIIlIlIllIlI));
            }
        }
    }
    
    public ItemBed() {
        this.setCreativeTab(CreativeTabs.DECORATIONS);
        this.setMaxDamage(0);
        this.setHasSubtypes(true);
    }
}
