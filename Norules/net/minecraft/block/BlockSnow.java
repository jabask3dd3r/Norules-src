package net.minecraft.block;

import net.minecraft.util.math.*;
import java.util.*;
import net.minecraft.block.properties.*;
import net.minecraft.world.*;
import net.minecraft.util.*;
import net.minecraft.block.state.*;
import net.minecraft.block.material.*;
import net.minecraft.creativetab.*;
import net.minecraft.entity.player.*;
import net.minecraft.tileentity.*;
import javax.annotation.*;
import net.minecraft.init.*;
import net.minecraft.stats.*;
import net.minecraft.item.*;

public class BlockSnow extends Block
{
    public static final /* synthetic */ PropertyInteger LAYERS;
    protected static final /* synthetic */ AxisAlignedBB[] SNOW_AABB;
    
    private boolean checkAndDropBlock(final World lllllllllllllllIlIlllIIIlIIlIIll, final BlockPos lllllllllllllllIlIlllIIIlIIlIllI, final IBlockState lllllllllllllllIlIlllIIIlIIlIlIl) {
        if (!this.canPlaceBlockAt(lllllllllllllllIlIlllIIIlIIlIIll, lllllllllllllllIlIlllIIIlIIlIllI)) {
            this.dropBlockAsItem(lllllllllllllllIlIlllIIIlIIlIIll, lllllllllllllllIlIlllIIIlIIlIllI, lllllllllllllllIlIlllIIIlIIlIlIl, 0);
            lllllllllllllllIlIlllIIIlIIlIIll.setBlockToAir(lllllllllllllllIlIlllIIIlIIlIllI);
            return false;
        }
        return true;
    }
    
    @Override
    public void updateTick(final World lllllllllllllllIlIlllIIIIlllIIII, final BlockPos lllllllllllllllIlIlllIIIIllIllll, final IBlockState lllllllllllllllIlIlllIIIIlllIIll, final Random lllllllllllllllIlIlllIIIIlllIIlI) {
        if (lllllllllllllllIlIlllIIIIlllIIII.getLightFor(EnumSkyBlock.BLOCK, lllllllllllllllIlIlllIIIIllIllll) > 11) {
            this.dropBlockAsItem(lllllllllllllllIlIlllIIIIlllIIII, lllllllllllllllIlIlllIIIIllIllll, lllllllllllllllIlIlllIIIIlllIIII.getBlockState(lllllllllllllllIlIlllIIIIllIllll), 0);
            lllllllllllllllIlIlllIIIIlllIIII.setBlockToAir(lllllllllllllllIlIlllIIIIllIllll);
        }
    }
    
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, (IProperty<?>[])new IProperty[] { BlockSnow.LAYERS });
    }
    
    @Override
    public BlockFaceShape func_193383_a(final IBlockAccess lllllllllllllllIlIlllIIIllIllIII, final IBlockState lllllllllllllllIlIlllIIIllIlIlll, final BlockPos lllllllllllllllIlIlllIIIllIlIllI, final EnumFacing lllllllllllllllIlIlllIIIllIlIlII) {
        return (lllllllllllllllIlIlllIIIllIlIlII == EnumFacing.DOWN) ? BlockFaceShape.SOLID : BlockFaceShape.UNDEFINED;
    }
    
    @Override
    public boolean isReplaceable(final IBlockAccess lllllllllllllllIlIlllIIIIlIlIIll, final BlockPos lllllllllllllllIlIlllIIIIlIlIIII) {
        return lllllllllllllllIlIlllIIIIlIlIIll.getBlockState(lllllllllllllllIlIlllIIIIlIlIIII).getValue((IProperty<Integer>)BlockSnow.LAYERS) == 1;
    }
    
    protected BlockSnow() {
        super(Material.SNOW);
        this.setDefaultState(this.blockState.getBaseState().withProperty((IProperty<Comparable>)BlockSnow.LAYERS, 1));
        this.setTickRandomly(true);
        this.setCreativeTab(CreativeTabs.DECORATIONS);
    }
    
    static {
        LAYERS = PropertyInteger.create("layers", 1, 8);
        SNOW_AABB = new AxisAlignedBB[] { new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 0.0, 1.0), new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 0.125, 1.0), new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 0.25, 1.0), new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 0.375, 1.0), new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 0.5, 1.0), new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 0.625, 1.0), new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 0.75, 1.0), new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 0.875, 1.0), new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 1.0, 1.0) };
    }
    
    @Override
    public boolean canPlaceBlockAt(final World lllllllllllllllIlIlllIIIlIllIlIl, final BlockPos lllllllllllllllIlIlllIIIlIllIlII) {
        final IBlockState lllllllllllllllIlIlllIIIlIllIIll = lllllllllllllllIlIlllIIIlIllIlIl.getBlockState(lllllllllllllllIlIlllIIIlIllIlII.down());
        final Block lllllllllllllllIlIlllIIIlIllIIlI = lllllllllllllllIlIlllIIIlIllIIll.getBlock();
        if (lllllllllllllllIlIlllIIIlIllIIlI != Blocks.ICE && lllllllllllllllIlIlllIIIlIllIIlI != Blocks.PACKED_ICE && lllllllllllllllIlIlllIIIlIllIIlI != Blocks.BARRIER) {
            final BlockFaceShape lllllllllllllllIlIlllIIIlIllIIIl = lllllllllllllllIlIlllIIIlIllIIll.func_193401_d(lllllllllllllllIlIlllIIIlIllIlIl, lllllllllllllllIlIlllIIIlIllIlII.down(), EnumFacing.UP);
            return lllllllllllllllIlIlllIIIlIllIIIl == BlockFaceShape.SOLID || lllllllllllllllIlIlllIIIlIllIIll.getMaterial() == Material.LEAVES || (lllllllllllllllIlIlllIIIlIllIIlI == this && lllllllllllllllIlIlllIIIlIllIIll.getValue((IProperty<Integer>)BlockSnow.LAYERS) == 8);
        }
        return false;
    }
    
    @Override
    public void harvestBlock(final World lllllllllllllllIlIlllIIIlIIIIIll, final EntityPlayer lllllllllllllllIlIlllIIIlIIIIIlI, final BlockPos lllllllllllllllIlIlllIIIlIIIlIII, final IBlockState lllllllllllllllIlIlllIIIlIIIIIII, @Nullable final TileEntity lllllllllllllllIlIlllIIIlIIIIllI, final ItemStack lllllllllllllllIlIlllIIIlIIIIlIl) {
        Block.spawnAsEntity(lllllllllllllllIlIlllIIIlIIIIIll, lllllllllllllllIlIlllIIIlIIIlIII, new ItemStack(Items.SNOWBALL, lllllllllllllllIlIlllIIIlIIIIIII.getValue((IProperty<Integer>)BlockSnow.LAYERS) + 1, 0));
        lllllllllllllllIlIlllIIIlIIIIIll.setBlockToAir(lllllllllllllllIlIlllIIIlIIIlIII);
        lllllllllllllllIlIlllIIIlIIIIIlI.addStat(StatList.getBlockStats(this));
    }
    
    @Override
    public void neighborChanged(final IBlockState lllllllllllllllIlIlllIIIlIlIIlIl, final World lllllllllllllllIlIlllIIIlIIllllI, final BlockPos lllllllllllllllIlIlllIIIlIIlllIl, final Block lllllllllllllllIlIlllIIIlIlIIIlI, final BlockPos lllllllllllllllIlIlllIIIlIlIIIIl) {
        this.checkAndDropBlock(lllllllllllllllIlIlllIIIlIIllllI, lllllllllllllllIlIlllIIIlIIlllIl, lllllllllllllllIlIlllIIIlIlIIlIl);
    }
    
    @Override
    public AxisAlignedBB getBoundingBox(final IBlockState lllllllllllllllIlIlllIIIlllIIllI, final IBlockAccess lllllllllllllllIlIlllIIIlllIlIII, final BlockPos lllllllllllllllIlIlllIIIlllIIlll) {
        return BlockSnow.SNOW_AABB[lllllllllllllllIlIlllIIIlllIIllI.getValue((IProperty<Integer>)BlockSnow.LAYERS)];
    }
    
    @Override
    public boolean isPassable(final IBlockAccess lllllllllllllllIlIlllIIIlllIIIlI, final BlockPos lllllllllllllllIlIlllIIIllIlllll) {
        return lllllllllllllllIlIlllIIIlllIIIlI.getBlockState(lllllllllllllllIlIlllIIIllIlllll).getValue((IProperty<Integer>)BlockSnow.LAYERS) < 5;
    }
    
    @Override
    public Item getItemDropped(final IBlockState lllllllllllllllIlIlllIIIIllllllI, final Random lllllllllllllllIlIlllIIIIlllllIl, final int lllllllllllllllIlIlllIIIIlllllII) {
        return Items.SNOWBALL;
    }
    
    @Override
    public boolean isFullyOpaque(final IBlockState lllllllllllllllIlIlllIIIllIllIll) {
        return lllllllllllllllIlIlllIIIllIllIll.getValue((IProperty<Integer>)BlockSnow.LAYERS) == 8;
    }
    
    @Override
    public boolean isFullCube(final IBlockState lllllllllllllllIlIlllIIIlIllllIl) {
        return false;
    }
    
    @Override
    public int quantityDropped(final Random lllllllllllllllIlIlllIIIIllllIlI) {
        return 0;
    }
    
    @Override
    public int getMetaFromState(final IBlockState lllllllllllllllIlIlllIIIIlIIllIl) {
        return lllllllllllllllIlIlllIIIIlIIllIl.getValue((IProperty<Integer>)BlockSnow.LAYERS) - 1;
    }
    
    @Override
    public boolean shouldSideBeRendered(final IBlockState lllllllllllllllIlIlllIIIIllIIlll, final IBlockAccess lllllllllllllllIlIlllIIIIllIIIII, final BlockPos lllllllllllllllIlIlllIIIIllIIlIl, final EnumFacing lllllllllllllllIlIlllIIIIllIIlII) {
        if (lllllllllllllllIlIlllIIIIllIIlII == EnumFacing.UP) {
            return true;
        }
        final IBlockState lllllllllllllllIlIlllIIIIllIIIll = lllllllllllllllIlIlllIIIIllIIIII.getBlockState(lllllllllllllllIlIlllIIIIllIIlIl.offset(lllllllllllllllIlIlllIIIIllIIlII));
        return (lllllllllllllllIlIlllIIIIllIIIll.getBlock() != this || lllllllllllllllIlIlllIIIIllIIIll.getValue((IProperty<Integer>)BlockSnow.LAYERS) < lllllllllllllllIlIlllIIIIllIIlll.getValue((IProperty<Integer>)BlockSnow.LAYERS)) && super.shouldSideBeRendered(lllllllllllllllIlIlllIIIIllIIlll, lllllllllllllllIlIlllIIIIllIIIII, lllllllllllllllIlIlllIIIIllIIlIl, lllllllllllllllIlIlllIIIIllIIlII);
    }
    
    @Override
    public IBlockState getStateFromMeta(final int lllllllllllllllIlIlllIIIIlIlIlll) {
        return this.getDefaultState().withProperty((IProperty<Comparable>)BlockSnow.LAYERS, (lllllllllllllllIlIlllIIIIlIlIlll & 0x7) + 1);
    }
    
    @Override
    public boolean isOpaqueCube(final IBlockState lllllllllllllllIlIlllIIIlIllllll) {
        return false;
    }
    
    @Nullable
    @Override
    public AxisAlignedBB getCollisionBoundingBox(final IBlockState lllllllllllllllIlIlllIIIllIIllII, final IBlockAccess lllllllllllllllIlIlllIIIllIIIlIl, final BlockPos lllllllllllllllIlIlllIIIllIIIlII) {
        final int lllllllllllllllIlIlllIIIllIIlIIl = lllllllllllllllIlIlllIIIllIIllII.getValue((IProperty<Integer>)BlockSnow.LAYERS) - 1;
        final float lllllllllllllllIlIlllIIIllIIlIII = 0.125f;
        final AxisAlignedBB lllllllllllllllIlIlllIIIllIIIlll = lllllllllllllllIlIlllIIIllIIllII.getBoundingBox(lllllllllllllllIlIlllIIIllIIIlIl, lllllllllllllllIlIlllIIIllIIIlII);
        return new AxisAlignedBB(lllllllllllllllIlIlllIIIllIIIlll.minX, lllllllllllllllIlIlllIIIllIIIlll.minY, lllllllllllllllIlIlllIIIllIIIlll.minZ, lllllllllllllllIlIlllIIIllIIIlll.maxX, lllllllllllllllIlIlllIIIllIIlIIl * 0.125f, lllllllllllllllIlIlllIIIllIIIlll.maxZ);
    }
}
