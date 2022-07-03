package net.minecraft.item;

import net.minecraft.entity.player.*;
import net.minecraft.util.math.*;
import net.minecraft.world.*;
import net.minecraft.util.*;
import net.minecraft.block.state.*;
import net.minecraft.block.*;
import net.minecraft.block.properties.*;
import net.minecraft.creativetab.*;

public class ItemDoor extends Item
{
    private final /* synthetic */ Block block;
    
    @Override
    public EnumActionResult onItemUse(final EntityPlayer lllllllllllllllIllIIllIIIIllllII, final World lllllllllllllllIllIIllIIIIlllIll, BlockPos lllllllllllllllIllIIllIIIIlIlIIl, final EnumHand lllllllllllllllIllIIllIIIIlllIIl, final EnumFacing lllllllllllllllIllIIllIIIIlIIlll, final float lllllllllllllllIllIIllIIIIllIlll, final float lllllllllllllllIllIIllIIIIllIllI, final float lllllllllllllllIllIIllIIIIlIIlIl) {
        if (lllllllllllllllIllIIllIIIIlIIlll != EnumFacing.UP) {
            return EnumActionResult.FAIL;
        }
        final IBlockState lllllllllllllllIllIIllIIIIllIlII = lllllllllllllllIllIIllIIIIlllIll.getBlockState(lllllllllllllllIllIIllIIIIlIlIIl);
        final Block lllllllllllllllIllIIllIIIIllIIll = lllllllllllllllIllIIllIIIIllIlII.getBlock();
        if (!lllllllllllllllIllIIllIIIIllIIll.isReplaceable(lllllllllllllllIllIIllIIIIlllIll, lllllllllllllllIllIIllIIIIlIlIIl)) {
            lllllllllllllllIllIIllIIIIlIlIIl = lllllllllllllllIllIIllIIIIlIlIIl.offset(lllllllllllllllIllIIllIIIIlIIlll);
        }
        final ItemStack lllllllllllllllIllIIllIIIIllIIlI = lllllllllllllllIllIIllIIIIllllII.getHeldItem(lllllllllllllllIllIIllIIIIlllIIl);
        if (lllllllllllllllIllIIllIIIIllllII.canPlayerEdit(lllllllllllllllIllIIllIIIIlIlIIl, lllllllllllllllIllIIllIIIIlIIlll, lllllllllllllllIllIIllIIIIllIIlI) && this.block.canPlaceBlockAt(lllllllllllllllIllIIllIIIIlllIll, lllllllllllllllIllIIllIIIIlIlIIl)) {
            final EnumFacing lllllllllllllllIllIIllIIIIllIIIl = EnumFacing.fromAngle(lllllllllllllllIllIIllIIIIllllII.rotationYaw);
            final int lllllllllllllllIllIIllIIIIllIIII = lllllllllllllllIllIIllIIIIllIIIl.getFrontOffsetX();
            final int lllllllllllllllIllIIllIIIIlIllll = lllllllllllllllIllIIllIIIIllIIIl.getFrontOffsetZ();
            final boolean lllllllllllllllIllIIllIIIIlIlllI = (lllllllllllllllIllIIllIIIIllIIII < 0 && lllllllllllllllIllIIllIIIIlIIlIl < 0.5f) || (lllllllllllllllIllIIllIIIIllIIII > 0 && lllllllllllllllIllIIllIIIIlIIlIl > 0.5f) || (lllllllllllllllIllIIllIIIIlIllll < 0 && lllllllllllllllIllIIllIIIIllIlll > 0.5f) || (lllllllllllllllIllIIllIIIIlIllll > 0 && lllllllllllllllIllIIllIIIIllIlll < 0.5f);
            placeDoor(lllllllllllllllIllIIllIIIIlllIll, lllllllllllllllIllIIllIIIIlIlIIl, lllllllllllllllIllIIllIIIIllIIIl, this.block, lllllllllllllllIllIIllIIIIlIlllI);
            final SoundType lllllllllllllllIllIIllIIIIlIllIl = this.block.getSoundType();
            lllllllllllllllIllIIllIIIIlllIll.playSound(lllllllllllllllIllIIllIIIIllllII, lllllllllllllllIllIIllIIIIlIlIIl, lllllllllllllllIllIIllIIIIlIllIl.getPlaceSound(), SoundCategory.BLOCKS, (lllllllllllllllIllIIllIIIIlIllIl.getVolume() + 1.0f) / 2.0f, lllllllllllllllIllIIllIIIIlIllIl.getPitch() * 0.8f);
            lllllllllllllllIllIIllIIIIllIIlI.func_190918_g(1);
            return EnumActionResult.SUCCESS;
        }
        return EnumActionResult.FAIL;
    }
    
    public static void placeDoor(final World lllllllllllllllIllIIllIIIIIIIIII, final BlockPos lllllllllllllllIllIIlIllllllllll, final EnumFacing lllllllllllllllIllIIlIlllllllllI, final Block lllllllllllllllIllIIllIIIIIIlIll, boolean lllllllllllllllIllIIlIllllllllII) {
        final BlockPos lllllllllllllllIllIIllIIIIIIlIIl = lllllllllllllllIllIIlIllllllllll.offset(lllllllllllllllIllIIlIlllllllllI.rotateY());
        final BlockPos lllllllllllllllIllIIllIIIIIIlIII = lllllllllllllllIllIIlIllllllllll.offset(lllllllllllllllIllIIlIlllllllllI.rotateYCCW());
        final int lllllllllllllllIllIIllIIIIIIIlll = (lllllllllllllllIllIIllIIIIIIIIII.getBlockState(lllllllllllllllIllIIllIIIIIIlIII).isNormalCube() + lllllllllllllllIllIIllIIIIIIIIII.getBlockState(lllllllllllllllIllIIllIIIIIIlIII.up()).isNormalCube()) ? 1 : 0;
        final int lllllllllllllllIllIIllIIIIIIIllI = (lllllllllllllllIllIIllIIIIIIIIII.getBlockState(lllllllllllllllIllIIllIIIIIIlIIl).isNormalCube() + lllllllllllllllIllIIllIIIIIIIIII.getBlockState(lllllllllllllllIllIIllIIIIIIlIIl.up()).isNormalCube()) ? 1 : 0;
        final boolean lllllllllllllllIllIIllIIIIIIIlIl = lllllllllllllllIllIIllIIIIIIIIII.getBlockState(lllllllllllllllIllIIllIIIIIIlIII).getBlock() == lllllllllllllllIllIIllIIIIIIlIll || lllllllllllllllIllIIllIIIIIIIIII.getBlockState(lllllllllllllllIllIIllIIIIIIlIII.up()).getBlock() == lllllllllllllllIllIIllIIIIIIlIll;
        final boolean lllllllllllllllIllIIllIIIIIIIlII = lllllllllllllllIllIIllIIIIIIIIII.getBlockState(lllllllllllllllIllIIllIIIIIIlIIl).getBlock() == lllllllllllllllIllIIllIIIIIIlIll || lllllllllllllllIllIIllIIIIIIIIII.getBlockState(lllllllllllllllIllIIllIIIIIIlIIl.up()).getBlock() == lllllllllllllllIllIIllIIIIIIlIll;
        if ((!lllllllllllllllIllIIllIIIIIIIlIl || lllllllllllllllIllIIllIIIIIIIlII) && lllllllllllllllIllIIllIIIIIIIllI <= lllllllllllllllIllIIllIIIIIIIlll) {
            if ((lllllllllllllllIllIIllIIIIIIIlII && !lllllllllllllllIllIIllIIIIIIIlIl) || lllllllllllllllIllIIllIIIIIIIllI < lllllllllllllllIllIIllIIIIIIIlll) {
                lllllllllllllllIllIIlIllllllllII = false;
            }
        }
        else {
            lllllllllllllllIllIIlIllllllllII = true;
        }
        final BlockPos lllllllllllllllIllIIllIIIIIIIIll = lllllllllllllllIllIIlIllllllllll.up();
        final boolean lllllllllllllllIllIIllIIIIIIIIlI = lllllllllllllllIllIIllIIIIIIIIII.isBlockPowered(lllllllllllllllIllIIlIllllllllll) || lllllllllllllllIllIIllIIIIIIIIII.isBlockPowered(lllllllllllllllIllIIllIIIIIIIIll);
        final IBlockState lllllllllllllllIllIIllIIIIIIIIIl = lllllllllllllllIllIIllIIIIIIlIll.getDefaultState().withProperty((IProperty<Comparable>)BlockDoor.FACING, lllllllllllllllIllIIlIlllllllllI).withProperty(BlockDoor.HINGE, lllllllllllllllIllIIlIllllllllII ? BlockDoor.EnumHingePosition.RIGHT : BlockDoor.EnumHingePosition.LEFT).withProperty((IProperty<Comparable>)BlockDoor.POWERED, lllllllllllllllIllIIllIIIIIIIIlI).withProperty((IProperty<Comparable>)BlockDoor.OPEN, lllllllllllllllIllIIllIIIIIIIIlI);
        lllllllllllllllIllIIllIIIIIIIIII.setBlockState(lllllllllllllllIllIIlIllllllllll, lllllllllllllllIllIIllIIIIIIIIIl.withProperty(BlockDoor.HALF, BlockDoor.EnumDoorHalf.LOWER), 2);
        lllllllllllllllIllIIllIIIIIIIIII.setBlockState(lllllllllllllllIllIIllIIIIIIIIll, lllllllllllllllIllIIllIIIIIIIIIl.withProperty(BlockDoor.HALF, BlockDoor.EnumDoorHalf.UPPER), 2);
        lllllllllllllllIllIIllIIIIIIIIII.notifyNeighborsOfStateChange(lllllllllllllllIllIIlIllllllllll, lllllllllllllllIllIIllIIIIIIlIll, false);
        lllllllllllllllIllIIllIIIIIIIIII.notifyNeighborsOfStateChange(lllllllllllllllIllIIllIIIIIIIIll, lllllllllllllllIllIIllIIIIIIlIll, false);
    }
    
    public ItemDoor(final Block lllllllllllllllIllIIllIIIlIIlllI) {
        this.block = lllllllllllllllIllIIllIIIlIIlllI;
        this.setCreativeTab(CreativeTabs.REDSTONE);
    }
}
