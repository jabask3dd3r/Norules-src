package net.minecraft.block;

import net.minecraft.block.properties.*;
import net.minecraft.block.state.*;
import java.util.*;
import net.minecraft.util.*;
import net.minecraft.block.material.*;
import net.minecraft.world.*;
import net.minecraft.item.*;
import net.minecraft.init.*;
import javax.annotation.*;
import net.minecraft.creativetab.*;
import net.minecraft.util.math.*;

public class BlockStem extends BlockBush implements IGrowable
{
    public static final /* synthetic */ PropertyDirection FACING;
    public static final /* synthetic */ PropertyInteger AGE;
    protected static final /* synthetic */ AxisAlignedBB[] STEM_AABB;
    private final /* synthetic */ Block crop;
    
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, (IProperty<?>[])new IProperty[] { BlockStem.AGE, BlockStem.FACING });
    }
    
    @Override
    public boolean canGrow(final World lllllllllllllllIlIlIlIllIIlIlIlI, final BlockPos lllllllllllllllIlIlIlIllIIlIlIIl, final IBlockState lllllllllllllllIlIlIlIllIIlIIllI, final boolean lllllllllllllllIlIlIlIllIIlIIlll) {
        return lllllllllllllllIlIlIlIllIIlIIllI.getValue((IProperty<Integer>)BlockStem.AGE) != 7;
    }
    
    @Override
    public IBlockState getStateFromMeta(final int lllllllllllllllIlIlIlIllIIIIllIl) {
        return this.getDefaultState().withProperty((IProperty<Comparable>)BlockStem.AGE, lllllllllllllllIlIlIlIllIIIIllIl);
    }
    
    @Override
    public void updateTick(final World lllllllllllllllIlIlIlIlllIIIIlll, BlockPos lllllllllllllllIlIlIlIlllIIIIllI, IBlockState lllllllllllllllIlIlIlIlllIIIIlIl, final Random lllllllllllllllIlIlIlIlllIIIIlII) {
        super.updateTick(lllllllllllllllIlIlIlIlllIIIIlll, lllllllllllllllIlIlIlIlllIIIIllI, lllllllllllllllIlIlIlIlllIIIIlIl, lllllllllllllllIlIlIlIlllIIIIlII);
        if (lllllllllllllllIlIlIlIlllIIIIlll.getLightFromNeighbors(lllllllllllllllIlIlIlIlllIIIIllI.up()) >= 9) {
            final float lllllllllllllllIlIlIlIlllIIIllII = BlockCrops.getGrowthChance(this, lllllllllllllllIlIlIlIlllIIIIlll, lllllllllllllllIlIlIlIlllIIIIllI);
            if (lllllllllllllllIlIlIlIlllIIIIlII.nextInt((int)(25.0f / lllllllllllllllIlIlIlIlllIIIllII) + 1) == 0) {
                final int lllllllllllllllIlIlIlIlllIIIlIll = lllllllllllllllIlIlIlIlllIIIIlIl.getValue((IProperty<Integer>)BlockStem.AGE);
                if (lllllllllllllllIlIlIlIlllIIIlIll < 7) {
                    lllllllllllllllIlIlIlIlllIIIIlIl = lllllllllllllllIlIlIlIlllIIIIlIl.withProperty((IProperty<Comparable>)BlockStem.AGE, lllllllllllllllIlIlIlIlllIIIlIll + 1);
                    lllllllllllllllIlIlIlIlllIIIIlll.setBlockState(lllllllllllllllIlIlIlIlllIIIIllI, lllllllllllllllIlIlIlIlllIIIIlIl, 2);
                }
                else {
                    for (final EnumFacing lllllllllllllllIlIlIlIlllIIIlIlI : EnumFacing.Plane.HORIZONTAL) {
                        if (lllllllllllllllIlIlIlIlllIIIIlll.getBlockState(lllllllllllllllIlIlIlIlllIIIIllI.offset(lllllllllllllllIlIlIlIlllIIIlIlI)).getBlock() == this.crop) {
                            return;
                        }
                    }
                    lllllllllllllllIlIlIlIlllIIIIllI = lllllllllllllllIlIlIlIlllIIIIllI.offset(EnumFacing.Plane.HORIZONTAL.random(lllllllllllllllIlIlIlIlllIIIIlII));
                    final Block lllllllllllllllIlIlIlIlllIIIlIIl = lllllllllllllllIlIlIlIlllIIIIlll.getBlockState(lllllllllllllllIlIlIlIlllIIIIllI.down()).getBlock();
                    if (lllllllllllllllIlIlIlIlllIIIIlll.getBlockState(lllllllllllllllIlIlIlIlllIIIIllI).getBlock().blockMaterial == Material.AIR && (lllllllllllllllIlIlIlIlllIIIlIIl == Blocks.FARMLAND || lllllllllllllllIlIlIlIlllIIIlIIl == Blocks.DIRT || lllllllllllllllIlIlIlIlllIIIlIIl == Blocks.GRASS)) {
                        lllllllllllllllIlIlIlIlllIIIIlll.setBlockState(lllllllllllllllIlIlIlIlllIIIIllI, this.crop.getDefaultState());
                    }
                }
            }
        }
    }
    
    @Override
    public void grow(final World lllllllllllllllIlIlIlIllIIIllIll, final Random lllllllllllllllIlIlIlIllIIIllIlI, final BlockPos lllllllllllllllIlIlIlIllIIIlIlIl, final IBlockState lllllllllllllllIlIlIlIllIIIlIlII) {
        this.growStem(lllllllllllllllIlIlIlIllIIIllIll, lllllllllllllllIlIlIlIllIIIlIlIl, lllllllllllllllIlIlIlIllIIIlIlII);
    }
    
    @Override
    public IBlockState getActualState(IBlockState lllllllllllllllIlIlIlIlllIlIlIlI, final IBlockAccess lllllllllllllllIlIlIlIlllIlIIIll, final BlockPos lllllllllllllllIlIlIlIlllIlIlIII) {
        final int lllllllllllllllIlIlIlIlllIlIIlll = lllllllllllllllIlIlIlIlllIlIlIlI.getValue((IProperty<Integer>)BlockStem.AGE);
        lllllllllllllllIlIlIlIlllIlIlIlI = lllllllllllllllIlIlIlIlllIlIlIlI.withProperty((IProperty<Comparable>)BlockStem.FACING, EnumFacing.UP);
        for (final EnumFacing lllllllllllllllIlIlIlIlllIlIIllI : EnumFacing.Plane.HORIZONTAL) {
            if (lllllllllllllllIlIlIlIlllIlIIIll.getBlockState(lllllllllllllllIlIlIlIlllIlIlIII.offset(lllllllllllllllIlIlIlIlllIlIIllI)).getBlock() == this.crop && lllllllllllllllIlIlIlIlllIlIIlll == 7) {
                lllllllllllllllIlIlIlIlllIlIlIlI = lllllllllllllllIlIlIlIlllIlIlIlI.withProperty((IProperty<Comparable>)BlockStem.FACING, lllllllllllllllIlIlIlIlllIlIIllI);
                break;
            }
        }
        return lllllllllllllllIlIlIlIlllIlIlIlI;
    }
    
    @Override
    public AxisAlignedBB getBoundingBox(final IBlockState lllllllllllllllIlIlIlIlllIllIllI, final IBlockAccess lllllllllllllllIlIlIlIlllIllIlIl, final BlockPos lllllllllllllllIlIlIlIlllIllIlII) {
        return BlockStem.STEM_AABB[lllllllllllllllIlIlIlIlllIllIllI.getValue((IProperty<Integer>)BlockStem.AGE)];
    }
    
    @Override
    public boolean canUseBonemeal(final World lllllllllllllllIlIlIlIllIIlIIlII, final Random lllllllllllllllIlIlIlIllIIlIIIll, final BlockPos lllllllllllllllIlIlIlIllIIlIIIlI, final IBlockState lllllllllllllllIlIlIlIllIIlIIIIl) {
        return true;
    }
    
    @Override
    public ItemStack getItem(final World lllllllllllllllIlIlIlIllIIllIIlI, final BlockPos lllllllllllllllIlIlIlIllIIllIIIl, final IBlockState lllllllllllllllIlIlIlIllIIllIIII) {
        final Item lllllllllllllllIlIlIlIllIIlIllll = this.getSeedItem();
        return (lllllllllllllllIlIlIlIllIIlIllll == null) ? ItemStack.field_190927_a : new ItemStack(lllllllllllllllIlIlIlIllIIlIllll);
    }
    
    @Nullable
    protected Item getSeedItem() {
        if (this.crop == Blocks.PUMPKIN) {
            return Items.PUMPKIN_SEEDS;
        }
        return (this.crop == Blocks.MELON_BLOCK) ? Items.MELON_SEEDS : null;
    }
    
    @Override
    public Item getItemDropped(final IBlockState lllllllllllllllIlIlIlIllIIlllllI, final Random lllllllllllllllIlIlIlIllIIllllII, final int lllllllllllllllIlIlIlIllIIlllIlI) {
        return Items.field_190931_a;
    }
    
    @Override
    public int getMetaFromState(final IBlockState lllllllllllllllIlIlIlIllIIIIIllI) {
        return lllllllllllllllIlIlIlIllIIIIIllI.getValue((IProperty<Integer>)BlockStem.AGE);
    }
    
    protected BlockStem(final Block lllllllllllllllIlIlIlIlllIlllIll) {
        this.setDefaultState(this.blockState.getBaseState().withProperty((IProperty<Comparable>)BlockStem.AGE, 0).withProperty((IProperty<Comparable>)BlockStem.FACING, EnumFacing.UP));
        this.crop = lllllllllllllllIlIlIlIlllIlllIll;
        this.setTickRandomly(true);
        this.setCreativeTab(null);
    }
    
    static {
        AGE = PropertyInteger.create("age", 0, 7);
        FACING = BlockTorch.FACING;
        STEM_AABB = new AxisAlignedBB[] { new AxisAlignedBB(0.375, 0.0, 0.375, 0.625, 0.125, 0.625), new AxisAlignedBB(0.375, 0.0, 0.375, 0.625, 0.25, 0.625), new AxisAlignedBB(0.375, 0.0, 0.375, 0.625, 0.375, 0.625), new AxisAlignedBB(0.375, 0.0, 0.375, 0.625, 0.5, 0.625), new AxisAlignedBB(0.375, 0.0, 0.375, 0.625, 0.625, 0.625), new AxisAlignedBB(0.375, 0.0, 0.375, 0.625, 0.75, 0.625), new AxisAlignedBB(0.375, 0.0, 0.375, 0.625, 0.875, 0.625), new AxisAlignedBB(0.375, 0.0, 0.375, 0.625, 1.0, 0.625) };
    }
    
    @Override
    public void dropBlockAsItemWithChance(final World lllllllllllllllIlIlIlIllIlIlIIII, final BlockPos lllllllllllllllIlIlIlIllIlIlllll, final IBlockState lllllllllllllllIlIlIlIllIlIIlllI, final float lllllllllllllllIlIlIlIllIlIllIll, final int lllllllllllllllIlIlIlIllIlIIllII) {
        super.dropBlockAsItemWithChance(lllllllllllllllIlIlIlIllIlIlIIII, lllllllllllllllIlIlIlIllIlIlllll, lllllllllllllllIlIlIlIllIlIIlllI, lllllllllllllllIlIlIlIllIlIllIll, lllllllllllllllIlIlIlIllIlIIllII);
        if (!lllllllllllllllIlIlIlIllIlIlIIII.isRemote) {
            final Item lllllllllllllllIlIlIlIllIlIlIlll = this.getSeedItem();
            if (lllllllllllllllIlIlIlIllIlIlIlll != null) {
                final int lllllllllllllllIlIlIlIllIlIlIlIl = lllllllllllllllIlIlIlIllIlIIlllI.getValue((IProperty<Integer>)BlockStem.AGE);
                for (int lllllllllllllllIlIlIlIllIlIlIIll = 0; lllllllllllllllIlIlIlIllIlIlIIll < 3; ++lllllllllllllllIlIlIlIllIlIlIIll) {
                    if (lllllllllllllllIlIlIlIllIlIlIIII.rand.nextInt(15) <= lllllllllllllllIlIlIlIllIlIlIlIl) {
                        Block.spawnAsEntity(lllllllllllllllIlIlIlIllIlIlIIII, lllllllllllllllIlIlIlIllIlIlllll, new ItemStack(lllllllllllllllIlIlIlIllIlIlIlll));
                    }
                }
            }
        }
    }
    
    @Override
    protected boolean canSustainBush(final IBlockState lllllllllllllllIlIlIlIlllIIlllII) {
        return lllllllllllllllIlIlIlIlllIIlllII.getBlock() == Blocks.FARMLAND;
    }
    
    public void growStem(final World lllllllllllllllIlIlIlIllIlllIllI, final BlockPos lllllllllllllllIlIlIlIllIlllIlIl, final IBlockState lllllllllllllllIlIlIlIllIlllIlII) {
        final int lllllllllllllllIlIlIlIllIlllIlll = lllllllllllllllIlIlIlIllIlllIlII.getValue((IProperty<Integer>)BlockStem.AGE) + MathHelper.getInt(lllllllllllllllIlIlIlIllIlllIllI.rand, 2, 5);
        lllllllllllllllIlIlIlIllIlllIllI.setBlockState(lllllllllllllllIlIlIlIllIlllIlIl, lllllllllllllllIlIlIlIllIlllIlII.withProperty((IProperty<Comparable>)BlockStem.AGE, Math.min(7, lllllllllllllllIlIlIlIllIlllIlll)), 2);
    }
}
