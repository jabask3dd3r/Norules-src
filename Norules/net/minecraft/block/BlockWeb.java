package net.minecraft.block;

import net.minecraft.entity.*;
import net.minecraft.entity.player.*;
import net.minecraft.tileentity.*;
import javax.annotation.*;
import net.minecraft.init.*;
import net.minecraft.stats.*;
import net.minecraft.item.*;
import net.minecraft.block.material.*;
import net.minecraft.creativetab.*;
import java.util.*;
import net.minecraft.world.*;
import net.minecraft.util.math.*;
import net.minecraft.util.*;
import net.minecraft.block.state.*;

public class BlockWeb extends Block
{
    @Override
    public void onEntityCollidedWithBlock(final World llllllllllllllIIIlIIIlIllIllIllI, final BlockPos llllllllllllllIIIlIIIlIllIllIlIl, final IBlockState llllllllllllllIIIlIIIlIllIllIlII, final Entity llllllllllllllIIIlIIIlIllIllIIll) {
        llllllllllllllIIIlIIIlIllIllIIll.setInWeb();
    }
    
    @Override
    public void harvestBlock(final World llllllllllllllIIIlIIIlIllIIllIll, final EntityPlayer llllllllllllllIIIlIIIlIllIIlIIll, final BlockPos llllllllllllllIIIlIIIlIllIIllIIl, final IBlockState llllllllllllllIIIlIIIlIllIIllIII, @Nullable final TileEntity llllllllllllllIIIlIIIlIllIIlIIII, final ItemStack llllllllllllllIIIlIIIlIllIIlIllI) {
        if (!llllllllllllllIIIlIIIlIllIIllIll.isRemote && llllllllllllllIIIlIIIlIllIIlIllI.getItem() == Items.SHEARS) {
            llllllllllllllIIIlIIIlIllIIlIIll.addStat(StatList.getBlockStats(this));
            Block.spawnAsEntity(llllllllllllllIIIlIIIlIllIIllIll, llllllllllllllIIIlIIIlIllIIllIIl, new ItemStack(Item.getItemFromBlock(this), 1));
        }
        else {
            super.harvestBlock(llllllllllllllIIIlIIIlIllIIllIll, llllllllllllllIIIlIIIlIllIIlIIll, llllllllllllllIIIlIIIlIllIIllIIl, llllllllllllllIIIlIIIlIllIIllIII, llllllllllllllIIIlIIIlIllIIlIIII, llllllllllllllIIIlIIIlIllIIlIllI);
        }
    }
    
    @Override
    public BlockRenderLayer getBlockLayer() {
        return BlockRenderLayer.CUTOUT;
    }
    
    public BlockWeb() {
        super(Material.WEB);
        this.setCreativeTab(CreativeTabs.DECORATIONS);
    }
    
    @Override
    public Item getItemDropped(final IBlockState llllllllllllllIIIlIIIlIllIlIlIII, final Random llllllllllllllIIIlIIIlIllIlIIlll, final int llllllllllllllIIIlIIIlIllIlIIllI) {
        return Items.STRING;
    }
    
    @Override
    public boolean isFullCube(final IBlockState llllllllllllllIIIlIIIlIllIlIlIlI) {
        return false;
    }
    
    @Nullable
    @Override
    public AxisAlignedBB getCollisionBoundingBox(final IBlockState llllllllllllllIIIlIIIlIllIlIlllI, final IBlockAccess llllllllllllllIIIlIIIlIllIlIllIl, final BlockPos llllllllllllllIIIlIIIlIllIlIllII) {
        return BlockWeb.NULL_AABB;
    }
    
    @Override
    protected boolean canSilkHarvest() {
        return true;
    }
    
    @Override
    public BlockFaceShape func_193383_a(final IBlockAccess llllllllllllllIIIlIIIlIllIIIllIl, final IBlockState llllllllllllllIIIlIIIlIllIIIllII, final BlockPos llllllllllllllIIIlIIIlIllIIIlIll, final EnumFacing llllllllllllllIIIlIIIlIllIIIlIlI) {
        return BlockFaceShape.UNDEFINED;
    }
    
    @Override
    public boolean isOpaqueCube(final IBlockState llllllllllllllIIIlIIIlIllIllIIII) {
        return false;
    }
}
