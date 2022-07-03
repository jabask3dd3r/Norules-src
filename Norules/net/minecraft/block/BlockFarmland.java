package net.minecraft.block;

import net.minecraft.block.properties.*;
import net.minecraft.util.math.*;
import net.minecraft.world.*;
import net.minecraft.util.*;
import net.minecraft.init.*;
import net.minecraft.entity.*;
import net.minecraft.entity.player.*;
import java.util.*;
import net.minecraft.item.*;
import net.minecraft.block.material.*;
import net.minecraft.block.state.*;

public class BlockFarmland extends Block
{
    protected static final /* synthetic */ AxisAlignedBB field_194405_c;
    public static final /* synthetic */ PropertyInteger MOISTURE;
    protected static final /* synthetic */ AxisAlignedBB FARMLAND_AABB;
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$EnumFacing;
    
    @Override
    public int getMetaFromState(final IBlockState llllllllllllIllllIlllllIllIllIII) {
        return llllllllllllIllllIlllllIllIllIII.getValue((IProperty<Integer>)BlockFarmland.MOISTURE);
    }
    
    @Override
    public void neighborChanged(final IBlockState llllllllllllIllllIllllllIIIIlllI, final World llllllllllllIllllIllllllIIIIllIl, final BlockPos llllllllllllIllllIllllllIIIlIIlI, final Block llllllllllllIllllIllllllIIIIlIll, final BlockPos llllllllllllIllllIllllllIIIlIIII) {
        super.neighborChanged(llllllllllllIllllIllllllIIIIlllI, llllllllllllIllllIllllllIIIIllIl, llllllllllllIllllIllllllIIIlIIlI, llllllllllllIllllIllllllIIIIlIll, llllllllllllIllllIllllllIIIlIIII);
        if (llllllllllllIllllIllllllIIIIllIl.getBlockState(llllllllllllIllllIllllllIIIlIIlI.up()).getMaterial().isSolid()) {
            func_190970_b(llllllllllllIllllIllllllIIIIllIl, llllllllllllIllllIllllllIIIlIIlI);
        }
    }
    
    private boolean hasCrops(final World llllllllllllIllllIllllllIIlIllIl, final BlockPos llllllllllllIllllIllllllIIlIllII) {
        final Block llllllllllllIllllIllllllIIlIlIll = llllllllllllIllllIllllllIIlIllIl.getBlockState(llllllllllllIllllIllllllIIlIllII.up()).getBlock();
        return llllllllllllIllllIllllllIIlIlIll instanceof BlockCrops || llllllllllllIllllIllllllIIlIlIll instanceof BlockStem;
    }
    
    @Override
    public boolean shouldSideBeRendered(final IBlockState llllllllllllIllllIlllllIllllIlIl, final IBlockAccess llllllllllllIllllIlllllIllllIlII, final BlockPos llllllllllllIllllIlllllIlllIllII, final EnumFacing llllllllllllIllllIlllllIllllIIlI) {
        switch ($SWITCH_TABLE$net$minecraft$util$EnumFacing()[llllllllllllIllllIlllllIllllIIlI.ordinal()]) {
            case 2: {
                return true;
            }
            case 3:
            case 4:
            case 5:
            case 6: {
                final IBlockState llllllllllllIllllIlllllIllllIIIl = llllllllllllIllllIlllllIllllIlII.getBlockState(llllllllllllIllllIlllllIlllIllII.offset(llllllllllllIllllIlllllIllllIIlI));
                final Block llllllllllllIllllIlllllIllllIIII = llllllllllllIllllIlllllIllllIIIl.getBlock();
                return !llllllllllllIllllIlllllIllllIIIl.isOpaqueCube() && llllllllllllIllllIlllllIllllIIII != Blocks.FARMLAND && llllllllllllIllllIlllllIllllIIII != Blocks.GRASS_PATH;
            }
            default: {
                return super.shouldSideBeRendered(llllllllllllIllllIlllllIllllIlIl, llllllllllllIllllIlllllIllllIlII, llllllllllllIllllIlllllIlllIllII, llllllllllllIllllIlllllIllllIIlI);
            }
        }
    }
    
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, (IProperty<?>[])new IProperty[] { BlockFarmland.MOISTURE });
    }
    
    @Override
    public void onBlockAdded(final World llllllllllllIllllIllllllIIIIIlII, final BlockPos llllllllllllIllllIllllllIIIIIIll, final IBlockState llllllllllllIllllIllllllIIIIIIlI) {
        super.onBlockAdded(llllllllllllIllllIllllllIIIIIlII, llllllllllllIllllIllllllIIIIIIll, llllllllllllIllllIllllllIIIIIIlI);
        if (llllllllllllIllllIllllllIIIIIlII.getBlockState(llllllllllllIllllIllllllIIIIIIll.up()).getMaterial().isSolid()) {
            func_190970_b(llllllllllllIllllIllllllIIIIIlII, llllllllllllIllllIllllllIIIIIIll);
        }
    }
    
    @Override
    public void onFallenUpon(final World llllllllllllIllllIllllllIlIIlIll, final BlockPos llllllllllllIllllIllllllIlIIIlIl, final Entity llllllllllllIllllIllllllIlIIlIIl, final float llllllllllllIllllIllllllIlIIlIII) {
        if (!llllllllllllIllllIllllllIlIIlIll.isRemote && llllllllllllIllllIllllllIlIIlIll.rand.nextFloat() < llllllllllllIllllIllllllIlIIlIII - 0.5f && llllllllllllIllllIllllllIlIIlIIl instanceof EntityLivingBase && (llllllllllllIllllIllllllIlIIlIIl instanceof EntityPlayer || llllllllllllIllllIllllllIlIIlIll.getGameRules().getBoolean("mobGriefing")) && llllllllllllIllllIllllllIlIIlIIl.width * llllllllllllIllllIllllllIlIIlIIl.width * llllllllllllIllllIllllllIlIIlIIl.height > 0.512f) {
            func_190970_b(llllllllllllIllllIllllllIlIIlIll, llllllllllllIllllIllllllIlIIIlIl);
        }
        super.onFallenUpon(llllllllllllIllllIllllllIlIIlIll, llllllllllllIllllIllllllIlIIIlIl, llllllllllllIllllIllllllIlIIlIIl, llllllllllllIllllIllllllIlIIlIII);
    }
    
    @Override
    public IBlockState getStateFromMeta(final int llllllllllllIllllIlllllIllIllIll) {
        return this.getDefaultState().withProperty((IProperty<Comparable>)BlockFarmland.MOISTURE, llllllllllllIllllIlllllIllIllIll & 0x7);
    }
    
    static {
        MOISTURE = PropertyInteger.create("moisture", 0, 7);
        FARMLAND_AABB = new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 0.9375, 1.0);
        field_194405_c = new AxisAlignedBB(0.0, 0.9375, 0.0, 1.0, 1.0, 1.0);
    }
    
    protected static void func_190970_b(final World llllllllllllIllllIllllllIIllIlll, final BlockPos llllllllllllIllllIllllllIIllIllI) {
        llllllllllllIllllIllllllIIllIlll.setBlockState(llllllllllllIllllIllllllIIllIllI, Blocks.DIRT.getDefaultState());
        final AxisAlignedBB llllllllllllIllllIllllllIIlllIlI = BlockFarmland.field_194405_c.offset(llllllllllllIllllIllllllIIllIllI);
        for (final Entity llllllllllllIllllIllllllIIlllIIl : llllllllllllIllllIllllllIIllIlll.getEntitiesWithinAABBExcludingEntity(null, llllllllllllIllllIllllllIIlllIlI)) {
            final double llllllllllllIllllIllllllIIlllIII = Math.min(llllllllllllIllllIllllllIIlllIlI.maxY - llllllllllllIllllIllllllIIlllIlI.minY, llllllllllllIllllIllllllIIlllIlI.maxY - llllllllllllIllllIllllllIIlllIIl.getEntityBoundingBox().minY);
            llllllllllllIllllIllllllIIlllIIl.setPositionAndUpdate(llllllllllllIllllIllllllIIlllIIl.posX, llllllllllllIllllIllllllIIlllIIl.posY + llllllllllllIllllIllllllIIlllIII + 0.001, llllllllllllIllllIllllllIIlllIIl.posZ);
        }
    }
    
    @Override
    public Item getItemDropped(final IBlockState llllllllllllIllllIlllllIlllIIlIl, final Random llllllllllllIllllIlllllIlllIIlII, final int llllllllllllIllllIlllllIlllIIIIl) {
        return Blocks.DIRT.getItemDropped(Blocks.DIRT.getDefaultState().withProperty(BlockDirt.VARIANT, BlockDirt.DirtType.DIRT), llllllllllllIllllIlllllIlllIIlII, llllllllllllIllllIlllllIlllIIIIl);
    }
    
    @Override
    public AxisAlignedBB getBoundingBox(final IBlockState llllllllllllIllllIllllllIllIlIII, final IBlockAccess llllllllllllIllllIllllllIllIIlll, final BlockPos llllllllllllIllllIllllllIllIIllI) {
        return BlockFarmland.FARMLAND_AABB;
    }
    
    protected BlockFarmland() {
        super(Material.GROUND);
        this.setDefaultState(this.blockState.getBaseState().withProperty((IProperty<Comparable>)BlockFarmland.MOISTURE, 0));
        this.setTickRandomly(true);
        this.setLightOpacity(255);
    }
    
    @Override
    public BlockFaceShape func_193383_a(final IBlockAccess llllllllllllIllllIlllllIllIlIIIl, final IBlockState llllllllllllIllllIlllllIllIlIIII, final BlockPos llllllllllllIllllIlllllIllIIllll, final EnumFacing llllllllllllIllllIlllllIllIIllIl) {
        return (llllllllllllIllllIlllllIllIIllIl == EnumFacing.DOWN) ? BlockFaceShape.SOLID : BlockFaceShape.UNDEFINED;
    }
    
    @Override
    public void updateTick(final World llllllllllllIllllIllllllIlIlIlIl, final BlockPos llllllllllllIllllIllllllIlIlIlII, final IBlockState llllllllllllIllllIllllllIlIllIIl, final Random llllllllllllIllllIllllllIlIllIII) {
        final int llllllllllllIllllIllllllIlIlIlll = llllllllllllIllllIllllllIlIllIIl.getValue((IProperty<Integer>)BlockFarmland.MOISTURE);
        if (!this.hasWater(llllllllllllIllllIllllllIlIlIlIl, llllllllllllIllllIllllllIlIlIlII) && !llllllllllllIllllIllllllIlIlIlIl.isRainingAt(llllllllllllIllllIllllllIlIlIlII.up())) {
            if (llllllllllllIllllIllllllIlIlIlll > 0) {
                llllllllllllIllllIllllllIlIlIlIl.setBlockState(llllllllllllIllllIllllllIlIlIlII, llllllllllllIllllIllllllIlIllIIl.withProperty((IProperty<Comparable>)BlockFarmland.MOISTURE, llllllllllllIllllIllllllIlIlIlll - 1), 2);
            }
            else if (!this.hasCrops(llllllllllllIllllIllllllIlIlIlIl, llllllllllllIllllIllllllIlIlIlII)) {
                func_190970_b(llllllllllllIllllIllllllIlIlIlIl, llllllllllllIllllIllllllIlIlIlII);
            }
        }
        else if (llllllllllllIllllIllllllIlIlIlll < 7) {
            llllllllllllIllllIllllllIlIlIlIl.setBlockState(llllllllllllIllllIllllllIlIlIlII, llllllllllllIllllIllllllIlIllIIl.withProperty((IProperty<Comparable>)BlockFarmland.MOISTURE, 7), 2);
        }
    }
    
    @Override
    public boolean isOpaqueCube(final IBlockState llllllllllllIllllIllllllIllIIlII) {
        return false;
    }
    
    @Override
    public boolean isFullCube(final IBlockState llllllllllllIllllIllllllIllIIIlI) {
        return false;
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$EnumFacing() {
        final int[] $switch_TABLE$net$minecraft$util$EnumFacing = BlockFarmland.$SWITCH_TABLE$net$minecraft$util$EnumFacing;
        if ($switch_TABLE$net$minecraft$util$EnumFacing != null) {
            return $switch_TABLE$net$minecraft$util$EnumFacing;
        }
        final short llllllllllllIllllIlllllIllIIlIll = (Object)new int[EnumFacing.values().length];
        try {
            llllllllllllIllllIlllllIllIIlIll[EnumFacing.DOWN.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            llllllllllllIllllIlllllIllIIlIll[EnumFacing.EAST.ordinal()] = 6;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            llllllllllllIllllIlllllIllIIlIll[EnumFacing.NORTH.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            llllllllllllIllllIlllllIllIIlIll[EnumFacing.SOUTH.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        try {
            llllllllllllIllllIlllllIllIIlIll[EnumFacing.UP.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError5) {}
        try {
            llllllllllllIllllIlllllIllIIlIll[EnumFacing.WEST.ordinal()] = 5;
        }
        catch (NoSuchFieldError noSuchFieldError6) {}
        return BlockFarmland.$SWITCH_TABLE$net$minecraft$util$EnumFacing = (int[])(Object)llllllllllllIllllIlllllIllIIlIll;
    }
    
    private boolean hasWater(final World llllllllllllIllllIllllllIIIlllll, final BlockPos llllllllllllIllllIllllllIIIllllI) {
        for (final BlockPos.MutableBlockPos llllllllllllIllllIllllllIIlIIIII : BlockPos.getAllInBoxMutable(llllllllllllIllllIllllllIIIllllI.add(-4, 0, -4), llllllllllllIllllIllllllIIIllllI.add(4, 1, 4))) {
            if (llllllllllllIllllIllllllIIIlllll.getBlockState(llllllllllllIllllIllllllIIlIIIII).getMaterial() == Material.WATER) {
                return true;
            }
        }
        return false;
    }
}
