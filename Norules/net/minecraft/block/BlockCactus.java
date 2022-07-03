package net.minecraft.block;

import net.minecraft.util.math.*;
import net.minecraft.entity.*;
import net.minecraft.world.*;
import net.minecraft.block.material.*;
import net.minecraft.init.*;
import net.minecraft.block.properties.*;
import net.minecraft.creativetab.*;
import java.util.*;
import net.minecraft.block.state.*;
import net.minecraft.util.*;

public class BlockCactus extends Block
{
    public static final /* synthetic */ PropertyInteger AGE;
    protected static final /* synthetic */ AxisAlignedBB CACTUS_AABB;
    protected static final /* synthetic */ AxisAlignedBB CACTUS_COLLISION_AABB;
    
    @Override
    public void neighborChanged(final IBlockState lllllllllllllIIIIIllIllIIllIIIll, final World lllllllllllllIIIIIllIllIIlIlllIl, final BlockPos lllllllllllllIIIIIllIllIIllIIIIl, final Block lllllllllllllIIIIIllIllIIllIIIII, final BlockPos lllllllllllllIIIIIllIllIIlIlllll) {
        if (!this.canBlockStay(lllllllllllllIIIIIllIllIIlIlllIl, lllllllllllllIIIIIllIllIIllIIIIl)) {
            lllllllllllllIIIIIllIllIIlIlllIl.destroyBlock(lllllllllllllIIIIIllIllIIllIIIIl, true);
        }
    }
    
    @Override
    public AxisAlignedBB getSelectedBoundingBox(final IBlockState lllllllllllllIIIIIllIllIIllllIII, final World lllllllllllllIIIIIllIllIIlllIlll, final BlockPos lllllllllllllIIIIIllIllIIlllIlIl) {
        return BlockCactus.CACTUS_AABB.offset(lllllllllllllIIIIIllIllIIlllIlIl);
    }
    
    @Override
    public void onEntityCollidedWithBlock(final World lllllllllllllIIIIIllIllIIlIIlIIl, final BlockPos lllllllllllllIIIIIllIllIIlIIlIII, final IBlockState lllllllllllllIIIIIllIllIIlIIIlll, final Entity lllllllllllllIIIIIllIllIIlIIIlIl) {
        lllllllllllllIIIIIllIllIIlIIIlIl.attackEntityFrom(DamageSource.cactus, 1.0f);
    }
    
    @Override
    public AxisAlignedBB getCollisionBoundingBox(final IBlockState lllllllllllllIIIIIllIllIIlllllIl, final IBlockAccess lllllllllllllIIIIIllIllIIlllllII, final BlockPos lllllllllllllIIIIIllIllIIllllIll) {
        return BlockCactus.CACTUS_COLLISION_AABB;
    }
    
    @Override
    public BlockFaceShape func_193383_a(final IBlockAccess lllllllllllllIIIIIllIllIIIllIlIl, final IBlockState lllllllllllllIIIIIllIllIIIllIlII, final BlockPos lllllllllllllIIIIIllIllIIIllIIll, final EnumFacing lllllllllllllIIIIIllIllIIIllIIlI) {
        return BlockFaceShape.UNDEFINED;
    }
    
    public boolean canBlockStay(final World lllllllllllllIIIIIllIllIIlIlIIII, final BlockPos lllllllllllllIIIIIllIllIIlIIllll) {
        for (final EnumFacing lllllllllllllIIIIIllIllIIlIlIIll : EnumFacing.Plane.HORIZONTAL) {
            final Material lllllllllllllIIIIIllIllIIlIlIIlI = lllllllllllllIIIIIllIllIIlIlIIII.getBlockState(lllllllllllllIIIIIllIllIIlIIllll.offset(lllllllllllllIIIIIllIllIIlIlIIll)).getMaterial();
            if (lllllllllllllIIIIIllIllIIlIlIIlI.isSolid() || lllllllllllllIIIIIllIllIIlIlIIlI == Material.LAVA) {
                return false;
            }
        }
        final Block lllllllllllllIIIIIllIllIIlIlIIIl = lllllllllllllIIIIIllIllIIlIlIIII.getBlockState(lllllllllllllIIIIIllIllIIlIIllll.down()).getBlock();
        return lllllllllllllIIIIIllIllIIlIlIIIl == Blocks.CACTUS || (lllllllllllllIIIIIllIllIIlIlIIIl == Blocks.SAND && !lllllllllllllIIIIIllIllIIlIlIIII.getBlockState(lllllllllllllIIIIIllIllIIlIIllll.up()).getMaterial().isLiquid());
    }
    
    @Override
    public boolean isFullCube(final IBlockState lllllllllllllIIIIIllIllIIlllIIll) {
        return false;
    }
    
    static {
        AGE = PropertyInteger.create("age", 0, 15);
        CACTUS_COLLISION_AABB = new AxisAlignedBB(0.0625, 0.0, 0.0625, 0.9375, 0.9375, 0.9375);
        CACTUS_AABB = new AxisAlignedBB(0.0625, 0.0, 0.0625, 0.9375, 1.0, 0.9375);
    }
    
    protected BlockCactus() {
        super(Material.CACTUS);
        this.setDefaultState(this.blockState.getBaseState().withProperty((IProperty<Comparable>)BlockCactus.AGE, 0));
        this.setTickRandomly(true);
        this.setCreativeTab(CreativeTabs.DECORATIONS);
    }
    
    @Override
    public boolean canPlaceBlockAt(final World lllllllllllllIIIIIllIllIIllIlIIl, final BlockPos lllllllllllllIIIIIllIllIIllIlIII) {
        return super.canPlaceBlockAt(lllllllllllllIIIIIllIllIIllIlIIl, lllllllllllllIIIIIllIllIIllIlIII) && this.canBlockStay(lllllllllllllIIIIIllIllIIllIlIIl, lllllllllllllIIIIIllIllIIllIlIII);
    }
    
    @Override
    public void updateTick(final World lllllllllllllIIIIIllIllIlIIIIlIl, final BlockPos lllllllllllllIIIIIllIllIlIIIIlII, final IBlockState lllllllllllllIIIIIllIllIlIIIIIll, final Random lllllllllllllIIIIIllIllIlIIIlIll) {
        final BlockPos lllllllllllllIIIIIllIllIlIIIlIlI = lllllllllllllIIIIIllIllIlIIIIlII.up();
        if (lllllllllllllIIIIIllIllIlIIIIlIl.isAirBlock(lllllllllllllIIIIIllIllIlIIIlIlI)) {
            int lllllllllllllIIIIIllIllIlIIIlIIl;
            for (lllllllllllllIIIIIllIllIlIIIlIIl = 1; lllllllllllllIIIIIllIllIlIIIIlIl.getBlockState(lllllllllllllIIIIIllIllIlIIIIlII.down(lllllllllllllIIIIIllIllIlIIIlIIl)).getBlock() == this; ++lllllllllllllIIIIIllIllIlIIIlIIl) {}
            if (lllllllllllllIIIIIllIllIlIIIlIIl < 3) {
                final int lllllllllllllIIIIIllIllIlIIIlIII = lllllllllllllIIIIIllIllIlIIIIIll.getValue((IProperty<Integer>)BlockCactus.AGE);
                if (lllllllllllllIIIIIllIllIlIIIlIII == 15) {
                    lllllllllllllIIIIIllIllIlIIIIlIl.setBlockState(lllllllllllllIIIIIllIllIlIIIlIlI, this.getDefaultState());
                    final IBlockState lllllllllllllIIIIIllIllIlIIIIlll = lllllllllllllIIIIIllIllIlIIIIIll.withProperty((IProperty<Comparable>)BlockCactus.AGE, 0);
                    lllllllllllllIIIIIllIllIlIIIIlIl.setBlockState(lllllllllllllIIIIIllIllIlIIIIlII, lllllllllllllIIIIIllIllIlIIIIlll, 4);
                    lllllllllllllIIIIIllIllIlIIIIlll.neighborChanged(lllllllllllllIIIIIllIllIlIIIIlIl, lllllllllllllIIIIIllIllIlIIIlIlI, this, lllllllllllllIIIIIllIllIlIIIIlII);
                }
                else {
                    lllllllllllllIIIIIllIllIlIIIIlIl.setBlockState(lllllllllllllIIIIIllIllIlIIIIlII, lllllllllllllIIIIIllIllIlIIIIIll.withProperty((IProperty<Comparable>)BlockCactus.AGE, lllllllllllllIIIIIllIllIlIIIlIII + 1), 4);
                }
            }
        }
    }
    
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, (IProperty<?>[])new IProperty[] { BlockCactus.AGE });
    }
    
    @Override
    public IBlockState getStateFromMeta(final int lllllllllllllIIIIIllIllIIIlllllI) {
        return this.getDefaultState().withProperty((IProperty<Comparable>)BlockCactus.AGE, lllllllllllllIIIIIllIllIIIlllllI);
    }
    
    @Override
    public BlockRenderLayer getBlockLayer() {
        return BlockRenderLayer.CUTOUT;
    }
    
    @Override
    public int getMetaFromState(final IBlockState lllllllllllllIIIIIllIllIIIlllIll) {
        return lllllllllllllIIIIIllIllIIIlllIll.getValue((IProperty<Integer>)BlockCactus.AGE);
    }
    
    @Override
    public boolean isOpaqueCube(final IBlockState lllllllllllllIIIIIllIllIIlllIIIl) {
        return false;
    }
}
