package net.minecraft.block;

import java.util.*;
import net.minecraft.block.properties.*;
import net.minecraft.util.math.*;
import net.minecraft.item.*;
import net.minecraft.world.*;
import net.minecraft.block.state.*;
import net.minecraft.creativetab.*;
import net.minecraft.init.*;

public class BlockCrops extends BlockBush implements IGrowable
{
    private static final /* synthetic */ AxisAlignedBB[] CROPS_AABB;
    public static final /* synthetic */ PropertyInteger AGE;
    
    @Override
    public void updateTick(final World lllIlllIIIIlIII, final BlockPos lllIlllIIIIIIII, final IBlockState lllIlllIIIIIllI, final Random lllIllIlllllllI) {
        super.updateTick(lllIlllIIIIlIII, lllIlllIIIIIIII, lllIlllIIIIIllI, lllIllIlllllllI);
        if (lllIlllIIIIlIII.getLightFromNeighbors(lllIlllIIIIIIII.up()) >= 9) {
            final int lllIlllIIIIIlII = this.getAge(lllIlllIIIIIllI);
            if (lllIlllIIIIIlII < this.getMaxAge()) {
                final float lllIlllIIIIIIll = getGrowthChance(this, lllIlllIIIIlIII, lllIlllIIIIIIII);
                if (lllIllIlllllllI.nextInt((int)(25.0f / lllIlllIIIIIIll) + 1) == 0) {
                    lllIlllIIIIlIII.setBlockState(lllIlllIIIIIIII, this.withAge(lllIlllIIIIIlII + 1), 2);
                }
            }
        }
    }
    
    static {
        AGE = PropertyInteger.create("age", 0, 7);
        CROPS_AABB = new AxisAlignedBB[] { new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 0.125, 1.0), new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 0.25, 1.0), new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 0.375, 1.0), new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 0.5, 1.0), new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 0.625, 1.0), new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 0.75, 1.0), new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 0.875, 1.0), new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 1.0, 1.0) };
    }
    
    @Override
    public int getMetaFromState(final IBlockState lllIllIIllIIIlI) {
        return this.getAge(lllIllIIllIIIlI);
    }
    
    protected int getAge(final IBlockState lllIlllIIIlllll) {
        return lllIlllIIIlllll.getValue((IProperty<Integer>)this.getAgeProperty());
    }
    
    @Override
    public ItemStack getItem(final World lllIllIlIIIllII, final BlockPos lllIllIlIIIlIll, final IBlockState lllIllIlIIIlIlI) {
        return new ItemStack(this.getSeed());
    }
    
    protected int getBonemealAgeIncrease(final World lllIllIlllIIlll) {
        return MathHelper.getInt(lllIllIlllIIlll.rand, 2, 5);
    }
    
    protected PropertyInteger getAgeProperty() {
        return BlockCrops.AGE;
    }
    
    @Override
    public boolean canGrow(final World lllIllIlIIIIlIl, final BlockPos lllIllIlIIIIlII, final IBlockState lllIllIlIIIIIll, final boolean lllIllIlIIIIIlI) {
        return !this.isMaxAge(lllIllIlIIIIIll);
    }
    
    @Override
    public boolean canBlockStay(final World lllIllIlIllIlIl, final BlockPos lllIllIlIllIlII, final IBlockState lllIllIlIllIlll) {
        return (lllIllIlIllIlIl.getLight(lllIllIlIllIlII) >= 8 || lllIllIlIllIlIl.canSeeSky(lllIllIlIllIlII)) && this.canSustainBush(lllIllIlIllIlIl.getBlockState(lllIllIlIllIlII.down()));
    }
    
    protected Item getCrop() {
        return Items.WHEAT;
    }
    
    @Override
    public AxisAlignedBB getBoundingBox(final IBlockState lllIlllIIlIlIIl, final IBlockAccess lllIlllIIlIllII, final BlockPos lllIlllIIlIlIll) {
        return BlockCrops.CROPS_AABB[lllIlllIIlIlIIl.getValue((IProperty<Integer>)this.getAgeProperty())];
    }
    
    public boolean isMaxAge(final IBlockState lllIlllIIIlIIll) {
        return lllIlllIIIlIIll.getValue((IProperty<Integer>)this.getAgeProperty()) >= this.getMaxAge();
    }
    
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, (IProperty<?>[])new IProperty[] { BlockCrops.AGE });
    }
    
    protected Item getSeed() {
        return Items.WHEAT_SEEDS;
    }
    
    protected BlockCrops() {
        this.setDefaultState(this.blockState.getBaseState().withProperty((IProperty<Comparable>)this.getAgeProperty(), 0));
        this.setTickRandomly(true);
        this.setCreativeTab(null);
        this.setHardness(0.0f);
        this.setSoundType(SoundType.PLANT);
        this.disableStats();
    }
    
    @Override
    public void grow(final World lllIllIIlllIIII, final Random lllIllIIlllIlII, final BlockPos lllIllIIlllIIll, final IBlockState lllIllIIlllIIlI) {
        this.grow(lllIllIIlllIIII, lllIllIIlllIIll, lllIllIIlllIIlI);
    }
    
    @Override
    public IBlockState getStateFromMeta(final int lllIllIIllIlIlI) {
        return this.withAge(lllIllIIllIlIlI);
    }
    
    public int getMaxAge() {
        return 7;
    }
    
    @Override
    protected boolean canSustainBush(final IBlockState lllIlllIIlIIlIl) {
        return lllIlllIIlIIlIl.getBlock() == Blocks.FARMLAND;
    }
    
    public IBlockState withAge(final int lllIlllIIIllIIl) {
        return this.getDefaultState().withProperty((IProperty<Comparable>)this.getAgeProperty(), lllIlllIIIllIIl);
    }
    
    @Override
    public void dropBlockAsItemWithChance(final World lllIllIlIIllllI, final BlockPos lllIllIlIlIIllI, final IBlockState lllIllIlIlIIlIl, final float lllIllIlIlIIlII, final int lllIllIlIlIIIll) {
        super.dropBlockAsItemWithChance(lllIllIlIIllllI, lllIllIlIlIIllI, lllIllIlIlIIlIl, lllIllIlIlIIlII, 0);
        if (!lllIllIlIIllllI.isRemote) {
            final int lllIllIlIlIIIlI = this.getAge(lllIllIlIlIIlIl);
            if (lllIllIlIlIIIlI >= this.getMaxAge()) {
                for (int lllIllIlIlIIIIl = 3 + lllIllIlIlIIIll, lllIllIlIlIIIII = 0; lllIllIlIlIIIII < lllIllIlIlIIIIl; ++lllIllIlIlIIIII) {
                    if (lllIllIlIIllllI.rand.nextInt(2 * this.getMaxAge()) <= lllIllIlIlIIIlI) {
                        Block.spawnAsEntity(lllIllIlIIllllI, lllIllIlIlIIllI, new ItemStack(this.getSeed()));
                    }
                }
            }
        }
    }
    
    protected static float getGrowthChance(final Block lllIllIllIIlIIl, final World lllIllIllIIlIII, final BlockPos lllIllIllIlIlll) {
        float lllIllIllIlIllI = 1.0f;
        final BlockPos lllIllIllIlIlIl = lllIllIllIlIlll.down();
        for (int lllIllIllIlIlII = -1; lllIllIllIlIlII <= 1; ++lllIllIllIlIlII) {
            for (int lllIllIllIlIIll = -1; lllIllIllIlIIll <= 1; ++lllIllIllIlIIll) {
                float lllIllIllIlIIlI = 0.0f;
                final IBlockState lllIllIllIlIIIl = lllIllIllIIlIII.getBlockState(lllIllIllIlIlIl.add(lllIllIllIlIlII, 0, lllIllIllIlIIll));
                if (lllIllIllIlIIIl.getBlock() == Blocks.FARMLAND) {
                    lllIllIllIlIIlI = 1.0f;
                    if (lllIllIllIlIIIl.getValue((IProperty<Integer>)BlockFarmland.MOISTURE) > 0) {
                        lllIllIllIlIIlI = 3.0f;
                    }
                }
                if (lllIllIllIlIlII != 0 || lllIllIllIlIIll != 0) {
                    lllIllIllIlIIlI /= 4.0f;
                }
                lllIllIllIlIllI += lllIllIllIlIIlI;
            }
        }
        final BlockPos lllIllIllIlIIII = lllIllIllIlIlll.north();
        final BlockPos lllIllIllIIllll = lllIllIllIlIlll.south();
        final BlockPos lllIllIllIIlllI = lllIllIllIlIlll.west();
        final BlockPos lllIllIllIIllIl = lllIllIllIlIlll.east();
        final boolean lllIllIllIIllII = lllIllIllIIlIIl == lllIllIllIIlIII.getBlockState(lllIllIllIIlllI).getBlock() || lllIllIllIIlIIl == lllIllIllIIlIII.getBlockState(lllIllIllIIllIl).getBlock();
        final boolean lllIllIllIIlIll = lllIllIllIIlIIl == lllIllIllIIlIII.getBlockState(lllIllIllIlIIII).getBlock() || lllIllIllIIlIIl == lllIllIllIIlIII.getBlockState(lllIllIllIIllll).getBlock();
        if (lllIllIllIIllII && lllIllIllIIlIll) {
            lllIllIllIlIllI /= 2.0f;
        }
        else {
            final boolean lllIllIllIIlIlI = lllIllIllIIlIIl == lllIllIllIIlIII.getBlockState(lllIllIllIIlllI.north()).getBlock() || lllIllIllIIlIIl == lllIllIllIIlIII.getBlockState(lllIllIllIIllIl.north()).getBlock() || lllIllIllIIlIIl == lllIllIllIIlIII.getBlockState(lllIllIllIIllIl.south()).getBlock() || lllIllIllIIlIIl == lllIllIllIIlIII.getBlockState(lllIllIllIIlllI.south()).getBlock();
            if (lllIllIllIIlIlI) {
                lllIllIllIlIllI /= 2.0f;
            }
        }
        return lllIllIllIlIllI;
    }
    
    @Override
    public Item getItemDropped(final IBlockState lllIllIlIIlIIll, final Random lllIllIlIIlIIlI, final int lllIllIlIIlIIIl) {
        return this.isMaxAge(lllIllIlIIlIIll) ? this.getCrop() : this.getSeed();
    }
    
    public void grow(final World lllIllIllllIlII, final BlockPos lllIllIllllIIll, final IBlockState lllIllIllllIIlI) {
        int lllIllIllllIIIl = this.getAge(lllIllIllllIIlI) + this.getBonemealAgeIncrease(lllIllIllllIlII);
        final int lllIllIllllIIII = this.getMaxAge();
        if (lllIllIllllIIIl > lllIllIllllIIII) {
            lllIllIllllIIIl = lllIllIllllIIII;
        }
        lllIllIllllIlII.setBlockState(lllIllIllllIIll, this.withAge(lllIllIllllIIIl), 2);
    }
    
    @Override
    public boolean canUseBonemeal(final World lllIllIIllllllI, final Random lllIllIIlllllIl, final BlockPos lllIllIIlllllII, final IBlockState lllIllIIllllIll) {
        return true;
    }
}
