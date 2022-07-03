package net.minecraft.block;

import net.minecraft.util.math.*;
import net.minecraft.block.properties.*;
import net.minecraft.entity.*;
import java.util.*;
import net.minecraft.world.*;
import javax.annotation.*;
import com.google.common.base.*;
import net.minecraft.block.material.*;
import net.minecraft.creativetab.*;
import net.minecraft.block.state.*;
import net.minecraft.init.*;
import net.minecraft.util.*;

public class BlockTorch extends Block
{
    protected static final /* synthetic */ AxisAlignedBB TORCH_NORTH_AABB;
    protected static final /* synthetic */ AxisAlignedBB TORCH_EAST_AABB;
    protected static final /* synthetic */ AxisAlignedBB STANDING_AABB;
    protected static final /* synthetic */ AxisAlignedBB TORCH_WEST_AABB;
    protected static final /* synthetic */ AxisAlignedBB TORCH_SOUTH_AABB;
    public static final /* synthetic */ PropertyDirection FACING;
    
    @Override
    public void onBlockAdded(final World llllllllllllllIlllIIllIIIlllllll, final BlockPos llllllllllllllIlllIIllIIIllllllI, final IBlockState llllllllllllllIlllIIllIIIlllllIl) {
        this.checkForDrop(llllllllllllllIlllIIllIIIlllllll, llllllllllllllIlllIIllIIIllllllI, llllllllllllllIlllIIllIIIlllllIl);
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$EnumFacing() {
        final int[] $switch_TABLE$net$minecraft$util$EnumFacing = BlockTorch.$SWITCH_TABLE$net$minecraft$util$EnumFacing;
        if ($switch_TABLE$net$minecraft$util$EnumFacing != null) {
            return $switch_TABLE$net$minecraft$util$EnumFacing;
        }
        final byte llllllllllllllIlllIIlIlllllllIll = (Object)new int[EnumFacing.values().length];
        try {
            llllllllllllllIlllIIlIlllllllIll[EnumFacing.DOWN.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            llllllllllllllIlllIIlIlllllllIll[EnumFacing.EAST.ordinal()] = 6;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            llllllllllllllIlllIIlIlllllllIll[EnumFacing.NORTH.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            llllllllllllllIlllIIlIlllllllIll[EnumFacing.SOUTH.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        try {
            llllllllllllllIlllIIlIlllllllIll[EnumFacing.UP.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError5) {}
        try {
            llllllllllllllIlllIIlIlllllllIll[EnumFacing.WEST.ordinal()] = 5;
        }
        catch (NoSuchFieldError noSuchFieldError6) {}
        return BlockTorch.$SWITCH_TABLE$net$minecraft$util$EnumFacing = (int[])(Object)llllllllllllllIlllIIlIlllllllIll;
    }
    
    protected boolean checkForDrop(final World llllllllllllllIlllIIllIIIlIIlIlI, final BlockPos llllllllllllllIlllIIllIIIlIIlIIl, final IBlockState llllllllllllllIlllIIllIIIlIIlIII) {
        if (llllllllllllllIlllIIllIIIlIIlIII.getBlock() == this && this.canPlaceAt(llllllllllllllIlllIIllIIIlIIlIlI, llllllllllllllIlllIIllIIIlIIlIIl, llllllllllllllIlllIIllIIIlIIlIII.getValue((IProperty<EnumFacing>)BlockTorch.FACING))) {
            return true;
        }
        if (llllllllllllllIlllIIllIIIlIIlIlI.getBlockState(llllllllllllllIlllIIllIIIlIIlIIl).getBlock() == this) {
            this.dropBlockAsItem(llllllllllllllIlllIIllIIIlIIlIlI, llllllllllllllIlllIIllIIIlIIlIIl, llllllllllllllIlllIIllIIIlIIlIII, 0);
            llllllllllllllIlllIIllIIIlIIlIlI.setBlockToAir(llllllllllllllIlllIIllIIIlIIlIIl);
        }
        return false;
    }
    
    @Override
    public IBlockState onBlockPlaced(final World llllllllllllllIlllIIllIIlIIlIIll, final BlockPos llllllllllllllIlllIIllIIlIIIlIII, final EnumFacing llllllllllllllIlllIIllIIlIIIIlll, final float llllllllllllllIlllIIllIIlIIlIIII, final float llllllllllllllIlllIIllIIlIIIllll, final float llllllllllllllIlllIIllIIlIIIlllI, final int llllllllllllllIlllIIllIIlIIIllIl, final EntityLivingBase llllllllllllllIlllIIllIIlIIIllII) {
        if (this.canPlaceAt(llllllllllllllIlllIIllIIlIIlIIll, llllllllllllllIlllIIllIIlIIIlIII, llllllllllllllIlllIIllIIlIIIIlll)) {
            return this.getDefaultState().withProperty((IProperty<Comparable>)BlockTorch.FACING, llllllllllllllIlllIIllIIlIIIIlll);
        }
        for (final EnumFacing llllllllllllllIlllIIllIIlIIIlIll : EnumFacing.Plane.HORIZONTAL) {
            if (this.canPlaceAt(llllllllllllllIlllIIllIIlIIlIIll, llllllllllllllIlllIIllIIlIIIlIII, llllllllllllllIlllIIllIIlIIIlIll)) {
                return this.getDefaultState().withProperty((IProperty<Comparable>)BlockTorch.FACING, llllllllllllllIlllIIllIIlIIIlIll);
            }
        }
        return this.getDefaultState();
    }
    
    @Override
    public void randomDisplayTick(final IBlockState llllllllllllllIlllIIllIIIIlllIII, final World llllllllllllllIlllIIllIIIIlIlIll, final BlockPos llllllllllllllIlllIIllIIIIlIlIlI, final Random llllllllllllllIlllIIllIIIIllIlIl) {
        final EnumFacing llllllllllllllIlllIIllIIIIllIlII = llllllllllllllIlllIIllIIIIlllIII.getValue((IProperty<EnumFacing>)BlockTorch.FACING);
        final double llllllllllllllIlllIIllIIIIllIIll = llllllllllllllIlllIIllIIIIlIlIlI.getX() + 0.5;
        final double llllllllllllllIlllIIllIIIIllIIlI = llllllllllllllIlllIIllIIIIlIlIlI.getY() + 0.7;
        final double llllllllllllllIlllIIllIIIIllIIIl = llllllllllllllIlllIIllIIIIlIlIlI.getZ() + 0.5;
        final double llllllllllllllIlllIIllIIIIllIIII = 0.22;
        final double llllllllllllllIlllIIllIIIIlIllll = 0.27;
        if (llllllllllllllIlllIIllIIIIllIlII.getAxis().isHorizontal()) {
            final EnumFacing llllllllllllllIlllIIllIIIIlIlllI = llllllllllllllIlllIIllIIIIllIlII.getOpposite();
            llllllllllllllIlllIIllIIIIlIlIll.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, llllllllllllllIlllIIllIIIIllIIll + 0.27 * llllllllllllllIlllIIllIIIIlIlllI.getFrontOffsetX(), llllllllllllllIlllIIllIIIIllIIlI + 0.22, llllllllllllllIlllIIllIIIIllIIIl + 0.27 * llllllllllllllIlllIIllIIIIlIlllI.getFrontOffsetZ(), 0.0, 0.0, 0.0, new int[0]);
            llllllllllllllIlllIIllIIIIlIlIll.spawnParticle(EnumParticleTypes.FLAME, llllllllllllllIlllIIllIIIIllIIll + 0.27 * llllllllllllllIlllIIllIIIIlIlllI.getFrontOffsetX(), llllllllllllllIlllIIllIIIIllIIlI + 0.22, llllllllllllllIlllIIllIIIIllIIIl + 0.27 * llllllllllllllIlllIIllIIIIlIlllI.getFrontOffsetZ(), 0.0, 0.0, 0.0, new int[0]);
        }
        else {
            llllllllllllllIlllIIllIIIIlIlIll.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, llllllllllllllIlllIIllIIIIllIIll, llllllllllllllIlllIIllIIIIllIIlI, llllllllllllllIlllIIllIIIIllIIIl, 0.0, 0.0, 0.0, new int[0]);
            llllllllllllllIlllIIllIIIIlIlIll.spawnParticle(EnumParticleTypes.FLAME, llllllllllllllIlllIIllIIIIllIIll, llllllllllllllIlllIIllIIIIllIIlI, llllllllllllllIlllIIllIIIIllIIIl, 0.0, 0.0, 0.0, new int[0]);
        }
    }
    
    @Override
    public boolean canPlaceBlockAt(final World llllllllllllllIlllIIllIIlIlllIlI, final BlockPos llllllllllllllIlllIIllIIlIlllIIl) {
        for (final EnumFacing llllllllllllllIlllIIllIIlIlllIII : BlockTorch.FACING.getAllowedValues()) {
            if (this.canPlaceAt(llllllllllllllIlllIIllIIlIlllIlI, llllllllllllllIlllIIllIIlIlllIIl, llllllllllllllIlllIIllIIlIlllIII)) {
                return true;
            }
        }
        return false;
    }
    
    private boolean canPlaceAt(final World llllllllllllllIlllIIllIIlIlIlIIl, final BlockPos llllllllllllllIlllIIllIIlIlIIIII, final EnumFacing llllllllllllllIlllIIllIIlIlIIlll) {
        final BlockPos llllllllllllllIlllIIllIIlIlIIllI = llllllllllllllIlllIIllIIlIlIIIII.offset(llllllllllllllIlllIIllIIlIlIIlll.getOpposite());
        final IBlockState llllllllllllllIlllIIllIIlIlIIlIl = llllllllllllllIlllIIllIIlIlIlIIl.getBlockState(llllllllllllllIlllIIllIIlIlIIllI);
        final Block llllllllllllllIlllIIllIIlIlIIlII = llllllllllllllIlllIIllIIlIlIIlIl.getBlock();
        final BlockFaceShape llllllllllllllIlllIIllIIlIlIIIll = llllllllllllllIlllIIllIIlIlIIlIl.func_193401_d(llllllllllllllIlllIIllIIlIlIlIIl, llllllllllllllIlllIIllIIlIlIIllI, llllllllllllllIlllIIllIIlIlIIlll);
        return (llllllllllllllIlllIIllIIlIlIIlll.equals(EnumFacing.UP) && this.canPlaceOn(llllllllllllllIlllIIllIIlIlIlIIl, llllllllllllllIlllIIllIIlIlIIllI)) || (llllllllllllllIlllIIllIIlIlIIlll != EnumFacing.UP && llllllllllllllIlllIIllIIlIlIIlll != EnumFacing.DOWN && (!Block.func_193382_c(llllllllllllllIlllIIllIIlIlIIlII) && llllllllllllllIlllIIllIIlIlIIIll == BlockFaceShape.SOLID));
    }
    
    @Nullable
    @Override
    public AxisAlignedBB getCollisionBoundingBox(final IBlockState llllllllllllllIlllIIllIIllIlIlll, final IBlockAccess llllllllllllllIlllIIllIIllIlIllI, final BlockPos llllllllllllllIlllIIllIIllIlIlIl) {
        return BlockTorch.NULL_AABB;
    }
    
    @Override
    public BlockRenderLayer getBlockLayer() {
        return BlockRenderLayer.CUTOUT;
    }
    
    @Override
    public AxisAlignedBB getBoundingBox(final IBlockState llllllllllllllIlllIIllIIllIlllII, final IBlockAccess llllllllllllllIlllIIllIIllIllIll, final BlockPos llllllllllllllIlllIIllIIllIllIlI) {
        switch ($SWITCH_TABLE$net$minecraft$util$EnumFacing()[llllllllllllllIlllIIllIIllIlllII.getValue((IProperty<EnumFacing>)BlockTorch.FACING).ordinal()]) {
            case 6: {
                return BlockTorch.TORCH_EAST_AABB;
            }
            case 5: {
                return BlockTorch.TORCH_WEST_AABB;
            }
            case 4: {
                return BlockTorch.TORCH_SOUTH_AABB;
            }
            case 3: {
                return BlockTorch.TORCH_NORTH_AABB;
            }
            default: {
                return BlockTorch.STANDING_AABB;
            }
        }
    }
    
    @Override
    public BlockFaceShape func_193383_a(final IBlockAccess llllllllllllllIlllIIllIIIIIIIIII, final IBlockState llllllllllllllIlllIIlIllllllllll, final BlockPos llllllllllllllIlllIIlIlllllllllI, final EnumFacing llllllllllllllIlllIIlIllllllllIl) {
        return BlockFaceShape.UNDEFINED;
    }
    
    static {
        FACING = PropertyDirection.create("facing", (Predicate<EnumFacing>)new Predicate<EnumFacing>() {
            public boolean apply(@Nullable final EnumFacing lllllllllllllIIIlIIllIlIIIlIIIll) {
                return lllllllllllllIIIlIIllIlIIIlIIIll != EnumFacing.DOWN;
            }
        });
        STANDING_AABB = new AxisAlignedBB(0.4000000059604645, 0.0, 0.4000000059604645, 0.6000000238418579, 0.6000000238418579, 0.6000000238418579);
        TORCH_NORTH_AABB = new AxisAlignedBB(0.3499999940395355, 0.20000000298023224, 0.699999988079071, 0.6499999761581421, 0.800000011920929, 1.0);
        TORCH_SOUTH_AABB = new AxisAlignedBB(0.3499999940395355, 0.20000000298023224, 0.0, 0.6499999761581421, 0.800000011920929, 0.30000001192092896);
        TORCH_WEST_AABB = new AxisAlignedBB(0.699999988079071, 0.20000000298023224, 0.3499999940395355, 1.0, 0.800000011920929, 0.6499999761581421);
        TORCH_EAST_AABB = new AxisAlignedBB(0.0, 0.20000000298023224, 0.3499999940395355, 0.30000001192092896, 0.800000011920929, 0.6499999761581421);
    }
    
    @Override
    public void neighborChanged(final IBlockState llllllllllllllIlllIIllIIIllIllIl, final World llllllllllllllIlllIIllIIIlllIIlI, final BlockPos llllllllllllllIlllIIllIIIllIlIll, final Block llllllllllllllIlllIIllIIIlllIIII, final BlockPos llllllllllllllIlllIIllIIIllIllll) {
        this.onNeighborChangeInternal(llllllllllllllIlllIIllIIIlllIIlI, llllllllllllllIlllIIllIIIllIlIll, llllllllllllllIlllIIllIIIllIllIl);
    }
    
    @Override
    public boolean isOpaqueCube(final IBlockState llllllllllllllIlllIIllIIllIlIIll) {
        return false;
    }
    
    protected boolean onNeighborChangeInternal(final World llllllllllllllIlllIIllIIIllIIIII, final BlockPos llllllllllllllIlllIIllIIIlIlIllI, final IBlockState llllllllllllllIlllIIllIIIlIlIlIl) {
        if (!this.checkForDrop(llllllllllllllIlllIIllIIIllIIIII, llllllllllllllIlllIIllIIIlIlIllI, llllllllllllllIlllIIllIIIlIlIlIl)) {
            return true;
        }
        final EnumFacing llllllllllllllIlllIIllIIIlIlllIl = llllllllllllllIlllIIllIIIlIlIlIl.getValue((IProperty<EnumFacing>)BlockTorch.FACING);
        final EnumFacing.Axis llllllllllllllIlllIIllIIIlIlllII = llllllllllllllIlllIIllIIIlIlllIl.getAxis();
        final EnumFacing llllllllllllllIlllIIllIIIlIllIll = llllllllllllllIlllIIllIIIlIlllIl.getOpposite();
        final BlockPos llllllllllllllIlllIIllIIIlIllIlI = llllllllllllllIlllIIllIIIlIlIllI.offset(llllllllllllllIlllIIllIIIlIllIll);
        boolean llllllllllllllIlllIIllIIIlIllIIl = false;
        if (llllllllllllllIlllIIllIIIlIlllII.isHorizontal() && llllllllllllllIlllIIllIIIllIIIII.getBlockState(llllllllllllllIlllIIllIIIlIllIlI).func_193401_d(llllllllllllllIlllIIllIIIllIIIII, llllllllllllllIlllIIllIIIlIllIlI, llllllllllllllIlllIIllIIIlIlllIl) != BlockFaceShape.SOLID) {
            llllllllllllllIlllIIllIIIlIllIIl = true;
        }
        else if (llllllllllllllIlllIIllIIIlIlllII.isVertical() && !this.canPlaceOn(llllllllllllllIlllIIllIIIllIIIII, llllllllllllllIlllIIllIIIlIllIlI)) {
            llllllllllllllIlllIIllIIIlIllIIl = true;
        }
        if (llllllllllllllIlllIIllIIIlIllIIl) {
            this.dropBlockAsItem(llllllllllllllIlllIIllIIIllIIIII, llllllllllllllIlllIIllIIIlIlIllI, llllllllllllllIlllIIllIIIlIlIlIl, 0);
            llllllllllllllIlllIIllIIIllIIIII.setBlockToAir(llllllllllllllIlllIIllIIIlIlIllI);
            return true;
        }
        return false;
    }
    
    protected BlockTorch() {
        super(Material.CIRCUITS);
        this.setDefaultState(this.blockState.getBaseState().withProperty((IProperty<Comparable>)BlockTorch.FACING, EnumFacing.UP));
        this.setTickRandomly(true);
        this.setCreativeTab(CreativeTabs.DECORATIONS);
    }
    
    @Override
    public boolean isFullCube(final IBlockState llllllllllllllIlllIIllIIllIlIIIl) {
        return false;
    }
    
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, (IProperty<?>[])new IProperty[] { BlockTorch.FACING });
    }
    
    @Override
    public IBlockState withMirror(final IBlockState llllllllllllllIlllIIllIIIIIIlIII, final Mirror llllllllllllllIlllIIllIIIIIIIlIl) {
        return llllllllllllllIlllIIllIIIIIIlIII.withRotation(llllllllllllllIlllIIllIIIIIIIlIl.toRotation(llllllllllllllIlllIIllIIIIIIlIII.getValue((IProperty<EnumFacing>)BlockTorch.FACING)));
    }
    
    @Override
    public int getMetaFromState(final IBlockState llllllllllllllIlllIIllIIIIIlIllI) {
        int llllllllllllllIlllIIllIIIIIlIlIl = 0;
        switch ($SWITCH_TABLE$net$minecraft$util$EnumFacing()[llllllllllllllIlllIIllIIIIIlIllI.getValue((IProperty<EnumFacing>)BlockTorch.FACING).ordinal()]) {
            case 6: {
                llllllllllllllIlllIIllIIIIIlIlIl |= 0x1;
                break;
            }
            case 5: {
                llllllllllllllIlllIIllIIIIIlIlIl |= 0x2;
                break;
            }
            case 4: {
                llllllllllllllIlllIIllIIIIIlIlIl |= 0x3;
                break;
            }
            case 3: {
                llllllllllllllIlllIIllIIIIIlIlIl |= 0x4;
                break;
            }
            default: {
                llllllllllllllIlllIIllIIIIIlIlIl |= 0x5;
                break;
            }
        }
        return llllllllllllllIlllIIllIIIIIlIlIl;
    }
    
    private boolean canPlaceOn(final World llllllllllllllIlllIIllIIllIIIlIl, final BlockPos llllllllllllllIlllIIllIIllIIIlII) {
        final Block llllllllllllllIlllIIllIIllIIlIII = llllllllllllllIlllIIllIIllIIIlIl.getBlockState(llllllllllllllIlllIIllIIllIIIlII).getBlock();
        final boolean llllllllllllllIlllIIllIIllIIIlll = llllllllllllllIlllIIllIIllIIlIII == Blocks.END_GATEWAY || llllllllllllllIlllIIllIIllIIlIII == Blocks.LIT_PUMPKIN;
        if (llllllllllllllIlllIIllIIllIIIlIl.getBlockState(llllllllllllllIlllIIllIIllIIIlII).isFullyOpaque()) {
            return !llllllllllllllIlllIIllIIllIIIlll;
        }
        final boolean llllllllllllllIlllIIllIIllIIIllI = llllllllllllllIlllIIllIIllIIlIII instanceof BlockFence || llllllllllllllIlllIIllIIllIIlIII == Blocks.GLASS || llllllllllllllIlllIIllIIllIIlIII == Blocks.COBBLESTONE_WALL || llllllllllllllIlllIIllIIllIIlIII == Blocks.STAINED_GLASS;
        return llllllllllllllIlllIIllIIllIIIllI && !llllllllllllllIlllIIllIIllIIIlll;
    }
    
    @Override
    public IBlockState getStateFromMeta(final int llllllllllllllIlllIIllIIIIIllllI) {
        IBlockState llllllllllllllIlllIIllIIIIIlllIl = this.getDefaultState();
        switch (llllllllllllllIlllIIllIIIIIllllI) {
            case 1: {
                llllllllllllllIlllIIllIIIIIlllIl = llllllllllllllIlllIIllIIIIIlllIl.withProperty((IProperty<Comparable>)BlockTorch.FACING, EnumFacing.EAST);
                break;
            }
            case 2: {
                llllllllllllllIlllIIllIIIIIlllIl = llllllllllllllIlllIIllIIIIIlllIl.withProperty((IProperty<Comparable>)BlockTorch.FACING, EnumFacing.WEST);
                break;
            }
            case 3: {
                llllllllllllllIlllIIllIIIIIlllIl = llllllllllllllIlllIIllIIIIIlllIl.withProperty((IProperty<Comparable>)BlockTorch.FACING, EnumFacing.SOUTH);
                break;
            }
            case 4: {
                llllllllllllllIlllIIllIIIIIlllIl = llllllllllllllIlllIIllIIIIIlllIl.withProperty((IProperty<Comparable>)BlockTorch.FACING, EnumFacing.NORTH);
                break;
            }
            default: {
                llllllllllllllIlllIIllIIIIIlllIl = llllllllllllllIlllIIllIIIIIlllIl.withProperty((IProperty<Comparable>)BlockTorch.FACING, EnumFacing.UP);
                break;
            }
        }
        return llllllllllllllIlllIIllIIIIIlllIl;
    }
    
    @Override
    public IBlockState withRotation(final IBlockState llllllllllllllIlllIIllIIIIIIllll, final Rotation llllllllllllllIlllIIllIIIIIIllII) {
        return llllllllllllllIlllIIllIIIIIIllll.withProperty((IProperty<Comparable>)BlockTorch.FACING, llllllllllllllIlllIIllIIIIIIllII.rotate(llllllllllllllIlllIIllIIIIIIllll.getValue((IProperty<EnumFacing>)BlockTorch.FACING)));
    }
}
