package net.minecraft.block;

import net.minecraft.block.properties.*;
import net.minecraft.util.math.*;
import net.minecraft.world.*;
import net.minecraft.init.*;
import java.util.*;
import net.minecraft.entity.player.*;
import net.minecraft.stats.*;
import net.minecraft.util.*;
import net.minecraft.block.material.*;
import net.minecraft.block.state.*;
import net.minecraft.item.*;

public class BlockCake extends Block
{
    protected static final /* synthetic */ AxisAlignedBB[] CAKE_AABB;
    public static final /* synthetic */ PropertyInteger BITES;
    
    @Override
    public int getMetaFromState(final IBlockState lllllllllllllIlIIllIllIlIlllIIII) {
        return lllllllllllllIlIIllIllIlIlllIIII.getValue((IProperty<Integer>)BlockCake.BITES);
    }
    
    @Override
    public AxisAlignedBB getBoundingBox(final IBlockState lllllllllllllIlIIllIllIlllIIllIl, final IBlockAccess lllllllllllllIlIIllIllIlllIIllll, final BlockPos lllllllllllllIlIIllIllIlllIIlllI) {
        return BlockCake.CAKE_AABB[lllllllllllllIlIIllIllIlllIIllIl.getValue((IProperty<Integer>)BlockCake.BITES)];
    }
    
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, (IProperty<?>[])new IProperty[] { BlockCake.BITES });
    }
    
    @Override
    public boolean isOpaqueCube(final IBlockState lllllllllllllIlIIllIllIlllIIlIIl) {
        return false;
    }
    
    @Override
    public ItemStack getItem(final World lllllllllllllIlIIllIllIlIlllllII, final BlockPos lllllllllllllIlIIllIllIlIllllIll, final IBlockState lllllllllllllIlIIllIllIlIllllIlI) {
        return new ItemStack(Items.CAKE);
    }
    
    @Override
    public int quantityDropped(final Random lllllllllllllIlIIllIllIllIIIIIlI) {
        return 0;
    }
    
    @Override
    public BlockRenderLayer getBlockLayer() {
        return BlockRenderLayer.CUTOUT;
    }
    
    @Override
    public void neighborChanged(final IBlockState lllllllllllllIlIIllIllIllIIlIIlI, final World lllllllllllllIlIIllIllIllIIlIIIl, final BlockPos lllllllllllllIlIIllIllIllIIlIIII, final Block lllllllllllllIlIIllIllIllIIIllll, final BlockPos lllllllllllllIlIIllIllIllIIIlllI) {
        if (!this.canBlockStay(lllllllllllllIlIIllIllIllIIlIIIl, lllllllllllllIlIIllIllIllIIlIIII)) {
            lllllllllllllIlIIllIllIllIIlIIIl.setBlockToAir(lllllllllllllIlIIllIllIllIIlIIII);
        }
    }
    
    private boolean eatCake(final World lllllllllllllIlIIllIllIllIlIlIIl, final BlockPos lllllllllllllIlIIllIllIllIlIlIII, final IBlockState lllllllllllllIlIIllIllIllIlIIIlI, final EntityPlayer lllllllllllllIlIIllIllIllIlIIllI) {
        if (!lllllllllllllIlIIllIllIllIlIIllI.canEat(false)) {
            return false;
        }
        lllllllllllllIlIIllIllIllIlIIllI.addStat(StatList.CAKE_SLICES_EATEN);
        lllllllllllllIlIIllIllIllIlIIllI.getFoodStats().addStats(2, 0.1f);
        final int lllllllllllllIlIIllIllIllIlIIlIl = lllllllllllllIlIIllIllIllIlIIIlI.getValue((IProperty<Integer>)BlockCake.BITES);
        if (lllllllllllllIlIIllIllIllIlIIlIl < 6) {
            lllllllllllllIlIIllIllIllIlIlIIl.setBlockState(lllllllllllllIlIIllIllIllIlIlIII, lllllllllllllIlIIllIllIllIlIIIlI.withProperty((IProperty<Comparable>)BlockCake.BITES, lllllllllllllIlIIllIllIllIlIIlIl + 1), 3);
        }
        else {
            lllllllllllllIlIIllIllIllIlIlIIl.setBlockToAir(lllllllllllllIlIIllIllIllIlIlIII);
        }
        return true;
    }
    
    private boolean canBlockStay(final World lllllllllllllIlIIllIllIllIIIIlIl, final BlockPos lllllllllllllIlIIllIllIllIIIIllI) {
        return lllllllllllllIlIIllIllIllIIIIlIl.getBlockState(lllllllllllllIlIIllIllIllIIIIllI.down()).getMaterial().isSolid();
    }
    
    static {
        BITES = PropertyInteger.create("bites", 0, 6);
        CAKE_AABB = new AxisAlignedBB[] { new AxisAlignedBB(0.0625, 0.0, 0.0625, 0.9375, 0.5, 0.9375), new AxisAlignedBB(0.1875, 0.0, 0.0625, 0.9375, 0.5, 0.9375), new AxisAlignedBB(0.3125, 0.0, 0.0625, 0.9375, 0.5, 0.9375), new AxisAlignedBB(0.4375, 0.0, 0.0625, 0.9375, 0.5, 0.9375), new AxisAlignedBB(0.5625, 0.0, 0.0625, 0.9375, 0.5, 0.9375), new AxisAlignedBB(0.6875, 0.0, 0.0625, 0.9375, 0.5, 0.9375), new AxisAlignedBB(0.8125, 0.0, 0.0625, 0.9375, 0.5, 0.9375) };
    }
    
    @Override
    public boolean isFullCube(final IBlockState lllllllllllllIlIIllIllIlllIIlIll) {
        return false;
    }
    
    @Override
    public int getComparatorInputOverride(final IBlockState lllllllllllllIlIIllIllIlIllIlIIl, final World lllllllllllllIlIIllIllIlIllIlIII, final BlockPos lllllllllllllIlIIllIllIlIllIIlll) {
        return (7 - lllllllllllllIlIIllIllIlIllIlIIl.getValue((IProperty<Integer>)BlockCake.BITES)) * 2;
    }
    
    @Override
    public IBlockState getStateFromMeta(final int lllllllllllllIlIIllIllIlIlllIlIl) {
        return this.getDefaultState().withProperty((IProperty<Comparable>)BlockCake.BITES, lllllllllllllIlIIllIllIlIlllIlIl);
    }
    
    @Override
    public boolean onBlockActivated(final World lllllllllllllIlIIllIllIlllIIIIII, final BlockPos lllllllllllllIlIIllIllIllIllllll, final IBlockState lllllllllllllIlIIllIllIllIlllllI, final EntityPlayer lllllllllllllIlIIllIllIllIllIIlI, final EnumHand lllllllllllllIlIIllIllIllIllIIIl, final EnumFacing lllllllllllllIlIIllIllIllIlllIll, final float lllllllllllllIlIIllIllIllIlllIlI, final float lllllllllllllIlIIllIllIllIlllIIl, final float lllllllllllllIlIIllIllIllIlllIII) {
        if (!lllllllllllllIlIIllIllIlllIIIIII.isRemote) {
            return this.eatCake(lllllllllllllIlIIllIllIlllIIIIII, lllllllllllllIlIIllIllIllIllllll, lllllllllllllIlIIllIllIllIlllllI, lllllllllllllIlIIllIllIllIllIIlI);
        }
        final ItemStack lllllllllllllIlIIllIllIllIllIlll = lllllllllllllIlIIllIllIllIllIIlI.getHeldItem(lllllllllllllIlIIllIllIllIllIIIl);
        return this.eatCake(lllllllllllllIlIIllIllIlllIIIIII, lllllllllllllIlIIllIllIllIllllll, lllllllllllllIlIIllIllIllIlllllI, lllllllllllllIlIIllIllIllIllIIlI) || lllllllllllllIlIIllIllIllIllIlll.func_190926_b();
    }
    
    @Override
    public boolean canPlaceBlockAt(final World lllllllllllllIlIIllIllIllIIllIll, final BlockPos lllllllllllllIlIIllIllIllIIlIlll) {
        return super.canPlaceBlockAt(lllllllllllllIlIIllIllIllIIllIll, lllllllllllllIlIIllIllIllIIlIlll) && this.canBlockStay(lllllllllllllIlIIllIllIllIIllIll, lllllllllllllIlIIllIllIllIIlIlll);
    }
    
    protected BlockCake() {
        super(Material.CAKE);
        this.setDefaultState(this.blockState.getBaseState().withProperty((IProperty<Comparable>)BlockCake.BITES, 0));
        this.setTickRandomly(true);
    }
    
    @Override
    public BlockFaceShape func_193383_a(final IBlockAccess lllllllllllllIlIIllIllIlIllIIIlI, final IBlockState lllllllllllllIlIIllIllIlIllIIIIl, final BlockPos lllllllllllllIlIIllIllIlIllIIIII, final EnumFacing lllllllllllllIlIIllIllIlIlIlllll) {
        return BlockFaceShape.UNDEFINED;
    }
    
    @Override
    public boolean hasComparatorInputOverride(final IBlockState lllllllllllllIlIIllIllIlIllIIlII) {
        return true;
    }
    
    @Override
    public Item getItemDropped(final IBlockState lllllllllllllIlIIllIllIllIIIIIII, final Random lllllllllllllIlIIllIllIlIlllllll, final int lllllllllllllIlIIllIllIlIllllllI) {
        return Items.field_190931_a;
    }
}
