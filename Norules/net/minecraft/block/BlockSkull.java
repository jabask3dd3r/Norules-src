package net.minecraft.block;

import com.google.common.base.*;
import net.minecraft.block.properties.*;
import net.minecraft.util.text.translation.*;
import net.minecraft.util.math.*;
import net.minecraft.block.material.*;
import javax.annotation.*;
import net.minecraft.init.*;
import net.minecraft.item.*;
import net.minecraft.world.*;
import net.minecraft.tileentity.*;
import net.minecraft.block.state.*;
import net.minecraft.block.state.pattern.*;
import net.minecraft.entity.boss.*;
import net.minecraft.advancements.*;
import net.minecraft.entity.*;
import net.minecraft.util.*;
import java.util.*;
import net.minecraft.entity.player.*;
import net.minecraft.nbt.*;

public class BlockSkull extends BlockContainer
{
    public static final /* synthetic */ PropertyBool NODROP;
    protected static final /* synthetic */ AxisAlignedBB WEST_AABB;
    protected static final /* synthetic */ AxisAlignedBB SOUTH_AABB;
    public static final /* synthetic */ PropertyDirection FACING;
    private /* synthetic */ BlockPattern witherPattern;
    protected static final /* synthetic */ AxisAlignedBB NORTH_AABB;
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$EnumFacing;
    protected static final /* synthetic */ AxisAlignedBB EAST_AABB;
    protected static final /* synthetic */ AxisAlignedBB DEFAULT_AABB;
    private static final /* synthetic */ Predicate<BlockWorldState> IS_WITHER_SKELETON;
    private /* synthetic */ BlockPattern witherBasePattern;
    
    @Override
    public Item getItemDropped(final IBlockState lllllllllllllIlIIIlllIIllIIIIIIl, final Random lllllllllllllIlIIIlllIIllIIIIIII, final int lllllllllllllIlIIIlllIIlIlllllll) {
        return Items.SKULL;
    }
    
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, (IProperty<?>[])new IProperty[] { BlockSkull.FACING, BlockSkull.NODROP });
    }
    
    @Override
    public String getLocalizedName() {
        return I18n.translateToLocal("tile.skull.skeleton.name");
    }
    
    @Override
    public AxisAlignedBB getBoundingBox(final IBlockState lllllllllllllIlIIIlllIIlllIlllIl, final IBlockAccess lllllllllllllIlIIIlllIIlllIlllII, final BlockPos lllllllllllllIlIIIlllIIlllIllIll) {
        switch ($SWITCH_TABLE$net$minecraft$util$EnumFacing()[lllllllllllllIlIIIlllIIlllIlllIl.getValue((IProperty<EnumFacing>)BlockSkull.FACING).ordinal()]) {
            default: {
                return BlockSkull.DEFAULT_AABB;
            }
            case 3: {
                return BlockSkull.NORTH_AABB;
            }
            case 4: {
                return BlockSkull.SOUTH_AABB;
            }
            case 5: {
                return BlockSkull.WEST_AABB;
            }
            case 6: {
                return BlockSkull.EAST_AABB;
            }
        }
    }
    
    @Override
    public boolean isFullCube(final IBlockState lllllllllllllIlIIIlllIIllllIIIlI) {
        return false;
    }
    
    @Override
    public boolean func_190946_v(final IBlockState lllllllllllllIlIIIlllIIllllIIIII) {
        return true;
    }
    
    protected BlockSkull() {
        super(Material.CIRCUITS);
        this.setDefaultState(this.blockState.getBaseState().withProperty((IProperty<Comparable>)BlockSkull.FACING, EnumFacing.NORTH).withProperty((IProperty<Comparable>)BlockSkull.NODROP, false));
    }
    
    static {
        FACING = BlockDirectional.FACING;
        NODROP = PropertyBool.create("nodrop");
        IS_WITHER_SKELETON = (Predicate)new Predicate<BlockWorldState>() {
            public boolean apply(@Nullable final BlockWorldState lllllllllllllIlIIIIlIlIIlllIlIlI) {
                return lllllllllllllIlIIIIlIlIIlllIlIlI.getBlockState() != null && lllllllllllllIlIIIIlIlIIlllIlIlI.getBlockState().getBlock() == Blocks.SKULL && lllllllllllllIlIIIIlIlIIlllIlIlI.getTileEntity() instanceof TileEntitySkull && ((TileEntitySkull)lllllllllllllIlIIIIlIlIIlllIlIlI.getTileEntity()).getSkullType() == 1;
            }
        };
        DEFAULT_AABB = new AxisAlignedBB(0.25, 0.0, 0.25, 0.75, 0.5, 0.75);
        NORTH_AABB = new AxisAlignedBB(0.25, 0.25, 0.5, 0.75, 0.75, 1.0);
        SOUTH_AABB = new AxisAlignedBB(0.25, 0.25, 0.0, 0.75, 0.75, 0.5);
        WEST_AABB = new AxisAlignedBB(0.5, 0.25, 0.25, 1.0, 0.75, 0.75);
        EAST_AABB = new AxisAlignedBB(0.0, 0.25, 0.25, 0.5, 0.75, 0.75);
    }
    
    @Override
    public IBlockState withRotation(final IBlockState lllllllllllllIlIIIlllIIlIIllIlIl, final Rotation lllllllllllllIlIIIlllIIlIIllIlII) {
        return lllllllllllllIlIIIlllIIlIIllIlIl.withProperty((IProperty<Comparable>)BlockSkull.FACING, lllllllllllllIlIIIlllIIlIIllIlII.rotate(lllllllllllllIlIIIlllIIlIIllIlIl.getValue((IProperty<EnumFacing>)BlockSkull.FACING)));
    }
    
    public boolean canDispenserPlace(final World lllllllllllllIlIIIlllIIlIlllIlIl, final BlockPos lllllllllllllIlIIIlllIIlIlllIlII, final ItemStack lllllllllllllIlIIIlllIIlIlllIlll) {
        return lllllllllllllIlIIIlllIIlIlllIlll.getMetadata() == 1 && lllllllllllllIlIIIlllIIlIlllIlII.getY() >= 2 && lllllllllllllIlIIIlllIIlIlllIlIl.getDifficulty() != EnumDifficulty.PEACEFUL && !lllllllllllllIlIIIlllIIlIlllIlIl.isRemote && this.getWitherBasePattern().match(lllllllllllllIlIIIlllIIlIlllIlIl, lllllllllllllIlIIIlllIIlIlllIlII) != null;
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$EnumFacing() {
        final int[] $switch_TABLE$net$minecraft$util$EnumFacing = BlockSkull.$SWITCH_TABLE$net$minecraft$util$EnumFacing;
        if ($switch_TABLE$net$minecraft$util$EnumFacing != null) {
            return $switch_TABLE$net$minecraft$util$EnumFacing;
        }
        final Exception lllllllllllllIlIIIlllIIlIIIIlllI = (Object)new int[EnumFacing.values().length];
        try {
            lllllllllllllIlIIIlllIIlIIIIlllI[EnumFacing.DOWN.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            lllllllllllllIlIIIlllIIlIIIIlllI[EnumFacing.EAST.ordinal()] = 6;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            lllllllllllllIlIIIlllIIlIIIIlllI[EnumFacing.NORTH.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            lllllllllllllIlIIIlllIIlIIIIlllI[EnumFacing.SOUTH.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        try {
            lllllllllllllIlIIIlllIIlIIIIlllI[EnumFacing.UP.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError5) {}
        try {
            lllllllllllllIlIIIlllIIlIIIIlllI[EnumFacing.WEST.ordinal()] = 5;
        }
        catch (NoSuchFieldError noSuchFieldError6) {}
        return BlockSkull.$SWITCH_TABLE$net$minecraft$util$EnumFacing = (int[])(Object)lllllllllllllIlIIIlllIIlIIIIlllI;
    }
    
    @Override
    public IBlockState onBlockPlaced(final World lllllllllllllIlIIIlllIIlllIlIllI, final BlockPos lllllllllllllIlIIIlllIIlllIlIlIl, final EnumFacing lllllllllllllIlIIIlllIIlllIlIlII, final float lllllllllllllIlIIIlllIIlllIlIIll, final float lllllllllllllIlIIIlllIIlllIlIIlI, final float lllllllllllllIlIIIlllIIlllIlIIIl, final int lllllllllllllIlIIIlllIIlllIlIIII, final EntityLivingBase lllllllllllllIlIIIlllIIlllIIllll) {
        return this.getDefaultState().withProperty((IProperty<Comparable>)BlockSkull.FACING, lllllllllllllIlIIIlllIIlllIIllll.getHorizontalFacing()).withProperty((IProperty<Comparable>)BlockSkull.NODROP, false);
    }
    
    @Override
    public IBlockState withMirror(final IBlockState lllllllllllllIlIIIlllIIlIIlIlllI, final Mirror lllllllllllllIlIIIlllIIlIIlIllll) {
        return lllllllllllllIlIIIlllIIlIIlIlllI.withRotation(lllllllllllllIlIIIlllIIlIIlIllll.toRotation(lllllllllllllIlIIIlllIIlIIlIlllI.getValue((IProperty<EnumFacing>)BlockSkull.FACING)));
    }
    
    @Override
    public TileEntity createNewTileEntity(final World lllllllllllllIlIIIlllIIlllIIlIll, final int lllllllllllllIlIIIlllIIlllIIlIlI) {
        return new TileEntitySkull();
    }
    
    @Override
    public BlockFaceShape func_193383_a(final IBlockAccess lllllllllllllIlIIIlllIIlIIlIIIlI, final IBlockState lllllllllllllIlIIIlllIIlIIlIIIIl, final BlockPos lllllllllllllIlIIIlllIIlIIlIIIII, final EnumFacing lllllllllllllIlIIIlllIIlIIIlllll) {
        return BlockFaceShape.UNDEFINED;
    }
    
    protected BlockPattern getWitherPattern() {
        if (this.witherPattern == null) {
            this.witherPattern = FactoryBlockPattern.start().aisle("^^^", "###", "~#~").where('#', BlockWorldState.hasState((Predicate<IBlockState>)BlockStateMatcher.forBlock(Blocks.SOUL_SAND))).where('^', BlockSkull.IS_WITHER_SKELETON).where('~', BlockWorldState.hasState((Predicate<IBlockState>)BlockMaterialMatcher.forMaterial(Material.AIR))).build();
        }
        return this.witherPattern;
    }
    
    public void checkWitherSpawn(final World lllllllllllllIlIIIlllIIlIllIIlIl, final BlockPos lllllllllllllIlIIIlllIIlIllIIlII, final TileEntitySkull lllllllllllllIlIIIlllIIlIllIIIll) {
        if (lllllllllllllIlIIIlllIIlIllIIIll.getSkullType() == 1 && lllllllllllllIlIIIlllIIlIllIIlII.getY() >= 2 && lllllllllllllIlIIIlllIIlIllIIlIl.getDifficulty() != EnumDifficulty.PEACEFUL && !lllllllllllllIlIIIlllIIlIllIIlIl.isRemote) {
            final BlockPattern lllllllllllllIlIIIlllIIlIllIIIlI = this.getWitherPattern();
            final BlockPattern.PatternHelper lllllllllllllIlIIIlllIIlIllIIIIl = lllllllllllllIlIIIlllIIlIllIIIlI.match(lllllllllllllIlIIIlllIIlIllIIlIl, lllllllllllllIlIIIlllIIlIllIIlII);
            if (lllllllllllllIlIIIlllIIlIllIIIIl != null) {
                for (int lllllllllllllIlIIIlllIIlIllIIIII = 0; lllllllllllllIlIIIlllIIlIllIIIII < 3; ++lllllllllllllIlIIIlllIIlIllIIIII) {
                    final BlockWorldState lllllllllllllIlIIIlllIIlIlIlllll = lllllllllllllIlIIIlllIIlIllIIIIl.translateOffset(lllllllllllllIlIIIlllIIlIllIIIII, 0, 0);
                    lllllllllllllIlIIIlllIIlIllIIlIl.setBlockState(lllllllllllllIlIIIlllIIlIlIlllll.getPos(), lllllllllllllIlIIIlllIIlIlIlllll.getBlockState().withProperty((IProperty<Comparable>)BlockSkull.NODROP, true), 2);
                }
                for (int lllllllllllllIlIIIlllIIlIlIllllI = 0; lllllllllllllIlIIIlllIIlIlIllllI < lllllllllllllIlIIIlllIIlIllIIIlI.getPalmLength(); ++lllllllllllllIlIIIlllIIlIlIllllI) {
                    for (int lllllllllllllIlIIIlllIIlIlIlllIl = 0; lllllllllllllIlIIIlllIIlIlIlllIl < lllllllllllllIlIIIlllIIlIllIIIlI.getThumbLength(); ++lllllllllllllIlIIIlllIIlIlIlllIl) {
                        final BlockWorldState lllllllllllllIlIIIlllIIlIlIlllII = lllllllllllllIlIIIlllIIlIllIIIIl.translateOffset(lllllllllllllIlIIIlllIIlIlIllllI, lllllllllllllIlIIIlllIIlIlIlllIl, 0);
                        lllllllllllllIlIIIlllIIlIllIIlIl.setBlockState(lllllllllllllIlIIIlllIIlIlIlllII.getPos(), Blocks.AIR.getDefaultState(), 2);
                    }
                }
                final BlockPos lllllllllllllIlIIIlllIIlIlIllIll = lllllllllllllIlIIIlllIIlIllIIIIl.translateOffset(1, 0, 0).getPos();
                final EntityWither lllllllllllllIlIIIlllIIlIlIllIlI = new EntityWither(lllllllllllllIlIIIlllIIlIllIIlIl);
                final BlockPos lllllllllllllIlIIIlllIIlIlIllIIl = lllllllllllllIlIIIlllIIlIllIIIIl.translateOffset(1, 2, 0).getPos();
                lllllllllllllIlIIIlllIIlIlIllIlI.setLocationAndAngles(lllllllllllllIlIIIlllIIlIlIllIIl.getX() + 0.5, lllllllllllllIlIIIlllIIlIlIllIIl.getY() + 0.55, lllllllllllllIlIIIlllIIlIlIllIIl.getZ() + 0.5, (lllllllllllllIlIIIlllIIlIllIIIIl.getForwards().getAxis() == EnumFacing.Axis.X) ? 0.0f : 90.0f, 0.0f);
                lllllllllllllIlIIIlllIIlIlIllIlI.renderYawOffset = ((lllllllllllllIlIIIlllIIlIllIIIIl.getForwards().getAxis() == EnumFacing.Axis.X) ? 0.0f : 90.0f);
                lllllllllllllIlIIIlllIIlIlIllIlI.ignite();
                for (final EntityPlayerMP lllllllllllllIlIIIlllIIlIlIllIII : lllllllllllllIlIIIlllIIlIllIIlIl.getEntitiesWithinAABB((Class<? extends EntityPlayerMP>)EntityPlayerMP.class, lllllllllllllIlIIIlllIIlIlIllIlI.getEntityBoundingBox().expandXyz(50.0))) {
                    CriteriaTriggers.field_192133_m.func_192229_a(lllllllllllllIlIIIlllIIlIlIllIII, lllllllllllllIlIIIlllIIlIlIllIlI);
                }
                lllllllllllllIlIIIlllIIlIllIIlIl.spawnEntityInWorld(lllllllllllllIlIIIlllIIlIlIllIlI);
                for (int lllllllllllllIlIIIlllIIlIlIlIlll = 0; lllllllllllllIlIIIlllIIlIlIlIlll < 120; ++lllllllllllllIlIIIlllIIlIlIlIlll) {
                    lllllllllllllIlIIIlllIIlIllIIlIl.spawnParticle(EnumParticleTypes.SNOWBALL, lllllllllllllIlIIIlllIIlIlIllIll.getX() + lllllllllllllIlIIIlllIIlIllIIlIl.rand.nextDouble(), lllllllllllllIlIIIlllIIlIlIllIll.getY() - 2 + lllllllllllllIlIIIlllIIlIllIIlIl.rand.nextDouble() * 3.9, lllllllllllllIlIIIlllIIlIlIllIll.getZ() + lllllllllllllIlIIIlllIIlIllIIlIl.rand.nextDouble(), 0.0, 0.0, 0.0, new int[0]);
                }
                for (int lllllllllllllIlIIIlllIIlIlIlIllI = 0; lllllllllllllIlIIIlllIIlIlIlIllI < lllllllllllllIlIIIlllIIlIllIIIlI.getPalmLength(); ++lllllllllllllIlIIIlllIIlIlIlIllI) {
                    for (int lllllllllllllIlIIIlllIIlIlIlIlIl = 0; lllllllllllllIlIIIlllIIlIlIlIlIl < lllllllllllllIlIIIlllIIlIllIIIlI.getThumbLength(); ++lllllllllllllIlIIIlllIIlIlIlIlIl) {
                        final BlockWorldState lllllllllllllIlIIIlllIIlIlIlIlII = lllllllllllllIlIIIlllIIlIllIIIIl.translateOffset(lllllllllllllIlIIIlllIIlIlIlIllI, lllllllllllllIlIIIlllIIlIlIlIlIl, 0);
                        lllllllllllllIlIIIlllIIlIllIIlIl.notifyNeighborsRespectDebug(lllllllllllllIlIIIlllIIlIlIlIlII.getPos(), Blocks.AIR, false);
                    }
                }
            }
        }
    }
    
    @Override
    public void dropBlockAsItemWithChance(final World lllllllllllllIlIIIlllIIllIlllIlI, final BlockPos lllllllllllllIlIIIlllIIllIlllIIl, final IBlockState lllllllllllllIlIIIlllIIllIlllIII, final float lllllllllllllIlIIIlllIIllIllIlll, final int lllllllllllllIlIIIlllIIllIllIllI) {
    }
    
    @Override
    public void onBlockHarvested(final World lllllllllllllIlIIIlllIIllIlIlIIl, final BlockPos lllllllllllllIlIIIlllIIllIlIlIII, IBlockState lllllllllllllIlIIIlllIIllIlIIllI, final EntityPlayer lllllllllllllIlIIIlllIIllIlIllII) {
        if (lllllllllllllIlIIIlllIIllIlIllII.capabilities.isCreativeMode) {
            lllllllllllllIlIIIlllIIllIlIIllI = lllllllllllllIlIIIlllIIllIlIIllI.withProperty((IProperty<Comparable>)BlockSkull.NODROP, true);
            lllllllllllllIlIIIlllIIllIlIlIIl.setBlockState(lllllllllllllIlIIIlllIIllIlIlIII, lllllllllllllIlIIIlllIIllIlIIllI, 4);
        }
        super.onBlockHarvested(lllllllllllllIlIIIlllIIllIlIlIIl, lllllllllllllIlIIIlllIIllIlIlIII, lllllllllllllIlIIIlllIIllIlIIllI, lllllllllllllIlIIIlllIIllIlIllII);
    }
    
    @Override
    public boolean isOpaqueCube(final IBlockState lllllllllllllIlIIIlllIIllllIIlII) {
        return false;
    }
    
    @Override
    public void breakBlock(final World lllllllllllllIlIIIlllIIllIIlIIIl, final BlockPos lllllllllllllIlIIIlllIIllIIlIIII, final IBlockState lllllllllllllIlIIIlllIIllIIIllll) {
        if (!lllllllllllllIlIIIlllIIllIIlIIIl.isRemote) {
            if (!lllllllllllllIlIIIlllIIllIIIllll.getValue((IProperty<Boolean>)BlockSkull.NODROP)) {
                final TileEntity lllllllllllllIlIIIlllIIllIIIlllI = lllllllllllllIlIIIlllIIllIIlIIIl.getTileEntity(lllllllllllllIlIIIlllIIllIIlIIII);
                if (lllllllllllllIlIIIlllIIllIIIlllI instanceof TileEntitySkull) {
                    final TileEntitySkull lllllllllllllIlIIIlllIIllIIIllIl = (TileEntitySkull)lllllllllllllIlIIIlllIIllIIIlllI;
                    final ItemStack lllllllllllllIlIIIlllIIllIIIllII = this.getItem(lllllllllllllIlIIIlllIIllIIlIIIl, lllllllllllllIlIIIlllIIllIIlIIII, lllllllllllllIlIIIlllIIllIIIllll);
                    if (lllllllllllllIlIIIlllIIllIIIllIl.getSkullType() == 3 && lllllllllllllIlIIIlllIIllIIIllIl.getPlayerProfile() != null) {
                        lllllllllllllIlIIIlllIIllIIIllII.setTagCompound(new NBTTagCompound());
                        final NBTTagCompound lllllllllllllIlIIIlllIIllIIIlIll = new NBTTagCompound();
                        NBTUtil.writeGameProfile(lllllllllllllIlIIIlllIIllIIIlIll, lllllllllllllIlIIIlllIIllIIIllIl.getPlayerProfile());
                        lllllllllllllIlIIIlllIIllIIIllII.getTagCompound().setTag("SkullOwner", lllllllllllllIlIIIlllIIllIIIlIll);
                    }
                    Block.spawnAsEntity(lllllllllllllIlIIIlllIIllIIlIIIl, lllllllllllllIlIIIlllIIllIIlIIII, lllllllllllllIlIIIlllIIllIIIllII);
                }
            }
            super.breakBlock(lllllllllllllIlIIIlllIIllIIlIIIl, lllllllllllllIlIIIlllIIllIIlIIII, lllllllllllllIlIIIlllIIllIIIllll);
        }
    }
    
    @Override
    public ItemStack getItem(final World lllllllllllllIlIIIlllIIlllIIIlII, final BlockPos lllllllllllllIlIIIlllIIlllIIIIll, final IBlockState lllllllllllllIlIIIlllIIlllIIIIlI) {
        int lllllllllllllIlIIIlllIIlllIIIIIl = 0;
        final TileEntity lllllllllllllIlIIIlllIIlllIIIIII = lllllllllllllIlIIIlllIIlllIIIlII.getTileEntity(lllllllllllllIlIIIlllIIlllIIIIll);
        if (lllllllllllllIlIIIlllIIlllIIIIII instanceof TileEntitySkull) {
            lllllllllllllIlIIIlllIIlllIIIIIl = ((TileEntitySkull)lllllllllllllIlIIIlllIIlllIIIIII).getSkullType();
        }
        return new ItemStack(Items.SKULL, 1, lllllllllllllIlIIIlllIIlllIIIIIl);
    }
    
    @Override
    public int getMetaFromState(final IBlockState lllllllllllllIlIIIlllIIlIIllllII) {
        int lllllllllllllIlIIIlllIIlIIllllIl = 0;
        lllllllllllllIlIIIlllIIlIIllllIl |= lllllllllllllIlIIIlllIIlIIllllII.getValue((IProperty<EnumFacing>)BlockSkull.FACING).getIndex();
        if (lllllllllllllIlIIIlllIIlIIllllII.getValue((IProperty<Boolean>)BlockSkull.NODROP)) {
            lllllllllllllIlIIIlllIIlIIllllIl |= 0x8;
        }
        return lllllllllllllIlIIIlllIIlIIllllIl;
    }
    
    protected BlockPattern getWitherBasePattern() {
        if (this.witherBasePattern == null) {
            this.witherBasePattern = FactoryBlockPattern.start().aisle("   ", "###", "~#~").where('#', BlockWorldState.hasState((Predicate<IBlockState>)BlockStateMatcher.forBlock(Blocks.SOUL_SAND))).where('~', BlockWorldState.hasState((Predicate<IBlockState>)BlockMaterialMatcher.forMaterial(Material.AIR))).build();
        }
        return this.witherBasePattern;
    }
    
    @Override
    public IBlockState getStateFromMeta(final int lllllllllllllIlIIIlllIIlIlIIIlII) {
        return this.getDefaultState().withProperty((IProperty<Comparable>)BlockSkull.FACING, EnumFacing.getFront(lllllllllllllIlIIIlllIIlIlIIIlII & 0x7)).withProperty((IProperty<Comparable>)BlockSkull.NODROP, (lllllllllllllIlIIIlllIIlIlIIIlII & 0x8) > 0);
    }
}
