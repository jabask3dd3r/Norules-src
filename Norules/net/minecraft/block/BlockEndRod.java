package net.minecraft.block;

import net.minecraft.block.properties.*;
import net.minecraft.creativetab.*;
import net.minecraft.block.material.*;
import net.minecraft.util.math.*;
import net.minecraft.world.*;
import java.util.*;
import net.minecraft.block.state.*;
import net.minecraft.entity.*;
import net.minecraft.init.*;
import net.minecraft.util.*;

public class BlockEndRod extends BlockDirectional
{
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$EnumFacing$Axis;
    protected static final /* synthetic */ AxisAlignedBB END_ROD_VERTICAL_AABB;
    protected static final /* synthetic */ AxisAlignedBB END_ROD_NS_AABB;
    protected static final /* synthetic */ AxisAlignedBB END_ROD_EW_AABB;
    
    protected BlockEndRod() {
        super(Material.CIRCUITS);
        this.setDefaultState(this.blockState.getBaseState().withProperty((IProperty<Comparable>)BlockEndRod.FACING, EnumFacing.UP));
        this.setCreativeTab(CreativeTabs.DECORATIONS);
    }
    
    @Override
    public IBlockState withRotation(final IBlockState llllllllllllllIlIlIlIllllllIlIII, final Rotation llllllllllllllIlIlIlIllllllIIlll) {
        return llllllllllllllIlIlIlIllllllIlIII.withProperty((IProperty<Comparable>)BlockEndRod.FACING, llllllllllllllIlIlIlIllllllIIlll.rotate(llllllllllllllIlIlIlIllllllIlIII.getValue((IProperty<EnumFacing>)BlockEndRod.FACING)));
    }
    
    @Override
    public EnumPushReaction getMobilityFlag(final IBlockState llllllllllllllIlIlIlIllllIIIlIll) {
        return EnumPushReaction.NORMAL;
    }
    
    @Override
    public BlockRenderLayer getBlockLayer() {
        return BlockRenderLayer.CUTOUT;
    }
    
    @Override
    public AxisAlignedBB getBoundingBox(final IBlockState llllllllllllllIlIlIlIlllllIllIII, final IBlockAccess llllllllllllllIlIlIlIlllllIllIlI, final BlockPos llllllllllllllIlIlIlIlllllIllIIl) {
        switch ($SWITCH_TABLE$net$minecraft$util$EnumFacing$Axis()[llllllllllllllIlIlIlIlllllIllIII.getValue((IProperty<EnumFacing>)BlockEndRod.FACING).getAxis().ordinal()]) {
            default: {
                return BlockEndRod.END_ROD_EW_AABB;
            }
            case 3: {
                return BlockEndRod.END_ROD_NS_AABB;
            }
            case 2: {
                return BlockEndRod.END_ROD_VERTICAL_AABB;
            }
        }
    }
    
    @Override
    public void randomDisplayTick(final IBlockState llllllllllllllIlIlIlIllllIlIIllI, final World llllllllllllllIlIlIlIllllIlIIlIl, final BlockPos llllllllllllllIlIlIlIllllIlIIlII, final Random llllllllllllllIlIlIlIllllIlIllII) {
        final EnumFacing llllllllllllllIlIlIlIllllIlIlIll = llllllllllllllIlIlIlIllllIlIIllI.getValue((IProperty<EnumFacing>)BlockEndRod.FACING);
        final double llllllllllllllIlIlIlIllllIlIlIlI = llllllllllllllIlIlIlIllllIlIIlII.getX() + 0.55 - llllllllllllllIlIlIlIllllIlIllII.nextFloat() * 0.1f;
        final double llllllllllllllIlIlIlIllllIlIlIIl = llllllllllllllIlIlIlIllllIlIIlII.getY() + 0.55 - llllllllllllllIlIlIlIllllIlIllII.nextFloat() * 0.1f;
        final double llllllllllllllIlIlIlIllllIlIlIII = llllllllllllllIlIlIlIllllIlIIlII.getZ() + 0.55 - llllllllllllllIlIlIlIllllIlIllII.nextFloat() * 0.1f;
        final double llllllllllllllIlIlIlIllllIlIIlll = 0.4f - (llllllllllllllIlIlIlIllllIlIllII.nextFloat() + llllllllllllllIlIlIlIllllIlIllII.nextFloat()) * 0.4f;
        if (llllllllllllllIlIlIlIllllIlIllII.nextInt(5) == 0) {
            llllllllllllllIlIlIlIllllIlIIlIl.spawnParticle(EnumParticleTypes.END_ROD, llllllllllllllIlIlIlIllllIlIlIlI + llllllllllllllIlIlIlIllllIlIlIll.getFrontOffsetX() * llllllllllllllIlIlIlIllllIlIIlll, llllllllllllllIlIlIlIllllIlIlIIl + llllllllllllllIlIlIlIllllIlIlIll.getFrontOffsetY() * llllllllllllllIlIlIlIllllIlIIlll, llllllllllllllIlIlIlIllllIlIlIII + llllllllllllllIlIlIlIllllIlIlIll.getFrontOffsetZ() * llllllllllllllIlIlIlIllllIlIIlll, llllllllllllllIlIlIlIllllIlIllII.nextGaussian() * 0.005, llllllllllllllIlIlIlIllllIlIllII.nextGaussian() * 0.005, llllllllllllllIlIlIlIllllIlIllII.nextGaussian() * 0.005, new int[0]);
        }
    }
    
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, (IProperty<?>[])new IProperty[] { BlockEndRod.FACING });
    }
    
    @Override
    public BlockFaceShape func_193383_a(final IBlockAccess llllllllllllllIlIlIlIllllIIIlIIl, final IBlockState llllllllllllllIlIlIlIllllIIIlIII, final BlockPos llllllllllllllIlIlIlIllllIIIIlll, final EnumFacing llllllllllllllIlIlIlIllllIIIIllI) {
        return BlockFaceShape.UNDEFINED;
    }
    
    @Override
    public boolean isFullCube(final IBlockState llllllllllllllIlIlIlIlllllIlIlII) {
        return false;
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$EnumFacing$Axis() {
        final int[] $switch_TABLE$net$minecraft$util$EnumFacing$Axis = BlockEndRod.$SWITCH_TABLE$net$minecraft$util$EnumFacing$Axis;
        if ($switch_TABLE$net$minecraft$util$EnumFacing$Axis != null) {
            return $switch_TABLE$net$minecraft$util$EnumFacing$Axis;
        }
        final Exception llllllllllllllIlIlIlIllllIIIIlII = (Object)new int[EnumFacing.Axis.values().length];
        try {
            llllllllllllllIlIlIlIllllIIIIlII[EnumFacing.Axis.X.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            llllllllllllllIlIlIlIllllIIIIlII[EnumFacing.Axis.Y.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            llllllllllllllIlIlIlIllllIIIIlII[EnumFacing.Axis.Z.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        return BlockEndRod.$SWITCH_TABLE$net$minecraft$util$EnumFacing$Axis = (int[])(Object)llllllllllllllIlIlIlIllllIIIIlII;
    }
    
    @Override
    public boolean isOpaqueCube(final IBlockState llllllllllllllIlIlIlIlllllIlIllI) {
        return false;
    }
    
    static {
        END_ROD_VERTICAL_AABB = new AxisAlignedBB(0.375, 0.0, 0.375, 0.625, 1.0, 0.625);
        END_ROD_NS_AABB = new AxisAlignedBB(0.375, 0.375, 0.0, 0.625, 0.625, 1.0);
        END_ROD_EW_AABB = new AxisAlignedBB(0.0, 0.375, 0.375, 1.0, 0.625, 0.625);
    }
    
    @Override
    public boolean canPlaceBlockAt(final World llllllllllllllIlIlIlIlllllIlIIlI, final BlockPos llllllllllllllIlIlIlIlllllIlIIIl) {
        return true;
    }
    
    @Override
    public IBlockState onBlockPlaced(final World llllllllllllllIlIlIlIllllIlllllI, final BlockPos llllllllllllllIlIlIlIlllllIIlIII, final EnumFacing llllllllllllllIlIlIlIlllllIIIlll, final float llllllllllllllIlIlIlIlllllIIIllI, final float llllllllllllllIlIlIlIlllllIIIlIl, final float llllllllllllllIlIlIlIlllllIIIlII, final int llllllllllllllIlIlIlIlllllIIIIll, final EntityLivingBase llllllllllllllIlIlIlIlllllIIIIlI) {
        final IBlockState llllllllllllllIlIlIlIlllllIIIIIl = llllllllllllllIlIlIlIllllIlllllI.getBlockState(llllllllllllllIlIlIlIlllllIIlIII.offset(llllllllllllllIlIlIlIlllllIIIlll.getOpposite()));
        if (llllllllllllllIlIlIlIlllllIIIIIl.getBlock() == Blocks.END_ROD) {
            final EnumFacing llllllllllllllIlIlIlIlllllIIIIII = llllllllllllllIlIlIlIlllllIIIIIl.getValue((IProperty<EnumFacing>)BlockEndRod.FACING);
            if (llllllllllllllIlIlIlIlllllIIIIII == llllllllllllllIlIlIlIlllllIIIlll) {
                return this.getDefaultState().withProperty((IProperty<Comparable>)BlockEndRod.FACING, llllllllllllllIlIlIlIlllllIIIlll.getOpposite());
            }
        }
        return this.getDefaultState().withProperty((IProperty<Comparable>)BlockEndRod.FACING, llllllllllllllIlIlIlIlllllIIIlll);
    }
    
    @Override
    public int getMetaFromState(final IBlockState llllllllllllllIlIlIlIllllIIlIIIl) {
        return llllllllllllllIlIlIlIllllIIlIIIl.getValue((IProperty<EnumFacing>)BlockEndRod.FACING).getIndex();
    }
    
    @Override
    public IBlockState getStateFromMeta(final int llllllllllllllIlIlIlIllllIIllIII) {
        IBlockState llllllllllllllIlIlIlIllllIIlIlll = this.getDefaultState();
        llllllllllllllIlIlIlIllllIIlIlll = llllllllllllllIlIlIlIllllIIlIlll.withProperty((IProperty<Comparable>)BlockEndRod.FACING, EnumFacing.getFront(llllllllllllllIlIlIlIllllIIllIII));
        return llllllllllllllIlIlIlIllllIIlIlll;
    }
    
    @Override
    public IBlockState withMirror(final IBlockState llllllllllllllIlIlIlIllllllIIIIl, final Mirror llllllllllllllIlIlIlIllllllIIIII) {
        return llllllllllllllIlIlIlIllllllIIIIl.withProperty((IProperty<Comparable>)BlockEndRod.FACING, llllllllllllllIlIlIlIllllllIIIII.mirror(llllllllllllllIlIlIlIllllllIIIIl.getValue((IProperty<EnumFacing>)BlockEndRod.FACING)));
    }
}
