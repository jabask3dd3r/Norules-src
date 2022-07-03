package net.minecraft.item;

import net.minecraft.util.*;
import net.minecraft.world.*;
import net.minecraft.init.*;
import net.minecraft.util.math.*;
import net.minecraft.block.properties.*;
import net.minecraft.block.*;
import net.minecraft.entity.player.*;
import net.minecraft.advancements.*;
import net.minecraft.block.state.*;
import net.minecraft.tileentity.*;
import net.minecraft.creativetab.*;

public class ItemSign extends Item
{
    @Override
    public EnumActionResult onItemUse(final EntityPlayer llllllllllllllIllIIIIIIIlllllIII, final World llllllllllllllIllIIIIIIIlllIlIlI, BlockPos llllllllllllllIllIIIIIIIllllIllI, final EnumHand llllllllllllllIllIIIIIIIlllIlIII, final EnumFacing llllllllllllllIllIIIIIIIllllIlII, final float llllllllllllllIllIIIIIIIllllIIll, final float llllllllllllllIllIIIIIIIllllIIlI, final float llllllllllllllIllIIIIIIIllllIIIl) {
        final IBlockState llllllllllllllIllIIIIIIIllllIIII = llllllllllllllIllIIIIIIIlllIlIlI.getBlockState(llllllllllllllIllIIIIIIIllllIllI);
        final boolean llllllllllllllIllIIIIIIIlllIllll = llllllllllllllIllIIIIIIIllllIIII.getBlock().isReplaceable(llllllllllllllIllIIIIIIIlllIlIlI, llllllllllllllIllIIIIIIIllllIllI);
        if (llllllllllllllIllIIIIIIIllllIlII == EnumFacing.DOWN || (!llllllllllllllIllIIIIIIIllllIIII.getMaterial().isSolid() && !llllllllllllllIllIIIIIIIlllIllll) || (llllllllllllllIllIIIIIIIlllIllll && llllllllllllllIllIIIIIIIllllIlII != EnumFacing.UP)) {
            return EnumActionResult.FAIL;
        }
        llllllllllllllIllIIIIIIIllllIllI = llllllllllllllIllIIIIIIIllllIllI.offset(llllllllllllllIllIIIIIIIllllIlII);
        final ItemStack llllllllllllllIllIIIIIIIlllIlllI = llllllllllllllIllIIIIIIIlllllIII.getHeldItem(llllllllllllllIllIIIIIIIlllIlIII);
        if (!llllllllllllllIllIIIIIIIlllllIII.canPlayerEdit(llllllllllllllIllIIIIIIIllllIllI, llllllllllllllIllIIIIIIIllllIlII, llllllllllllllIllIIIIIIIlllIlllI) || !Blocks.STANDING_SIGN.canPlaceBlockAt(llllllllllllllIllIIIIIIIlllIlIlI, llllllllllllllIllIIIIIIIllllIllI)) {
            return EnumActionResult.FAIL;
        }
        if (llllllllllllllIllIIIIIIIlllIlIlI.isRemote) {
            return EnumActionResult.SUCCESS;
        }
        llllllllllllllIllIIIIIIIllllIllI = (llllllllllllllIllIIIIIIIlllIllll ? llllllllllllllIllIIIIIIIllllIllI.down() : llllllllllllllIllIIIIIIIllllIllI);
        if (llllllllllllllIllIIIIIIIllllIlII == EnumFacing.UP) {
            final int llllllllllllllIllIIIIIIIlllIllIl = MathHelper.floor((llllllllllllllIllIIIIIIIlllllIII.rotationYaw + 180.0f) * 16.0f / 360.0f + 0.5) & 0xF;
            llllllllllllllIllIIIIIIIlllIlIlI.setBlockState(llllllllllllllIllIIIIIIIllllIllI, Blocks.STANDING_SIGN.getDefaultState().withProperty((IProperty<Comparable>)BlockStandingSign.ROTATION, llllllllllllllIllIIIIIIIlllIllIl), 11);
        }
        else {
            llllllllllllllIllIIIIIIIlllIlIlI.setBlockState(llllllllllllllIllIIIIIIIllllIllI, Blocks.WALL_SIGN.getDefaultState().withProperty((IProperty<Comparable>)BlockWallSign.FACING, llllllllllllllIllIIIIIIIllllIlII), 11);
        }
        final TileEntity llllllllllllllIllIIIIIIIlllIllII = llllllllllllllIllIIIIIIIlllIlIlI.getTileEntity(llllllllllllllIllIIIIIIIllllIllI);
        if (llllllllllllllIllIIIIIIIlllIllII instanceof TileEntitySign && !ItemBlock.setTileEntityNBT(llllllllllllllIllIIIIIIIlllIlIlI, llllllllllllllIllIIIIIIIlllllIII, llllllllllllllIllIIIIIIIllllIllI, llllllllllllllIllIIIIIIIlllIlllI)) {
            llllllllllllllIllIIIIIIIlllllIII.openEditSign((TileEntitySign)llllllllllllllIllIIIIIIIlllIllII);
        }
        if (llllllllllllllIllIIIIIIIlllllIII instanceof EntityPlayerMP) {
            CriteriaTriggers.field_193137_x.func_193173_a((EntityPlayerMP)llllllllllllllIllIIIIIIIlllllIII, llllllllllllllIllIIIIIIIllllIllI, llllllllllllllIllIIIIIIIlllIlllI);
        }
        llllllllllllllIllIIIIIIIlllIlllI.func_190918_g(1);
        return EnumActionResult.SUCCESS;
    }
    
    public ItemSign() {
        this.maxStackSize = 16;
        this.setCreativeTab(CreativeTabs.DECORATIONS);
    }
}
