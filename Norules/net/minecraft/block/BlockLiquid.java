package net.minecraft.block;

import net.minecraft.block.properties.*;
import net.minecraft.block.material.*;
import net.minecraft.world.*;
import java.util.*;
import net.minecraft.util.math.*;
import javax.annotation.*;
import net.minecraft.item.*;
import net.minecraft.init.*;
import net.minecraft.entity.player.*;
import net.minecraft.entity.*;
import net.minecraft.block.state.*;
import net.minecraft.util.*;

public abstract class BlockLiquid extends Block
{
    public static final /* synthetic */ PropertyInteger LEVEL;
    
    @Override
    public boolean isOpaqueCube(final IBlockState llllllllllllllllIIlllIIlIIllIIlI) {
        return false;
    }
    
    @Override
    public int getMetaFromState(final IBlockState llllllllllllllllIIllIlllllllIlII) {
        return llllllllllllllllIIllIlllllllIlII.getValue((IProperty<Integer>)BlockLiquid.LEVEL);
    }
    
    protected BlockLiquid(final Material llllllllllllllllIIlllIIlIlIlIlIl) {
        super(llllllllllllllllIIlllIIlIlIlIlIl);
        this.setDefaultState(this.blockState.getBaseState().withProperty((IProperty<Comparable>)BlockLiquid.LEVEL, 0));
        this.setTickRandomly(true);
    }
    
    @Override
    public int quantityDropped(final Random llllllllllllllllIIlllIIIlllIlIlI) {
        return 0;
    }
    
    @Override
    public void neighborChanged(final IBlockState llllllllllllllllIIlllIIIIlIIIlII, final World llllllllllllllllIIlllIIIIIllllIl, final BlockPos llllllllllllllllIIlllIIIIlIIIIlI, final Block llllllllllllllllIIlllIIIIlIIIIIl, final BlockPos llllllllllllllllIIlllIIIIlIIIIII) {
        this.checkForMixing(llllllllllllllllIIlllIIIIIllllIl, llllllllllllllllIIlllIIIIlIIIIlI, llllllllllllllllIIlllIIIIlIIIlII);
    }
    
    protected Vec3d getFlow(final IBlockAccess llllllllllllllllIIlllIIIllIllIll, final BlockPos llllllllllllllllIIlllIIIllIllIlI, final IBlockState llllllllllllllllIIlllIIIllIIlIlI) {
        double llllllllllllllllIIlllIIIllIllIII = 0.0;
        double llllllllllllllllIIlllIIIllIlIlll = 0.0;
        double llllllllllllllllIIlllIIIllIlIllI = 0.0;
        final int llllllllllllllllIIlllIIIllIlIlIl = this.getRenderedDepth(llllllllllllllllIIlllIIIllIIlIlI);
        final BlockPos.PooledMutableBlockPos llllllllllllllllIIlllIIIllIlIlII = BlockPos.PooledMutableBlockPos.retain();
        for (final EnumFacing llllllllllllllllIIlllIIIllIlIIll : EnumFacing.Plane.HORIZONTAL) {
            llllllllllllllllIIlllIIIllIlIlII.setPos(llllllllllllllllIIlllIIIllIllIlI).move(llllllllllllllllIIlllIIIllIlIIll);
            int llllllllllllllllIIlllIIIllIlIIlI = this.getRenderedDepth(llllllllllllllllIIlllIIIllIllIll.getBlockState(llllllllllllllllIIlllIIIllIlIlII));
            if (llllllllllllllllIIlllIIIllIlIIlI < 0) {
                if (llllllllllllllllIIlllIIIllIllIll.getBlockState(llllllllllllllllIIlllIIIllIlIlII).getMaterial().blocksMovement()) {
                    continue;
                }
                llllllllllllllllIIlllIIIllIlIIlI = this.getRenderedDepth(llllllllllllllllIIlllIIIllIllIll.getBlockState(llllllllllllllllIIlllIIIllIlIlII.down()));
                if (llllllllllllllllIIlllIIIllIlIIlI < 0) {
                    continue;
                }
                final int llllllllllllllllIIlllIIIllIlIIIl = llllllllllllllllIIlllIIIllIlIIlI - (llllllllllllllllIIlllIIIllIlIlIl - 8);
                llllllllllllllllIIlllIIIllIllIII += llllllllllllllllIIlllIIIllIlIIll.getFrontOffsetX() * llllllllllllllllIIlllIIIllIlIIIl;
                llllllllllllllllIIlllIIIllIlIlll += llllllllllllllllIIlllIIIllIlIIll.getFrontOffsetY() * llllllllllllllllIIlllIIIllIlIIIl;
                llllllllllllllllIIlllIIIllIlIllI += llllllllllllllllIIlllIIIllIlIIll.getFrontOffsetZ() * llllllllllllllllIIlllIIIllIlIIIl;
            }
            else {
                if (llllllllllllllllIIlllIIIllIlIIlI < 0) {
                    continue;
                }
                final int llllllllllllllllIIlllIIIllIlIIII = llllllllllllllllIIlllIIIllIlIIlI - llllllllllllllllIIlllIIIllIlIlIl;
                llllllllllllllllIIlllIIIllIllIII += llllllllllllllllIIlllIIIllIlIIll.getFrontOffsetX() * llllllllllllllllIIlllIIIllIlIIII;
                llllllllllllllllIIlllIIIllIlIlll += llllllllllllllllIIlllIIIllIlIIll.getFrontOffsetY() * llllllllllllllllIIlllIIIllIlIIII;
                llllllllllllllllIIlllIIIllIlIllI += llllllllllllllllIIlllIIIllIlIIll.getFrontOffsetZ() * llllllllllllllllIIlllIIIllIlIIII;
            }
        }
        Vec3d llllllllllllllllIIlllIIIllIIllll = new Vec3d(llllllllllllllllIIlllIIIllIllIII, llllllllllllllllIIlllIIIllIlIlll, llllllllllllllllIIlllIIIllIlIllI);
        if (llllllllllllllllIIlllIIIllIIlIlI.getValue((IProperty<Integer>)BlockLiquid.LEVEL) >= 8) {
            for (final EnumFacing llllllllllllllllIIlllIIIllIIlllI : EnumFacing.Plane.HORIZONTAL) {
                llllllllllllllllIIlllIIIllIlIlII.setPos(llllllllllllllllIIlllIIIllIllIlI).move(llllllllllllllllIIlllIIIllIIlllI);
                if (this.isBlockSolid(llllllllllllllllIIlllIIIllIllIll, llllllllllllllllIIlllIIIllIlIlII, llllllllllllllllIIlllIIIllIIlllI) || this.isBlockSolid(llllllllllllllllIIlllIIIllIllIll, llllllllllllllllIIlllIIIllIlIlII.up(), llllllllllllllllIIlllIIIllIIlllI)) {
                    llllllllllllllllIIlllIIIllIIllll = llllllllllllllllIIlllIIIllIIllll.normalize().addVector(0.0, -6.0, 0.0);
                    break;
                }
            }
        }
        llllllllllllllllIIlllIIIllIlIlII.release();
        return llllllllllllllllIIlllIIIllIIllll.normalize();
    }
    
    @Override
    public int getPackedLightmapCoords(final IBlockState llllllllllllllllIIlllIIIlIlIIlII, final IBlockAccess llllllllllllllllIIlllIIIlIIllIll, final BlockPos llllllllllllllllIIlllIIIlIIllIlI) {
        final int llllllllllllllllIIlllIIIlIlIIIIl = llllllllllllllllIIlllIIIlIIllIll.getCombinedLight(llllllllllllllllIIlllIIIlIIllIlI, 0);
        final int llllllllllllllllIIlllIIIlIlIIIII = llllllllllllllllIIlllIIIlIIllIll.getCombinedLight(llllllllllllllllIIlllIIIlIIllIlI.up(), 0);
        final int llllllllllllllllIIlllIIIlIIlllll = llllllllllllllllIIlllIIIlIlIIIIl & 0xFF;
        final int llllllllllllllllIIlllIIIlIIllllI = llllllllllllllllIIlllIIIlIlIIIII & 0xFF;
        final int llllllllllllllllIIlllIIIlIIlllIl = llllllllllllllllIIlllIIIlIlIIIIl >> 16 & 0xFF;
        final int llllllllllllllllIIlllIIIlIIlllII = llllllllllllllllIIlllIIIlIlIIIII >> 16 & 0xFF;
        return ((llllllllllllllllIIlllIIIlIIlllll > llllllllllllllllIIlllIIIlIIllllI) ? llllllllllllllllIIlllIIIlIIlllll : llllllllllllllllIIlllIIIlIIllllI) | ((llllllllllllllllIIlllIIIlIIlllIl > llllllllllllllllIIlllIIIlIIlllII) ? llllllllllllllllIIlllIIIlIIlllIl : llllllllllllllllIIlllIIIlIIlllII) << 16;
    }
    
    public boolean shouldRenderSides(final IBlockAccess llllllllllllllllIIlllIIIllllIllI, final BlockPos llllllllllllllllIIlllIIIlllllIll) {
        for (int llllllllllllllllIIlllIIIlllllIlI = -1; llllllllllllllllIIlllIIIlllllIlI <= 1; ++llllllllllllllllIIlllIIIlllllIlI) {
            for (int llllllllllllllllIIlllIIIlllllIIl = -1; llllllllllllllllIIlllIIIlllllIIl <= 1; ++llllllllllllllllIIlllIIIlllllIIl) {
                final IBlockState llllllllllllllllIIlllIIIlllllIII = llllllllllllllllIIlllIIIllllIllI.getBlockState(llllllllllllllllIIlllIIIlllllIll.add(llllllllllllllllIIlllIIIlllllIlI, 0, llllllllllllllllIIlllIIIlllllIIl));
                if (llllllllllllllllIIlllIIIlllllIII.getMaterial() != this.blockMaterial && !llllllllllllllllIIlllIIIlllllIII.isFullBlock()) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public static float getSlopeAngle(final IBlockAccess llllllllllllllllIIlllIIIIlIllIlI, final BlockPos llllllllllllllllIIlllIIIIlIllIIl, final Material llllllllllllllllIIlllIIIIlIlllIl, final IBlockState llllllllllllllllIIlllIIIIlIlIlll) {
        final Vec3d llllllllllllllllIIlllIIIIlIllIll = getFlowingBlock(llllllllllllllllIIlllIIIIlIlllIl).getFlow(llllllllllllllllIIlllIIIIlIllIlI, llllllllllllllllIIlllIIIIlIllIIl, llllllllllllllllIIlllIIIIlIlIlll);
        return (llllllllllllllllIIlllIIIIlIllIll.xCoord == 0.0 && llllllllllllllllIIlllIIIIlIllIll.zCoord == 0.0) ? -1000.0f : ((float)MathHelper.atan2(llllllllllllllllIIlllIIIIlIllIll.zCoord, llllllllllllllllIIlllIIIIlIllIll.xCoord) - 1.5707964f);
    }
    
    public static BlockDynamicLiquid getFlowingBlock(final Material llllllllllllllllIIllIllllllIllll) {
        if (llllllllllllllllIIllIllllllIllll == Material.WATER) {
            return Blocks.FLOWING_WATER;
        }
        if (llllllllllllllllIIllIllllllIllll == Material.LAVA) {
            return Blocks.FLOWING_LAVA;
        }
        throw new IllegalArgumentException("Invalid material");
    }
    
    public static float getLiquidHeightPercent(int llllllllllllllllIIlllIIlIlIIIlIl) {
        if (llllllllllllllllIIlllIIlIlIIIlIl >= 8) {
            llllllllllllllllIIlllIIlIlIIIlIl = 0;
        }
        return (llllllllllllllllIIlllIIlIlIIIlIl + 1) / 9.0f;
    }
    
    public static float func_190973_f(final IBlockState llllllllllllllllIIllIllllllIIIlI, final IBlockAccess llllllllllllllllIIllIllllllIIIIl, final BlockPos llllllllllllllllIIllIllllllIIIII) {
        final int llllllllllllllllIIllIllllllIIIll = llllllllllllllllIIllIllllllIIIlI.getValue((IProperty<Integer>)BlockLiquid.LEVEL);
        return ((llllllllllllllllIIllIllllllIIIll & 0x7) == 0x0 && llllllllllllllllIIllIllllllIIIIl.getBlockState(llllllllllllllllIIllIllllllIIIII.up()).getMaterial() == Material.WATER) ? 1.0f : (1.0f - getLiquidHeightPercent(llllllllllllllllIIllIllllllIIIll));
    }
    
    @Override
    public IBlockState getStateFromMeta(final int llllllllllllllllIIllIllllllllIII) {
        return this.getDefaultState().withProperty((IProperty<Comparable>)BlockLiquid.LEVEL, llllllllllllllllIIllIllllllllIII);
    }
    
    @Override
    public int tickRate(final World llllllllllllllllIIlllIIIlIlIlllI) {
        if (this.blockMaterial == Material.WATER) {
            return 5;
        }
        if (this.blockMaterial == Material.LAVA) {
            return llllllllllllllllIIlllIIIlIlIlllI.provider.getHasNoSky() ? 10 : 30;
        }
        return 0;
    }
    
    @Override
    public BlockFaceShape func_193383_a(final IBlockAccess llllllllllllllllIIllIlllllIlIlII, final IBlockState llllllllllllllllIIllIlllllIlIIll, final BlockPos llllllllllllllllIIllIlllllIlIIlI, final EnumFacing llllllllllllllllIIllIlllllIlIIIl) {
        return BlockFaceShape.UNDEFINED;
    }
    
    @Override
    public boolean isPassable(final IBlockAccess llllllllllllllllIIlllIIlIlIIlIlI, final BlockPos llllllllllllllllIIlllIIlIlIIlIIl) {
        return this.blockMaterial != Material.LAVA;
    }
    
    protected int getRenderedDepth(final IBlockState llllllllllllllllIIlllIIlIIlllIlI) {
        final int llllllllllllllllIIlllIIlIIlllIIl = this.getDepth(llllllllllllllllIIlllIIlIIlllIlI);
        return (llllllllllllllllIIlllIIlIIlllIIl >= 8) ? 0 : llllllllllllllllIIlllIIlIIlllIIl;
    }
    
    static {
        LEVEL = PropertyInteger.create("level", 0, 15);
    }
    
    @Override
    public boolean canCollideCheck(final IBlockState llllllllllllllllIIlllIIlIIlIllII, final boolean llllllllllllllllIIlllIIlIIlIllIl) {
        return llllllllllllllllIIlllIIlIIlIllIl && llllllllllllllllIIlllIIlIIlIllII.getValue((IProperty<Integer>)BlockLiquid.LEVEL) == 0;
    }
    
    @Override
    public boolean isFullCube(final IBlockState llllllllllllllllIIlllIIlIIllIlII) {
        return false;
    }
    
    @Nullable
    @Override
    public AxisAlignedBB getCollisionBoundingBox(final IBlockState llllllllllllllllIIlllIIlIlIIllll, final IBlockAccess llllllllllllllllIIlllIIlIlIIlllI, final BlockPos llllllllllllllllIIlllIIlIlIIllIl) {
        return BlockLiquid.NULL_AABB;
    }
    
    @Override
    public AxisAlignedBB getBoundingBox(final IBlockState llllllllllllllllIIlllIIlIlIlIIll, final IBlockAccess llllllllllllllllIIlllIIlIlIlIIlI, final BlockPos llllllllllllllllIIlllIIlIlIlIIIl) {
        return BlockLiquid.FULL_BLOCK_AABB;
    }
    
    public static BlockStaticLiquid getStaticBlock(final Material llllllllllllllllIIllIllllllIllII) {
        if (llllllllllllllllIIllIllllllIllII == Material.WATER) {
            return Blocks.WATER;
        }
        if (llllllllllllllllIIllIllllllIllII == Material.LAVA) {
            return Blocks.LAVA;
        }
        throw new IllegalArgumentException("Invalid material");
    }
    
    @Override
    public Item getItemDropped(final IBlockState llllllllllllllllIIlllIIIlllIlllI, final Random llllllllllllllllIIlllIIIlllIllIl, final int llllllllllllllllIIlllIIIlllIllII) {
        return Items.field_190931_a;
    }
    
    public static float func_190972_g(final IBlockState llllllllllllllllIIllIlllllIllIII, final IBlockAccess llllllllllllllllIIllIlllllIlIlll, final BlockPos llllllllllllllllIIllIlllllIllIIl) {
        return llllllllllllllllIIllIlllllIllIIl.getY() + func_190973_f(llllllllllllllllIIllIlllllIllIII, llllllllllllllllIIllIlllllIlIlll, llllllllllllllllIIllIlllllIllIIl);
    }
    
    protected int getDepth(final IBlockState llllllllllllllllIIlllIIlIIllllll) {
        return (llllllllllllllllIIlllIIlIIllllll.getMaterial() == this.blockMaterial) ? llllllllllllllllIIlllIIlIIllllll.getValue((IProperty<Integer>)BlockLiquid.LEVEL) : -1;
    }
    
    protected void triggerMixEffects(final World llllllllllllllllIIlllIIIIIIIllII, final BlockPos llllllllllllllllIIlllIIIIIIIIIlI) {
        final double llllllllllllllllIIlllIIIIIIIlIlI = llllllllllllllllIIlllIIIIIIIIIlI.getX();
        final double llllllllllllllllIIlllIIIIIIIlIII = llllllllllllllllIIlllIIIIIIIIIlI.getY();
        final double llllllllllllllllIIlllIIIIIIIIllI = llllllllllllllllIIlllIIIIIIIIIlI.getZ();
        llllllllllllllllIIlllIIIIIIIllII.playSound(null, llllllllllllllllIIlllIIIIIIIIIlI, SoundEvents.BLOCK_LAVA_EXTINGUISH, SoundCategory.BLOCKS, 0.5f, 2.6f + (llllllllllllllllIIlllIIIIIIIllII.rand.nextFloat() - llllllllllllllllIIlllIIIIIIIllII.rand.nextFloat()) * 0.8f);
        for (int llllllllllllllllIIlllIIIIIIIIlII = 0; llllllllllllllllIIlllIIIIIIIIlII < 8; ++llllllllllllllllIIlllIIIIIIIIlII) {
            llllllllllllllllIIlllIIIIIIIllII.spawnParticle(EnumParticleTypes.SMOKE_LARGE, llllllllllllllllIIlllIIIIIIIlIlI + Math.random(), llllllllllllllllIIlllIIIIIIIlIII + 1.2, llllllllllllllllIIlllIIIIIIIIllI + Math.random(), 0.0, 0.0, 0.0, new int[0]);
        }
    }
    
    @Override
    public boolean shouldSideBeRendered(final IBlockState llllllllllllllllIIlllIIlIIIIllII, final IBlockAccess llllllllllllllllIIlllIIlIIIIIllI, final BlockPos llllllllllllllllIIlllIIlIIIIIlIl, final EnumFacing llllllllllllllllIIlllIIlIIIIlIIl) {
        return llllllllllllllllIIlllIIlIIIIIllI.getBlockState(llllllllllllllllIIlllIIlIIIIIlIl.offset(llllllllllllllllIIlllIIlIIIIlIIl)).getMaterial() != this.blockMaterial && (llllllllllllllllIIlllIIlIIIIlIIl == EnumFacing.UP || super.shouldSideBeRendered(llllllllllllllllIIlllIIlIIIIllII, llllllllllllllllIIlllIIlIIIIIllI, llllllllllllllllIIlllIIlIIIIIlIl, llllllllllllllllIIlllIIlIIIIlIIl));
    }
    
    private boolean isBlockSolid(final IBlockAccess llllllllllllllllIIlllIIlIIlIIIIl, final BlockPos llllllllllllllllIIlllIIlIIlIIIII, final EnumFacing llllllllllllllllIIlllIIlIIIlllll) {
        final IBlockState llllllllllllllllIIlllIIlIIIllllI = llllllllllllllllIIlllIIlIIlIIIIl.getBlockState(llllllllllllllllIIlllIIlIIlIIIII);
        final Block llllllllllllllllIIlllIIlIIIlllIl = llllllllllllllllIIlllIIlIIIllllI.getBlock();
        final Material llllllllllllllllIIlllIIlIIIlllII = llllllllllllllllIIlllIIlIIIllllI.getMaterial();
        if (llllllllllllllllIIlllIIlIIIlllII == this.blockMaterial) {
            return false;
        }
        if (llllllllllllllllIIlllIIlIIIlllll == EnumFacing.UP) {
            return true;
        }
        if (llllllllllllllllIIlllIIlIIIlllII == Material.ICE) {
            return false;
        }
        final boolean llllllllllllllllIIlllIIlIIIllIll = Block.func_193382_c(llllllllllllllllIIlllIIlIIIlllIl) || llllllllllllllllIIlllIIlIIIlllIl instanceof BlockStairs;
        return !llllllllllllllllIIlllIIlIIIllIll && llllllllllllllllIIlllIIlIIIllllI.func_193401_d(llllllllllllllllIIlllIIlIIlIIIIl, llllllllllllllllIIlllIIlIIlIIIII, llllllllllllllllIIlllIIlIIIlllll) == BlockFaceShape.SOLID;
    }
    
    public boolean checkForMixing(final World llllllllllllllllIIlllIIIIIllIIIl, final BlockPos llllllllllllllllIIlllIIIIIllIIII, final IBlockState llllllllllllllllIIlllIIIIIlIlIII) {
        if (this.blockMaterial == Material.LAVA) {
            boolean llllllllllllllllIIlllIIIIIlIlllI = false;
            final Exception llllllllllllllllIIlllIIIIIlIIIll;
            final boolean llllllllllllllllIIlllIIIIIlIIlII = ((EnumFacing[])(Object)(llllllllllllllllIIlllIIIIIlIIIll = (Exception)(Object)EnumFacing.values())).length != 0;
            for (final EnumFacing llllllllllllllllIIlllIIIIIlIllIl : llllllllllllllllIIlllIIIIIlIIIll) {
                if (llllllllllllllllIIlllIIIIIlIllIl != EnumFacing.DOWN && llllllllllllllllIIlllIIIIIllIIIl.getBlockState(llllllllllllllllIIlllIIIIIllIIII.offset(llllllllllllllllIIlllIIIIIlIllIl)).getMaterial() == Material.WATER) {
                    llllllllllllllllIIlllIIIIIlIlllI = true;
                    break;
                }
            }
            if (llllllllllllllllIIlllIIIIIlIlllI) {
                final Integer llllllllllllllllIIlllIIIIIlIllII = llllllllllllllllIIlllIIIIIlIlIII.getValue((IProperty<Integer>)BlockLiquid.LEVEL);
                if (llllllllllllllllIIlllIIIIIlIllII == 0) {
                    llllllllllllllllIIlllIIIIIllIIIl.setBlockState(llllllllllllllllIIlllIIIIIllIIII, Blocks.OBSIDIAN.getDefaultState());
                    this.triggerMixEffects(llllllllllllllllIIlllIIIIIllIIIl, llllllllllllllllIIlllIIIIIllIIII);
                    return true;
                }
                if (llllllllllllllllIIlllIIIIIlIllII <= 4) {
                    llllllllllllllllIIlllIIIIIllIIIl.setBlockState(llllllllllllllllIIlllIIIIIllIIII, Blocks.COBBLESTONE.getDefaultState());
                    this.triggerMixEffects(llllllllllllllllIIlllIIIIIllIIIl, llllllllllllllllIIlllIIIIIllIIII);
                    return true;
                }
            }
        }
        return false;
    }
    
    @Override
    public Vec3d modifyAcceleration(final World llllllllllllllllIIlllIIIlIllIllI, final BlockPos llllllllllllllllIIlllIIIlIllIlIl, final Entity llllllllllllllllIIlllIIIlIlllIIl, final Vec3d llllllllllllllllIIlllIIIlIlllIII) {
        return llllllllllllllllIIlllIIIlIlllIII.add(this.getFlow(llllllllllllllllIIlllIIIlIllIllI, llllllllllllllllIIlllIIIlIllIlIl, llllllllllllllllIIlllIIIlIllIllI.getBlockState(llllllllllllllllIIlllIIIlIllIlIl)));
    }
    
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, (IProperty<?>[])new IProperty[] { BlockLiquid.LEVEL });
    }
    
    @Override
    public EnumBlockRenderType getRenderType(final IBlockState llllllllllllllllIIlllIIIllllIIII) {
        return EnumBlockRenderType.LIQUID;
    }
    
    @Override
    public void randomDisplayTick(final IBlockState llllllllllllllllIIlllIIIIlllIIIl, final World llllllllllllllllIIlllIIIlIIIIIII, final BlockPos llllllllllllllllIIlllIIIIlllllll, final Random llllllllllllllllIIlllIIIIllllllI) {
        final double llllllllllllllllIIlllIIIIlllllIl = llllllllllllllllIIlllIIIIlllllll.getX();
        final double llllllllllllllllIIlllIIIIlllllII = llllllllllllllllIIlllIIIIlllllll.getY();
        final double llllllllllllllllIIlllIIIIllllIll = llllllllllllllllIIlllIIIIlllllll.getZ();
        if (this.blockMaterial == Material.WATER) {
            final int llllllllllllllllIIlllIIIIllllIlI = llllllllllllllllIIlllIIIIlllIIIl.getValue((IProperty<Integer>)BlockLiquid.LEVEL);
            if (llllllllllllllllIIlllIIIIllllIlI > 0 && llllllllllllllllIIlllIIIIllllIlI < 8) {
                if (llllllllllllllllIIlllIIIIllllllI.nextInt(64) == 0) {
                    llllllllllllllllIIlllIIIlIIIIIII.playSound(llllllllllllllllIIlllIIIIlllllIl + 0.5, llllllllllllllllIIlllIIIIlllllII + 0.5, llllllllllllllllIIlllIIIIllllIll + 0.5, SoundEvents.BLOCK_WATER_AMBIENT, SoundCategory.BLOCKS, llllllllllllllllIIlllIIIIllllllI.nextFloat() * 0.25f + 0.75f, llllllllllllllllIIlllIIIIllllllI.nextFloat() + 0.5f, false);
                }
            }
            else if (llllllllllllllllIIlllIIIIllllllI.nextInt(10) == 0) {
                llllllllllllllllIIlllIIIlIIIIIII.spawnParticle(EnumParticleTypes.SUSPENDED, llllllllllllllllIIlllIIIIlllllIl + llllllllllllllllIIlllIIIIllllllI.nextFloat(), llllllllllllllllIIlllIIIIlllllII + llllllllllllllllIIlllIIIIllllllI.nextFloat(), llllllllllllllllIIlllIIIIllllIll + llllllllllllllllIIlllIIIIllllllI.nextFloat(), 0.0, 0.0, 0.0, new int[0]);
            }
        }
        if (this.blockMaterial == Material.LAVA && llllllllllllllllIIlllIIIlIIIIIII.getBlockState(llllllllllllllllIIlllIIIIlllllll.up()).getMaterial() == Material.AIR && !llllllllllllllllIIlllIIIlIIIIIII.getBlockState(llllllllllllllllIIlllIIIIlllllll.up()).isOpaqueCube()) {
            if (llllllllllllllllIIlllIIIIllllllI.nextInt(100) == 0) {
                final double llllllllllllllllIIlllIIIIllllIIl = llllllllllllllllIIlllIIIIlllllIl + llllllllllllllllIIlllIIIIllllllI.nextFloat();
                final double llllllllllllllllIIlllIIIIllllIII = llllllllllllllllIIlllIIIIlllllII + llllllllllllllllIIlllIIIIlllIIIl.getBoundingBox(llllllllllllllllIIlllIIIlIIIIIII, llllllllllllllllIIlllIIIIlllllll).maxY;
                final double llllllllllllllllIIlllIIIIlllIlll = llllllllllllllllIIlllIIIIllllIll + llllllllllllllllIIlllIIIIllllllI.nextFloat();
                llllllllllllllllIIlllIIIlIIIIIII.spawnParticle(EnumParticleTypes.LAVA, llllllllllllllllIIlllIIIIllllIIl, llllllllllllllllIIlllIIIIllllIII, llllllllllllllllIIlllIIIIlllIlll, 0.0, 0.0, 0.0, new int[0]);
                llllllllllllllllIIlllIIIlIIIIIII.playSound(llllllllllllllllIIlllIIIIllllIIl, llllllllllllllllIIlllIIIIllllIII, llllllllllllllllIIlllIIIIlllIlll, SoundEvents.BLOCK_LAVA_POP, SoundCategory.BLOCKS, 0.2f + llllllllllllllllIIlllIIIIllllllI.nextFloat() * 0.2f, 0.9f + llllllllllllllllIIlllIIIIllllllI.nextFloat() * 0.15f, false);
            }
            if (llllllllllllllllIIlllIIIIllllllI.nextInt(200) == 0) {
                llllllllllllllllIIlllIIIlIIIIIII.playSound(llllllllllllllllIIlllIIIIlllllIl, llllllllllllllllIIlllIIIIlllllII, llllllllllllllllIIlllIIIIllllIll, SoundEvents.BLOCK_LAVA_AMBIENT, SoundCategory.BLOCKS, 0.2f + llllllllllllllllIIlllIIIIllllllI.nextFloat() * 0.2f, 0.9f + llllllllllllllllIIlllIIIIllllllI.nextFloat() * 0.15f, false);
            }
        }
        if (llllllllllllllllIIlllIIIIllllllI.nextInt(10) == 0 && llllllllllllllllIIlllIIIlIIIIIII.getBlockState(llllllllllllllllIIlllIIIIlllllll.down()).isFullyOpaque()) {
            final Material llllllllllllllllIIlllIIIIlllIllI = llllllllllllllllIIlllIIIlIIIIIII.getBlockState(llllllllllllllllIIlllIIIIlllllll.down(2)).getMaterial();
            if (!llllllllllllllllIIlllIIIIlllIllI.blocksMovement() && !llllllllllllllllIIlllIIIIlllIllI.isLiquid()) {
                final double llllllllllllllllIIlllIIIIlllIlIl = llllllllllllllllIIlllIIIIlllllIl + llllllllllllllllIIlllIIIIllllllI.nextFloat();
                final double llllllllllllllllIIlllIIIIlllIlII = llllllllllllllllIIlllIIIIlllllII - 1.05;
                final double llllllllllllllllIIlllIIIIlllIIll = llllllllllllllllIIlllIIIIllllIll + llllllllllllllllIIlllIIIIllllllI.nextFloat();
                if (this.blockMaterial == Material.WATER) {
                    llllllllllllllllIIlllIIIlIIIIIII.spawnParticle(EnumParticleTypes.DRIP_WATER, llllllllllllllllIIlllIIIIlllIlIl, llllllllllllllllIIlllIIIIlllIlII, llllllllllllllllIIlllIIIIlllIIll, 0.0, 0.0, 0.0, new int[0]);
                }
                else {
                    llllllllllllllllIIlllIIIlIIIIIII.spawnParticle(EnumParticleTypes.DRIP_LAVA, llllllllllllllllIIlllIIIIlllIlIl, llllllllllllllllIIlllIIIIlllIlII, llllllllllllllllIIlllIIIIlllIIll, 0.0, 0.0, 0.0, new int[0]);
                }
            }
        }
    }
    
    @Override
    public BlockRenderLayer getBlockLayer() {
        return (this.blockMaterial == Material.WATER) ? BlockRenderLayer.TRANSLUCENT : BlockRenderLayer.SOLID;
    }
    
    @Override
    public void onBlockAdded(final World llllllllllllllllIIlllIIIIlIlIIII, final BlockPos llllllllllllllllIIlllIIIIlIIllll, final IBlockState llllllllllllllllIIlllIIIIlIIlllI) {
        this.checkForMixing(llllllllllllllllIIlllIIIIlIlIIII, llllllllllllllllIIlllIIIIlIIllll, llllllllllllllllIIlllIIIIlIIlllI);
    }
}
